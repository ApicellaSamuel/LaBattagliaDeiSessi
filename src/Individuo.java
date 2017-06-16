
public abstract class Individuo {

    private int energy = 50;

    int getEnergy(){
        return this.energy;
    }//omettendo il modificatore di accesso sarà implicitamente package-private

    void setEnergy(int i){
        this.energy = this.energy+i;
    }

    public abstract String getName();
}
