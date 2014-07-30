package br.ufes.inf.nemo.nom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.Person;
import br.ufes.inf.nemo.nom.servlet.DataViewerHTMLServlet;
import br.ufes.inf.nemo.nome.utils.Utils;

@ManagedBean (name="personService")
@ApplicationScoped
public class PersonService {

	public 	String 	URI,
			link = "<a href=\"{link}\">{name}</a>";
	
	Connection connection;
	
	public Person createPerson() throws ClassNotFoundException, SQLException{	
		this.URI = DataViewerHTMLServlet.URI;
		this.connection = new ConnectionFactory().getConnection();	
		Person person = new Person(getName(), getNotation(), getMemberOf(), getHolds());
		return person;	
	}

	public String getName() throws ClassNotFoundException, SQLException {
		
		String	name = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://xmlns.com/foaf/0.1/name>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			name = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return name;
	}
	
	public String getNotation() throws ClassNotFoundException, SQLException {
		
		String	notation = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2004/02/skos/core#notation>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			notation = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return notation;
	}

	public ArrayList<String> getMemberOf() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> memberOf = new ArrayList<String>();
	
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/ns/org#memberOf>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()){
			s = rs.getString("o");		
			memberOf.add(s);
		}
		
		rs.close();
		st.close();
		
		return memberOf;
	}

	public ArrayList<String> getHolds() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> holds = new ArrayList<String>();
	
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2004/02/skos/core#prefLabel>",
				p2 = "<http://www.w3.org/ns/org#holds>",
				o = "?o",
				o2 = "?o2";
	
		//String query = Utils.createSelectQuery(s, p, o);
		
		String query = "sparql SELECT * from <http://localhost:8080/NOM/resource#> where { "
				+ s + " " + p2 + " " + o2 + " ."
				+ o2 + " " +  p + " " + o + " ."
				+ "}";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()){
			s = rs.getString("o");		
			holds.add(s);
		}
		
		rs.close();
		st.close();
		
		return holds;
	}
	
}
