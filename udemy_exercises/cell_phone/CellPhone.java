package udemy_exercises.cell_phone;

import java.util.*;

class CellPhone {

  Scanner s;
  Scanner sc;
  ArrayList<Contact> contactList = new ArrayList<Contact>();

  public void menu() {

    s = new Scanner(System.in);
    sc = new Scanner(System.in);
    int option = 0;

    while (option != 99) {

      System.out.println("Please enter in an option from the menu:");
      System.out.println(
          "\t1. Show Contacts\n\t2. Add Contact\n\t3. Update Contact\n\t4. Remove Contact \n\t5. Search Contact\n\t99. Quit");

      option = s.nextInt();

      switch (option) {

        case 1:
          System.out.println("\n");
          showContacts();
          break;

        case 2:
          System.out.println("\n");
          addContact();
          break;

        case 3:
          System.out.println("\n");
          updateContact();
          System.out.println("\n");
          break;

        case 4:
          System.out.println("\n");
          removeContact();
          System.out.println("\n");
          break;

        case 5:
          System.out.println("\n");
          searchContact();
          break;

        case 99:
          break;

        default:
          System.out.println("\n");
          System.out.println("Please enter a valid option.");
          System.out.println("\n");
      }
    }

    s.close();
    sc.close();
  }

  public void showContacts() {

    System.out.println("Contact List:");
    for (int i = 0; i < contactList.size(); i++) {
      System.out.println(contactList.get(i).name + "\t\t" + contactList.get(i).phNum);
    }

    System.out.println("\n");
  }

  public void addContact() {

    System.out.print("Enter the Name: ");
    String name = sc.nextLine();

    System.out.print("Enter the number (ex. 1234567890): ");
    long number = s.nextLong();

    Contact c = new Contact(name, number);

    contactList.add(c);
    System.out.println("Contact added!\n");
  }

  public void updateContact() {

    System.out.print("Enter the full name of the contact to be updated: ");
    String searchName = sc.nextLine();

    for (int i = 0; i < contactList.size(); i++) {
      if (contactList.get(i).name.equals(searchName)) {
        System.out.println("\n" + contactList.get(i).name + "\t\t" + contactList.get(i).phNum);
        System.out.print("Enter new name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter new number: ");
        long number1 = s.nextLong();

        Contact c = new Contact(name1, number1);

        contactList.set(i, c);
        break;
      }
    }
  }

  public void removeContact() {
    System.out.print("Enter the full name of the contact to be deleted: ");
    String searchName = sc.nextLine();

    for (int i = 0; i < contactList.size(); i++) {
      if (contactList.get(i).name.equals(searchName)) {
        contactList.remove(i);
        break;
      }
    }
  }

  public void searchContact() {

    int count = 0;

    System.out.print("Enter the Name to search for: ");
    String searchName = sc.nextLine();

    for (int i = 0; i < contactList.size(); i++) {
      if (contactList.get(i).name.contains(searchName)) {
        System.out.println("\n" + contactList.get(i).name + "\t\t" + contactList.get(i).phNum);
        count++;
      }
    }

    System.out.println("\n" + count + " Result(s) Found\n");
  }

  public static void main(String args[]) {

    CellPhone cp1 = new CellPhone();

    cp1.menu();
  }

}

/*
**Cell Phone with Java Classes**
    - **CellPhone Class:**
        - Contact List
        - quit()
        - showContacts()
        - addContact()
        - updateContat()
        - removeContact()
        - searchContact()
      * **When adding or updating be sure to check if the contact already exists**
      * **Be sure not to expose the inner workings of the Arraylist to MobilePhone (use concepts of encapsulation to meet this requirement)**
*/
