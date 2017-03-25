package br.edu.univas.si7.sd.student;

public class Aluno {

	private String name;
	private String identifier;
	
	public Aluno() {
	}
	
	public Aluno(String name, String identifier) {
		super();
		this.name = name;
		this.identifier = identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
