/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Fives extends Category
{  
   /*Overriding the evaluate method for fives category, adds up all fives
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(5);
      return score * 5;
   }
}
   
     
         