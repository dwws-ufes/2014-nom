package br.ufes.inf.nemo.nome.utils;

import java.util.EnumSet;

import org.mindswap.pellet.jena.ModelExtractor;
import org.mindswap.pellet.jena.ModelExtractor.StatementType;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import virtuoso.jena.driver.VirtDataSource;
import virtuoso.jena.driver.VirtModel;
import br.ufes.inf.nemo.nom.ConnectionFactory;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Inference {

	public static void main(String[] args) {
		
		VirtModel mdata = VirtModel.openDatabaseModel("http://localhost:8080/NOM/resource#", "jdbc:virtuoso://localhost:1111", "dba", "dba");
		
		Model model = ModelFactory.createDefaultModel();
		model.add(mdata);
		
		Model orgModel = ModelFactory.createDefaultModel();
		orgModel.read("http://www.w3.org/ns/org#");
		
		model.add(orgModel);
		
		//model.setNsPrefix("org", "http://www.w3.org/ns/org#");
		//model.setNsPrefix("skos", "http://www.w3.org/2004/02/skos/core#");
		//model.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		
		OntModel ontmodel = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC);
		ontmodel.add(model);
		
		ModelExtractor extractor = new ModelExtractor(ontmodel);
		extractor.setSelector(EnumSet.of(StatementType.INVERSE_PROPERTY));
		Model inferences = extractor.extractModel();
		
		ConnectionFactory factory = new ConnectionFactory();
		VirtDataSource virtDataSource = factory.getVirtDataSource();
		virtDataSource.addNamedModel("http://localhost:8080/NOM/resource-inferences#", inferences);

	}

}
