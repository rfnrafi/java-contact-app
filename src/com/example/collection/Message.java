package com.example.collection;

public class Message {
    private String text;
    private String to ;
    private String from ;
    private int id ;
    
    public Message(String text, String to, String from, int id) {
        this.text = text;
        this.to = to;
        this.from = from;
        this.id = id;
    }

    public void getDetails(){
        System.out.println(
        "******************************************************\n"    
        +"TO : " + to + 
        "\nMessage : " + text +
        "\nid : " + id +
        "\nFROM : " + from +
        "\n******************************************************" );
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
