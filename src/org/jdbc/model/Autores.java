package org.jdbc.model;

public class Autores {
	
	private int idautor;
	private String nombre;
	private String apellido;
	private String domicilio;
	private double salario;
	
	public void setnombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getnombre()
	{
		return nombre;
	}
	
	public void setidautor(int autor)
	{
		idautor = autor;
	}
	
	public int getidautor() 
	{
		return idautor;
	}
	
	public void setapellido(String apellido)
	{
		this.apellido = apellido;
	}
	
	public String getapellido()
	{
		return apellido;
	}
	
	public void setdomicilio(String domiclio)
	{
		this.domicilio = apellido;
	}
	
	public String getdomicilio()
	{
		return domicilio;
	}
	
	public void setsalario(double salario)
	{
		this.salario = salario;
	}
	
	public double getsalario()
	{
		return salario;
	}
}
