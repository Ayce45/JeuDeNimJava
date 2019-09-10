package fr.ayce.tp1.vue;

import java.util.Scanner;

public class Ihm {
    public Ihm() {

    }
    public String nomJoueur(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nom de joueur "+ s +":");
        String str = sc.nextLine();
        return str;
    }
    public int nbLignes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir nombre de ligne :");
        int str = sc.nextInt();
        return str;
    }
}
