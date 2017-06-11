import java.util.ArrayList;


public class trueSet <T extends Individuo>{

    private ArrayList<T> set = new ArrayList<>();
    private Integer nPru = 0, nSpr = 0, nMor = 0, nAvv = 0;

    int size() {
        return this.set.size();
    }

    T extract(){
        int randomNumber = (int) (Math.random()*this.set.size());
        return this.set.get(randomNumber);
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    boolean add(T o) {
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

    Integer getNumberofSpregiudicate(){return nSpr;}
    Integer getNumberofPrudenti(){return nPru;}
    Integer getNumberofMorigerati(){return nMor;}
    Integer getNumberofAvventurieri(){return nAvv;}

    boolean remove(T o) {

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

    void removeAll(){
        this.set.clear();
    }

}
