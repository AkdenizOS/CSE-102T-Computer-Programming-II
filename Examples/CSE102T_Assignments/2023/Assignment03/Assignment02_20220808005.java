import java.util.ArrayList;
/**---------------------------------------------------

 * Akdeniz University CSE102T Assignments

 * @author: Yahya Efe Kuruçay

 * @since: 07.04.2024

 * Description: Assignment02

 * Score:87

 * Website: https://efekurucay.com

*---------------------------------------------------*/
/*
 * Bu bir otomatik maildir!!
 -------------START----------------
20220808005 - Assignment02->87
Test Result
╷
├─ JUnit Jupiter ✔
├─ JUnit Vintage ✔
│  └─ Assignment02_20220808005Test ✔
│     ├─ shouldNotCreateDepartmentWithInvalidID ✔
│     ├─ shouldNotCreateCourseWithDifferentDepartment ✔
│     ├─ departmentShouldNotSetChairDifferentDepartment ✘ Should have thrown DepartmentMismatchException
│     ├─ DepartmentMismatchExceptionShouldHaveDepartmentTeacherConstructor ✔
│     ├─ shouldGetGPA ✔
│     ├─ shouldCourseResultThrowCourseNotFoundException ✘ Should have thrown CourseNotFoundException
│     ├─ shouldAddCourse ✔
│     ├─ departmentShouldSetChair ✔
│     ├─ shouldCreateCourse ✔
│     ├─ shouldNotCreateGradStudent ✔
│     ├─ shouldCreateStudent ✔
│     ├─ teachershouldSetDepartmentAndChair ✘ Should set department expected:<Department@4e32a067> but was:<Department@4a0d2d79>
│     ├─ gradStudentCourseResultThrowException ✘ Index 0 out of bounds for length 0
│     ├─ shouldGetCourseGPAPoints ✔
│     ├─ courseShouldNotSetTeacherFromDifferentDpt ✔
│     ├─ shouldReplaceCourse ✘ expected:<11> but was:<17>
│     ├─ shouldGetCourseGradeLetter ✔
│     ├─ shouldCreateTeacher ✔
│     ├─ shouldCreateDepartment ✔
│     ├─ teachershouldSetDepartment ✘ Should set department expected:<Department@6770946d> but was:<Department@69b776f3>
│     ├─ teacherShouldPromoteDemote ✔
│     ├─ shouldGetGPAwithOneFailedCourse ✔
│     ├─ shouldGetCourseResultFailed ✔
│     ├─ DepartmentMismatchExceptionShouldHaveCourseTeacherConstructor ✔
│     ├─ courseMutators ✔
│     ├─ teacherShouldNotDemote ✔
│     ├─ gradStudentShouldGetCourseGPAPoints ✔
│     ├─ gradStudentShouldGetCourseResult ✔
│     ├─ teacherShouldNotPromote ✔
│     ├─ gradStudentShouldGetCourseGradeLetter ✔
│     ├─ shouldThrowInvalidGradeException ✔
│     ├─ departmentAccessors ✔
│     ├─ departmentShouldNotSetInvalidID ✔
│     ├─ shouldCreateGradStudent ✔
│     ├─ courseAccessors ✔
│     ├─ shouldGetCourseResultConditionallyPassed ✔
│     └─ departmentMutators ✔
└─ JUnit Platform Suite ✔


--------------END-----------------
 */

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

public class Assignment02_20220808005 {

