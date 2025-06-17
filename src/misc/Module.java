package misc;

import Maquina.Maquina;

public class Module implements Comparable<Module> {

  private int mod;
  private Maquina maquina;

  public Module(Maquina m){
    this.maquina = m;
  }
  
  @Override
  public int compareTo(Module other) {

    if (other == null) return -1;

    // Comparamos por modulo
    if (this.getMod() != other.getMod()) {
      return Integer.compare(this.getMod(), other.getMod());
    }

    // Si son el mismo módulo, -> par vs impar
    boolean thisEven = this.getValue() % 2 == 0;
    boolean otherEven = other.getValue() % 2 == 0;

    if (thisEven && !otherEven) return -1; // this es par, por lo tanto this es menor
    if (!thisEven && otherEven) return 1; // other es par, por lo tanto this es mayor

    // Ambos son pares -> mayor value es menor
    if (thisEven) {
      return Integer.compare(other.getValue(), this.getValue());
    }

    // Ambos son impares, el que vale 1 es mayor
    if (this.getValue() == 1) return 1;

    if (other.getValue() == 1) return -1;

    // Ambos son impares distintos a 1 -> menor value es menor
    return Integer.compare(this.getValue(), other.getValue());





  }

  public int getMod() {
    return mod;
  }

  public int getValue() {
    return this.maquina.getPiezas();
  }

  public void setMod(int mod) {
    this.mod = mod;
  }

  public void setModCalculated(int x){
    this.setMod(x % this.getValue());
  }

  public Maquina getMaquina(){
    return maquina;
  }

  public String toString(){
    return "Valor: "+this.getValue()+" Modulo: "+this.getMod();
  }
  
}
