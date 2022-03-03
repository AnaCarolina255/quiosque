package br.senai.sp.cotia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.senai.sp.cotia.model.ClienteForm;
import br.senai.sp.cotia.model.TipoGeneroForm;
import br.senai.sp.cotia.model.TipoProdutoForm;

public class DaoForm {
	private Connection conexao;

	public DaoForm() {
		conexao = ConnectionFactoryForm.conectar();
	}
	
	public void inserir(ClienteForm cliente) {
		String sql = "insert into tabela_cliente(nome, data_nascimento, endereco, celular, email, tipo_genero, tipo_produto) "+"values (?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(3, cliente.getEndereco());
			stmt.setInt(4, cliente.getCelular());
			stmt.setString(5, cliente.getEmail());
			stmt.setInt(6, cliente.getTipoGenero().ordinal());
			stmt.setInt(7, cliente.getTipoProduto().ordinal());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<ClienteForm> listar(){
		String sql = "select * from tabela_cliente order by nome asc";
		List<ClienteForm> lista = new ArrayList<ClienteForm>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ClienteForm p = new ClienteForm();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setCelular(rs.getInt("celular"));
				p.setEmail(rs.getString("email"));
				
				Calendar nascimento = Calendar.getInstance();
				
				Date dataDn = rs.getDate("data_nascimento");
				nascimento.setTimeInMillis(dataDn.getTime());
				
				p.setDataNascimento(nascimento);
				
				int enumPos = rs.getInt("tipo_genero");
				TipoGeneroForm tipoG = TipoGeneroForm.values()[enumPos];
				
				p.setTipoGenero(tipoG);
				
				int posEnum = rs.getInt("tipo_produto");
				TipoProdutoForm tipo = TipoProdutoForm.values()[posEnum];
				
				p.setTipoProduto(tipo);
				lista.add(p);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(long id) {
		String sql = "delete from tabela_cliente where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(ClienteForm cliente) {
		String sql = "update tabela_cliente set nome = ?, data_nascimento = ?, endereco = ?, celular = ?, email = ?, tipo_genero = ?, tipo_produto = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(3, cliente.getEndereco());
			stmt.setInt(4, cliente.getCelular());
			stmt.setString(5, cliente.getEmail());
			stmt.setInt(6, cliente.getTipoGenero().ordinal());
			stmt.setInt(7, cliente.getTipoProduto().ordinal());
			stmt.setLong(8, cliente.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ClienteForm buscar(long idProduto){
		String sql = "select * from tabela_cliente where id = ?";
		ClienteForm p = null;
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idProduto);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				p = new ClienteForm();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setCelular(rs.getInt("celular"));
				p.setEmail(rs.getString("email"));
				
				Calendar nascimento = Calendar.getInstance();
				
				Date dataDn = rs.getDate("data_nascimento");
				nascimento.setTimeInMillis(dataDn.getTime());
				
				p.setDataNascimento(nascimento);
				
				int enumPos = rs.getInt("tipo_genero");
				TipoGeneroForm tipoG = TipoGeneroForm.values()[enumPos];
				
				p.setTipoGenero(tipoG);
				
				int posEnum = rs.getInt("tipo_produto");
				TipoProdutoForm tipo = TipoProdutoForm.values()[posEnum];
				
				p.setTipoProduto(tipo);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
