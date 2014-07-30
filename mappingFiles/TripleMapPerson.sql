sparql clear graph <http://temp/person> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix foaf: <http://xmlns.com/foaf/0.1/> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .

<http://localhost:8080/NOM/resource#TriplesMapPerson>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Agentes_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/person/{Id_SERVIDOR_PORTAL}";
 	  rr:class foaf:Person;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:notation;
      rr:objectMap [ rr:column "Id_SERVIDOR_PORTAL" ];
    ];

    rr:predicateObjectMap
    [
      rr:predicate foaf:name;
      rr:objectMap [ rr:column "NOME" ];
    ];
	
	rr:predicateObjectMap [
        rr:predicate org:memberOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization>;
            rr:joinCondition [
                rr:child "COD_ORG_LOTACAO";
                rr:parent "COD_ORG_LOTACAO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:memberOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationalUnit>;
            rr:joinCondition [
                rr:child "UORG_LOTACAO";
                rr:parent "UORG_LOTACAO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:memberOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization2>;
            rr:joinCondition [
                rr:child "COD_ORG_EXERCICIO";
                rr:parent "COD_ORG_EXERCICIO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:memberOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationalUnit2>;
            rr:joinCondition [
                rr:child "UORG_EXERCICIO";
                rr:parent "UORG_EXERCICIO";
            ];
        ];
    ];
	
	rr:predicateObjectMap [
        rr:predicate org:holds;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapPost>;
            rr:joinCondition [
                rr:child "DESCRICAO_CARGO";
                rr:parent "DESCRICAO_CARGO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:holds;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapPost2>;
            rr:joinCondition [
                rr:child "CODIGO_ATIVIDADE";
                rr:parent "CODIGO_ATIVIDADE";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:remuneration;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapRemunerationBRL>;
            rr:joinCondition [
                rr:child "Id_SERVIDOR_PORTAL";
                rr:parent "Id_SERVIDOR_PORTAL";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:remuneration;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapRemunerationUSD>;
            rr:joinCondition [
                rr:child "Id_SERVIDOR_PORTAL";
                rr:parent "Id_SERVIDOR_PORTAL";
            ];
        ];
    ]
.
', 'http://temp/person', 'http://temp/person' )
<end-command>