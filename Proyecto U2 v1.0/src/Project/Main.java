package Project;

import java.util.*;
import Controllers.*;
import Repositories.Seeder;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int easterEggCounter = 0;

    /**Engine start,
     * no problem,
     * 5 minut: TIDIN TIDIN TIDIN TIDIN,
     * engine kaput*/
    public static void main(String[] args) {
        int key, counter = 1;
        boolean eg3 = true, eg2 = true;

        Seeder.initialize();

        do {
            System.out.println("------This is a title screen--------");
            System.out.println("===============================");
            System.out.println("1. Start");
            System.out.println("0. Exit");
            System.out.print(">> ");
            key = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (key) {
                case 1:
                    mainMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case -1:
                    System.out.println("Yahaha! You found me!");// easter egg -2
                    if (eg2) {
                        easterEggCounter ++;
                        eg2 = false;
                    }
                    break;
                default:
                    if (counter == 20) {
                        System.out.println("Fine, I'll just end myself.");
                        key = 0;
                    } else if (counter == 17) {
                        System.out.println("MEOW? (waiting for something to happen?)");// lil easter egg:3 -3
                        if (eg3) {
                            easterEggCounter ++;
                            eg3 = false;
                        }
                        counter++;
                    } else if (counter >= 10) {
                        System.out.println("Nope, there's nothing over here.");
                        counter++;
                    } else {
                        System.out.println("Not an option");
                        counter++;
                    }
                    break;
            }   
        } while (key != 0);

        if (easterEggCounter == 2) {
            System.out.println("You got an award!\nStop messing with the inputs :D");
        }
        
        if (easterEggCounter > 2){
            System.out.println("...");
            System.out.println("What!? Another award!\nStop messing with the code :D");//not happy
        }

    }

    /** THE GAME */
    public static void mainMenu() { // first menu to show up
        int option;

        do {
            System.out.println("===============================");
            System.out.println("\t  ---Menus---");
            System.out.println("1. Access books menu.");
            System.out.println("2. Access authors menu.");
            System.out.println("3. Access clients menu.");
            System.out.println("4. Access transactions menu (lend or return).");
            System.out.println("0. Go back.");
            System.out.print(">>");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1:
                    Menus.bookMenu();
                    break;
                case 2:
                    Menus.authorMenu();
                    break;
                case 3:
                    Menus.clientMenu();
                    break;
                case 4:
                    Menus.transactionMenu();
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Not an option.");
                    break;
            }
        } while (option != 0);
    }
}