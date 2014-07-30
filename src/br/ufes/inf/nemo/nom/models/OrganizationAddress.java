package br.ufes.inf.nemo.nom.models;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OrganizationAddress {

	private String	postalCode,
					countryName,
					locality,
					hasRegion;
	
	private ArrayList<String> streetAddress;
	
	public OrganizationAddress(){
		
	}
	
	public OrganizationAddress(String postalCode, String countryName, String locality, String hasRegion, ArrayList<String> streetAddress){
		
		this.postalCode = postalCode;
		this.countryName = countryName;
		this.locality = locality;
		this.hasRegion = hasRegion;
		this.streetAddress = streetAddress;
		
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getHasRegion() {
		return hasRegion;
	}

	public void setHasRegion(String hasRegion) {
		this.hasRegion = hasRegion;
	}

	public ArrayList<String> getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(ArrayList<String> streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	
	
}


