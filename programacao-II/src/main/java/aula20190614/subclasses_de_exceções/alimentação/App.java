package aula20190614.subclasses_de_exce��es.alimenta��o;

public class App {
	
	public static void main(String[] args) {
		
		Rob� r2d2 = new Rob�();
		
		Boi boi = new Boi();
		Frango frango = new Frango();
		Su�no su�no = new Su�no();
		
		r2d2.alimentar(boi);
		r2d2.alimentar(frango);
		r2d2.alimentar(su�no);

		
		r2d2.alimentar(frango);
		System.out.println("Ok.");

	}

}
