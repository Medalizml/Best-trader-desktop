package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.Blues.Services.CustomerServices;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.BluesClient.Main.ScreensFramework;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class userCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	
	  CustomerServices remote;
	
	

	@FXML
	ImageView user;
	@FXML
	ImageView article;
	@FXML
	ImageView company;
	@FXML
	ImageView profile;
	@FXML
	ImageView stats;
	@FXML
	ImageView logout;
	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	TextField address;
	@FXML
	TextField nationality;
	@FXML
	TextField job;
	@FXML
	TextField email;
	@FXML
	TextField password;
	@FXML
	TextField phoneNumber;
	@FXML
	TextField picture;
	@FXML
	Button add;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	
	public CustomerServices getContext(){
		try {
			Context context=new InitialContext();
			remote = (CustomerServices) context.lookup("Blues/CustomerServicesImpl!"+CustomerServices.class.getCanonicalName());
			return remote;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remote;
		}
		
		}

	@FXML
	ImageView home;

	public void zoomHome() {

		home.setScaleX(1.2);
		home.setScaleY(1.2);

	}

	public void zoomOutHome() {

		home.setScaleX(1.0);
		home.setScaleY(1.0);

	}

	public void zoomUser() {

		user.setScaleX(1.2);
		user.setScaleY(1.2);

	}

	public void zoomOutUser() {

		user.setScaleX(1.0);
		user.setScaleY(1.0);

	}

	public void zoomArticle() {

		article.setScaleX(1.2);
		article.setScaleY(1.2);

	}

	public void zoomOutArticle() {

		article.setScaleX(1.0);
		article.setScaleY(1.0);

	}

	public void zoomLogout() {

		logout.setScaleX(1.2);
		logout.setScaleY(1.2);

	}

	public void zoomOutLogout() {

		logout.setScaleX(1.0);
		logout.setScaleY(1.0);

	}

	public void zoomCompany() {

		company.setScaleX(1.2);
		company.setScaleY(1.2);

	}

	public void zoomOutCompany() {

		company.setScaleX(1.0);
		company.setScaleY(1.0);

	}

	public void zoomStats() {

		stats.setScaleX(1.2);
		stats.setScaleY(1.2);

	}

	public void zoomOutStats() {

		stats.setScaleX(1.0);
		stats.setScaleY(1.0);

	}

	public void zoomProfile() {

		profile.setScaleX(1.2);
		profile.setScaleY(1.2);

	}

	public void zoomOutProfile() {

		profile.setScaleX(1.0);
		profile.setScaleY(1.0);

	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private void goToScreen2() {
		myController.setScreen(ScreensFramework.screen2ID);
	}

	@FXML
	private void goToScreen3() {
		myController.setScreen(ScreensFramework.screen3ID);
	}

	@FXML
	private void goToScreen4() {
		myController.setScreen(ScreensFramework.screen4ID);
	}

	@FXML
	private void goToScreen5() {
		myController.setScreen(ScreensFramework.screen5ID);
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
	}

	@FXML
	private void goToScreen7() {
		myController.setScreen(ScreensFramework.screen7ID);
	}

	@FXML
	private void Close() {
		ScreensFramework.s.hide();
	}
	
	
	public  void doAddCustomer(){
		Customer c=new Customer();
		c.setFirstName(firstName.getText());
		c.setLastName(lastName.getText());
		c.setAddress(address.getText());
		c.setNationality(nationality.getText());
		c.setJob(job.getText());
		c.setEmail(email.getText());
		c.setPassword(password.getText());
		c.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
		c.setProfilePicture(picture.getText());
		this.getContext().add(c);
		}
}
