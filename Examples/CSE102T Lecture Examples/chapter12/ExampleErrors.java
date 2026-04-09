import java.util.Scanner;
public class ExampleErrors {
   public static void main(String[] args) throws Exception {
      Scanner inp = new Scanner(System.in);
      int choice = inp.nextInt();
      if (choice == 0) {
         int i = 1/0;
      }
      else if(choice == 1) {
         int[] arr = new int[0];
         arr[0] = 3;
      }
      else if(choice == 2) {
         throw new Exception();
      }
      System.out.println("Everything okay.");
   }
}