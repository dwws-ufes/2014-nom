package br.ufes.inf.nemo.nom.models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Region {

	private String	prefLabel,
					altLabel,
					notation;
	
	public Region(){
		
	}
	
	public Region(String prefLabel, String altLabel, String notation){
		
		this.prefLabel = prefLabel;
		this.altLabel = altLabel;
		this.notation = notation;
		
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
	
	
	
	
}
