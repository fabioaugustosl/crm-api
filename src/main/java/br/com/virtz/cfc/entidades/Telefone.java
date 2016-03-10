package br.com.virtz.cfc.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessorType;

import org.jboss.resteasy.spi.StringConverter;

import br.com.virtz.cfc.contantes.EnumTipoTelefone;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlAccessorType
public class Telefone extends Entidade implements Serializable, StringConverter<Telefone>  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero", length = 20, nullable = false)
	private String numero;

	@Column(name = "tipoTelefone", nullable = true)
	@Enumerated(EnumType.STRING)
	private EnumTipoTelefone tipoTelefone;
	
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;
	
	@Override
	public Long getId() {
		return null;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EnumTipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(EnumTipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Telefone fromString(String str){
		if(str!= null){
			Long id = Long.valueOf(str);
			Telefone e = new Telefone();
			e.setId(id);
			return e;
			
		} 
		return null;
	}

	@Override
	public String toString(Telefone value) {
		if(this.getId()!= null){
			return this.getId().toString();
		}
		return null;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
		
}
