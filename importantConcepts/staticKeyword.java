// 'static' is a non-access modifier in Java
// 'static' is valid for the following --> blocks, variables, methods, nested classes.
// When a member is declared static, it can be accessed before any objects of its class are created. (without referencing any other object)

class Test{
  static void m1(){
    System.out.println("Inside M1");
  }

  public static void main(String[] args){
    // Here is the fun part --> Notice we havn't initialized any objects for m1, still it works becuase we declared it as static
    m1();
  }
}

//////// STATIC BLOCKS //////////
// Furthermore we can use this to our advantage,
// If we want a class to be loaded first and exactly one we can initialize it using 'static'

class Test1{

  // These are static variables
  static int a = 10;
  static int b;

  static{
    System.out.println("Static block initialized");
    b = a * 4;
  }

  public static void main(String[] args){
    System.out.println("Value of A is " + a);
    System.out.println("Value of A is " + a);
  }
}
// Right here we understand that a will forever be 10 util it is destroyed.
// While b will always compute (a * 4), as a is 10, b will always be 40.

//////////// STATIC VARIABLES //////////
// When a variable is declared as static, then a single copy of variable is created,
// and shared among all objects at Class level.
// You can think of static variables as Global variables
// IMPORTANT nOTE --> We can create static variables only at class-level
// and static variables are executed in order they are present in a program.

class Test2{
  // Static variable
  static int a = m1();

  static{
    System.out.println("Inside static block");
  }

  static int m1(){
    System.out.println("from m1");
    return 20;
  }

  public static void main(String[] args){
    System.out.println("Value of a: " + a);
    System.out.println("from main");
  }
}

// Output of this sequence is
// 1. from m1
// 2. Inside static block
// 3. Value of a: 20
// 4. Inside main

/////////// STATIC METHODS ////////////
// Important points about static methods
// 1. Static methods can only (directly) call other static methods
// 2. They can only (directly) access static data.
// 3. they cannot refer to 'this' or 'super' in any way!

class Test3{
  static int a = 10;
  int b = 20;

  static void m1(){
    a = 20;
    System.out.println("from m1");

    b = 10; // This would result in an error, Can't make a static reference to a non-static member

    m2(); // This would again result in error, can't make a static reference to a non-static source.

    System.out.println(super.a); // Again can't use super in static context

    void m2(){
      System.out.println("from m2");
    }

    public static void main(String[] args){
      // main method
    }

  }
}

// So when is the correct time to use static variables and methods?
// We use static varible for the property that is common across all objects in a classes
// For example the College name for the Student class.
class Student{
  String name;
  int rollNo;

  static String cllgName;

  static int counter = 0;

  public Student(String name){
    this.name = name;
    this.rollNo = setRollNo();
  }

  static int setRollNo(){
    counter++;
    return counter;
  }

  static void setCllg(String name){
    cllgName = name;
  }

  // This is a normal instance method --> No static stuff here!
  void getStudentInfo(){
    System.out.println("name: " + this.name);
    System.out.println("rollNo: " + this.rollNo);

    // We are fetch
    System.out.println("College Name: " + cllgName);
  }
}
