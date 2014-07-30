package br.ufes.inf.nemo.nom.view.data;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.ufes.inf.nemo.nom.models.Organization;
import br.ufes.inf.nemo.nom.models.OrganizationStructure;
import br.ufes.inf.nemo.nom.service.OrganizationService;
import br.ufes.inf.nemo.nom.service.OrganizationStructureService;

@ManagedBean (name="OrganizationView")
@ViewScoped
public class OrganizationView {

	Organization organization;
	OrganizationStructure organizationStructure;
	
	@ManagedProperty("#{organizationService}")
    private OrganizationService service;
	
	@ManagedProperty("#{organizationStructureService}")
    private OrganizationStructureService service2;
	
	@PostConstruct
    public void init() {
		try {
			this.organization = service.createOrganization();	
			this.organizationStructure = service2.createOrganizationStructure(this.organization.getSameAs());
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public OrganizationStructure getOrganizationStructure() {
		return organizationStructure;
	}

	public void setOrganizationStructure(OrganizationStructure organizationStructure) {
		this.organizationStructure = organizationStructure;
	}

	public OrganizationService getService() {
		return service;
	}

	public void setService(OrganizationService service) {
		this.service = service;
	}

	public OrganizationStructureService getService2() {
		return service2;
	}

	public void setService2(OrganizationStructureService service2) {
		this.service2 = service2;
	}
	
	
	
}
