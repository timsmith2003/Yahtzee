/*Tim Smith
  CS2100
  A specific category that overrides the category method evaluate*/
public class Chance extends Category
{  
   /*Adds upp all the values of the pips and returns an int
   @param Dice object
   @return int representing the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = 0;
      for (int i = 1; i < 6; i++)
      {
         count += d.getDie(i-1).getValue();
      }
      return count;
   }
}
   
     
         