import pkg.*;

public class GameDriver
{
    
    //print initial state of game
    //repeatedly determine currentplayer and that player's next move
    //print both player's names and chosen moves
    //make the move
    //when gameover stop making moves
    //print name of winner and word "wins" or "Game ends in a draw" if no winner
    
    private GameState state;
    public GameDriver(GameState initial)
    {
        state=initial;
    }
    
    public void play()
    {
        System.out.println("The game begins and " + state);
        //prints initial state
        while(!state.isGameOver())
        {
            //while the game is not in ending state
            Player curP= state.getCurrentPlayer();
            String curM= curP.getNextMove(state);
            String curName= curP.getName();
            System.out.println("Current player is: " + curName + "Move: "+ curM);
            state.makeMove(curM);
        }
        
        Player win= state.getWinner();
        if(win!=null)
        {
            String winName= win.getName();
            System.out.println("The winner is: "+winName);
                                                 
        }
        if(win==null)
           {
            System.out.println("Game ends in a draw");
        }
        
        
        
    }
    
}
   


