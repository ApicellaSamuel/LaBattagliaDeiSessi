/**
 * Created by sam on 12/06/17.
 *
 */
public class Population {
    private populationSet<Femmina> female = new populationSet<>();
    private populationSet<Maschio> male = new populationSet<>();
    private populationSet<Femmina> nextFemale = new populationSet<>();
    private populationSet<Maschio> nextMale = new populationSet<>();
    private int a, b, c;

    public Population(int a, int b, int c, int nAvv, int nSpr, int nMor, int nPru){

        this.a = a; this.b = b; this.c = c;

        for(int i = 1; i <= nAvv; i++)
            male.add(new Avventuriero());

        for(int i = 1; i <= nSpr; i++)
            female.add(new Spregiudicata());

        for(int i = 1; i <= nMor; i++)
            male.add(new Morigerato());

        for(int i = 1; i <= nPru; i++)
            female.add(new Prudente());
    }

    public Population(int a, int b, int c, populationSet<Maschio> male, populationSet<Femmina> female){
        this.female = female;
        this.male = male;
        this.a = a; this.b = b; this.c = c;
    }

    int getA() {
        return a;
    }

    int getB() {
        return b;
    }

    int getC() {
        return c;
    }

    synchronized int getNumberOfAvventurieri(){
        return male.getNumberOfAvventurieri();
    }
    synchronized int getNumberOfMorigerati(){
        return male.getNumberOfMorigerati();
    }
    synchronized int getNumberOfPrudenti(){
        return female.getNumberOfPrudenti();
    }
    synchronized int getNumberOfSpregiudicate(){
        return female.getNumberOfSpregiudicate();
    }

    /**
    Dalla popolazione estraggo un maschio qualsiasi
    @return un maschio random
     */
    synchronized Maschio extractMale(){
        Maschio male = this.male.extract();
        this.male.remove(male);
        return male;
    }

    void putMale(Maschio male){
        this.male.add(male);
    }
    /**
     Dalla popolazione estraggo una femmina qualsiasi
     @return una femmina random
     */
    synchronized Femmina extractFemale(){
        Femmina female = this.female.extract();
        this.female.remove(female);
        return female;
    }

    void putFemale(Femmina female){
        this.female.add(female);
    }

    synchronized void newFemale(Femmina female){
        nextFemale.add(female);
    }
    synchronized void newMale(Maschio male){
        nextMale.add(male);
    }

    synchronized populationSet<Femmina> getNextFemale(){
        return this.nextFemale;
    }
    synchronized populationSet<Maschio> getNextMale(){
        return this.nextMale;
    }
}
