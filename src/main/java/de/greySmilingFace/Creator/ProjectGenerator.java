package de.greySmilingFace.Creator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectGenerator {

	private PomCreator creator;

	public ProjectGenerator(PomCreator creator) {
		this.creator = creator;
	}

	public void generateProject(String workspaceDirectory, String projectName) throws IOException {
		StringBuilder projectFolderBuilder = new StringBuilder();
		projectFolderBuilder.append(workspaceDirectory).append("\\").append(projectName);
		generateFolders(projectFolderBuilder.toString());

		StringBuilder srcMainJavaFolderBuilder = new StringBuilder();
		srcMainJavaFolderBuilder.append(projectFolderBuilder.toString()).append("\\src\\main\\java");
		generateFolders(srcMainJavaFolderBuilder.toString());

		StringBuilder srcMainResourcesBuilder = new StringBuilder();
		srcMainResourcesBuilder.append(projectFolderBuilder.toString()).append("\\src\\main\\resources");
		generateFolders(srcMainResourcesBuilder.toString());

		StringBuilder srcMainWebappBuilder = new StringBuilder();
		srcMainWebappBuilder.append(projectFolderBuilder.toString()).append("\\src\\main\\webapp");
		generateFolders(srcMainWebappBuilder.toString());

		StringBuilder srcTestJavaBuilder = new StringBuilder();
		srcTestJavaBuilder.append(projectFolderBuilder.toString()).append("\\src\\test\\java");
		generateFolders(srcTestJavaBuilder.toString());

		StringBuilder srcTestresourcesBuilder = new StringBuilder();
		srcTestresourcesBuilder.append(projectFolderBuilder.toString()).append("\\src\\test\\resources");
		generateFolders(srcTestresourcesBuilder.toString());

		creator.writeToFile(projectFolderBuilder.toString(), "pom.xml");
	}

	private static void generateFolders(String directory) {
		Path path = Paths.get(directory);
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
