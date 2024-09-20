/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Yahtzee extends Category
{
   /*Overriding the evaluate method for yahtzee category, adds a score of 50 if all dice same number
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      
      for (int i = 1; i < 6; i++)
      {
         if (d.count(i)==5)
            return 50;
      }
      return 0;
   }
}
   
     
         