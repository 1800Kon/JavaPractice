import java.time.LocalDate;
import java.util.HashSet;

public class School {
    private String schoolName;
    private HashSet<Student> students = new HashSet<>();
    double passingGrade = 5.5;

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public static void main(String[] args) {
        School Babeque = new School("Babeque");
        Student Konstantin = new Student("Konstantin", LocalDate.of(2001, 3, 8));
        Student Ace = new Student("Ace", LocalDate.of(2002, 4, 11));
        Student Frizz = new Student("Frizz", LocalDate.of(1999, 8, 21));
        Student Michael = new Student("Michael", LocalDate.of(2001, 10, 22));
        Student Cardude = new Student("Cardude", LocalDate.of(2001, 9, 15));
        //Adding regular student
        Babeque.addStudentToSchool(Konstantin);
        Babeque.spacer();
        Babeque.addStudentToSchool(Ace);
        Babeque.spacer();
        Babeque.addStudentToSchool(Cardude);
        Babeque.spacer();
        Babeque.addStudentToSchool(Michael);
        Babeque.spacer();
        Babeque.addStudentToSchool(Frizz);
        Babeque.spacer();
        //Showing no duplicates
        Babeque.addStudentToSchool(Konstantin);
        Konstantin.addGrade("Math", 6);
        Babeque.spacer();
        Konstantin.addGrade("Biology", 10);
        Babeque.spacer();
        Michael.addGrade("Math", 3);
        Babeque.spacer();
        Ace.addGrade("Math", 10);
        Babeque.spacer();
        Cardude.addGrade("Biology", 4);
        Babeque.spacer();
        Cardude.addGrade("Math", 1);
        Babeque.spacer();
        //Get all grades
        Babeque.getAllGrades(Konstantin);
        Babeque.spacer();
        //Print all the students
        Babeque.printAllStudents();
        Babeque.spacer();
        //Get the failing grades
        Babeque.getFailingGrades("Math");
        Babeque.spacer();
        //Get student information without spaces / misc characters
        Cardude.getSafeInfo();
        Babeque.spacer();
        Babeque.getSafeSchoolName();
    }

    public void addStudentToSchool(Student student) {
        if (student.getStudentName() != null) {
            if (!this.students.contains(student)) if (this.students.add(student)) {
                System.out.println(student.getStudentName() + " has been added to the school.");
            }
        } else {
            System.out.println("This is an invalid student and has not been added");
        }
    }

    public void printAllStudents() {
        for (Student student : students
        ) {
            student.printStudentName();
        }
    }

    public void spacer() {
        System.out.println("=================================");
    }

    public void getSafeSchoolName() {
        System.out.println(UrlUtility.urlMaker(this.schoolName));
    }

    /**
     * Gets all the grades for a specific student
     * @param student The student for which the grades are being printed
     */
    public void getAllGrades(Student student) {
        if (this.students.contains(student)) {
            if (student.getGradesheet().size() > 0) {
                student.getAllGrades();
            } else {
                System.out.println(student.getStudentName() + " doesn't have any grades yet");
            }
        } else {
            System.out.println("The student is not registered in the school");
        }
    }

    /**
     * Prints all the students which have failed a subject
     * @param subject The subject to be searched for
     */
    public void getFailingGrades(String subject) {
        int i = 0;
        for (Student student : students
        ) {
            if (student.getGradesheet().containsKey(subject)) {
                if (student.getGradesheet().get(subject) < passingGrade) {
                    student.printGrade(subject);
                    i++;
                }
            }
        }
        if (i == 0) {
            System.out.println("Nobody failed or the course name is incorrect!");
        }
    }
}
