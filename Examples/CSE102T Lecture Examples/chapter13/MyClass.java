interface Interface1  {
   int MYVAL = 1;
}

interface Interface2  {
   int MYVAL = 2;
}

public class MyClass implements Interface1, Interface2 {
   public static void main(String[] args) {
      System.out.println("This is my class.");
      System.out.println(MYVAL);
   }
}