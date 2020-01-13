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
