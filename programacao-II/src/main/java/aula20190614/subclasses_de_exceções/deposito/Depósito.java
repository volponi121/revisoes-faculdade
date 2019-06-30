package aula20190614.subclasses_de_exce��es.deposito;

public class Dep�sito {

	private final String conta;
	private final double valor;

	public Dep�sito(String conta, double valor) {
		if (valor <= 0.00) {
			throw new ValorDeDep�sitoInv�lidoException("Valor depositado: " + valor);
		}
		this.conta = conta;
		this.valor = valor;
	}
	
	public String getConta() {
		return conta;
	}
	public double getValor() {
		return valor;
	}

}
