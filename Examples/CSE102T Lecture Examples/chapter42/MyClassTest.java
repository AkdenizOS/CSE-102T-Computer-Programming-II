import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MyClassTest {


   /** Fixture initialization (common initialization for all tests). **/
   @Before public void setUp() {
   }


   @Test public void tc001_NoArgConstructor() {
      MyClass obj = new MyClass();
      assertEquals("message", 1, obj.getMyInt());
   }

   @Test public void tc002_setMyInt() {
      MyClass obj = new MyClass();
      obj.setMyInt(5);
      assertEquals("message", 5, obj.getMyInt());
   }

   @Test public void tc003_setMyIntNegative() {
      try{
         MyClass obj = new MyClass();
         obj.setMyInt(-8);
         // if i get here
         assertTrue("message", false);
      } catch (java.lang.IllegalArgumentException ex) {
      }
//      assertEquals("message", -8, obj.getMyInt());
   }

   @Test public void tc004_ConstructorNegative() {
      try{
         MyClass obj = new MyClass(-8);
         // if i get here
         assertTrue("message", false);
      } catch (java.lang.IllegalArgumentException ex) {
      }
   }
}
