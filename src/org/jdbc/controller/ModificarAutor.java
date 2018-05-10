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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ModificarAutor
 */
@WebServlet("/ModificarAutor")
public class ModificarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idAutor = request.getParameter("txtidautor");
		//response.getWriter().append("Id Autor:"+idAutor);
		
		String url;
		String user;
		String pass;
		String sentenciaSQL;
		
		url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		user="root";
		pass="root";
		sentenciaSQL="SELECT * FROM autores WHERE idautor="+idAutor;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn;
			Statement stmnt;
			ResultSet rs;
			
			conn = (Connection) DriverManager.getConnection(url, user, pass);
			
			stmnt = (Statement) conn.createStatement();
			
			rs = stmnt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				response.getWriter().append("<form action=\"ModificarUsuarioServlet\" method=\"get\">");
				response.getWriter().append("<p>Id Autor:<input type=\"text\" name=\"txtidautor\" value=\""+rs.getInt("idautor")+"\" </p>");
				response.getWriter().append("<p>Nombre Autor:<input type=\"text\" name=\"txtnombre\" value=\""+rs.getString("nombre")+"\" </p>");
				response.getWriter().append("<p>Apellido Autor:<input type=\"text\" name=\"txtapellido\" value=\""+rs.getString("apellido")+"\" </p>");
				//response.getWriter().append("<p>Telefono Autor:<input type=\"text\" name=\"txttelefono\" value=\""+rs.getInt("telefono")+"\" </p>");
				response.getWriter().append("<p>Domicilio Autor:<input type=\"text\" name=\"txtdomicilio\" value=\""+rs.getString("domicilio")+"\" </p>");
				response.getWriter().append("<p>Salario Autor:<input type=\"text\" name=\"txtsalario\" value=\""+rs.getDouble("salario")+"\" </p>");
				response.getWriter().append("<p><input type=\"submit\" value=\"Actualiza Registro\"</p>");
				response.getWriter().append("</form>");
			}
			response.getWriter().append("<a href=\"index.jsp\"><input type=\"button\" value=\"Regresar\"></a>");
		}
		catch(Exception e)
		{
			System.out.println("Error en la bd:"+e);
		}
		
	}

}
