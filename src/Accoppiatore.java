import java.util.ArrayList;

//ad ogni coppia che si incontra si crea un accoppiatore
//in questo modo al main non rimane che gestire le generazioni
public class Accoppiatore extends Thread{
    private volatile Maschio maschio;
    private volatile Femmina femmina;
    private volatile Population population;
    Accoppiatore(Maschio maschio, Femmina femmina, Population population){
        this.maschio = maschio;
        this.femmina = femmina;
        this.population = population;
    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(50);//per i test della concorrenza
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        String concat = maschio.getName()+femmina.getName();
        int a = population.getA(); int b = population.getB(); int c = population.getC();

        switch(concat){
            case("avvspr"): {

                femmina.newSon();
                femmina.setEnergy(a - (b*femmina.getNSons()));
                maschio.setEnergy(a);//il controllo sottostante può portare la femmina ad avere una energia negativa
                population.putMale(maschio);
                if ((femmina.getEnergy() + (a-(b*femmina.getNSons()))) > 0) population.putFemale(femmina);//non morigerato

                {
                    Avventuriero avventuriero = new Avventuriero();
                    Spregiudicata spregiudicata = new Spregiudicata();
                    ArrayList<Individuo> vector = new ArrayList<>();
                    vector.add(avventuriero);vector.add(spregiudicata);
                    int randomNumber = (int) (Math.random() * vector.size());
                    Individuo individuo = vector.get(randomNumber);
                    if (individuo.getName().equals("avv")) population.newMale(avventuriero);
                    else population.newFemale(spregiudicata);
                }
                break;
            }

            case("morspr"):{//da rivedere
                //System.out.println("mor e spr");

                femmina.setEnergy(-c);
                maschio.setEnergy(-c);
                //femmina.setEnergy(a - ((b/2)*femmina.getNSons()));
                //maschio.setEnergy(a - ((b/2)*femmina.getNSons()));//il morigerato deve tener conto del numero di figli precedenti della spr
                //int i = 1;//stessa cosa
                while(femmina.getEnergy() + (a-((b/2)*(femmina.getNSons()+1))) > 0 && maschio.getEnergy() + (a-((b/2)*(femmina.getNSons()+1))) > 0){

                    {
                        Morigerato morigerato = new Morigerato();
                        Spregiudicata spregiudicata = new Spregiudicata();
                        ArrayList<Individuo> vector = new ArrayList<>();
                        vector.add(morigerato);vector.add(spregiudicata);
                        int randomNumber = (int) (Math.random() * vector.size());
                        Individuo individuo = vector.get(randomNumber);
                        if (individuo.getName().equals("mor")) population.newMale(morigerato);
                        else population.newFemale(spregiudicata);
                    }
                    femmina.newSon();
                    femmina.setEnergy(a - ((b/2)*femmina.getNSons()) );
                    maschio.setEnergy(a - ((b/2)*femmina.getNSons()) );
                    //i++;
                }
                break;
            }

            case("morpru"):{
                femmina.setEnergy(-c);
                maschio.setEnergy(-c);
                int i = 1;
                while(femmina.getEnergy() + (a-((b/2)*i)) > 0 && maschio.getEnergy() + (a-((b/2)*i)) > 0){

                    {
                        Morigerato morigerato = new Morigerato();
                        Prudente prudente = new Prudente();
                        ArrayList<Individuo> vector = new ArrayList<>();
                        vector.add(morigerato);vector.add(prudente);
                        int randomNumber = (int) (Math.random() * vector.size());
                        Individuo individuo = vector.get(randomNumber);
                        if (individuo.getName().equals("mor")) population.newMale(morigerato);
                        else population.newFemale(prudente);
                    }

                    femmina.setEnergy(a - ((b/2)*i) );
                    maschio.setEnergy(a - ((b/2)*i) );
                    ++i;
                }
                break;
            }

            case("avvpru"):{
                //femmina.setEnergy(-c);//attenzione!!!!!
                population.putFemale(femmina);
                population.putMale(maschio);
                break;
            }
            default : System.out.println("Shit");
        }
    }
}
