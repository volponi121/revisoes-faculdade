package aula20190614.subclasses_de_exce��es.alimenta��o;

public class Animal {
	private boolean buchoCheio = false;

	public void comer() {
		if (this.buchoCheio) {
			throw new BuchoCheioExeption();
		}
		this.buchoCheio = true;
	}

	public boolean estahComBuchoCheio() {
		return this.buchoCheio;
	}

}
