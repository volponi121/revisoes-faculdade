package aula20190614.subclasses_de_exce��es;

public class App {
	
	public static void main(String[] args) {
		
		gerarExce��o();
		
	}
	
	public static void gerarExce��o() {
		//RuntimeException umaExce��o = new RuntimeException("Ulha!");
		RuntimeException umaExce��o = new UlhaException();
		
		throw umaExce��o;		
	}

}
