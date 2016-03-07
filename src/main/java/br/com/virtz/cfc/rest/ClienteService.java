package br.com.virtz.cfc.rest;

import javax.ws.rs.Path;

@Path("/v1/cliente")
public class ClienteService {

/*	@Inject
	private Pessoa*/
	
	/*@Inject
	private AplicacaoDAO appDAO;
	
	@Inject
	private AcordoComClienteDAO acordoDAO;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PessoaCliente> getClientes(){
		return pessoaDAO.recuperarTodos();
	}
	
	@GET
	@Path("/emp/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PessoaCliente> getClientesPorEmpresa(@PathParam("id") Long idEmpresa){
		return pessoaDAO.recuperarPorEmpresa(idEmpresa);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PessoaCliente getCliente(@PathParam("id") Long id){
		return pessoaDAO.recuperarPorId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public PessoaCliente criarCliente(PessoaCliente cliente, @QueryParam("idEmpresa") Long idEmpresa) throws Exception{
		if(idEmpresa == null){
			throw new Exception("id da empresa obrigatorio");
		}
		
		Aplicacao emp = appDAO.recuperarPorId(idEmpresa);
		
		if(emp == null){
			throw new Exception("Empresa não existente");
		}
		cliente.setEmpresa(emp);
		return pessoaDAO.salvar(cliente);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void atualizarCliente(PessoaCliente cliente) throws Exception {
		pessoaDAO.salvar(cliente);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		pessoaDAO.remover(id);
	}*/
	
	
	/*// ACORDOS
	//*************************************************************
	
	@POST
	@Path("/acordo")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public AcordoComCliente novoAcordo(
							@Form AcordoComCliente acordo) throws Exception{
		AcordoComCliente a = acordoDAO.salvar(acordo);
		return a;
	}
	
	@PUT
	@Path("/acordo")
	@Consumes("application/x-www-form-urlencoded")
	public void atualizarAcordo(
							@Form AcordoComCliente acordo) throws Exception{
		acordoDAO.salvar(acordo);
	}
	
	@GET
	@Path("/acordo/{idCliente/{idOrcamento}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AcordoComCliente> getAcordosPorClienteEOrcamento(@PathParam("idCliente") Long idCliente,
																@PathParam("idOrcamento") Long idOrcamento){
		return acordoDAO.recuperarPorClientePorOrcamento(idCliente, idOrcamento);
	}
	
	@DELETE
	@Path("/acordo/{id}")
	public void deletarAcordo(@PathParam("id") Long id){
		acordoDAO.remover(id);
	}*/
	
	
}
