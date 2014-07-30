package br.ufes.inf.nemo.nom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import virtuoso.jena.driver.VirtDataSource;
import virtuoso.sesame3.driver.VirtuosoRepository;

public class ConnectionFactory
{
	private final String connectionString = "jdbc:virtuoso://localhost:1111";
	private final String user = "dba";
	private final String pass = "dba";

	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		return getConnection(connectionString, user, pass);
	}
	
	public Connection getConnection(String connectionString, String user, String pass) throws ClassNotFoundException, SQLException
	{
    	Class.forName("virtuoso.jdbc4.Driver");
	    
        return DriverManager.getConnection(connectionString, user, pass);
	}
	
	public VirtDataSource getVirtDataSource()
	{
		return getVirtDataSource(connectionString, user, pass);
	}
	
	public VirtDataSource getVirtDataSource(String connectionString, String user, String pass)
	{
		return new VirtDataSource(connectionString, user, pass);
	}
	
	public VirtuosoRepository getVirtuosoRepository(String baseURI)
	{
		return getVirtuosoRepository(connectionString, user, pass, baseURI);
	}
	
	public VirtuosoRepository getVirtuosoRepository(String connectionString, String user, String pass, String baseURI)
	{
		return new VirtuosoRepository(connectionString, user, pass, baseURI);
	}
}
