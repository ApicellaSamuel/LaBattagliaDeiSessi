//ad ogni coppia che si incontra si crea un accoppiatore
//in questo modo al main non rimane che gestire le generazioni
public class Accoppiatore extends Thread{
    private Maschio maschio;
    private Femmina femmina;
    public Accoppiatore(Maschio maschio, Femmina femmina){
        this.maschio = maschio;
        this.femmina = femmina;
    }

    @Override
    public void run() {

    }
}
