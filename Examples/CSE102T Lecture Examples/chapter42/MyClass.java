import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class MyClass {
   private int myInt;
   
   public MyClass() {
      myInt = 1;
   }
   
   public MyClass(int myInt) {
      setMyInt(myInt);
   }
   
   public void setMyInt(int myInt) {
      if (myInt < 0) 
         throw new IllegalArgumentException();
      this.myInt = myInt;
   }
   
   public int getMyInt() {
      return myInt;
   }
}