package UtilityClasses;

import Controllers.Menus;

public class EasterEggs {
    public static void findThem(int key) {
        boolean eg3 = true;

        if (Menus.counter == 20) {
            System.out.println("Fine, I'll just end myself.");
            key = 0;
        } else if (Menus.counter == 17) {
            System.out.println("MEOW? (waiting for something to happen?)");// lil easter egg:3 -3
            if (eg3) {
                Menus.easterEggCounter ++;
                eg3 = false;
            }
            Menus.counter++;
        } else if (Menus.counter >= 10) {
            System.out.println("Nope, there's nothing over here.");
            Menus.counter++;
        } else {
            System.out.println("Not an option");
            Menus.counter++;
        }
    }
}
