package udemy_exercises.bank;

import java.util.*;

public class Branch {

    String name;
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    Scanner s = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);

    public Branch(String name) {
        this.name = name;
        System.out.println(this.name + " Branch Created!");
    }

    public void addCustomer() {

        System.out.print("Please enter the name of the customer:\t");
        String custName = s.nextLine();

        System.out.print("Please enter an initial transaction:\t");
        double transaction = sc.nextDouble();

        if (transaction <= 0) {
            System.out.println(
                    "Initial transaction cannot be less than or equal to 0. Please enter a valid transaction.");
            addCustomer();
        } else {
            // Add customer if the customer does not already exist
            if (custExists(custName)) {
                System.out.println("Customer already exists. Please add a unique Customer.");
            } else {
                customerList.add(new Customer(custName, transaction));
            }
        }
    }

    public void addTransaction(String custName) {

        System.out.print("Enter new transaction: ");
        double transaction = sc.nextDouble();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).name.equals(custName)) {
                customerList.get(i).transList.add(transaction);
                System.out.println("Transaction added!");
            }
        }
    }

    private boolean custExists(String custName) {

        for (Customer cust : customerList) {
            if (cust.name.equals(custName)) {
                return true;
            }
        }
        return false;
    }

    public void closeScanners() {
        s.close();
        sc.close();
    }
}

/*
 ** Branch Class**: 
 - addCustomer and initial transaction amount. 
 - Also needs to
 * add additional transactions for that customer/branch
 */
