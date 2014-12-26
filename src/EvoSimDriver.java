/**
 * Created by Peter on 12/7/2014.
 */

/**
 * Developers are Peter and Amol
 */
public class EvoSimDriver {
    public static void main(String[] args) {
        EvoSimDriver.getOption();
    }

    private static void getOption() {
        MonoCreature mc1 = new MonoCreature("Y", "y");                                                                  //A monocreature (with two genes of one character
        MonoCreature mc2 = new MonoCreature("Y", "Y");                                                                  //Another one
        MonoHybrid m = new MonoHybrid();
        m.fuseTwo(mc1, mc2);
    }
}
