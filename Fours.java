/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class Fours extends Category
{
   /*Overriding the evaluate method for fours category, adds up all fours
   @param dice object
   @return int value with the score*/

   @Override
   public int evaluate(Dice d)
   {
      int count = d.getNumDice();
      int score = d.count(4);
      return score *4;
   }
}
   
     
         