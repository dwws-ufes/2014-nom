sparql clear graph <http://temp/organization-siorg> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .

<http://localhost:8080/NOM/resource#TriplesMapSIORG>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Organizacoes_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://www.siorg.redegoverno.gov.br/Atributo.asp?co_orgao={DADOS_CADASTRO_CODIGO}";
      rr:class org:FormalOrganization;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ]

.
', 'http://temp/organization-siorg', 'http://temp/organization-siorg' )
<end-command>