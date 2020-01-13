import java.util.*;

class GFG{
  static class Queue{
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    // In the enQueue function we make use of two stack to implement the FIFO
    static void enQueue(int x){
      while(!s1.isEmpty()){
        s2.push(s1.pop());
      }
      s1.push(x);

      while(!s2.isEmpty()){
        s1.push(s2.pop());
      }
    }

    // Logic for deQueue is pretty straight-forward
    static int deQueue(){
      if(s1.isEmpty(){
        System.out.println("Stack is empty");
        System.out.println(0);
      }

      int x = s1.peek();
      s1.pop();
      return x;
    }
  }; // This line is important because I dont think ';' is needed

  public static void main(String[] args){
      Queue q = new Queue();
      q.enQueue(1);
      q.enQueue(2);
      q.enQueue(3);

      System.out.println(q.deQueue());
      System.out.println(q.deQueue());
      System.out.println(q.deQueue());
  }
}
