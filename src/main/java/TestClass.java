
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestClass {

	public static void main(String[] args) {

		try {
			Pom pom = new Pom("4.0.0", "de.nuerberger.test", "testProject", "0.0.1-SNAPSHOT", Packaging.WAR.value(),
					"test", "this is a test");
			generateFolders("C:\\Users\\B069448\\Desktop\\Neuer Ordner\\Sub2\\Sub-Sub2");
			writeToFile("C:\\Users\\B069448\\Desktop\\Neuer Ordner\\Sub2\\Sub-Sub2", "pom.xml", pom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String setContentToPom(Pom pomContent) {
		StringBuilder builder = new StringBuilder();
		builder.append("<project xmlns=\"").append("http://maven.apache.org/POM/4.0.0").append("\" xmlns:xsi=\"")
				.append("http://www.w3.org/2001/XMLSchema-instance").append("\"\n") //
				.append("xsi:schemaLocation=\"")
				.append("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd").append("\">\n") //
				.append("<modelVersion>").append(pomContent.getModelVersion()).append("</modelVersion>\n") //
				.append("<groupId>").append(pomContent.getGroupId()).append("</groupId>\n") //
				.append("<artifactId>").append(pomContent.getArtifactId()).append("</artifactId>\n") //
				.append("<version>").append(pomContent.getVersion()).append("</version>\n") //
				.append("<packaging>").append(pomContent.getPackaging()).append("</packaging>\n") //
				.append("<name>").append(pomContent.getName()).append("</name>\n")//
				.append("<description>").append(pomContent.getDescription()).append("</description>\n") //
				.append("<properties>\n").append("<failOnMissingWebXml>false</failOnMissingWebXml>\n")
				.append("</properties>\n") //
				.append("</project>");
		return builder.toString();
	}

	public static void writeToFile(String path, String fileName, Pom pomContent) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\" + fileName));
		writer.write(setContentToPom(pomContent));
		writer.close();
	}

	/**
	 * 
	 * @param directory
	 *            Path were Folders are generated to
	 */
	public static void generateFolders(String directory) {
		Path path = Paths.get(directory);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}

	}

}
