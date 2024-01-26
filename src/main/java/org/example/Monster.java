package org.example;

public class Monster {
    private String name;
    private String type;
    private String attribute;
    private int star;

    public Monster(String name, String attribute, String type, int star){
        this.name = name;
        this.attribute = attribute;
        this.type = type;
        this.star = star;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public String getAttribute(){
        return this.attribute;
    }
    public int getStar(){
        return this.star;
    }

    public String toString(){
        return "Monster Data -> Name: " + this.name + " Type: " + this.type + " Star: " + this.star + " Attribute: " + this.attribute + "\n";
    }

}
