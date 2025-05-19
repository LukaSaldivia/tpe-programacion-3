import FileManager.FileManager;

public class App {

  public static void main(String[] args) {
    FileManager FM = new FileManager();

    FM.processFile();

    System.out.println(FM.getPiezasTotales());
    System.out.println(FM.getMaquinas());
  }

  
}