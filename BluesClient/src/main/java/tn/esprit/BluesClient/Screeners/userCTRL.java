package tn.esprit.BluesClient.Screeners;

import java.awt.Dialog;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.print.attribute.standard.MediaSize.Engineering;
import javax.swing.JOptionPane;

import com.sun.mail.iap.ParsingException;

import tn.esprit.Blues.Services.CustomerServices;
import tn.esprit.Blues.Services.PortfolioServices;
import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class userCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	Sound s = new Sound();

	CustomerServices remote;
	PortfolioServices remoteP;
	public static Integer id12;
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
	TextField picture;
	@FXML
	Button add;
	@FXML
	Button update;
	@FXML
	Button delete;

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
	@FXML
	TextField fpname;
	@FXML
	TextField pjob;
	@FXML
	TextField pvalue;
	@FXML
	TextField pshare;
	@FXML
	ImageView pic;

	@FXML
	TableView<Customer> tab;
	// @FXML
	// TableView<Portfolio> tab1;
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

	ObservableList<Customer> data = FXCollections.observableArrayList(this
			.getContext().findAll());

	// ObservableList<Portfolio> data1 =
	// FXCollections.observableArrayList(this.getContextP().findAllP());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
		Name.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"firstName"));
		LastName.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"lastName"));
		nationalitytab
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"nationality"));
		// jobtab.setCellValueFactory(new
		// PropertyValueFactory<Customer,String>("job"));

		value.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Customer, String> c) {
				return new SimpleStringProperty(Float.toString(c.getValue()
						.getPortfolio().getValue()));
			}
		});

		// value.setCellValueFactory(new PropertyValueFactory<Portfolio,
		// Float>("capital"));

		tab.setItems(data);

	}

	public void affiche() {

	}

	public CustomerServices getContext() {
		try {
			Context context = new InitialContext();
			remote = (CustomerServices) context
					.lookup("Blues/CustomerServicesImpl!"
							+ CustomerServices.class.getCanonicalName());
			return remote;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remote;
		}

	}
	
	public PortfolioServices getContextP() {
		try {
			Context context = new InitialContext();
			remoteP = (PortfolioServices) context
					.lookup("Blues/PortfolioServicesImp!"
							+ PortfolioServices.class.getCanonicalName());
			return remoteP;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remoteP;
		}

	}

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

	public void doAddCustomer() {
		Customer c = new Customer();
		Portfolio p= new Portfolio();
		c.setFirstName(firstName.getText());
		c.setLastName(lastName.getText());
		c.setAddress(address.getText());
		c.setNationality(nationality.getText());
		c.setJob(job.getText());
		c.setEmail(email.getText());
		c.setPassword(password.getText());
		c.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
		c.setProfilePicture(picture.getText());
		p.setValue(10000);
		p.setSharesNumber(0);
		p.setCustomer(c);
		this.getContext().add(c,p);
		data = FXCollections.observableArrayList(this.getContext().findAll());
		tab.setItems(data);
		JOptionPane jp = new JOptionPane();
		jp.showMessageDialog(null, "Ajout Réussi", "Message d'erreur",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void AfficheDetails() {
		
		Customer c = new Customer();
		Customer c1 = new Customer();
		
		c = data.get(tab.getSelectionModel().getSelectedIndex());

		c1 = this.getContext().findById(c.getId());

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

	}

	public void doDeleteCustomer() {

		Customer c = this.getContext().findById(id12);

		this.getContext().remove(c);
		data = FXCollections.observableArrayList(this.getContext().findAll());
		tab.setItems(data);
	}
	
	@FXML
	TextField bonus;
	@FXML
	Button addBonus;
	
	
	public void doAddBonus()
	{
		Portfolio p = this.getContext().findById(id12).getPortfolio();
		p.setValue(p.getValue() + Float.parseFloat(bonus.getText()));
		this.getContextP().updatePortfolio(p);
		pvalue.setText(p.getValue()+"");
		data = FXCollections.observableArrayList(this.getContext().findAll());
		tab.setItems(data);
		
	}

}
