import java.util.Scanner;

public class Main{
    static String[] studentNames;
    static double[][] studentScores;
    static char[] studentGrades;
    static int noOfStudents;
    static boolean isRunning = true;
    static double[] averageScores;

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        while(isRunning){
            System.out.println("****STUDENT GRADE MANAGER****");
            System.out.println("1. Enter grades for new class");
            System.out.println("2. View all students");
            System.out.println("3. Show class statistics");
            System.out.println("4. Find highest/lowest scores");
            System.out.println("5. Search for a student");
            System.out.println("6. Exit");
            System.out.println("*****************************");
            int choice;
            while(true){
                System.out.print("Choose option (1-6): ");
                if(scanner.hasNextInt()){
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice < 1 || choice > 6){
                        System.out.println("Invalid choice enter choice between 1 and 6");
                    }
                    else{
                        break;
                    }
                }
                else{
                    System.out.println("Invalid input!!");
                    scanner.next();
                }
            }
            switch(choice){
                case 1 -> studentEntry();
                case 2 -> displayStudent();
                case 3 -> showStatistics();
                case 4 -> highestLowestScore();
                case 5 -> searchStudent();
                case 6 -> {
                    System.out.print("Do you want to exit(true/false): ");
                    boolean exitChoice = scanner.nextBoolean();
                    if(exitChoice){
                        isRunning =false;
                        System.out.println("\uD83D\uDC4B Goodbye! Thanks for using Grade Manager!");
                        printASCIIPattern();
                    }
                    else{
                        System.out.println("Continuing..........");
                    }
                }
                default -> System.out.println("Invalid input");
            }
        }
        scanner.close();
    }

    private static void studentEntry() {
        while(true){
            System.out.print("How many student records do you want to store?: ");
            if(scanner.hasNextInt()){
                noOfStudents = scanner.nextInt();
                scanner.nextLine();
                if(noOfStudents < 1){
                    System.out.println("Invalid input!!! number cannot be negative or zero");
                }
                else {
                    break;
                }
            }
            else{
                System.out.println("Invalid input!! enter only integer values.");
                scanner.next();
            }
        }
        studentNames = new String[noOfStudents];
        studentScores = new double[noOfStudents][3];
        studentGrades = new char[noOfStudents];
        averageScores = new double[noOfStudents];
        for(int i = 0;i<noOfStudents;i++){
            System.out.print("Enter name of student "+(i+1)+ ":");
            studentNames[i]  = scanner.nextLine();

            double totalScore = 0;
            for(int j =0;j<3;j++){
                while(true){
                    System.out.print("Enter test score "+(j+1)+":");
                    if(scanner.hasNextDouble()){
                        studentScores[i][j] = scanner.nextDouble();
                        scanner.nextLine();
                        if(studentScores[i][j] < 0 || studentScores[i][j] > 100){
                            System.out.println("Score must be between 0 and 100");
                        }
                        else{
                            totalScore += studentScores[i][j];
                            break;
                        }
                    }
                    else{
                        System.out.println("Invalid input please enter a number.");
                        scanner.next();
                    }
                }
            }
            double averageScore = totalScore/3;
            char grade = getGrade(averageScore);
            studentGrades[i] = grade;
            averageScores[i] = averageScore;

            System.out.println("\n--- Student Summary ---");
            System.out.println("Student: " + studentNames[i]);
            System.out.println("Scores: " + studentScores[i][0] + ", " +
                    studentScores[i][1] + ", " +
                    studentScores[i][2]);
            System.out.printf("Average: %.2f\n", averageScore);
            System.out.println("Grade: " + grade);
            System.out.println("-------------------------\n");
        }
        System.out.println("All student data entered successfully!");
    }

    private static void displayStudent() {
        if(studentNames == null || noOfStudents == 0){
            System.out.println("\n⚠ No student data available.\n");
            return;
        }
        System.out.println("\n******STUDENTS RESULTS******");
        System.out.printf("%-4s %-10s %-18s %-6s %s\n", "#", "Name", "Scores", "Avg", "Grade");
        System.out.println("-----------------------------------------------------");
        for(int i = 0;i<noOfStudents;i++){
            String scoresStr = String.format("%.0f %.0f %.0f",
                    studentScores[i][0], studentScores[i][1], studentScores[i][2]);
            System.out.printf("%-4d %-10s %-18s %-6.2f %c\n",
                    (i + 1),
                    studentNames[i],
                    scoresStr,
                    averageScores[i],
                    studentGrades[i]);

        }
        System.out.println("---------------------------------------------\n");
    }

    private static char getGrade(double averageScore){
        if(averageScore >= 80){
            return 'A';
        }
        else if(averageScore >= 70){
            return 'B';
        }
        else if(averageScore >= 60){
            return 'C';
        }
        else if(averageScore >= 50){
            return  'D';
        }
        else if(averageScore >= 40){
            return 'E';
        }
        else {
            return 'F';
        }
    }

    private static void showStatistics() {
        if(studentNames == null || noOfStudents == 0){
            System.out.println("\n⚠No student data to analyze.\n");
            return;
        }
        System.out.println("\n\uD83D\uDCCA CLASS STATISTICS \uD83D\uDCCA");
        System.out.println("******************************\n");

        double totalAverage =0;
        double max = averageScores[0];
        double min = averageScores[0];
        String bestStudent = studentNames[0];
        String worstStudent = studentNames[0];
        char bestGrade = studentGrades[0];
        char worstGrade = studentGrades[0];
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0;
        for(int i =0;i<noOfStudents;i++){
            totalAverage += averageScores[i];
            if(averageScores[i] > max){
                max = averageScores[i];
                bestStudent = studentNames[i];
                bestGrade = studentGrades[i];
            }
            if(averageScores[i] < min){
                min = averageScores[i];
                worstStudent = studentNames[i];
                worstGrade = studentGrades[i];
            }
            switch (studentGrades[i]) {
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                case 'E' -> countE++;
                case 'F' -> countF++;
            }
        }
        double classAverage = totalAverage/noOfStudents;
        System.out.printf("Class Average: %.2f\n", classAverage);
        System.out.println();

        System.out.println("\nGrade Distribution:");
        System.out.println("A: " + countA + " | B: " + countB + " | C: " + countC +
                " | D: " + countD + " | E: " + countE + " | F: " + countF);

        System.out.println("\nPerformance Highlights:");
        System.out.printf("Best Student:  %s | Avg: %.2f | Grade: %c\n", bestStudent, max, bestGrade);
        System.out.printf("Worst Student: %s | Avg: %.2f | Grade: %c\n", worstStudent, min, worstGrade);
        System.out.println("******************************\n");
        System.out.println();
        System.out.println("******************************");
    }

    private static void highestLowestScore() {
        if(studentNames == null || noOfStudents == 0){
            System.out.println("\n⚠ No student data available.\n");
            return;
        }
        String search;
        System.out.print("Whose highest and lowest score would you like to check?: ");
        search= scanner.nextLine();
        boolean found = false;
        for(int i =0; i<noOfStudents;i++){
            if(studentNames[i].equalsIgnoreCase(search)){
                System.out.println("found");
                found = true;

                double maxScore = studentScores[i][0];
                double minScore = studentScores[i][0];

                for(int j =0;j<3;j++){
                    if(studentScores[i][j] > maxScore){
                        maxScore = studentScores[i][j];
                    }
                    if(studentScores[i][j] < minScore){
                        minScore = studentScores[i][j];
                    }
                }
                System.out.println("\n✅ Results for " + studentNames[i] + ":");
                System.out.println("All scores: ");
                for(int j = 0;j<3;j++){
                    System.out.println(studentScores[i][j] +" ");
                }
                System.out.println("Highest Score: " + maxScore);
                System.out.println("Lowest Score:  " + minScore);
                System.out.println();
                break;
            }

        }
        if(!found){
            System.out.println("\nStudent "+search+ "not found.");
        }
    }

    private static void searchStudent() {
        if(studentNames == null || noOfStudents == 0){
            System.out.println("\n⚠ No student data available.\n");
            return;
        }
        String search;
        System.out.print("Which student are you searching for?: ");
        search = scanner.nextLine();
        boolean found = false;




        for(int i =0;i<noOfStudents;i++){
            if(studentNames[i].equalsIgnoreCase(search)){
                System.out.println(search+" Found");
                System.out.println("*********************************");
                System.out.println("Student: "+ studentNames[i]);
                System.out.printf("Scores: %.0f, %.0f, %.0f\n",
                        studentScores[i][0], studentScores[i][1], studentScores[i][2]);
                System.out.printf("Average: %.2f\n",averageScores[i]);
                System.out.println("Grade: "+ studentGrades[i]);
                System.out.println("**********************************");

                found = true;
            }
        }
        if(!found){
            System.out.println(search+" not found");
        }
    }
    public static void printASCIIPattern() {
        System.out.println("   *   ");
        System.out.println("  ***  ");
        System.out.println(" ***** ");
        System.out.println("*******");
        System.out.println("  ***  ");
    }

}