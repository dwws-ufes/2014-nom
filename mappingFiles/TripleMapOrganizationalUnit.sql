sparql clear graph <http://temp/organizational-unit> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganizationalUnit>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "UOrgLotacao_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organizational-unit/{UORG_LOTACAO}";
      rr:class org:OrganizationalUnit;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "UORG_LOTACAO" ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:unitOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization>;
			rr:joinCondition [
                rr:child "COD_ORG_LOTACAO";
                rr:parent "COD_ORG_LOTACAO";
            ];
        ];
    ]

.
', 'http://temp/organizational-unit', 'http://temp/organizational-unit' )
<end-command>