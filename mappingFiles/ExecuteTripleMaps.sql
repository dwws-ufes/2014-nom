sparql clear graph <http://temp/mix> <end-command>
sparql clear graph <http://localhost:8080/NOM/graph#> <end-command>
sparql clear graph <http://localhost:8080/NOM/resource#> <end-command>

sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/region> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-siorg> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-address> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-superior-structure> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-structure> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-superior> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization-superior2> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organizational-unit> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organizational-unit2> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/organization2> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/post> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/post2> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/person-remuneration-brl> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/person-remuneration-usd> where { ?s ?p ?o } <end-command>
sparql insert in graph <http://temp/mix> { ?s ?p ?o } from <http://temp/person> where { ?s ?p ?o } <end-command>

exec ('sparql ' || DB.DBA.R2RML_MAKE_QM_FROM_G ('http://temp/mix')) <end-command>

sparql insert in graph <http://localhost:8080/NOM/resource#> { ?s ?p ?o } from <http://localhost:8080/NOM/graph#> where { ?s ?p ?o } <end-command>

