package Grammar;

import java.util.ArrayList;
import java.util.List;

public class Test {

   public static void main(String[] args) {
      String[] myArray = { "Apple", "Banana", "Orange" };
      List<String> myList = new ArrayList<String>();
      for (String str : myArray) {
         myList.add(str);
      }
      System.out.println(myList.size());
   }
}