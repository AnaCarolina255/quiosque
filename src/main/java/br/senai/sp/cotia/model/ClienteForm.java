package br.senai.sp.cotia.model;


import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import br.senai.sp.cotia.dao.DaoForm;

public class ClienteForm {

	private Long id;
	private String nome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNascimento;
	private String endereco;
	private int celular;
	private String email;
	private TipoProdutoForm tipoProduto;
	private TipoGeneroForm tipoGenero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataCadastro;
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public TipoGeneroForm getTipoGenero() {
		return tipoGenero;
	}
	public void setTipoGenero(TipoGeneroForm tipoGenero) {
		this.tipoGenero = tipoGenero;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TipoProdutoForm getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(TipoProdutoForm tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	public int getIdade() {
		int dia = dataNascimento.get(Calendar.DAY_OF_MONTH);
		int mes = dataNascimento.get(Calendar.MONTH);
		int ano = dataNascimento.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes + 1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
	/*	
	Calendar calendario = Calendar.getInstance();
	
	public int contData(ClienteForm cliente) {
	
		int anoAt = calendario.get(Calendar.YEAR);
		int anoC = cliente.getDataNascimento().get(Calendar.YEAR);
		int idadeC = anoAt - anoC;*/
		
		
	}
}
