package mytest;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class ArrayListTest {
  private ArrayList<String> list = new ArrayList<String>();
    
  @Before
  public void setUp() throws Exception {
  }
  @Test
  public void tc003_testSomething() {
  } 

  @Test
  public void tc004_testSomething() {
  } 
  @Test
  public void tc005_testSomething() {
  } 
  @Test
  public void tc006_testSomething() {
  } 
  @Test
  public void tc007_testSomething() {
  } 
  @Test
  public void tc001_testInsertion() {
    list.add("beijing");
    assertEquals("Antalya", list.get(0));
  } 
  
  @Test
  public void tc002_testInsertion() {
    list.add("Beijing");
    list.add("Shanghai");
    list.add("Hongkong");
    assertEquals("Hongkong", list.get(list.size() - 1));    
  } 
  
  @Test
  public void testDeletion() {
    list.clear();
    assertTrue(list.isEmpty());  
    
    list.add("A");
    list.add("B");
    list.add("C");
    list.remove("B");
    assertEquals(2, list.size());  
  } 
}
