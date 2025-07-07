import Algoritmos.Backtracking;
import Algoritmos.Greedy;
import FileManager.FileManager;

public class App {

  public static void main(String[] args) {
    FileManager FM = new FileManager();

    FM.processFile();

    System.out.println("\n---- Encendidos eficientes SA ----");
    System.out.println("Piezas requeridas: " + FM.getPiezasTotales());
    System.out.println("Máquinas disponibles: " + FM.getMaquinas());

    Backtracking bk = new Backtracking();

    bk.run(FM.getPiezasTotales(), FM.getMaquinas());

    System.out.println("\nBacktracking");
    System.out.print("Secuencia obtenida: " + bk.getSecuencia());
    System.out.println("");
    System.out.println("Solución obtenida: \n- Piezas producidas: " + bk.getPiezasProducidas()
        + " \n- Puestas en funcionamiento: " + bk.getPuestasEnFuncionamiento());
    System.out.println("Cantidad de estados generados: " + bk.getCantidadDeEstadosGenerados());

    Greedy gd = new Greedy();

    gd.run(FM.getPiezasTotales(), FM.getMaquinas());

    System.out.println("");
    System.out.println("Greedy");
    System.out.print("Secuencia obtenida: " + gd.getSecuencia());
    System.out.println("");
    System.out.println("Solución obtenida: \n- Piezas producidas: " + gd.getPiezasProducidas()
        + " \n- Puestas en funcionamiento: " + gd.getPuestasEnFuncionamiento());
    System.out.println("Cantidad de candidatos considerados: " + gd.getCantidadDeEstadosGenerados());
    System.out.println("\n----------------------------------");
    System.out.println("");
  }

}