package br.com.virtz.cfc.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.virtz.cfc.contantes.EnumFormaContato;

@Entity
@Table(name = "contatocliente")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ContatoComCliente.recuperarPorApp", 
			query = "SELECT ct FROM ContatoComCliente ct "
					+ " WHERE ct.aplicacao.id = :idAplicacao"),
	@NamedQuery(name = "ContatoComCliente.recuperarPorChaveApp", 
			query = "SELECT ct FROM ContatoComCliente ct "
					+ " WHERE ct.aplicacao.chave = :chaveAplicacao"),
	@NamedQuery(name = "ContatoComCliente.recuperarPorId", 
			query = "SELECT ct FROM ContatoComCliente ct "
					+ " WHERE ct.id = :idContato")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatoComCliente extends Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idCliente", nullable=false)
	private Pessoa cliente;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idAplicacao", nullable=false)
	private Aplicacao aplicacao;

	@Column(name="dataContato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataContato;
	
	@ManyToOne
	@JoinColumn(name="idProdutoServico", nullable=true)
	private ProdutoServico podutoServico;
	
	@Column(name = "formaContato", nullable = true)
	@Enumerated(EnumType.STRING)
	private EnumFormaContato formaContato;
	
	@Column(name = "descricao", nullable = true)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Date getDataContato() {
		return dataContato;
	}

	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}

	public ProdutoServico getPodutoServico() {
		return podutoServico;
	}

	public void setPodutoServico(ProdutoServico podutoServico) {
		this.podutoServico = podutoServico;
	}

	public EnumFormaContato getFormaContato() {
		return formaContato;
	}

	public void setFormaContato(EnumFormaContato formaContato) {
		this.formaContato = formaContato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
