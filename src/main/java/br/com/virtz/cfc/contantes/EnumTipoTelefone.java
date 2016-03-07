package br.com.virtz.cfc.contantes;

public enum EnumTipoTelefone {
	CELULAR("Celular"),
	RESIDENCIAL("Residencial"),
	COMERCIAL("Comercial");
	
	private String descricao;

	private EnumTipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoTelefone recuperarPorDescricao(String descricao){
		for(EnumTipoTelefone tv : EnumTipoTelefone.values()){
			if(tv.getDescricao().equals(descricao)){
				return tv;
			}
		}
		return null;
	}
}
