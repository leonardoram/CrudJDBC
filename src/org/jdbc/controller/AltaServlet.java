package org.jdbc.controller;

import java.io.IOException;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class AltaServlet
 */
@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//int idautor= Integer.parseInt(request.getParameter("txtautor"));
		String nombre= request.getParameter("txtnombre");
		String apellido= request.getParameter("txtapellido");
		String domicilio= request.getParameter("txtdomicilio");
		double salario= Double.parseDouble(request.getParameter("txtsalario"));
		
		String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		String user="root";
		String pass="root";
		String sentencia="insert into autores(nombre,apellido,domicilio,salario) values (?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn;
			PreparedStatement stmn;
			int resultado ;
			
			conn = (Connection) DriverManager.getConnection(url,user,pass);
			stmn =  (PreparedStatement) conn.prepareStatement(sentencia);
			
			//stmn.setInt(1, idautor);
			stmn.setString(1,nombre);
			stmn.setString(2,apellido);
			stmn.setString(3,domicilio);
			stmn.setDouble(4,salario);
			
			resultado = stmn.executeUpdate();
			if(resultado>0)
			{
				response.getWriter().append("<p>se afectaron "+resultado+"filas</p>");
			}
			else
			{
				response.getWriter().append("<p>usuario no agregado</p>");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("error en la base de datos"+ex);
		}
				
				
		
		
	}

}

