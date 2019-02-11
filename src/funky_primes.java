import java.util.ArrayList;
import java.util.List;

public class funky_primes {
    public static int Länge(long eini) {
        return Long.toString(eini).length();
    }

    public static long Zifferentfernung(long eini, int Nummer_der_zu_löschenden_Ziffer) {
        String irgendwas = Long.toString(eini).substring(0, Nummer_der_zu_löschenden_Ziffer) +
                Long.toString(eini).substring(Nummer_der_zu_löschenden_Ziffer + 1);
        return Long.parseLong(irgendwas);
    }

    public static List<Long> Lösungsmenge(Long rein) {
        List<Long> hauptliste = new ArrayList<Long>();
        hauptliste.add(rein);
        Primzahlfindung(hauptliste);
        return hauptliste;
    }

    public static List<List<Long>> Lösung(Long rein) {
        List<Long> hauptliste = Lösungsmenge(rein);
        List<Long> Lösung = hauptliste.subList(0, 1);
        List<List<Long>> aussi = new ArrayList<>();
        for (int i = 1; i < (hauptliste.size() - 1); i++) {
            Lösung.add(hauptliste.get(i));
            if (Länge(hauptliste.get(i)) == 1) {
                List<Long> pfad = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    pfad.add(Lösung.get(j));
                }
                aussi.add(pfad);
            }
        }
        return aussi;
    }

    public static void Primzahlfindung(List<Long> nei) {
        long eini = nei.get(nei.size() - 1);
        if (Länge(eini) >= 2) {
            for (int i = 0; i < Länge(eini); i++) {
                if (Primzahleigenschaft(Zifferentfernung(eini, i))) {
                    nei.add(Zifferentfernung(eini, i));
                    Primzahlfindung(nei);
                }
            }
        }
    }

    public static List<List<Long>> mutable_primes(double eini) {
        List<Long> Lösung = funky_primes.Lösungsmenge((long) eini);
        Lösung.add((long) eini);
        List<List<Long>> Ergebnis = new ArrayList<>();
        List<Long> temp = new ArrayList<>();
        temp.add(Lösung.get(0));

        for (int i = 1; i < Lösung.size(); i++) {
            if (funky_primes.Länge(Lösung.get(i)) < funky_primes.Länge(Lösung.get(i - 1))) {
                temp.add(Lösung.get(i));
            } else {
                List Einfügen = (List) ((ArrayList<Long>) temp).clone();
                Ergebnis.add(Einfügen);
                temp = new ArrayList<>();
                for (int j = 0;
                     funky_primes.Länge((Long) Einfügen.get(j))
                             > funky_primes.Länge(Lösung.get(i));
                     j++) {
                    temp.add((Long) Einfügen.get(j));
                }
                temp.add(Lösung.get(i));
            }
        }
        Ergebnis.removeIf(e -> e.size() < funky_primes.Länge((long) eini));
        return Ergebnis;
    }

    static double Primfaktorenzerlegung(long eini) {
        if (eini == 2) {
            return 2;
        }

        for (int i = 2; i < eini; i++) {
            if (eini % i == 0) {
                return Primfaktorenzerlegung(eini / i);
            }
        }
        return eini;
    }

    static boolean Primzahleigenschaft(long eini) {
        if ((eini == Primfaktorenzerlegung(eini) && (eini != 1))) {
            return true;
        } else {
            return false;
        }
    }
}
