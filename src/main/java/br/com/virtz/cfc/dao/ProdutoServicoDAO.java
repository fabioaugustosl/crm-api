package br.com.virtz.cfc.dao;

import java.util.List;

import br.com.virtz.cfc.entidades.ProdutoServico;

import com.google.inject.ImplementedBy;

@ImplementedBy(ProdutoServicoDAOImpl.class)
public interface ProdutoServicoDAO extends CrudDAO<ProdutoServico>   {

	public List<ProdutoServico> recuperarPorAplicacao(Long idAplicacao);
	public List<ProdutoServico> recuperarPorChaveAplicacao(Long chaveAplicacao);
	public ProdutoServico recuperarPorChave(String chaveProdutoServiceo);
		
}
