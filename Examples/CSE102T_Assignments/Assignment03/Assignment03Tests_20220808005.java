import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**---------------------------------------------------

 * Akdeniz University CSE102T Assignments

 * @author: Yahya Efe Kuruçay

 * @since: 08.05.2024

 * Description: Assignment03Tests

 * Score:30 ( tüm sınıf birbirinden kopyaladi çoğu kişi 30 aldı)

 * Website: https://efekurucay.com

*---------------------------------------------------*/
/*
 *            __     _                                                          
 *           / _|   | |                                                         
 *       ___| |_ ___| | ___   _ _ __ _   _  ___ __ _ _   _   ___ ___  _ __ ___  
 *      / _ \  _/ _ \ |/ / | | | '__| | | |/ __/ _` | | | | / __/ _ \| '_ ` _ \ 
 *     |  __/ ||  __/   <| |_| | |  | |_| | (_| (_| | |_| || (_| (_) | | | | | |
 *      \___|_| \___|_|\_\\__,_|_|   \__,_|\___\__,_|\__, (_)___\___/|_| |_| |_|
 *                                                    __/ |                     
 *                                                   |___/                      
 */


public class Assignment03Tests_20220808005 {
    @Test
    public void departmentGetCodeTestIn(){
        Department department = new Department("CSE", "Computer Engineering");
        Assert.assertEquals("CSE", department.getCode());
    }

    @Test
    public void setCodeTest(){
        Department department = new Department("CSE", "Computer Engineering");
        department.setCode("Cse");
        Assert.assertEquals("Cse", department.getCode());  
    }

    @Test
    public void departmentGetNameTest(){
        Department department =new Department("CSE", "Computer Engineering");
        Assert.assertEquals("Computer Engineering",department.getName());
    }
    
    @Test
    public void departmentInvalidCodeTest(){
        try {
            @SuppressWarnings("unused")
            Department department =new Department("CSE10", "Computer Engineering");
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }

    }

