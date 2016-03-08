package br.com.virtz.cfc.dao;

import java.util.List;

import br.com.virtz.cfc.entidades.Pessoa;

import com.google.inject.ImplementedBy;

@ImplementedBy(ClienteDAOImpl.class)
public interface ClienteDAO extends CrudDAO<Pessoa>   {
	
	public Pessoa recuperarPorChave(String chavePessoa);
	public List<Pessoa> recuperarPorEmail(String email);
	public List<Pessoa> recuperarPorAplicacao(String chaveAplicacao);
	public Pessoa recuperarPorChaveEmAplicacao(String chavePessoa, String chaveAplicacao);
		
}
