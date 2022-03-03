package br.senai.sp.cotia.model;

public enum TipoProdutoForm {
	PERFUMES("Perfumes"),
	CREMES("Cremes"),
	MAQUIAGENS("Maquiagens");
	
	String desc;
	
	private TipoProdutoForm(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}
}
