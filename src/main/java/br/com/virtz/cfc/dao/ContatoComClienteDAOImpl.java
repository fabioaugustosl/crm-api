package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.ContatoComCliente;

public class ContatoComClienteDAOImpl extends DAO<ContatoComCliente> implements ContatoComClienteDAO {

	
	@Override
	public List<ContatoComCliente> recuperarPorAplicacao(Long idAplicacao) {
		Query qry = getEntityManager().createNamedQuery("ContatoComCliente.recuperarPorApp");
		qry.setParameter("idAplicacao", idAplicacao);
		return qry.getResultList();
	}

	@Override
	public List<ContatoComCliente> recuperarPorChaveAplicacao(Long chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("ContatoComCliente.recuperarPorChaveApp");
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return qry.getResultList();
	}

		
}
