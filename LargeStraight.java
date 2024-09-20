/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class LargeStraight extends Category
{
   /*Overriding the evaluate method for the large straight category
   checks for the two different types of large straight, if present the score is set to 40
   @param dice object
   @return int value with the score*/

   @Override
   public int evaluate(Dice d)
   {
      int d1 = d.count(1);
      int d2 = d.count(2);
      int d3 = d.count(3);
      int d4 = d.count(4);
      int d5 = d.count(5);
      int d6 = d.count(6);
      
      if (d1>0 && d2>0 && d3>0 && d4>0 && d5>0)
         return 40;
      if (d2>0 && d3>0 && d4>0 && d5>0 && d6>0)
         return 40;
      return 0;
   }
}
   
     
         