import pkg.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.awt.Canvas;
import java.lang.Object;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Hangman extends Canvas implements GameState
{
    private boolean state;
    private String[] b;
    private EasyReader read;
    private String line;
    private ArrayList<Object> person;
    private JFrame frame;
    private Canvas canvas;
    private Rectangle cover;
    private Graphics g;
    private String[] nature;
    private String[] teacher;
    private String[] cs;
    private String word;
    private boolean play;
    private Player win;
    private Player comp;
    private int countright;
    private String guess;
    private String[] w;
    private String[] ran;
    private int countwrong;
    private int[] numright;
    private int lettercount;
    public Hangman(String w)
    {
        numright= new int[26];
        win=new Player("Word Guesser");
        comp=new Player("Computer");
        word=w;
        if (word.equalsIgnoreCase("nature"))
        {
            EasyReader n= new EasyReader("nature.txt");
            nature=new String[8];
            for(int a=0; a<8; a++)
            {
                nature[a]= n.readLine();
            }
            int r= (int)(Math.random()*8);
            word=nature[r];
            //System.out.println(word);
            for(int j=0; j<50; j++)
            {
                System.out.println();
            }
        }
        else if (word.equalsIgnoreCase("teachers"))
        {
            EasyReader t= new EasyReader("teachers.txt");
            teacher=new String[9];
            for(int a=0; a<9; a++)
            {
                teacher[a]= t.readLine();
            }
            int rr= (int)(Math.random()*9);
            word=teacher[rr];
            for(int j=0; j<50; j++)
            {
                System.out.println();
            }
        }
        else if (word.equalsIgnoreCase("comp sci"))
        {
            EasyReader c= new EasyReader("cs.txt");
            cs=new String[10];
            for(int a=0; a<10; a++)
            {
                cs[a]= c.readLine();
            }
            int rr= (int)(Math.random()*10);
            word=cs[rr];
            for(int j=0; j<50; j++)
            {
                System.out.println();
            }
        }
        else
        {
            EasyReader r= new EasyReader("random.txt");
            ran= new String[28];
            for(int a=0; a<28; a++)
            {
                ran[a]= r.readLine();
            }
            int rr= (int)(Math.random()*28);
            word=ran[rr];
            System.out.println(word);
            for(int j=0; j<50; j++)
            {
                System.out.println();
            }
            System.out.println("You might have typed something wrong, so a random word was chosen");
            
        }
        
        
        frame = new JFrame("My Drawing");
        canvas = new Canvas();
        canvas.setSize(2000, 2000);
        frame.add(canvas);
        frame.pack();

        PlayHangman(word);
        
    }
    public Hangman(String w, boolean b)
    {
        numright= new int[26];
        win=new Player("Word Guesser");
        comp=new Player("Computer");
        word=w;
        frame = new JFrame("My Drawing");
        canvas = new Canvas();
        canvas.setSize(2000, 2000);
        frame.add(canvas);
        frame.pack();

        System.out.println(word);
        for(int j=0; j<50; j++){
            System.out.println();
        }
        PlayHangman(word);
        
    }
	private void PlayHangman(String a)
	{
        word=a;
        w=new String[word.length()];
        for(int b=0;b<word.length(); b++)
        {
            w[b]=word.substring(b,b+1);
        }
        int spacer=20;
        drawHang();
        Line[] under= new Line[a.length()];
        lettercount=0;
        int count=0;
        for(int b=1; b<a.length()+1; b++)
        {
            if(!a.substring(b-1,b).equals(" "))
            {
                g.drawLine(spacer, 500, spacer+10, 500);
                under[count]= new Line(spacer, 500, spacer+50, 500);
                spacer= spacer+ 30;
                lettercount++;
                count++;
            }
            if(a.substring(b-1,b).equals(" "))
            {
                count++;
                spacer=spacer + 20;
            }
        }
        play= true;
        int index=0;
        read = new EasyReader();
        countright=0;
        String temp="";
        int wrongX= -40;
        int wrongY= 520;
        countwrong=0;
        while(play)
        {
            System.out.println("What is your guess?");
            String k= read.readLine();
            k=k.toLowerCase();
            if(!(k.equalsIgnoreCase(""))){
            guess= k.substring(0,1);
            index=a.indexOf(guess);
            int c=0;
            if(guess.equalsIgnoreCase("a")){
                numright[0]=numright[0]+1;
                c=0;
            } else if(guess.equalsIgnoreCase("b")){
                numright[1]=numright[1]+1;
                c=1;
            }else if(guess.equalsIgnoreCase("c")){
                numright[2]=numright[2]+1;
                c=2;
            }else if(guess.equalsIgnoreCase("d")){
                numright[3]=numright[3]+1;
                c=3;
            }else if(guess.equalsIgnoreCase("e")){
                numright[4]=numright[4]+1;
                c=4;
            }else if(guess.equalsIgnoreCase("f")){
                numright[5]=numright[5]+1;
                c=5;
            }else if(guess.equalsIgnoreCase("g")){
                numright[6]=numright[6]+1;
                c=6;
            }else if(guess.equalsIgnoreCase("h")){
                numright[7]=numright[7]+1;
                c=7;
            }else if(guess.equalsIgnoreCase("i")){
                numright[8]=numright[8]+1;
                c=8;
            }else if(guess.equalsIgnoreCase("j")){
                numright[9]=numright[9]+1;
                c=9;
            }else if(guess.equalsIgnoreCase("k")){
                numright[10]=numright[10]+1;
                c=10;
            }else if(guess.equalsIgnoreCase("l")){
                numright[11]=numright[11]+1;
                c=11;
            }else if(guess.equalsIgnoreCase("m")){
                numright[12]=numright[12]+1;
                c=12;
            }else if(guess.equalsIgnoreCase("n")){
                numright[13]=numright[13]+1;
                c=13;
            }else if(guess.equalsIgnoreCase("o")){
                numright[14]=numright[14]+1;
                c=14;
            }else if(guess.equalsIgnoreCase("p")){
                numright[15]=numright[15]+1;
                c=15;
            }else if(guess.equalsIgnoreCase("q")){
                numright[16]=numright[16]+1;
                c=16;
            }else if(guess.equalsIgnoreCase("r")){
                numright[17]=numright[17]+1;
                c=17;
            }else if(guess.equalsIgnoreCase("s")){
                numright[18]=numright[18]+1;
                c=18;
            }else if(guess.equalsIgnoreCase("t")){
                numright[19]=numright[19]+1;
                c=19;
            }else if(guess.equalsIgnoreCase("u")){
                numright[20]=numright[20]+1;
                c=20;
            }else if(guess.equalsIgnoreCase("v")){
                numright[21]=numright[21]+1;
                c=21;
            }else if(guess.equalsIgnoreCase("w")){
                numright[22]=numright[22]+1;
                c=22;
            }else if(guess.equalsIgnoreCase("x")){
                numright[23]=numright[23]+1;
                c=23;
            }else if(guess.equalsIgnoreCase("y")){
                numright[24]=numright[24]+1;
                c=24;
            }else if(guess.equalsIgnoreCase("z")){
                numright[25]=numright[25]+1;
                c=25;
            }
            if(k.equals(a))
            {
                System.out.println("You won! The word was: "+ a);

                play=false;
       
                
            }
      
            else if (index==-1){
                if(numright[c]==1){
                g.drawString(guess,wrongX+45,wrongY);
                wrongX=wrongX+30;
                guessWrong(countwrong);
                if(countwrong==5)
                {
                    System.out.println("You lost! The word was: "+ a);
                    play=false;
                }
                countwrong++;
                }
            }
            else if(index!=-1){
                while(index!=-1)
                {
                    
                    countright= countright+1;
                    if(countright==lettercount)
                    {
                        System.out.println("You won! The word was: "+ a);
                        play=false;
                        
                    }
                    g.drawString(a.substring(index, index+1), under[index].getX(),under[index].getY()-5);
                    index= a.indexOf(guess, index+1);
                }
            }
            }
        }
    }
    
    private void drawHang()
    {
        frame.add(canvas);

        frame.setVisible(true);
        
         g = canvas.getGraphics();
        g.drawLine(50, 350, 150, 350);
        g.drawLine(100, 350, 100, 150);
        g.drawLine(100, 150, 200, 150);

        g.drawLine(200, 150, 200,180);
    }
    private void guessWrong(int num)
    {
        if(num==0)
        {
            g.drawOval(180, 180, 40,40);
        }
        if(num==1)
        {
            g.drawLine(200, 220, 200, 280);
            
        }
        if(num==2)
        {
            g.drawLine(200,250, 220, 230);
        }
        if(num==3)
        {
           g.drawLine(200,250, 180, 230);
        
        }
        if(num==4)
        {
            g.drawLine(200,280, 180, 310);
            
        }
        if(num==5)
        {
            g.drawLine(200,280, 220, 310);
        }
        
    }
  
    public boolean isGameOver()
    {
        return !play;
    }
    public Player getWinner()
    {
        if(countwrong<5)
        {
            return win;
        }
        return comp;
        
    }
    public Player getCurrentPlayer()
    {
        return win;
    }
    public ArrayList<String> getCurrentMoves()
    {
        ArrayList<String> moves= new ArrayList<String>(word.length()-countright);
        for(String a: w)
        {
            moves.add(a);
        }
        
        return moves;
    }
    public void makeMove(String next)
    {
        guess=next;
        
    }
    public String toString()
    {
       return "the word is: "+ word;
    }
}
