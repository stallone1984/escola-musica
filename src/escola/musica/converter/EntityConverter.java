package escola.musica.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.beanutils.BeanUtils;

public class EntityConverter<T> implements Converter {
	
	private Class<T> targetClass;
	
	public EntityConverter(Class<T> targetClass){
		this.targetClass = targetClass;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String texto) {
		T object = null;
		if(texto.equals("")){
			return null;
		}
		try {
			object = targetClass.newInstance();
			BeanUtils.setProperty(object, "id", Integer.parseInt(texto));
			return object;
		} catch (NumberFormatException e){
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		try {
			if(object == null || object.equals("")){
				return "";
			}
			Object value = BeanUtils.getProperty(object, "id");
			return value == null ? null : value.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
}
