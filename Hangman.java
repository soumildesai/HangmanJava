import java.util.ArrayList;

public class Hangman {
    private ArrayList<Character> character; //represents "already guessed characters" list
    private String word;
    private static final int MAXGUESSES = 10;
    private static int incorrect = 0;

    public Hangman(String word){
        //Constructor
        this.word = word;
        character = new ArrayList<>();
    }

    public boolean guess(char guess){
        //Checks if the the guessed letter is in the word
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == guess) {
                return true;
            }
        }
        incorrect+=1;
        return false;
    }

    public void addLetter(char guess){
        //adds letter to 'already guessed letters' ArrayList
        // (if the list doesn't already have that guessed letter)
        if(!character.contains(guess)){
            character.add(guess);
        }
    }

    //Simple getters for the characters list, the word, incorrect guesses,
    // and the max guesses
    public ArrayList<Character> getCharacter(){return character;}
    public String getWord(){return word;}
    public int getMaxGuesses(){return MAXGUESSES;}
    public int getIncorrect(){return incorrect;}

    //goes through the word, prints letters that have already been guessed,
    //and puts an _ (underscore) in place for the letters that haven't
    public void printLetters(){
        for (int i = 0; i<word.length(); i++){
            char letter = word.charAt(i);
            if(character.contains(letter)){
                System.out.print(letter);
            }
            else{
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    //checks if the player has won by checking all the letters in the word are in the
    //already guessed list
    public boolean checkWin(){
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!character.contains(letter)){
                return false;
            }
        }
        System.out.println("YAY YOU WON!");
        return true;
    }

    //checks if player has lost by checking if incorrect guesses is greater than or
    //equal to the max guesses
    public boolean checkLose(){
        if (incorrect >= MAXGUESSES){
            System.out.println("UR BAD AT HANGMAN!!!!");
            System.out.println("The correct word was: "+word);
            return true;
        }
        return false;
    }
}
