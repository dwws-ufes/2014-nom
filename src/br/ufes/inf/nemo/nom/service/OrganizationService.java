package br.ufes.inf.nemo.nom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.Organization;
import br.ufes.inf.nemo.nom.servlet.DataViewerHTMLServlet;
import br.ufes.inf.nemo.nome.utils.Utils;

@ManagedBean (name="organizationService")
@ApplicationScoped
public class OrganizationService {

	public 	String 	URI,
			link = "<a href=\"{link}\">{name}</a>";
	
	Connection connection;
	
	public Organization createOrganization() throws ClassNotFoundException, SQLException{		
		
		this.URI = DataViewerHTMLServlet.URI;
		this.connection = new ConnectionFactory().getConnection();
		
		Organization organization = new Organization(getPrefLabel(), getNotation(), getSubOrganizationOf(), getSameAs());
		return organization;	
	}
	
	public Organization createOrganization(String URI) throws ClassNotFoundException, SQLException{		
		
		this.URI = URI;
		this.connection = new ConnectionFactory().getConnection();
		
		Organization organization = new Organization(getPrefLabel(URI), getNotation(), getSubOrganizationOf(), getSameAs());
		return organization;	
	}
	
	public String getPrefLabel() throws ClassNotFoundException, SQLException {
	
		String	prefLabel = "";
		
		String 		s = "<" + URI + ">",
					p = "<http://www.w3.org/2004/02/skos/core#prefLabel>",
					o = "?o";
		
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			prefLabel = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return prefLabel;
	}
	
	public String getPrefLabel(String s) throws ClassNotFoundException, SQLException {
		
		String	prefLabel = "";
		
		String 		p = "<http://www.w3.org/2004/02/skos/core#prefLabel>",
					o = "?o";
		
		String query = Utils.createSelectQuery("<" + s + ">", p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			prefLabel = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		String linkPrefLabel = link.replace("{link}", s + ".html");
		
		prefLabel = linkPrefLabel.replace("{name}", prefLabel);
		
		return prefLabel;
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
	
	public String getSubOrganizationOf() throws SQLException, ClassNotFoundException {

		String	subOrganizationOf = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/ns/org#subOrganizationOf>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			s = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		subOrganizationOf = getPrefLabel(s);
		
		return subOrganizationOf;
	}
	
	public String getSameAs() throws ClassNotFoundException, SQLException {
		
		String	sameAs = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2002/07/owl#sameAs>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			sameAs = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		//sameAs = getPrefLabel("<" + s + ">");
		
		return sameAs;
	}
	
	public int getTotalMembers() throws SQLException{
		
		int totalMembers = 0;
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/ns/org#hasMember>",
				o = "?o";
	
		String query = Utils.createSelectCountInferenceQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			s = rs.getString("callret-0");
		}
		
		totalMembers = Integer.parseInt(s);
		
		rs.close();
		st.close();
		
		return totalMembers;
		
	}
}
