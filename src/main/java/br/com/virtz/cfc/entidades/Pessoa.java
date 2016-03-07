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
import javax.persistence.OneToMany;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.ManyToAny;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Pessoa extends Entidade implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(nullable=false, unique=true)
	@FormParam("id")
	private Long id;
	
	@Column(name="nome", length=60, nullable=false)
	@FormParam("nome")
	private String nome;
	
	@Column(name="nomenome", length=100)
	private String sobreNome;
	
	/**
	 * Usado para facilitar a identificação do cliente/pessoas pelo cliente da API. Essa sigla deve ser única por aplicação.
	 */
	@Column(name="sigla", length=20, nullable=false)
	private String sigla;
	
	@Column(name="email", length=150)
	private String email;
	
	@Column(name="emailSecundario", length=150)
	private String emailSecundario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pessoa")
	private List<Telefone> telefones;

	@ManyToOne
	@JoinColumn(name="idEndereco")
	private Endereco endereco;
	
	
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
