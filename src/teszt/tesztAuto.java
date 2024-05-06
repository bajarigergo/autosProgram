package teszt;

import main.Auto;


public class tesztAuto {
    public static void main(String[] args) {
        tankolTesztek();
    }
    public static void tankolTesztek(){
        tankolVanUzemanyagBeinditva();
        tankolVanUzemanyagNincsBeinditva();
        tankolNincsUzemanyagBeinditva();
        tankolNincsUzemanyagNincsBeinditva();
    }
    public void kerekCsereTesztek(){
        egyetlenPotkerekVan();
        
        
    }
    private static void tankolNincsUzemanyagBeinditva() {
        main.Auto auto = new Auto(false, true);
        boolean vart = false;
        auto.tankol();
        boolean kapott = auto.getUzemanyag();
        assert kapott == vart : "Tankol, beindított motorral, üres üzemanyagtankkal (uzemanyag = false, beinditva = true)";
    }

    private static void tankolNincsUzemanyagNincsBeinditva() {
        main.Auto auto = new Auto(false, false);
        boolean vart = true;
        auto.tankol();
        boolean kapott = auto.getUzemanyag();
        assert kapott == vart : "Tankol, leállított motorral, üres üzemanyagtankkal (uzemanyag = false, beinditva = false)";    
    }
    private static void tankolVanUzemanyagBeinditva() {
        main.Auto auto = new Auto(false, false);
        boolean vart = true;
        auto.tankol();
        boolean kapott = auto.getUzemanyag();
        assert kapott == vart : "Tankol, beindított motorral, teli üzemanyagtankkal (uzemanyag = true, beinditva = true)";    
    }

    private static void tankolVanUzemanyagNincsBeinditva() {
        main.Auto auto = new Auto(true, false);
        boolean vart = true;
        auto.tankol();
        boolean kapott = auto.getUzemanyag();
        assert kapott == vart : "Tankol, leállított motorral, üres üzemanyagtankkal (uzemanyag = true, beinditva = false)";    }

    private static void egyetlenPotkerekVan() {
        main.Auto auto = new Auto(true, true);
        int vart = 0;
        auto.setDefekt(true);
        auto.kerekCsere();
        int kapott = auto.getPotKerek();
        assert kapott == vart : "Egyetlen pótkerék van";    
    }
}
