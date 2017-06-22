public class myMain {
    public static void main(String[] args){
        int nIterations = 250;
        int a = 15, b = 20, c = 3;
        Population population = new Population(a,b,c, 50, 50, 50, 50);

        //Start!
        //Femmina currentFemmina;
        //Maschio currentMaschio;

        for(int i = 1; i < nIterations; i++) {

            {

                Float nF = Float.parseFloat(String.valueOf(population.getNumberOfSpregiudicate() + population.getNumberOfPrudenti()));
                Float nM = Float.parseFloat(String.valueOf(population.getNumberOfMorigerati() + population.getNumberOfAvventurieri()));

                System.out.println("numero mor: " + population.getNumberOfMorigerati() + "; numero avv: " + population.getNumberOfAvventurieri());
                System.out.println("numero pru: " + population.getNumberOfPrudenti() + "; numero spr: " + population.getNumberOfSpregiudicate());

                System.out.println( "%Morigerati: " + (population.getNumberOfMorigerati()/nM)*100 +
                        "\n%Avventurieri: " + (population.getNumberOfAvventurieri()/nM)*100 +
                        "\n%Prudenti: " + (population.getNumberOfPrudenti()/nF)*100 +
                        "\n%Spregudicate: " + (population.getNumberOfSpregiudicate()/nF)*100);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


            //ExecutorService executorService = Executors.newCachedThreadPool();
            //boolean end = false;
            int j = 0;
            while(j++<1000){

                //currentFemmina = population.extractFemale();
                //currentMaschio = population.extractMale();

                new Accoppiatore(population.extractMale(), population.extractFemale(), population).go();
                //executorService.submit(new Accoppiatore(currentMaschio, currentFemmina, population));
            }

            System.out.println("Dopo " + i + " anni:..........................................");

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
