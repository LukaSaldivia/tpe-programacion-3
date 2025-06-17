package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import misc.Module;

import Maquina.Maquina;

/*
 * Algoritmo Greedy:
 *
 * Estrategia general:
 * - El objetivo es alcanzar exactamente una cantidad de piezas (objetivo) utilizando máquinas.
 * - En cada paso se selecciona la "mejor" máquina según un criterio voraz implementado en la clase Module.
 * - Se continúa agregando máquinas hasta alcanzar el objetivo (o hasta pasarse, si no hay solución exacta).
 *
 * Candidatos:
 * - Cada máquina se representa como un "Module", que calcula el módulo entre las piezas restantes y la cantidad que produce.
 * - Esto permite elegir máquinas que se ajusten mejor al número restante de piezas.
 *
 * Criterio de selección (ver clase Module):
 * - Se prioriza el menor módulo respecto a las piezas restantes.
 * - Si hay empate en el módulo:
 *    - Se prefiere par sobre impar.
 *    - Entre pares, se prefiere el de mayor valor.
 *    - Entre impares:
 *       - Se evita elegir máquinas que producen exactamente 1 (último recurso).
 *       - Se prefiere el de menor valor.
 * 
 * Construcción de la solución:
 * - Se elige en cada iteración el mejor módulo (máquina) según este orden.
 * - Se resta su valor del objetivo restante y se repite hasta llegar a 0.
 *
 * Solución válida:
 * - Si se alcanza exactamente el objetivo, se imprime la secuencia de máquinas usadas.
 * - No se garantiza optimalidad; puede usar más máquinas que una solución exacta con backtracking.
 *
 * Métrica adicional:
 * - Se cuenta cuántos candidatos se consideraron en total (contadorCandidatos).
 */

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
    System.out.println("Cantidad de candidatos considerados: " + contadorCandidatos);
  }

}
