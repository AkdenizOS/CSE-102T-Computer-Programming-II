public class ComparableExamples {
   public static void main(String[] args) {
      System.out.println(Integer.valueOf(3).compareTo(Integer.valueOf(5)));
      System.out.println("Star Wars".compareTo("Star Trek"));    
      java.util.Date date1 = new java.util.Date(2013, 1, 1);    
      java.util.Date date2 = new java.util.Date(2012, 1, 1);    
      System.out.println(date1.compareTo(date2)); 
   }
}