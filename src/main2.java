
public class main2 {
    public static void main(String[] args) throws InterruptedException {
        int a = 15, b = 20, c = 3;

        trueSet<Femmina> femmine = new trueSet<>();
        trueSet<Maschio> maschi = new trueSet<>();

        int nAvv = 10, nSpr = 10, nMor = 10, nPru = 10;

        for(int i = 1; i <= nAvv; i++)
            maschi.add(new Avventuriero());

        for(int i = 1; i <= nSpr; i++)
            femmine.add(new Spregiudicata());

        for(int i = 1; i <= nMor; i++)
            maschi.add(new Morigerato());

        for(int i = 1; i <= nPru; i++)
            femmine.add(new Prudente());

        Femmina currentFemmina;
        Maschio currentMaschio;
        String nameFemm, nameMasc;
        while(femmine.getNumberofSpregiudicate() != 0 && maschi.getNumberofMorigerati() != 0){

            System.out.println("numero mor: " + maschi.getNumberofMorigerati() + "; numero avv: " + maschi.getNumberofAvventurieri());
            System.out.println("numero pru: " + femmine.getNumberofPrudenti() + "; numero spr: " + femmine.getNumberofSpregiudicate());
            System.out.println("numero maschi: " + maschi.size() + "; numero femmine: " + femmine.size() + "; TOT: " + (femmine.size()+maschi.size()));

            currentFemmina = femmine.extract();

            if (currentFemmina.getEnergy() < 0){ femmine.remove(currentFemmina); continue; }

            currentMaschio = maschi.extract();

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
            Thread.sleep(50);
        }
        System.out.println("fine della generazione");
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
