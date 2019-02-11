import java.util.List;

public class Main {

    public static void main(String[] args) {

        Long eini = 46216567629L ;
        long hinein = 46_216_567_629_137L;
        List<List<Long>> Ergebnis = funky_primes.mutable_primes(eini);
        if (Ergebnis.size() == 0){
            System.out.println("Is' lea!");
        }
        else
        for (int i = 0; i < Ergebnis.size(); i++) {
            System.out.println(Ergebnis.get(i));
        }
        System.out.println(Ergebnis.size());
    }
}