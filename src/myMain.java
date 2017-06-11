
public class myMain {
    public static void main(String[] args){
        Avventuriero avv = new Avventuriero();
        System.out.println(avv.getName());//getName ridefinito
        System.out.println(avv.getName());//non ridefinito
    }
}
