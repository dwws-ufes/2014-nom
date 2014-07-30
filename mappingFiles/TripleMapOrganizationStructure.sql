sparql clear graph <http://temp/organization-structure> <end-command>

DB.DBA.TTLP ('
@prefix rr: <http://www.w3.org/ns/r2rml#> .
@prefix org: <http://www.w3.org/ns/org#> .
@prefix skos: <http://www.w3.org/2004/02/skos/core#> .
@prefix vcard: <http://www.w3.org/2006/vcard/ns#> .
@prefix owl: <http://www.w3.org/2002/07/owl#> .

<http://localhost:8080/NOM/resource#TriplesMapOrganizationStructure>
    a rr:TriplesMap;

    rr:logicalTable 
    [ 
      rr:tableSchema "CSV"; 
      rr:tableOwner "DBA"; 
      rr:tableName  "Organizacoes_csv" 
    ];

    rr:subjectMap 
    [ 
      rr:template "http://localhost:8080/NOM/resource/organization-structure/{DADOS_CADASTRO_CODIGO}";
      rr:class org:FormalOrganization;
      rr:graph <http://localhost:8080/NOM/graph#>;
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:notation;
      rr:objectMap [ rr:column "DADOS_CADASTRO_CODIGO" ];
    ];

    rr:predicateObjectMap
    [
      rr:predicate skos:prefLabel;
      rr:objectMap [ rr:column "DADOS_CADASTRO_NOME" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate skos:altLabel;
      rr:objectMap [ rr:column "DADOS_CADASTRO_SIGLA" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:hasTelephone;
      rr:objectMap [ rr:column "DADOS_CADASTRO_DDD" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:hasTelephone;
      rr:objectMap [ rr:column "DADOS_CADASTRO_TELEFONES" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:hasEmail;
      rr:objectMap [ rr:column "DADOS_CADASTRO_EMAIL" ];
    ];

	rr:predicateObjectMap
    [
      rr:predicate vcard:hasURL;
      rr:objectMap [ rr:column "DADOS_CADASTRO_SITE" ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:subOrganizationOf;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperiorStructure>;
			rr:joinCondition [
				rr:child "DADOS_CADASTRO_CODIGO_PAI";
                rr:parent "DADOS_CADASTRO_CODIGO_PAI";       
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapSIORG>;
			rr:joinCondition [
                rr:child "DADOS_CADASTRO_CODIGO";
                rr:parent "DADOS_CADASTRO_CODIGO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate org:hasSite;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationAddress>;
			rr:joinCondition [
                rr:child "DADOS_CADASTRO_CODIGO";
                rr:parent "DADOS_CADASTRO_CODIGO";
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization>;
			rr:joinCondition [
				rr:child "DADOS_CADASTRO_NOME";
                rr:parent "ORG_LOTACAO";       
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganization2>;
			rr:joinCondition [
				rr:child "DADOS_CADASTRO_NOME";
                rr:parent "ORG_EXERCICIO";       
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperior>;
			rr:joinCondition [
				rr:child "DADOS_CADASTRO_NOME";
                rr:parent "ORGSUP_LOTACAO";       
            ];
        ];
    ];

	rr:predicateObjectMap [
        rr:predicate owl:sameAs;
        rr:objectMap [
            rr:parentTriplesMap <http://localhost:8080/NOM/resource#TriplesMapOrganizationSuperior2>;
			rr:joinCondition [
				rr:child "DADOS_CADASTRO_NOME";
                rr:parent "ORGSUP_EXERCICIO";       
            ];
        ];
    ]

.
', 'http://temp/organization-structure', 'http://temp/organization-structure' )
<end-command>