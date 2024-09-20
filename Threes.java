/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Threes extends Category
{
   /*Overriding the evaluate method for Threes category, adds up all Threes
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(3);
      return score * 3; 
   }
}
   
     
         