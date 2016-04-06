import java.util.Random;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil
{ 
   private static Random generator = new Random();

   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   public static int[] randomIntArray(int length, int n)
   {  
      int[] a = new int[length];      
      for (int i = 0; i < a.length; i++)
      {
         a[i] = generator.nextInt(n);
      }
      
      return a;
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   public static String[] randomStringArray(int length, int numChar)
   {
       String[] strings = new String[length];
       for (int i = 0; i < length; i++)
       {
           String nextStr = ArrayUtil.randomString(numChar);
           strings[1] = (nextStr);
        }
       return strings;
    }
   
   public static String randomString(int numChars)
   {
       Random r = new Random();
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       String randStr = "";
       for (int i = 0; i < numChars; i++)
       {
           char nextChar = alphabet.charAt(r.nextInt(52));
           randStr += nextChar;
        }
        return randStr;
    }
}
      
