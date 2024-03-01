package Project;

import Controllers.*;
import Repositories.Seeder;

public class Main {

    /**Engine start,
     * no problem,
     * 5 minut: TIDIN TIDIN TIDIN TIDIN,
     * engine kaput*/
    public static void main(String[] args) {
        Seeder.initialize();
        Menus.firstMenu();
    }
}