    @Test
    public void departmentSetChairTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        department.setChair(t);
        Assert.assertEquals(t,department.getChair());
    }

    @Test
    public void departmentNullChairTest () {
        Department department = new Department("CSE", "Computer Engineering");
        Department department2 = new Department("PHY", "Physics");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        department.setChair(t);
        assertNull(department2.getChair());
    }

     @Test
    public void testChairMismatchException() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        try {
            department2.setChair(t);
            assertTrue(true);
        }catch (Exception e){
            Assert.assertEquals("DepartmentMismatchException: Joseph Ledet(123) cannot be chair of FİZ because he/she is currently assigned to CSE",e.toString());
        }
    }

    @Test
    public void departmentMismatchExceptionTest() throws Exception {
        Department department = new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FIZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        try {
            department2.setChair(t);
            fail("Expected DepartmentMismatchException was not thrown");
        } catch (Exception e) {
            assertEquals("DepartmentMismatchException: Joseph Ledet(123) cannot be chair of FIZ because he/she is currently assigned to CSE", e.toString());
        }
    }

    @Test
    public void departmentMismatchExceptionTest2() throws Exception {
        Department department = new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FIZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department2, 2);
        try {
         department.setChair(t);
            fail("Expected DepartmentMismatchException was not thrown");
        } catch (Exception e) {
            assertEquals("DepartmentMismatchException: Joseph Ledet(123) cannot be chair of CSE because he/she is currently assigned to FIZ", e.toString());
        }
    }

    
    @Test
    public void courseConstructorTest1 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        assertEquals("CSE", c1.getDepartment().getCode());
    }

    @Test
    public void courseConstructorTest2 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        Assert.assertEquals(t,c1.getTeacher());
    }

    @Test
    public void courseConstructorTest3 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        Assert.assertEquals(101,c1.getCourseNumber());
    }

    @Test
    public void courseConstructorTest5 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        Assert.assertEquals(4,c1.getAKTS());
    }

    @Test
    public void courseConstructorTest6 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        assertEquals("Programming 1", c1.getTitle());
    }

    @Test
    public void courseConstructorTest7 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        assertEquals("Intro to Programming", c1.getDescription());
    }

    @Test
    public void courseConstructorTest8 () {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@gmail.com", 123L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);

        assertEquals("Intro to Programming", c1.getDescription());
    }

    @Test
    public void courseSetDepartmentTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);
        t.setDepartment(department2);
        c1.setDepartment(department2);
        Assert.assertEquals(department2,c1.getDepartment());
    }
    
    @Test
    public void courseSetTeacherTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Efe efe", "efek@akdeniz.edu.tr", 128L, department, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 4, t);
        c1.setTeacher(t2);
        Assert.assertEquals(t2,c1.getTeacher());
    }

    @Test
    public void courseSetNumberTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        c1.setCourseNumber(102);
        Assert.assertEquals(102,c1.getCourseNumber());
    }

    @Test
    public void courseSetTitleTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        c1.setTitle("Programming 2");
        Assert.assertEquals("Programming 2",c1.getTitle());
    }

    @Test
    public void courseSetDescriptionTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        c1.setDescription("OOP");
        Assert.assertEquals("OOP",c1.getDescription());
    }

    @Test
    public void courseSetAKTSTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        c1.setAKTS(6);
        Assert.assertEquals(6,c1.getAKTS());
    }

    @Test
    public void courseCourseCodeTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        Assert.assertEquals("CSE101",c1.courseCode());
    }

    @Test
    public void courseToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        Assert.assertEquals("CSE101 - Programming 1 (6)",c1.toString());
    }
    

    @Test
    public void courseDepartmentMismatchExceptionTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FIZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Efe efe", "efek@akdeniz.edu.tr", 128L, department2, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
        try {
            c1.setTeacher(t2);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("DepartmentMismatchException: Efe efe(128) cannot be chair of CSE because he/she is currently assigned to FIZ",e.toString());
        }
    }

    @Test
    public void courseDepartmentMismatchExceptionTest3() throws Exception {
        Department department = new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FIZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Teacher t2 = new Teacher("Efe efe", "efek@akdeniz.edu.tr", 128L, department2, 1);
        Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", 6, t);
    
        try {
            c1.setTeacher(t2);
            fail("Expected DepartmentMismatchException was not thrown");
        } catch (Exception e) {
            assertEquals("DepartmentMismatchException: Efe efe(128) cannot be chair of CSE because he/she is currently assigned to FIZ", e.toString());
        }
    }   


    @Test
    public void courseInvalidNumberTest() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        try {
            @SuppressWarnings("unused")
            Course c1 = new Course(department, 0, "Programming 1", "Intro to Programming", 6, t);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void courseInvalidAKTSTest() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
    
        try {
            @SuppressWarnings("unused")
            Course c1 = new Course(department, 101, "Programming 1", "Intro to Programming", -6, t);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }


    @Test
    public void personConstructorTest1 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("Joseph Ledet",p.getName());
        Assert.assertEquals("Joseph Ledet",p.getName());
    }

    @Test
    public void personConstructorTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("josephledet@akdeniz.edu.tr",p.getEmail());
    }

    @Test
    public void personConstructorTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals(123L,p.getId());
    }

    @Test
    public void personConstructorTest4 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals(department,p.getDepartment());
    }

    @Test
    public void personConstructorTest5 () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        assertEquals(department, p.getDepartment());
    }

    @Test
    public void personSetNameTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setName("Efe efe");
        Assert.assertEquals("Efe efe",p.getName());
    }

    @Test
    public void personSetEmailTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setEmail("efek@akdeniz.edu.tr");
        Assert.assertEquals("efek@akdeniz.edu.tr",p.getEmail());
    }

    @Test
    public void personSetIDTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setId(124L);
        Assert.assertEquals(124L,p.getId());
    }

    @Test
    public void personSetDepartmentTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        p.setDepartment(department2);
        Assert.assertEquals(department2,p.getDepartment());
    }

    @Test
    public void personToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Person p = new Person("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department) {
        };
        Assert.assertEquals("Joseph Ledet  (123) - josephledet@akdeniz.edu.tr",p.toString());
    }


    @Test
    public void teacherConstructorTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        assertTrue(t instanceof Person);
    }

    @Test
    public void teacherConstructorTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Joseph Ledet",t.getName());
    }

    @Test
    public void teacherConstructorTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("josephledet@akdeniz.edu.tr",t.getEmail());
    }

    @Test
    public void teacherConstructorTest4 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(123L,t.getId());
    }

    @Test
    public void teacherConstructorTest5 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(department,t.getDepartment());
    }

    @Test
    public void teacherConstructorTest6 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals(2,t.getRank());
    }

    @Test
    public void teacherSetDepartmentTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setDepartment(department2);
        Assert.assertEquals(department2,t.getDepartment());
    }

    @Test
    public void teacherSetNameTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setName("Efe efe");
        Assert.assertEquals("Efe efe",t.getName());
    }

    @Test
    public void teacherSetEmailTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setEmail("efek@akdeniz.edu.tr");
        Assert.assertEquals("efek@akdeniz.edu.tr",t.getEmail());
    }

    @Test
    public void teacherSetIDTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.setId(124L);
        Assert.assertEquals(124L,t.getId());
    }

    @Test
    public void teacherGetTitleTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Lecturer",t.getTitle());
    }

    @Test
    public void teacherDemoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        Assert.assertEquals(1,t.getRank());
    }

    @Test
    public void teacherDemoteTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        Assert.assertEquals("Teaching Assistant",t.getTitle());
    }

    @Test
    public void teacherPromoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        Assert.assertEquals(3,t.getRank());
    }

    @Test
    public void teacherPromoteTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        Assert.assertEquals("Assistant Professor",t.getTitle());
    }

    @Test
    public void teacherPromoteTest3 () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        t.promote();
        Assert.assertEquals("Associate Professor",t.getTitle());
    }

    @Test
    public void teacherToStringTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Assert.assertEquals("Joseph Ledet  (123) - josephledet@akdeniz.edu.tr",t.toString());
    }

    @Test
    public void teacherInvalidEmailTest() {
        var cse = new Department("CSE", "CSECI");
        try {
        @SuppressWarnings("unused")
        Teacher t = new Teacher("Joseph Ledet", "josephledetakdeniz.edu.tr", 123L, cse, 2);
        fail("RuntimeException should have been thrown.");
    } catch (RuntimeException e) {
        assertTrue(true);
    }
}

    

    @Test
    public void teacherInvalidRankTest () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            @SuppressWarnings("unused")
            Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 6);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void teacherInvalidRankTest2 () {
        Department department =new Department("CSE", "Computer Engineering");
        try {
            @SuppressWarnings("unused")
            Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 6);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("InvalidRankException: 6",e.toString());
        }
    }

    @Test
    public void teacherInvalidPromoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.promote();
        t.promote();
        try {
            t.promote();
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void teacherInvalidDemoteTest () {
        Department department =new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        t.demote();
        try {
            t.demote();
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidRankException);
        }
    }

    @Test
    public void studentConstructorTest1 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d);
        assertTrue(s instanceof Person);
    }

    @Test
    public void studentConstructorTest2 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d);
        Assert.assertEquals("Yahya Efe Kurucay",s.getName());
    }

    @Test
    public void studentConstructorTest3 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d);
        Assert.assertEquals("contact@efekurucay.com",s.getEmail());
    }


    @Test
    public void studentConstructorTest4 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d);
        Assert.assertEquals(456L,s.getId());
    }

    @Test
    public void studentConstructorTest5 (){
        Department d = new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d);
        Assert.assertEquals(d,s.getDepartment());
    }

    @Test
    public void studentSetDepartmentTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Department department2 = new Department("FİZ", "Fizik Fakultesi");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        s.setDepartment(department2);
        Assert.assertEquals(department2,s.getDepartment());
    }

    @Test
    public void studentSetNameTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        s.setName("Efe efe");
        Assert.assertEquals("Efe efe",s.getName());
    }

    @Test
    public void studentSetEmailTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        s.setEmail("efek@akdeniz.edu.tr");
        Assert.assertEquals("efek@akdeniz.edu.tr",s.getEmail());
    }

    @Test
    public void studentSetIDTest() {
        Department department =new Department("CSE", "Computer Engineering");
        Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        s.setId(124L);
        Assert.assertEquals(124L,s.getId());
    }

    @Test
    public void testGetAKTS_NoCourses() {
        Department department = new Department("CSE", "Computer Engineering");
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);

        Assert.assertEquals(0, student.getAKTS());
    }

    @Test
    public void testGetAKTS_WithCourses() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
       
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course1 = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Course course2 = new Course(department, 102, "Programming 2", "Object Oriented Programming", 6, t);

        student.addCourse(course1, 40); 
        student.addCourse(course2, 80); 

        Assert.assertEquals(6, student.getAKTS());
    }

    @Test
    public void studentGetAttemptedAKTSTest() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
       
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course1 = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Course course2 = new Course(department, 102, "Programming 2", "Object Oriented Programming", 6, t);

        student.addCourse(course1, 40); 
        student.addCourse(course2, 80);

        Assert.assertEquals(12,student.getAttemptedAKTS());


    }

    @Test
    public void stundentAddCourseTest() {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);

        student.addCourse(course, 80);

        Assert.assertTrue(student.getCourses().contains(course));
        Assert.assertEquals(course.getAKTS(), student.getAKTS());
        
    }

    @Test
    public void studentCourseGPAPointsTest() {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);

        student.addCourse(course,89);
        Assert.assertEquals(4.0,student.courseGPAPoints(course),0.0001);
    }

    @Test
    public void studentCourseGradeLetterTest() {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        
        student.addCourse(course,89);
        Assert.assertEquals("AA",student.courseGradeLetter(course));
    }

    @Test
    public void studentGetGPATest(){
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Course course2 = new Course(department, 102, "Programming 2", "Object Oriented Programming", 6, t);

        student.addCourse(course,78);
        student.addCourse(course2,92);
        Assert.assertEquals(3.5,student.getGPA(),0.01);
    }

    @Test
    public void studentCourseResultTest() {
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
         
        student.addCourse(course,89);
        Assert.assertEquals("Passed",student.courseResult(course));
    }

    @Test
    public void studentToStringTest (){
        Department department = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Course course2 = new Course(department, 102, "Programming 2", "Object Oriented Programming", 6, t);
        
        student.addCourse(course,78);
        student.addCourse(course2,75);
        Assert.assertEquals("Yahya Efe Kurucay  (456) - contact@efekurucay.com -GPA:3.0",student.toString());
    }

    @Test
    public void studentInvalidEmailTest() {
        Department department = new Department("CSE", "Computer Engineering");
        try {
            @SuppressWarnings("unused")
            Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
            fail("RuntimeException should have been thrown.");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void studentInvalidGradeTest1() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
        try {
            student.addCourse(course,125);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidGradeException);
        }
    }

    @Test
    public void studentInvalidGradeTest2() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, t);
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
         try {
            student.addCourse(course,125);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("InvalidGradeException: 125.0",e.toString());
        }
    }

    @Test
    public void studentCourseResultNotFoundExceptionTest() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher teacher = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, teacher);
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
    
        try {
            student.courseResult(course);
            fail("Expected CourseNotFoundException was not thrown");
         } catch (CourseNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void studentCourseNotFoundExcepitonTest2() {
        Department department = new Department("CSE", "Computer Engineering");
        Teacher teacher = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, department, 2);
        Course course = new Course(department, 101, "Programming 1", "Introduction to Programming", 6, teacher);
        Student student = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, department);
          try {
            student.courseGPAPoints(course);
            assertTrue(false);
        }catch (Exception e){
            Assert.assertEquals("java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0",e.toString());
        }
    }

    @Test
    public void gradStudentConstructorTest1 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        assertTrue(g instanceof Student);
    }

    @Test
    public void gradStudentConstructorTest2 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        Assert.assertEquals("Yahya Efe Kurucay",g.getName());
    }

    @Test
    public void gradStudentConstructorTest3 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        Assert.assertEquals("contact@efekurucay.com",g.getEmail());
    }

    @Test
    public void gradStudentConstructorTest4 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        assertEquals(456L, g.getId());
    }

    @Test
    public void gradStudentConstructorTest5 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        Assert.assertEquals(d,g.getDepartment());
    }

    @Test
    public void gradStudentConstructorTest6 (){
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        Assert.assertEquals("Programming",g.getThesisTopic());
    }

    @Test
    public void gradStudentSetDepartmentTest() {
        Department d =new Department("CSE", "Computer Engineering");
        Department d2 = new Department("FİZ", "Fizik Fakultesi");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.setDepartment(d2);
        Assert.assertEquals(d2,g.getDepartment());
    }

    @Test
    public void gradStudentSetNameTest() {
        Department d =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.setName("Efe efe");
        Assert.assertEquals("Efe efe",g.getName());
    }

    @Test
    public void gradStudentSetEmailTest() {
        Department d =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.setEmail("efek@akdeniz.edu.tr");
        Assert.assertEquals("efek@akdeniz.edu.tr",g.getEmail());
    }

    @Test
    public void gradStudentSetIDTest() {
        Department d =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.setId(456L);
        Assert.assertEquals(456L,g.getId());
    }

    @Test
    public void gradStudentSetThesisTest() {
        Department d =new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.setThesisTopic("Big Data");
        Assert.assertEquals("Big Data",g.getThesisTopic());
    }

    @Test
    public void gradStudentCourseGPAPointsTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher teacher = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course course = new Course(d, 101, "Programming 1", "Introduction to Programming", 6, teacher);
    
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
       
        g.addCourse(course, 90);
    
        assertEquals(4.0, g.courseGPAPoints(course), 0.001);
    }

    @Test
    public void gradStudentGetGPATest() {
        Department d = new Department("CSE", "Computer Engineering");
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
    
        assertEquals(0.0, g.getGPA(), 0.001);
    }

    @Test
    public void gradStudentGetAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        Course c2 = new Course(d, 102, "Programming 2", "OOP", 4,t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,85);
        g.addCourse(c2,35);
        Assert.assertEquals(4,g.getAKTS());
    }

    @Test
    public void gradStudentGetAttemptedAKTSTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        Course c2 = new Course(d, 102, "Programming 2", "OOP", 4,t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,85);
        g.addCourse(c2,35);
        Assert.assertEquals(8,g.getAttemptedAKTS());
    }

    @Test
    public void gradStudentAddCourseTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,75);
        g.addCourse(c1,98);
        Assert.assertEquals(8,g.getAKTS());
    }

    @Test
    public void gradStudentCourseGPAPointsTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,89);
        Assert.assertEquals(3.5,g.courseGPAPoints(c1),0.0001);
    }

    @Test
    public void gradStudentCourseGradeLetterTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,89);
        Assert.assertEquals("BA",g.courseGradeLetter(c1));
    }

    @Test
    public void gradStudentCourseResultTest() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,89);
        Assert.assertEquals("Passed",g.courseResult(c1));
    }

    @Test
    public void gradStudentGetGPATest2(){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        Course c2 = new Course(d, 102, "Programming 2", "OOP", 4,t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,78);
        g.addCourse(c2,92);
        Assert.assertEquals(3.25,g.getGPA(),0.01);
    }

    @Test
    public void gradStudentToStringTest (){
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        Course c2 = new Course(d, 102, "Programming 2", "OOP", 4,t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        g.addCourse(c1,78);
        g.addCourse(c2,75);
        Assert.assertEquals("Yahya Efe Kurucay  (456) - contact@efekurucay.com -GPA:2.5",g.toString());
    }

    @Test
    public void gradStudentInvalidGradeTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        try {
            g.addCourse(c1,125);
            assertTrue(false);
        }catch (Exception e){
            assertTrue(e instanceof InvalidGradeException);
        }
    }

    @Test
    public void gradStudentInvalidGradeTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");

        try {
            g.addCourse(c1,125);
            assertTrue("InvalidGradeException not thrown", false);
        } catch (InvalidGradeException e) {
            assertTrue("InvalidGradeException thrown", true);
        } catch (Exception e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void gradStudentInvalidGradeTest3() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        try {
            g.addCourse(c1, 125);
            fail(); 
        } catch (InvalidGradeException e) {
            assertTrue(true); 
        } catch (Exception e) {
            fail(); 
        }
    }

    @Test
    public void gradStudentCourseNotFoundExcepitonTest1() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");

        try {
            g.courseGPAPoints(c1);
            assertFalse("CourseNotFoundException not thrown", true);
        } catch (CourseNotFoundException e) {
            assertTrue("CourseNotFoundException thrown", true);
        } catch (Exception e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void gradStudentCourseNotFoundExcepitonTest2() {
        Department d = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, d, 2);
        Course c1 = new Course(d, 101, "Programming 1", "Introduction to Programming", 4, t);
        GradStudent g = new GradStudent("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, d, 1, "Programming");
        try {
            g.courseGPAPoints(c1);
            fail(); 
        } catch (CourseNotFoundException e) {
            assertTrue(true); 
        } catch (Exception e) {
            fail(); 
        }
    }



    


    

    



    



    






}
