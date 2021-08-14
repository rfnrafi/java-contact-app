package com.example.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static int id ;
    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        showOption();
            
    }
    public static void showOption(){
        System.out.println("************************************");
        System.out.println("SELECT AN OPTION : " + 
           "\n\t1.MANAGE CONTACT" + 
            "\n\t2.SEND A MASSAGE" +
            "\n\t3.EXIT");
            System.out.println("************************************");
            int choose = scanner.nextInt();
            switch(choose){
                case 1 : 
                    manageContact();
                    break ;
                case 2 :
                    sendMassage();
                    break;
                default:
                    break;
            }

    }

    public static void manageContact(){
        System.out.println("************************************");
        System.out.println("CHOOSE AN OPTION : "
        + "\n\t1.SHOW ALL CONTACT"
        + "\n\t2.ADD CONTACT"
        + "\n\t3.REMOVE CONTACT"
        + "\n\t4.SHOW MASSAGE ON SELECTED CONTACT"
        + "\n\t5.BACK");
        System.out.println("************************************");

        int choose = scanner.nextInt();
        switch(choose){
            case 1:
                showAllContact();
                break;
            case 2:
                addContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                showSelectedMassage();
            default:
                showOption();
                break;
            
        }
    }

    public static void sendMassage(){
        
        if(contacts.size() < 2){
            System.out.println(
            "************************************\n"+
            "AT LEAST YOU MUST HAVE 2 CONTACT TO SEND MASSAGE"+
            "\n************************************");
            showOption();
            return;

        }

        
        
            
        System.out.println("FROM : ");
        String from = scanner.next();

        boolean isExist = false;
        for(Contact c : contacts){
           
            if(c.getName().equals(from)){
                isExist = true;
                System.out.println("************************************\n"    
                +"NAME FOUND" +
                "\n************************************");
            } 
        }

        if(!isExist){
            System.out.println("********* \nNAME NOT FOUND\n *********");
            sendMassage();
            return;
        }

        System.out.println("TO : ");
        String to = scanner.next();

        isExist = false;

        for(Contact c : contacts){
           
            if(c.getName().equals(to)){
                isExist = true;
                System.out.println("************************************\n"    
                +"NAME FOUND" +
                "\n************************************");
            } 
        }
    
        if(!isExist){
            System.out.println("********* \nNAME NOT FOUND\n *********");
            sendMassage();
            return;
        }

    
        System.out.println("TEXT TO SEND ");
        scanner.nextLine();
        String text = scanner.nextLine();
        id++;
        Message message = new Message(text, to, from, id);

        for(Contact c : contacts){
            if(c.getName().equals(to)){
                c.addMessage(message);
            } 
        }

        System.out.println("MESSAGE SENDED SUCCESS");
        showOption();
        return;

        
        
    }
    
    public static void showAllContact(){
        if(contacts.size()<1){
            System.out.println("YOU DOESNT HAVE ANY CONTACT");
            manageContact();
            return;
        }
        System.out.println("**************");
        for(Contact c :contacts){
            c.getDetails();
        }
        manageContact();
       return;
    }
    
    public static void addContact(){
        
        System.out.println("ENTER A NAME");
        String name = scanner.next();

        for(Contact c : contacts){
            if(c.getName().equals(name)){
                System.out.println("NAME IS ALREADY EXIST");
                addContact();
                return;
            }
        }

        System.out.println("************\n" +
        "ENTER A PHONE NUMBER");

        String number = scanner.next();

        for(Contact c : contacts){
            if(c.getNumber().equals(number)){
                System.out.println("NUMBER IS ALREADY EXIST");
                addContact();
                return;
            }
        }

        try{
            Contact contact = new Contact(name, number);

            contacts.add(contact);
            System.out.println("SUCCESS ADDED");
            showOption();
            return;
        }catch(Exception e){
            System.out.println("SOMETHING ERROR");
        }
        
    }

    public static void removeContact(){

        if(contacts.size()<1){
            System.out.println("YOU DOESNT HAVE ANY CONTACT");
            manageContact();
            return;
        }
        
        System.out.println("ENTER A NAME OR NUMBER");
        String nameOrNumber = scanner.next();

        boolean isExist = false;
        for(Contact c : contacts){
            if(c.getName().equals(nameOrNumber) || c.getNumber().equals(nameOrNumber)){
                contacts.remove(c);
                System.out.println("SUCCESS REMOVED");
                manageContact();
                return;
            }
        }

        if(!isExist){
            System.out.println("********* \nNAME OR NUMBER NOT FOUND\n *********");
            removeContact();
            return;
        }

    }

    public static void showSelectedMassage(){

        if(contacts.size()<1){
            System.out.println("YOU DOESNT HAVE ANY CONTACT");
            manageContact();
            return;
        }

        System.out.println("ENTER A NAME");
        String select = scanner.next();
        boolean isExist = false ;
        for(Contact c : contacts){
            if(c.getName().equals(select)){
                isExist = true;
                for(Message m : c.getMessages()){
                    m.getDetails();
                }
            }
        }

        if(!isExist){
            System.out.println("NAME OR NUMBER NOT FOUND");
            showSelectedMassage();
            return;
        }

        manageContact();
        return;

        

    }
}
