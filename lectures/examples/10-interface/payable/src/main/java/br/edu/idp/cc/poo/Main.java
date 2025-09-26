package br.edu.idp.cc.poo;

import br.edu.idp.cc.poo.payable.Payable;
import br.edu.idp.cc.poo.payable.Invoice;
import br.edu.idp.cc.poo.payable.SalariedEmployee;

public class Main {
    public static void main(String[] args) {

        Payable[] payableObjects = new Payable[] { 
            new Invoice("01234", "seat", 2, 375.00), 
            new Invoice("56789", "tire", 4, 79.95), 
            new SalariedEmployee("John", "Smith", "111-11-1111", 800.00), 
            new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00) 
        }; 

        System.out.println("Invoices and Employees processed polymorphically:"); 

        for (br.edu.idp.cc.poo.payable.Payable currentPayable : payableObjects) { 
            // output currentPayable and its appropriate payment amount 
            System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(), currentPayable.getPaymentAmount()); 
            System.out.println(currentPayable.metodoDefault());
        } 
    } 
} 
