package Controller;

import java.util.ArrayList;
import java.util.List;

public class SzovegStatisztika {
    private final List<String> sorok;

    public SzovegStatisztika(List<String> sorok) {
        this.sorok = sorok;
    }
    public int szoSzamlalas() {
        int osszesSzo = 0;
        for (String sor : sorok) {
            if (sor != null && !sor.trim().isEmpty()) {
                String[] szavak = sor.trim().split("\\s+");
                osszesSzo += szavak.length;
            }
        }
        return osszesSzo;
    }
    public int karakterSzamlalas() {
        return sorok.stream().mapToInt(String::length).sum();
    }


    public String LeghosszabbSzo(){
        String leghosszabszo = "";

        for(String sor : sorok){
            if(sor != null && !sor.trim().isEmpty()){
                String[] szavak = sor.trim().split("\\s+");

                for (String szo : szavak){
                    String tisztaszo = szo.replaceAll("[^a-zA-ZáéíóöőúüűÁÉÍÓÖŐÚÜŰ]", "");

                    if(tisztaszo.length() > leghosszabszo.length()){
                        leghosszabszo = tisztaszo;
                    }
                }
            }
        }
        return  leghosszabszo;
    }


    public int HanybanvanAbetu() {
        int db = 0;
        for (String sor : sorok) {
            if (sor != null && !sor.trim().isEmpty()) {
                String[] szavak = sor.trim().split("\\s+");
                for (String szo : szavak) {
                    String kisbetusSzo = szo.toLowerCase();
                    for (int i = 0; i < kisbetusSzo.length(); i++){
                        if (kisbetusSzo.charAt(i) == 'a') {
                            db++;
                        }
                    }

                }
            }
        }
        return db;
    }

    public String elsoUtolsoCsere(String szo){
        if (szo == null || szo.length() <= 1) {
            return szo;
        }
        char elso = szo.charAt(0);
        char utolso = szo.charAt(szo.length() - 1);
        String kozepe = szo.substring(1, szo.length() - 1);
        return utolso + kozepe + elso;
    }

    public boolean VanEDuplikacio(){
        List<String> mindenSzo = new ArrayList<>();
        for(String sor : sorok){
            if(sor != null){
                String[] szavak = sor.trim().split("\\s+");
                for(String szo : szavak){
                    String tiszta = szo.toLowerCase().replaceAll("[^a-zA-ZáéíóöőúüűÁÉÍÓÖŐÚÜŰ]", "");
                    if (!tiszta.isEmpty()) {
                        mindenSzo.add(tiszta);
                }
            }
        }
    }
        for (int i = 0; i < mindenSzo.size(); i++) {
            for (int j = i + 1; j < mindenSzo.size(); j++) {
                if (mindenSzo.get(i).equals(mindenSzo.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void betuStatisztikaSzo(String szo) {
        if (szo == null) return;

        int[] szamlalo = new int[256]; // Az ASCII karaktereknek
        String tisztaSzo = szo.toLowerCase();

        for (int i = 0; i < tisztaSzo.length(); i++) {
            char c = tisztaSzo.charAt(i);
            if (c < 256) {
                szamlalo[c]++;
            }
        }

        System.out.println("Betűk statisztikája az '" + szo + "' szóban:");
        kiirStatisztika(szamlalo);

    }

    private void kiirStatisztika(int[] szamlalo) {
        for (int i = 0; i < szamlalo.length; i++) {
            if (szamlalo[i] > 0 && Character.isLetter((char)i)) {
                System.out.println((char)i + ": " + szamlalo[i] + " db");
            }
        }
    }

    public void betuStatisztikaTeljesSzoveg() {
        int[] szamlalo = new int[256];

        for (String sor : sorok) {
            if (sor != null) {
                String tisztaSor = sor.toLowerCase();
                for (int i = 0; i < tisztaSor.length(); i++) {
                    char c = tisztaSor.charAt(i);
                    if (c < 256) {
                        szamlalo[c]++;
                    }
                }
            }
        }

        System.out.println("Betűk statisztikája a TELJES szövegben:");
        kiirStatisztika(szamlalo);
    }
}
