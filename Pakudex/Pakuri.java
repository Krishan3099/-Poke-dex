public class Pakuri implements Comparable<Pakuri>{

    private String species;
    private int attack, defense, speed;

    public Pakuri(String species){

        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
        this.species = species;

    }
    // returns species name
    public String getSpecies(){

        return species;
    }

    // returns attack integer
    public int getAttack(){

        return attack;
    }

    // returns defense integer
    public int getDefense(){

        return defense;
    }

    // returns speed integer
    public int getSpeed(){

        return speed;
    }

    // sets attack = newAttack
    public void setAttack(int newAttack){

        attack = newAttack;
    }

    // a) double the attack; b) quadruple the defense; and c) triple the speed
    public void evolve(){
        // create case for failed evolution
        this.attack = attack * 2;
        this.defense = defense * 4;
        this.speed = speed * 3;
    }


    public int compareTo(Pakuri target) {
        return this.species.compareTo(target.getSpecies());
    }

}
