package de.greySmilingFace.Creator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

import de.greySmilingFace.Object.SimpleEntity;

public class ProjectGenerator {

	private PomCreator pomCreator;
	private EntityCreator entityCreator = new EntityCreator();

	public ProjectGenerator(PomCreator creator) {
		this.pomCreator = creator;
	}

	public void generateProject(String workspaceDirectory, String projectName, List<SimpleEntity> entities,
			String groupId) throws IOException {
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
		pomCreator.writeToFile(projectFolderBuilder.toString(), "pom.xml");

		String temp = projectFolderBuilder.toString() + "\\src\\main\\java";
		for (String groupIdPathPart : getPathForSources(groupId)) {
			temp = temp + "\\" + groupIdPathPart;
			generateFolders(temp);
		}
		for (SimpleEntity simpleEntity : entities) {
			String entityPath = temp + "\\" + simpleEntity.getName() + "\\entities";
			generateFolders(entityPath);
			generateFolders(temp + "\\" + simpleEntity.getName() + "\\boundary");
			String fileName = simpleEntity.getName() + ".java";
			entityCreator.writeEntities(simpleEntity, groupId, entityPath, fileName);
		}
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

	private static String[] getPathForSources(String groupId) {
		String[] segs = groupId.split(Pattern.quote("."));
		return segs;
	}

}
