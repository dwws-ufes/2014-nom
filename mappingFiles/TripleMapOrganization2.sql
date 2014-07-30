sparql clear graph <http://temp/organization2> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .
@prefix owl: <http://www.w3.org/2002/07/owl#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganization2>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "OrgExercicio_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organization/{COD_ORG_EXERCICIO}";
      rr:class org:FormalOrganization;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "ORG_EXERCICIO" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:notation;
      rr:objectMap [ rr:column "COD_ORG_EXERCICIO" ];
    ];

	rr:predicateObjectMap
    [
      	rr:predicate org:subOrganizationOf;
      	rr:objectMap [ 		
			rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperior2>;
			rr:joinCondition [
	            rr:child "COD_ORGSUP_EXERCICIO";
	            rr:parent "COD_ORGSUP_EXERCICIO";
	        ];
		];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationStructure>;
			rr:joinCondition [
                rr:child "ORG_EXERCICIO";
                rr:parent "DADOS_CADASTRO_NOME";
            ];
        ];
    ]
.
', 'http://temp/organization2', 'http://temp/organization2' )
<end-command>