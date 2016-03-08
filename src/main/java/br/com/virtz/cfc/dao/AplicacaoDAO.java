package br.com.virtz.cfc.dao;

import br.com.virtz.cfc.entidades.Aplicacao;

import com.google.inject.ImplementedBy;

@ImplementedBy(AplicacaoDAOImpl.class)
public interface AplicacaoDAO extends CrudDAO<Aplicacao>   {

	public Aplicacao recuperarPorChave(String chave);
	
}
