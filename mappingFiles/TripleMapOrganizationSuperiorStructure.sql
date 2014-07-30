sparql clear graph <http://temp/organization-superior-structure> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperiorStructure>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Organizacoes_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organization-structure/{DADOS_CADASTRO_CODIGO_PAI}";
      rr:class org:FormalOrganization;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ]

.
', 'http://temp/organization-superior-structure', 'http://temp/organization-superior-structure' )
<end-command>

	