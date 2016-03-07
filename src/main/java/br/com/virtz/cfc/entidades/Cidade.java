package br.com.virtz.cfc.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="cidade")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Cidade.recuperarPorEstado", 
			query = "SELECT c FROM Cidade c WHERE c.estado.id = :idEstado") })
public class Cidade extends Entidade implements Serializable, Comparable<Cidade> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@FormParam("id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name = "estado")
	@FormParam("estado")
	private Estado estado;

	@Column(name = "uf", length = 4, nullable = false)
	@FormParam("uf")
	private String uf;

	@Column(name = "nome", length = 50, nullable = false)
	@FormParam("nome")
	private String nome;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getNomeExibicao(){
		return "["+this.uf+"] "+this.nome;
	}

	@Override
	public int compareTo(Cidade c) {
		if(c == null){
			return 1;
		}
		
		if(this.uf != null && !this.uf.equals(c.getUf())){
			return this.uf.compareTo(c.getUf());
		} 
			
		if(this.nome != null){
			return this.nome.compareTo(c.getNome());
		}
		
		return 0;
	}

}