package br.ufes.inf.nemo.nom.controllers;


import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import virtuoso.jena.driver.VirtModel;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import br.ufes.inf.nemo.nom.servlet.DataViewerRDFServlet;

@ManagedBean (name="RDFDataController")
public class RDFDataController {

	String RDFTriple;
	
	public String getURL(){
		return DataViewerRDFServlet.URI;
	}
	

	public String getRDFTriples() throws ClassNotFoundException, SQLException, IOException {
	
		String uri = DataViewerRDFServlet.URI;
			   //uriPath = DataViewerRDFServlet.URIPath;
		
		String query = "CONSTRUCT { <" + uri + "> ?p ?o .} where { <" + uri + "> ?p ?o .}";
		
		//System.out.println(query);
		
		VirtModel mdata = VirtModel.openDatabaseModel("http://localhost:8080/NOM/resource#", "jdbc:virtuoso://localhost:1111", "dba", "dba");
		
		QueryExecution qexec = VirtuosoQueryExecutionFactory.create(query, mdata) ;
		Model results = qexec.execConstruct();
		
		//Model orgModel = ModelFactory.createDefaultModel();
		//orgModel.read("http://www.w3.org/ns/org#");
		
		//results.add(orgModel);
		
		results.setNsPrefix("org", "http://www.w3.org/ns/org#");
		results.setNsPrefix("skos", "http://www.w3.org/2004/02/skos/core#");
		results.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		
		Writer saida = new StringWriter();
		results.write(saida, "RDF/XML");
		
		return saida.toString();
		
	}
	
	
}
