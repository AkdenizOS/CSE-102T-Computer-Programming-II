import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**---------------------------------------------------

 * Akdeniz University CSE102T Assignments

 * @author: Yahya Efe Kuruçay

 * @since: 29.02.2024

 * Description: Assignment01

 * Score: 89

 * Website: https://efekurucay.com

*---------------------------------------------------*/
/*
 * Bu bir otomatik maildir!!
 -------------START----------------
20220808005 - Assignment01->89
Test Result
╷
├─ JUnit Jupiter ✔
├─ JUnit Vintage ✔
│  └─ Assignment01_20220808005Test ✔
│     ├─ shouldCreateTeacherWithInvalidRank ✔
│     ├─ teacherShouldPromote ✔
│     ├─ personShouldGetEmail ✔
│     ├─ teacherShouldGetTitleProfessor ✔
│     ├─ shouldCreateCourse ✔
│     ├─ gradStudentShouldSetThesis ✔
│     ├─ courseShouldSetNumber ✔
│     ├─ studentShouldGetAKTS ✔
│     ├─ courseShouldNotSetInvalidDepartment ✘ Expected RuntimeException
│     ├─ courseShouldGetAKTS ✔
│     ├─ shouldCreateStudent ✔
│     ├─ personShouldNotSetInvalidEmail ✔
│     ├─ gradStudentShouldGetThesis ✔
│     ├─ courseShouldGetNumber ✔
│     ├─ personShouldToString ✔
│     ├─ personShouldGetID ✔
│     ├─ personShouldSetID ✔
│     ├─ shouldCreatePerson ✔
│     ├─ personShouldGetDepartment ✔
│     ├─ shouldCreateTeacher ✔
│     ├─ courseShouldNotSetInvalidAKTS ✘ Expected RuntimeException
│     ├─ shouldNotCreatePersonWithInvalidDepartment ✔
│     ├─ teacherShouldToString ✔
│     ├─ courseShouldNotSetInvalidNumber ✘ Expected RuntimeException
│     ├─ personShouldSetDepartment ✔
│     ├─ personShouldGetName ✔
│     ├─ teacherShouldDemote ✔
│     ├─ shouldNotCreateCourseWithInvalidDepartment ✘ Expected RuntimeException
│     ├─ teacherShouldNotDemote ✘ java.lang.AssertionError
│     ├─ studentShouldPassCourse ✔
│     ├─ courseShouldSetTitle ✔
│     ├─ teacherShouldNotPromote ✔
│     ├─ teacherShouldGetTitleAssociateProfessor ✔
│     ├─ courseShouldSetAKTS ✔
│     ├─ courseShouldGetTitle ✔
│     ├─ teacherShouldGetTitleAssistantProfessor ✔
│     ├─ courseShouldReturnCourseCode ✔
│     ├─ personShouldNotSetInvalidDepartment ✔
│     ├─ courseShouldGetDepartment ✔
│     ├─ shouldCreateGradStudent ✔
│     ├─ courseShouldToString ✔
│     ├─ testInheritence ✔
│     ├─ shouldNotCreatePersonWithInvalidEmail ✔
│     ├─ personShouldSetName ✔
│     ├─ courseShouldSetDepartment ✔
│     ├─ shouldNotCreateCourseWithInvalidNumber ✘ Expected RuntimeException
│     └─ personShouldSetEmail ✔
└─ JUnit Platform Suite ✔


--------------END-----------------


 */
/***
 *    ███████╗███████╗███████╗
 *    ██╔════╝██╔════╝██╔════╝
 *    █████╗  █████╗  █████╗  
 *    ██╔══╝  ██╔══╝  ██╔══╝  
 *    ███████╗██║     ███████╗
 *    ╚══════╝╚═╝     ╚══════╝
 *                            
 */

public class Assignment01_20220808005 {
    public static void main(String[] args) throws Exception {
       Course c = new Course("CSE", 102, "Programming 2", "Introduction to OOP", 6);
       System.out.println(c.courseCode()+" - "+c.getTitle());
       System.out.println(c);

       Teacher t = new Teacher("Joseph LEDET","josephledet@akdeniz.edu.tr",123L,"CSE",1);
       System.out.println(t);

       Student s = new Student("Yahya Efe Kurucay", "contact@efekurucay.com", 456L, "CSE");
       System.out.println(s);

       s.passCourse(c);
       System.out.println(s.getAKTS());

       System.out.println("---------");

       Course course = new Course("CSE", 101, "Computer Programming 1", "Introduction to Programming",6);
       Student student = new Student("Yahya Efe", "yahya@efekurucay.com",123L, "CSE");
       student.passCourse(course);
       course.setCourseNum(course.getCourseNum()+10);
       System.out.println(student);
       System.out.println(course);
       course = new Course("CSE", 102, "Computer Programming 2", "Introduction to OOP", 4);
       student.passCourse(course);
       course.setCourseNum(course.getCourseNum()/*-10 */);
       System.out.println(course);
       System.out.println(student);



    }
}//class Assignment01


