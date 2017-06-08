/**
 * Created by Federico on 07/06/2017.
 */
public class Morigerato extends Maschio {
    int energy = 10; //per fare una prova
    @Override
    public void setEnergy(int i){
        this.energy = i+energy;
    }
    public String getName(){ return "mor";}
}
