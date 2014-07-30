sparql clear graph <http://temp/region> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .
@prefix vcard: <http://www.w3.org/2006/vcard/ns#> .

<http://localhost:8080/NOM/resource#TriplesMapRegion>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "EstadosIBGE_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/region/{CODIGO_UF}";
      rr:class vcard:Location;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "NOME_UF" ];
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:notation;
      rr:objectMap [ rr:column "CODIGO_UF" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:altLabel;
      rr:objectMap [ rr:column "SIGLA_UF" ];
    ]

.
', 'http://temp/region', 'http://temp/region' )
<end-command>