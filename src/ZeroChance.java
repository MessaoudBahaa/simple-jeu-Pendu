/**
 * Created by MB_Be on 4/20/2017.
 */
public class ZeroChance extends Case {
    //attributs
    private final int score=3;

    // methodes


    public ZeroChance(char vraiLettre) {
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
        return 0;
    }


    public boolean isFaux() {
        return this.Faux;
    }

    @Override
    public void setSanctionnement(boolean sanctionnement) {

    }

    public void setLettre(char lettre){
        this.lettre=lettre;
        if(lettre!=vraiLettre){
            this.Faux=true;
        }
    }
}
