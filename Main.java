class Main {
    public static void main(String[] args) {
        School school = new School(50);
        
        school.addCourse("Linear Algebra", "MATH101", 4);
        school.addCourse("Physics Fundamentals", "PHYS101", 4);
        school.addCourse("Biology Introduction", "BIO101", 3);
        school.addCourse("Chemistry Basics", "CHEM201", 3);

        school.addTeacher("Dr. Smith", "T001", "Mathematics", 
                         "123456789", "Math@123!");
        school.addTeacher("Prof. Johnson", "T002", "Physics", 
                         "987654321", "Physics#456");
        school.addTeacher("Dr. Wilson", "T003", "Biology", 
                         "555666777", "Bio$789");
        school.addTeacher("Prof. Brown", "T004", "Chemistry", 
                         "111222333", "Chem!101");
        
        school.addStudent("Dara", "CS", "dara@email.com", 2023, "012345678");
        school.addStudent("Sokha", "DB", "sokha@email.com", 2023, "023456789");
        
        // Use safe methods instead of array getters
        Student dara = school.getStudent(0);
        Student sokha = school.getStudent(1);
        
        Teacher mathTeacher = school.findTeacher("T001");
        Teacher physicsTeacher = school.findTeacher("T002");
        Teacher bioTeacher = school.findTeacher("T003");
        Teacher chemTeacher = school.findTeacher("T004");
        
        Course math = school.findCourse("MATH101");
        Course physics = school.findCourse("PHYS101");
        Course biology = school.findCourse("BIO101");
        Course chem = school.findCourse("CHEM201");
        
        System.out.println("GRADING SYSTEM");
        System.out.println("=".repeat(30) + "\n");
        
        System.out.println("1. Teachers login:");
        System.out.println("-".repeat(30));
        mathTeacher.login("123456789", "Math@123!");
        physicsTeacher.login("987654321", "Physics#456");
        bioTeacher.login("555666777", "Bio$789");
        chemTeacher.login("111222333", "Chem!101");
        
        System.out.println("\n2. Create CourseGrade objects:");
        System.out.println("-".repeat(30));
        
        CourseGrade daraMath = new CourseGrade(dara, math, mathTeacher, 85.0, 90.0, 88.0, 95.0);
        CourseGrade daraPhysics = new CourseGrade(dara, physics, physicsTeacher, 78.0, 82.0, 85.0, 90.0);
        CourseGrade daraBio = new CourseGrade(dara, biology, bioTeacher, 92.0, 88.0, 90.0, 98.0);
        
        CourseGrade sokhaMath = new CourseGrade(sokha, math, mathTeacher, 75.0, 80.0, 78.0, 85.0);
        CourseGrade sokhaPhysics = new CourseGrade(sokha, physics, physicsTeacher, 82.0, 85.0, 80.0, 88.0);
        CourseGrade sokhaBio = new CourseGrade(sokha, biology, bioTeacher, 88.0, 85.0, 90.0, 92.0);
        CourseGrade sokhaChem = new CourseGrade(sokha, chem, chemTeacher, 90.0, 92.0, 88.0, 95.0);
        
        System.out.println("\nSTUDENT: " + dara.getFullName());
        Transcript daraTranscript = school.createTranscript(dara);
        
        daraTranscript.addGrade(daraMath);
        daraTranscript.addGrade(daraPhysics);
        daraTranscript.addGrade(daraBio);
        daraTranscript.displayTranscript();
        
        System.out.println("\nSTUDENT: " + sokha.getFullName());
        Transcript sokhaTranscript = school.createTranscript(sokha);
        
        sokhaTranscript.addGrade(sokhaMath);
        sokhaTranscript.addGrade(sokhaPhysics);
        sokhaTranscript.addGrade(sokhaBio);
        sokhaTranscript.addGrade(sokhaChem);
        sokhaTranscript.displayTranscript();
        
        System.out.println("\n" + "*".repeat(30));
        System.out.println("PROOFS");
        System.out.println("*".repeat(30));
        
        System.out.println("\n1. Primitive copy:");
        double original = 88.0;
        double copy = original;
        copy = 100.0;
        System.out.println("   Original: " + original);
        System.out.println("   Copy: " + copy);
        
        System.out.println("\n2. Reference copy:");
        CourseGrade ref1 = daraPhysics;
        CourseGrade ref2 = ref1;
        System.out.println("   Before: ref1.getTotalScore() = " + String.format("%.2f", ref1.getTotalScore()));
        ref2.setFinalExamScore(95.0);
        System.out.println("   After: ref1.getTotalScore() = " + String.format("%.2f", ref1.getTotalScore()));
        
        System.out.println("\n3. Array stores references:");
        System.out.println("   Sokha transcript grades: " + sokhaTranscript.getGradeCount());
        
        System.out.println("\n4. Snapshot behavior:");
        System.out.println("   Saved: " + String.format("%.2f", sokhaTranscript.calculateGPA()));
        sokhaBio.setFinalExamScore(60.0);
        System.out.println("   New bio score: " + String.format("%.2f", sokhaBio.getTotalScore()));
        System.out.println("   Saved GPA stays: " + String.format("%.2f", sokhaTranscript.calculateGPA()));
        
        System.out.println("\n5. Test without teacher login:");
        System.out.println("-".repeat(30));
        physicsTeacher.logout();
        System.out.println("   Physics teacher logged in: " + physicsTeacher.isLoggedIn());
        System.out.println("   Try update assignments: " + sokhaPhysics.setAssignmentsScore(80.0));
        
        System.out.println("\n6. Wrong password test:");
        System.out.println("-".repeat(30));
        System.out.print("   Math teacher login with wrong password: ");
        boolean wrongLogin = mathTeacher.login("123456789", "WrongPass!");
        System.out.println(wrongLogin);
        System.out.println("   Can update math score: " + sokhaMath.setFinalExamScore(85.0));
        
        System.out.println("\nStatic data proof:");
        System.out.println("   Total courses: " + Course.getTotalCourses());
        System.out.println("   Next student ID: " + Student.getNextStudentId());
        System.out.println("   Total schools: " + School.gettotalBranch());
        
        System.out.println("\nNull check:");
        Course notFound = school.findCourse("ART999");
        if (notFound == null) {
            System.out.println("   Course not found (null)");
        }
    }
}   