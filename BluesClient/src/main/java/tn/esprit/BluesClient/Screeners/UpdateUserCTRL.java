package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.CustomerServices;
import tn.esprit.Blues.Services.PortfolioServices;
import tn.esprit.Blues.entities.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UpdateUserCTRL implements Initializable, ControlledScreen {
	String User="Blues/CustomerServicesImpl!"+ CustomerServices.class.getCanonicalName();
	CustomerServices remote=(CustomerServices)ServiceLocator.getInstance().getProxy(User);
 
 
 @FXML
	TextField sname;
	@FXML
	TextField lname;
	@FXML
	TextField addrss;
	@FXML
	TextField nat;
	@FXML
	TextField jobb;
	@FXML
	TextField mail;
	@FXML
	TextField pass;
	@FXML
	TextField phonenum;
	@FXML private javafx.scene.control.Button closeButton;
	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Customer c=remote.findById(userCTRL.id12);
		
			
			
		sname.setText(c.getFirstName());
		lname.setText(c.getLastName());
		addrss.setText(c.getAddress());
		nat.setText(c.getNationality());
		jobb.setText(c.getJob());
		mail.setText(c.getEmail());
		pass.setText(c.getPassword());
		phonenum.setText(Integer.toString(c.getPhoneNumber()));
		
		
	}

		
		public void doUpdateCustomer() {
			
			Customer c=remote.findById(userCTRL.id12);
			c.setFirstName(sname.getText());
			c.setLastName(lname.getText());
			c.setAddress(addrss.getText());
			c.setNationality(nat.getText());
			c.setJob(jobb.getText());
			c.setEmail(mail.getText());
			c.setPassword(pass.getText());
			c.setPhoneNumber(Integer.parseInt(phonenum.getText()));
			
			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Successful ", "Update",
					JOptionPane.INFORMATION_MESSAGE);
			
		    remote.update(c);
			Stage stage = (Stage) closeButton.getScene().getWindow();
			 stage.close();
			


			}

}
	

