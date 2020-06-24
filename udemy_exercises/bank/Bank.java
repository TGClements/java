package udemy_exercises.bank;

import java.util.*;

public class Bank {

  ArrayList<Branch> branchList = new ArrayList<Branch>();
  Scanner s, sc;

  public void menu() {

    s = new Scanner(System.in);
    sc = new Scanner(System.in);
    int option = 0;

    while (option != 99) {

      System.out.println("\nPlease enter in an option from the menu:");
      System.out.println(
          "\t1. Add Branch\n\t2. Add Customer to Branch\n\t3. Add Transaction for Customer in a Branch\n\t4. Show Branches\n\t5. Show Branch Customers\n\t99. Quit");

      option = s.nextInt();

      switch (option) {

        case 1:
          System.out.println("\n");
          addBranch();

          break;

        case 2:
          System.out.println("\n");
          addCustToBranch();
          break;

        case 3:
          System.out.println("\n");
          addTransToCustForBranch();
          break;

        case 4:
          System.out.println("\n");
          showBranches();
          break;

        case 5:
          System.out.println("\n");
          showBranchCustomers();
          break;

        case 99:
          break;

        default:
          System.out.println("\n");
          System.out.println("Please enter a valid option.");
          System.out.println("\n");
      }
    }

    closeScanners();
  }

  void addBranch() {

    System.out.print("Please enter in a new branch name: ");

    String bName = sc.nextLine();

    // Only allow unique branches to be created - will make it much easier for later operations.
    if (!branchExists(bName)) {
      branchList.add(new Branch(bName));
    } else {
      System.out.println("Branch already exists. Please enter a unique branch name.\n");
      addBranch();
    }

  }

  void addCustToBranch() {

    System.out.print("Please enter in the branch name for the new Customer: ");
    String bName = sc.nextLine();

    try {
      branchList.get(getBranchIndex(bName)).addCustomer();
    } catch (IndexOutOfBoundsException ibe) {
      System.out.println("Requested branch does not exist.");
    }
  }

  void addTransToCustForBranch() {

    System.out.print("Please enter the Customer Name to create a new transaction for: ");
    String cName = sc.nextLine();

    int index = findCustomer(cName);

    if (index == -1) {
      System.out.println("Requested Customer does not exist - Cannot create a new transaction. Please try again.");
    } else {
      branchList.get(index).addTransaction(cName);
    }
  }

  void showBranchCustomers() {

    System.out.print("Please enter in the name of the Branch to display Customers from: ");
    String bName = sc.nextLine();

    try {
      for (Customer c : branchList.get(getBranchIndex(bName)).customerList) { // For each customer in the selected branch's customer list
        System.out.println(c.name);
      }
    } catch (IndexOutOfBoundsException ibe) {
      System.out.println("Requested branch does not exist.");
    }

  }

  void showBranches() {

    // Print all the branches in branchlist
    for (Branch b : branchList) {
      System.out.println(b.name);
    }
  }

  int getBranchIndex(String branchName) {

    int index = -1;

    for (int i = 0; i < branchList.size(); i++) {
      if (branchList.get(i).name.equals(branchName)) {
        index = i;
      }
    }

    return index;
  }

  boolean branchExists(String branchName) {

    boolean result = false;

    // Iterate thru branchlist to check if the entered name already exists.
    for (Branch b : branchList) {
      result = b.name.equals(branchName) ? true : false;
    }

    return result;
  }

  int findCustomer(String customerName) {

    for (int i = 0; i < branchList.size(); i++) {
      for (Customer c : branchList.get(i).customerList) {
        if (c.name.equals(customerName))
          return i;
      }
    }

    return -1;
  }

  // Close all scanners used
  void closeScanners() {

    s.close();
    sc.close();

    for (Branch b : branchList) {
      b.closeScanners();
    }
  }

  public static void main(String args[]) {

    Bank myBank = new Bank();

    myBank.menu();
  }

}

/*
**Banking w/ Java Classes**
   - **Bank class**
      - List of Branches
      - Add a new branch
      - Add a customer to that branch with initial transaction
      - Add a transaction for an existing customer for that branch
      - Show a list of customers for a particular branch and optionally a list of their transactions
   - Demonstration autoboxing and unboxing in your code
   - Think about where you are adding the code to perform certain actions
   - **Branch class**
     - List of Customers
     - List of Transactions
   - **Customer Class**:
     - Customer Name
   - **Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
   - **Bank:**
     
*/