import java.util.ArrayList;

/**
 * Created by Peter on 12/7/2014.
 */
/**
 * Developers are Peter and Amol
 */
public class MonoHybrid {
    private int f = 200;
    ArrayList<MonoCreature> bufferMC = new ArrayList<MonoCreature>();                                                              //A buffer for temporarily storing mono-creatures
    ArrayList<ArrayList<MonoCreature>> alOfAl = new ArrayList<ArrayList<MonoCreature>>();                                                      //An arrayList of an arrayList of mono-creatures
    MonoCreature[] seedCreatures = new MonoCreature[2];                                                                            //Creates an array to hold the input parents

    public MonoHybrid(int maxGenerationsToSee) {                                                                        //Most probable constructor, will take in max gen count
        this.f = maxGenerationsToSee;
    }

    protected MonoHybrid() {                                                                                            //another possible constructor.
                                                                                                                        //initialize maxGen later, or cut it out. Use a max safe limit
    }

    protected void seedParents(MonoCreature parent1, MonoCreature parent2) {
        seedCreatures[0] = parent1;
        seedCreatures[1] = parent2;
    }

    private void fuseTwo(MonoCreature parent1, MonoCreature parent2) {                                                //Generates the four DNA outcomes from two parents
        //Change to private later, replace outside IO by the seed creatures
        String[] gamete = new String[4];
        MonoCreature[] offSpring = new MonoCreature[4];
        for(int i = 0; i < 4; i++) {
            if((i == 0)||(i == 1)) {
                gamete[i] = parent1.getGamete(i);
            } else if((i == 2)||(i == 3)) {
                gamete[i] = parent2.getGamete(i - 2);
            }
            System.out.println("Gamete " + i + " is " + gamete[i]);
        }
        for (int z = 0; z < 4; z++) {                                                                                   //Iterates over the offSpringString count
            for (int gameteFuseBothWith0 = 2; gameteFuseBothWith0 < 4; gameteFuseBothWith0++) {                         //Iterates over both genes of p2
                //offSpringString[z] = this.fuse(gamete[0], gamete[gameteFuse0]);                                               //Fuses [0] and the above two
                offSpring[z] = new MonoCreature(gamete[0], gamete[gameteFuseBothWith0]);                                //Creates two new MonoCreatures which are a result of gene1 of parent1 and gene1,2 of parent2
                z++;
            }
            for (int gameteFuseBothWith1 = 2; gameteFuseBothWith1 < 4; gameteFuseBothWith1++) {                         //Iterates over both genes of p2
                //offSpringString[z] = this.fuse(gamete[1], gamete[gameteFuseBothWith1]);                                               //This time for [1] and the two above
                offSpring[z] = new MonoCreature(gamete[1], gamete[gameteFuseBothWith1]);                                //Creates two new MonoCreatures which are a result of gene2 of p1 and g1,2 of p2
                z++;
            }
        }
        //4 off-springs from 2 parents created. Now send them to bufferMC arrayList.
        for(int childInt = 0; childInt < 4; childInt++) {
            System.out.println("Adding " + offSpring[childInt].geneMakeup());
            bufferMC.add(offSpring[childInt]);
            System.out.println(offSpring[childInt].geneMakeup() + " added\nTotal length of the buffer array-list: " + bufferMC.size() + "\n");
        }
        parent1.fusedWith(parent2);                                                                                     //Adds parents to each others' lists
        parent2.fusedWith(parent1);
    }

    private void addToList() {
        alOfAl.add(bufferMC);
    }



    private void generator(int maxLevels) {
        for(int i = 1; i < f; i++) {                                                                                    //Iterates in the generations count
            for(int o = 1; o <= i * 2; o++) {                                                                           //Iterates in the parent count of this gem

                //adds mono-creatures to buffer array-list
                /*
                Possible prep-code:
                take first two parents
                create their four off-springs through fuseTwo method, which also adds them to buffer
                do the same for all other parents
                now add the buffer's content to the main ArrayList, in current gen. Possibly like:
                alOfAl.add(bufferMC);
                this will add bufferMC to current alOfAl index, ie this generation
                then the for loop iterates for next gen, does the same

                * */
                //@TODO
            }
        }
    }

    protected void nextGen() {
        f++;
    }
}
