package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.FormaPagamento;

public class FormaPagamentoDAOImpl extends DAO<FormaPagamento> implements FormaPagamentoDAO {


	@Override
	public List<FormaPagamento> recuperarPorAplicacao(Long idAplicacao) {
		Query qry = getEntityManager().createNamedQuery("FormaPagamento.recuperarPorApp");
		qry.setParameter("idAplicacao", idAplicacao);
		return qry.getResultList();
	}

	
	@Override
	public List<FormaPagamento> recuperarPorChaveAplicacao(String chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("FormaPagamento.recuperarPorChaveApp");
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return qry.getResultList();
	}


	@Override
	public FormaPagamento recuperarPorChave(String chaveFormaPagamento, String chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("FormaPagamento.recuperarPorChave");
		qry.setParameter("chaveFormaPagamento", chaveFormaPagamento);
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return (FormaPagamento) qry.getSingleResult();
	}

	
}
