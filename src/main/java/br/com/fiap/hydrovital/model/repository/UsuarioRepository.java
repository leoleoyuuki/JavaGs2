package br.com.fiap.hydrovital.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.hydrovital.model.entity.Usuario;

public class UsuarioRepository extends Repository{
	
	public static ArrayList<Usuario> findAll() {
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Usuario user = new Usuario();
					user.setNome(rs.getString("nome_user"));
					user.setTelefone(rs.getString("telefone_user"));
					user.setCpf(rs.getString("cpf_user"));
					user.setEmail(rs.getString("email_user"));
					user.setDataDeNascimento(rs.getString("dt_nascimento"));
					users.add(user);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return users;
	}
	
	
	public static Usuario save(Usuario user) {
		String sql = "insert into usuario" + "(nome_user, telefone_user, cpf_user, email_user, dt_nascimento)"
				+ " values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getTelefone());
			ps.setString(3, user.getCpf());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getDataDeNascimento());
			
			if (ps.executeUpdate() > 0) {
				return user;
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
		String sql = "delete from usuario where cpf_user=?";
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
	
	public static Usuario update(Usuario user) {
		String sql = "UPDATE usuario " + "SET nome_user=?, telefone_user=?, email_user=?, dt_nascimento=?"
				+ "WHERE cpf_user=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getTelefone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getDataDeNascimento());
			ps.setString(5, user.getCpf());

			
			if (ps.executeUpdate() > 0) {
				return user;
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
