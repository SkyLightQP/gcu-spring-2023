public class Student {
    private String studentName;
    private int studentID;

    private CourseGrade oop;
    private CourseGrade web;
    private CourseGrade c;

    public Student() {
        this.studentName = "EMPTY";
        this.studentID = -1;
    }

    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public void initialize() {
        oop = new CourseGrade("OOP", 100);
        web = new CourseGrade("Web", 400);
        c = new CourseGrade("C", 200);
    }

    public void inputSubjectScore() {
        System.out.println("Please enter scores of " + getName() + " (ID: " + getStudentID() + ")\n");
        oop.inputScore();
        web.inputScore();
        c.inputScore();
    }

    public int totalRating() {
        return oop.getCurrentScore() + web.getCurrentScore() + c.getCurrentScore();
    }

    public int maxRating() {
        return oop.getMaxScore() + web.getMaxScore() + c.getMaxScore();
    }

    public String writeOutput() {
        return this.studentName + "'s total score is " + this.totalRating() + "/" + this.maxRating();
    }

    public int compareScore(Student other) {
        if (this.totalRating() < other.totalRating()) return -1;
        if (this.totalRating() > other.totalRating()) return 1;
        return 0;
    }

    public boolean equals(Student other) {
        return this.studentName.equals(other.studentName)
                && this.studentID == other.studentID
                && this.totalRating() == other.totalRating();
    }

    public String getName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }
}
