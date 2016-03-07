package br.com.virtz.cfc.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlType;

import org.jboss.resteasy.spi.StringConverter;

@Entity
@Table(name="endereco")
@XmlType
public class Endereco extends Entidade implements Serializable, StringConverter<Endereco>{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
	@FormParam("id")
	private Long id;
	
	@Column(name="logradouro", length=60, nullable=false)
	@FormParam("logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	@FormParam("numero")
	private Integer numero;

	@Column(name = "complemento", length = 100)
	@FormParam("complemento")
	private String complemento;

	@Column(name = "bairro", length = 100)
	@FormParam("bairro")
	private String bairro;

	@Column(name = "cep", length = 20)
	@FormParam("cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "idCidade")
	@FormParam("cidade")
	private Cidade cidade;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public Endereco fromString(String str){
		if(str!= null){
			Long id = Long.valueOf(str);
			Endereco e = new Endereco();
			e.setId(id);
			return e;
			
		} 
		return null;
	}

	@Override
	public String toString(Endereco value) {
		if(this.getId()!= null){
			return this.getId().toString();
		}
		return null;
	}
	
	
	
}
