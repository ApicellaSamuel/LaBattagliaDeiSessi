import java.util.ArrayList;


public class trueSet <T>{

    private ArrayList<T> set = new ArrayList<>();
    private Integer nPru = 0, nSpr = 0, nMor = 0, nAvv = 0;

    public int size() {
        return this.set.size();
    }

    public T extract(){
        int randomNumber = (int) (Math.random()*this.set.size());
        return this.set.get(randomNumber);
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public boolean add(T o) {
        switch(((Individuo)o).getName()) {
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

    public Integer getNumberofSpregiudicate(){return nSpr;}
    public Integer getNumberofPrudenti(){return nPru;}
    public Integer getNumberofMorigerati(){return nMor;}
    public Integer getNumberofAvventurieri(){return nAvv;}

    public boolean remove(T o) {

        switch(((Individuo)o).getName()) {
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

}
