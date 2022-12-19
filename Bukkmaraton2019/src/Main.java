import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

        //NAGY DANIEL ZOLTAN HALOOOO

        public static void main(String[] args) {
            String fileName = "C:\\Users\\dandi\\IdeaProjects\\Bukkmaraton2019\\src\\bukkm2019.txt";
            List<VersenyTav> versenyTavList = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line = br.readLine(); // első sor mezőneveket tartalmazza
                while ((line = br.readLine()) != null) {
                    String[] adatok = line.split(";");
                    VersenyTav versenyTav = new VersenyTav(adatok[0], adatok[1], adatok[2], adatok[3], adatok[4]);
                    versenyTavList.add(versenyTav);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            double nemTeljesitettekSzama = 691-versenyTavList.size();


            double nemTeljesitettekAranya = (double) nemTeljesitettekSzama / 691 * 100;
            System.out.println("A versenyzők milyen arányban nem teljesítették a versenyt: " + String.format("%.2f", nemTeljesitettekAranya) + "%");

            int noiVersenyzoSzama = 0;
            for (VersenyTav versenyTav : versenyTavList) {
                if (versenyTav.getTav().equals("R") && versenyTav.getKategoria().endsWith("n")) {
                    noiVersenyzoSzama++;
                }
            }
            System.out.println("A rövidtávú versenyen elindult női versenyzők száma: " + noiVersenyzoSzama);

            boolean olyanVersenyzoVan = false;
            for (VersenyTav versenyTav : versenyTavList) {
                if (versenyTav.getIdo().startsWith("06:")) {
                    olyanVersenyzoVan = true;
                    break;
                }
            }
            System.out.println("Volt-e olyan versenyző, aki több mint hat órát töltött a versenypályán?: " + (olyanVersenyzoVan ? "Volt ilyen versenyző" : "Nem volt ilyen versenyző"));

            String gyoztesAdatai = "";
            int legjobbIdo = 0;
            for (VersenyTav versenyTav : versenyTavList) {
                if (versenyTav.getTav().equals("R") && versenyTav.getKategoria().endsWith("f")) {
                    int currentIdo = versenyTav.getIdoInSeconds();
                    if (currentIdo > legjobbIdo) {
                        legjobbIdo = currentIdo;
                        gyoztesAdatai = versenyTav.getRajtszam() + " " + versenyTav.getKategoria() + " " + versenyTav.getNev() + " " + versenyTav.getEgyesulet() + " " + versenyTav.getIdo();
                    }
                }
            }
            System.out.println("A rövidtávú verseny felnőtt férfi kategóriájának győztesének adatai: " + gyoztesAdatai);

            System.out.println("Kategóriák szerinti célba érkező férfi versenyzők száma:");
            for (VersenyTav versenyTav : versenyTavList) {
                if (versenyTav.getKategoria().endsWith("f") && !versenyTav.getIdo().equals("00:00:00")) {
                    System.out.println(versenyTav.getKategoria() + ": " + versenyTav.getNev());
                }
            }
        }

}