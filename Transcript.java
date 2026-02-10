class Transcript {
    private Student student;
    private CourseGrade[] grades;
    private double[] savedScores;
    private int gradeCount;
    private int transcriptId;
    
    public Transcript(int transcriptId, Student student, int maxCourses) {
        this.transcriptId = transcriptId;
        this.student = student;
        this.grades = new CourseGrade[maxCourses];
        this.savedScores = new double[maxCourses];
        this.gradeCount = 0;
    }
    
    void addGrade(CourseGrade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            savedScores[gradeCount] = grade.getTotalScore();
            gradeCount++;
        }
    }
    
    double calculateGPA() {
        if (gradeCount == 0) return 0.0;
        
        double totalPoints = 0.0;
        int totalCredits = 0;
        
        for (int i = 0; i < gradeCount; i++) {
            double gradePoints = grades[i].getGradePoints();
            int credits = grades[i].getCourse().getCredits();
            totalPoints += (gradePoints * credits);
            totalCredits += credits;
        }
        
        if (totalCredits > 0) {
            return totalPoints / totalCredits;
        } else {
            return 0.0;
        }
    }
    
    String getOverallGrade() {
        double gpa = calculateGPA();
        
        if (gpa >= 3.5) return "A";
        else if (gpa >= 3.0) return "B+";
        else if (gpa >= 2.5) return "B";
        else if (gpa >= 2.0) return "C+";
        else if (gpa >= 1.0) return "C";
        else return "F";
    }
    
    int getGradeCount() {
        return gradeCount;
    }
    
    void displayTranscript() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TRANSCRIPT");
        System.out.println("=".repeat(50));
        System.out.println("Student: " + student.getFullName());
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Major: " + student.getMajorField());
        System.out.println("Transcript #: " + transcriptId);
        System.out.println("-".repeat(50));
        System.out.println("GRADES:");
        
        for (int i = 0; i < gradeCount; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            grades[i].showGradeDetails();
            System.out.println("    Saved Score: " + 
                             String.format("%.2f", savedScores[i]));
        }
        
        System.out.println("-".repeat(50));
        System.out.println("SUMMARY:");
        System.out.println("   Courses: " + gradeCount);
        System.out.println("   GPA: " + String.format("%.2f", calculateGPA()));
        System.out.println("   Overall: " + getOverallGrade());
        System.out.println("=".repeat(50));
    }
}