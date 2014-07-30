package br.ufes.inf.nemo.nom.models;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Organization {

	private String 	prefLabel,
				 	notation,
				 	subOrganizationOf,
				 	sameAs;
	
	private ArrayList<Person> members;
	
	private int totalMembers;

	public Organization() {}
	
	public Organization(String prefLabel, String notation, String subOrganizationOf, String sameAs) {
		this.prefLabel = prefLabel;
		this.notation = notation;
		this.subOrganizationOf = subOrganizationOf;
		this.sameAs = sameAs;
	}

	
	public String getPrefLabel() {
		return prefLabel;
	}

	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}

	
	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	
	public String getSubOrganizationOf() {
		return subOrganizationOf;
	}

	public void setSubOrganizationOf(String subOrganizationOf) {
		this.subOrganizationOf = subOrganizationOf;
	}

	
	public String getSameAs() {
		return sameAs;
	}

	public void setSameAs(String sameAs) {
		this.sameAs = sameAs;
	}

	
	public ArrayList<Person> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}

	public int getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}
	
	


	
	
}
