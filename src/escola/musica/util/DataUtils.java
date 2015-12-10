package escola.musica.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

	public static String obterDataFormatoBanco(Date data, String formato){
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String dataFormatoBanco = sdf.format(data);
		return dataFormatoBanco;
	}
}
