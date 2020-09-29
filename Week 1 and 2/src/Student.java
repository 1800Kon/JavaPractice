import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Student {
    private String studentName;
    private long studentNo;
    private LocalDate birthDate;
    private HashMap<String, Integer> gradesheet;
    private static final int maxGrades = 10;

    public HashMap<String, Integer> getGradesheet() {
        return gradesheet;
    }

    //Constructor
    public Student(String studentName, LocalDate birthDate) {
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.studentNo = new Date().getTime();
        this.gradesheet = new HashMap<>();
    }

    /**
     * @param subject The subject being added
     * @param grade   The grade assigned to the subject
     */
    public void addGrade(String subject, Integer grade) {
        if (this.gradesheet.size() < maxGrades) {
            if (!this.gradesheet.containsKey(subject)) {
                this.gradesheet.put(subject, grade);
                System.out.println(this.getStudentName() + " has registered a " + grade + " in " + subject);
            } else {
                System.out.println("The " + subject + " subject is already in the gradesheet for the student");
            }
        }else {
            System.out.println("The student has the max amount of grades assignable");
        }
    }

    /**
     *
     * @param subject Subject from which a grade will be printed
     */
    public void printGrade(String subject) {
        if (this.gradesheet.containsKey(subject)) {
            System.out.println(this.getStudentName() + " scored a " + this.gradesheet.get(subject));
        }
    }

    /**
     * Get all the grades for a student
     */
    public void getAllGrades() {
        if (this.gradesheet.size() > 0) {
            for (String i : this.gradesheet.keySet()) {
                System.out.println("Subject: " + i + " Grade: " + this.gradesheet.get(i));
            }
        }
    }

    /**
     * Get student info in url safe way
     */
    public void getSafeInfo() {
        System.out.println(UrlUtility.urlMaker(this.studentName));
        System.out.println(UrlUtility.urlMaker(this.birthDate.toString()));
    }

    //Getters and setters
    public String getStudentName() {
        return this.studentName;
    }

    public void printStudentName() {
        System.out.println(this.studentName);
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentNo() {
        return this.studentNo;
    }

    public void setStudentNo(long studentNo) {
        this.studentNo = studentNo;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;

    }
}
