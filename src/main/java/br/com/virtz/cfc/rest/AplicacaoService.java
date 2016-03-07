package br.com.virtz.cfc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.virtz.cfc.dao.AplicacaoDAO;
import br.com.virtz.cfc.entidades.Aplicacao;

import com.google.inject.Inject;

@Path("/v1/empresa")
public class AplicacaoService {

	@Inject
	private AplicacaoDAO empresaDAO;
	
	 
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aplicacao getEmpresa(@PathParam("id") Long idEmpresa) throws Exception{
		return empresaDAO.recuperarPorId(idEmpresa);
	}
	
	
		
}
