package fr.poc.spring;

import java.io.Serializable;

public class Todo implements Serializable {
	private String name;
	
	public Todo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
