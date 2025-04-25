package models;

public class SalaryAccount extends Account{

    public SalaryAccount(){
      super();
    }

    @Override
    public boolean deposit(double valor) {
        throw new IllegalCallerException("nao pode depositar em conta salario");
    }

    @Override
    public boolean withdraw(double valor) {
      throw new IllegalCallerException("nao pode sacar em conta salario");
    }
}
