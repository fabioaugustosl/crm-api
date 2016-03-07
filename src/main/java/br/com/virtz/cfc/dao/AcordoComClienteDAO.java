package br.com.virtz.cfc.dao;

import java.util.List;

import br.com.virtz.cfc.entidades.AcordoComCliente;

import com.google.inject.ImplementedBy;

@ImplementedBy(AcordoComClienteDAOImpl.class)
public interface AcordoComClienteDAO extends CrudDAO<AcordoComCliente>   {

	public List<AcordoComCliente> recuperarPorClientePorId(Long idCliente);
	public List<AcordoComCliente> recuperarPorCliente(String siglaCliente, String siglaAplicacao);
	
}
