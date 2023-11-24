package br.com.fiap.hydrovital.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.hydrovital.model.entity.Agua;

public class AguaRepository extends Repository{

	public static ArrayList<Agua> findAll() {
		ArrayList<Agua> aguas = new ArrayList<Agua>();
		String sql = "select * from agua";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Agua agua = new Agua();
					agua.setId(rs.getLong("id_agua"));
					agua.setQualidade(rs.getString("qualidade"));
					agua.setQuantidadeAgua(rs.getString("quantidade_agua"));
					agua.setQuantidadeProd(rs.getString("quantidade_prod"));
					agua.setQuantidadePessoa(rs.getString("quantidade_pessoa"));
					agua.setCnpj(rs.getString("cnpj_ong"));
					aguas.add(agua);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return aguas;
	}
	
	
	public static Agua save(Agua agua) {
		String sql = "insert into agua" + "(qualidade,quantidade_agua,quantidade_prod,quantidade_pessoa,cnpj_ong)"
				+ " values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, agua.getQualidade());
			ps.setString(2, agua.getQuantidadeAgua());
			ps.setString(3, agua.getQuantidadeProd());
			ps.setString(4, agua.getQuantidadePessoa());
			ps.setString(5, agua.getCnpj());
			
			if (ps.executeUpdate() > 0) {
				return agua;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	public static boolean delete(Long id) {
		String sql = "delete from agua where id_agua=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
	
	public static Agua update(Agua agua) {
		String sql = "UPDATE agua " + "SET qualidade=?, quantidade_agua=?, quantidade_prod=?, quantidade_pessoa=?"
				+ "WHERE id_agua=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, agua.getQualidade());
			ps.setString(2, agua.getQuantidadeAgua());
			ps.setString(3, agua.getQuantidadeProd());
			ps.setString(4, agua.getQuantidadePessoa());
			ps.setLong(5, agua.getId());

			
			if (ps.executeUpdate() > 0) {
				return agua;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
}
