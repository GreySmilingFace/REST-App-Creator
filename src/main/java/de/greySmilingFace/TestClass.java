package de.greySmilingFace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.greySmilingFace.Creator.PomCreator;
import de.greySmilingFace.Creator.ProjectGenerator;
import de.greySmilingFace.Object.EntityAttribute;
import de.greySmilingFace.Object.Packaging;
import de.greySmilingFace.Object.Pom;
import de.greySmilingFace.Object.SimpleEntity;

public class TestClass {

	public static void main(String[] args) {

		System.out.println("Start generating...");

		String workspaceDireytory = "C:\\Users\\B069448\\Desktop\\TestOrdner";
		String projectName = "testProject";

		Pom pom = new Pom("4.0.0", "de.nuerberger.test", "testProject", "0.0.1-SNAPSHOT", Packaging.WAR.value(), "test",
				"this is a test");
		ProjectGenerator generator = new ProjectGenerator(new PomCreator(pom));

		List<SimpleEntity> list = new ArrayList<SimpleEntity>();
		List<EntityAttribute> peopleAttr = new ArrayList<EntityAttribute>();
		List<EntityAttribute> houseAttr = new ArrayList<EntityAttribute>();
		List<EntityAttribute> carAttr = new ArrayList<EntityAttribute>();

		peopleAttr.add(new EntityAttribute("name", "String"));
		peopleAttr.add(new EntityAttribute("forename", "String"));
		peopleAttr.add(new EntityAttribute("age", "int"));

		houseAttr.add(new EntityAttribute("color", "String"));
		houseAttr.add(new EntityAttribute("adress", "String"));
		houseAttr.add(new EntityAttribute("number", "int"));

		carAttr.add(new EntityAttribute("color", "String"));
		carAttr.add(new EntityAttribute("name", "String"));

		list.add(new SimpleEntity("People", peopleAttr));
		list.add(new SimpleEntity("House", houseAttr));
		list.add(new SimpleEntity("Car", carAttr));

		try {
			generator.generateProject(workspaceDireytory, projectName, list, pom.getGroupId());
		} catch (IOException e) {

		}

		System.out.println("Finished");
	}

}
