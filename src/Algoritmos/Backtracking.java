package Algoritmos;

import java.util.ArrayList;
import java.util.List;

import Maquina.Maquina;

/*
 * Algoritmo Backtracking:
 *
 * Estrategia general:
 * - Se busca una combinación de máquinas cuya suma total de piezas sea exactamente igual al objetivo.
 * - Cada estado representa una selección parcial de máquinas (lista 'parcial').
 * - El objetivo es encontrar la combinación válida con la menor cantidad de máquinas.
 * 
 * Generación de estados:
 * - En cada paso se considera agregar una nueva máquina desde la posición actual en adelante.
 * - Se realiza una llamada recursiva por cada posibilidad.
 *
 * Soluciones válidas:
 * - Un estado es solución si la suma de piezas de la lista 'parcial' es igual al objetivo.
 * - Se guarda como mejor solución si usa menos máquinas que la anterior (o si no había ninguna).
 *
 * Podas aplicadas:
 * - Si la suma acumulada supera el objetivo, se corta la búsqueda.
 * - Si la cantidad de máquinas en 'parcial' ya supera o iguala a la mejor solución encontrada hasta ahora, se corta.
 *
 * Métrica adicional:
 * - Se cuenta la cantidad de estados generados durante el recorrido (variable 'contadorEstados').
 */
public class Backtracking {
  private static int contadorEstados = 0;

  public static void run(int objetivo, List<Maquina> maquinas) {
    ArrayList<Maquina> solucion = new ArrayList<>(), parcial = new ArrayList<>();

    for (int i = 0; i < maquinas.size(); i++) {
      Maquina m = maquinas.get(i);
      parcial.add(m);
      visit(maquinas, solucion, parcial, i, objetivo);
      contadorEstados++;
      parcial.remove(m);
    }

    System.out.println("\nBacktracking");
    System.out.print("Secuencia obtenida: ");
    if (solucion.size() > 0) { 
      for (Maquina maquina : solucion) {
        System.out.print(maquina.getNombre() + " ");
      }
    }else{
      System.out.print("Sin solución");
    }
    System.out.println("");
    System.out.println("Solución obtenida: \n- Piezas producidas: " + (solucion.size() > 0 ? objetivo : 0)
        + " \n- Puestas en funcionamiento: " + solucion.size());
    System.out.println("Cantidad de estados generados: " + contadorEstados);
  }

  private static List<Maquina> visit(List<Maquina> maquinas, List<Maquina> solucion, List<Maquina> parcial, int index,
      int objetivo) {

    int sumaAcumulada = getSuma(parcial);

    if (sumaAcumulada > objetivo || (!solucion.isEmpty() && parcial.size() >= solucion.size())) {
      return solucion;
    }

    if (sumaAcumulada == objetivo) {
      if (parcial.size() < solucion.size() || solucion.isEmpty()) {
        solucion.clear();
        solucion.addAll(parcial);
      }
    } else {
      for (int i = 0; i < maquinas.size() - index; i++) {
        Maquina next = maquinas.get(index + i);
        parcial.add(next);
        visit(maquinas, solucion, parcial, index + i, objetivo);
        contadorEstados++;
        parcial.remove(next);
      }
    }
    return solucion;
  }

  private static int getSuma(List<Maquina> parcial) {
    int suma = 0;

    for (Maquina maquina : parcial) {
      suma += maquina.getPiezas();
    }

    return suma;
  }
}
