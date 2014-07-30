sparql clear graph <http://temp/person-remuneration-brl> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix gr: <http://purl.org/goodrelations/v1#> .

<http://localhost:8080/NOM/resource#TriplesMapRemunerationBRL>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Remuneracao112013_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/remuneration/brl/{ANO}/{MES}/person/{Id_SERVIDOR_PORTAL}";
	  rr:class gr:PriceSpecification;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

	rr:predicateObjectMap
    [
      rr:predicate gr:hasCurrencyValue;
      rr:objectMap [ rr:column "REMUNERACAO_BASICA_BRUTA_BRL" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate gr:hasCurrency;
      rr:objectMap [ rr:constant BRL ];
    ]

.
', 'http://temp/person-remuneration-brl', 'http://temp/person-remuneration-brl' )
<end-command>