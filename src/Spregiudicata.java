
public class Spregiudicata extends Femmina {
    private int energy = 10; //per fare una prova
    @Override
    public void setEnergy(int i){
        this.energy = i+energy;
    }
    @Override
    public int getEnergy(){
        return this.energy;
    }
    @Override
    public String getName(){ return "spr";}
}
