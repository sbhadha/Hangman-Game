import pkg.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Player

{
    private String name;
    
    public Player(String aName)
    {
        name= aName;
    }
    public String getName()
    {
        return name;
    }
    public String getNextMove(GameState state)
    {
        ArrayList<String> possmoves= state.getCurrentMoves();
        int gwgame= (int)(Math.random()*(possmoves.size()-1));;
        String nmove= possmoves.get(gwgame);
        return nmove;
    }
}