    public static void main(String[] args) {
        Department cse = new Department("CSE", "Computer Science Engineering");
        Department cse2 = new Department("CSE", "Computer Science Engineering");
        Teacher t = new Teacher("Joseph Ledet", "josephledet@akdeniz.edu.tr", 123L, cse, 1);
        Course c101 = new Course(cse, 101, "Programing 1", "İntro to Programing", 6, t);
        Course c102 = new Course(cse2, 102, "Programing 2", "OOP", 4, t);
        Student s = new Student("Yahya Efe Kuruçay", "contact@efekurucay.com", 123L, cse);
        s.addCourse(c101, 70);
        s.addCourse(c102, 50);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
        System.out.println(s);
        s = new GradStudent("Yahya Efe", "me@efekurucay.com", 456L, cse,2, "MDE");
        s.addCourse(c101, 70);
        s.addCourse(c102, 50);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
        System.out.println(s);

        cse.setChair(t);
        Department math = new Department("MATH", "Mathematics");
        System.out.println(cse.getCode() + " C = " + cse.getChair());
        t.setDepartment(math);
        System.out.println(cse.getCode() + " C = " + cse.getChair());
        t.setDepartment(cse);
        System.out.println(cse.getCode() + " C = " + cse.getChair());

    }
}
class Department{
    private String code;
    private String name;
    private Teacher chair;
    Department(String code, String name){
       setCode(code);
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        if(code.length() == 3 || code.length() == 4)
            this.code = code;
        else{
            throw new InvalidCodeException(code);
        }    
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Teacher getChair() {
        if(chair == null)
            return null;
        if(chair.getDepartment()==this)
            return chair;    
        else
            throw new DepartmantMismatchException(chair.getDepartment(), chair);   
    }
    public void setChair(Teacher chair) {
        if (this.chair == null) {
            this.chair = chair;
        } else if (chair == null && chair == null) {
            this.chair = null;
        } else {
            throw new DepartmantMismatchException(chair.getDepartment(), chair);
        }
    }
}
class Course{
    private Department department;
    private Teacher teacher;
    private int courseNumber; 
    private String title;
    private String description;
    private int AKTS; 

    public Course(Department department,int courseNumber,String title,String description,int AKTS,Teacher teacher){
        setDepartment(department);
        setCourseNumber(courseNumber);
        setTitle(title);
        setDescription(description);
        setAKTS(AKTS);
        setTeacher(teacher);
        if(this.department != teacher.getDepartment())
            throw new DepartmantMismatchException(department, teacher);
        

    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }
    public void setTeacher(Teacher teacher) {
        if(teacher.getDepartment() == department)
            this.teacher = teacher;
        else 
            throw new DepartmantMismatchException(department, teacher);    
    }    
    
    public Teacher getTeacher() {
        if(teacher.getDepartment() == department)
            return teacher;
        else 
            throw new DepartmantMismatchException(department, teacher);    
    }
    @Override
    public String toString() {
        return courseCode() +" - "+title + " ("+AKTS+")";
    }
    public String courseCode(){
        return department.getCode()+courseNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        if(isCourseNumberValid(courseNumber))
            this.courseNumber = courseNumber;
        else  {
            throw new InvalidValueEntered(courseNumber, "Person", "courseNumber", "must be 100-99 or 5000-5999 or 7000-7999");
        }         
    }
    public boolean isCourseNumberValid(int courseNumber){
        // must be in range 100-999,5000-5999,7000-7999
        if(courseNumber >= 100 && courseNumber <= 999)
            return true;
        else if(courseNumber >=5000 && courseNumber <= 5999)
            return true;
        else if(courseNumber >= 7000 && courseNumber <= 7999 )
            return true;
        else 
            return false;           
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void setAKTS(int AKTS) {
        // must be possitive
        if(AKTS > 0)
            this.AKTS = AKTS;
        else{ 
            throw new InvalidValueEntered(AKTS,"Course","AKTS","Must be possitive");
        }      
    }

}
abstract class Person{
    private Department department;
    private String name;
    private String email; 
    private long id;
    public Person(String name, String email, long id, Department department) {
        setName(name);
        setEmail(email);
        setId(id);
        setDepartment(department);
        
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return name+ " "+" ("+ id+")" +" - "+ email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        // there is a certain form
        if(isEmailValid(email))
            this.email = email;
        else{
            throw new InvalidValueEntered(email, "Person", "email", "must be format of xxx@gmail.com");
        }    
    }
    public boolean isEmailValid(String email){
        if(!email.contains("@"))
            return false;
        int indexOfat = email.indexOf("@");
        if(email.substring(0, indexOfat).contains("."))
            return false;
        if(email.substring(indexOfat+1).contains("@"))
            return false;
        if(!email.contains("."))
            return false;
        else
            return true;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}

class Teacher extends Person{
    int rank;
    
    public Teacher(String name, String email, long id, Department department,int rank){
        super(name, email, id, department);
        if(rank <= 5 && rank >= 1)
            this.rank = rank;
        else    
            throw new InvalidRankException(rank);


            
    }
    @Override
    public void setDepartment(Department department) {
        if(getDepartment() == null)
            super.setDepartment(department);
        else if(department.getChair() != getDepartment().getChair()){
            getDepartment().setChair(null);;
            department.setChair(this);
        }
        else
            department.setChair(null);   
    }
    
