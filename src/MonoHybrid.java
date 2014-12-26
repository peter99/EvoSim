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
    ArrayList<ArrayList<MonoCreature>> monoCreaturesTotalList = new ArrayList<ArrayList<MonoCreature>>();                                                      //An arrayList of an arrayList of mono-creatures
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
        bufferMC.add(parent1);
        bufferMC.add(parent2);
        monoCreaturesTotalList.add(bufferMC);
        fuseTwo(parent1, parent2);
        this.generator();
    }

    private void fuseTwo(MonoCreature parent1, MonoCreature parent2) {                                                  //Generates the four DNA outcomes from two parents
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
                now add the buffer's content to the main ArrayList, in current gen. Possibly like:
                monoCreaturesTotalList.add(bufferMC);
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
