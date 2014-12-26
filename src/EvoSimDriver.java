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
        try {
            MonoCreature mc1 = new MonoCreature("Q", "u");                                                                  //A monocreature (with two genes of one character
            MonoCreature mc2 = new MonoCreature("Y", "y");                                                                  //Another one
            MonoHybrid m = new MonoHybrid();
            m.seedParents(mc1, mc2);
        } catch (IllegalArgumentException e) {
            System.out.println("Something happened!");
        } finally {
            System.out.println("Aborting program. Retry.");
        }



    }
}
