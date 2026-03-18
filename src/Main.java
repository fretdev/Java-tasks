import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int[] scores = new int[5];
        double average;
        String calculateGrade = "yes";

        while (calculateGrade.equals("yes")){
            System.out.println("*****************");
            System.out.println("Grade Calculator");
            System.out.println("*****************");

            for(int i = 0;i<5;i++){
                System.out.print("Enter score(0/100): ");
                int score = scanner.nextInt();
                scores[i] = score;
                scanner.nextLine();

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

                switch (grade){
                    case 'A' -> System.out.println("Excellent");
                    case 'B' -> System.out.println("Very Good");
                    case 'C' -> System.out.println("Good");
                    case 'D' -> System.out.println("Pass");
                    case 'E' -> System.out.println("Weak pass");
                    case 'F' -> System.out.println("Fail");
                    default -> System.out.println("Invalid input");
                }
                System.out.println("*****************");
            }
            for(int i =0;i < 5;i++){
                total+=scores[i];
            }
            average = total/5.0;
            System.out.println("Score Average: "+ average);

            printASCIIPattern();
            System.out.print("Do you want to recalculate grade: ");
            calculateGrade = scanner.nextLine();
        }


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