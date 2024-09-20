/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Sixes extends Category
{  
   /*Overriding the evaluate method for sixes category, adds up all sixes
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(6);
      return score * 6; 
   }
}
   
     
         