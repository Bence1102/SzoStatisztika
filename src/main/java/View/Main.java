package View;

import Controller.SzovegStatisztika;
import Model.Fajlbeolvas;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fajlnev = "fajl.txt";
        try {
            List<String> adatok = Fajlbeolvas.beolvas(fajlnev);
            System.out.println("---------------------------------------");
            System.out.println("A fájl tartalma: " + adatok);
            System.out.println("---------------------------------------");
            SzovegStatisztika stat = new SzovegStatisztika(adatok);
            int szavakSzama = stat.szoSzamlalas();
            System.out.println("A fájlban található szavak száma: " + szavakSzama);
            System.out.println("---------------------------------------");
            String leghosszabb = stat.LeghosszabbSzo();
            System.out.println("A leghosszabb szó: " + leghosszabb);
            System.out.println("Hossza: " + leghosszabb.length() + " karakter.");
            System.out.println("---------------------------------------");
            int hanybanvana = stat.HanybanvanAbetu();
            System.out.println("A szavakban ennyi A betű tálálható: " + hanybanvana);
            System.out.println("---------------------------------------");
            if (!adatok.isEmpty()) {
                String elsoSor = adatok.get(0);
                String[] szavak = elsoSor.split("\\s+");
                String eredetiSzo = szavak[0];
                String modositottSzo = stat.elsoUtolsoCsere(eredetiSzo);
                System.out.println("Eredeti szó: " + eredetiSzo);
                System.out.println("Módosított szó: " + modositottSzo);
            }
            System.out.println("---------------------------------------");
            if (stat.VanEDuplikacio()) {
                System.out.println("Találtunk egyforma szavakat a fájlban.");
            } else {
                System.out.println("Minden szó egyedi a fájlban.");
            };
            System.out.println("---------------------------------------");
            if (!adatok.isEmpty()) {
                String elsoSzo = adatok.get(0).split("\\s+")[0];
                stat.betuStatisztikaSzo(elsoSzo);
            }
            System.out.println("---------------------------------------");
            stat.betuStatisztikaTeljesSzoveg();
        } catch (IOException e) {
            System.err.println("Nem sikerült beolvasni a fájlt: " + e.getMessage());
        }
    }
}