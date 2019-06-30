package aula20190628.tratando_exce��es_banco;

import java.util.List;

public interface CorRepository {

	void inserir(Cor c) throws Exception; 
	List<Cor> obterTodas() throws Exception;
	void alterar(Cor c) throws Exception;
	void excluir(int id) throws Exception;

}