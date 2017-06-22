import java.util.ArrayList;


public class populationSet<T extends Individuo>{

    private volatile ArrayList<T> set = new ArrayList<>();
    private volatile Integer nPru = 0, nSpr = 0, nMor = 0, nAvv = 0;

    int size() {
        return this.set.size();
    }

    synchronized T extract(){
        int randomNumber = (int) (Math.random()*this.set.size());
        return this.set.get(randomNumber);
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }


    synchronized boolean add(T o) {
        switch((o).getName()) {
            case ("spr"): {
                nSpr++;
                break;
            }
            case ("pru"): {
                nPru++;
                break;
            }
            case ("mor"): {
                nMor++;
                break;
            }
            case ("avv"): {
                nAvv++;
                break;
            }
            default:
                System.out.println("Whaaaat!!!???");
        }
        return this.set.add(o);
    }

    Integer getNumberOfSpregiudicate(){return nSpr;}
    Integer getNumberOfPrudenti(){return nPru;}
    Integer getNumberOfMorigerati(){return nMor;}
    Integer getNumberOfAvventurieri(){return nAvv;}

    synchronized boolean remove(T o) {

        switch((o).getName()) {
            case ("spr"): {
                nSpr--;
                break;
            }
            case ("pru"): {
                nPru--;
                break;
            }
            case ("mor"): {
                nMor--;
                break;
            }
            case ("avv"): {
                nAvv--;
                break;
            }
            default:
                System.out.println("Whaaaat!!!???");
        }
        return this.set.remove(o);
    }

    synchronized void removeAll(){
        this.set.clear();
    }

}
