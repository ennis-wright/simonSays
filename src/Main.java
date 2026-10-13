import java.util.Random;
import java.util.Scanner;

class Main{
    static boolean exit = false;
    static Random rand = new Random();
    static String task;
    static int score = 0;
    static Scanner scnr = new Scanner(System.in);

    static void main() {
        String response;
        String diffuculty;
        while(!exit){
            score = 0;
            task = "";
            System.out.printf("Select a difficulty (easy/hard)\n>>");
            diffuculty = scnr.next();
            scnr.nextLine();
            System.out.printf("Play a game (y/n)?\n>>");
            response = scnr.next();
            scnr.nextLine();
            exit = response.equalsIgnoreCase("n");
            if(response.equalsIgnoreCase("y")){
                if(diffuculty.equalsIgnoreCase("easy")){easy();}
                else if (diffuculty.equalsIgnoreCase("hard")){hard();};
            }}}

 /**this code calls if the user chooses the hard option
     it will generate a random number between 0 and 9 and add it to the sequence
     the user has to repeat the sequence. It also keeps track of the user's score.*/
    public static void hard(){
        boolean rightAnswer = true;
        String response = "";
        while(rightAnswer){
            task += String.valueOf(rand.nextInt(10)+" ");
            System.out.println("Simon says: "+task);
            pauseClear();
            response = scnr.nextLine().replaceAll("\\s", "").toLowerCase();
            if(response.equals(task.replaceAll("\\s", ""))){score+=1;}
            else{
                rightAnswer = false;
                System.out.println("Round over! Your score was "+score);
            }}}


/**     this code calls if the user chooses the easy option
     it will generate a random color and add it to the sequence
     the user has to repeat the sequence correctly. It also keeps track of the user's score*/
    public static void easy(){
        boolean rightAnswer = true;
        String response = "";
        int num;
        while(rightAnswer){
            num = rand.nextInt(3);
            switch (num){
                case 0:
                    task+= "red ";
                    break;
                case 1:
                    task+= "green ";
                    break;
                case 2:
                    task+="yellow ";}
            System.out.println("Simon Says: "+task);
            pauseClear();
            response = scnr.nextLine().toLowerCase().replaceAll("\\s","");
            if(response.equals(task.replaceAll("\\s",""))){
                score+=1;
                System.out.println("score: "+ score);}
            else{
                rightAnswer=false;
                System.out.println("Round over! Your score was "+score);
            }}}

//ansi escape codes dont work in every terminal
// i took this from the example code
    public static void pauseClear() {
        try {
            System.out.print("3... ");
            Thread.sleep(1000);
            System.out.print("2... ");
            Thread.sleep(1000);
            System.out.print("1... ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
// ignore
        }
        for (int i = 0; i < 100; i++) {
// print 100 new lines
            System.out.println();
        }
        System.out.print(">>");}} //i added this just because