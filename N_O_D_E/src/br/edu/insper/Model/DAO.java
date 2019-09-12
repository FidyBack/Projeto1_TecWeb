package br.edu.insper.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/dados_node", "FIDY_BACK", "ikja.o");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkUserInSystem(User user) {
		boolean confirm = false;
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM users WHERE nome=?");
			stmt.setString(1,user.getNome());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				confirm = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirm;
	}
	
	public void adicionaUser(User user) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO users" + 
					"(nome,senha) values(?,?)");
			stmt.setString(1,user.getNome());
			stmt.setString(2,user.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(User user) {
		boolean confirm = false;
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM users WHERE nome=? AND senha=?");
			stmt.setString(1,user.getNome());
			stmt.setString(2,user.getSenha());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				confirm = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirm;
	}
	
	public User getUser(String name) {
		User user = new User();
		PreparedStatement stmt;
		try {
			stmt = connection.
			prepareStatement("SELECT * FROM users WHERE name=?");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List<Project> getProjects() {
		List<Project> Projects = new ArrayList<Project>();
		PreparedStatement stmt;
		try {
			stmt = connection.
			prepareStatement("SELECT * FROM projects");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				project.setNome(rs.getString("nome"));
				project.setId_user(rs.getInt("id_user")); // ALGO AS ER MUDADO PLMDDDDDS
				project.setUsername(rs.getString("username"));
				Projects.add(project);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Projects;
	}
	
	public void adicionaProject(Project project) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("INSERT INTO projects" + 
					"(nome,id_user,username) values(?,?,?)");
			stmt.setString(1,project.getNome());
			stmt.setLong(2,project.getId_user());
			stmt.setString(3,project.getUsername());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkProjectInSystem(Project project) {
		boolean confirm = false;
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM projects WHERE nome=?");
			stmt.setString(1,project.getNome());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				confirm = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirm;
	}
	
	public void deletaProject(String nome) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM projects WHERE nome=? ");
			stmt.setString(1, nome);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyProject(String nome, String nome_edit) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("UPDATE projects SET nome=? WHERE nome=?");
			stmt.setString(1, nome_edit);
			stmt.setString(2, nome);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
