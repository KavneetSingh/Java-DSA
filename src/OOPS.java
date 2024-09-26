public class OOPS {
    public static void main(String[] args){
        Pen p1= new Pen();
        p1.setColor("Blue");
        p1.tip= "Gel";
        p1.write();

        Student s1= new Student();
        s1.name="Kavi";
        System.out.println(s1.name);
        s1.age=19;
        s1.calcPercentage(98,80,97);
        System.out.println(s1.percentage);
        BankAccount BA1= new BankAccount();
        BA1.username= "Hello";
        BA1.setPassword("1234");
        System.out.println(BA1.username);
        System.out.println(BA1.getPassword());
        s1.marks[0]=20;
        s1.marks[1]= 30;
        s1.marks[2]=40;
        Student s2 = new Student(s1);
        s1.marks[2]= 32;
        s1.name= "Kkk";
        System.out.println(s2.marks[2]);
        Fish shark= new Fish();
        shark.eat();
        Queen q1= new Queen();
        q1.moves();
    }
}
class Pen{
    String color;
    String tip;
    void setColor(String newCol){
        color= newCol;
    }
    void setTip(String newTip){
        tip= newTip;
    }
    void write(){
        System.out.println("Writing something");
    }

}

class Student{
    String name;
    int age;
    float percentage;
    void calcPercentage(int Maths, int Phy, int Chem){
        percentage= (float) (Maths+Phy+Chem)/3;
    }
    int marks[]= new int[3];
    Student(){

    }
    Student(Student s1){
        this.name= s1.name;
        this.marks=s1.marks;
    }

}

class BankAccount{
    public String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
// Base Class
class Animals{
    String color;
    void eat(){
        System.out.println("Eats");
    }
    void breathes(){
        System.out.println("Breathes");
    }
}
//Derived Class or Subclass
class Fish extends Animals{
    int fins;
    void swim(){
        System.out.println("Swims in water");
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, right, left, diag(in all 4 drxns)");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, right, left");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, right, left, diag(one step)");
    }
}

interface Herbivore{

}
interface Carnivore{

}

class Bear implements Herbivore, Carnivore{

}