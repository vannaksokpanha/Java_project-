class School {
    private Student[] students;
    private Course[] courses;
    private Teacher[] teachers;
    private Transcript[] transcripts;
    private int studentCount;
    private int courseCount;
    private int teacherCount;
    private int transcriptCount;
    private static int totalBranch = 0;

    public static final String VIEW_COURSES = "VIEW_COURSES";
    public static final String CREATE_COURSE = "CREATE_COURSE";
    public static final String UPDATE_COURSE = "UPDATE_COURSE";
    public static final String DELETE_COURSE = "DELETE_COURSE";
    public static final String GRADE_STUDENT = "GRADE_STUDENT";
    public static final String VIEW_OWN_GRADES = "VIEW_OWN_GRADES";
    public static final String VIEW_ALL_GRADES = "VIEW_ALL_GRADES";
    public static final String UPDATE_SCORES = "UPDATE_SCORES";
    public static final String VIEW_TRANSCRIPT = "VIEW_TRANSCRIPT";
    public static final String VIEW_OWN_TRANSCRIPT = "VIEW_OWN_TRANSCRIPT";
    public static final String CREATE_USER = "CREATE_USER";
    public static final String VIEW_USERS = "VIEW_USERS";
    public static final String UPDATE_USER = "UPDATE_USER";
    public static final String DELETE_USER = "DELETE_USER";
    public static final String UPDATE_ATTENDANCE = "UPDATE_ATTENDANCE";
    public static final String VIEW_ATTENDANCE = "VIEW_ATTENDANCE";
    public static final String VIEW_OWN_ATTENDANCE = "VIEW_OWN_ATTENDANCE";
    
    public School(int capacity) {
        this.students = new Student[capacity];
        this.courses = new Course[capacity];
        this.teachers = new Teacher[capacity];
        this.transcripts = new Transcript[capacity];
        this.studentCount = 0;
        this.courseCount = 0;
        this.teacherCount = 0;
        this.transcriptCount = 0;
        totalBranch++;
    }
    
    public static int gettotalBranch() {
        return totalBranch;
    }
    
    void addStudent(String fullName, String majorField, String emailAddress,
                   int enrollmentYear, String phoneNumber) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(fullName, majorField, 
                                                emailAddress, enrollmentYear, 
                                                phoneNumber);
            studentCount++;
        }
    }
    
    void addCourse(String title, String code, int credits) {
        if (courseCount < courses.length) {
            courses[courseCount] = new Course(title, code, credits);
            courseCount++;
        }
    }
    
    void addTeacher(String teacherName, String teacherId, String department,
                   String phoneNumber, String password) {
        if (teacherCount < teachers.length) {
            teachers[teacherCount] = new Teacher(teacherName, teacherId, 
                                                department, phoneNumber, password);
            teacherCount++;
        }
    }
    
    Course findCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equals(code)) {
                return courses[i];
            }
        }
        return null;
    }
    
    Teacher findTeacher(String teacherId) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getTeacherId().equals(teacherId)) {
                return teachers[i];
            }
        }
        return null;
    }
    
    Transcript createTranscript(Student student) {
        if (transcriptCount < transcripts.length) {
            Transcript t = new Transcript(transcriptCount + 1, student, 10);
            transcripts[transcriptCount] = t;
            transcriptCount++;
            return t;
        }
        return null;
    }
    
    public Student getStudent(int index) {
        if (index >= 0 && index < studentCount) {
            return students[index];
        }
        return null;
    }
    
    public Student findStudentByName(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getFullName().equals(name)) {
                return students[i];
            }
        }
        return null;
    }
    
    public int getStudentCount() {
        return studentCount;
    }
    
    public int getTeacherCount() {
        return teacherCount;
    }
}