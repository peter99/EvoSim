import java.util.ArrayList;

/**
 * Created by Peter on 12/7/2014.
 */
public class MonoHybrid {
    private int f;
    MonoCreature[][] mc = new MonoCreature[f][];                                                                        //Creates a 2-d array which will contain all the mono-creatures in following format: [gen][offspring#]

    public MonoHybrid(int maxGenerationsToSee) {
        this.f = maxGenerationsToSee;
    }

    protected MonoHybrid() {                                                                                            //this constructor only for debugging

    }

    protected void fuseTwo(MonoCreature parent1, MonoCreature parent2) {                                                //Generates the four DNA outcomes from two parents
        String[] gamete = new String[4];
        String[] offSpring = new String[4];
        for(int i = 0; i < 4; i++) {
            if((i == 0)||(i == 1)) {
                gamete[i] = parent1.getGamete(i);
            } else if((i == 2)||(i == 3)) {
                gamete[i] = parent2.getGamete(i - 2);
            }
            System.out.println("Gamete " + i + " is " + gamete[i]);
        }
        offSpring[0] = this.fuse(gamete[0], gamete[2]);
        offSpring[1] = this.fuse(gamete[0], gamete[3]);
        offSpring[2] = this.fuse(gamete[1], gamete[2]);
        offSpring[3] = this.fuse(gamete[1], gamete[3]);
        for(int i = 0; i < 4; i++) {
            System.out.println(offSpring[i]);
        }
    }

    private String fuse(String gamete1, String gamete2) {                                                               //Fuses gametes and fixes capital issue
        String fusionResult = "";
        if(gamete1.equals(gamete2)) {                                                                                   //If both upper case, then just do it
            fusionResult = gamete1 + gamete2;
        }
        char g1 = gamete1.charAt(0);
        char g2 = gamete2.charAt(0);
        if(Character.isUpperCase(g1)) {
            fusionResult = gamete1 + gamete2;
        } else {
            fusionResult = gamete2 + gamete1;
        }
        return fusionResult;
    }

    private void generator(int maxLevels) {
        for(int i = 1; i < f + 1; i++) {                                                                                //Iterates in the generations count
            for(int o = 1; o <= i * 2; o++) {                                                                           //Iterates in the offspring count of current gen
                //a buffer here
                //@TODO
            }
        }
    }

    protected void nextGen() {
        f++;
    }
}
