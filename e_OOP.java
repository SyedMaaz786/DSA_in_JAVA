import java.util.Arrays;

public class e_OOP {
    public static void main(String args[]) {

    // Pen myPen = new Pen();  //created an object named mypen
    // myPen.setColor("Black");  //Here we are using our obj we created . fnx we created and passing the values
    // System.out.println(myPen.getColor());  
    // myPen.setTip(5);  //obj . setter for assigning 
    // System.out.println(myPen.getTip());  //obj . getter for printing
    // myPen.setColor("Blue");
    // System.out.println(myPen.getColor());

    // Student stud = new Student();
    // stud.studName("Syed Maaz");
    // System.out.println(stud.username);  //In print statement we need to pass object.property 
    // stud.calcPerc(98, 96, 90);
    // System.out.println(stud.percentage);

    // BankAccount myAcc = new BankAccount();
    // myAcc.username = "Syed Maaz";
    // System.out.println(myAcc.username);
    // myAcc.setPassword("LionHeart");

    // Employee emp1 = new Employee(); //Where Employee() is the cons call
    // Employee emp2 = new Employee("Syed");
    // Employee emp3 = new Employee(167);
    // Employee e1 = new Employee();
    // e1.name = "Syed";
    // e1.empId = 123;
    // e1.password = "abc";
    // e1.salary[0] = 50000;
    // e1.salary[1] = 80000;
    
    // Employee e2 = new Employee(e1);  //here we are passing e1 object as the parametere in the new e2 obj simply copying constructor values in e2
    // e2.password = "xyz"; //here e2 will be changed but not e1 as it is pass by value
    // System.out.println(e1.password);
    // e2.salary[1] = 100000; //this is[] which is passed as reference so changes in this will reflect int he original arr as well
    // System.out.println(e1.salary[1]);

    // Fish shark = new Fish();
    // shark.eat();

    // Dog husky = new Dog();
    // husky.breathe();
    // husky.legs = 4;
    // System.err.println(husky.legs);

    // Cat meow = new Cat();
    // meow.legs = 4;
    // System.out.println(meow.legs);
    // meow.eat();

    // Monkey gorilla = new Monkey();
    // gorilla.play();
    // gorilla.eat();

    // Calculator calc = new Calculator();
    // System.out.println(calc.sum(1, 2));
    // System.out.println(calc.sum((float)1.5, (float)2.5));
    // System.out.println(calc.sum(1, 2, 3));

    // BrownHen gori = new BrownHen();
    // gori.layEgg();

    // Horse h = new Horse();
    // h.eat();
    // h.walk();
    // h.changeColor();
    // Chicken c = new Chicken();
    // c.eat();
    // c.walk();
    // c.changeColor();
    // Mustang myMustang = new Mustang(); //Animal -> Horse -> Mustang

    // Students s1 = new Students();
    // s1.schoolName = "Presidency";  
    // System.out.println(s1.schoolName);
    // Students s2 = new Students();
    // System.out.println(s2.schoolName); // s2 schoolname is also same because it was static and if we change ot here it will get changes everywhere
    // System.out.println(s1.percentage(70, 80, 90));

    // B b = new B();
    // System.out.println(b.color);
}
}

//Here we have created 2 class Pen and Student and using main fnx above to print the values
class Pen {
    //properties
    private String color;
    private int tip;

    //fnx (setters)
    void setColor(String newColor) {
        color = newColor; //or we can give it like this.color = newColor
    }
    void setTip(int newTip) {
        tip = newTip;
    }
    //(getters)
    String getColor() {
        return this.color;
    }
    int getTip() {
        return this.tip;
    }

}
class Student {
    //properties
    String username;
    float percentage;

    //fnx
    void studName(String name) {
        username = name;
    }
    void calcPerc(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;
    }
}
class BankAccount {
    public String username;
    private String password;
    public void setPassword (String pwd) {
        password = pwd;
        System.out.println(password);
    }
}


//Constructor
class Employee {
    String name;
    int empId;
    String password;
    int salary[];

    //This is also an ex of constructor overloading where in one class we have multiple constructors with same name and diff parameters, so that objects can be created in diff ways.
    //constructor(Non parameterized - no parameters are being passed while creating the constructor)
    Employee() {
        salary = new int[2];
        System.out.println("Constructor is called...");
    }
    //constructor(parameterized - parameters are being passed while creating the constructor)
    Employee(String name) {
        this.name = name;
        System.out.println(name);
    }
    Employee(int empId) {
        this.empId = empId;
        System.out.println(empId);
    }
    // // you can consider this as copy constructor as well, Shallow copy constructor (Same memory loc) (changes made in the reference will make changes in the main arr aswell, as they share same memory)
    // Employee(Employee e1) { //byheart this for copy constructor, we are passing Employee->constructor, Employee->datatype, e1-> variable name
    //     this.name = e1.name;
    //     this.empId = e1.empId;
    //     this.salary = e1.salary;
    // }
    //deep copy constructor (Different memory loc)
    Employee (Employee e1) {
        salary = new int[2]; //as we have created new arr for salary this will now point to their and changes will not be reflected in the main arr
        this.name = e1.name;
        this.empId = e1.empId;
        this.salary[0] = e1.salary[0];
        this.salary[1] = e1.salary[1];  
     }
}


//Inheritance 
//Single level inheritance
//Base class / Parent class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathe's");
    }
}
//Derived class / Child class
class Fish extends Animal {
    int fins;

    void swims() {
        System.out.println("Swims in water");
    }
}

//Multi level inheritance
class Mammal extends Animal {
    int legs;
}
class Dog extends Mammal {
    String breed;
}

//Hierarchial inheritance
class Hen extends Animal {
    int legs;

    void layEggs() {
        System.out.println("Lay's Egg's");
    }
}
class Cat extends Animal {
    int legs;

    void sipsMilk() {
        System.out.println("Sip's Milk");
    }
}

//Hybrid inheritance
interface Pet {
    public void play(); //here we can't print because, Inside an interface, methods are only declared.
}
class Monkey extends Animal implements Pet{  // Also it is a ex of multiple inheritance because we are using properties of 2 classes
    public void play() {
        System.out.println("Playing...");
    }
}

//Polymorphism

//Method Overloading
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }
    float sum(float a, float b) {
        return a + b;
    }
    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

// Method Overriding
class WhiteHen {
    void layEgg() {
        System.out.println("Lay's White Eggs");
    }
}
class BrownHen extends WhiteHen{
    void layEgg() {
        System.out.println("Lay's Brown Eggs");
    }
}


//Abstraction

// Abstract class
abstract class Animals {
    String color;

    Animals() {  //constructor 
        System.out.println("Animal constructor called");
    }
    void eat() {  //fnx
        System.out.println("Animal Eat's");
    }
    // Abstract method / fnx
    abstract void walk();
}
class Horse extends Animals {
    void changeColor() {
        color = "Dark Brown";
    }
    Horse() {
        System.out.println("Horse constructor called");
    }
    void walk() {
        System.out.println("Horse walk's on 4 leg's");
    }
}
class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}
class Chicken extends Animals {
    void changeColor() {
        color = "Yellow";
    }
    void walk() {
        System.out.println("Chicken walk's on 2 leg's");
    }
}

//Static keyword
class Students {
    //Static var
    static String schoolName;
    //Static fnx
    int percentage(int math, int phy, int chem) {
        return (math + phy + chem) / 3;
    } 
}

//Super keyword
class A {
    String color;

    A() {
        System.out.println("A is called");
    }

}
class B extends A {
    B() {
        super(); 
        super.color = "Black"; //Super as properties
        System.out.println("B is called");
    }
}
