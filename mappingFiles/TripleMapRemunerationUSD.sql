sparql clear graph <http://temp/person-remuneration-usd> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix gr: <http://purl.org/goodrelations/v1#> .

<http://localhost:8080/NOM/resource#TriplesMapRemunerationUSD>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Remuneracao112013_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/remuneration/usd/{ANO}/{MES}/person/{Id_SERVIDOR_PORTAL}";
	  rr:class gr:PriceSpecification;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

	rr:predicateObjectMap
    [
      rr:predicate gr:hasCurrencyValue;
      rr:objectMap [ rr:column "REMUNERACAO_BASICA_BRUTA_USD" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate gr:hasCurrency;
      rr:objectMap [ rr:constant USD ];
    ]

.
', 'http://temp/person-remuneration-usd', 'http://temp/person-remuneration-usd' )
<end-command>