package br.com.virtz.cfc.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="formapagamento")
@NamedQueries({
	@NamedQuery(name = "FormaPagamento.recuperarPorApp", 
			query = "SELECT fp FROM FormaPagamento fp "
					+ " WHERE fp.aplicacao.id = :idAplicacao"),
	@NamedQuery(name = "FormaPagamento.recuperarPorChaveApp", 
			query = "SELECT fp FROM FormaPagamento fp "
					+ " WHERE fp.aplicacao.chave = :chaveAplicacao"),
	@NamedQuery(name = "FormaPagamento.recuperarPorId", 
			query = "SELECT fp FROM FormaPagamento fp "
					+ " WHERE fp.id = :idFormaPagamento"),
	@NamedQuery(name = "FormaPagamento.recuperarPorChave", 
			query = "SELECT fp FROM FormaPagamento fp "
					+ " JOIN fp.aplicacao ap "
					+ " WHERE fp.chave = :chaveFormaPagamento AND ap.chave = :chaveAplicacao")
})
@XmlRootElement
public class FormaPagamento extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "ativo")
	private Boolean ativo;
	
	/**
	 * Usado para facilitar a identificação da forma de pagamento pelo cliente da API. Essa sigla deve ser única por aplicação.
	 */
	@Column(name="chave", length=20, nullable=false)
	private String chave;
	
	@ManyToOne
	@JoinColumn(name="idAplicacao", nullable=false)
	private Aplicacao aplicacao;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
