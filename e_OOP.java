import java.util.Arrays;

public class e_OOP {
    public static void main(String args[]) {

    // Pen myPen = new Pen();  //created an object named mypen
    // myPen.setColor("Black");  //Here we are using our obj we craeted . fnx we created and passing the values
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
    // myAcc.setPassword("LionHeart");
    // System.out.println(myAcc.username);

    // Employee emp1 = new Employee(); //Where Employee() is the cons call
    // Employee emp2 = new Employee("Syed");
    // Employee emp3 = new Employee(167);
    // Employee e1 = new Employee();
    // e1.name = "Syed";
    // e1.empId = 123;
    // e1.password = "abc";
    // e1.salary[0] = 50000;
    // e1.salary[1] = 80000;
    
    // Employee e2 = new Employee(e1);  //here we are passing e1 object as the parametere in the new e2 obj simply copying constructor
    // e2.password = "xyz";
    // System.out.println(e2.password);
    // e1.salary[1] = 100000;
    // for (int i=0; i<2; i++) {
    //     System.out.println(e2.salary[i]);
    // }
}
}

//Here we have created 2 class Pen and Student and using main fnx above to print the values
class Pen {
    //properties
    private String color;
    private int tip;

    //fnx (setters)
    void setColor(String newColor) {
        color = newColor;
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
    void studName(String newStud) {
        username = newStud;
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


    // //This is also an ex of constructor overloading where in one class we have multiple constructors with same name and diff parameters, so that objects can be created in diff ways.

    //constructor(Non parameterized - no parameters are being passed while creating the constructor)
    Employee() {
        salary = new int[2];
        System.out.println("Constructor is called...");
    }
    // //constructor(parameterized - parameters are being passed while creating the constructor)
    // Employee(String name) {
    //     this.name = name;
    //     System.out.println(name);
    // }
    // Employee(int empId) {
    //     this.empId = empId;
    //     System.out.println(empId);
    // }
    // // Shallow copy constructor (Same memory loc)
    // Employee(Employee e1) {
    //     this.name = e1.name;
    //     this.empId = e1.empId;
    //     this.salary = e1.salary;
    // }
    // //deep copy constructor (Different memory loc)
    // Employee (Employee e1) {
    //     salary = new int[2];
    //     this.name = e1.name;
    //     this.empId = e1.empId;
    //     for (int i=0; i<2; i++) {
    //         this.salary[i] = e1.salary[i];
    //     }    
    // }
}