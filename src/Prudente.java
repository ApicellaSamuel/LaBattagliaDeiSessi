
public class Prudente extends Femmina {
    private int energy = 10; //per fare una prova
    @Override
    public void setEnergy(int i){
        this.energy = i+energy;
    }
    public String getName(){ return "pru";}
}
