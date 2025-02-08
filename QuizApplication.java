import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quiz Questions, Options, and Correct Answers
        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Romeo and Juliet'?"
        };
        String[][] options = {
            {"A. Paris", "B. London", "C. Berlin", "D. Madrid"},
            {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"A. Charles Dickens", "B. William Shakespeare", "C. Mark Twain", "D. Jane Austen"}
        };
        char[] correctAnswers = {'A', 'B', 'B'};

        int score = 0;
        int totalQuestions = questions.length;

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 10 seconds to answer each question.\n");

        // Loop through each question
        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Timer for 10 seconds
            long startTime = System.currentTimeMillis();
            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.next().toUpperCase();
            long endTime = System.currentTimeMillis();

            // Check if the user answered within the time limit
            if ((endTime - startTime) / 1000 > 10) {
                System.out.println("Time's up! You took too long to answer.\n");
                continue;
            }

            // Check if the answer is correct
            if (userAnswer.charAt(0) == correctAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + correctAnswers[i] + ".\n");
            }
        }

        // Display Results
        System.out.println("Quiz Over!");
        System.out.println("Your Final Score: " + score + "/" + totalQuestions);
        System.out.println("Summary of Answers:");
        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": Correct Answer - " + correctAnswers[i]);
        }

        scanner.close();
    }
}