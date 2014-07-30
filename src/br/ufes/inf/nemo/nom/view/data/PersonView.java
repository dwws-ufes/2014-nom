package br.ufes.inf.nemo.nom.view.data;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.ufes.inf.nemo.nom.models.Organization;
import br.ufes.inf.nemo.nom.models.OrganizationalUnit;
import br.ufes.inf.nemo.nom.models.Person;
import br.ufes.inf.nemo.nom.service.OrganizationService;
import br.ufes.inf.nemo.nom.service.OrganizationalUnitService;
import br.ufes.inf.nemo.nom.service.PersonService;

@ManagedBean (name="PersonView")
@ViewScoped
public class PersonView {

	Person	person;
	Organization organization;
	OrganizationalUnit organizationalUnit;
	
	@ManagedProperty("#{personService}")
    private PersonService service;
	
	@ManagedProperty("#{organizationService}")
	private OrganizationService service2;
	
	@ManagedProperty("#{organizationalUnitService}")
	private OrganizationalUnitService service3;
	
	@PostConstruct
    public void init() {
		try {
			this.person = service.createPerson();
			
			for(int i=0; i<this.person.getMemberOf().size(); i++){
				if(this.person.getMemberOf().get(i).contains("/organization/")){
					this.organization = service2.createOrganization(this.person.getMemberOf().get(i));
				}
				else if(this.person.getMemberOf().get(i).contains("/organizational-unit/")){
					this.organizationalUnit = service3.createOrganizationalUnit(this.person.getMemberOf().get(i));			
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public void destroy(){
		destroy();
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonService getService() {
		return service;
	}

	public void setService(PersonService service) {
		this.service = service;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public OrganizationService getService2() {
		return service2;
	}

	public void setService2(OrganizationService service2) {
		this.service2 = service2;
	}

	public OrganizationalUnit getOrganizationalUnit() {
		return organizationalUnit;
	}

	public void setOrganizationalUnit(OrganizationalUnit organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public OrganizationalUnitService getService3() {
		return service3;
	}

	public void setService3(OrganizationalUnitService service3) {
		this.service3 = service3;
	}
	
	
	
}
