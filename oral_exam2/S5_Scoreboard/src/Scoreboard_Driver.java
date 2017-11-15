import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scoreboard_Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sportNumber = 0;
        boolean bool = true;
        String homeTeam, awayTeam;

        while (bool) {
                System.out.println("Select type of game: ");
                System.out.println("1. Football\n2. Basketball");
                sportNumber = scanner.nextInt();
                bool = false;
        }

        System.out.println("Enter team1 name: ");
        homeTeam = scanner.nextLine();
        Team team1 = new Team(homeTeam);

        System.out.println("Enter team1 name: ");
        awayTeam = scanner.nextLine();
        Team team2 = new Team(homeTeam);

        System.out.println(team1.getTeamName() + " - " + team1.getScore());
        System.out.println(team2.getTeamName() + " - " + team2.getScore());


        switch (sportNumber){
            case 1:
                Game football = new Football(team1, team2);
                while (!football.isGameOver()){
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " touchdown");
                    System.out.println("2. " + team1.getTeamName() + " field goal");
                    System.out.println("3. " + team1.getTeamName() + " extra point");
                    System.out.println("4. " + team1.getTeamName() + " two point conversion");
                    System.out.println("5. " + team1.getTeamName() + " safety");
                }
        }


//        System.out.println("Creating new Football game");
//
//        /*----- setup teams and game ------*/
//        Team hawkeyes = new Team("Hawkeyes");
//        Team cyclones = new Team("Cyclones");
//
//        System.out.println(hawkeyes.getTeamName() + " vs " + cyclones.getTeamName());
//        /*----- start game ------*/
//
//        Game hyveeCyHawk = new Football(hawkeyes, cyclones);
//        System.out.println("Name of Period: " + hyveeCyHawk.getNameOfPeriod());
//
//        /*----- do some scoring and print the score along with what period we are at ------*/
//
//        System.out.println("Current " + hyveeCyHawk.getNameOfPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());
//
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("safety", hawkeyes);
//        hyveeCyHawk.addScore("field goal", cyclones);
//
//        System.out.println("Ending first quarter");
//        hyveeCyHawk.endCurrentPeriod();
//
//        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
//        System.out.println("Cyclones score:" + cyclones.getScore());
//
//        /*----- end current period, print new period and do some more scoring ------*/
//
//        System.out.println("Current " + hyveeCyHawk.getNameOfPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());
//
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("safety", hawkeyes);
//        hyveeCyHawk.addScore("field goal", cyclones);
//
//        System.out.println("Is this game over? " + hyveeCyHawk.isGameOver());
//
//        System.out.println("Ending second quarter");
//        hyveeCyHawk.endCurrentPeriod();
//
//        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
//        System.out.println("Cyclones score:" + cyclones.getScore());
//
//        /*----- 3rd quarter and scoring------*/
//
//        System.out.println("Current " + hyveeCyHawk.getNameOfPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());
//
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//        hyveeCyHawk.addScore("touchdown", hawkeyes);
//
//        System.out.println("Ending third quarter");
//        hyveeCyHawk.endCurrentPeriod();
//
//        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
//        System.out.println("Cyclones score:" + cyclones.getScore());
//
//        /*----- fourth quarter and scoring ------*/
//
//        System.out.println("Current " + hyveeCyHawk.getNameOfPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());
//
//        hyveeCyHawk.addScore("safety", hawkeyes);
//
//        System.out.println("Ending fourth quarter");
//        hyveeCyHawk.endCurrentPeriod();
//
//        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
//        System.out.println("Cyclones score:" + cyclones.getScore());
//
//        /*----- end the game ------*/
//
//        System.out.println("Is the game over? " + hyveeCyHawk.isGameOver());
//
//
//        /*
//
//
//        do one with soccer and like tennis or something
//         */


    }
}
