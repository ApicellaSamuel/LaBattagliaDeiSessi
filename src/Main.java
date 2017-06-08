import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Federico on 07/06/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        int a = 15, b = 20, c = 3;

        Set<Femmina> femmine = new HashSet<>();
        Set<Maschio> maschi = new HashSet<>();

        int nAvv = 10, nSpr = 10, nMor = 10, nPru = 10;

        for(int i = 1; i <= nAvv; i++)
            maschi.add(new Avventuriero());

        for(int i = 1; i <= nSpr; i++)
            femmine.add(new Spregiudicata());

        for(int i = 1; i <= nMor; i++)
            maschi.add(new Morigerato());

        for(int i = 1; i <= nPru; i++)
            femmine.add(new Prudente());


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

            if (currentFemmina.getEnergy() < 0) femmine.remove(currentFemmina);
            currentMaschio = iterMaschio.next();
            //if (currentMaschio.getEnergy() < 0) maschi.remove(currentMaschio); //per adesso non serve perchè l'avventuriero non perde energia
            nameFemm = currentFemmina.getName();
            nameMasc = currentMaschio.getName();

            if (nameFemm.equals("spr") && nameMasc.equals("avv")) {
                    currentFemmina.setEnergy(a - b);
                    currentMaschio.setEnergy(a);
            }
            else if(nameFemm.equals("spr") && nameMasc.equals("mor")) {
                currentFemmina.setEnergy(a - (b/2));
                currentMaschio.setEnergy(a - (b/2));
                femmine.remove(currentFemmina);
                maschi.remove(currentMaschio);
                consumo(currentFemmina, currentMaschio);//forse esistono nomi migliori
            }
            else if(nameFemm.equals("pru") && nameMasc.equals("mor")) {
                currentFemmina.setEnergy(a - (b/2) - c );
                currentMaschio.setEnergy(a - (b/2) - c);
                femmine.remove(currentFemmina);
                maschi.remove(currentMaschio);
                consumo(currentFemmina, currentMaschio);//forse esistono nomi migliori
            }
            /*else if(nameFemm.equals("pru") && nameMasc.equals("avv")) {
                //questo caso non serve perchè "per adesso" non accade nulla se si incontrano
            }*/
        }
    }

    private static void consumo(Femmina currentFemmina, Maschio currentMaschio) {

    }
}
