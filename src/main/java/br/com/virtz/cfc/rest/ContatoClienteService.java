package br.com.virtz.cfc.rest;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

import br.com.virtz.cfc.contantes.EnumFormaContato;
import br.com.virtz.cfc.dao.AcordoComClienteDAO;
import br.com.virtz.cfc.dao.AplicacaoDAO;
import br.com.virtz.cfc.dao.ClienteDAO;
import br.com.virtz.cfc.dao.ContatoComClienteDAO;
import br.com.virtz.cfc.dao.FormaPagamentoDAO;
import br.com.virtz.cfc.dao.ProdutoServicoDAO;
import br.com.virtz.cfc.entidades.AcordoComCliente;
import br.com.virtz.cfc.entidades.Aplicacao;
import br.com.virtz.cfc.entidades.ContatoComCliente;
import br.com.virtz.cfc.entidades.FormaPagamento;
import br.com.virtz.cfc.entidades.Pessoa;
import br.com.virtz.cfc.entidades.ProdutoServico;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/v1/contato")
public class ContatoClienteService {

	@Inject
	private ContatoComClienteDAO contatoDAO;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private AplicacaoDAO appDAO;
	
	@Inject
	private ProdutoServicoDAO psDAO;
	
	
	
	@GET
	@Path("/listarPorClienteApp/{chaveCliente}/{chaveApp}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContatoComCliente> listarContatosDoClientePorApp(@PathParam("chaveCliente") String chaveCliente, @PathParam("chaveApp") String chaveApp){
		return contatoDAO.recuperarPorChaveClienteEAplicacao(chaveCliente, chaveApp);
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public ContatoComCliente novoContato(String chaveCliente, String chaveApp, String chaveProdutoServico,  
											String descricao, String formaContato) throws Exception{
		
		if(chaveApp == null || chaveCliente == null || chaveProdutoServico == null){
			throw new InvalidParameterException("Parâmetros obrigatórios não enviados.");
		}
		
		Pessoa pessoa = clienteDAO.recuperarPorChave(chaveCliente);
		
		Aplicacao app = appDAO.recuperarPorChave(chaveApp);
		
		ProdutoServico ps = psDAO.recuperarPorChave(chaveProdutoServico);
		
		EnumFormaContato fp = null;
		if(formaContato != null){
			fp = EnumFormaContato.recuperarPorDescricao(formaContato);
		}
		
		ContatoComCliente contato = new ContatoComCliente();
		contato.setAplicacao(app);
		contato.setCliente(pessoa);
		contato.setPodutoServico(ps);
		contato.setDataContato(new Date());
		contato.setFormaContato(fp);
		contato.setDescricao(descricao);
		
		return salvar(contato);
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public ContatoComCliente salvarContatoComCliente(ContatoComCliente contato) throws Exception{
		return salvar(contato);
	}
	
	
	private ContatoComCliente salvar(ContatoComCliente contato) throws Exception {
		if(contato == null){
			throw new InvalidParameterException("Contato é obrigatória.");
		}
		
		if(contato.getAplicacao() == null || contato.getAplicacao().getId() == null){
			throw new InvalidParameterException("Aplicação é obrigatório");
		}
		
		if(contato.getCliente() == null || contato.getCliente().getId() == null){
			throw new InvalidParameterException("Cliente é obrigatório");
		}
		
		if(contato.getPodutoServico() == null || contato.getPodutoServico().getId() == null){
			throw new InvalidParameterException("Produto ou serviço é obrigatório");
		}
				
		return contatoDAO.salvar(contato);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		if(id == null){
			throw new InvalidParameterException("ID do contato não recebido.");
		}
		contatoDAO.remover(id);
	}
	
	
}
