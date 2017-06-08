/**
 * Created by Federico on 07/06/2017.
 */
public class Prudente extends Femmina {
    int energy = 10; //per fare una prova
    @Override
    public void setEnergy(int i){
        this.energy = i+energy;
    }
    public String getName(){ return "pru";}
}
