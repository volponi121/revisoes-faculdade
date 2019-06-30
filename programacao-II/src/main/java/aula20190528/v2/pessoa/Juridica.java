package aula20190528.v2.pessoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private Set<CotaSociedade> cotasSociedade = new HashSet<>();

	public Juridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
	}
	public Juridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
	}
	public void adicionarSocio(Pessoa socio, PercentualDeParticipacao percentualDeParticipacao) {
		CotaSociedade novaCota = new CotaSociedade();
		novaCota.socio = socio;
		novaCota.percentualDeParticipacao = percentualDeParticipacao;
		
		double percentualAtual = somarPercentualAtual();
		/*
		if (percentualAtual + percentualDeParticipacao > 100.00) {
			throw new RuntimeException("A participaço total n�o pode exceder 100%! Percentual atual: " + percentualAtual + ". Voc� tentou adicionar mais " + percentualDeParticipacao);
		}
		*/
		
		this.cotasSociedade.add(novaCota);
	}
	private double somarPercentualAtual() {
		double percentualAtual = 0.00d;
		for (CotaSociedade cotaSociedade : cotasSociedade) {
			percentualAtual += cotaSociedade.percentualDeParticipacao.getValor();
		}
		return percentualAtual;
	}
	public Map<Pessoa, PercentualDeParticipacao> getCotasSociedade() {
		Map<Pessoa, PercentualDeParticipacao> cotas = new HashMap<>();
		for (CotaSociedade cota : cotasSociedade) {
			cotas.put(cota.socio, cota.percentualDeParticipacao);
		}
		return cotas;
	}
	public void removerSocio(Pessoa socioParaRemover) {
		Set<CotaSociedade> aux = new HashSet<>();
		for (CotaSociedade cota : cotasSociedade) {
			if (!cota.socio.equals(socioParaRemover)) {
				aux.add(cota);
			}
		}
		this.cotasSociedade = aux;
	}
	public double getCapitalSocial() {
		return capitalSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	private class CotaSociedade {
		private PercentualDeParticipacao percentualDeParticipacao;
		private Pessoa socio;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((socio == null) ? 0 : socio.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CotaSociedade other = (CotaSociedade) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (socio == null) {
				if (other.socio != null)
					return false;
			} else if (!socio.equals(other.socio))
				return false;
			return true;
		}
		private Juridica getOuterType() {
			return Juridica.this;
		}
		
		
		
	}

}
