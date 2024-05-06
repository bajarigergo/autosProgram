package main;

import java.util.Random;

public class Auto {
    private static Random rnd = new Random();
    private static int objektumDb = 0;
    private boolean uzemanyag;
    private boolean beinditva;
    private boolean defektes;
    private int potKerek;
    
    /* kstr hívási lánc: túlterhelt kstr hívja a másik kstr-t */
    public Auto(){
        
        /* semmi nem lehet a kstr. hívás előtt, mert nem fordul le! */
        //int i = 7;
        
        /* kstr csak kstr-ból hívunk, this kulcsszóval, nem a nevével */
        this(true, false);
    }
    
    public Auto(boolean beinditva){
        this(false, beinditva);
    }
    public Auto(boolean uzemanyag, boolean beinditva){
        this(uzemanyag, beinditva, 1);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva, int potKerek){
        Auto.objektumDb++;
        this.potKerek = potKerek;
        defektes = false;
        System.out.println("*********************************");
        System.out.printf("********** %d. bemutató **********\n".formatted(Auto.objektumDb));
        this.uzemanyag = uzemanyag;
        this.beinditva = beinditva;
        final String VAN = "✔ (van)";
        final String NINCS = "❌ (nincs)";
        String info = uzemanyag ? VAN : NINCS;
        System.out.println("üzemanyag: " + info);
        info = beinditva ? VAN : NINCS;
        System.out.println("beindítva: " + info);
        System.out.println("-----------------");
    }
    
    public void setBeinditva(boolean beinditva){
        /* lehetne további ellenőrzés, pl.:
        csak akkor lehet beindítani, ha van üzemanyag
        */
        this.beinditva = beinditva;
        if(beinditva){
            System.out.println("A motor be van indítva.");
        }else{
            System.out.println("A motor le van állítva.");
        }
    }
    
    //setUzemanyag(false)
    public void megy(){
        if (beinditva && uzemanyag && !defektes) {
            defekt();
            if (!defektes){
                this.uzemanyag = false;
                System.out.println("Haladtunk, az autó megérkezett, de üres a tank.");
            }else{
                System.out.println("Defektet kaptunk, kereket kell cserélni");
            }
        }else if(!beinditva && !defektes){
            System.out.println("Nem haladtunk, az autó nincs beindítva.");
        }else if(!uzemanyag && !defektes){
            System.out.println("Nem haladtunk, mert üres a tank.");
        }else{
            System.out.println("Defekted van, kereket kell cserélni");
        }
    }
    
    //setUzemanyag(true)
    public void tankol(){
        if (!beinditva) {
            this.uzemanyag = true;
            System.out.println("Sikerült tankolni, tele a tank.");
        }else{
            System.out.println("Sikertelen tankolás, mert be van indítva a motor.");
        }
    }
    public void kerekCsere(){
        if (potKerek > 0 && defektes) {
            potKerek--;
            defektes = false; 
        }else if(potKerek == 0 && defektes){
            System.out.println("Nem áll rendelkezésre elegendő pótkerék");
        }
    }
    public void defekt(){
        int szam = rnd.nextInt(1,101);
        if (szam <= 20){
            defektes = true;
        }
    }
    public void setDefekt(boolean defektes){
        this.defektes = defektes;
    }
    public void setUzemanyag(boolean uzemanyag){
        this.uzemanyag = uzemanyag;
    }
    public void setPotKerek(int potKerek){
        this.potKerek = potKerek;
    }
    public boolean getDefekt(){
        return defektes;
    }
    public boolean getUzemanyag(){
        return uzemanyag;
    }
    public int getPotKerek(){
        return potKerek;
    }
    
}

