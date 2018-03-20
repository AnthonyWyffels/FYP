import java.util.*;
import java.util.Random;

public class GeneralClassification {
	
	public static void MainGeneralChat(String userinput) {
		
	if (userinput.contains("change key")) { //changing key
			Main.ChooseOption();
			Main.OptionSelected();
	}
	else {
		//this could all be put in a database at in a future stage. For the moment it is ok here though						
		String[][] general = 
			{
					//grettings part
					{"hi", "hello","hey"},//input part
					{"hi", "hello","hey"},//answer list
					//first question
					{"how are you"},
					{"I'm good, how can I help you ?"}, //answer
					//
					{"your name", "you called"},
					{"I'm called Isambot. Can I help you with anything? "},//answer
					//
					{"who made you"},
					{"I was developed by A.Wyffels"},
					//
					{"my name", "I called"},
					{"You should know that", "Your name is "+ Main.name},
		
					/* 
					 *  if you want to add responses for the general chat add them here leave the default one last!!!!!! otherwise the rest of the code won't work
					 */
					//default response
					{"I'm sorry I didn't understand that :("}
			};//end of general
		
		
		int response = 0; int j=0;
		/*General instruction for the following code
		 * response = 0  when it's searching through the array
		 * response = 1  when it finds an answer in the array 
		 * response = 2 if no match is found the chatbot answers with the default response */
		while (response ==0)
		{
			if (stringContainsItemFromArray(userinput.toLowerCase(), general[j*2]))
				{
					response = 1;
					int r = (int)Math.floor(Math.random()*general[j*2 +1].length);
					System.out.println("this is r: " + r);
					Main.botSay(general[j*2 +1][r]);
				}
			j++;
			//set the response of chatbot to 1 (=default) if nothing found in array
			if (j*2 == general.length-1 && response == 0)
			{
				response =2;
			}	
		}//end of while
		//let the bot print the default response
		if (response == 2 && userinput.contains("change key")==false) 
		{
			Main.botSay(general[general.length -1][0]);
		}
		
	}//end of big else

		
		
		
		
		
		
	}//end of MainGeneralChat
	
	
	private static boolean stringContainsItemFromArray (String input, String[] arr) {
		return Arrays.stream(arr).parallel().anyMatch(input::contains);
	}//end stringContainsItemFromArray
	
	
	
}//end of class