//Course class
class Course{
    private String depCode; //Must be 3 or 4 characters
    private int courseNum; //Must be in the range 100-999 or 5000-5999 or 7000-7999 
    private String title;
    private String description;
    private int AKTS; //must be positive

    //Constructor Method
    Course(String depCode, int courseNumber, String title, String description, int AKTS) throws Exception {

        if(!validAKTS(AKTS))throw new Exception("ERROR: AKTS must be positive");
        if(!validCourseNum(courseNumber))throw new Exception("ERROR: Invalid Course Number");
        if(!validDepCode(depCode))throw new Exception("ERROR: Invalid Department Name");

        this.depCode = depCode;
        this.courseNum = courseNumber;
        this.title = title;
        this.description = description;
        this.AKTS = AKTS;

        
    }
    public String getDepCode() {
        return depCode;
    }
    public void setDepCode(String depCode) throws Exception {
        

        if(validDepCode(depCode)){this.depCode = depCode;}
        else{ throw new Exception("ERROR: Invalid Department Name"); }
    }

    public static boolean validDepCode(String dep){
        int l = dep.length();

        if(l==3 || l==4){return true;}
        else{return false;}

    }
    
    public int getCourseNum() {
        return courseNum;
    }
     
    public void setCourseNum(int courseNum) throws Exception {
       
        if (validCourseNum(courseNum)) 
        this.courseNum = courseNum;
        else  
        throw new Exception("ERROR: Invalid Course Number");
    }
 
    public boolean validCourseNum(int courseNum){
        int c = courseNum;
        if(c>=100&&c<=999|| c>=5000 &&c<=5999 || c>= 7000 && c<=7999  ) return true;

        else return false;



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

    public void setAKTS(int aKTS) throws Exception {
        
        if(validAKTS(aKTS))
        AKTS = aKTS;

        else throw new Exception("ERROR: AKTS must be positive");

    }

    public boolean validAKTS(int AKTS){

        return AKTS>0;
    }


    public String courseCode(){return depCode + courseNum;}


    @Override
    public String toString() {
        return courseCode() + " - " + title + " (" + AKTS + ")";
    }


}

//Person class
class Person{

    private String name;
    private String email;//Must be of the form {username}@{university name}.{domain} 
    private long ID;
    private String departmentCode;//Must be 3 or 4 characters 

    Person(String name, String email, long ID, String departmentCode) throws Exception {
        if(!validEmail(email))throw new IllegalArgumentException("ERROR: Invalid Email Address");
        if(!Course.validDepCode(departmentCode))throw new IllegalArgumentException("ERROR: Invalid department code");

    
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.departmentCode = departmentCode;
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

    public void setEmail(String email) throws Exception {
        if (validEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException("ERROR: Invalid Email Address");
    }


   

public boolean validEmail(String email) {
    String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
}


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) throws Exception {

        if(Course.validDepCode(departmentCode))
        this.departmentCode = departmentCode;
        else throw new Exception("ERROR: Invalid department code");
    
    }
 

    @Override
    public String toString() {
        return name + " (" + ID + ") - " + email;
    }


}//Person class


//Teacher class 
class Teacher extends Person{
    private int rank;

    Teacher(String name, String email, long number, String departmentCode, int rank) throws Exception {
        super(name, email, number, departmentCode);
        if (!validRank(rank))throw new IllegalArgumentException("ERROR: Invalid rank value."); 
          
         
        this.rank = rank;
    }

    public void setRank(int rank) {
        if (validRank(rank)) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid rank value.");
        }
    }

    public boolean validRank(int rank){

        if (rank >= 1 && rank <= 4) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        switch (rank) {
            case 1:
                return "Lecturer";
            case 2:
                return "Assistant Professor";
            case 3:
                return "Associate Professor";
            case 4:
                return "Professor";
            default:
                return "";
        }
    }

    public void promote() {
        if (rank < 4) {
            rank++;
        }
    }

