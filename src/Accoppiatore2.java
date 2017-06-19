public class Accoppiatore2 {//extends Thread{

    private volatile Maschio maschio;
    private volatile Femmina femmina;
    private volatile Population population;

    Accoppiatore2(Maschio maschio, Femmina femmina, Population population){
        this.maschio = maschio;
        this.femmina = femmina;
        this.population = population;
    }

    //@Override
    //public void run(){
    void go(){
        int a = population.getA(); int b = population.getB(); int c = population.getC();

        String concat = maschio.getName()+femmina.getName();
        switch(concat){

            case("avvspr"): {

                if( a-b < 0 ){
                    int i = a-b;
                    while(i < 0) {
                        Femmina femminai = population.extractFemale();
                        if (femminai.getName().equals("pru")) population.putFemale(femminai);
                        i++;
                    }
                }
                /*if( a < 0 ){
                    int i = a;
                    while(i < 0) {
                        Maschio maschioi = population.extractMale();
                        if (maschioi.getName().equals("avv")) population.putMale(maschioi);
                        i++;
                    }
                }

                for(int i = 0; i < a-b; i++)
                    population.putFemale(new Spregiudicata());*/

                for(int i = 0; i < a; i++)
                    population.putMale(new Avventuriero());

                break;
            }

            case("morspr"):{
                for(int i = 0; i < a-(b/2); i++) {
                    population.putFemale(new Spregiudicata());
                }
                for(int i = 0; i < a-(b/2); i++){
                    population.putMale(new Morigerato());
                }
                break;
            }

            case("morpru"):{
                for(int i = 0; i < a-(b/2)-c; i++) {
                    population.putFemale(new Prudente());
                }
                for(int i = 0; i < a-(b/2)-c; i++){
                    population.putMale(new Morigerato());
                }
            }

            case("avvpru"):{
                population.putFemale(femmina);
                population.putMale(maschio);
                break;
            }

            default : System.out.println("Shit");
        }
    }

}
