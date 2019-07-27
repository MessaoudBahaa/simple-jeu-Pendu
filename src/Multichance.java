/**
 * Created by MB_Be on 4/20/2017.
 */
public class Multichance extends Case {
    //attributs
    private int chanceRestante;
    private final int score=1;
    private boolean sanctionnement;

    // methodes
    // constructeur


    public Multichance(char vraiLettre) {
        this.chanceRestante = 2;
        this.vraiLettre=vraiLettre;
        this.Faux=false;
    }

    @Override
    public int getValeur() {
        if (lettre==vraiLettre) {
            return score;
        }else{
            return 0 ;
        }
    }

    @Override
    public int getSanc() {
        if (sanctionnement && lettre!=vraiLettre){
            return 2;
        }
        else{
            return 0;
        }
    }


    @Override
    public boolean isFaux() {
        return this.Faux;
    }
    public void setLettre(char lettre){
        this.lettre=lettre;
        if(lettre!=vraiLettre){
            chanceRestante--;
            if(chanceRestante==0) {
                this.Faux = true;
            }
        }
    }

    public void setSanctionnement(boolean sanctionnement) {
        this.sanctionnement = sanctionnement;
    }
}
