package de.limago.jpademo.models;

public class TinyBar {
	
	private final int id;
	private final String name;
	public TinyBar(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "TinyBar [id=" + id + ", name=" + name + "]";
	}
	
	

}
