package aula20190614.subclasses_de_exce��es.deposito;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {

		boolean usuarioQuerContinuar = true;
		while (usuarioQuerContinuar) {
			try {
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));			
				Dep�sito d1 = new Dep�sito("1033-4", valor);
				System.out.println("Foi.");
			} catch (Exception exce��oCapturada) {
				System.out.println("Erro: " + exce��oCapturada.getMessage());
				usuarioQuerContinuar = JOptionPane.showConfirmDialog(null, "Valor inv�lido, deseja continuar?","Confirme", JOptionPane.YES_NO_OPTION) == 0;
			}
		}
		System.out.println("Fim.");
		
		
	}

}
