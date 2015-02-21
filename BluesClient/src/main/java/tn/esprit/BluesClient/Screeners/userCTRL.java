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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.CustomerServices;
import tn.esprit.Blues.Services.PortfolioServices;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class userCTRL implements Initializable, ControlledScreen {

	ScreensController myController;
	Sound s = new Sound();

	CustomerServices remote;
	PortfolioServices remoteP;

	public static Integer id12;
	/*********************** Les images de la barre Menu ***********************/
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
	/**************** Les champs texte de la barre Add ***************/
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
	/************************* Les differents bouttons ******************************************/
	Button add;
	@FXML
	Button update;
	@FXML
	Button delete;
	@FXML
	Button addBonus;
	/************************ Les champs texte du Personal Details ******************************/
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
	/**************************** Les champs texte du Portfolio Details ***************************/
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

	/**************************** Les Columns du tableau d'affichage *************************/
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

	/**********************************************************************/
	ObservableList<Customer> data = FXCollections.observableArrayList(this
			.getContext().findAll());

	/**********************************************************************/
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

	/****************************************************************************/
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

	/**************************************************************************/
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

	/*********************** Fenetre de l'update d'un user ****************************/
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

	/************************ L'animation des images de la barre Menu ***************************/
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

	/****************** Le mapping entre les differentes fenetres *************************/
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

	/***************** Instansiation d'un customer *************************/
	Customer c = new Customer();

	/***************** La methode d'ajout d'un user ************************/
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
					JOptionPane.INFORMATION_MESSAGE);
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
			p.setCustomer(c);
			this.getContext().add(c, p);
			data = FXCollections.observableArrayList(this.getContext()
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

	/******************** Méthode retourne un entier *******************/
	public boolean isInteger(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
	
	/******************** Méthode retourne un float *******************/
	public boolean isFloat(String chaine) {
		try {
			Float.parseFloat(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/********************** Méthode de al récupération d'un fichier ******************************/
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

	/*********************** Méthode de l'affichage dans un tableau **************************/
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

		File file1 = new File(c1.getProfilePicture());
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file1);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);

			pic.setImage(image);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/******************** Méthode de la suppression d'un user ***************************/
	public void doDeleteCustomer() {

		Customer c = this.getContext().findById(id12);

		this.getContext().remove(c);
		data = FXCollections.observableArrayList(this.getContext().findAll());
		tab.setItems(data);
	}

	/************************* Méthode de l'ajout d'un Bonus ****************************/
	public void doAddBonus() {
		Portfolio p = this.getContext().findById(id12).getPortfolio();

		if (bonus.getText().isEmpty() || !isFloat(bonus.getText())) {

			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Field empty or not Float ", "ERROR",
					JOptionPane.INFORMATION_MESSAGE);
		} 
		
		else {
			p.setValue(p.getValue() + Float.parseFloat(bonus.getText()));
			this.getContextP().updatePortfolio(p);
			pvalue.setText(p.getValue() + "");
			data = FXCollections.observableArrayList(this.getContext()
					.findAll());
			tab.setItems(data);
			bonus.clear();
		}

	}

}