    public void demote() {
        if (rank > 1) {
            rank--;
        }
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}//Teacher class 

//Student class 
class Student extends Person{
    private int AKTS;

    public Student(String name, String email, long number, String departmentCode) throws Exception {
        super(name, email, number, departmentCode);
        this.AKTS = 0;
    }

    public int getAKTS() {
        return AKTS;
    }

    public void passCourse(Course course) {
        AKTS += course.getAKTS();
    }

    @Override
    public String toString() {
        // 
        return super.toString();
    }


}//Student class 


//GradStudent class
class GradStudent extends Student{

    private int rank;
    private String thesisTopic;

    public GradStudent(String name, String email, long number, String departmentCode, int rank, String thesisTopic) throws Exception {
        super(name, email, number, departmentCode);
        if(!validRank(rank)) throw new IllegalArgumentException("ERROR: Invalid rank value.");
        this.rank = rank;
        this.thesisTopic = thesisTopic;
    }

    public void setRank(int rank) {
        if (validRank(rank)) {
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid rank value.");
        }
    }

    public boolean validRank(int rank){
        if (rank == 1 || rank == 2 || rank == 3) {
            return true;
        } else {
           return false;
        }

    }

    public String getLevel() {
        switch (rank) {
            case 1:
                return "Master's Student";
            case 2:
                return "Doctoral Student";
            case 3:
                return "Doctoral Candidate";
            default:
                return "";
        }
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String toString() {
        
        return super.toString();
    }

}//GradStudent class 


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

/*
 * 
 * Bu bir otomatik maildir!!
 -------------START----------------
20220808005 - Assignment01->89
Test Result
╷
├─ JUnit Jupiter ✔
├─ JUnit Vintage ✔
│  └─ Assignment01_20220808005Test ✔
│     ├─ shouldCreateTeacherWithInvalidRank ✔
│     ├─ teacherShouldPromote ✔
│     ├─ personShouldGetEmail ✔
│     ├─ teacherShouldGetTitleProfessor ✔
│     ├─ shouldCreateCourse ✔
│     ├─ gradStudentShouldSetThesis ✔
│     ├─ courseShouldSetNumber ✔
│     ├─ studentShouldGetAKTS ✔
│     ├─ courseShouldNotSetInvalidDepartment ✘ Expected RuntimeException
│     ├─ courseShouldGetAKTS ✔
│     ├─ shouldCreateStudent ✔
│     ├─ personShouldNotSetInvalidEmail ✔
│     ├─ gradStudentShouldGetThesis ✔
│     ├─ courseShouldGetNumber ✔
│     ├─ personShouldToString ✔
│     ├─ personShouldGetID ✔
│     ├─ personShouldSetID ✔
│     ├─ shouldCreatePerson ✔
│     ├─ personShouldGetDepartment ✔
│     ├─ shouldCreateTeacher ✔
│     ├─ courseShouldNotSetInvalidAKTS ✘ Expected RuntimeException
│     ├─ shouldNotCreatePersonWithInvalidDepartment ✔
│     ├─ teacherShouldToString ✔
│     ├─ courseShouldNotSetInvalidNumber ✘ Expected RuntimeException
│     ├─ personShouldSetDepartment ✔
│     ├─ personShouldGetName ✔
│     ├─ teacherShouldDemote ✔
│     ├─ shouldNotCreateCourseWithInvalidDepartment ✘ Expected RuntimeException
│     ├─ teacherShouldNotDemote ✘ java.lang.AssertionError
│     ├─ studentShouldPassCourse ✔
│     ├─ courseShouldSetTitle ✔
│     ├─ teacherShouldNotPromote ✔
│     ├─ teacherShouldGetTitleAssociateProfessor ✔
│     ├─ courseShouldSetAKTS ✔
│     ├─ courseShouldGetTitle ✔
│     ├─ teacherShouldGetTitleAssistantProfessor ✔
│     ├─ courseShouldReturnCourseCode ✔
│     ├─ personShouldNotSetInvalidDepartment ✔
│     ├─ courseShouldGetDepartment ✔
│     ├─ shouldCreateGradStudent ✔
│     ├─ courseShouldToString ✔
│     ├─ testInheritence ✔
│     ├─ shouldNotCreatePersonWithInvalidEmail ✔
│     ├─ personShouldSetName ✔
│     ├─ courseShouldSetDepartment ✔
│     ├─ shouldNotCreateCourseWithInvalidNumber ✘ Expected RuntimeException
│     └─ personShouldSetEmail ✔
└─ JUnit Platform Suite ✔


--------------END-----------------
 */