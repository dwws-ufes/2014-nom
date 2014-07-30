package br.ufes.inf.nemo.nom.view.data;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.ufes.inf.nemo.nom.models.OrganizationAddress;
import br.ufes.inf.nemo.nom.service.OrganizationAddressService;

@ManagedBean (name="OrganizationAddressView")
@ViewScoped
public class OrganizationAddressView {

	OrganizationAddress organizationAddress;
	
	@ManagedProperty("#{organizationAddresservice}")
    private 	OrganizationAddressService service;
	
	@PostConstruct
    public void init() {
		try {
			this.organizationAddress = service.createOrganizationAddress();	
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

	public OrganizationAddress getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(OrganizationAddress organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public OrganizationAddressService getService() {
		return service;
	}

	public void setService(OrganizationAddressService service) {
		this.service = service;
	}

	
}
