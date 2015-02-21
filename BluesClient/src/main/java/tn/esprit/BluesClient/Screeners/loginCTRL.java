package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.ILoginRemote;
import tn.esprit.Blues.entities.Administrator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
	
	Context context;
	@SuppressWarnings("unused")
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
		ScreensFramework.s.hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
