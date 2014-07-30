package br.ufes.inf.nemo.nom.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PageController {

	public String getProcessOntologySearchPage(){		
		return "http://localhost:8080/OntologySearchWeb/ontologySearch.jsp?";
	}
	
	
}
