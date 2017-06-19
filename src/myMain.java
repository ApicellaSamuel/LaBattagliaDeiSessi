import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class myMain {
    public static void main(String[] args){
        int nIterations = 30;
        int a = 15, b = 20, c = 3;
        Population population = new Population(a,b,c, 100, 100, 100, 100);

        //Start!
        Femmina currentFemmina;
        Maschio currentMaschio;

        for(int i = 0; i < nIterations; i++) {

            {
                System.out.println("numero mor: " + population.getNumberOfMorigerati() + "; numero avv: " + population.getNumberOfAvventurieri());
                System.out.println("numero pru: " + population.getNumberOfPrudenti() + "; numero spr: " + population.getNumberOfSpregiudicate());

                int nMale = population.getNumberOfAvventurieri() + population.getNumberOfMorigerati();
                int nFemale = population.getNumberOfPrudenti() + population.getNumberOfSpregiudicate();
                int tot = nFemale + nMale;
                System.out.println("numero maschi: " + nMale + "; numero femmine: " + nFemale + "; TOT: " + tot);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //ExecutorService executorService = Executors.newCachedThreadPool();

            //while (population.getNumberOfSpregiudicate() != 0 || population.getNumberOfMorigerati() != 0
                    //|| population.getNumberOfPrudenti() != 0 || population.getNumberOfAvventurieri() != 0) {
            //boolean end = false;
            int j = 0;
            while(j++<1000){
                if (population.getNumberOfSpregiudicate() == 0 && population.getNumberOfPrudenti() == 0) break;//end = true;
                currentFemmina = population.extractFemale();
                if (population.getNumberOfAvventurieri() == 0 && population.getNumberOfMorigerati() == 0) break;//end = true;
                currentMaschio = population.extractMale();

                new Accoppiatore2(currentMaschio, currentFemmina, population).go();
                //executorService.submit(new Accoppiatore2(currentMaschio, currentFemmina, population));
            }

            //executorService.shutdown();
            //population = new Population(a, b, c, population.getNextAvv(), population.getNextSpr(), population.getNextMor(), population.getNextPru());

            //System.out.println("Next!!!!!!!!!!! " + i);

        }



        Float nF = Float.parseFloat(String.valueOf(population.getNumberOfSpregiudicate() + population.getNumberOfPrudenti()));
        Float nM = Float.parseFloat(String.valueOf(population.getNumberOfMorigerati() + population.getNumberOfAvventurieri()));


        System.out.println("end");
        System.out.println("Fine della generazione. Sono rimasti:");
        System.out.println("numero mor: " + population.getNumberOfMorigerati() + "; numero avv: " + population.getNumberOfAvventurieri());
        System.out.println("numero pru: " + population.getNumberOfPrudenti() + "; numero spr: " + population.getNumberOfSpregiudicate());


        System.out.println( "  %Morigerati: " + (population.getNumberOfMorigerati()/nM)*100 +
                            "; %Avventurieri: " + (population.getNumberOfAvventurieri()/nM)*100 +
                            "; %Prudenti: " + (population.getNumberOfPrudenti()/nF)*100 +
                            "; %Spregudicate: " + (population.getNumberOfSpregiudicate()/nF)*100);

    }
}
