package br.com.virtz.cfc.entidades;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parametrosistema")
public class ParametroSistema extends Entidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valor", nullable = false)
	private String valor;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa", nullable=false)
	private Aplicacao empresa;
	

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Aplicacao getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Aplicacao empresa) {
		this.empresa = empresa;
	}
	

}
