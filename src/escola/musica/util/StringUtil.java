package escola.musica.util;

public class StringUtil {

	public static String preencherZerosAEsquerda(String valor, int quantidade){
		int zerosNecessarios = quantidade - valor.length();
		for(int i = 0; i < zerosNecessarios; i++){
			valor = "0" + valor;
		}
		
		return valor;
	}
}
