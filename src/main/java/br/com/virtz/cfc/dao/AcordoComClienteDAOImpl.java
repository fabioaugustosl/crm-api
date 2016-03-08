package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.AcordoComCliente;

public class AcordoComClienteDAOImpl extends DAO<AcordoComCliente> implements AcordoComClienteDAO {

	
	@Override
	public List<AcordoComCliente> recuperarPorClientePorId(Long idCliente) {
		Query qry = getEntityManager().createNamedQuery("AcordoComCliente.recuperarPorCliente");
		qry.setParameter("idCliente", idCliente);
		return qry.getResultList();
	}

	@Override
	public List<AcordoComCliente> recuperarPorCliente(String siglaCliente, String chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("AcordoComCliente.recuperarPorChaveApp");
		qry.setParameter("siglaCliente", siglaCliente);
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return qry.getResultList();
	}

}
