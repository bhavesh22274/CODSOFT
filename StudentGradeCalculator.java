# CODSOFT
import java.util.Scanner;
import java.util.ArrayList;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Grade Calculator ---");
        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

        ArrayList<Integer> marks = new ArrayList<>();

        for (int i = 0; i < subjectCount; i++) {
            int mark;
            while (true) {
                System.out.print("Marks for subject " + (i + 1) + ": ");
                mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) break;
                System.out.println("Invalid input. Enter a value between 0 and 100.");
            }
            marks.add(mark);
        }

        int total = calculateTotal(marks);
        double average = subjectCount > 0 ? (double) total / subjectCount : 0;
        char grade = getGrade(average);

        printResults(total, average, grade);
        scanner.close();
    }

    private static int calculateTotal(ArrayList<Integer> marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    private static char getGrade(double avg) {
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }

    private static void printResults(int total, double average, char grade) {
        System.out.println("\n--- Result ---");
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Grade: " + grade);


    }
}
