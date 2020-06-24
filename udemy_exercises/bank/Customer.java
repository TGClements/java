package udemy_exercises.bank;

import java.util.*;

public class Customer {

    String name;
    ArrayList<Double> transList = new ArrayList<Double>();

    public Customer(String cName, double initialTransaction) {
        this.name = cName;
        this.transList.add(initialTransaction);

        System.out.println("New Customer Created: " + name);
    }
}

/*
 * - **Customer Class**: 
 * - Customer Name
 */
