package fr.ayce.tp1.vue;

import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.modele.Coup;
import fr.ayce.tp1.modele.Partie;

import java.util.Arrays;
import java.util.Scanner;

public class Ihm {
    private String str;
    private int in;
    private String[] tabStr;
    private Coup c = new Coup();

    public Ihm() {

    }
    public String nomJoueur(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un nom de joueur "+ s +":");
        while (!sc.hasNext()) {
            sc.next();
        }
        str = sc.nextLine();
        return str;
    }
    public int nbLignes() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir nombre de ligne :");
        while (!sc.hasNextInt() && sc.nextInt() > 0) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir nombre de ligne valide:");
            sc.next();
        }
        in = sc.nextInt();
        return in;
    }
    public void affiche(int[][] tab) {
        System.out.println(Arrays.deepToString(tab)
                .replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("0","|")
                .replace("[","")
                .replace(",","")
                .replace(" 1", "")
                .replace("1 ", "")
                .replace("1", ""));
    }
    public void joue(Partie partie) {
        Coup c = new Coup();
        Scanner sc = new Scanner(System.in);
        System.out.println(partie.getJoueur().getNom() + " : à vous de jouer un coup");

        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un coup sous la forme 'm n' où m est la ligne choisie et n le nombre d'allumettes à retirer sur cette ligne");
        while (!sc.hasNext() && c.isValide(sc.nextLine(),partie)) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:");
            sc.next();
        }
        str = sc.nextLine();
        tabStr = str.split(" ");
        c.setLigne(Integer.parseInt(tabStr[0]));
        c.setNbAllumettes(Integer.parseInt(tabStr[1]));
        partie.coup(c);
        //partie.getEtat()[Integer.parseInt(tabStr[0])][Integer.parseInt(tabStr[1])] = 1;
    }

}
