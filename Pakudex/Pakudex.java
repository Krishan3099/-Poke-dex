import java.util.Arrays;
public class Pakudex{

    private int capacity;
    private int pakuCounter = 0;
    Pakuri[] pakuris;

    public Pakudex(){

        capacity = 20;
        pakuris = new Pakuri[capacity];

    }

    // sets max cap of Pakudex
    public Pakudex(int capacity){
        this.capacity = capacity;
        pakuris = new Pakuri[capacity];
    }

    public int getSize(){
        return pakuCounter;
    }

    // returns max capacity
    public int getCapacity(){

        return capacity;

    }

    //returns the names of all Pakudex pakuris
    public String[] getSpeciesArray(){

        String[] pakNames = new String[pakuCounter];
        for(int i = 0; i < pakNames.length; i++){
            if(pakuris[i] == null)
                pakNames[i] = null;
            else
                pakNames[i] = pakuris[i].getSpecies();
        }
        return pakNames;
    }

    //Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, and 2
    //respectively; if species is not in the Pakudex, returns null
    public int[] getStats(String species) {

        int[] stats = new int[3];
        for (int i = 0; i < getSize(); i++) {
            if (pakuris[i].getSpecies().equals(species)) {
                stats[0] = pakuris[i].getAttack();
                stats[1] = pakuris[i].getDefense();
                stats[2] = pakuris[i].getSpeed();
                return stats;
            }
        }
        if (stats[0] == 0 && stats[1] == 0 && stats[2] == 0)
            return null;
        else
            return stats;

    }

    public void sortPakuri(){

        Pakuri[] pakuriSort = new Pakuri[pakuCounter];

        for(int i = 0; i < pakuCounter; i++){
            pakuriSort[i] = pakuris[i];
        }

        Arrays.sort(pakuriSort);

        for(int i = 0; i < pakuCounter; i++){
            pakuris[i] = pakuriSort[i];
        }
    }

    public boolean addPakuri(String species){
        pakuCounter++;
        String[] tester = getSpeciesArray();

        if(pakuCounter <= capacity && !Arrays.asList(tester).contains(species))
        {
            pakuris[getSize()-1] = new Pakuri(species);
            return true;
        }else
            return false;
    }

    public boolean evolveSpecies(String species){
        for (int i = 0; i < getSize(); i++) {
            if (pakuris[i].getSpecies().equals(species)) {
                pakuris[i].evolve();
                return true;
            }
        }
         return false;
    }

}
