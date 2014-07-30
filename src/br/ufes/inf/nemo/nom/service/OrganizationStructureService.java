package br.ufes.inf.nemo.nom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.OrganizationStructure;
import br.ufes.inf.nemo.nom.servlet.DataViewerHTMLServlet;
import br.ufes.inf.nemo.nome.utils.Utils;

@ManagedBean (name="organizationStructureService")
@ApplicationScoped
public class OrganizationStructureService {

	public 	String 	URI,
			link = "<a href=\"{link}\">{name}</a>";
	
	Connection connection;
	
	public OrganizationStructure createOrganizationStructure() throws ClassNotFoundException, SQLException{		
		
		this.URI = DataViewerHTMLServlet.URI;		
		this.connection = new ConnectionFactory().getConnection();
		
		OrganizationStructure organizationStructure = new OrganizationStructure(getPrefLabel(), getAltLabel(), getNotation(), getHasTelephone(), getHasEmail(), getHasURL(), getSubOrganizationOf(), getHasSite());
		
		return organizationStructure;	
	}		
	
	public OrganizationStructure createOrganizationStructure(String URI) throws ClassNotFoundException, SQLException{		
		
		this.URI = URI;
		this.connection = new ConnectionFactory().getConnection();
		
		OrganizationStructure organizationStructure = new OrganizationStructure(getPrefLabel(), getAltLabel(), getNotation(), getHasTelephone(), getHasEmail(), getHasURL(), getSubOrganizationOf(), getHasSite());
		
		return organizationStructure;	
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
	
	public String getAltLabel() throws ClassNotFoundException, SQLException {
		
		String	altLabel = "";
		
		String 		s = "<" + URI + ">",
					p = "<http://www.w3.org/2004/02/skos/core#altLabel>",
					o = "?o";
		
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			altLabel = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return altLabel;
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
	
	public String getHasTelephone() throws ClassNotFoundException, SQLException {
		
		String	hasTelephone = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#hasTelephone>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			hasTelephone = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return hasTelephone;
	}
	
	public String getHasEmail() throws ClassNotFoundException, SQLException {
		
		String	hasEmail = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#hasEmail>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			hasEmail = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return hasEmail;
	}
	
	public String getHasURL() throws ClassNotFoundException, SQLException {
		
		String	hasURL = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#hasURL>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			hasURL = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return hasURL;
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
		
		subOrganizationOf = link.replace("{link}", s + ".html");
		subOrganizationOf = subOrganizationOf.replace("{name}", getPrefLabel("<" + s + ">"));
		
		return subOrganizationOf;
	}
	
public String getHasSite() throws ClassNotFoundException, SQLException {
		
		String	hasSite = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#hasSite>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			hasSite = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return hasSite;
	}
}
