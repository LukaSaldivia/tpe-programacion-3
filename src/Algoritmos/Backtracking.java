package Algoritmos;

import java.util.ArrayList;
import java.util.List;

import Maquina.Maquina;

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
      System.out.println("Solución obtenida: "+solucion);
      System.out.println("Solución obtenida: \n- Piezas producidas: "+ (solucion.size() > 0 ? objetivo : 0) +" \n- Puestas en funcionamiento: "+solucion.size());
      System.out.println("Cantidad de estados generados: "+contadorEstados);
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
