import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nIterations = 30;//in seguito verrà passato come parametro

        Population population = new Population(15,20,3, 10, 10, 10, 10);//il senso dei parametri ci sta

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
                Thread.sleep(1000);
            }

            ExecutorService executorService = Executors.newCachedThreadPool();

            while (population.getNumberOfSpregiudicate() != 0 || population.getNumberOfMorigerati() != 0) {

                if(population.getNumberOfSpregiudicate() == 0 && population.getNumberOfPrudenti() == 0) break;
                currentFemmina = population.extractFemale();
                if(population.getNumberOfAvventurieri() == 0 && population.getNumberOfMorigerati() == 0) break;
                currentMaschio = population.extractMale();

                //Accoppiatore acc = new Accoppiatore(currentMaschio, currentFemmina, population);
                //acc.run();
                executorService.submit(new Accoppiatore(currentMaschio, currentFemmina, population));
            }

            executorService.shutdown();
            if (!executorService.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                Thread.interrupted();
                System.out.println("Shittt!!");
            }
            population = new Population(15, 20, 3, population.getNextMale(), population.getNextFemale());

            System.out.println("Next!!!!!!!!!!! " + i);

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
