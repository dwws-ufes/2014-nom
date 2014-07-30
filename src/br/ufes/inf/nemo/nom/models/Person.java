package br.ufes.inf.nemo.nom.models;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Person {

	private String 	name,
					notation;
	
	private ArrayList<String>	remuneration,
								memberOf,
								holds;
	
	public Person(){
	}
	
	public Person(String name, String notation, ArrayList<String> memberOf, ArrayList<String> holds){
		this.name = name;
		this.notation = notation;
		this.memberOf = memberOf;
		this.holds = holds;
	}
	
	public Person(String name, String notation, ArrayList<String> memberOf, ArrayList<String> holds, ArrayList<String> remuneration){
		this.name = name;
		this.notation = notation;
		this.memberOf = memberOf;
		this.holds = holds;
		this.remuneration = remuneration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	public ArrayList<String> getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(ArrayList<String> memberOf) {
		this.memberOf = memberOf;
	}

	
	public ArrayList<String> getHolds() {
		return holds;
	}

	public void setHolds(ArrayList<String> holds) {
		this.holds = holds;
	}

	
	public ArrayList<String> getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(ArrayList<String> remuneration) {
		this.remuneration = remuneration;
	}
	
	
}
