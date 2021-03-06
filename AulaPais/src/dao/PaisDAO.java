package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {

	private Connection conexao;
	
	public PaisDAO (Connection conexao) {
		this.conexao = conexao;
	}
	
	public PaisDAO() {
		// TODO Auto-generated constructor stub
	}

	public long insert (Pais pais) {
		String inserir = "INSERT INTO Paises (id, nome, area_total, populacao)" + "VALUES(?,?,?,?)";
		
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			pst.setInt(1, pais.getId());
			pst.setString(2, pais.getNome());
			pst.setDouble(3, pais.getArea());
			pst.setLong(4, pais.getPopulacao());
			
			pst.execute();
			
			System.out.println("Pais Cadastrado!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao cadastrar o Pais");
		}
		return pais.getId();	
		}
	
	//SELECT
	public Pais selectPais (int id) {
		
		String consulta = "SELECT id, nome, populacao, area_total FROM pais WHERE id = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			Pais pais = null;
			
			if(resultado.next()) {
				pais = new Pais();
				
				int idPais = resultado.getInt("id");
				String nome = resultado.getString("nome");
				long populacao = resultado.getLong("populacao");
				double area = resultado.getDouble("area_total");
				
				//Atribuição
				pais.setId(idPais);
				pais.setNome(nome);
				pais.setPopulacao(populacao);
				pais.setArea(area);
				
				return pais;
			}
			System.out.println("Consulta feita com sucesso");
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		return null;
	}
	
	//DELETE
	public void delete (String pais) {
		String deleta = "DELETE FROM pais WHERE nome = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deleta)){
			pst.setString(1, pais);
			pst.execute();
			
			System.out.println("Pais excluido");
			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Falha ao excluir o Pais");
		}
	}
	
	public void upDateNomePais (String pais, int id) {		
		String update = "UPDATE pais SET nome = ? WHERE id = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(update)){
			pst.setString(1, pais);
			pst.setInt(2, id);
			pst.execute();
				
			System.out.println("Atualizado com sucesso!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao atualizar");
		}
	}	
	
	
	public ArrayList<Pais> listarPais() {
		Pais pais;
		ArrayList<Pais> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getInt("email"));
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	
	public ArrayList<Pais> listarPais(String chave) {
		Pais pais;
		ArrayList<Pais> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getInt("area"));
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	
}
