package br.com.virtz.cfc.contantes;

public enum EnumParametroSistema {

	VALIDADE_PADRAO_ORCAMENTO(1l, "Período padrão em dias da validade do orçamento.");
	
	private String descricao;
	private Long idParamentro;

	private EnumParametroSistema(Long idParamentro, String descricao) {
		this.idParamentro = idParamentro;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Long getIdParametro(){
		return idParamentro;
	}

	public static EnumParametroSistema recuperarPorDescricao(String descricao){
		for(EnumParametroSistema tv : EnumParametroSistema.values()){
			if(tv.getDescricao().equals(descricao)){
				return tv;
			}
		}
		return null;
	}
	
	public static EnumParametroSistema recuperarPorId(Long id){
		for(EnumParametroSistema tv : EnumParametroSistema.values()){
			if(tv.getIdParametro().equals( id)){
				return tv;
			}
		}
		return null;
	}
	
}
