public class Main {
    public static void main(String[] args) {
        System.out.println("---SSP---");
        //opretter et objekt a StenSaksPapir
        StenSaksPapir ssp = new StenSaksPapir();
        //spilleren moden computer
        ssp.kampModComputer();
        //10 kampe med computer vs computer
        ssp.flereKampe();
    }
}
