package br.ufes.inf.nemo.nom;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufes.inf.nemo.nom.mapping.VirtuosoR2RML;

public class NOM {

	static Connection connection;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		connection = new ConnectionFactory().getConnection();
		
		VirtuosoR2RML r2rml = new VirtuosoR2RML();	
		ArrayList<String> mapList = new ArrayList<String>(); 
		
		//mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOWLClass.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapRegion.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapSIORG.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationAddress.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationSuperiorStructure.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationStructure.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationalUnit.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationSuperior.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganization.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationalUnit2.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganizationSuperior2.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapOrganization2.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapPost.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapPost2.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapRemunerationBRL.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapRemunerationUSD.sql");
		mapList = r2rml.createMapping(mapList, "mappingFiles/TripleMapPerson.sql");
		
		mapList = r2rml.createMapping(mapList, "mappingFiles/ExecuteTripleMaps.sql");
		
		long startTime = System.currentTimeMillis();
		
		r2rml.executeMapping(mapList, connection);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Tempo Total: " + (endTime - startTime)/1000 + "s"); 

	}
}
