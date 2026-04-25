import java.util.ArrayList;
import java.util.HashMap;
/**---------------------------------------------------
 * Akdeniz University CSE102T Assignments
 * @author: Yahya Efe Kuruçay
 * @since: 20.05.2024
 * Description: Assignment04
 * Score:?
 * Website: https://efekurucay.com
*---------------------------------------------------*/
/***
 *    ███████╗███████╗███████╗
 *    ██╔════╝██╔════╝██╔════╝
 *    █████╗  █████╗  █████╗  
 *    ██╔══╝  ██╔══╝  ██╔══╝  
 *    ███████╗██║     ███████╗
 *    ╚══════╝╚═╝     ╚══════╝                      
 *            __     _                                                          
 *           / _|   | |                                                         
 *       ___| |_ ___| | ___   _ _ __ _   _  ___ __ _ _   _   ___ ___  _ __ ___  
 *      / _ \  _/ _ \ |/ / | | | '__| | | |/ __/ _` | | | | / __/ _ \| '_ ` _ \ 
 *     |  __/ ||  __/   <| |_| | |  | |_| | (_| (_| | |_| || (_| (_) | | | | | |
 *      \___|_| \___|_|\_\\__,_|_|   \__,_|\___\__,_|\__, (_)___\___/|_| |_| |_|
 *                                                    __/ |                     
 *                                                   |___/                      
 */

public class Assignment04_20220808005 {
    public static void main(String[] args) {
        Department cse = new Department("CSE", "Computer Engineering");
        Teacher teacher = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L, cse, 3);
        System.out.println(teacher);
        
        Student stu = new Student("Yahya Efe Kuruçay", "contact@efekurucay.com", 456L, cse);
        Semester s1 = new Semester(1, 2020);
        Course c101 = new Course(cse, 101, "Programming 1", "Introduction", 6, teacher);
        Semester s2 = new Semester(2, 2021);
        Course c102 = new Course(cse, 102, "Programming 2", "OOP", 4, teacher);
        Course c204 = new Course(cse, 204, "Database Systems", "DBMS", 6, teacher);

        stu.addCourse(c101, s1, 80);
        stu.addCourse(c102, s2, 30);
        stu.addCourse(c204, s2, 70);

        System.out.println("List Grades for CSE101:\n" + stu.listGrades(c101));
        System.out.println("List Grades for Spring 2021:\n" + stu.listGrades(s2));
        System.out.println("Student Transcript:\n" + stu.transcript());

        GradStudent gs = new GradStudent("Yahya Efe Kuruçay ", "contact@efekurucay.com", 789L, cse, 2, "MDE");
        gs.addCourse(c101, s1, 85);
        gs.addCourse(c102, s2, 40);
        gs.setTeachingAssistant(c101);
        System.out.println("Teaching Assistant:\n" + gs.getTeachingAssistant());
        try {
            gs.setTeachingAssistant(c102);
        } catch (CourseNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("Teaching Assistant:\n" + gs.getTeachingAssistant());
    }
}
class Department {
    private String code;
    private String name;
    private Teacher chair;

    Department(String code, String name) {
        setCode(code);
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code.length() == 3 || code.length() == 4) {
            this.code = code;
        } else {
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
        if (chair == null) return null;
        if (chair.getDepartment() == this) return chair;
        else throw new DepartmantMismatchException(chair.getDepartment(), chair);
    }

    public void setChair(Teacher chair) {
        if (this.chair == null) {
            this.chair = chair;
        } else if (chair == null) {
            this.chair = null;
        } else {
            throw new DepartmantMismatchException(chair.getDepartment(), chair);
        }
    }
}

class Course {
    private Department department;
    private Teacher teacher;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;

    public Course(Department department, int courseNumber, String title, String description, int AKTS, Teacher teacher) {
        setDepartment(department);
        setCourseNumber(courseNumber);
        setTitle(title);
        setDescription(description);
        setAKTS(AKTS);
        setTeacher(teacher);
        if (this.department != teacher.getDepartment())
            throw new DepartmantMismatchException(department, teacher);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.getDepartment() == department)
            this.teacher = teacher;
        else
            throw new DepartmantMismatchException(department, teacher);
    }

    public Teacher getTeacher() {
        if (teacher.getDepartment() == department)
            return teacher;
        else
            throw new DepartmantMismatchException(department, teacher);
    }

    @Override
    public String toString() {
        return courseCode() + " - " + title + " (" + AKTS + ")";
    }

    public String courseCode() {
        return department.getCode() + courseNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        if (isCourseNumberValid(courseNumber))
            this.courseNumber = courseNumber;
        else {
            throw new InvalidValueEntered(courseNumber, "Course", "courseNumber", "must be 100-999, 5000-5999 or 7000-7999");
        }
    }

    public boolean isCourseNumberValid(int courseNumber) {
        // must be in range 100-999,5000-5999,7000-7999
        if (courseNumber >= 100 && courseNumber <= 999)
            return true;
        else if (courseNumber >= 5000 && courseNumber <= 5999)
            return true;
        else if (courseNumber >= 7000 && courseNumber <= 7999)
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
        if (AKTS > 0)
            this.AKTS = AKTS;
        else {
            throw new InvalidValueEntered(AKTS, "Course", "AKTS", "Must be positive");
        }
    }
}

