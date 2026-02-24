class Student implements IPerson {
    private String fullName;
    private String majorField;
    private int studentId;
    private String emailAddress;
    private int enrollmentYear;
    private String phoneNumber;
    private static int nextStudentId = 1000;
    private String password;
    
    public Student(String fullName, String majorField, String emailAddress, 
                  int enrollmentYear, String phoneNumber) {
        this.fullName = fullName;
        this.majorField = majorField;
        this.studentId = nextStudentId;
        this.emailAddress = emailAddress;
        this.enrollmentYear = enrollmentYear;
        this.phoneNumber = phoneNumber;
        nextStudentId++;
    }
    
    public static int getNextStudentId() {
        return nextStudentId;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getMajorField() {
        return majorField;
        
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public boolean can(String action) { 
        if(action.equals(School.VIEW_COURSES) || action.equals(School.VIEW_OWN_GRADES) || action.equals(School.VIEW_OWN_ATTENDANCE) || action.equals(School.VIEW_OWN_TRANSCRIPT)) {
            return true;
        }
        return false;
    }

    @Override
    public String getId() {
        return String.valueOf(studentId);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String getUserName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName + " (ID: " + studentId + ", " + majorField + ")";
    }
}