package br.com.virtz.cfc.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="empresa")
@XmlRootElement
public class Aplicacao extends Entidade {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
	@FormParam("id")
	private Long id;
	
	@Column(name="nome", length=60, nullable=false)
	@FormParam("nome")
	private String nome;
	
	@Column(name="email", length=150)
	@FormParam("email")
	private String email;
	
	@Column(name="site", length=150)
	@FormParam("site")
	private String site;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}
