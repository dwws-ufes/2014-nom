package br.ufes.inf.nemo.nom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.OrganizationAddress;
import br.ufes.inf.nemo.nom.servlet.DataViewerHTMLServlet;
import br.ufes.inf.nemo.nome.utils.Utils;

@ManagedBean (name="organizationAddressService")
@ApplicationScoped
public class OrganizationAddressService {

	public 	String 	URI,
			link = "<a href=\"{link}\">{name}</a>";

	Connection connection;
	
	public OrganizationAddress createOrganizationAddress() throws ClassNotFoundException, SQLException{		
	
		this.URI = DataViewerHTMLServlet.URI;
		this.connection = new ConnectionFactory().getConnection();
		
		OrganizationAddress organizationAddress = new OrganizationAddress(getPostalCode(), getCountryName(), getLocality(), getHasRegion(), getStreetAddress());
		
		return organizationAddress;	
	}
	
	public OrganizationAddress createOrganizationAddress(String URI) throws ClassNotFoundException, SQLException{		
		
		this.URI = URI;
		this.connection = new ConnectionFactory().getConnection();
		
		OrganizationAddress organizationAddress = new OrganizationAddress(getPostalCode(), getCountryName(), getLocality(), getHasRegion(), getStreetAddress());
		
		return organizationAddress;	
	}
	
	public String getPostalCode() throws ClassNotFoundException, SQLException {
		
		String	postalCode = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#postal-code>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			postalCode = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return postalCode;
	}
	
	public String getCountryName() throws ClassNotFoundException, SQLException {
		
		String	countryName = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#country-name>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			countryName = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return countryName;
	}
	
	public String getLocality() throws ClassNotFoundException, SQLException {
		
		String	locality = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#locality>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			locality = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return locality;
	}
	
	public String getHasRegion() throws ClassNotFoundException, SQLException {
		
		String	hasRegion = "";
		
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#hasRegion>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()){
			hasRegion = rs.getString("o");
		}
		
		rs.close();
		st.close();
		
		return hasRegion;
	}
	
	public ArrayList<String> getStreetAddress() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> streetAddress = new ArrayList<String>();
	
		String 	s = "<" + URI + ">",
				p = "<http://www.w3.org/2006/vcard/ns#street-address>",
				o = "?o";
	
		String query = Utils.createSelectQuery(s, p, o);
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()){
			s = rs.getString("o");		
			streetAddress.add(s);
		}
		
		rs.close();
		st.close();
		
		return streetAddress;
	}
	
}
