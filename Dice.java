/*Tim Smith
  CS2100
  Class for creating and manipulating Dice objects*/
import java.util.*;
public class Dice
{
   //instance variables
   private String s;
   private ArrayList<Die> dice;
   private static final int DEF_CAP = 5;
   
   /*Class constructor*/
   public Dice()
   {
      dice = new ArrayList<Die> (DEF_CAP);
   }
   /*Alternate constructor*/
   public Dice(int num)
   {
      dice = new ArrayList<Die> (num);
   }
   /*Takes in a Die object and adds it to the dice arraylist
   @param Die
   @return NONE*/
   public void addDie(Die d)
   {
      dice.add(d);
   }
   /*Returns an int with the number of Die in the arrayList
   @param NONE
   @return An integer representing the number of Die in the arraylist*/
   public int getNumDice()
   {
      return dice.size();
   }
   /*Retrieves a specific die from the arraylist
   @param int that is the index
   @return Die object retrieved from the arrayList*/
   public Die getDie(int i)
   {
      return dice.get(i);
   }
   /*Removes a Die from Dice
   @param Index of the Die being removed
   @return Die object that was removed*/
   public Die removeDie(int i)
   {
     
     return dice.remove(i);
   }
   /*Shows the number of a specific numbered Die in a given Dice object
   @param the desired Die number
   @return Int of how many of these objects are in Dice*/
   public int count(int val)
   {
       int count = 0;
       for (Die d: dice)
       {
          if (d.getValue() == val)
          {
             count ++;
          }
       }
       return count;
    }
    /*Sums up all the values of the Die in Dice
    @param none
   @return int that is the sum of the pips*/
    public int sum()
    {
       int sum = 0;
       for (Die d: dice)
       {
          sum += d.getValue();
       }
       return sum;
    }
    /*A boolean method saying wether a not a Die of some value is in the Dice object
    @param  int Desired value
   @return a true or false value telling whether that Die is in Dice*/
     public boolean contains(int val)
     {
        for (Die d: dice)
        {
           if (d.getValue() == val)
           {
              return true;
           }
        }
        return false;
     }
   /*String representation of the values of Die in Dice
   @param none
   @return String representation*/
   @Override
   public String toString()
   {
      String s="";
      int count = 1;
      
      for (Die d: dice)
      {
         s+=String.format("%d: value "+d.toString()+"\n", count);
         count++;
      }
      return s;
   }
}         