import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scoreboard_Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sportNumber = 0, choice;
        boolean bool = true;
        String homeTeam, awayTeam;

        while (bool) {
                System.out.println("Select type of game: ");
                System.out.println("1. Football\n2. Basketball");
                sportNumber = scanner.nextInt();
                bool = false;

            //TODO: do some error checking. mismatch and within bounds

        }

        System.out.println("Enter team1 name: ");
        homeTeam = scanner.nextLine();
        Team team1 = new Team(homeTeam);

        System.out.println("Enter team2 name: ");
        awayTeam = scanner.nextLine();
        Team team2 = new Team(awayTeam);

        System.out.println(team1.getTeamName() + " - " + team1.getScore());
        System.out.println(team2.getTeamName() + " - " + team2.getScore());


        switch (sportNumber){
            case 1:
                Game football = new Football(team1, team2);
                System.out.println("Current Period: " + football.getCurrentPeriod());
                while (!football.isGameOver()) {
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " touchdown");
                    System.out.println("2. " + team1.getTeamName() + " field goal");
                    System.out.println("3. " + team1.getTeamName() + " extra point");
                    System.out.println("4. " + team1.getTeamName() + " two point conversion");
                    System.out.println("5. " + team1.getTeamName() + " safety");

                    System.out.println("6. " + team2.getTeamName() + " touchdown");
                    System.out.println("7. " + team2.getTeamName() + " field goal");
                    System.out.println("8. " + team2.getTeamName() + " extra point");
                    System.out.println("9. " + team2.getTeamName() + " two point conversion");
                    System.out.println("10. " + team2.getTeamName() + " safety");

                    System.out.println("11. End quarter");

                    //TODO: do some error checking. mismatch and within bounds

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            football.addScore("touchdown", team1);
                        case 2:
                            football.addScore("field goal", team1);
                        case 3:
                            football.addScore("extra point", team1);
                        case 4:
                            football.addScore("two point conversion", team1);
                        case 5:
                            football.addScore("safety", team1);
                        case 6:
                            football.addScore("touchdown", team2);
                        case 7:
                            football.addScore("field goal", team2);
                        case 8:
                            football.addScore("extra point", team2);
                        case 9:
                            football.addScore("two point conversion", team2);
                        case 10:
                            football.addScore("safety", team2);
                        case 11:
                            football.endCurrentPeriod();
                    }

                    //print out score, check if game is over
                    System.out.println(team1.getTeamName() + " - " + team1.getScore());
                    System.out.println(team2.getTeamName() + " - " + team2.getScore());

                    //TODO: do i check if game is over or does endCurrentPeriod just do it?
                }

            case 2:
                Game basketball = new Basketball(team1, team2);
                System.out.println("Current Period: " + basketball.getCurrentPeriod());

                while(!basketball.isGameOver()){
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " Three Pointer");
                    System.out.println("2. " + team1.getTeamName() + " Two Pointer");
                    System.out.println("3. " + team1.getTeamName() + " Free Throw");

                    System.out.println("4. " + team2.getTeamName() + " Three Pointer");
                    System.out.println("5. " + team2.getTeamName() + " Two Pointer");
                    System.out.println("6. " + team2.getTeamName() + " Free Throw");

                    System.out.println("11. End quarter");

                    //TODO: some error checking

                    choice = scanner.nextInt();

                    switch (choice){
                        case 1:
                            basketball.addScore("Three Pointer", team1);
                        case 2:
                            basketball.addScore("Two Pointer", team1);
                        case 3:
                            basketball.addScore("Free Throw", team1);
                        case 4:
                            basketball.addScore("Three Pointer", team2);
                        case 5:
                            basketball.addScore("Two Pointer", team2);
                        case 6:
                            basketball.addScore("Free Throw", team2);
                        case 7:
                            basketball.endCurrentPeriod();

                    }

                    System.out.println(team1.getTeamName() + " - " + team1.getScore());
                    System.out.println(team2.getTeamName() + " - " + team2.getScore());
                }

        }

        System.out.println("Game Over");


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
