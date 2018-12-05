package de.greySmilingFace.Creator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import de.greySmilingFace.Object.Pom;

public class PomCreator {

	private Pom pom;

	public PomCreator(Pom pom) {
		this.pom = pom;
	}

	public void writeToFile(String path, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\" + fileName));
		writer.write(setContentToPom());
		writer.close();
	}

	private String setContentToPom() {
		StringBuilder builder = new StringBuilder();
		builder.append("<project xmlns=\"").append("http://maven.apache.org/POM/4.0.0").append("\" xmlns:xsi=\"")
				.append("http://www.w3.org/2001/XMLSchema-instance").append("\"\n") //
				.append("xsi:schemaLocation=\"")
				.append("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd").append("\">\n") //
				.append("<modelVersion>").append(pom.getModelVersion()).append("</modelVersion>\n") //
				.append("<groupId>").append(pom.getGroupId()).append("</groupId>\n") //
				.append("<artifactId>").append(pom.getArtifactId()).append("</artifactId>\n") //
				.append("<version>").append(pom.getVersion()).append("</version>\n") //
				.append("<packaging>").append(pom.getPackaging()).append("</packaging>\n") //
				.append("<name>").append(pom.getName()).append("</name>\n")//
				.append("<description>").append(pom.getDescription()).append("</description>\n") //
				.append("<properties>\n").append("<failOnMissingWebXml>false</failOnMissingWebXml>\n")
				.append("</properties>\n") //
				.append("</project>");
		return builder.toString();
	}

}
