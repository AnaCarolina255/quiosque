package br.senai.sp.cotia.model;

public enum TipoGeneroForm {
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	OUTROS("Outros");
	
	String desc;
	
	private TipoGeneroForm(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}
}


