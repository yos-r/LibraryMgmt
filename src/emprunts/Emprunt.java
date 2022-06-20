
package emprunts;
/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class Emprunt {
    private String cin; //cin of user
    private String isbn; //isbn of book
    private String dateemprunt;
    private String dateretour;
    private int retour;
    public Emprunt(){
        super();
    }
    public Emprunt(String c,String i,String de){
        this.cin=c;
        this.isbn=i;
        this.dateemprunt=de;
        this.retour=0;
    }
    public Emprunt(String c,String i,String de, String dr, int r){
        this.cin=c;
        this.isbn=i;
        this.dateemprunt =de;
        this.dateretour = dr;
        this.retour=r;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(String dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    public String getDateretour() {
        return dateretour;
    }

    public void setDateretour(String dateretour) {
        this.dateretour = dateretour;
    }

    public int getRetour() {
        return retour;
    }

    public void setRetour(int retour) {
        this.retour = retour;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "cin=" + cin + ", isbn=" + isbn + ", dateemprunt=" + dateemprunt + ", dateretour=" + dateretour + ", retour=" + retour + '}';
    }
    
   
}
