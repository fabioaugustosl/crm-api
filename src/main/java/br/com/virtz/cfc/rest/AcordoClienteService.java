package br.com.virtz.cfc.rest;

import java.security.InvalidParameterException;
import java.util.Date;
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

import br.com.virtz.cfc.dao.AcordoComClienteDAO;
import br.com.virtz.cfc.dao.AplicacaoDAO;
import br.com.virtz.cfc.dao.ClienteDAO;
import br.com.virtz.cfc.dao.FormaPagamentoDAO;
import br.com.virtz.cfc.dao.ProdutoServicoDAO;
import br.com.virtz.cfc.entidades.AcordoComCliente;
import br.com.virtz.cfc.entidades.Aplicacao;
import br.com.virtz.cfc.entidades.FormaPagamento;
import br.com.virtz.cfc.entidades.Pessoa;
import br.com.virtz.cfc.entidades.ProdutoServico;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/v1/acordo")
public class AcordoClienteService {

	@Inject
	private AcordoComClienteDAO acordoDAO;
	
	@Inject
	private FormaPagamentoDAO formaDAO;
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private AplicacaoDAO appDAO;
	
	@Inject
	private ProdutoServicoDAO psDAO;
	
	
	
	@GET
	@Path("/listarPorClienteApp/{chaveCliente}/{chaveApp}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AcordoComCliente> listarAcordosDoClientePorApp(@PathParam("chaveCliente") String chaveCliente, @PathParam("chaveApp") String chaveApp){
		return acordoDAO.recuperarPorCliente(chaveCliente, chaveApp);
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public AcordoComCliente novoAcordo(Long idFormaPG, String chaveCliente, String chaveApp, String chaveProdutoServico,  
											String chaveLivre, Integer qtdParcelas, Double valor) throws Exception{
		
		if(chaveApp == null || chaveCliente == null || chaveProdutoServico == null){
			throw new InvalidParameterException("Parâmetros obrigatórios não enviados.");
		}
		
		Pessoa pessoa = clienteDAO.recuperarPorChave(chaveCliente);
		
		Aplicacao app = appDAO.recuperarPorChave(chaveApp);
		
		ProdutoServico ps = psDAO.recuperarPorChave(chaveProdutoServico);
		
		FormaPagamento fp = null;
		if(idFormaPG != null){
			fp = formaDAO.recuperarPorId(idFormaPG);
		}
		
		AcordoComCliente acordo = new AcordoComCliente();
		acordo.setAplicacao(app);
		acordo.setChaveLivre(chaveCliente);
		acordo.setCliente(pessoa);
		acordo.setFormaPagamento(fp);
		acordo.setQtdParcelas(qtdParcelas);
		acordo.setValor(valor);
		acordo.setPodutoServico(ps);
		
		return salvar(acordo);
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public AcordoComCliente salvarAcordoComCliente(AcordoComCliente acordo) throws Exception{
		return salvar(acordo);
	}
	
	
	private AcordoComCliente salvar(AcordoComCliente acordo) throws Exception {
		if(acordo == null){
			throw new InvalidParameterException("Aplicação é obrigatória.");
		}
		
		if(acordo.getAplicacao() == null || acordo.getAplicacao().getId() == null){
			throw new InvalidParameterException("Aplicação é obrigatório");
		}
		
		if(acordo.getCliente() == null || acordo.getCliente().getId() == null){
			throw new InvalidParameterException("Cliente é obrigatório");
		}
		
		if(acordo.getPodutoServico() == null || acordo.getPodutoServico().getId() == null){
			throw new InvalidParameterException("Produto ou serviço é obrigatório");
		}
		
		acordo.setDataAcordo(new Date());
				
		return acordoDAO.salvar(acordo);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		if(id == null){
			throw new InvalidParameterException("ID do acordo não recebido.");
		}
		acordoDAO.remover(id);
	}
	
	
}