    public String getTitle(){
        switch(rank){
            case 1:
                return "Teaching Assistant";
            case 2:
                return "Lecturer";
            case 3:
                return "Assistant Professor";
            case 4:
                return "Associate Professor";
            default:
                return "Professor";    
        }
    }
    public void promote(){
        if(rank +1 <= 4)
            rank++;
        else{
            throw new InvalidRankException(rank) ;
        }    
    }
    public void demote(){
        if(rank -1 >= 1)
            rank--;
        else{
            throw new InvalidRankException(rank);
        }    
    }
    @Override
    public String toString() {
        return super.toString();
    }
    public Object getRank() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRank'");
    }
}
class Student extends Person{
    private int failedAKTS;
    private int AKTS;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Double> grades = new ArrayList<>();

    public Student(String name, String email, long id, Department department) {
        super(name, email, id, department);
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getAKTS() {
        return AKTS;
    }
    public int getAttemptedAKTS(){
        return AKTS+ failedAKTS;
    }
    public void addCourse(Course course, double grade){

        if(grade < 100 && grade > 0){
            if(grade > 45)
                AKTS += course.getAKTS();
            else
                failedAKTS += course.getAKTS();     
            if(!courses.contains(course)){
                courses.add(course);
                grades.add(grade);
            }else{
                courses.set(courses.indexOf(course),course);
                grades.set(courses.indexOf(course),grade);
            }
        }
        else{
            throw new InvalidGradeException(grade);
        }
    }   
    public double courseGPAPoints(Course course){
        if(course== null)
            throw new CourseNotFoundException();
        else{
            double point = grades.get(courses.indexOf(course));
            if(point >87)
                return 4.0;
            else if(point >80)
                return 3.5;    
            else if(point >73)
                return 3.0;    
            else if(point >66)
                return 2.5;      
            else if(point >59)
                return 2.0;   
            else if(point >52)
                return 1.5;   
            else if(point >45)
                return 1.0;
            else if(point >34)
                return 0.5;     
            else                         
                return 0.0;
        }    
    }
    public double getGPA() {
        if (courses.isEmpty()) {
            return 0;
        }
        
        double totalGPA= 0; 
        int totalAKTS = 0;

        for(int i = 0; i < courses.size(); i++){
            totalGPA += courseGPAPoints(courses.get(i))*courses.get(i).getAKTS();
            totalAKTS += courses.get(i).getAKTS();
        }

        return totalGPA / totalAKTS;
    }
    public String courseGradeLetter(Course course){
        if(getGPA() >3.5){
            return "AA";
        }
        else if(getGPA() >3.0){
            return "BA";
        }
        else if(getGPA() >2.5){
            return "BB";
        }
        else if(getGPA() >2.0){
            return "CB";
        }
        else if(getGPA() >1.5){
            return "CC";
        }
        else if(getGPA() >1.0){
            return "DD";
        }
        else if(getGPA() >0.5){
            return "FD";
        }
        else{
            return "FF";
        }
    }
    public String courseResult(Course course){
        if(getGPA() > 1.5)
            return "Passed";
        else if(getGPA() > 0.5)
            return "Conditionally Passed";
        else
            return "Failed";        
    }
    @Override
    public String toString() {
        return super.toString() +" -GPA:" + getGPA();
    }



}
class GradStudent extends Student{
    int rank;
    private String thesisTopic;
    public GradStudent(String name, String email, long id, Department department,int rank , String thesisTopic) {
        super(name, email, id, department);
        setRank(rank);
        this.thesisTopic = thesisTopic;
    }
    public void setRank(int rank) {
        if(rank >= 1 && rank <= 3)
            this.rank = rank;
        else{
            throw new InvalidRankException(rank);
        }    
    }

