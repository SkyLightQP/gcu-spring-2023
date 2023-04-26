public class GradeTest {
    static Scholarships scholarships = new Scholarships();

    public static void main(String[] args) {
        Student kim = new Student("Kim", 20231293);
        Student park = new Student("Park", 20221928);
        Student choi = new Student("Choi", 20221234);

        kim.initialize();
        park.initialize();
        choi.initialize();

        kim.inputSubjectScore();
        System.out.println("=================");
        park.inputSubjectScore();
        System.out.println("=================");
        choi.inputSubjectScore();

        System.out.println();

        System.out.println(kim.writeOutput());
        System.out.println(park.writeOutput());
        System.out.println(choi.writeOutput());

        System.out.println();

        compareScore(park, kim);
        compareScore(choi, park);

        System.out.println();

        compareStudent(kim, park);
        compareStudent(park, choi);

        System.out.println();

        scholarships.registerScholarships();
        scholarships.writeOutput();
        System.out.println("=================");
        findScholarshipStudents(kim, park, choi);
    }

    public static void compareScore(Student a, Student b) {
        int compare = a.compareScore(b);
        if (compare == 1) {
            System.out.println(a.getName() + " has higher score than " + b.getName());
        } else if (compare == -1) {
            System.out.println(a.getName() + " has lower score than " + b.getName());
        } else {
            System.out.println(a.getName() + " and " + b.getName() + " scores are equals.");
        }
    }

    public static void compareStudent(Student a, Student b) {
        boolean equal = a.equals(b);
        if (equal) {
            System.out.println(a.getName() + " and " + b.getName() + " are equal person.");
        } else {
            System.out.println(a.getName() + " and " + b.getName() + " are different person.");
        }
    }

    public static void findScholarshipStudents(Student a, Student b, Student c) {
        System.out.println("In AI.Software department, 2 students out of 3 students got the scholarship");
        Student firstStudent, secondStudent;
        if (a.totalRating() > b.totalRating()) {
            if (a.totalRating() > c.totalRating()) {
                firstStudent = a;
                secondStudent = c;
            } else {
                firstStudent = c;
                secondStudent = a;
            }
        } else {
            if (b.totalRating() > c.totalRating()) {
                firstStudent = b;
                secondStudent = c;
            } else {
                firstStudent = c;
                secondStudent = b;
            }
        }

        System.out.println(firstStudent.getName() + " will receive scholarship of " + scholarships.getFirstScholarship());
        System.out.println(secondStudent.getName() + " will receive scholarship of " + scholarships.getSecondScholarship());
    }
}
