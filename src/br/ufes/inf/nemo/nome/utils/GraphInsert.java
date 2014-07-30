package br.ufes.inf.nemo.nome.utils;

import br.ufes.inf.nemo.nom.ConnectionFactory;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import virtuoso.jena.driver.VirtDataSource;

public class GraphInsert {

	public static void main(String[] args) {
		
		String graphNamespace = "http://www.w3.org/ns/org#";
		
		Model model = ModelFactory.createDefaultModel();
		model.read(graphNamespace);
		
		ConnectionFactory factory = new ConnectionFactory();
		VirtDataSource virtDataSource = factory.getVirtDataSource();
		virtDataSource.addNamedModel(graphNamespace, model);

	}

}
