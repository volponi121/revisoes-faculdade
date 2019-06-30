package aula20190619.tipos_de_exce��es;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		Prensa p1 = new Prensa();		
		try {
			p1.conectarRedeEl�trica();
			System.out.println("Conectado � rede el�trica! :D");			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar � rede el�trica: " + e.getMessage());
			System.out.println("Aborted.");
			//e.printStackTrace();
			//throw new RuntimeException(e);
		} finally {
			p1.desligar();
		}
		System.out.println("Fim.");
		
	}

}
