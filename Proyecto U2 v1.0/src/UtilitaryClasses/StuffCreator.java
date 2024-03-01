package UtilitaryClasses;

import Project.Profile;

import java.util.*;

public class StuffCreator {
    static Scanner sc  = new Scanner(System.in);
    public static Profile createProfile() {
        Date dateOfBirth;
        String aux1, aux2;

        System.out.println("What's the name?");
        System.out.print(">> ");
        aux1 = sc.nextLine();

        System.out.println("What's the last name?");
        System.out.print(">> ");
        aux2 = sc.nextLine();

        System.out.println("When's their birthday?"); //lego batman 2 goty 2024

        dateOfBirth = createDate();

        return new Profile(aux1, aux2, dateOfBirth);
    }

    public static Date createDate() {
        Date newDate = new Date();
        int aux3;

        System.out.print("\tDay >> ");
        aux3 = sc.nextInt();
        newDate.setDate(aux3);
        sc.nextLine();

        System.out.print("\tMonth(numeric) >> ");
        aux3 = sc.nextInt();
        newDate.setMonth(aux3 - 1);
        sc.nextLine();

        System.out.print("\tYear >> ");
        aux3 = sc.nextInt();
        newDate.setYear(aux3 - 1900);
        sc.nextLine();

        return newDate;
    }
}
