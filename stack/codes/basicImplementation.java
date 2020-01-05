import java.io.*;
import java.util.*;

class Test{
  static void stack_push(Stack<Integer> stack){
    for(int i = 0; i < 5; i++){
      stack.push(i);
    }
  }

  static void stack_pop(Stack<Integer> stack){
    System.out.println("Pop :");

    for(int i = 0; i < 5; i++){
      Integer y = (Integer) stack.pop();
      System.out.println(" " + y);
    }
  }

  static void stack_peak(Stack<Integer> stack, int element){
    Integer element = (Integer) stack.peek();
    System.out.println(" " + element);
  }

  static void stack_search(Stack<Integer> stack, int element){
    Integer pos = (Integer) stack.search(element);

    if(pos == -1) System.out.println("Not Found");
    else System.out.println("Found at" + pos);
  }

  public static void main(String[] args){
      Stack<Integer> stack = new Stack<Integer> ();

      stack_push(stack);
      stack_pop(stack);
      stack_push(stack);
      stack_peak(stack);
      stack_search(stack, 2);
      stack_search(stack, 6);
  }
}
