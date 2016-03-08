package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.Aplicacao;

public class AplicacaoDAOImpl extends DAO<Aplicacao> implements AplicacaoDAO {

	@Override
	public Aplicacao recuperarPorChave(String chave) {
		Query qry = getEntityManager().createNamedQuery("Aplicacao.recuperarPorChave");
		qry.setParameter("chave", chave);
		List<Aplicacao> lista = qry.getResultList();
		if(lista != null && !lista.isEmpty()){
			return lista.get(0);
		}
		return null;
	}

	
}
