package br.com.virtz.cfc.rest;

import java.security.InvalidParameterException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.virtz.cfc.dao.AplicacaoDAO;
import br.com.virtz.cfc.entidades.Aplicacao;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/v1/aplicacao")
public class AplicacaoService {

	@Inject
	private AplicacaoDAO aplicacaoDAO;
	
	 
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aplicacao getAplicacao(@PathParam("id") Long idAplicacao) throws Exception{
		return aplicacaoDAO.recuperarPorId(idAplicacao);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Aplicacao novaAplicacao(String nome, String chave, String email, String site) throws Exception{
		Aplicacao aplicacao = new Aplicacao();
		aplicacao.setEmail(email);
		aplicacao.setNome(nome);
		aplicacao.setSite(site);
		aplicacao.setChave(chave);
		return salvar(aplicacao);
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Aplicacao salvarAplicacao(Aplicacao aplicacao) throws Exception{
		return salvar(aplicacao);
	}
	
	
	private Aplicacao salvar(Aplicacao aplicacao) throws Exception {
		if(aplicacao == null){
			throw new InvalidParameterException("Aplicação é obrigatória.");
		}
		
		if(aplicacao.getNome() == null){
			throw new InvalidParameterException("Nome da aplicação é obrigatório");
		}
				
		return aplicacaoDAO.salvar(aplicacao);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		if(id == null){
			throw new InvalidParameterException("ID da aplicação não recebido.");
		}
		aplicacaoDAO.remover(id);
	}
		
}
