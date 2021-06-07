/* Scores:
   Design and implement an application that reads student scores, gets the best score and then assigns
   grades based on the following scheme:
   • Grade A: Score >= best - 10
   • Grade B: Score >= best - 20
   • Grade C: Score >= best - 30
   • Grade D: Score >= best - 40
   • Grade F: All other scores
*/

import java.util.*;
public class Score{

    /*Method: main(String[] args).
    Description: You will need to create a Scanner object and have a loop that
    executes the runProgram() method while they want to run the program.
    Use the runAgain() method in the helper class to determine if they want to
    run again.*/
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        boolean runAgain = true;

        while(runAgain){

            runProgram(s);
            runAgain = getRunAgain(s);
        }


    }
    // -----------------------------------------------------------------------------------------------
   /*Method: runProgram(Scanner s).
   Description: Call the printIntroduction() method then call the createArray()
   method which will return the array of student scores. You will need to call
   findMaxGrade and can then call the outputResults method.*/
    public static void runProgram(Scanner s){

        printIntroduction();
        int[] scores = createArray(s);
        int best = findMaxGrade(scores);
        System.out.println(best);
        outputResults(scores, best);



    }
    //  -----------------------------------------------------------------------------------------------
   /*Method: printIntroduction().
   Description: Outputs the program description as shown in the sample
   output.*/
    public static void printIntroduction(){

        System.out.println("\n\t\tWelcome to the Grading Program!");
        System.out.println("=========================================");
        System.out.println("You will be prompted to enter the number");
        System.out.println("of students that you have to grade. Next,");
        System.out.println("you need to enter the scores. The results");
        System.out.println("will print in a table with the weighted");
        System.out.println("grades.\n");

    }
    //   ----------------------------------------------------------------------------------------------
    /*Method: outputResults(int[] scores, int best).
    Description: Outputs the results in a table. You will need to use the
    getLetterGrade() method in the helper class to determine the letter grade
    for each student. Also, make use of the printf function to format your table.*/
    public static void outputResults(int[] scores, int best){

        System.out.println("Here are your results:");

        System.out.printf("%5s %5s %5s", "\tStudent\t\t" , "Score\t\t" , "Grade\n");
        String letterGrade;

        for(int i = 0; i < scores.length; i++){

            letterGrade = getLetterGrade(scores[i], best);

            System.out.printf("%10s %10s %11s %1s" , (i+1) , scores[i] , letterGrade , "\n");

        }


    }
    //   ---------------------------------------------------------------------------------------------
   /*Method: createArray(Scanner s).
   Description: Prompts for the number of students, then has the user input
   that many scores. Returns the array of scores that were input. You will need
   to use the getValidInt() method both for the number of scores and each
   individual score.
   Inputs: Scanner object to read from System.in.
   Returns: An array of student scores*/
    public static int[] createArray(Scanner s){

        int students;
        String prompt;

        prompt = "Enter the number of students: ";
        students = getValidInt(s, prompt);
        int[] scores = new int[students];

        System.out.println("Enter " + students + " scores: ");

        for(int i = 0; i < students; i++)
        {
            prompt = "Score " + (i + 1) + ": ";
            //put the scores into the array
            scores[i] = getValidInt(s, prompt);
        }
        return scores;

    }
    //   ---------------------------------------------------------------------------------------------
    /*Method: findMaxGrade(int[] scores).
    Description: Given an array of scores, finds the maximum.
    Inputs: The array of scores
    Returns: The highest score in the array*/
    public static int findMaxGrade(int[] scores){

        int best = scores[0];
        for(int i = 0; i < scores.length; i++){

            if(scores[i] > best)
                best = scores[i];
        }

        //System.out.println(best);
        return best;

    }
    //  ---------------------------------------------------------------------------------------------
   /*Method: getLetterGrade(int score, int best).
   Description: Determines the letter grade for a score
   Inputs: The score that needs to be graded and the best score (max) for the
   test.
   Returns: A letter grade (A, B, C, D or F)*/
    public static String getLetterGrade(int score, int best){

        if(score >= best-10){
            return "A";
        }
        else if(score < best-10 && score >= best-20){
            return "B";
        }
        else if(score < best-20 && score >= best-30){
            return "C";
        }
        else if(score < best-30 && score >= best-40){
            return "D";
        }
        else{
            return "F";
        }

    }
    //   ---------------------------------------------------------------------------------------------
   /*Method: getValidInt(Scanner s, String prompt).
   Description: Prompts the user continuously until they enter an integer.
   Make sure to call s.nextLine() before returning the answer so that System.in
   is ready to read at the beginning of the next input line.
   Inputs: A Scanner object to read from System.in and the prompt for the user
   Returns: The integer input by the user.*/
    public static int getValidInt(Scanner s, String prompt){


     /* int score;
      while (!s.hasNextInt()){
         s.nextLine(); //clear the invalid input before prompting again
         System.out.print(prompt);
      }

      score = s.nextInt();


      return score;*/

        int score;

        while (true) {

            try {

                System.out.print(prompt);
                score = s.nextInt();
                if (score <= 0) {

                    throw new IllegalArgumentException();
                }
                return score;

            } catch (Exception e) {
                s.nextLine();
            }

        }

    }
    //  ---------------------------------------------------------------------------------------------
   /*Method: getRunAgain(Scanner s)
   Description: Prompts the user if they have another test to score and returns
   true if they respond “Yes” on false if they respond “No.” Their response
   should not be case sensitive and they will continue to be prompted until
   they enter a valid response.
   Inputs: A Scanner object to read from System.in
   Returns: True if the user answered “Yes” and false if the user answered “No.”*/
    public static boolean getRunAgain(Scanner s){
        boolean runAgain = true;
        System.out.print("Do you have another test to score? ");

        while(runAgain){
            String str = s.next();
            if(str.equalsIgnoreCase("Yes") || str.equalsIgnoreCase("No") ){
                if(str.equalsIgnoreCase("Yes")){
                    return true;
                }
                runAgain = false;
            }
            else{
                System.out.print("Please enter yes or no.\nDo you have another test to score? ");

            }
        }

        return false;

    }
    //  ---------------------------------------------------------------------------------------------
}