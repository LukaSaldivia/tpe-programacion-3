import Algoritmos.Backtracking;
import Algoritmos.Greedy;
import FileManager.FileManager;

public class App {

  public static void main(String[] args) {
    FileManager FM = new FileManager();

    FM.processFile();

    System.out.println("\n---- Encendidos eficientes SA ----");
    System.out.println("Piezas requeridas: "+FM.getPiezasTotales());
    System.out.println("Máquinas disponibles: "+FM.getMaquinas());

    Backtracking.run(FM.getPiezasTotales(), FM.getMaquinas());
    Greedy.run(FM.getPiezasTotales(), FM.getMaquinas());
    System.out.println("\n----------------------------------");
    System.out.println("");
  }
  
}