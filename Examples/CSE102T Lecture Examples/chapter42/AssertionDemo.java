public class AssertionDemo {
  public static void main(String[] args) {
    int i; int sum = 0;
    for (i = 0; i < 10; i++) {
      sum += i; 
    }
    assert i == 11;
    assert sum > 10 && sum < 5 * 10 : "sum is " + sum;
    
    System.out.println("Program ended.");
  }
}
