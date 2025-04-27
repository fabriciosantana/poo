package models;

import java.time.LocalDateTime;

public class Transaction {
  double valor;
  String tipo;
  
  public String getTipo() {
    return tipo;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getValor() {
      return valor;
  }

  public void setValor(double valor) {
      this.valor = valor;
  }

  @Override
  public String toString() {
      return LocalDateTime.now() + " " + this.getTipo() + " " + this.getValor();
  }
}
