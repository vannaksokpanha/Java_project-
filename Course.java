class Course {
    private String title;
    private String code;
    private int credits;
    private static int totalCourses = 0;
    
    public Course(String title, String code, int credits) {
        this.title = title;
        this.code = code;
        this.credits = credits;
        totalCourses++;
    }
    
    public static int getTotalCourses() {
        return totalCourses;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCode() {
        return code;
    }
    
    public int getCredits() {
        return credits;
    }
    
    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}