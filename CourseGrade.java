class CourseGrade {
    private Student student;
    private Course course;
    private Teacher teacher;
    private double assignmentsScore = 0.0;
    private double midtermExamScore = 0.0;
    private double finalExamScore = 0.0;
    private double attendanceScore = 0.0;
    
    public CourseGrade(Student student, Course course, Teacher teacher) {
        this.student = student;
        this.course = course;
        this.teacher = teacher;
        this.assignmentsScore = 0.0;
        this.midtermExamScore = 0.0;
        this.finalExamScore = 0.0;
        this.attendanceScore = 0.0;
    }
    
    public CourseGrade(Student student, Course course, Teacher teacher,
                    double assignmentsScore, double midtermExamScore,
                    double finalExamScore, double attendanceScore) {
        this.student = student;
        this.course = course;
        this.teacher = teacher;
        this.assignmentsScore = assignmentsScore;
        this.midtermExamScore = midtermExamScore;
        this.finalExamScore = finalExamScore;
        this.attendanceScore = attendanceScore;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public boolean setFinalExamScore(double finalExamScore) {
        if (teacher.isLoggedIn()) {
            this.finalExamScore = finalExamScore;
            System.out.println(teacher.getTeacherName() + " updated final exam score for " + 
                             student.getFullName() + " to " + finalExamScore);
            return true;
        } else {
            System.out.println("Cannot update: " + teacher.getTeacherName() + " is not logged in.");
            return false;
        }
    }
    
    public boolean setAssignmentsScore(double assignmentsScore) {
        if (teacher.isLoggedIn()) {
            this.assignmentsScore = assignmentsScore;
            System.out.println(teacher.getTeacherName() + " updated assignments score for " + 
                             student.getFullName() + " to " + assignmentsScore);
            return true;
        } else {
            System.out.println("Cannot update: " + teacher.getTeacherName() + " is not logged in.");
            return false;
        }
    }
    
    public boolean setMidtermExamScore(double midtermExamScore) {
        if (teacher.isLoggedIn()) {
            this.midtermExamScore = midtermExamScore;
            System.out.println(teacher.getTeacherName() + " updated midterm score for " + 
                             student.getFullName() + " to " + midtermExamScore);
            return true;
        } else {
            System.out.println("Cannot update: " + teacher.getTeacherName() + " is not logged in.");
            return false;
        }
    }
    
    public boolean setAttendanceScore(double attendanceScore) {
        if (teacher.isLoggedIn()) {
            this.attendanceScore = attendanceScore;
            System.out.println(teacher.getTeacherName() + " updated attendance score for " + 
                             student.getFullName() + " to " + attendanceScore);
            return true;
        } else {
            System.out.println("Cannot update: " + teacher.getTeacherName() + " is not logged in.");
            return false;
        }
    }
    
    public double getTotalScore() {
        return (assignmentsScore * 0.25) + 
            (midtermExamScore * 0.25) + 
            (finalExamScore * 0.40) + 
            (attendanceScore * 0.10);
    }
    
    public String getLetterGrade() {
        double score = getTotalScore();
        
        if (score >= 85.0) return "A";
        else if (score >= 80.0) return "B+";
        else if (score >= 70.0) return "B";
        else if (score >= 65.0) return "C+";
        else if (score >= 50.0) return "C";
        else return "F";
    }
    
    public double getGradePoints() {
        String grade = getLetterGrade();
        
        if (grade.equals("A")) return 4.00;
        else if (grade.equals("B+")) return 3.50;
        else if (grade.equals("B")) return 3.00;
        else if (grade.equals("C+")) return 2.50;
        else if (grade.equals("C")) return 2.00;
        else return 0.00;
    }
    
    void showGradeDetails() {
        System.out.println("  " + course.getCode() + ": " + course.getTitle());
        System.out.println("     Teacher: " + teacher.getTeacherName());
        System.out.println("     Assignments: " + assignmentsScore + " | Midterm: " + 
                          midtermExamScore + " | Final: " + finalExamScore);
        System.out.println("     Attendance: " + attendanceScore + "%");
        System.out.println("     Total Score: " + String.format("%.2f", getTotalScore()));
        System.out.println("     Grade: " + getLetterGrade());
        System.out.println("     GPA Points: " + String.format("%.2f", getGradePoints()));
    }
    
    @Override
    public String toString() {
        return course.getCode() + ": " + String.format("%.2f", getTotalScore()) + 
            " (" + getLetterGrade() + ")";
    }
}