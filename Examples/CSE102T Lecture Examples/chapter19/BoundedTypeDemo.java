package chapter19;

import chapter13.Circle;
import chapter13.GeometricObject;
import chapter13.Rectangle;

public class BoundedTypeDemo {
  public static void main(String[] args ) {
    Rectangle rectangle = new Rectangle(4, Math.PI);
    Circle circle = new Circle(2);
    System.out.println(rectangle.getArea());

    System.out.println("Same area? " +
      equalArea(rectangle, circle));
      
//     System.out.println("Same area Strings? " +
//       equalArea("JAVA", "CSE102"));
  }

  public static <Ramazan extends GeometricObject> boolean equalArea(
      Ramazan object1, Ramazan object2) {
    return object1.getArea() == object2.getArea();
  }
}
