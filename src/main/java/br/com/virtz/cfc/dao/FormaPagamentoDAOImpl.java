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

}
