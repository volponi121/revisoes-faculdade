package aula20190611.repository_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class App {
	
	
	
	public static void main(String[] args) throws Exception {
		Cor verde = new Cor(1, "Verde");
		Cor rosa = new Cor(2, "Rosa");
		
		/*
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/3esoft2019",
				"postgres",
				"unicesumar");

		CorRepository repo = new CorRepositoryJDBC(conn); //usar a conex�o para persistir os dados.
		CorRepository repo = new CorRepositoryMem�ria(); //manter  os dados em uma cole��o.
		CorRepository repo = null;
		*/
		CorRepository repo = criarCorRepositoryAleatoriamente();
		System.out.println("Utilizando repo: " + repo.getClass().getName());
		
		repo.inserir(verde);
		repo.inserir(rosa);
		repo.inserir(new Cor(3, "Azul"));	
		repo.inserir(new Cor(4, "Lil�s"));
		
		
		verde = new Cor(1, "Verde Musgo");
		repo.alterar(verde);
		
		repo.excluir(rosa.getId());

		List<Cor> cores = repo.obterTodas();
		
		System.out.println("Listando as cores...");
		for (Cor cor : cores) {
			System.out.println("  " + cor.getNome());
		}
		System.out.println("Fim da listagem.");
		
	}
	
	private static CorRepository criarCorRepositoryAleatoriamente() throws Exception {
		boolean ehPar = System.currentTimeMillis()%2 == 0;
		if (ehPar) {
			return new CorRepositoryMem�ria();
		} else {
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/3esoft2019",
					"postgres",
					"unicesumar");
			return new CorRepositoryJDBC(conn); //usar a conex�o para persistir os dados.
		}
	}

}
