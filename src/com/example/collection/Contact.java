package com.example.collection;
import java.util.ArrayList;

public class Contact {
    private String name ;
    private String number ;
    private ArrayList<Message> messages;


    public void getDetails(){
        System.out.println("NAME : " + name + 
        "\nNUMBER : " + number + 
        "\n MESSAGE : " + messages.size() +
        "\n**************");
    }

    public void addMessage(Message message){
        messages.add(message);
    }
    public Contact(String name, String number, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.messages = messages;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}
