import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//this class is everything to do with the health key. 
public class HealthClass {

	public static void Main() {
		
		
		
		Main.txtEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.trimming();//triming method
				String uText = Main.txtEnter.getText();
				//System.out.println("This is txtEnter trimmed : "+uText);
				Main.txtChat.append(Main.name + ": "+ uText + "\n");
				
				try {
					String myDriver = "com.mysql.jdbc.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/fyp";// fyp since it's the name of the db
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "root", "");

					String str = Main.txtEnter.getText();
					String query = "SELECT * FROM healthinput WHERE '"+ str + "' LIKE CONCAT('%',userinput, '%');";  //FROM table don't put from <name of db> not a good idea!!!

					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(query);

					if(rs.next()) 
					{
						//need to select random row from the possible answers:  sql query
						//botSay the answer.
						int categorie = rs.getInt(3);
						
						String query2 = "SELECT * FROM healthoutput WHERE categorienb="+ categorie + ";";     
						Statement st2 = conn.createStatement();
						ResultSet rs2 = st.executeQuery(query2);
						if (rs2.next()) 
						{
							String output = rs2.getString(2);
							Main.botSay(output);
						}
					}

					else 
					{
						GeneralClassification.MainGeneralChat(uText);
					}


					}catch (Exception e){
						e.printStackTrace();
						GeneralClassification.MainGeneralChat(uText);
						//Main.botSay("Can you be more precise for me please, I'm only a bot after all :-)");
					}

				
				Main.txtEnter.setText("");
			}
		});
	}//end of Main()
	
}//end of HealthClass.java