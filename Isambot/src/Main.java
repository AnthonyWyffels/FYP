import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {

	public static String key;
	private static JFrame frame = new JFrame();
	public static String name;
	public static int option;
	public static JTextField txtEnter = new JTextField();
	public static JTextArea txtChat = new JTextArea();
	static Thread thread = new Thread();
	
	public static void main(String[] args) throws IOException{
		NameBox();
		ChooseOption();
		ChatboxFrame();
		OptionSelected();
	}
	
	
	
	
	public static void NameBox() {
		int g=-1;
		while (g<0)
		{
			name = JOptionPane.showInputDialog("Enter name here");	
			if (name.length()>0) {g++;}
			else{
				System.out.println("please enter your name!");
			}
		}
	}//end of nameBox()
	
	public static void ChooseOption() {
		int g=-1;
		String[] option = {"health", "studies", "finance"};
		while (g<0) 
		{
		int x =JOptionPane.showOptionDialog(null, "Hello "+ name + " please choose a categorie with which i can help you with", "Brunel Chatbot", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
		key = option[x];
		key = key.toLowerCase();
		g++;
		}
	}//end of ChooseOption()
	
	
	public static void ChatboxFrame() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setTitle("Brunel Chatbot");
		
		txtEnter.setLocation(2, 540);
		txtEnter.setSize(590, 30);
		frame.add(txtEnter);
		
		txtChat.setLocation(15, 5);;
		txtChat.setSize(560, 510);
		txtChat.setEnabled(false);
		txtChat.setLineWrap(true);
		txtChat.setWrapStyleWord(true);
		txtChat.append("Hi there, how may I help you? " + "\n");
		frame.add(txtChat);
	}//end of ChatboxFrame()
		
	public static void OptionSelected() {
		System.out.println("This is the key: " + key);
		if (key == "health") {HealthClass.Main();}
		if (key=="studies") {/*StudieClass.Main()*/}
		if (key=="finance") {FinanceClass.Main();}
	}//end of option selection
	
		
	public static void botSay(String s) {
		txtChat.append("Isambot: "+ s + "\n");
	}//end of botSay
	
	
	public static void trimming() {
		String txt = txtEnter.getText();
		if (txt.contains("'")) { //can add other symbole to trim off if needed here
			txt = txt.replace("'", "");
			txtEnter.setText(txt);
			//System.out.println("trimming method  : "+ txtEnter.getText());
		}
	}//end of trimming()
	
	
	
}//end of class bracket
