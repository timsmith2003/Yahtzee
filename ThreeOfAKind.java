/*Tim Smith
  CS2100
  Extends the category class and overrides the evaluate method for the threeofakind category*/
public class ThreeOfAKind extends Category
{
   /*Overriding the evaluate method for three of a kind category, adds up all die
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      boolean three = false;
      
      for (int i = 1; i < 7; i++)
      {
         if (d.count(i)>=3)
            three = true;
      }
      if (three == true)
         return d.sum();
      return 0;
   }
}
   
     
         