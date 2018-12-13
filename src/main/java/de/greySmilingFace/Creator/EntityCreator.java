package de.greySmilingFace.Creator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import de.greySmilingFace.Object.EntityAttribute;
import de.greySmilingFace.Object.SimpleEntity;

public class EntityCreator {

	public EntityCreator() {
	}

	public void writeEntities(SimpleEntity entity, String groupId, String path, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\" + fileName));
		writer.write(generateEntitySource(entity, groupId));
		writer.close();
	}

	private String generateEntitySource(SimpleEntity entity, String groupId) {
		StringBuilder builder = new StringBuilder();
		builder.append("package ").append(groupId).append(".").append(entity.getName()).append(".entities;\n\n") //
				.append("public class ").append(entity.getName()).append(" {\n\n"); //
		for (EntityAttribute attr : entity.getAttributes()) {
			builder.append("private ").append(attr.getAttributeType()).append(" ").append(attr.getAttributeName())
					.append(";\n");
		}
		builder.append("\n") //
				.append("public ").append(entity.getName()).append("(");
		for (int i = 0; i < entity.getAttributes().size(); i++) {
			if (i == entity.getAttributes().size() - 1) {
				builder.append(entity.getAttributes().get(i).getAttributeType()).append(" ")
						.append(entity.getAttributes().get(i).getAttributeName()).append(") {\n");
			} else {
				builder.append(entity.getAttributes().get(i).getAttributeType()).append(" ")
						.append(entity.getAttributes().get(i).getAttributeName()).append(", ");
			}
		}

		for (EntityAttribute attr : entity.getAttributes()) {
			builder.append("this.").append(attr.getAttributeName()).append(" = ").append(attr.getAttributeName())
					.append(";\n");
		}

		builder.append("}\n\n");

		for (EntityAttribute attr : entity.getAttributes()) {

			String temp = attr.getAttributeName();
			String functionName = "" + temp.charAt(0);
			functionName = functionName.toUpperCase();
			functionName = functionName + temp.substring(1);

			builder.append("public ").append(attr.getAttributeType()).append(" get").append(functionName)
					.append("() {\n") //
					.append("return ").append(attr.getAttributeName()).append(";\n") //
					.append("}\n\n");

			builder.append("public void set").append(functionName).append("(").append(attr.getAttributeType())
					.append(" ").append(attr.getAttributeName()).append(") {\n") //
					.append("this.").append(attr.getAttributeName()).append(" = ").append(attr.getAttributeName())
					.append(";\n") //
					.append("}\n\n");
		}
		
		return builder.toString();
	}

}
