package de.greySmilingFace.Object;


public enum Packaging {
	WAR("war"),
	JAR("jar"),
	EJB("ejb"),
	EAR("ear"),
	POM("pom"),
	MAVENPLUGIN("maven-plugin");

	private String value;

	private Packaging(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
