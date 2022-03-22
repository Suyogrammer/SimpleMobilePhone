package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone(" 122 122 1222");

    public static void main(String[] args) {

        boolean flag = false;
        startPhone();
        printActions();
        while (!flag){
            System.out.println(" Enter the action number: \r");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("\n Shutting down");
                    flag = true;
                    break;

                case 1:
                    addNewContact();
                    break;

                case 2:
                    updateContact();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    queryContact();
                    break;

                case 5:
                    printContacts();
                    break;

                case 6:
                    printActions();
                    break;

                default:
                    System.out.println("Action not in the list.");
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        Contact contact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(contact)){
            System.out.println("Name: " + name + " Number: " + number);
        }
        else{
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
        }
        else {
            System.out.println("Enter new contact: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new contact phone number: ");
            String newNumber = scanner.nextLine();
            Contact newContact = Contact.createContact(newName, newNumber);
            if (mobilePhone.updateContact(existingContact, newContact)){
                System.out.println("Contact updated");
            }
            else{
                System.out.println("Error while updating");
            }
        }
    }

    private static void removeContact(){
        System.out.println("Enter the contact you want to remove: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not in the list");
        }
        else if (mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully removed");
        }
        else{
            System.out.println("Error while removing");
        }
    }

    private static void queryContact(){
        System.out.println("Enter the name you want to query about: ");
        String name = scanner.nextLine();
        Contact queryContact = mobilePhone.queryContact(name);
        if (queryContact == null){
            System.out.println("Contact not found.");
        }
        else{
            System.out.println("Name: "+ queryContact.getName() + " Phone Number: "+ queryContact.getPhoneNumber());
        }
    }

    private static void printContacts(){
        mobilePhone.printContacts();
    }

    private static void startPhone(){
        System.out.println("Starting Phone......");
    }

    private static void printActions(){
        System.out.println("Action you can to perform");
        System.out.println("0 - Shutdown");
        System.out.println("1 - Add contact");
        System.out.println("2 - Update contact");
        System.out.println("3 - Remove contact");
        System.out.println("4 - Query contact");
        System.out.println("5 - Print contacts");
        System.out.println("6 - Print the list of available actions");
        System.out.println(" Choose the action you ant to perform ");
    }

}
