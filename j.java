import java.util.*;

public class j {
    public static void main(String args[]){
      Horse h = new Horse();
      h.changeColor("White");   
      h.eat();
      h.walk();   
    }
}
abstract class Animal{
    String color;

    Animal(){
        System.out.println("Animal constructor called...");
    }

    void eat(){
        System.out.println("Animal eats...");
    }
    abstract void walk();
}
class Horse extends Animal{
    void changeColor(String newColor){
        color = newColor;
    }
    void walk(){
        System.out.println("Walking...");
    }
}

