package br.com.fiap.hydrovital.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.hydrovital.model.entity.Ong;

public class OngRepository extends Repository{
	
	public static ArrayList<Ong> findAll() {
		ArrayList<Ong> ongs = new ArrayList<Ong>();
		String sql = "select * from ong";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Ong ong = new Ong();
					ong.setNome(rs.getString("nome"));
					ong.setLocalidade(rs.getString("localidade"));
					ong.setTelefone(rs.getString("telefone"));
					ong.setEmail(rs.getString("email"));
					ong.setCnpj(rs.getString("cnpj"));
					ong.setCpf(rs.getString("cpf_usuario"));
					ongs.add(ong);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return ongs;
	}
	
	
	public static Ong save(Ong ongs) {
		String sql = "insert into ong" + "(nome, localidade, telefone, email, cnpj, cpf_usuario)"
				+ " values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, ongs.getNome());
			ps.setString(2, ongs.getLocalidade());
			ps.setString(3, ongs.getTelefone());
			ps.setString(4, ongs.getEmail());
			ps.setString(5, ongs.getCnpj());
			ps.setString(6, ongs.getCpf());
			
			if (ps.executeUpdate() > 0) {
				return ongs;
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
	
	
	public static boolean delete(String id) {
		String sql = "delete from ong where cnpj=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
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
	
	public static Ong update(Ong ongs) {
		String sql = "UPDATE ong " + "SET nome=?, localidade=?, telefone=?, email=?"
				+ "WHERE cnpj=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, ongs.getNome());
			ps.setString(2, ongs.getLocalidade());
			ps.setString(3, ongs.getTelefone());
			ps.setString(4, ongs.getEmail());
			ps.setString(5, ongs.getCnpj());
			
			if (ps.executeUpdate() > 0) {
				return ongs;
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
