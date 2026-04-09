public class MyMainClass {
   public static void main(String[] args) {
      MyOtherClass m1 = new MyOtherClass();
//      System.out.println(m1.myprivateint);
//      System.out.println(m1.myPrivateInt);
      m1.setMyPrivateInt(4);
      System.out.println(m1.getMyPrivateInt());
      System.out.println(m1.myProtectedInt);
      System.out.println(m1.myPublicInt);
      MyChildClass m2 = new MyChildClass();
//      System.out.println(m2.myPrivateInt);
      m2.setMyPrivateInt(5);
      m2.setMyProtectedInt(6);
      System.out.println(m2.getMyPrivateInt());
      System.out.println(m2.myProtectedInt);
      System.out.println(m2.myPublicInt);
   }
}

class MyOtherClass {
   private int myPrivateInt;
   protected int myProtectedInt;
   public int myPublicInt;
   
   public int getMyPrivateInt() {
      return myPrivateInt;
   }
   
   public void setMyPrivateInt(int myPrivateInt) {
      this.myPrivateInt = myPrivateInt;
   }
}

class MyChildClass extends MyOtherClass {
   public void setMyProtectedInt(int myProtectedInt) {
      this.myProtectedInt = myProtectedInt;
   }
   
}