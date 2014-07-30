sparql clear graph <http://temp/organization> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .
@prefix owl: <http://www.w3.org/2002/07/owl#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganization>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "OrgLotacao_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organization/{COD_ORG_LOTACAO}";
      rr:class org:FormalOrganization;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "ORG_LOTACAO" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:notation;
      rr:objectMap [ rr:column "COD_ORG_LOTACAO" ];
    ];

	rr:predicateObjectMap
    [
      	rr:predicate org:subOrganizationOf;
      	rr:objectMap [ 
			rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperior>;
			rr:joinCondition [
	            rr:child "COD_ORGSUP_LOTACAO";
	            rr:parent "COD_ORGSUP_LOTACAO";
	        ];
	  	];
    ];


	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationStructure>;
			rr:joinCondition [
                rr:child "ORG_LOTACAO";
                rr:parent "DADOS_CADASTRO_NOME";
            ];
        ];
    ]
.
', 'http://temp/organization', 'http://temp/organization' )
<end-command>