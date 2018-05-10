package org.jdbc.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class BorrarServlet
 */
@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "deprecation"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// declaro y asigno valores a las variables de sql
		String idautor= request.getParameter("txtidautor");
		String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		String user="root";
		String pass="root";
		String SentenciaSQL ="SELECT * FROM autores WHERE idautor="+idautor;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
			Statement stmn = (Statement) conn.createStatement();
			ResultSet  rs;
			
			rs = stmn.executeQuery(SentenciaSQL);
			// Recorremos 
			while (rs.next())
			{
				response.getWriter().append("<form action=\"BorrarUsuarioServlet\" method=\"get\"><br/>");
				
				request.setAttribute("txtidautor2", rs.getInt("idautor"));
				
				response.getWriter().append("id autor: "+"<input type=\"text\" id=\"txtidautor\" name=\"txtidautor\" value=\""+rs.getInt("idautor")+"\"><br/>");
				response.getWriter().append("nombre: "+rs.getString("nombre")+"<br/>");
				response.getWriter().append("apellido: "+rs.getString("apellido")+"<br/>");
				response.getWriter().append("salario: "+rs.getDouble("salario")+"<br/>");
				response.getWriter().append("domicilio: "+rs.getString("domicilio")+"<br/>");
				response.getWriter().append("<p><input type=\"submit\" value=\"borrar usuario\"></p>");
				response.getWriter().append("</form>");

			}
			
			response.getWriter().append("<a href=\"index.jsp\"><input type=\"button\" value=\"Regresar\"></a>");
			
			//cerramos todos los objetos
			rs.close();
			stmn.close();
			conn.close();
		}
			
			catch(Exception e)
			{
				System.out.println("error en la base de datos"+e);
			}
	
	}
}

