import Algoritmos.Backtracking;
import Algoritmos.Greedy;
import FileManager.FileManager;

public class App {

  public static void main(String[] args) {
    FileManager FM = new FileManager();

    FM.processFile();

    System.out.println(FM.getPiezasTotales());
    System.out.println(FM.getMaquinas());

    Backtracking.run(FM.getPiezasTotales(), FM.getMaquinas());
    
    Greedy.run(FM.getPiezasTotales(), FM.getMaquinas());
  }

}