    public String getLevel(){
        switch(rank){
            case 1: 
                return "Master's Student";
            case 2:
                return "Doctoral Student";
            default:
                return "Doctoral Candidate";
        }
    }
    public String getThesisTopic(){
            return thesisTopic;
    }
    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }
    @Override
    public double courseGPAPoints(Course course) {
        if(course== null)
            throw new CourseNotFoundException();
        else{
            double point = getGrades().get(getCourses().indexOf(course));
            if(point >89)
                return 4.0;
            else if(point >84)
                return 3.5;    
            else if(point >79)
                return 3.0;    
            else if(point >74)
                return 2.5;      
            else if(point >69)
                return 2.0;    
            else                         
                return 0.0;
        }    
        
    }
    @Override
    public double getGPA() {
        return super.getGPA();
    }
    @Override
    public String courseGradeLetter(Course course) {
        double GPA = getGPA();
        if(GPA>3.5)
            return "AA";
        else if(GPA > 3.0)
            return "BA";   
        else if(GPA > 2.5)
            return "BB";
        else if(GPA > 2.0)
            return "CB";
        else if(GPA > 0.0)
            return "CC";
        else     
            return "FF";
    }
    @Override
    public String courseResult(Course course) {
        if(getGPA() >= 2.0)
            return "Passed";
        else 
            return "Failed";    
    }

}
class CourseNotFoundException extends RuntimeException{
    private Course course;
    private Student student;
    @Override
    public String toString() {
        
        return "CourseNotFoundException: " + student.getId() + " has not yet taken " + course.courseCode();
    }
}
class DepartmantMismatchException extends RuntimeException{
    private Department department;
    private Teacher person;
    private Course course;
    DepartmantMismatchException(Course course,Teacher person){
        this.course = course;
        this.person = person;
        department = null;
    }
    DepartmantMismatchException(Department department,Teacher person){
        this.department = department;
        this.person = person;
        course = null;
    }
    @Override
    public String toString() {
        if(course == null){
            return "DepartmentMismatchException: " + person.getName()+" ("+ person.getId()+") cannot be chair of " + department.getCode()+" because"+
            " currently assigned to "+ person.getDepartment().getCode();
        }
        else{
            return "DepartmentMismatchException: " + person.getName()+" ("+ person.getId()+") cannot teach " + course.courseCode()+" because"+
            " currently assigned to "+ person.getDepartment();
        }

    }
}
class InvalidGradeException extends RuntimeException{
    private double grade;
    InvalidGradeException(double grade){
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "InvalidGradeException: " + grade;
    }
}
class InvalidRankException extends RuntimeException{
    private int rank;
    InvalidRankException(int rank){
        this.rank = rank;
    }
    @Override
    public String toString() {
        return "InvalidRankException: "+ rank;
    }
}
class InvalidCodeException extends RuntimeException{
    private String code;
    InvalidCodeException(String code){
        this.code = code;
    }
    @Override
    public String toString() {
        return "invalidCodeException: Department - code "+code+" (length must be 3 or 4)";
    }
}
class InvalidValueEntered extends RuntimeException{
    InvalidValueEntered(String value,String className, String valueName,String validValues){
        System.out.println("invalidValueEntered: "+className + " - " +valueName+ " " +value+" (" + validValues+")");
    }
    InvalidValueEntered(int value,String className, String valueName,String validValues){
        System.out.println("invalidValueEntered: "+className + " - " +valueName+ " " +value+" (" + validValues+")");
    }
}

/***
 *              _____                    _____                    _____          
 *             /\    \                  /\    \                  /\    \         
 *            /::\    \                /::\    \                /::\    \        
 *           /::::\    \              /::::\    \              /::::\    \       
 *          /::::::\    \            /::::::\    \            /::::::\    \      
 *         /:::/\:::\    \          /:::/\:::\    \          /:::/\:::\    \     
 *        /:::/__\:::\    \        /:::/__\:::\    \        /:::/__\:::\    \    
 *       /::::\   \:::\    \      /::::\   \:::\    \      /::::\   \:::\    \   
 *      /::::::\   \:::\    \    /::::::\   \:::\    \    /::::::\   \:::\    \  
 *     /:::/\:::\   \:::\    \  /:::/\:::\   \:::\    \  /:::/\:::\   \:::\    \ 
 *    /:::/__\:::\   \:::\____\/:::/  \:::\   \:::\____\/:::/__\:::\   \:::\____\
 *    \:::\   \:::\   \::/    /\::/    \:::\   \::/    /\:::\   \:::\   \::/    /
 *     \:::\   \:::\   \/____/  \/____/ \:::\   \/____/  \:::\   \:::\   \/____/ 
 *      \:::\   \:::\    \               \:::\    \       \:::\   \:::\    \     
 *       \:::\   \:::\____\               \:::\____\       \:::\   \:::\____\    
 *        \:::\   \::/    /                \::/    /        \:::\   \::/    /    
 *         \:::\   \/____/                  \/____/          \:::\   \/____/     
 *          \:::\    \                                        \:::\    \         
 *           \:::\____\                                        \:::\____\        
 *            \::/    /                                         \::/    /        
 *             \/____/                                           \/____/         
 *                                                                               
 */
