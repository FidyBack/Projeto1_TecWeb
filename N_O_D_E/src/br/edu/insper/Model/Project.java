package br.edu.insper.Model;

public class Project {
	private Integer id;
	private String nome;
	private Integer id_user;
	private String username;

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	public Integer getId_user() {return this.id_user;}
	public void setId_user(Integer id_user) {this.id_user = id_user;}
	public String getUsername() {return this.username;}
	public void setUsername(String username) {this.username = username;}
}
