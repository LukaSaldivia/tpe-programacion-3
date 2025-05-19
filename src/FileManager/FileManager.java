package FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import Maquina.Maquina;

public class FileManager {

  private Path inputDir = Paths.get("input"), processedDir = Paths.get("processed");
  private int piezas;
  private List<Maquina> maquinas;

  public FileManager() {
    maquinas = new ArrayList<Maquina>();

  }

  public void processFile() {

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(inputDir)) {

      for (Path archivo : stream) {

        if (!Files.isRegularFile(archivo))
        continue;

        if (archivo.getFileName().toString().equals(".gitkeep"))
        continue;


        // Leer línea por línea
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {
          String linea;
          boolean seLeyoLaPrimera = false;
          while ((linea = reader.readLine()) != null) {

            if (!seLeyoLaPrimera) {
              piezas = Integer.parseInt(linea);
              seLeyoLaPrimera = true;
              continue;
            }

            maquinas.add(new Maquina(linea));

          }

          // break;
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");

        String fechaFormateada = ahora.format(formato);
        Path destino = processedDir.resolve(fechaFormateada);
        Files.move(archivo, destino, StandardCopyOption.REPLACE_EXISTING);

        break;

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public List<Maquina> getMaquinas() {
    return new ArrayList<Maquina>(maquinas);
  }

  public int getPiezasTotales() {
    return piezas;
  }

}
