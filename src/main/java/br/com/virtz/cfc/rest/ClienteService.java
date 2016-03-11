package br.com.virtz.cfc.rest;

import java.security.InvalidParameterException;
import java.util.List;

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
import br.com.virtz.cfc.dao.ClienteDAO;
import br.com.virtz.cfc.entidades.Aplicacao;
import br.com.virtz.cfc.entidades.Pessoa;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/v1/cliente")
public class ClienteService {

	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private AplicacaoDAO appDAO;
	
	
	@GET
	@Path("/listarPorApp/{chaveApp}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getClientesPorAplicacao(@PathParam("chaveApp") String chaveApp){
		return clienteDAO.recuperarPorAplicacao(chaveApp);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa getCliente(@PathParam("id") Long id){
		return clienteDAO.recuperarPorId(id);
	}
	

	@GET
	@Path("/recPorChave/{chaveCliente/{chaveApp}}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa getClientePorChave(@PathParam("chaveCliente") String chave, @PathParam("chaveApp") String chaveApp){
		return clienteDAO.recuperarPorChaveEmAplicacao(chave, chaveApp);
	}
	
	
	@GET
	@Path("/recPorEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getClientePorEmail(@PathParam("email") String email){
		return clienteDAO.recuperarPorEmail(email);
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Pessoa criarCliente(String nome, String sobrenome, String email, String chave, String chaveApp) throws Exception{
		if(chaveApp == null){
			throw new Exception("Chave da aplicação é obrigatoria.");
		}
		
		
		Aplicacao app = appDAO.recuperarPorChave(chaveApp);

		Pessoa pessoa = new Pessoa();
		pessoa.setAplicacao(app);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setSobreNome(sobrenome);
		pessoa.setChave(chave);
		
		return salvar(pessoa);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Pessoa atualizarCliente(Pessoa cliente) throws Exception {
		return salvar(cliente);
	}
	
	private Pessoa salvar(Pessoa pessoa) throws Exception {
		if(pessoa == null){
			throw new InvalidParameterException("Pessoa é obrigatória.");
		}
		
		if(pessoa.getNome() == null){
			throw new InvalidParameterException("Nome do cliente é obrigatório");
		}
		
		if(pessoa.getAplicacao() == null || pessoa.getAplicacao().getId() == null){
			throw new InvalidParameterException("A aplicação do cliente é obrigatório");
		}
				
		return clienteDAO.salvar(pessoa);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		if(id == null){
			throw new InvalidParameterException("ID do cliente não recebido.");
		}
		clienteDAO.remover(id);
	}
	
	
	
}
