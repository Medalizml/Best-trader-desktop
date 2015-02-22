package tn.esprit.BluesClient.Screeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.CustomerServices;
import tn.esprit.Blues.Services.PortfolioServices;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class userCTRL implements Initializable, ControlledScreen {
	
	/*****************Declaration the ServiceLocator*******************/
	String User="Blues/CustomerServicesImpl!"+ CustomerServices.class.getCanonicalName();
	String Portfolio="Blues/PortfolioServicesImp!"+ PortfolioServices.class.getCanonicalName();
	CustomerServices remote=(CustomerServices)ServiceLocator.getInstance().getProxy(User);
	PortfolioServices remoteP=(PortfolioServices)ServiceLocator.getInstance().getProxy(Portfolio);
	
	ScreensController myController;
	Sound s = new Sound();

	

	public static Integer id12;
	/*********************** Declaration of the FXML component imageView ***********************/
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
	ImageView home;
	/**************** Declaration of the FXML textField references to the ADD ***************/
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
	PasswordField password;
	@FXML
	TextField phoneNumber;
	@FXML
	ImageView pic;
	@FXML
	TextField picture;
	@FXML
	/*************************  Declaration of the FXML button  ******************************************/
	Button add;
	@FXML
	Button update;
	@FXML
	Button delete;
	@FXML
	Button addBonus;
	/****************** Declaration of the FXML textFieald references to the PersonalDetails **********************/
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
	/*****************  Declaration of the FXML textField references to the PortfolioDetails ******************/
	@FXML
	TextField fpname;
	@FXML
	TextField pjob;
	@FXML
	TextField pvalue;
	@FXML
	TextField pshare;
	@FXML
	TextField bonus;

	/***********************  Declaration of the FXML tableColumns *************************/
	@FXML
	TableView<Customer> tab;
	@FXML
	TableColumn<Customer, Integer> id;
	@FXML
	TableColumn<Customer, String> Name;
	@FXML
	TableColumn<Customer, String> LastName;
	@FXML
	TableColumn<Customer, String> nationalitytab;
	@FXML
	TableColumn<Customer, String> jobtab;
	@FXML
	TableColumn<Customer, String> value;

	/**********Initializing the values of the JAVAFX component  ObservableList *******************/
	ObservableList<Customer> data = FXCollections.observableArrayList(
			remote.findAll());

	/**********************************************************************/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/**
		 *initialize method is specified to the controller of a fxml file this method is the first one to run 
		 * when we start the page interface in this the userCTRL this method will be charged of filling in 
		 * the values in the different TableCells witch are Customer and Portfolio	
		*/

		id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
		Name.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"firstName"));
		LastName.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"lastName"));
		nationalitytab
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"nationality"));
		value.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Customer, String> c) {
				return new SimpleStringProperty(Float.toString(c.getValue()
						.getPortfolio().getValue()));
			}
		});
		tab.setItems(data);
	}

	

	/*********************** The Update PopUp ****************************/
	/**
	 * Whene we click on the update button in the PersonalDetails this fonction displays a popup
	 * in wich we will find the different textField to update an user 
	 */
	public void popupUpdate() {

		FXMLLoader loader = new FXMLLoader(
				statsCTRL.class.getResource("../Screeners/UpdateUser.fxml"));
		try {

			Pane page = (Pane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Update");
			dialogStage.initModality(Modality.WINDOW_MODAL);

			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			dialogStage.setHeight(588);
			dialogStage.setWidth(635);
			dialogStage.setResizable(false);
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/************************ Animation's fonctions ***************************/
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

	/****************** Windows Mapping *************************/
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private void goToScreen2() {
		myController.setScreen(ScreensFramework.screen2ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen3() {
		myController.setScreen(ScreensFramework.screen3ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen4() {
		myController.setScreen(ScreensFramework.screen4ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen5() {
		myController.setScreen(ScreensFramework.screen5ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen7() {
		myController.setScreen(ScreensFramework.screen7ID);
		s.playSomeSound();
	}

	@FXML
	private void Close() {
		ScreensFramework.s.hide();
	}

	/*****************  Customer Instansiation  *************************/
	Customer c = new Customer();

	/***************** Implementation of the Add Method ************************/
	/**
	 * when we click on the add button a test is launched : if there is empty
	 * fields or the PhoneNumber field is not an INTEGER an error window will appear else we recuperate the fields' text , 
	 * we initialize also the portfolioValue and the shares number for each portfolio relited to an user. 
	 * then add the user in the database through the remote service with a successful message.
	 * Finally we refresh the Observablelist of the users to add this new user on the table.
	 */
	public void doAddCustomer() {

		Portfolio p = new Portfolio();

		if (firstName.getText().isEmpty() || lastName.getText().isEmpty()
				|| address.getText().isEmpty()
				|| nationality.getText().isEmpty() || job.getText().isEmpty()
				|| email.getText().isEmpty() || password.getText().isEmpty()
				|| phoneNumber.getText().isEmpty() || !isInteger(phoneNumber.getText())) {
			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Field empty or Phone Number Field is not Integer ", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		 else {
			c.setFirstName(firstName.getText());
			c.setLastName(lastName.getText());
			c.setAddress(address.getText());
			c.setNationality(nationality.getText());
			c.setJob(job.getText());
			c.setEmail(email.getText());
			c.setPassword(password.getText());
			c.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));

			p.setValue(10000);
			p.setSharesNumber(0);
			p.setGain(0);
			p.setCustomer(c);
			remote.add(c, p);
			data = FXCollections.observableArrayList(remote
					.findAll());
			tab.setItems(data);

			firstName.clear();
			lastName.clear();
			address.clear();
			nationality.clear();
			job.clear();
			email.clear();
			password.clear();
			phoneNumber.clear();

			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Successful ", "Add",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**************** Method wich test if a string is an integer or not  *******************/
	public boolean isInteger(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
	
	/******************** Method wich test if a string is a float or not  *******************/
	public boolean isFloat(String chaine) {
		try {
			Float.parseFloat(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/********************** File method ******************************/
	FileChooser fileChooser;
	File file;

	public void openfile(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser = new FileChooser();

		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		c.setProfilePicture(file.getPath());

	}

	/*********************** Details display **************************/
	/**
	 * when we click on a user from the table this function get his index
	 * and get his id from the observable list, then we recuperate the user and the portfolio relited to this user
	 * from the database through the remote service "findById" so the field's and image
	 * will be filled by its informations
	 */
	public void AfficheDetails() {

		Customer c = new Customer();
		Customer c1 = new Customer();

		c = data.get(tab.getSelectionModel().getSelectedIndex());

		c1 = remote.findById(c.getId());

		sname.setText(c1.getFirstName());
		lname.setText(c1.getLastName());
		addrss.setText(c1.getAddress());
		nat.setText(c1.getNationality());
		jobb.setText(c1.getJob());
		mail.setText(c1.getEmail());
		pass.setText(c1.getPassword());
		phonenum.setText(Integer.toString(c1.getPhoneNumber()));

		id12 = c1.getId();

		fpname.setText(c1.getFirstName());
		pjob.setText(c1.getJob());
		pvalue.setText(Float.toString(c1.getPortfolio().getValue()));
		pshare.setText(Float.toString(c1.getPortfolio().getSharesNumber()));

		update.setDisable(false);
		delete.setDisable(false);

		File file1 = new File(c1.getProfilePicture());
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file1);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);

			pic.setImage(image);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		data = FXCollections.observableArrayList(remote
				.findAll());
		tab.setItems(data);

	}

	/******************** Delete Method ***************************/
	/**
	 * when we click on the delete button a confirmDialog will be apper ,if we click yes ,
	 * we recuperate the user's id and delete it through the remote service "remove"
	 * and finally we refesh the users' list to remove the deleted user from the tableView
	 */
	public void doDeleteCustomer() {

		Customer c = remote.findById(id12);
		if(JOptionPane.showConfirmDialog(new JFrame(),"Do you want to delete this user ?", "Delete",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
		remote.remove(c);
		data = FXCollections.observableArrayList(remote.findAll());
		tab.setItems(data);
		}
	}

	/************************* Add Bonus method ****************************/
	/**
	 * when we click on the + button a test is launched : if there is empty
	 * field or the bonus field is not a float an error window will appear else we recuperate the field's text ,  
	 * then add the bonus to the portfoliovalue in the database through the remote service.
	 * Finally we refresh the value textfield and the Observablelist of the user to add this new portfolioValue on the table.
	 * 
	 */
	public void doAddBonus() {
		Portfolio p = remote.findById(id12).getPortfolio();

		if (bonus.getText().isEmpty() || !isFloat(bonus.getText())) {

			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Field empty or not Float ", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		} 
		
		else {
			p.setValue(p.getValue() + Float.parseFloat(bonus.getText()));
			remoteP.updatePortfolio(p);
			pvalue.setText(p.getValue() + "");
			data = FXCollections.observableArrayList(remote
					.findAll());
			tab.setItems(data);
			bonus.clear();
		}

	}

}
