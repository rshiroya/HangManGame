
/**
 * This class is the game class for a very simple 
 * hangman game.
 * 
 * @author R. Shiroya
 * @version v1
 */
public class GameWord
{
   private String phrase;
   private StringBuilder inProgress;
   private int numberWrongGuesses;
   private StringBuilder state;
   private boolean gameOver;
   
   public GameWord( )
   {
       inProgress = new StringBuilder( );
       phrase = new String( );
       numberWrongGuesses = 0;
       state = new StringBuilder( );
       gameOver = false;
    }
    
    public GameWord(String phraseToGuess)
    {
        phrase = new String(phraseToGuess);
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++)
        {
            //build the seequence of dashes indicating
            //the number of characters in the phrase
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;//needed to build the stick figure
        gameOver = false;
    }
        
    public void setPhrase(String phraseToGuess)
    {
        phrase = new String(phraseToGuess);
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++)
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;
        state = new StringBuilder( );
        gameOver = false;
    }
    
    public boolean getGameOver( )
    {
        return gameOver;
    }
    
    public void find(char symbol)
    {
        int count = 0;
        int pos = 0;
        pos = phrase.indexOf(symbol);
        //use the StringBuilder class indexOf( ) methods
        //to find all the occorances of the guessed symbol
        while(pos != -1)
        { 
          count++;//count increases when an occarance of the letter is found
          // the pos * 2 is because every letter has a space
          //after it
          inProgress.setCharAt(pos*2,symbol);
          pos = phrase.indexOf(symbol, pos + 1);;
        }
        if(count == 0) //no occarances of the letter were found
        {
            //update the field of how many wrong guess there
            //were so the stickman can be added on to
            numberWrongGuesses++;
            updateState( );//update the stick figure
        }
    }
    
  public boolean checkWin( )
   {
      boolean match = true;
       for(int k = 0, m = 0; k < phrase.length( ) && match; k++, m += 2)
      {
          if(phrase.charAt(k) != inProgress.charAt(m))
          {
              match = false;
         
          }
      }
      return match;
    }
   
    
   private void updateState( )
   { 
      
       switch(numberWrongGuesses)
       {
           case 1: state.append("\n\t\t\t\t\t\t  0");
                   break;
           case 2: state.append( "\n\t\t\t\t       /");
                   break;
           case 3: state.append(" |");
                   break;
           case 4: state.append( " \\");
                   break;
           case 5: state.append("\n\t\t\t\t         |");
                   break;
           case 6: state.append("\n\t\t\t\t        /");
                   break;
           case 7: state.append(" \\\n\n\t\t\t\t      OH NO!!\n");
                   gameOver = true;
                   
        
      }
      
  }
  
  public String toString(  )
  {
      return new String("\n***************************************\n" 
            + inProgress + "\n" + state.toString( ));
  }
}