abstract class Person {
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
        return name + " (" + id + ") - " + email;
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
        if (isEmailValid(email))
            this.email = email;
        else {
            throw new InvalidValueEntered(email, "Person", "email", "must be format of xxx@gmail.com");
        }
    }

    public boolean isEmailValid(String email) {
        if (!email.contains("@"))
            return false;
        int indexOfAt = email.indexOf("@");
        if (email.substring(0, indexOfAt).contains("."))
            return false;
        if (email.substring(indexOfAt + 1).contains("@"))
            return false;
        if (!email.contains("."))
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

class Teacher extends Person {
    int rank;

    public Teacher(String name, String email, long id, Department department, int rank) {
        super(name, email, id, department);
        if (rank <= 5 && rank >= 1)
            this.rank = rank;
        else
            throw new InvalidRankException(rank);
    }

    @Override
    public void setDepartment(Department department) {
        if (getDepartment() == null)
            super.setDepartment(department);
        else if (department.getChair() != getDepartment().getChair()) {
            getDepartment().setChair(null);
            department.setChair(this);
        } else
            department.setChair(null);
    }

    public String getTitle() {
        switch (rank) {
            case 1:
                return "Lecturer";
            case 2:
                return "Adjunct Instructor";
            case 3:
                return "Assistant Professor";
            case 4:
                return "Associate Professor";
            default:
                return "Professor";
        }
    }

    public void promote() {
        if (rank + 1 <= 5)
            rank++;
        else {
            throw new InvalidRankException(rank);
        }
    }

    public void demote() {
        if (rank - 1 >= 1)
            rank--;
        else {
            throw new InvalidRankException(rank);
        }
    }

    @Override
    public String toString() {
        return getTitle() + " " + super.toString();
    }
}

class Student extends Person {
    private int failedAKTS;
    private int AKTS;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Double> grades = new ArrayList<>();
    private HashMap<Course, ArrayList<Semester>> courseSemesters = new HashMap<>();
    private HashMap<Semester, ArrayList<Course>> semesterCourses = new HashMap<>();

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

    public int getAttemptedAKTS() {
        return AKTS + failedAKTS;
    }

    public void addCourse(Course course, Semester semester, double grade) {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException(grade);
        }

        // Add course and grade
        if (!courses.contains(course)) {
            courses.add(course);
            grades.add(grade);
        } else {
            int index = courses.indexOf(course);
            grades.set(index, grade);
        }

        // Add course to semester
        courseSemesters.putIfAbsent(course, new ArrayList<>());
        if (!courseSemesters.get(course).contains(semester)) {
            courseSemesters.get(course).add(semester);
        }

        // Add semester to course
        semesterCourses.putIfAbsent(semester, new ArrayList<>());
        if (!semesterCourses.get(semester).contains(course)) {
            semesterCourses.get(semester).add(course);
        }

        if (grade >= 45) {
            AKTS += course.getAKTS();
        } else {
            failedAKTS += course.getAKTS();
        }
    }

    public double courseGPAPoints(Course course) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException(course, this);
        }

        double maxGrade = grades.get(courses.indexOf(course));
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course) && grades.get(i) > maxGrade) {
                maxGrade = grades.get(i);
            }
        }

        if (maxGrade > 87) return 4.0;
        else if (maxGrade > 80) return 3.5;
        else if (maxGrade > 73) return 3.0;
        else if (maxGrade > 66) return 2.5;
        else if (maxGrade > 59) return 2.0;
        else if (maxGrade > 52) return 1.5;
        else if (maxGrade > 45) return 1.0;
        else if (maxGrade > 34) return 0.5;
        else return 0.0;
    }

    public String courseGradeLetter(Course course) {
        double gpaPoints = courseGPAPoints(course);

        if (gpaPoints == 4.0) return "AA";
        else if (gpaPoints == 3.5) return "BA";
        else if (gpaPoints == 3.0) return "BB";
        else if (gpaPoints == 2.5) return "CB";
        else if (gpaPoints == 2.0) return "CC";
        else if (gpaPoints == 1.5) return "DC";
        else if (gpaPoints == 1.0) return "DD";
        else if (gpaPoints == 0.5) return "FD";
        else return "FF";
    }

    public String courseResult(Course course) {
        double gpaPoints = courseGPAPoints(course);

        if (gpaPoints >= 1.0) return "Passed";
        else if (gpaPoints > 0.0) return "Conditionally Passed";
        else return "Failed";
    }

    public String listGrades(Semester semester) {
        if (!semesterCourses.containsKey(semester)) {
            throw new SemesterNotFoundException(this, semester);
        }

        StringBuilder result = new StringBuilder();
        ArrayList<Course> coursesInSemester = semesterCourses.get(semester);
        for (Course course : coursesInSemester) {
            result.append(course.courseCode()).append(" - ").append(courseGradeLetter(course)).append("\n");
        }
        return result.toString();
    }

    public String listGrades(Course course) {
        if (!courseSemesters.containsKey(course)) {
            throw new CourseNotFoundException(course, this);
        }

        StringBuilder result = new StringBuilder();
        ArrayList<Semester> semestersForCourse = courseSemesters.get(course);
        for (Semester semester : semestersForCourse) {
            result.append(semester).append(" - ").append(courseGradeLetter(course));
        }
        return result.toString();
    }

    public String transcript() {
        StringBuilder result = new StringBuilder();

        for (Semester semester : semesterCourses.keySet()) {
            result.append(semester).append(":\n");
            ArrayList<Course> coursesInSemester = semesterCourses.get(semester);
            double semesterGPA = 0;
            int semesterAKTS = 0;
            for (Course course : coursesInSemester) {
                result.append(course.courseCode()).append(" - ").append(courseGradeLetter(course)).append("\n");
                semesterGPA += courseGPAPoints(course) * course.getAKTS();
                semesterAKTS += course.getAKTS();
            }
            result.append("GPA: ").append(semesterGPA / semesterAKTS).append("\n\n");
        }

        double totalGPA = getGPA();
        result.append("Overall GPA: ").append(totalGPA);
        return result.toString();
    }

    public double getGPA() {
        double totalGPA = 0;
        int totalAKTS = 0;
        for (int i = 0; i < courses.size(); i++) {
            totalGPA += courseGPAPoints(courses.get(i)) * courses.get(i).getAKTS();
            totalAKTS += courses.get(i).getAKTS();
        }
        return totalGPA / totalAKTS;
    }
}

