/**
 * Created by MB_Be on 4/20/2017.
 */
public abstract class  Case {
    //attributs
    protected char lettre;
    protected boolean Faux;
    protected char vraiLettre;
    // methodes
    public abstract int getValeur();
    public abstract int getSanc();
    public abstract boolean isFaux();
    public abstract void setSanctionnement(boolean sanctionnement);

}
