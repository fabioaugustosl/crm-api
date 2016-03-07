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

import org.jboss.resteasy.spi.StringConverter;

@Entity
@Table(name="formapagamento")
@NamedQueries({
	@NamedQuery(name = "FormaPagamento.recuperarPorApp", 
			query = "SELECT fp FROM FormaPagamento fp "
					+ " WHERE fp.aplicacao.id = :idAplicacao") 
})
@XmlRootElement
public class FormaPagamento extends Entidade implements Serializable, StringConverter<FormaPagamento> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "ativo")
	private Boolean ativo;
	
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

	@Override
	public FormaPagamento fromString(String str){
		if(str!= null){
			Long id = Long.valueOf(str);
			FormaPagamento e = new FormaPagamento();
			e.setId(id);
			return e;
			
		} 
		return null;
	}

	@Override
	public String toString(FormaPagamento value) {
		if(this.getId()!= null){
			return this.getId().toString();
		}
		return null;
	}
		
}
