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
            MonoCreature mc1 = new MonoCreature("Q", "q");                                                                  //A monocreature (with two genes of one character
            MonoCreature mc2 = new MonoCreature("Q", "q");                                                                  //Another one
            MonoHybrid m = new MonoHybrid();
            m.seedParents(mc1, mc2);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong genotype entered!");
        } finally {
            System.out.println("\n\nEnd of program");
        }
    }
}
