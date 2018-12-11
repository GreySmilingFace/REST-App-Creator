package de.greySmilingFace;

import java.io.IOException;

import de.greySmilingFace.Creator.PomCreator;
import de.greySmilingFace.Creator.ProjectGenerator;
import de.greySmilingFace.Object.Packaging;
import de.greySmilingFace.Object.Pom;

public class TestClass {

	public static void main(String[] args) {

		System.out.println("Start generating...");

		String workspaceDireytory = "C:\\Users\\Max\\Desktop\\TestOrdner";
		String projectName = "testProject";

		ProjectGenerator generator = new ProjectGenerator(new PomCreator(new Pom("4.0.0", "de.nuerberger.test",
				"testProject", "0.0.1-SNAPSHOT", Packaging.WAR.value(), "test", "this is a test")));

		
		
		try {
			generator.generateProject(workspaceDireytory, projectName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}

}