class GradStudent extends Student {
    private Course teachingAssistantCourse;
    @SuppressWarnings("unused")
    private String thesisTopic;
    @SuppressWarnings("unused")
    private int rank;

    public GradStudent(String name, String email, long id, Department department, int rank, String thesisTopic) {
        super(name, email, id, department);
        setRank(rank);
        this.thesisTopic = thesisTopic;
    }

    public void setRank(int rank) {
        if (rank >= 1 && rank <= 3) {
            this.rank = rank;
        } else {
            throw new InvalidRankException(rank);
        }
    }

    public void setTeachingAssistant(Course course) {
        if (!getCourses().contains(course) || getGrades().get(getCourses().indexOf(course)) < 80) {
            throw new CourseNotFoundException(course, this);
        }
        this.teachingAssistantCourse = course;
    }

    public Course getTeachingAssistant() {
        return this.teachingAssistantCourse;
    }
}

class Semester {
    private final int season;
    private final int year;

    public Semester(int season, int year) {
        if (season < 1 || season > 3) {
            throw new IllegalArgumentException("Season must be 1, 2, or 3");
        }
        this.season = season;
        this.year = year;
    }

    public String getSeason() {
        switch (season) {
            case 1:
                return "Fall";
            case 2:
                return "Spring";
            case 3:
                return "Summer";
            default:
                throw new IllegalStateException("Unexpected value: " + season);
        }
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getSeason() + " - " + year;
    }
}

class SemesterNotFoundException extends RuntimeException {
    private Student student;
    private Semester semester;

    public SemesterNotFoundException(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterNotFoundException: " + student.getId() + " has not taken any courses in " + semester;
    }
}

class CourseNotFoundException extends RuntimeException {
    private Course course;
    private Student student;

    public CourseNotFoundException(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " + student.getId() + " has not yet taken " + course.courseCode();
    }
}

class DepartmantMismatchException extends RuntimeException {
    private Department department;
    private Teacher person;
    private Course course;

    DepartmantMismatchException(Course course, Teacher person) {
        this.course = course;
        this.person = person;
        department = null;
    }

    DepartmantMismatchException(Department department, Teacher person) {
        this.department = department;
        this.person = person;
        course = null;
    }

    @Override
    public String toString() {
        if (course == null) {
            return "DepartmentMismatchException: " + person.getName() + " (" + person.getId() + ") cannot be chair of " + department.getCode() + " because currently assigned to " + person.getDepartment().getCode();
        } else {
            return "DepartmentMismatchException: " + person.getName() + " (" + person.getId() + ") cannot teach " + course.courseCode() + " because currently assigned to " + person.getDepartment().getCode();
        }
    }
}

class InvalidGradeException extends RuntimeException {
    private double grade;

    InvalidGradeException(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "InvalidGradeException: " + grade;
    }
}

class InvalidRankException extends RuntimeException {
    private int rank;

    InvalidRankException(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "InvalidRankException: " + rank;
    }
}

class InvalidCodeException extends RuntimeException {
    private String code;

    InvalidCodeException(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "invalidCodeException: Department - code " + code + " (length must be 3 or 4)";
    }
}

class InvalidValueEntered extends RuntimeException {
    InvalidValueEntered(String value, String className, String valueName, String validValues) {
        System.out.println("invalidValueEntered: " + className + " - " + valueName + " " + value + " (" + validValues + ")");
    }

    InvalidValueEntered(int value, String className, String valueName, String validValues) {
        System.out.println("invalidValueEntered: " + className + " - " + valueName + " " + value + " (" + validValues + ")");
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