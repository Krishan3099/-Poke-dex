import java.util.*;
public class PakuriProgram {
    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        int menuChoice = 6;
        int maxCap = 0;
        String species = "";
        Pakudex myDex;

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while(true) {
            try {
                System.out.print("Enter max capacity of the Pakudex: ");
                maxCap = scnr.nextInt();
                myDex = new Pakudex(maxCap);
                System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri.\n");
                break;
            } catch (Exception e) {

                System.out.println("Please enter a valid size.");
                scnr.nextLine();
            }
        }

        while(true) {
            while(true) {
                try {
                    DisplayMenu();
                    menuChoice = scnr.nextInt();
                    break;
                }catch (InputMismatchException oopsie) {

                    System.out.println("Unrecognized menu selection!\n");
                    scnr.next();
                }
            }


            switch (menuChoice) {
                case 1:
                    if(myDex.getSize() != 0){
                        String[] speciesArray = myDex.getSpeciesArray();
                        System.out.println("Pakuri In Pakudex:");
                        for (int i = 0; i < speciesArray.length; i++) {
                            System.out.println(i + 1 + ". " + speciesArray[i]);
                        }
                    }else
                        System.out.println("No Pakuri in Pakudex yet!");

                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter the name of the species to display: ");
                    species = scnr.next();
                    int[] stats = myDex.getStats(species);
                    if(stats != null)
                    {
                        System.out.println();
                        System.out.println("Species: " + species);
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                        System.out.println();

                    }else
                        System.out.println("Error: No such Pakuri!\n");
                    break;

                case 3:

                    if(myDex.getSize() == myDex.getCapacity()){

                        System.out.println("Error: Pakudex is full!\n");
                        break;
                    }

                    System.out.print("Enter the name of the species to add: ");
                    species = scnr.next();

                    if(myDex.addPakuri(species)){

                        System.out.println("Pakuri species " + species + " successfully added!\n");

                    }else{

                        System.out.println("Error: Pakudex already contains this species!\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter the name of the species to evolve: ");
                    species = scnr.next();
                    if(myDex.evolveSpecies(species)){

                        System.out.println(species + " has evolved!\n");

                    }else{

                        System.out.println("Error: No such Pakuri!\n");
                    }
                    break;

                case 5:
                    myDex.sortPakuri();
                    System.out.println("Pakuri have been sorted!\n");
                    break;

                case 6:
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);

                default:
                    System.out.println("Unrecognized menu selection!\n");
            }
        }


    }

    public static void DisplayMenu(){
        System.out.println("Pakudex Main Menu\n" +
                "-----------------\n" +
                "1. List Pakuri\n" +
                "2. Show Pakuri\n" +
                "3. Add Pakuri\n" +
                "4. Evolve Pakuri\n" +
                "5. Sort Pakuri\n" +
                "6. Exit");

        System.out.print("\nWhat would you like to do? ");
    }

}
