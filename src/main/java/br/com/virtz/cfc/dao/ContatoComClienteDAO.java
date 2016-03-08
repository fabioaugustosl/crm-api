package br.com.virtz.cfc.dao;

import java.util.List;

import br.com.virtz.cfc.entidades.ContatoComCliente;

import com.google.inject.ImplementedBy;

@ImplementedBy(ContatoComClienteDAOImpl.class)
public interface ContatoComClienteDAO extends CrudDAO<ContatoComCliente>   {

	public List<ContatoComCliente> recuperarPorAplicacao(Long idAplicacao);
	public List<ContatoComCliente> recuperarPorChaveAplicacao(Long chaveAplicacao);
	public ContatoComCliente recuperarPorChave(String chaveFormaPagamento);
	
}
