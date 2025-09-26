package br.edu.idp.cc.poo.payable;

public interface Payable {
    double getPaymentAmount();

    default String metodoDefault(){
        return "Usando implementação default da interface";
    }
}
