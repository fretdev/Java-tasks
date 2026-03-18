import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean calculateGrade = true;

        while (calculateGrade){
            int total = 0;
            int[] scores = new int[5];
            char[] grades = new char[5];
            String[] descriptions= new String[5];
            double average;

            System.out.println("*****************");
            System.out.println("Grade Calculator");
            System.out.println("*****************");

            for(int i = 0;i<5;i++){
                int score;
                while(true){
                    System.out.print("Enter score(0-100): ");
                    if(scanner.hasNextInt()){
                        score = scanner.nextInt();
                        scanner.nextLine();
                        if(score < 0 || score > 100){
                            System.out.println("Score must be between 0 and 100!");
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        System.out.println("Invalid input! Please enter an integer.");
                        scanner.nextLine();
                    }
                }

                scores[i] = score;
                char grade;
                if(score >= 80){
                    grade = 'A';
                }
                else if(score >= 70){
                    grade = 'B';
                }
                else if(score >= 60){
                    grade = 'C';
                }
                else if(score >= 50){
                    grade = 'D';
                }
                else if(score >= 40){
                    grade = 'E';
                }
                else {
                    grade = 'F';
                }

                grades[i] = grade;
                String description;
                switch (grade){
                    case 'A' -> description = "Excellent";
                    case 'B' -> description = "Very Good";
                    case 'C' -> description = "Good";
                    case 'D' -> description = "Pass";
                    case 'E' -> description = "Weak pass";
                    case 'F' -> description = "Fail";
                    default -> description = "Invalid input";
                }
                descriptions[i] = description;
                System.out.println("Grade: "+grade+" - "+description);
                System.out.println("*****************");
            }
            for(int i =0;i < 5;i++){
                total+=scores[i];
            }
            average = total/5.0;
            System.out.println("Score Average: "+ average);

            System.out.println("\n******STUDENT RESULTS*****");
            for (int i = 0; i < 5; i++) {
                System.out.println("Student "+(i + 1) +"  "+ scores[i] +"  " +grades[i]+"  " +descriptions[i]);
            }

            printASCIIPattern();

            System.out.println();
            System.out.print("Do you want to recalculate grades(true/false): ");
            calculateGrade = scanner.nextBoolean();
        }


        System.out.println("Goodbye");
        scanner.close();
    }

    public static void printASCIIPattern() {
        System.out.println("   *   ");
        System.out.println("  ***  ");
        System.out.println(" ***** ");
        System.out.println("*******");
        System.out.println("  ***  ");
    }
}