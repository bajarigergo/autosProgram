package main;

public class AutosProgram {

    public static void main(String[] args) {
        /* referencia nélkül: */
        new AutosProgram().bemutato_0();
        
        /* referenciával: */
        AutosProgram prg = new AutosProgram();
        //prg.bemutato_1();
        //prg.bemutato_2();
        prg.bemutato_3();
    }

    private void bemutato_0() {
        //System.out.println("1. bemutató: ");
        Auto auto = new Auto();
        auto.megy();
        auto.setBeinditva(true);
        auto.megy();
        auto.megy();
        auto.tankol();
        auto.setBeinditva(false);
        auto.tankol();
        auto.setBeinditva(true);
        auto.megy();
        auto.megy();
    }
    
    private void bemutato_1() {
        //System.out.println("2. bemutató: ");
        Auto auto = new Auto(true);
        auto.tankol();
    }
    
    private void bemutato_2() {
        //System.out.println("3. bemutató: ");
        Auto auto = new Auto(true, true);
    }
    private void bemutato_3() {
        //System.out.println("3. bemutató: ");
        Auto auto = new Auto(true, true);
        auto.setDefekt(true);
        auto.megy();
        auto.kerekCsere();
        auto.megy();
        auto.setDefekt(true);
        auto.kerekCsere();
        auto.megy();
    }
    
}
