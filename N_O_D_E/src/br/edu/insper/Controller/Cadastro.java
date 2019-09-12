package br.edu.insper.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.insper.Model.*;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		DAO dao = new DAO();
		User usuario = new User();
		String nome = request.getParameter("nome_cad");
		String senha = request.getParameter("senha_cad");
		String confsenha = request.getParameter("senha_cadconf");
		
		int cadastrado = 0;
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		if (dao.checkUserInSystem(usuario)) {
			cadastrado = 1;
		} else if (nome.isEmpty() || senha.isEmpty()) {
			cadastrado = 2;
		} else if (senha.equals(confsenha) == false) {
			cadastrado = 3;
		} else {
			dao.adicionaUser(usuario);
		}
		
		request.setAttribute("cadastro", cadastrado);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);

	 }
}
