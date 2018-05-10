package org.jdbc.controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ModificarUsuarioServlet
 */
@WebServlet("/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idAutor=request.getParameter("txtidautor");
		String nombreAutor=request.getParameter("txtnombre");
		String apellidoAutor=request.getParameter("txtapellido");
		//String telefonoAutor=request.getParameter("txttelefono");
		String domicilioAutor=request.getParameter("txtdomicilio");
		String salarioAutor=request.getParameter("txtsalario");
		
		String url;
		String user;
		String pass;
		String sentenciaSQL;
		
		url="jdbc:mysql://127.0.0.1:3306/biblioteca";
		user="root";
		pass="root";
		sentenciaSQL="UPDATE autores SET nombre=?, apellido=?, domicilio=?, salario=? WHERE idautor=?";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn;
			PreparedStatement stmnt;
			int resultado;
			
			conn = (Connection) DriverManager.getConnection(url,user,pass);
			stmnt = (PreparedStatement) conn.prepareStatement(sentenciaSQL);
			stmnt.setString(1, nombreAutor);
			stmnt.setString(2, apellidoAutor);
			//stmnt.setInt(3, Integer.parseInt(telefonoAutor));
			stmnt.setString(3, domicilioAutor);
			stmnt.setDouble(4, Double.parseDouble(salarioAutor));
			stmnt.setInt(5, Integer.parseInt(idAutor));
			resultado=stmnt.executeUpdate();
			if(resultado>0)
			{
				response.getWriter().append("Cantidad de registros afectados:"+resultado);
			}
			else
			{
				response.getWriter().append("Actualización Fallida");
			}
			
			stmnt.close();
			conn.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	

	}

}
