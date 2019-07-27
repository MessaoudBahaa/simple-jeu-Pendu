import com.company.Main;

/**
 * Created by MB_Be on 4/20/2017.
 */
public class Proposition extends Case {
    //attributs
    private  char[] props;
    private final int score =2;
    private boolean sanctionnement;

    // methodes
    // constructeur
    public Proposition(char vraiLettre){
        this.vraiLettre=vraiLettre;
        this.Faux=false;
        props=new char[4];
        int alea=Main.RandomInt(0,4);
        props[alea]=vraiLettre;
        for (int i=0;i<4;i++) {
            if (i!=alea) {//int q = (int)'a';
                props[i] = (char)Main.RandomInt(97, 123);
            }
        }
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
            return 1;
        }
        else{
            return 0;
        }
    }


    @Override
    public boolean isFaux() {
        return this.Faux;
    }

    public void setLettre(int i){
        if (i>4){System.out.println("out of range !");}else {
            lettre = props[i];
            if (lettre != vraiLettre) {
                this.Faux = true;
            }
        }
    }
    // methodes

    public void setSanctionnement(boolean sanctionnement) {
        this.sanctionnement = sanctionnement;
    }
}
