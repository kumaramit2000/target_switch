public class Oops{
    public static void main(String args[]){
        System.out.println("Amit");
        Employee e = new Employee();
    }

}


//abstraction ------
//only the essential details are displayed to the user
abstract class Abst{
    //abstract methods declaration
    abstract void add();
    abstract void mul();
    abstract void div();
}


//Encapsulation using private modifier
//Employee class contains private data called employee id and employee name
class Employee {
    private int empid;
    private String ename;
    public void setEmpId(int id){
        this.empid = id;
    }
    public void setEname(String name){
        this.ename = name;
    }
    public void printData(){
        System.out.println("empid : "+empid);
        System.out.println("ename : "+ename);
    }
}

//Inheritance
//base class or parent class or super class
class A{
    //parent class methods
    void method1(){}
    void method2(){}
}

//derived class or child class or base class
class B extends A{  //Inherits parent class methods
    //child class methods
    void method3(){}
    void method4(){}
}