/*Tim Smith
  CS2100
  Extention of Dice class that allows for easy ADDITION AND ROLLING OF ALL DIE*/
import java.util.*;
public class DiceRoll extends Dice
{
   //Constants
   private static final int NUM_DIE = 5;
   /*Class Constructor*/
   public DiceRoll()
   {
      super();
      for(int i = 0; i< NUM_DIE; i++)
      {
         super.addDie(new Die());
      }
   }
   /*Rolls all of the Die in the DiceRoll object
   @param NONE
   @return NONE*/
   public void toss()
   {
      int num = super.getNumDice();
      int count = 0;
      while (count < num-1)
      {
         Die d = super.getDie(count);
         d.roll();
         count++;
      }
   }
}
         
   
      