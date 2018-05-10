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
 * Servlet implementation class BorrarUsuarioServlet
 */
@WebServlet("/BorrarUsuarioServlet")
public class BorrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: asdfasdf ");//.append(request.getContextPath());
		String idautor= request.getParameter("txtidautor");
		String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		String user="root";
		String pass="root";
		String SentenciaSQL ="delete from autores where idautor="+idautor;
		//response.getWriter().append("id autor: "+idautor);
		

		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();   // instancia de la API 
			Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
			Statement stmn = (Statement) conn.createStatement();
//			ResultSet  rs;
//			
			/*int rs =*/int resultado = stmn.executeUpdate(SentenciaSQL);
//			while (rs.next())
//			{
			if(resultado>0)
			{
				response.getWriter().append("registros borrados: "+resultado);
			}
			else 
				response.getWriter().append("no se borro el registro");
				//response.getWriter().append("id autor:"+stmn.getInt("idautor"));
//		}
//				response.getWriter().append("<form action=\"BorrarUsuarioServlet\" method=\"get\"><br/>");
//				response.getWriter().append("id autor: "+rs.getInt("idautor")+"<br/>");
//				response.getWriter().append("nombre: "+rs.getString("nombre")+"<br/>");
//				response.getWriter().append("apellido: "+rs.getString("apellido")+"<br/>");
//				response.getWriter().append("salario: "+rs.getDouble("salario")+"<br/>");
//				response.getWriter().append("domicilio: "+rs.getString("domicilio")+"<br/>");
//				response.getWriter().append("<p><input type=\"submit\" value=\"borrar usuario\"></p>");
//				response.getWriter().append("</form>");
//
//			}
			//response.getWriter().append("usuario "+idautor+" borrado ");
//			
			response.getWriter().append("<a href=\"index.jsp\"><input type=\"button\" value=\"Regresar\"></a>");
//			
//			//cerramos todos los objetos
//			rs.close();
			stmn.close();
			conn.close();
		}
//			
			catch(Exception e)
			{
				System.out.println("error en la base de datos"+e);
			}
//	
//	}

	}
}

