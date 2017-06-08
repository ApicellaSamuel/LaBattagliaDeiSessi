import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

            if (currentFemmina.getEnergy() < 0){ femmine.remove(currentFemmina); continue; }
            currentMaschio = iterMaschio.next();
            //if (currentMaschio.getEnergy() < 0) maschi.remove(currentMaschio); //per adesso non serve perchè l'avventuriero non perde energia
            nameFemm = currentFemmina.getName();
            nameMasc = currentMaschio.getName();

            if (nameFemm.equals("spr") && nameMasc.equals("avv")) {
                System.out.println("spr e avv");
                currentFemmina.setEnergy(a - b);
                currentMaschio.setEnergy(a);
                //nuovoFiglio();
            }
            if(nameFemm.equals("spr") && nameMasc.equals("mor")) {
                System.out.println("spr e mor");
                currentFemmina.setEnergy(a - (b/2));
                currentMaschio.setEnergy(a - (b/2));
                //nuovoFiglio();
                femmine.remove(currentFemmina);
                maschi.remove(currentMaschio);
                consumo(currentFemmina, currentMaschio, a, b);//forse esistono nomi migliori
            }
            if(nameFemm.equals("pru") && nameMasc.equals("mor")) {
                System.out.println("pru e mor");
                currentFemmina.setEnergy(a - (b/2) - c );
                currentMaschio.setEnergy(a - (b/2) - c);
                //nuovoFiglio();
                femmine.remove(currentFemmina);
                maschi.remove(currentMaschio);
                consumo(currentFemmina, currentMaschio, a, b);//forse esistono nomi migliori
            }
            if(nameFemm.equals("pru") && nameMasc.equals("avv")) {
                //questo caso non serve perchè "per adesso" non accade nulla se si incontrano
                System.out.println("null");
            }
            Thread.sleep(100);
        }
    }

    private static void consumo(Femmina femmina, Maschio maschio, int a, int b) {
        int i = 2;
        while(femmina.getEnergy() + (a-((b/2)*i)) > 0 && maschio.getEnergy() + (a-((b/2)*i)) > 0){
            //nuovoFiglio();
            femmina.setEnergy(a - ((b/2)*i) );
            maschio.setEnergy(a - ((b/2)*i) );
            i++;
            System.out.println("ok");
        }
    }
}
