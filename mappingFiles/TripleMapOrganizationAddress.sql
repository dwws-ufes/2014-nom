sparql clear graph <http://temp/organization-address> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix vcard: <http://www.w3.org/2006/vcard/ns#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganizationAddress>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Organizacoes_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organization-structure/address/{DADOS_CADASTRO_CODIGO}";
      rr:class org:Site;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

    rr:predicateObjectMap
    [
      rr:predicate vcard:postal-code;
      rr:objectMap [ rr:column "LOCALIDADE_NUMERO_CEP" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:country-name;
      rr:objectMap [ rr:column "LOCALIDADE_NOME_PAIS" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:locality;
      rr:objectMap [ rr:column "LOCALIDADE_NOME_CIDADE" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:street-address;
      rr:objectMap [ rr:column "LOCALIDADE_DESCRICAO_ENDERECO" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:street-address;
      rr:objectMap [ rr:column "LOCALIDADE_DESCRICAO_BAIRRO" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:street-address;
      rr:objectMap [ rr:column "LOCALIDADE_DESCRICAO_COMPLEMENTO" ];
    ];

	rr:predicateObjectMap [
        rr:predicate vcard:hasRegion;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapRegion>;
            rr:joinCondition [
                rr:child "LOCALIDADE_SIGLA_UF";
                rr:parent "SIGLA_UF";
            ];
        ];
    ]
.
', 'http://temp/organization-address', 'http://temp/organization-address' )
<end-command>