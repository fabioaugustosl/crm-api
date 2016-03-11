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
import br.com.virtz.cfc.dao.FormaPagamentoDAO;
import br.com.virtz.cfc.entidades.Aplicacao;
import br.com.virtz.cfc.entidades.FormaPagamento;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/v1/fpg")
public class FormaPagamentoService {

	@Inject
	private FormaPagamentoDAO formaDAO;
	
	@Inject
	private AplicacaoDAO appDAO;
	

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FormaPagamento getFormaPagamento(@PathParam("id") Long idFormaPG) throws Exception{
		return formaDAO.recuperarPorId(idFormaPG);
	}
	
	
	@GET
	@Path("/listarPorIdApp/{idApp}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FormaPagamento> listarFormasPG(@PathParam("idApp") Long idApp){
		return formaDAO.recuperarPorAplicacao(idApp);
	}
	
	@GET
	@Path("/listarPorChaveApp/{chaveApp}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FormaPagamento> listarFormasPG(@PathParam("chaveApp") String chaveApp){
		return formaDAO.recuperarPorChaveAplicacao(chaveApp);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public FormaPagamento novaFPG(String descricao, Long idAplicacao) throws Exception{
		if(idAplicacao == null){
			throw new InvalidParameterException("A aplicação da forma de pagamento é obrigatória");
		}
		Aplicacao ap = appDAO.recuperarPorId(idAplicacao);
		
		FormaPagamento fpg = new FormaPagamento();
		fpg.setDescricao(descricao);
		fpg.setAplicacao(ap);
		
		return salvar(fpg);
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public FormaPagamento salvarForma(FormaPagamento forma) throws Exception{
		return salvar(forma);
	}
	
	
	private FormaPagamento salvar(FormaPagamento formaPG) throws Exception {
		if(formaPG == null){
			throw new InvalidParameterException("Forma de pagamento é obrigatória.");
		}
		
		if(formaPG.getAplicacao() == null || formaPG.getAplicacao().getId() == null){
			throw new InvalidParameterException("A aplicação da forma de pagamento é obrigatória");
		}
		
		if(formaPG.getDescricao() == null){
			throw new InvalidParameterException("Descrição da forma de pagamento é obrigatório");
		}
				
		return formaDAO.salvar(formaPG);
	}
	
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletar(@PathParam("id") Long id){
		if(id == null){
			throw new InvalidParameterException("ID da forma de pagamento não recebido.");
		}
		formaDAO.remover(id);
	}
		
}
