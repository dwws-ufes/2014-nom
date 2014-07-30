package br.ufes.inf.nemo.nom.models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OrganizationalUnit {

	String 	prefLabel,
			unitOf;
	
	public OrganizationalUnit(){
		
	}
	
	public OrganizationalUnit(String prefLabel){
		this.prefLabel = prefLabel;
	}

	public OrganizationalUnit(String prefLabel, String unitOf){
		this.prefLabel = prefLabel;
		this.unitOf = unitOf;
	}
	
	public String getPrefLabel() {
		return prefLabel;
	}

	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}

	public String getUnitOf() {
		return unitOf;
	}

	public void setUnitOf(String unitOf) {
		this.unitOf = unitOf;
	}
	
	
	
}
