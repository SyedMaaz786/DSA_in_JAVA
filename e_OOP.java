public class e_OOP {
    public static void main(String args[]) {

    Pen myPen = new Pen();  //created an object named mypen
    myPen.setColor("Black");  //Here we are using our obj we craeted . fnx we created and passing the values
    System.out.println(myPen.color);  //In print statement we need to pass object.property 
    myPen.setTip(5);
    System.out.println(myPen.tip);
    myPen.color="Blue";
    System.out.println(myPen.color);

    Student stud = new Student();
    stud.studName("Syed Maaz");
    System.out.println(stud.username);
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
    String color;
    int tip;

    //fnx
    void setColor(String newColor) {
        color = newColor;
    }
    void setTip(int newTip) {
        tip = newTip;
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
