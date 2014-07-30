package br.ufes.inf.nemo.nom.view.data;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.ufes.inf.nemo.nom.models.OrganizationStructure;
import br.ufes.inf.nemo.nom.service.OrganizationStructureService;

@ManagedBean (name="OrganizationStructureView")
@ViewScoped
public class OrganizationStructureView {

	OrganizationStructure organizationStructure;
	
	@ManagedProperty("#{organizationStructureService}")
    private OrganizationStructureService service;
	
	@PostConstruct
    public void init() {
		try {
			this.organizationStructure = service.createOrganizationStructure();
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

	public OrganizationStructure getOrganizationStructure() {
		return organizationStructure;
	}

	public void setOrganizationStructure(OrganizationStructure organizationStructure) {
		this.organizationStructure = organizationStructure;
	}

	public OrganizationStructureService getService() {
		return service;
	}

	public void setService(OrganizationStructureService service) {
		this.service = service;
	}
	
	
	
}
