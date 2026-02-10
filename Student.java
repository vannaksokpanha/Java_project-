class Student {
    private String fullName;
    private String majorField;
    private int studentId;
    private String emailAddress;
    private int enrollmentYear;
    private String phoneNumber;
    private static int nextStudentId = 1000;
    
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
    public String toString() {
        return fullName + " (ID: " + studentId + ", " + majorField + ")";
    }
}