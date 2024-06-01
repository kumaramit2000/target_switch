#include<bits/stdc++.h>

using namespace std;

//Class
//Objects
//Encapsulation
//Abstraction
//Polymorphism
//Inheritance
//Dynamic Binding
//Message Passing

/*
 Class ----- 
 
 It is a user-defined data type, which holds its own data members and member functions, 
 which can be accessed and used by creating an instance of that class. 
 
 A class is like a blueprint for an object.
*/
class Person{
	public:
	int id;
	string name;
	
	
		//Default Constructor
		Person(){}
		//Parameterize Constructor
		Person(string n,int i){
			this->name=n;
			this->id=i;
		} 
		//Copy Constructor
		Person(Person& temp){
			name=temp.name;
			id=temp.id;
		}
		Person(Person& temp,int check){
			cout<<"Deep Copy - Separate memory will be created."<<endl;
			name=temp.name;
			id=temp.id;
		}
		~Person(){
			cout<<"Destructor called."<<endl;
		}
		void setname(string name){
			this->name = name;
		}
		void setid(int id){
			this->id = id;
		}
		void printName(){
			cout<<"Name - "<<this->name<<endl;
			cout<<"Id - "<<this->id<<endl;
		}
};

/*
	Inheritance -----
	The capability of a class to derive properties and characteristics from another class is called Inheritance.
	
	Here Person is our Super Class
	And Student is our Sub Class
*/
class Student : private Person {
	string cs;
	
	public:
		void setstu(string name, int id, string cs){
			this->cs = cs;
			this->name = name;
			this->id = id;
		}
		void printstu(){
			printName();
			cout<<"Class - "<<this->cs<<endl;
		}
};

/*
	Polymorphism -----
	
	When a single thing is existing in multiple forms then we call it polymorphism.
	
		Compile Time - Function, Operator Overloading 
		Run Time - Function Overriding or Virtual Function
*/

class Poly{
	public:
//		Compile Time
		void sum(int a,int b){
			cout<<"Sum :"<<a+b<<endl;
		}
		void sum(int a,int b,int c){
			cout<<"Sum :"<<a+b+c<<endl;
		}
//		Run Time Using Virtual Function
		virtual void display(){
			cout << "Called virtual Base Class function"<<endl;
		}
};

/*
	Abstraction -----
	
*/

class abst{
	int a,b;
	public:
		void set(int x,int y){
			a=x;
			b=y;
		}
		void show(){
			cout<<"a - "<<a<<endl;
			cout<<"b - "<<b<<endl;
		}
};

class Chil : public Poly{
	public:
		void display(){
			cout << "Called Child Class function"<<endl;
		}
};
/*
	Encapsulation -----
	Wrapping up data member and function.
*/
int main(){
	int n;
	/*
	Object ----- 
	
	An Object is an identifiable entity with some characteristics and behavior. 
	An Object is an instance of a Class. 
	When a class is defined, no memory is allocated but when it is instantiated (i.e. an object is created) memory is allocated.
	*/
	Person p;
	p.setname("Amit");
	p.setid(26778765);
	p.printName();
	//Static Way of Object Creation
	Person p1("Lalit",1234);
	p1.printName();
	//Dynamically Way of Object Creation
	Person *p2 = new Person("Ans",4567);
	(*p2).printName();
	p2->printName();
	//Copy Constructor Call
	Person p3(p1);//Shallow Copy if default constructor is called.  
	p3.printName();
	
	Person p4(p1,1);//Deep Copy if own copy constructor is called.  
	p4.printName();	
	//For Dynamically object destructor can call only manually
	delete p2;
	
	Student s;
	s.setstu("abc",12, "def");
	s.printstu();
	
	Poly po;
	po.sum(1,2);
	po.sum(1,2,3);
	
	
	Chil ch;
	ch.display();
	
	Poly po1;
	po1.display();
	
//	Override Parent Method by Child Method
	Poly* par;
	Chil chi;
	par = &chi;
	par->display();
	
	abst a;
	a.set(1,3);
	a.show();
}
