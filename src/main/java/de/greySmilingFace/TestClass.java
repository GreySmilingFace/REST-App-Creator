package de.greySmilingFace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.greySmilingFace.Creator.PomCreator;
import de.greySmilingFace.Creator.ProjectGenerator;
import de.greySmilingFace.Object.Packaging;
import de.greySmilingFace.Object.Pom;
import de.greySmilingFace.Object.SimpleEntity;

public class TestClass {

	public static void main(String[] args) {

		System.out.println("Start generating...");

		List<SimpleEntity> list = new ArrayList<SimpleEntity>();
		list.add(new SimpleEntity("test1", null));
		list.add(new SimpleEntity("test2", null));
		list.add(new SimpleEntity("test3", null));

		String workspaceDireytory = "C:\\Users\\Max\\Desktop\\TestOrdner";
		String projectName = "testProject";

		Pom pom = new Pom("4.0.0", "de.nuerberger.test", "testProject", "0.0.1-SNAPSHOT", Packaging.WAR.value(), "test",
				"this is a test");

		ProjectGenerator generator = new ProjectGenerator(new PomCreator(pom));

		try {
			generator.generateProject(workspaceDireytory, projectName, list, pom.getGroupId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");
	}

}
