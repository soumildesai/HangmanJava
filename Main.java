import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String word = Utilities.getWord();
        Hangman hangman = new Hangman(word);
        Scanner input = new Scanner(System.in);
        while(!hangman.checkWin() && !hangman.checkLose()){
            System.out.println("Guess a letter.");
            char guess = input.nextLine().charAt(0);
            hangman.guess(guess);
            hangman.addLetter(guess);
            System.out.println("Letters guessed: "+hangman.getCharacter());
            hangman.printLetters();
            System.out.println("Guesses left: "+(hangman.getMaxGuesses() - hangman.getIncorrect()));
        }
    }
}
