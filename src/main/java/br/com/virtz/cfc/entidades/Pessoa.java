package br.com.virtz.cfc.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "Pessoa.recuperarPorChave", 
			query = "SELECT cli FROM Pessoa cli "
					+ " WHERE cli.chave = :chave"),
	@NamedQuery(name = "Pessoa.recuperarPorEmail", 
			query = "SELECT cli FROM Pessoa cli "
					+ " WHERE cli.email = :email"),
	@NamedQuery(name = "Pessoa.recuperarPorChaveApp", 
			query = "SELECT cli FROM Pessoa cli "
					+ " JOIN cli.aplicacao ap "
					+ " WHERE  ap.chave = :chaveAplicacao "
					+ " ORDER BY cli.id DESC "),
	@NamedQuery(name = "Pessoa.recuperarClientePorChaveEApp", 
			query = "SELECT cli FROM Pessoa cli "
					+ " JOIN cli.aplicacao ap "
					+ " WHERE cli.chave = :chaveCliente AND ap.chave = :chaveAplicacao ")
})
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoa extends Entidade implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(nullable=false, unique=true)
	private Long id;
	
	@Column(name="nome", length=60, nullable=false)
	private String nome;
	
	@Column(name="nomenome", length=100)
	private String sobreNome;
	
	/**
	 * Usado para facilitar a identificação do cliente/pessoas pelo cliente da API. Essa sigla deve ser única por aplicação.
	 */
	@Column(name="chave", length=20, nullable=false)
	private String chave;
	
	@Column(name="email", length=150)
	private String email;
	
	@Column(name="emailSecundario", length=150)
	private String emailSecundario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pessoa")
	private List<Telefone> telefones;

	@ManyToOne
	@JoinColumn(name="idEndereco")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="idAplicacao")
	private Aplicacao aplicacao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}
	
	
}
