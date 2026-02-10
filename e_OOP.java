public class e_OOP {
    public static void main(String args[]) {

    Pen myPen = new Pen();  //created an object named mypen
    myPen.setColor("Black");  //Here we are using our obj we craeted . fnx we created and passing the values
    System.out.println(myPen.getColor());  
    myPen.setTip(5);  //obj . setter for assigning 
    System.out.println(myPen.getTip());  //obj . getter for printing
    myPen.setColor("Blue");
    System.out.println(myPen.getColor());

    Student stud = new Student();
    stud.studName("Syed Maaz");
    System.out.println(stud.username);  //In print statement we need to pass object.property 
    stud.calcPerc(98, 96, 90);
    System.out.println(stud.percentage);

    BankAccount myAcc = new BankAccount();
    myAcc.username = "Syed Maaz";
    myAcc.setPassword("LionHeart");
    System.out.println(myAcc.username);

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
