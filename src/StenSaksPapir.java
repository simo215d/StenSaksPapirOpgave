import java.util.Scanner;

public class StenSaksPapir {
    //-1 = fejl, 0 = uafgjort, 1 = 1 hånd vinder, 2 = 2 hånd vinder
    int slag(Hand a, Hand b){
        int resultat = -1;
        //uafgjort
        if (a.equals(b)){
            resultat = 0;
        }
        //hånd 1 vinder
        else if(a==Hand.PAPIR && b==Hand.STEN || a==Hand.STEN && b==Hand.SAKS || a==Hand.SAKS && b==Hand.PAPIR){
            resultat = 1;
        }
        //hånd 2 vinder
        else if(b==Hand.PAPIR && a==Hand.STEN || b==Hand.STEN && a==Hand.SAKS || b==Hand.SAKS && a==Hand.PAPIR){
            resultat = 2;
        }
        return resultat;
    }

    void kampModComputer(){
        StenSaksPapir runde1 = new StenSaksPapir();
        System.out.println("Spil mod computeren:");
        //computer generer hand
        Hand computer = null;
        int handInt = (int) (Math.random()*3);
        switch (handInt){
            case 0: computer = Hand.STEN; break;
            case 1: computer = Hand.SAKS; break;
            case 2: computer = Hand.PAPIR; break;
        }
        System.out.println("Computer slår "+computer);
        //Spiller input
        Scanner input = new Scanner(System.in);
        Hand spiller = null;
        //loop kører indtil spiller indtaster noget rigtigt og spiller skal indtaste hver iteration
        //man får aldrig -1 i slag() fordi at spilleren er tvunget til at indtaste rigtigt
        //default case er hvis man ikke taster sten saks eller papir
        while (spiller == null) {
            String spillerInput = input.next();
            switch (spillerInput.toUpperCase()) {
                case "STEN": spiller = Hand.STEN;break;
                case "SAKS": spiller = Hand.SAKS;break;
                case "PAPIR": spiller = Hand.PAPIR;break;
                default: System.out.println("Indtast noget rigigt!");spiller = null;
            }
        }
        System.out.println("Spiller slår "+spiller);
        //sammenlign og print vinder
        int resultat = runde1.slag(spiller,computer);
        switch (resultat){
            case 0: System.out.println("Uafgjort..."); break;
            case 1: System.out.println("Spiller vinder!"); break;
            case 2: System.out.println("Computer vinder!"); break;
        }
    }

    void flereKampe(){
        //metode som simulerer 10 kampe mellem 2 computere
        System.out.println("-----------------------");
        System.out.println("Computer1 mod computer2");
        StenSaksPapir ssp = new StenSaksPapir();
        for (int i = 1; i <= 10; i++) {
            System.out.println("-----------------------");
            System.out.println("Runde "+i);
            //spil for 2 computere mod hinanden
            Hand computer1 = null;
            Hand computer2 = null;
            int handInt1 = (int) (Math.random()*3);
            int handInt2 = (int) (Math.random()*3);
            switch (handInt1){
                case 0: computer1 = Hand.STEN; break;
                case 1: computer1 = Hand.SAKS; break;
                case 2: computer1 = Hand.PAPIR; break;
            }
            switch (handInt2){
                case 0: computer2 = Hand.STEN; break;
                case 1: computer2 = Hand.SAKS; break;
                case 2: computer2 = Hand.PAPIR; break;
            }
            System.out.println("Computer1 slår "+computer1+" og Computer2 slår "+computer2);
            //sammenlign og print vinder
            int resultatLoop = ssp.slag(computer1,computer2);
            switch (resultatLoop){
                case 0: System.out.println("Uafgjort..."); break;
                case 1: System.out.println("Computer1 vinder!"); break;
                case 2: System.out.println("Computer2 vinder!"); break;
            }
        }
    }
}