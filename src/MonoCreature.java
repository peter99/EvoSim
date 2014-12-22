import java.util.ArrayList;

/**
 * Created by Peter on 12/7/2014.
 */
public class MonoCreature {                                                                                             //This is a monocreature
    static int orgID = 0;                                                                                               //++ the UID of the creature
    public MonoCreature() {
        orgID++;
    }

    String dominantTrait;                                                                                               //The dom gene
    String recessiveTrait;                                                                                              //Possibly useless?
    ArrayList<String> gene = new ArrayList<String>();                                                                        //An arraylist that contains all the genes
    String gamete1;                                                                                                     //You don't say?
    String gamete2;
    public MonoCreature(String characterGene1, String characterGene2) {                                                 //Constructor: Takes in a gene set (Gx2)
        this.gene.add(characterGene1);                                                                                  //Adds two Strings to gene arraylist
        this.gene.add(characterGene2);
        System.out.println("Character genes initialized");
        orgID++;                                                                                                        //++ the id
        System.out.println("OK to proceed: " + this.geneCheck());
        this.setDominantTrait();                                                                                        //Sets dom
        System.out.println("Dom trait: " + dominantTrait);
        this.createGametes();                                                                                           //Creates two gametes by dividing the genes
        System.out.printf("G1: %s, G2: %s\n\n", gamete1, gamete2);
    }

    private boolean geneCheck() {                                                                                       //Checks integrity of genes and sets the dom
        boolean isOK = false;
        int verifiedAll = 0;                                                                                            //def values set
        String g1 = this.gene.get(0).toLowerCase();
        String g2 = this.gene.get(1).toLowerCase();
        if(g1.equals(g2)) {                                                                                             //if both the genes are same alphabetically,
            verifiedAll++;                                                                                              //increase the count
        }
        for(int k = 0; k < 2; k++) {                                                                                    //iterates over the two genes
            int len = gene.get(k).length();
            if (len == 1) {                                                                                             //if the current element's length is 1
                verifiedAll++;                                                                                          //increase verified count
            }
        }
        if(verifiedAll == 2) {                                                                                          //two times verified means oll korrect
            isOK = true;
        }
        return isOK;
    }

    private void setDominantTrait() {
        String domTrait = "none";
        DomSelector: for(int i = 0; i < 2; i++) {                                                                       //iterates over two genes
            String geneAtThisInt = gene.get(i);
            char geneChar = geneAtThisInt.charAt(0);                                                                    //converts current element to char
            if(Character.isUpperCase(geneChar)) {                                                                       //checks if it is capital
                domTrait = geneAtThisInt;
                break DomSelector;                                                                                      //if yes, then break things
            }
        }
        this.dominantTrait = domTrait;                                                                                  //set the capital one as dominant trait
    }

    protected void createGametes() {                                                                                    //Initializes the gametes
        gamete1 = gene.get(0);
        gamete2 = gene.get(1);
    }

    protected String getGamete(int whichGamete) {                                                                       //Starts from 0, not 1
        String gamete = "";
        if(whichGamete == 0) {
            gamete = gamete1;
        } else if(whichGamete == 1) {
            gamete = gamete2;
        } else {
            System.out.println("Invalid gamete index passed");
        }
        return gamete;
    }
}
