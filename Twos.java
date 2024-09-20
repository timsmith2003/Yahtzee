/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Twos extends Category
{
   /*Overriding the evaluate method for twos category, adds up all twos
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(2);
      return score * 2;
   }
}
   
     
         