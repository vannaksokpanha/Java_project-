class Teacher implements IPerson {
    private String teacherName;
    private String teacherId;
    private String department;
    private String phoneNumber;
    private String password;
    private boolean isLoggedIn;
    
    public Teacher(String teacherName, String teacherId, String department, 
                   String phoneNumber, String password) {
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.department = department;
        setPhoneNumber(phoneNumber);
        setPassword(password);
        this.isLoggedIn = false;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{9}$";
        if (phoneNumber.matches(phoneRegex)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "000000000";
        }
    }
    
    public void setPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";
        if (password.matches(passwordRegex)) {
            this.password = password;
        } else {
            this.password = "Default@123";
        }
    }
    
    public boolean login(String inputPhone, String inputPassword) {
        if (this.phoneNumber.equals(inputPhone) && this.password.equals(inputPassword)) {
            this.isLoggedIn = true;
            System.out.println("Teacher " + teacherName + " logged in successfully.");
            return true;
        }
        this.isLoggedIn = false;
        System.out.println("Login failed for " + teacherName + ".");
        return false;
    }
    
    public void logout() {
        this.isLoggedIn = false;
        System.out.println("Teacher " + teacherName + " logged out.");
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public String getTeacherId() {
        return teacherId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return teacherName + " (" + teacherId + ", " + department + ")";
    }

    @Override
    public boolean can(String action) {
        if(action.equals(School.VIEW_COURSES) || action.equals(School.GRADE_STUDENT)  || action.equals(School.VIEW_ALL_GRADES) || action.equals(School.UPDATE_SCORES) || action.equals(School.UPDATE_ATTENDANCE)) {
            return true;
        }
        return false;
    }

    @Override
    public String getId() {
        return teacherId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return "TEACHER";
    }

    @Override
    public String getUserName() {
        return teacherName;
    }
}