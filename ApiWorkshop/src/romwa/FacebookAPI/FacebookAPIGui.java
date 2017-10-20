package romwa.FacebookAPI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FacebookAPIGui extends JFrame implements ActionListener{

	JButton auth;
	JLabel user;
	Container c;
	
	public FacebookAPIGui() {
		c = new Container();
		
		auth = new JButton("auth");
		auth.setBounds(200, 200, 100, 50);
		auth.addActionListener(this);
		
		user = new JLabel("Current Auth User: ");
		user.setBounds(150, 250, 200, 50);
		
		
		c.add(auth);
		c.add(user);
		add(c);
	}
	
	public void authUser() {
		System.out.println("authenticatoting user");
		String domain = "https://github.com/romwa";
		String appId = "1387718927993464";
		String authUrl = "";
	}
	
	public void setWindow() {
		setTitle("facebookAPI");
		setBounds(150, 150, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//window.setResizable(false);
		setVisible(false);
	}
	
	public void toggleWindow() {
		setVisible(!isVisible());
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b == auth) {
			authUser();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//---------------------------------------------------------------
	public static void main(String[] args) {
		FacebookAPIGui window = new FacebookAPIGui();
		FacebookAPI user = new FacebookAPI();
		System.out.println(user.getName());
		window.setWindow();
		window.toggleWindow();
	}

}
