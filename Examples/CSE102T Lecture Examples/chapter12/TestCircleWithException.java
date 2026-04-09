package chapter12;

public class TestCircleWithException {
  public static void main(String[] args) {
    try {
      CircleWithException c1 = new CircleWithException(5);
//       c1 = new CircleWithException(55);
//       c1 = new CircleWithException(53);
//       c1 = new CircleWithException(52);
      c1.setRadius(55);
       c1 = new CircleWithException(53);
      c1.setRadius(52);
      //CircleWithException c2 = new CircleWithException(-5);
      CircleWithException c3 = new CircleWithException(0);
    }
    catch (IllegalArgumentException ex) {
      System.out.println(ex);
    }

    System.out.println("Number of objects created: " +
      CircleWithException.getNumberOfObjects());
  }
}
