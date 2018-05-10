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
 * Servlet implementation class ConsultaIndividualServlet
 */
@WebServlet("/ConsultaIndividualServlet")
public class ConsultaIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaIndividualServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("ya estas en la individual ");
		
		String idautor= request.getParameter("txtidautor");
		String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		String user="root";
		String pass="root";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
			Statement stmn = (Statement) conn.createStatement();
			ResultSet  rs;
			
			rs = stmn.executeQuery("SELECT * FROM autores WHERE idautor="+idautor);
			while(rs.next())
			{
				response.getWriter().append("id autor: "+rs.getInt("idautor")+"<br/>");
				response.getWriter().append("nombre: "+rs.getString("nombre")+"<br/>");
				response.getWriter().append("apellido: "+rs.getString("apellido")+"<br/>");
				response.getWriter().append("salario: "+rs.getDouble("salario")+"<br/>");
				response.getWriter().append("domicilio: "+rs.getString("domicilio")+"<br/>");
			}
			
			response.getWriter().append("<a href=\"index.jsp\"><input type=\"button\" value=\"Regresar\"></a>");
			
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
