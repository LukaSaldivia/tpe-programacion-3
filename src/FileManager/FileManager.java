package FileManager;

import java.io.*;
import java.nio.file.*;

public class FileManager {
  private FileReader fr;
  private FileWriter fw;

  private Path inputDir = Paths.get("input"), processedDir = Paths.get("processed");

  public FileManager() {

  }

  public void s() {
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(inputDir)) {
      for (Path file : stream) {
        if (Files.isRegularFile(file)) {
          Path targetPath = processedDir.resolve(file.getFileName());

          // System.out.println(targetPath);

          // Mover el archivo
          Files.move(file, targetPath, StandardCopyOption.REPLACE_EXISTING);

          System.out.println("Archivo movido: " + file.getFileName());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
