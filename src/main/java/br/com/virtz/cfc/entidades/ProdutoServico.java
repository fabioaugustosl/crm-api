package br.com.virtz.cfc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="produtoservico")
@XmlRootElement
public class ProdutoServico extends Entidade {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
	private Long id;
	
	@Column(name="descricao", length=100, nullable=false)
	private String descricao;
	
	/**
	 * Usado para facilitar a identificação do produto/serviço pelo cliente da API. Essa sigla deve ser única por aplicação.
	 */
	@Column(name="sigla", length=20, nullable=false)
	private String sigla;
	
	@ManyToOne(fetch= FetchType.EAGER)
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

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
