package br.com.virtz.cfc.dao;

import java.util.List;

import br.com.virtz.cfc.entidades.FormaPagamento;

import com.google.inject.ImplementedBy;

@ImplementedBy(FormaPagamentoDAOImpl.class)
public interface FormaPagamentoDAO extends CrudDAO<FormaPagamento>   {

	public List<FormaPagamento> recuperarPorAplicacao(Long idAplicacao);
	public List<FormaPagamento> recuperarPorChaveAplicacao(String chaveAplicacao);
	public FormaPagamento recuperarPorId(Long idFormaPagamento);
	
}
