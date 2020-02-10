package ie.gmit.dip;

import java.util.Scanner;

/**
 * 
 * @author Oleksandr Petrushchak
 * @version 1.0
 *
 */
public class Menu {
    private Scanner scanner;
    private Scanner keyScanner;
    private boolean keepRunning = true;
    Parser parser = new Parser();
    private String word;
    
    /**
     * Output initMenu with instruction(visual) and processInput that reads input
     * @throws Exception
     */
    public void start() throws Exception {
        scanner = new Scanner(System.in);
        do {
            initMenu();
            processInput();
        } while (keepRunning == true);
    }

    
    /**
     * Read input. Check if it is in Constants.StopWords. If not, proceed to file selection.
     * @throws Exception
     */
    private void processInput() throws Exception{
    	System.out.println(">");
        keyScanner = new Scanner(System.in);
        word = keyScanner.next();

        if(!parser.isStopWord(word)){
        	fileOptions(); // show list of available files
        	encryptOptions(); // switch statement with options(1-7)
        }else {
        	System.out.println(word +"- is in ignore list.");
        }
    }
    
    
    /**
     * Read input (integer) and proceed further with word and file.
     * @throws Exception
     */
    private void encryptOptions() throws Exception{
        String input = scanner.next();
        int choice = Integer.parseInt(input);
        switch (choice){
            case 1:
                System.out.println("War and Peace");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.WarAndPeace);
                exitOption();
                break;
            case 2:
                System.out.println("De Bello Gallicio-Caesar");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.DeBelloGallico);
                exitOption();
                break;
            case 3:
                System.out.println("Divine Comedy");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.DivineComedy);
                exitOption();
                break;
            case 4:
                System.out.println("Happy Prince");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.HappyPrince);
                exitOption();
                break;          
            case 5:
                System.out.println("Picture of Dorian Gray");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.PictureOfDorianGray);
                exitOption();
                break;
            case 6:
                System.out.println("Poblacht Na H Eireann");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.PoblachtNaHEireann);
                exitOption();
                break;
            case 7:
                System.out.println("The Prince");
                keyScanner = new Scanner(System.in);
                parser.getWordFromDictionary(word, Constants.ThePrince);
                exitOption();
                break;
        }
    }
    
    
    /**
     * UI with list of files available to be analysed.
     */
   private void fileOptions(){
        System.out.println("-----------------------------------------------");
        System.out.println("|               Dictionary                    |");
        System.out.println("-----------------------------------------------");
        System.out.println("| Choose a file:                              |");
        System.out.println("|                                             |");
        System.out.println("|  (1) War and Peace                          |");
        System.out.println("|  (2) De Bello Gallicio-Caesar               |");
        System.out.println("|  (3) Divine Comedy                          |");
        System.out.println("|  (4) Happy Prince                           |");
        System.out.println("|  (5) Picture of Dorian Gray                 |");
        System.out.println("|  (6) Poblacht Na H Eireann                  |");
        System.out.println("|  (7) The Prince                             |");
        System.out.println("|                                             |");
        System.out.println("-----------------------------------------------");
    }  
        
   
   /**
    * UI with instruction to: "Enter word".
    */
    private void initMenu(){
        System.out.println("-----------------------------------------------");
        System.out.println("|               Dictionary                    |");
        System.out.println("-----------------------------------------------");
        System.out.println("|      Enter word                             |");
    }
    
    
    /**
     * Method giving an option to run program again or exit.
     * @throws Exception
     */
    private void exitOption() throws Exception {
    	System.out.println("-----------------------------------------------");
    	System.out.println("|Options: (1)Enter another word;   (2)Exit.   |");
    	System.out.println("-----------------------------------------------");
    	String input = scanner.next();
        int choice = Integer.parseInt(input);
        switch(choice){
        	case 1:
        		start();
        		break;
        	case 2:
        		keepRunning = false;
        		break;
        	default:
        		System.out.println("Invalid option");
        		exitOption();
        		break;
        }
    }
}
