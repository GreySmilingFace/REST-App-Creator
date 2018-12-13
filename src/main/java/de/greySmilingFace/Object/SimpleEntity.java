package de.greySmilingFace.Object;

import java.util.List;

public class SimpleEntity {

	private String name;

	private List<EntityAttribute> attributes;

	public SimpleEntity(String name, List<EntityAttribute> attributes) {
		this.name = name;
		this.attributes = attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntityAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<EntityAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "SimpleEntity [name=" + name + ", attributes=" + attributes + "]";
	}

}
