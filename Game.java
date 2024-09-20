/*Tim Smith
  CS2100
  Creates the methods and varibles necessary for playing the game and user input*/
//imports
import java.util.Scanner;
import java.util.*;
public class Game
{
   //instance varibles and constants
   private ScoreCard s1;
   private ScoreCard s2;
   Scanner keyboard = new Scanner(System.in);
   
   private static final int NUM_ROLLS = 2;
   /*Class constructor*/
   public Game()
   {  
      //cREATING BOTH PLAYER SCORECARDS*/
      s1 = new ScoreCard();
      s2 = new ScoreCard();
      //sETTING THE GAME IN MOTION GIVING EACH PLAYER 13 TURNS
      for (int i = 0; i< 13; i++)
      {
         this.turn(s1);
         this.turn(s2);
      }
      int score1 = s1.score();
      int score2 = s2.score();
      //The declaration of the winner
      if (s1.score() > s2.score())
      System.out.print("PLAYER ONE WINS");
      else if (s2.score()>s1.score())
      System.out.print("PLAYER TWO WINS");
      else
      System.out.print("THERE WAS A TIE!");

   }
   /*This method simulates a player turn and controlls input
   @param Scorecard object
   @return NONE*/
   public void turn(ScoreCard s)
   {
      //Tracks which die are saved
      boolean[] saved = new boolean[5];
      
      for (int i = 0; i < 5; i++)
      {
         saved[i] = false;
      }
      DiceRoll d = new DiceRoll();
      d.toss();
      int numRolls = 0;
      boolean scored = false;
      
      if (s == s1)
         System.out.print("***Player One: ***\n");
      if (s==s2)
         System.out.print("***Player Two: ***\n");
      System.out.print(s);
      System.out.print("***************************************************\n");
      System.out.print(d);
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": ");
      int saver = 0;
      String input = keyboard.nextLine();
      
      //loop make sure players only get two re-rolls and once they have scored the loop ends
      while (numRolls < NUM_ROLLS && !scored)
      {
            if (input.equals("roll"))
            {
               numRolls++;
               this.rollDie(s,saved,d);
               System.out.print("***************************************************\n");
               System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": ");
               input = keyboard.nextLine();
               }
            
            else if(input.equals("score"))
            {
               scored=true;
               this.scoreIt(s, d);
            }
            //input validation
            else
            {
               try
               {
                  saver = Integer.parseInt(input);
               }
               catch (NumberFormatException e)
               {
                  System.out.print(input + " is not a valid die value or input\n");
                  System.out.print(s);
                  System.out.print("***************************************************\n");
                  System.out.print("Dice:\n");
                  for (int i = 1; i < 6; i ++)
                  {
                     if (saved[i-1] == true)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "   SAVED\n");
                     }
                     else if (saved[i-1] == false)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "\n");
                     }
                  }
                  System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": ");
                  input = keyboard.nextLine();
               }
               
               if (saver < 1 || saver > 5)
               {
                  System.out.print(input + " is not a valid die value or input\n");
                  System.out.print(s);
                  System.out.print("***************************************************\n");
                  System.out.print("Dice:\n");
                  for (int i = 1; i < 6; i ++)
                  {
                     if (saved[i-1] == true)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "   SAVED\n");
                     }
                     else if (saved[i-1] == false)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "\n");
                     }
                  }
                  System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": ");
                  input = keyboard.nextLine();
                  
               }
               if (saver > 0 && saver < 6)
               {
                  this.save(saver, saved);
                  
                  System.out.print("***************************************************\n");
                  System.out.print("Dice:\n");
                  for (int i = 1; i < 6; i ++)
                  {
                     if (saved[i-1] == true)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "   SAVED\n");
                     }
                     else if (saved[i-1] == false)
                     {
                        System.out.print(i + ": value " + d.getDie(i-1).toString() + "\n");
                     }
                  }
                  System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": ");
                  input = keyboard.nextLine();
                  
               }
      
            }
      }
         
       //Makes sure players score after rolling their max
       if (!scored)
               {
                  System.out.print("You must score, you have no rolls left");
                  System.out.println("\nDice:");
                  for (int i = 0; i < d.getNumDice(); i++) {
                     System.out.println(String.format("%d: value %d", i + 1, d.getDie(i).getValue()));
                  }
                  
                  System.out.println("\n");
                  scoreIt(s, d);
                  
               }
   }
    /*saves/unsaves die in the saved array
   @param integer to be saved/unsaved in array, the array with the boolean objects
   @return int NONE*/
    public void save(int i, boolean[] a)
    { 
      if (a[i-1] == true)
      {
         a[i-1] = false;
      }
      else if (a[i-1] == false)
      {
         a[i-1] = true;
      }
    }
    /*Rolls the die that are not saved and presents them to the user
   @param dice object, scorecard object, and array of saved
   @return NONE*/
    public void rollDie(ScoreCard s, boolean[] a, DiceRoll d)
    {
         System.out.print(s);
         System.out.print("***************************************************\n");
         System.out.print("Dice:\n");
         for (int i = 1; i < 6; i ++)
         {
            if (a[i-1] == true)
            {
               System.out.printf("%d: value " + d.getDie(i-1).toString() + " SAVED\n", i);
            }
            else if (a[i-1] == false)
            {
               d.getDie(i-1).roll();
               System.out.printf("%d: value " +  d.getDie(i-1).toString() + "\n", i);
            }
         }
       }
   /*Scores the category selected and makes sure it wont be used again by the same player
   @param dice object, scorecard object
   @return NONE*/
   public void scoreIt(ScoreCard s, DiceRoll d)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("\nSelect a category you have not scored in yet:\n");
      for (CategoryValue c: CategoryValue.values())
      {
         if(s.checkScored(c,d)==false)
         {  
            System.out.printf("%d: %s, %d points\n", c.getValue()+1, c.toString(), s.getEvaluation(c,d));
         }
      }
      
      int selection = keyboard.nextInt();
      CategoryValue cv = CategoryValue.ONES;
      for(CategoryValue x : CategoryValue.values())
      {
         if (selection == x.getValue()+1)
            cv = x;
      }
      while (s.checkScored(cv,d)==true || selection > 13 || selection < 1)
      {
         System.out.print("\nSelect a category you have not scored in yet:\n");
         selection = keyboard.nextInt();
         for(CategoryValue x : CategoryValue.values())
         {
            if (selection == x.getValue()+1)
               cv = x;
         }
      }
         
      for (CategoryValue x: CategoryValue.values())
      {
         if (selection == x.getValue()+1)
         {
            s.choose(x,d);
            System.out.printf("You scored %d points in %s\n", s.getEvaluation(x,d), x.toString());
         }
      }
         
}
}




         
      
      