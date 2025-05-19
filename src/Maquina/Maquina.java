package Maquina;

public class Maquina {
  private String nombre;
  private int piezas;

  public Maquina(String raw){
    processString(raw);
  }

  private void processString(String raw){
    String[] data = raw.split(",");

    nombre = data[0];
    piezas = Integer.parseInt(data[1].strip());
  }

  public String getNombre() {
    return nombre;
  }

  public int getPiezas() {
    return piezas;
  }

  public String toString(){
    return "["+nombre + ","+piezas+"]";
  }
}
