package br.com.virtz.cfc.entidades;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "acordocliente")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "AcordoComCliente.recuperarPorCliente", 
			query = "SELECT cli FROM AcordoComCliente cli "
					+ " WHERE cli.cliente.id = :idCliente ORDER BY cli.id DESC"),
	@NamedQuery(name = "AcordoComCliente.recuperarPorChaveApp", 
			query = "SELECT ac FROM AcordoComCliente ac "
					+ " JOIN ac.cliente cli"
					+ " JOIN ac.aplicacao ap "
					+ " WHERE cli.sigla = :siglaCliente AND ap.sigla = :siglaAplicacao "
					+ " ORDER BY ac.id DESC ")
})
public class AcordoComCliente extends Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long id;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idFormaPagamento", nullable=false)
	private FormaPagamento formaPagamento;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idCliente", nullable=false)
	private Pessoa cliente;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idAplicacao", nullable=false)
	private Aplicacao aplicacao;
	
	@Column(name="chaveLivre")
	private String chaveLivre;
	
	@Column(name="qtdParcelas")
	private Integer qtdParcelas;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="dataAcordo")
	@Temporal(TemporalType.DATE)
	private Date dataAcordo;
	
	@ManyToOne
	@JoinColumn(name="idProdutoServico", nullable=true)
	private ProdutoServico podutoServico;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getChaveLivre() {
		return chaveLivre;
	}

	public void setChaveLivre(String chaveLivre) {
		this.chaveLivre = chaveLivre;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Date getDataAcordo() {
		return dataAcordo;
	}

	public void setDataAcordo(Date dataAcordo) {
		this.dataAcordo = dataAcordo;
	}

	public ProdutoServico getPodutoServico() {
		return podutoServico;
	}

	public void setPodutoServico(ProdutoServico podutoServico) {
		this.podutoServico = podutoServico;
	}
	
	
}
