package br.ufes.inf.nemo.nom.models;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Data {

	private String 	subject, 
					predicate, 
					object;


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	
	
}
