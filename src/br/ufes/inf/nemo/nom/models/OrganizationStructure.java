package br.ufes.inf.nemo.nom.models;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OrganizationStructure {

	private String	prefLabel,
					altLabel,
					notation,
					hasTelephone,
					hasEmail,
					hasURL,
					subOrganizationOf,
					hasSite;
	
	private ArrayList<String>	sameAs;
					
	public OrganizationStructure(){
		
	}
	
	public OrganizationStructure(String prefLabel, String altLabel, String notation){
		
		this.prefLabel = prefLabel;
		this.altLabel = altLabel;
		this.notation = notation;
		
	}


	public OrganizationStructure(String prefLabel, String altLabel, String notation, String hasTelephone, String hasEmail, String hasURL, String subOrganizationOf, String hasSite){
		
		this.prefLabel = prefLabel;
		this.altLabel = altLabel;
		this.notation = notation;
		this.hasTelephone = hasTelephone;
		this.hasEmail = hasEmail;
		this.hasURL = hasURL;
		this.subOrganizationOf = subOrganizationOf;
		this.hasSite = hasSite;

		
	}
	
	public String getPrefLabel() {
		return prefLabel;
	}

	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}

	public String getAltLabel() {
		return altLabel;
	}

	public void setAltLabel(String altLabel) {
		this.altLabel = altLabel;
	}

	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	public String getHasTelephone() {
		return hasTelephone;
	}

	public void setHasTelephone(String hasTelephone) {
		this.hasTelephone = hasTelephone;
	}

	public String getHasEmail() {
		return hasEmail;
	}

	public void setHasEmail(String hasEmail) {
		this.hasEmail = hasEmail;
	}

	public String getHasURL() {
		return hasURL;
	}

	public void setHasURL(String hasURL) {
		this.hasURL = hasURL;
	}

	public String getSubOrganizationOf() {
		return subOrganizationOf;
	}

	public void setSubOrganizationOf(String subOrganizationOf) {
		this.subOrganizationOf = subOrganizationOf;
	}

	public String getHasSite() {
		return hasSite;
	}

	public void setHasSite(String hasSite) {
		this.hasSite = hasSite;
	}

	public ArrayList<String> getSameAs() {
		return sameAs;
	}

	public void setSameAs(ArrayList<String> sameAs) {
		this.sameAs = sameAs;
	}
	
	
	
}
