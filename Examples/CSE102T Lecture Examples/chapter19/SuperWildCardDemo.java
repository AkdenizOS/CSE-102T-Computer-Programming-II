package chapter19;

public class SuperWildCardDemo {
  public static void main(String[] args) {
    GenericStack<Object> stack1 = new GenericStack<Object>();
    GenericStack<Object> stack2 = new GenericStack<Object>();
    stack2.push("Java");
    stack2.push(2);
    stack1.push("Sun");
//    stack1.push(1);
    add(stack2, stack1);
    AnyWildCardDemo.print(stack2);
  }

  public static <T> void add(GenericStack<T> stack1,
      GenericStack<? super T> stack2) {
    while (!stack1.isEmpty())
      stack2.push(stack1.pop());
  }
}