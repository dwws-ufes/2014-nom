package br.ufes.inf.nemo.nome.utils;

public class Utils {
	
	public static String createSelectQuery (String s, String p, String o){			
		return "sparql SELECT * from <http://localhost:8080/NOM/resource#> where { " + s + " " + p + " " + o + " }";
	}
	
	public static String createSelectInferenceQuery (String s, String p, String o){			
		return "sparql DEFINE input:inference <http://www.w3.org/ns/org#> SELECT * from <http://localhost:8080/NOM/resource#> where { " + s + " " + p + " " + o + " }";
	}
	
	public static String createSelectCountInferenceQuery (String s, String p, String o){			
		return "sparql DEFINE input:inference <http://www.w3.org/ns/org#> SELECT COUNT(*) from <http://localhost:8080/NOM/resource#> where { " + s + " " + p + " " + o + " }";
	}
}
