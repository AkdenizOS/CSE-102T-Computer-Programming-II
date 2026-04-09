public class MidtermRoom {
   public static void main(String[] args) {
      long studentNum = 3;
      System.out.println(room(studentNum, "", ""));
   }
   public static String room(long studentNum, String name, String course){
      Student s;
      
      try {
         if (studentNum % 4L == 0)
            s = new Class0();
         else if (studentNum % 4L == 1)
            s = new Class1();
         else if (studentNum % 4L == 2)
            s = new Class2();
         else if (studentNum % 4L == 3)
            s = new Class3();
         else if (studentNum % 4L == 4)
            s = new Class4();
         else throw new Exception();
   
         if(s instanceof Class0)
            return "BB01";
         else if (s instanceof Class1)
            return "Amfi4";
         else if (s instanceof Class2)
            return "Amfi4";
         else if (s instanceof Class3)
            return "BB01";
         else return "BB01";
      } catch (Exception ex) {
         return "Amfi4";
      }
   }
}

abstract class Student {
}

class Class0 extends Student {
}

class Class1 extends Student {
}

class Class4 extends Student {
}

class Class2 extends Class0 {
}

class Class3 extends Class1 {
}
