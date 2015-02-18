package tn.esprit.BluesClient.Screeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;




import tn.esprit.Blues.Services.BankShareServices;
import tn.esprit.Blues.Services.CompanyShareService;
import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Sector;
import tn.esprit.Blues.entities.Share;
import tn.esprit.BluesClient.Main.ScreensFramework;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class companyCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
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
	AnchorPane dynamicPane;
	@FXML
	Tab PrivateCompanyList;
	@FXML
	Tab PublicCompanyList;
	@FXML
	Tab BankList;
	FileChooser fileChooser;
	File file;
	
	

	
	
	
	@FXML
	Pane CompanyPane;
	
	@FXML
	ImageView home;
	//*****************start form add company  public *********************
	@FXML
	Button addCompanyPublicB;
	@FXML
	TextField namePublicCompany;
	@FXML
	DatePicker DatePublicCompany;
	@FXML
	TextField CodePublicCompany;
	@FXML
	TextField headPublicCompany;
	@FXML
	TextField PhonePublicCompany;
	@FXML
	TextField socialPublicCompany;
	@FXML
	ChoiceBox<Sector> SectorPublicCompany;
	@FXML
	ImageView logoPublic;
	@FXML
	Button openButtonPublic;
	static Company publicCompany =new Company();
	static Bond bond=new Bond();
	
	
	//*****************end form add company public*******************
	//*****************start form add company  private *********************
	@FXML
	Button addCompanyPrivateB;
	@FXML
	TextField namePrivateCompany;
	@FXML
	DatePicker DatePrivateCompany;
	@FXML
	TextField CodePrivateCompany;
	@FXML	
	TextField headPrivateCompany;
	@FXML
	TextField PhonePrivateCompany;
	@FXML
	TextField socialPrivateCompany;
	@FXML
	ChoiceBox<Sector> SectorPrivateCompany;
	@FXML
	ImageView logoPrivate;
	@FXML
	Button openButtonPrivate;
	@FXML
	TextField nbSahre;
	@FXML
	TextField shareValue;
	
	
	static Company privateCompany =new Company();
	static Share privateShare=new Share();
	
	
	//*****************end form add company private*******************
	//*****************start form add Bank *********************
		@FXML
		Button addBankB;
		@FXML
		TextField nameBank;
		@FXML
		DatePicker DateBank;
		@FXML
		TextField CodeBank;
		@FXML
		TextField headBank;
		@FXML
		TextField PhoneBank;
		@FXML
		TextField socialBank;
		
		@FXML
		ImageView logoBank;
		@FXML
		Button openButtonBank;
		@FXML
		TextField bankNbSahre;
		@FXML
		TextField bankShareValue;
		
		static Bank bank =new Bank();
		static Share shareBank=new Share();
		
		
		//*****************end form add Bank*******************
	CompanyShareService remoteCompanyService;
	BankShareServices remoteBankServices;
	
	public CompanyShareService getCompanyContext() {
		try {
			Context context = new InitialContext();
			remoteCompanyService = (CompanyShareService) context
					.lookup("Blues/CompanyShareServicesImpl!tn.esprit.Blues.Services.CompanyShareService");
			return remoteCompanyService;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remoteCompanyService;
		}

	}
	public BankShareServices getBankContext() {
		try {
			Context context = new InitialContext();
			remoteBankServices = (BankShareServices) context
					.lookup("Blues/BankShareServicesImp!tn.esprit.Blues.Services.BankShareServices");
			return remoteBankServices;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remoteBankServices;
		}

	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	     
	           
	            
	        
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
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
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
	private void goToScreen6() {
		myController.setScreen(ScreensFramework.screen6ID);
	}

	@FXML
	private void goToScreen7() {
		myController.setScreen(ScreensFramework.screen7ID);
	}

	@FXML
	private void loadPrivateCompany() {

		try {

			dynamicPane.getChildren().setAll(
					FXMLLoader.load(getClass().getResource(
							"CompanyPrivateTabpane.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@FXML
	private void loadPublicCompany() {

		try {

			dynamicPane.getChildren().setAll(
					FXMLLoader.load(getClass().getResource(
							"CompanyPublicTabpane.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@FXML
	private void loadBank() {

		try {

			dynamicPane.getChildren()
					.setAll(FXMLLoader.load(getClass().getResource(
							"BankTabpane.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@FXML
	private void openfileChooserBank(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser=new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoBank.setImage(image);
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}
	@FXML
	private void openfileChooserPrivate(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser=new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoPrivate.setImage(image);
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}
	@FXML
	private void openfileChooserPublic(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser=new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoPublic.setImage(image);
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}
	@FXML
	public void addCompanyPublic(ActionEvent event){
		//c.setDateIncorporation(DatePublicCompany.get);
		System.out.println("add1");
		System.out.println(headPublicCompany.getText());
		publicCompany.setHeadOffice(headPublicCompany.getText());
		System.out.println("add2");
		publicCompany.setName(namePublicCompany.getText());
		System.out.println("add3");
		publicCompany.setNature("public");
		System.out.println("add3");
		publicCompany.setPhone(Integer.parseInt(PhonePublicCompany.getText()));
		System.out.println("add4");
		publicCompany.setSocialCapital(Float.parseFloat(socialPublicCompany.getText()));
		System.out.println("hhello");
		this.getCompanyContext().add(publicCompany);
		
		
		
		
	}
	@FXML
	public void addCompanyPrivate(ActionEvent event){
		//c.setDateIncorporation(DatePublicCompany.get);
		System.out.println("add1");
		System.out.println(headPrivateCompany.getText());
		privateCompany.setHeadOffice(headPrivateCompany.getText());
		System.out.println("add2");
		privateCompany.setName(namePrivateCompany.getText());
		System.out.println("add3");
		privateCompany.setNature("private");
		System.out.println("add3");
		privateCompany.setPhone(Integer.parseInt(PhonePrivateCompany.getText()));
		System.out.println("add4");
		privateCompany.setSocialCapital(Float.parseFloat(socialPrivateCompany.getText()));
		System.out.println("add5");
		privateCompany.setNbShares(Integer.parseInt(nbSahre.getText()));
		
		this.getCompanyContext().add(privateCompany);
		
		
		
		
	}
	@FXML
	public void addBankPrivate(ActionEvent event){
		//c.setDateIncorporation(DatePublicCompany.get);
		System.out.println("add1");
		System.out.println(headBank.getText());
		bank.setHeadOffice(headBank.getText());
		System.out.println("add2");
		bank.setName(nameBank.getText());
		System.out.println("add3");
		bank.setNature("Bank");
		System.out.println("add3");
		bank.setPhone(Integer.parseInt(PhoneBank.getText()));
		System.out.println("add4");
		bank.setSocialCapital(Float.parseFloat(socialBank.getText()));
		System.out.println("add5");
		bank.setNbShares(Integer.parseInt(bankNbSahre.getText()));
		shareBank.setCompany(bank);
		shareBank.setOpningPrice(Float.parseFloat(bankShareValue.getText()));
		
		this.getBankContext().add(bank,shareBank);
		
		
		
		
	}

	@FXML
	private void Close() {
		ScreensFramework.s.hide();
	}

}
