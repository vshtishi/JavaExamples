package com.github.vshtishi;

public class CardFactory {
      public static Card getCard(String identity){
    	  switch(identity){
    	  case "employee": return new EmployeeCard(0.15);
    	  case "student": return new StudentCard(0.10);
    	  }
     //If no matching subclass could be found
      throw new UnsupportedOperationException("Invalid identity" +identity);
   }
}
