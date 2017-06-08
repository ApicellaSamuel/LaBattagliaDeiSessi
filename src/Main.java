import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Federico on 07/06/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        int a = 15, b = 20;
        Set<Femmina> femmine = new HashSet<>();
        Set<Maschio> maschi = new HashSet<>();
        int nAvv = 10;
        int nSpreg = 10;
        for(int i = 1; i <= nAvv; i++){
            maschi.add(new Avventuriero());
        }
        for(int i = 1; i <= nSpreg; i++){
            femmine.add(new Spregiudicata());
        }

        Iterator<Maschio> iterMaschio;// = maschi.iterator();
        Iterator<Femmina> iterFemmina;// = femmine.iterator();
        Femmina currentFemmina;
        Maschio currentMaschio;
        String nameFemm, nameMasc;
        while(!femmine.isEmpty()){//iterFemmina.hasNext() && iterMaschio.hasNext()) {
            System.out.println("numero maschi: " + maschi.size() + "; numero femmine: " + femmine.size());
            iterMaschio = maschi.iterator();
            iterFemmina = femmine.iterator();
            currentFemmina = iterFemmina.next();
            currentMaschio = iterMaschio.next();
            nameFemm = currentFemmina.getName();
            nameMasc = currentMaschio.getName();
            if (nameFemm.equals("spr") && nameMasc.equals("avv")) {
                if (currentFemmina.getEnergy() > 0) {
                    //System.out.println(currentFemmina.getEnergy());
                    currentFemmina.setEnergy(a - b);
                    //System.out.println(currentFemmina.getEnergy());
                    currentMaschio.setEnergy(a);
                } else {
                    femmine.remove(currentFemmina);
                }
            }
        }
    }
}
