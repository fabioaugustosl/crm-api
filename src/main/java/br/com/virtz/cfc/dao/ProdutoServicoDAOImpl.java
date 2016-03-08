package br.com.virtz.cfc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.virtz.cfc.entidades.ProdutoServico;

public class ProdutoServicoDAOImpl extends DAO<ProdutoServico> implements ProdutoServicoDAO {

		@Override
	public List<ProdutoServico> recuperarPorAplicacao(Long idAplicacao) {
		Query qry = getEntityManager().createNamedQuery("ProdutoServico.recuperarPorApp");
		qry.setParameter("idAplicacao", idAplicacao);
		return qry.getResultList();
	}
		

	@Override
	public List<ProdutoServico> recuperarPorChaveAplicacao(Long chaveAplicacao) {
		Query qry = getEntityManager().createNamedQuery("ProdutoServico.recuperarPorChaveApp");
		qry.setParameter("chaveAplicacao", chaveAplicacao);
		return qry.getResultList();
	}

	
	@Override
	public ProdutoServico recuperarPorChave(String chaveProdutoServiceo) {
		Query qry = getEntityManager().createNamedQuery("ProdutoServico.recuperarPorChave");
		qry.setParameter("chaveProdutoServiceo", chaveProdutoServiceo);
		List<ProdutoServico> lista = qry.getResultList();
		if(lista != null && !lista.isEmpty()){
			return lista.get(0);
		}
		return null;
	}

}
