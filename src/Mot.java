import com.company.Main;

import java.util.Random;

/**
 * Created by MB_Be on 4/20/2017.
 */
public class Mot {
    //attributs
    private TypeIndication typeIndication;
    private int coefficiant;
    private String description;
    private String reponse;
    private Case[] cases;
    private int caseCourante;
    private boolean sanctionnement;

    // methodes

    // constructeur
    public Mot(TypeIndication typeIndication, String description, String reponse) {
        if(reponse.length()>6) {
            // initialisation des attributs
             this.typeIndication = typeIndication;
             this.description = description;
             this.reponse = reponse;
             caseCourante = 0;

             // changement de  coeficiant selon le type de l'indicateur
             if (typeIndication == TypeIndication.Synonyme) {
                 coefficiant = 2;
             } else if (typeIndication == TypeIndication.Antonyme) {
                 coefficiant = 1;
             } else if (typeIndication == TypeIndication.Definition) {
                 coefficiant = 3;
             } else {
                 System.out.println("typeIndication erreur");
             }

             // creation aleatoire de type des cases de ce mots
             int nbrZeroChance = Main.RandomInt(0, 6); // generant aleatoirement le nombre des zero chances
             int nbrMultiChance = Main.RandomInt(0, reponse.length() - nbrZeroChance + 1); // generant aleatoirement le nombre des multichances
             int nbrProposition = reponse.length() - (nbrMultiChance + nbrZeroChance);// generant aleatoirement le nombre des propositions
             int i = 0;
             sanctionnement= (nbrMultiChance+nbrProposition>3);
             while (i < reponse.length()) {
                 int alea = Main.RandomInt(0, 3);
                 if (alea == 0 && nbrZeroChance != 0) {
                     cases[i] = new ZeroChance(reponse.charAt(i));
                     nbrZeroChance--;
                     i++;
                 } else if (alea == 1 && nbrMultiChance != 0) {
                     cases[i] = new Multichance(reponse.charAt(i));
                     cases[i].setSanctionnement(sanctionnement);
                     nbrMultiChance--;
                     i++;
                 } else if (alea == 2 && nbrProposition != 0) {
                     cases[i] = new Proposition(reponse.charAt(i));
                     cases[i].setSanctionnement(sanctionnement);
                     nbrProposition--;
                     i++;
                 } else {
                     System.out.println("Erreur : depassement du type de case ! ");
                 }

             }
         }
         else{// en cas d' erreur que le mot ne depasse pas 6 lettres
            System.out.println("Mot trop cours ! ");
        }
    }

    public boolean Verifier(){
        return cases[caseCourante].isFaux();
    }

    public boolean isSanctionnement() {
        return sanctionnement;
    }
    public void caseSuivante(){
        if (caseCourante!=reponse.length()) {
            caseCourante++;
        }else {
            System.out.println("fin du mot ! ");
        }
    }
}
