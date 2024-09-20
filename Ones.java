/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Ones extends Category
{
   /*Overriding the evaluate method for ones category, adds up all ones
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(1);
      return score;
   }
}
   
     
         