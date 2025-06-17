package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import misc.Module;

import Maquina.Maquina;

public class Greedy {

  private static int contadorCandidatos = 0;

  public static void run(int objetivo, List<Maquina> maquinas) {

    ArrayList<Maquina> solucion = new ArrayList<>();

    // Setteando el ArrayList de modulos para ordenar mejor y simplemente hacer
    // get(0) para obtener el mejor candidato
    ArrayList<Module> modules = new ArrayList<>();
    for (Maquina maquina : maquinas) {
      Module mod = new Module(maquina);
      modules.add(mod);
    }

    int objetivoCopia = objetivo;

    while (objetivoCopia > 0) {
      for (Module module : modules) {
        module.setModCalculated(objetivoCopia);
      }

      Collections.sort(modules);

      Module selected = modules.get(0);
      contadorCandidatos++;
      solucion.add(selected.getMaquina());
      objetivoCopia -= selected.getValue();
    }

    System.out.println("");
    System.out.println("Greedy");
    System.out.print("Secuencia obtenida: ");
    boolean huboSolucion = objetivo + objetivoCopia == objetivo;
    if (huboSolucion) {
      for (Maquina maquina : solucion) {
        System.out.print(maquina.getNombre() + " ");
      }
    }else{
      System.out.print("Sin solución");  
    }
    System.out.println("");
    System.out.println("Solución obtenida: \n- Piezas producidas: " + (huboSolucion ? objetivo : 0)
        + " \n- Puestas en funcionamiento: " + solucion.size());
    System.out.println("Cantidad de estados generados: " + contadorCandidatos);
  }

}
