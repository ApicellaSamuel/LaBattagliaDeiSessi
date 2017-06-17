import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nIterations = 30;//in seguito verrà passato come parametro

        Population population = new Population(15,20,3, 20, 20, 20, 20);//il senso dei parametri ci sta

        //Start!
        Femmina currentFemmina;
        Maschio currentMaschio;
        boolean flag;
        for(int i = 0; i < nIterations; i++) {
            {
                System.out.println("numero mor: " + population.getNumberOfMorigerati() + "; numero avv: " + population.getNumberOfAvventurieri());
                System.out.println("numero pru: " + population.getNumberOfPrudenti() + "; numero spr: " + population.getNumberOfSpregiudicate());

                int nMale = population.getNumberOfAvventurieri() + population.getNumberOfMorigerati();
                int nFemale = population.getNumberOfPrudenti() + population.getNumberOfSpregiudicate();
                int tot = nFemale + nMale;
                System.out.println("numero maschi: " + nMale + "; numero femmine: " + nFemale + "; TOT: " + tot);
                Thread.sleep(1000);
            }

            flag = true;
            while(flag) {
            ExecutorService executorService = Executors.newCachedThreadPool();

                while (population.getNumberOfSpregiudicate() != 0 || population.getNumberOfMorigerati() != 0) {

                    if (population.getNumberOfSpregiudicate() == 0 && population.getNumberOfPrudenti() == 0) break;
                    currentFemmina = population.extractFemale();
                    if (population.getNumberOfAvventurieri() == 0 && population.getNumberOfMorigerati() == 0) break;
                    currentMaschio = population.extractMale();


                    executorService.submit(new Accoppiatore(currentMaschio, currentFemmina, population));
                }
                Thread.sleep(1000);
                executorService.shutdown();
                if (population.getNumberOfSpregiudicate() == 0) {
                    flag = false;
                    population = new Population(15, 20, 3, population.getNextMale(), population.getNextFemale());
                    System.out.println("Next!!!!!!!!!!! " + i);
                }
            }
        }






        System.out.println("end");
        System.out.println("Fine della generazione. Sono rimasti:");
        System.out.println("numero mor: " + population.getNumberOfMorigerati() + "; numero avv: " + population.getNumberOfAvventurieri());
        System.out.println("numero pru: " + population.getNumberOfPrudenti() + "; numero spr: " + population.getNumberOfSpregiudicate());

        int nMale = population.getNumberOfAvventurieri() + population.getNumberOfMorigerati();
        int nFemale = population.getNumberOfPrudenti() + population.getNumberOfSpregiudicate();
        int tot = nFemale + nMale;
        System.out.println("numero maschi: " + nMale + "; numero femmine: " + nFemale + "; TOT: " + tot);

    }

}
