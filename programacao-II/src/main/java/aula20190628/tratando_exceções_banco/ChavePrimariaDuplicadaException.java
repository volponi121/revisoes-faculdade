package aula20190628.tratando_exce��es_banco;

public class ChavePrimariaDuplicadaException extends RuntimeException {
	
	public ChavePrimariaDuplicadaException(Exception cause) {
		super("Chave duplicada!", cause);
	}

}
