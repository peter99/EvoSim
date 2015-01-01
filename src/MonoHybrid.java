import java.util.ArrayList;

/**
 * Created by Peter on 12/7/2014.
 */
/**
 * Developers are Peter and Amol
 */
public class MonoHybrid {
    private int f = 3;
    ArrayList<MonoCreature> bufferMC = new ArrayList<MonoCreature>();                                                              //A buffer for temporarily storing mono-creatures
    ArrayList<ArrayList<MonoCreature>> monoCreaturesTotalList = new ArrayList<ArrayList<MonoCreature>>();                                     //An arrayList of an arrayList of mono-creatures
    MonoCreature[] seedCreatures = new MonoCreature[2];                                                                 //Creates an array to hold the input parents

    public MonoHybrid(int maxGenerationsToSee) {                                                                        //Most probable constructor, will take in max gen count
        this.f = maxGenerationsToSee;
    }

    protected MonoHybrid() {                                                                                            //another possible constructor.
                                                                                                                        //initialize maxGen later, or cut it out. Use a max safe limit
    }

    protected void seedParents(MonoCreature parent1, MonoCreature parent2) {                                            //@TODO: include with constructor
        seedCreatures[0] = parent1;
        seedCreatures[1] = parent2;
        bufferMC.add(parent1);
        bufferMC.add(parent2);
        monoCreaturesTotalList.add(bufferMC);
        fuseTwo(parent1, parent2);
        this.generator();
    }

    private void fuseTwo(MonoCreature parent1, MonoCreature parent2) {                                                  //Generates the four DNA outcomes from two parents
        /**@javadoc
         * Fuses two parents' gametes to obtain 4 off-springs.
         * Working:
         *      Takes two MonoCreatures as arguments
         *      Creates two arrays, one for holding the gametes, other for the off-springs
         *      Then initializes the gamete array by enquiring about each gamete through the getGamete(int whichGamete) method
         *          Working of this:
         *              Iterates from 0 to 3 (0, 1, 2, 3)
         *              In each iteration, it will add a gamete by the method
         *      Now four creatures are created via these four gametes.
         * */

        String[] gamete = new String[4];
        MonoCreature[] offSpring = new MonoCreature[4];                                                                 //Temporarily holds the offspring creatures
        for (int i = 0; i < 4; i++) {                                                                                    //Initializes the gametes array
            if ((i == 0) || (i == 1)) {                                                                                    //The first two gametes
                gamete[i] = parent1.getGamete(i);
                System.out.print("From p1: ");
            } else if ((i == 2) || (i == 3)) {                                                                             //The second two gametes
                gamete[i] = parent2.getGamete(i - 2);
                System.out.print("From p2: ");
            }
            System.out.println("Gamete " + i + " is " + gamete[i]);
        }
        System.out.println("\n");
        offSpring[0] = new MonoCreature(gamete[0], gamete[2]);                                                          //Clean and better at improving performance
        offSpring[1] = new MonoCreature(gamete[0], gamete[3]);
        offSpring[2] = new MonoCreature(gamete[1], gamete[2]);
        offSpring[3] = new MonoCreature(gamete[1], gamete[3]);
        //4 off-springs from 2 parents created. Now send them to bufferMC arrayList.
        for(int childInt = 0; childInt < 4; childInt++) {
            System.out.println("for " + childInt);
            System.out.println("Adding " + offSpring[childInt].geneMakeup() + " to buffer AL");
            bufferMC.add(offSpring[childInt]);
            System.out.println(offSpring[childInt].geneMakeup() + " added\nTotal length of the buffer array-list: " + bufferMC.size() + "\n");
        }
        parent1.fusedWith(parent2);                                                                                     //Adds parents to each others' lists
        parent2.fusedWith(parent1);
    }

    private void addToList() {
        monoCreaturesTotalList.add(bufferMC);
    }

    private void generator() {
        for(int i = 1; i < f; i++) {                                                                                    //Iterates in the generations count
            System.out.println("In generation " + i);
            ArrayList<MonoCreature> parentsLastsGen = monoCreaturesTotalList.get(i - 1);
            //this method generates an error since the next generation is not yet in the main arrayList

            for (int firstParent = 1; firstParent <= (i * 2); firstParent++) {                                                                         //Iterates in the first parent count of this gem
                System.out.println("First parent: " + firstParent);
                MonoCreature firstC = parentsLastsGen.get(firstParent);                                                 //Note that firstParent has got nothing to do with the arrayList. Its just an index
                for(int second = 1; second <= (i *2); second++) {                                                       //Iterates in the second parent count
                    System.out.println("Second parent: " + second);
                    MonoCreature secondC = parentsLastsGen.get(second);
                    if (!(firstC.hasFused(secondC))) {
                        System.out.println("Fusing " + firstC + " and " + secondC);
                        this.fuseTwo(firstC, secondC);
                        /*@TODO: resolve bugs*/
                    }
                }
                //adds mono-creatures to buffer array-list
                /*
                Possible prep-code:
                take first two parents
                create their four off-springs through fuseTwo method, which also adds them to buffer
                do the same for all other parents
                now add the buffer's content to the main ArrayList, in current gen. Via above addToList method
                this will add bufferMC to current monoCreaturesTotalList index, ie this generation
                then the for loop iterates for next gen, does the same

                * *
                //@TODO*/
            }
        }
    }

    protected void nextGen() {
        f++;
    }
}
