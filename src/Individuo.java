/**
 * Created by Federico on 30/05/2017.
 */
public class Individuo {
    private int energy = 30;
    public int getEnergy(){
        return this.energy;
    }
    public void setEnergy(int i){
        this.energy = i;
    }
    public boolean interazione(Individuo I){
        return true;
    }
    public String getName(){ return "Hello!"; }
}
