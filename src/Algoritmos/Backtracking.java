package Algoritmos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Maquina.Maquina;
import misc.Solucion;

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
 * Restricciones aplicadas:
 * - Si la suma acumulada supera el objetivo, se corta la búsqueda.
 * - Si la cantidad de máquinas en 'parcial' ya supera o iguala a la mejor solución encontrada hasta ahora, se corta.
 *
 * Podas:
 * - No se consideran máquinas pasadas para evitar repeticiones debido a la conmutatividad de la suma.
 * - No se consideran máquinas que sumen la misma cantidad de piezas que la actual.
 *
 * Métrica adicional:
 * - Se cuenta la cantidad de estados generados durante el recorrido (variable 'contadorEstados').
 */
public class Backtracking implements Solucion {
  private int contadorEstados = 0, piezasProducidas = 0;
  private ArrayList<Maquina> solucion;

  public Backtracking() {
    solucion = new ArrayList<>();
  }

  public void run(int objetivo, List<Maquina> maquinas) {
    ArrayList<Maquina> parcial = new ArrayList<>();
    HashSet<Integer> piezasRecorridas = new HashSet<>();

    for (int i = 0; i < maquinas.size(); i++) {
      Maquina m = maquinas.get(i);
      if (piezasRecorridas.contains(m.getPiezas()))
      continue;

      piezasRecorridas.add(m.getPiezas());
      
      parcial.add(m);
      visit(maquinas, solucion, parcial, i, objetivo, m.getPiezas());
      contadorEstados++;
      parcial.remove(m);
    }
  }

  private void visit(List<Maquina> maquinas, List<Maquina> solucion, List<Maquina> parcial, int index,
      int objetivo, int sumaAcumulada) {

    if (sumaAcumulada > objetivo || (!solucion.isEmpty() && parcial.size() >= solucion.size())) {
      return;
    }

    if (sumaAcumulada == objetivo) {
      if (parcial.size() < solucion.size() || solucion.isEmpty()) {
        solucion.clear();
        solucion.addAll(parcial);
        piezasProducidas = objetivo;
      }
      return;
    } else {
      for (int i = index; i < maquinas.size(); i++) {
        Maquina next = maquinas.get(i);
        if (maquinas.get(index).getPiezas() == maquinas.get(i).getPiezas() && i != index)
          continue;

        parcial.add(next);
        visit(maquinas, solucion, parcial, i, objetivo, sumaAcumulada + next.getPiezas());
        this.contadorEstados++;
        parcial.remove(next);
      }
    }

  }

  @Override
  public int getCantidadDeEstadosGenerados() {
    return contadorEstados;
  }

  @Override
  public int getPiezasProducidas() {
    return piezasProducidas;
  }

  @Override
  public int getPuestasEnFuncionamiento() {
    return solucion.size();
  }

  @Override
  public String getSecuencia() {
    String res = "";
    if (solucion.size() > 0) {
      for (Maquina maquina : solucion) {
        res += maquina.getNombre() + " ";
      }
    } else {
      res = "Sin solución";
    }

    return res;
  }
}
