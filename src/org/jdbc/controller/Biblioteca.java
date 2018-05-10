package org.jdbc.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdbc.model.Autores;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;



/**
 * Servlet implementation class Biblioteca
 */
@WebServlet("/Biblioteca")
public class Biblioteca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Biblioteca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("si funciona");
		
		String url ="jdbc:mysql://127.0.0.1:3306/biblioteca";
		String user ="root";
		String password ="root";
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn =  (Connection) DriverManager.getConnection(url,user,password);
			System.out.println("conexion establecida");
			stmt = (Statement) conn.createStatement();
			
			Statement stmnt =(Statement) conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT* FROM autores");
			
			while(rs.next())
			{
				System.out.println("id autor: "+rs.getInt("idautor"));
				System.out.println("nombre : "+rs.getString("nombre"));
				System.out.println("id autor: "+rs.getString("apellido"));
				System.out.println("id autor: "+rs.getString("domicilio"));
				System.out.println("id autor: "+rs.getDouble("salario"));
				
			}
			
			
//			String sql ="INSERT INTO autores (apellido,salario,domicilio,nombre) VALUES ('ramirez',30000,'enrique segoviano','leo')";
//			stmt.executeUpdate(sql);
//			
//			String sql1 ="INSERT INTO autores (apellido,salario,domicilio,nombre) VALUES ('plascencia',40000,'casa del arbol','alex')";
//			stmt.executeUpdate(sql1);
//			
//			String sql2=("SELECT * From autores");
//			stmnt.executeQuery(sql2);
			
			
			//sql ="UPDATE autores SET salario  = 500 WHERE idautor=2";
			//stmt.executeUpdate(sql);
			
			
			
			conn.close();
		}
		catch(Exception e) 
		{
			System.out.println("exception :"+e);
		}
		
		Autores Leonardo = new Autores();
		
		Leonardo.setidautor(Integer.parseInt(request.getParameter("txtidautor")));
		Leonardo.setnombre(request.getParameter("txtnombre"));
		Leonardo.setapellido(request.getParameter("txtapellido"));
		Leonardo.setdomicilio(request.getParameter("txtdomicilio"));
		Leonardo.setsalario(Double.parseDouble(request.getParameter("txtsalario")));

		response.getWriter().append("el id del Autor:"+Leonardo.getidautor()+"<br/>"+"nombre: "+Leonardo.getnombre()+"<br/>"+"domicilio: "+Leonardo.getdomicilio()+
				"<br/>"+"apellido: "+Leonardo.getapellido()+"<br/>"+"salario: "+Leonardo.getsalario());
		
		
		
		
	}

}
