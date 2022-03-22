package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if (position <0){
            System.out.println(oldContact + " contact not found");
            return false;
        }
        this.myContacts.set(position, newContact);
        System.out.println("Successfully updated");
        return true;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if (position <0){
            System.out.println(contact + " not found");
            return false;
        }
        this.myContacts.remove(contact);
        System.out.println("Successfully removed");
        return true;
    }

    public Contact queryContact(String nameOfContact){
        int position = findContact(nameOfContact);
        if (position < 0){
            System.out.println("Contact not found with the name " + nameOfContact);
            return null;
        }
        return this.myContacts.get(position);
    }

    public void printContacts(){
        System.out.println("Contact List");
        for (int i=0; i<myContacts.size(); i++){
            System.out.println("Name         : " + this.myContacts.get(i).getName());
            System.out.println("Phone Number : " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
}