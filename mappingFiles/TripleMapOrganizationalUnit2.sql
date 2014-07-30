sparql clear graph <http://temp/organizational-unit2> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganizationalUnit2>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "UOrgExercicio_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organizational-unit/{UORG_EXERCICIO}";
      rr:class org:OrganizationalUnit;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "UORG_EXERCICIO" ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:unitOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization2>;
			rr:joinCondition [
                rr:child "COD_ORG_EXERCICIO";
                rr:parent "COD_ORG_EXERCICIO";
            ];
        ];
    ]
.
', 'http://temp/organizational-unit2', 'http://temp/organizational-unit2' )
<end-command>