import pkg.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class starter implements InputControl
{
    private int counter=0;
        public static void main(String args[])
		{
            MouseController mC = new MouseController(Canvas.getInstance(),new starter());
            firstPage b= new firstPage();

			
		}
    public void onMouseClick(double xx, double yy)
    {
        if(counter==0){
            counter++;
        if((20<xx && xx<270) && (250<yy && yy<350))
        {
            System.out.println("type a category: nature, teachers, or comp sci");
            EasyReader read= new EasyReader();
            String word= read.readLine();
            GameState g = new Hangman(word);
            GameDriver game = new GameDriver(g);
            game.play();
            
            
        }
        else if((330<xx && xx<580) && (250<yy && yy<350))
        {
            
            System.out.println("What would your friend like the word to be:");
            EasyReader read= new EasyReader();
            String word= read.readLine();
            for(int tc= 0; tc<15; tc++){
                System.out.println();
            }
            boolean c= true;
            GameState g = new Hangman(word, c);
            GameDriver game = new GameDriver(g);
            game.play();
        }
        else
        {
//            EasyReader r= new EasyReader("random.txt");
//            String[] ran= new String[28];
//            for(int a=0; a<28; a++)
//            {
//                ran[a]= r.readLine();
//            }
//            int rr= (int)(Math.random()*28);
//            String word=ran[rr];
            String word="random";
            GameState g = new Hangman(word);
            GameDriver game = new GameDriver(g);
            game.play();
        }
       
        
    }
    }
			
}

