package br.com.virtz.cfc.contantes;

public enum EnumFormaContato {
	TELEFONE("Telefone"),
	EMAIL("Email"),
	PESSOALMENTE("Pessoalmente"),
	SMS("Sms"),
	CARTA("Carta"),
	OUTROS("Outros");
	
	private String descricao;

	private EnumFormaContato(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumFormaContato recuperarPorDescricao(String descricao){
		for(EnumFormaContato tv : EnumFormaContato.values()){
			if(tv.getDescricao().equals(descricao)){
				return tv;
			}
		}
		return null;
	}
}
