package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.ILoginRemote;
import tn.esprit.Blues.entities.Administrator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class loginCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	@FXML
	ImageView login;
	@FXML
	ImageView quit;
	@FXML
	TextField email;
	@FXML
	PasswordField password;
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	/**
	 * when typing your email and password this method verifies if you are an administrator or not 
	 * if you are it leads you to the home page of the application 
	 * if you are not it shows you a message asking you to verify your email and password
	 */
	
	@SuppressWarnings({ "unused", "static-access" })
	public void Authentification(){
			ILoginRemote loginRemote = (ILoginRemote)ServiceLocator.getInstance().getProxy("Blues/LoginService!"+ILoginRemote.class.getCanonicalName());
			System.out.println("Verifying...");
			//loginRemote.sayHello();
			String M=email.getText();
			String P=password.getText();
			Administrator a=null;
			try {
			a=loginRemote.authentification(M,P);}
			catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			if(a!=null)
			{goToScreen1();
			myController.setA(a);
			System.out.println(myController.getA().getId());
			email.setText("");
			password.setText("");
			}
			else{
				password.setText("");
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Verify your username and password", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("Fields checked");
		
	}
	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
	}
	
	@FXML
	private void Close() {
		if(JOptionPane.showConfirmDialog(new JFrame(),"Do you want to exit this application ?", "Title",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
		ScreensFramework.s.hide();}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	public void zoomLogin() {

		login.setScaleX(1.2);
		login.setScaleY(1.2);

	}

	public void zoomOutlogin() {

		login.setScaleX(1.0);
		login.setScaleY(1.0);

	}
	public void zoomQuit() {

		quit.setScaleX(1.2);
		quit.setScaleY(1.2);

	}

	public void zoomOutQuit() {

		quit.setScaleX(1.0);
		quit.setScaleY(1.0);

	}
	/**
	 * this method allows the user of the application to login when clicking on the enter-key
	 * @param e
	 */
	@FXML
	private void Enterkey(KeyEvent e){
		        if (e.getCode() == KeyCode.ENTER)  {
		        	this.Authentification();
		        }
		    }
	}
