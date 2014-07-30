package br.ufes.inf.nemo.nom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.nom.ConnectionFactory;
import br.ufes.inf.nemo.nom.models.OrganizationalUnit;
import br.ufes.inf.nemo.nom.servlet.DataViewerHTMLServlet;
import br.ufes.inf.nemo.nome.utils.Utils;

@ManagedBean (name="organizationalUnitService")
@ApplicationScoped
public class OrganizationalUnitService {

	public 	String 	URI,
	link = "<a href=\"{link}\">{name}</a>";

	Connection connection;

	public OrganizationalUnit createOrganizationalUnit() throws ClassNotFoundException, SQLException{		

		this.URI = DataViewerHTMLServlet.URI;
		this.connection = new ConnectionFactory().getConnection();

		OrganizationalUnit organizationalUnit = new OrganizationalUnit(getPrefLabel());
		return organizationalUnit;	
	}

	public OrganizationalUnit createOrganizationalUnit(String URI) throws ClassNotFoundException, SQLException{		

		this.URI = URI;
		this.connection = new ConnectionFactory().getConnection();

		OrganizationalUnit organizationalUnit = new OrganizationalUnit(getPrefLabel(URI));
		return organizationalUnit;	
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

}
