package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.Pessoa;

public class ClienteDAOImpl extends DAO<Pessoa> implements ClienteDAO {

	
	@Override
	public Pessoa recuperarPorChave(String chavePessoa) {
		Query qry = getEntityManager().createNamedQuery("Pessoa.recuperarPorChave");
		qry.setParameter("chave", chavePessoa);
		List<Pessoa> lista = qry.getResultList();
		if(lista != null && !lista.isEmpty()){
			return lista.get(0);
		}
		return null;
	}
	

	@Override
	public List<Pessoa> recuperarPorEmail(String email) {
		Query qry = getEntityManager().createNamedQuery("Pessoa.recuperarPorEmail");
		qry.setParameter("email", email);
		return qry.getResultList();
	}

	
	@Override
	public List<Pessoa> recuperarPorAplicacao(String chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("Pessoa.recuperarPorChaveApp");
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return qry.getResultList();
	}

	
	@Override
	public Pessoa recuperarPorChaveEmAplicacao(String chavePessoa, String chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("Pessoa.recuperarClientePorChaveEApp");
		qry.setParameter("chaveCliente", chavePessoa);
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		List<Pessoa> lista = qry.getResultList();
		if(lista != null && !lista.isEmpty()){
			return lista.get(0);
		}
		return null;
	}
	

}
