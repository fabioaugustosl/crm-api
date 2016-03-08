package br.com.virtz.cfc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="produtoservico")
@NamedQueries({
	@NamedQuery(name = "ProdutoServico.recuperarPorApp", 
			query = "SELECT fp FROM ProdutoServico fp "
					+ " WHERE fp.aplicacao.id = :idAplicacao"),
	@NamedQuery(name = "ProdutoServico.recuperarPorChaveApp", 
			query = "SELECT fp FROM ProdutoServico fp "
					+ " WHERE fp.aplicacao.chave = :chaveAplicacao"),
	@NamedQuery(name = "ProdutoServico.recuperarPorChave", 
			query = "SELECT fp FROM ProdutoServico fp "
					+ " WHERE fp.chave = :chaveProdutoServico"),
})
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
	@Column(name="chave", length=20, nullable=false)
	private String chave;
	
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

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
}
