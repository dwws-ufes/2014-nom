package br.ufes.inf.nemo.nom.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.Data;
import br.ufes.inf.nemo.nom.servlet.DataViewerServlet;

@ManagedBean (name="DataController")
public class DataController {

	public String getURL(){
		return DataViewerServlet.URI;
	}
	
	public ArrayList<Data> getFindRelationships() throws ClassNotFoundException, SQLException{			
		return findRelationships();	
	}
	
	public ArrayList<Data> getFindAllRelationships() throws ClassNotFoundException, SQLException {
		return findAllRelationships();
	}	
	
	public ArrayList<Data> findRelationships() throws ClassNotFoundException, SQLException{
		
		String link = "<a href=\"{link}\">{link}</a>";
		
		ArrayList<Data> data = new ArrayList<Data>();
		
		//String query = "sparql DEFINE input:inference <http://www.w3.org/ns/org#> SELECT * from <http://localhost:8080/NOM/resource#> where { <" + DataViewerServlet.URI + "> ?p ?o .}";
		String query = "sparql SELECT * from <http://localhost:8080/NOM/resource#> where { <" + DataViewerServlet.URI + "> ?p ?o .}";
		
		ResultSet rs = executeQuery(query);
			
		while(rs.next()){
			Data d = new Data();
			d.setPredicate(link.replace("{link}", rs.getString("p")));
			if(rs.getString("o").contains("http")){
				d.setObject(link.replace("{link}", rs.getString("o")));
			}
			else{
				d.setObject(rs.getString("o"));
			}
			data.add(d);
		}
		
		rs.close();
		
		return data;
	}
	
	public ArrayList<Data> findAllRelationships() throws ClassNotFoundException, SQLException{
		
		String link = "<a href=\"{link}\">{link}</a>";
		
		ArrayList<Data> data = new ArrayList<Data>();
		
		String query = "sparql SELECT * from <http://localhost:8080/NOM/resource#> where { "
				+ "<http://localhost:8080/NOM/resource/person/1682175> ?p ?o ."
				+ "}";
		
		ResultSet rs = executeQuery(query);
			
		while(rs.next()){
			Data d = new Data();
			d.setSubject(link.replace("{link}", "http://localhost:8080/NOM/resource/person/1682175"));
			d.setPredicate(link.replace("{link}", rs.getString("p")));
			if(rs.getString("o").contains("http")){
				d.setObject(link.replace("{link}", rs.getString("o")));
			}
			else{
				d.setObject(rs.getString("o"));
			}
			data.add(d);
		}
		
		rs.close();
		
		return data;
	}
	
	public ResultSet executeQuery (String query) throws SQLException, ClassNotFoundException{
		
		Connection connection = new ConnectionFactory().getConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
				
		return rs;
		
	}
	
}
