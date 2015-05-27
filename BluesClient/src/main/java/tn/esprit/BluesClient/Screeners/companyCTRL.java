package tn.esprit.BluesClient.Screeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javafx.util.StringConverter;

import javax.imageio.ImageIO;
import javax.resource.spi.AuthenticationMechanism;

import tn.esprit.Blues.Services.BankShareServices;
import tn.esprit.Blues.Services.CompanyServices;
import tn.esprit.Blues.Services.CompanyShareService;
import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currency;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Sector;
import tn.esprit.Blues.entities.Share;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class companyCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	FileChooser fileChooser;
	File file;
	CompanyShareService remoteSector = (CompanyShareService) ServiceLocator
			.getInstance().getProxy(
					"Blues/CompanyShareServicesImpl!"
							+ CompanyShareService.class.getCanonicalName());
	@FXML
	TextField Ok = new TextField();

	// ******************************* start image view screen
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
	// ************************end image view screen

	// ************************ start handel tabs
	@FXML
	AnchorPane dynamicPane;
	@FXML
	Tab PrivateCompanyListTab;
	@FXML
	Tab PublicCompanyListTab;
	@FXML
	Tab BankListTab;
	// ****************************** end handel tabs***************************

	// *****************start form add company public *********************
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
	ComboBox<Sector> SectorPublicCompany;
	@FXML
	ImageView logoPublic;
	@FXML
	Button openButtonPublic;
	static Company publicCompany = new Company();
	static Bond bond = new Bond();

	// *****************end form add company public*******************

	// *****************start form add Bank *********************
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

	static Bank bank = new Bank();
	static Share shareBank = new Share();

	// *****************end form add Bank*******************
	// *****************start form add company private *********************
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
	ComboBox<Sector> SectorPrivateCompany; 
	@FXML
	ImageView logoPrivate;
	@FXML
	Button openButtonPrivate;
	@FXML
	TextField nbSahre;
	@FXML
	TextField shareValue;

	static Company privateCompany = new Company();
	static Share privateShare = new Share();

	// *****************end form add company private*******************

	// ******************************* start list
	// bank***************************
	@FXML
	private TableView<Bank> TableBank;
	@FXML
	private TableColumn<Bank, Integer> idTabBank;
	@FXML
	private TableColumn<Bank, String> nameTabBank;
	@FXML
	private TableColumn<Bank, Float> SocialTabbank;
	@FXML
	private TableColumn<Bank, Integer> nbSharesTabbank;
	@FXML
	private TableView<Currencybank> bclist;
	@FXML
	private TableColumn<Currencybank, String> blcurr;
	@FXML
	private TableColumn<Currencybank, String> blunity;
	@FXML
	private TableColumn<Currencybank, Float> blBP;
	@FXML
	private TableColumn<Currencybank, Float> blSP;
	BankShareServices remoteBank = (BankShareServices) ServiceLocator
			.getInstance().getProxy(
					"Blues/BankShareServicesImp!"
							+ BankShareServices.class.getCanonicalName());
	ObservableList<Bank> banklist = FXCollections
			.observableArrayList(remoteBank.findAll());

	// ***********************************end list
	// bank*********************************
	// **********************************start public
	// list******************************
	@FXML
	private TableView<Company> TablePublic;
	@FXML
	private TableColumn<Company, Integer> idTabPublic;
	@FXML
	private TableColumn<Company, String> nameTabPublic;
	@FXML
	private TableColumn<Company, String> SectorTabPublic;
	@FXML
	private TableColumn<Company, String> SharesValueTabPublic;
	CompanyShareService remotePublic = (CompanyShareService) ServiceLocator
			.getInstance().getProxy(
					"Blues/CompanyShareServicesImpl!"
							+ CompanyShareService.class.getCanonicalName());
	ObservableList<Company> publicList = FXCollections
			.observableArrayList(remotePublic.findAllPublic());
	// **********************************end public list
	// *******************************
	// **************************************start private list
	// **************************
	@FXML
	private TableView<Company> TablePrivate;
	@FXML
	private TableColumn<Company, Integer> idTabPrivate;
	@FXML
	private TableColumn<Company, String> nameTabPrivate;
	@FXML
	private TableColumn<Company, String> SectorTabPrivate;
	@FXML
	private TableColumn<Company, String> SharesValueTabPrivate;
	CompanyShareService remotePrivate = (CompanyShareService) ServiceLocator
			.getInstance().getProxy(
					"Blues/CompanyShareServicesImpl!"
							+ CompanyShareService.class.getCanonicalName());
	ObservableList<Company> privateList = FXCollections
			.observableArrayList(remotePrivate.findAllPrivate());
	@FXML
	Button updatePublicCompany;
	

	// **********************************end private list
	// *******************************
	// ******************************** start update bank fields
	// *****************

	@FXML
	TextField CmpanyNameUpdateB = new TextField();
	@FXML
	TextField dateofIncorUpdateB;
	@FXML
	TextField codeSticoUpdateB;
	@FXML
	TextField headOfficeUpdateB;
	@FXML
	TextField PhoneNumberUpdateB;
	@FXML
	TextField SocialCapitalUpdateB;
	@FXML
	TextField NumberShareUpdateB;
	@FXML
	TextField shareValueUpdateB;
	@FXML
	TextField QuotedShareUpdateB;
	@FXML
	TextField noQuotedShareUpdateB;
	@FXML
	TextField ShareHeighPriceUpdateB;
	@FXML
	TextField SharelowPriceUpdateB;
	@FXML
	TextField ClosinfPriceUpdateB;
	@FXML
	TextField opningPriceUpdateB;
	static Bank bank1 = new Bank();
	@FXML
	Button updatebank;
	// ******************************** end update bank
	// fields********************
	// *********************************start Private update
	// fields*******************

	@FXML
	TextField CmpanyNameUpdatePr = new TextField();
	@FXML
	TextField dateofIncorUpdatePr;
	@FXML
	TextField codeSticoUpdatePr;
	@FXML
	TextField headOfficeUpdatePr;
	@FXML
	TextField PhoneNumberUpdatePr;
	@FXML
	TextField SocialCapitalUpdatePr;
	@FXML
	TextField NumberShareUpdatePr;
	@FXML
	TextField shareValueUpdatePr;
	@FXML
	TextField QuotedShareUpdatePr;
	@FXML
	TextField noQuotedShareUpdatePr;
	@FXML
	TextField ShareHeighPriceUpdatePr;
	@FXML
	TextField SharelowPriceUpdatePr;
	@FXML
	TextField ClosinfPriceUpdatePr;
	@FXML
	TextField opningPriceUpdatePr;
	Company privateCompany1 = new Company();
	@FXML
	Button updatePrivateCompany;
	// *********************************end Private update
	// Fields***********************
	// *********************************start Public update
	// fields*******************

	@FXML
	TextField CmpanyNameUpdatePu;
	@FXML
	TextField dateofIncorUpdatePu;
	@FXML
	TextField codeSticoUpdatePu;
	@FXML
	TextField headOfficeUpdatePu;
	@FXML
	TextField PhoneNumberUpdatePu;
	@FXML
	TextField SocialCapitalUpdatePu;
	@FXML
	TextField NumberShareUpdatePu;
	@FXML
	TextField shareValueUpdatePu;
	@FXML
	TextField QuotedShareUpdatePu;
	@FXML
	TextField noQuotedShareUpdatePu;
	@FXML
	TextField ShareHeighPriceUpdatePu;
	@FXML
	TextField SharelowPriceUpdatePu;
	@FXML
	TextField ClosinfPriceUpdatePu;
	@FXML
	TextField opningPriceUpdatePu;
	Company publicCompany1=new Company(); 
	@FXML 
	Button removePublic;
	// *********************************end Public update
	// Fields***********************
	//************************  start bond add -update*********************
	@FXML
	TextField bopning ;
	@FXML
	TextField bclosing;
	@FXML
	TextField bhprice;
	@FXML
	TextField blprice;
	@FXML
	TextField bnvalue;
	@FXML
	TextField bevalue;
	@FXML
	TextField brvalue;
	@FXML
	TextField bnrate;
	@FXML
	DatePicker bodate;
	@FXML
	DatePicker bcdate;
	@FXML
	Button bupdate;
	//*************************end  bond add -update *********************
	//************************** start currency add************************
	@FXML
	TextField CurrencyName;
	Currency currency=new Currency();
	Currencybank currencybank=new Currencybank();
	@FXML
	TextField unityCurrency;
	@FXML
	Button addCurrency;
	@FXML
	TextField sellPriceadd;
	@FXML
	TextField buyPriceadd;
	@FXML
	TextField buyPriceEdit;
	@FXML
	TextField SellPriceEdit;
	@FXML
	Button updateCurrency;
	 static Currency currency1=new Currency();
	static Currencybank currencybank1=new Currencybank();
	 ObservableList<Currencybank> currencylist = FXCollections
			.observableArrayList(remotePrivate.findBybank(bank1.getId()));
	 @FXML
	    ImageView detailPicturePrivate;
	 @FXML
	 ImageView detailPicturePublic;
	 @FXML
	 ImageView detailPictureBank;
	//****************************end  currency add*****************************
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.remplirTabPrivate();
		this.remplirTabBank();
		this.remplirTabPublic();
		SectorPrivateCompany.setItems((FXCollections.observableArrayList(remoteSector.findAllSector())));
		SectorPrivateCompany.setCellFactory((comboBox) -> {
		    return new ListCell<Sector>() {
		        @Override
		        protected void updateItem(Sector item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		                System.out.println("nullsector");
		            } else {
		                setText(item.getName());
		                System.out.println(item.getName());
		            }
		        }
		    };
		});
		SectorPrivateCompany.setConverter(new StringConverter<Sector>() {
			

			@Override
			public Sector fromString(String string) {
				// TODO Auto-generated method stub
				
				return null;

			}

			@Override
			public String toString(Sector object) {
				// TODO Auto-generated method stub
				if (object == null) {
					
					return "choose Sector";

				} else {
					
					return object.getName();
				}

			}
		});
		SectorPrivateCompany.setItems((FXCollections.observableArrayList(remoteSector.findAllSector())));
		SectorPrivateCompany.getSelectionModel().select(0);
		//System.out.println(SectorPrivateCompany.getItems()+"1235");
		System.out.println(SectorPrivateCompany.getSelectionModel().getSelectedItem().getId()+"iciiiiiii");
		SectorPrivateCompany.setItems((FXCollections.observableArrayList(remoteSector.findAllSector())));
		SectorPrivateCompany.setCellFactory((comboBox) -> {
		    return new ListCell<Sector>() {
		        @Override
		        protected void updateItem(Sector item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		                System.out.println("nullsector");
		            } else {
		                setText(item.getName());
		                System.out.println(item.getName());
		            }
		        }
		    };
		});
		SectorPublicCompany.setConverter(new StringConverter<Sector>() {
			

			@Override
			public Sector fromString(String string) {
				// TODO Auto-generated method stub
				
				return null;

			}

			@Override
			public String toString(Sector object) {
				// TODO Auto-generated method stub
				if (object == null) {
					
					return "choose Sector";

				} else {
					
					return object.getName();
				}

			}
		});
		SectorPublicCompany.setItems((FXCollections.observableArrayList(remoteSector.findAllSector())));
		SectorPublicCompany.getSelectionModel().select(0);
		//System.out.println(SectorPrivateCompany.getItems()+"1235");
		System.out.println(SectorPublicCompany.getSelectionModel().getSelectedItem().getId()+"iciiiiiii2");
		
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

	/**
	 * @author Maleck
	 * 
	 */
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

	

	

	

	// *************************start methods of public company
	// ******************************************
	@SuppressWarnings("deprecation")
	@FXML
	public void addCompanyPublic(ActionEvent event) {
		// c.setDateIncorporation(DatePublicCompany.get);
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
		publicCompany.setSocialCapital(Float.parseFloat(socialPublicCompany
				.getText()));
		Integer year = DatePublicCompany.getValue().getYear();
		Integer month = DatePublicCompany.getValue().getMonthValue();
		Integer day = DatePublicCompany.getValue().getDayOfMonth();
		java.sql.Date date = new java.sql.Date(year - 1900, month - 1, day);
		publicCompany.setDateIncorporation(date);
		publicCompany.setSector(SectorPublicCompany.getSelectionModel().getSelectedItem());
		System.out.println("hhello");
		CompanyServices remote = (CompanyServices) ServiceLocator.getInstance()
				.getProxy(
						"Blues/CompanyServicesImpl!"
								+ CompanyServices.class.getCanonicalName());
		remote.add(publicCompany);
		publicList = FXCollections
				.observableArrayList(remotePublic.findAllPublic());
		this.remplirTabPublic();

	}

	@FXML
	private void openfileChooserPublic(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoPublic.setImage(image);
			publicCompany.setLogo(file.getPath());
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}

	void remplirTabPublic() {

		idTabPublic
				.setCellValueFactory(new PropertyValueFactory<Company, Integer>(
						"id"));
		nameTabPublic
				.setCellValueFactory(new PropertyValueFactory<Company, String>(
						"name"));

		SectorTabPublic
				.setCellValueFactory(new Callback<CellDataFeatures<Company, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Company, String> c) {
						return new SimpleStringProperty(c.getValue()
								.getSector().getName());
					}
				});

		SharesValueTabPublic
				.setCellValueFactory(new Callback<CellDataFeatures<Company, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Company, String> c) {
						if (c.getValue().getQuotation() != null) {
							return new SimpleStringProperty(Float
									.toString(c.getValue().getQuotation()
											.getOpningPrice()));
						} else {
							return new SimpleStringProperty(
									"this company has no bond");

						}
					}
				});

		TablePublic.setItems(publicList);

	}

	// *****************************************************end methods of
	// public Company**************************

	// ************************ start methods of bank
	// ***********************************
	@SuppressWarnings("deprecation")
	@FXML
	public void addBankPrivate(ActionEvent event) {
		// c.setDateIncorporation(DatePublicCompany.get);
		System.out.println("add1");
		System.out.println(headBank.getText());
		
		bank.setHeadOffice(headBank.getText());
		System.out.println("add2");
		bank.setName(nameBank.getText());
		System.out.println("add3");
		bank.setNature("Bank");
		System.out.println("add3");
		if(this.isFloat(PhoneBank.getText())){
		bank.setPhone(Integer.parseInt(PhoneBank.getText()));}
		System.out.println("add4");
		if(this.isFloat(socialBank.getText())){
		bank.setSocialCapital(Float.parseFloat(socialBank.getText()));}
		System.out.println("add5");
		if(this.isFloat(bankNbSahre.getText())){
		bank.setNbShares(Integer.parseInt(bankNbSahre.getText()));}
		
		Integer year = DateBank.getValue().getYear();
		Integer month = DateBank.getValue().getMonthValue();
		Integer day = DateBank.getValue().getDayOfMonth();
		java.sql.Date date = new java.sql.Date(year - 1900, month - 1, day);
		bank.setDateIncorporation(date);
		shareBank.setCompany(bank);
		shareBank.setOpningPrice(Float.parseFloat(bankShareValue.getText()));
		System.out.println(shareBank);
		System.out.println(bank);
		

		BankShareServices remote = (BankShareServices) ServiceLocator
				.getInstance().getProxy(
						"Blues/BankShareServicesImp!"
								+ BankShareServices.class.getCanonicalName());
		remote.add(bank, shareBank);
		banklist = FXCollections
				.observableArrayList(remoteBank.findAll());
		this.remplirTabBank();

	}

	@FXML
	private void openfileChooserBank(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoBank.setImage(image);
			bank.setLogo(file.getPath());
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}

	void remplirTabBank() {

		idTabBank.setCellValueFactory(new PropertyValueFactory<Bank, Integer>(
				"id"));
		nameTabBank.setCellValueFactory(new PropertyValueFactory<Bank, String>(
				"name"));

		SocialTabbank
				.setCellValueFactory(new PropertyValueFactory<Bank, Float>(
						"socialCapital"));

		nbSharesTabbank
				.setCellValueFactory(new PropertyValueFactory<Bank, Integer>(
						"nbShares"));

		TableBank.setItems(banklist);

	}
	@FXML
	private void remplirListCurr(){
		ObservableList<Currencybank> currencylist = FXCollections
				.observableArrayList(remotePrivate.findBybank(bank1.getId()));
		blcurr.setCellValueFactory(new Callback<CellDataFeatures<Currencybank, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Currencybank, String> c) {
				return new SimpleStringProperty(c.getValue().getCurrency().getName());
			}
		});
		
		blunity.setCellValueFactory(new Callback<CellDataFeatures<Currencybank, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Currencybank, String> c) {
				return new SimpleStringProperty(Integer.toString(c.getValue().getCurrency().getUnity()));
			}
		});
		blBP
		.setCellValueFactory(new PropertyValueFactory<Currencybank,Float>(
				"buyPrice"));
		blSP
		.setCellValueFactory(new PropertyValueFactory<Currencybank,Float>(
				"sellPrice"));
		System.out.println("iciiiiiiiiiiiiiiiii");
		bclist.setItems(currencylist);
		System.out.println("iciiiiiiiiiiiiiiiii");
	}

	
	  @FXML 
	  public void addCurrency(ActionEvent event){
	  
	        System.out.println("add1");
	        System.out.println(CurrencyName.getText());
	        currency.setName(CurrencyName.getText());
	        System.out.println("add2");
	        currency.setUnity(Integer.parseInt(unityCurrency.getText()));
	        currencybank.setBank(bank1); 
	        currencybank.setSellPrice(Float.parseFloat(sellPriceadd.getText()));
	        currencybank.setBuyPrice(Float.parseFloat(buyPriceadd.getText()));
	        currencybank.setCurrency(currency);
	  
	  
	        remoteBank.addCurrency(currency,currencybank);
	        this.remplirListCurr();
	  
	  
	  
	  
	        }
	  @FXML
	  public void getCurrency(){
		  ObservableList<Currencybank> currencylist = FXCollections
					.observableArrayList(remotePrivate.findBybank(bank1.getId()));
		  System.out.println("hello5");
		  System.out.println(bclist.getSelectionModel().getSelectedIndex()+"hhhhhh");
		  currencybank1= currencylist.get(bclist.getSelectionModel().getSelectedIndex());
		  SellPriceEdit.setText(currencybank1.getSellPrice()+"");
		 buyPriceEdit.setText(currencybank1.getBuyPrice()+"");
		  
		  
	  }
	  @FXML
	  public void editPriceCurrency(){
		  
		 currencybank1.setBuyPrice(Float.parseFloat(buyPriceEdit.getText()));
		 currencybank1.setSellPrice(Float.parseFloat(SellPriceEdit.getText()));	 
		 remoteBank.editCurrency(currencybank1);
		 this.remplirListCurr();
		  
	  }
	 

	// ************************end methods of
	// bank************************************

	// ************************start methods of private************************
	@FXML
	private void openfileChooserPrivate(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		System.out.println("hello11");
		try {
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			logoPrivate.setImage(image);
			privateCompany.setLogo(file.getPath());
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}

	@SuppressWarnings("deprecation")
	@FXML
	public void addCompanyPrivate(ActionEvent event) {
		// c.setDateIncorporation(DatePublicCompany.get);
		System.out.println("add1");
		System.out.println(headPrivateCompany.getText());
		privateCompany.setHeadOffice(headPrivateCompany.getText());
		System.out.println("add2");
		privateCompany.setName(namePrivateCompany.getText());
		System.out.println("add3");
		privateCompany.setNature("private");
		System.out.println("add3");
		
		if(this.isFloat(PhonePrivateCompany.getText())){privateCompany
				.setPhone(Integer.parseInt(PhonePrivateCompany.getText()));}
		System.out.println("add4");
		if(this.isFloat(socialPrivateCompany.getText())){
		privateCompany.setSocialCapital(Float.parseFloat(socialPrivateCompany
				.getText()));}
		System.out.println("add5");
		if(this.isFloat(nbSahre.getText())){
		privateCompany.setNbShares(Integer.parseInt(nbSahre.getText()));}
		Integer year = DatePrivateCompany.getValue().getYear();
		Integer month = DatePrivateCompany.getValue().getMonthValue();
		Integer day = DatePrivateCompany.getValue().getDayOfMonth();
		java.sql.Date date = new java.sql.Date(year - 1900, month - 1, day);
		privateCompany.setDateIncorporation(date);
		privateShare.setCompany(privateCompany);
		privateShare.setOpningPrice(Float.parseFloat(shareValue.getText()));
		privateCompany.setSector(SectorPrivateCompany.getSelectionModel().getSelectedItem());

		CompanyShareService remote = (CompanyShareService) ServiceLocator
				.getInstance().getProxy(
						"Blues/CompanyShareServicesImpl!"
								+ CompanyShareService.class.getCanonicalName());
		remote.add(privateCompany, privateShare);
		 privateList = FXCollections
				.observableArrayList(remotePrivate.findAllPrivate());
		this.remplirTabPrivate();

	}

	void remplirTabPrivate() {

		idTabPrivate
				.setCellValueFactory(new PropertyValueFactory<Company, Integer>(
						"id"));
		nameTabPrivate
				.setCellValueFactory(new PropertyValueFactory<Company, String>(
						"name"));

		SectorTabPrivate
				.setCellValueFactory(new Callback<CellDataFeatures<Company, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Company, String> c) {
						return new SimpleStringProperty(c.getValue()
								.getSector().getName());
					}
				});

		SharesValueTabPrivate
				.setCellValueFactory(new Callback<CellDataFeatures<Company, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Company, String> c) {
						if (c.getValue().getQuotation() != null) {
							return new SimpleStringProperty(Float
									.toString(c.getValue().getQuotation()
											.getOpningPrice()));
						} else {
							return new SimpleStringProperty(
									"company has no bond");

						}
					}
				});

		TablePrivate.setItems(privateList);

	}

	// ************************end methods of private
	// ***************************
	

	@FXML
	public void afficheDetailBank() {

		bank1 = banklist.get(TableBank.getSelectionModel().getSelectedIndex());
		System.out.println(bank1);
		System.out.println(bank1.getName());
		System.out.println(CmpanyNameUpdateB);
		Ok.setText(bank1.getName());
		System.out.println(Ok.getText());

		if (bank.getDateIncorporation() != null) {
			dateofIncorUpdateB.setText(bank1.getDateIncorporation().toString());
		}

		codeSticoUpdateB.setText("Bank sector");

		headOfficeUpdateB.setText(bank1.getHeadOffice());

		PhoneNumberUpdateB.setText(bank1.getPhone() + "");

		SocialCapitalUpdateB.setText(bank1.getSocialCapital() + "");

		NumberShareUpdateB.setText(bank1.getNbShares() + "");

		shareValueUpdateB.setText(bank1.getQuotation().getClosingPrice() + "");

		QuotedShareUpdateB.setText(bank1.getQuotedShares() + "");
		int noquoted = bank1.getNbShares() - bank1.getQuotedShares();
		noQuotedShareUpdateB.setText(noquoted + "");

		ShareHeighPriceUpdateB.setText(bank1.getQuotation().getHighestPrice()
				+ "");

		SharelowPriceUpdateB
				.setText(bank1.getQuotation().getLowestPrice() + "");

		ClosinfPriceUpdateB
				.setText(bank1.getQuotation().getClosingPrice() + "");

		opningPriceUpdateB.setText(bank1.getQuotation().getOpningPrice() + "");
		dateofIncorUpdateB.setText(bank1.getDateIncorporation().toString());
		
	File file1=new File(bank1.getLogo()); 
		try {
			;
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file1);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			detailPictureBank.setImage(image);
			
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

		

	}

	@FXML
	public void afficheDetailPrivate() {

		privateCompany1 = privateList.get(TablePrivate.getSelectionModel()
				.getSelectedIndex());
		System.out.println(privateCompany1);
		System.out.println(privateCompany1.getName());
		System.out.println(CmpanyNameUpdatePr);
		CmpanyNameUpdatePr.setText(privateCompany1.getName());
		System.out.println(CmpanyNameUpdatePr.getText());

		dateofIncorUpdatePr.setText(privateCompany1.getDateIncorporation()
				.toString());
		;

		codeSticoUpdatePr.setText(privateCompany1.getSector().getName());

		headOfficeUpdatePr.setText(privateCompany1.getHeadOffice());

		PhoneNumberUpdatePr.setText(privateCompany1.getPhone() + "");

		SocialCapitalUpdatePr.setText(privateCompany1.getSocialCapital() + "");

		NumberShareUpdatePr.setText(privateCompany1.getNbShares() + "");

		shareValueUpdatePr.setText(privateCompany1.getQuotation()
				.getClosingPrice() + "");

		QuotedShareUpdatePr.setText(privateCompany1.getQuotedShares() + "");
		int noquoted = privateCompany1.getNbShares()
				- privateCompany1.getQuotedShares();
		noQuotedShareUpdatePr.setText(noquoted + "");

		ShareHeighPriceUpdatePr.setText(privateCompany1.getQuotation()
				.getHighestPrice() + "");

		SharelowPriceUpdatePr.setText(privateCompany1.getQuotation()
				.getLowestPrice() + "");

		ClosinfPriceUpdatePr.setText(privateCompany1.getQuotation()
				.getClosingPrice() + "");

		opningPriceUpdatePr.setText(privateCompany1.getQuotation().getOpningPrice() + "");
		File file1=new File(privateCompany1.getLogo()); 
		try {
			;
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file1);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			detailPicturePrivate.setImage(image);
			
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}

	@SuppressWarnings("deprecation")
	@FXML
	public void afficheDetailPublic() {

		publicCompany1 = publicList.get(TablePublic.getSelectionModel()
				.getSelectedIndex());
		System.out.println(publicCompany1);
		System.out.println(publicCompany1.getName());
		
		CmpanyNameUpdatePu.setText(publicCompany1.getName());
		System.out.println(CmpanyNameUpdatePu.getText());

		dateofIncorUpdatePu.setText(publicCompany1.getDateIncorporation()
				.toString());
		;

		codeSticoUpdatePu.setText(publicCompany1.getSector().getName());

		headOfficeUpdatePu.setText(publicCompany1.getHeadOffice());

		PhoneNumberUpdatePu.setText(publicCompany1.getPhone() + "");

		SocialCapitalUpdatePu.setText(publicCompany1.getSocialCapital() + "");

		NumberShareUpdatePu.setText(publicCompany1.getNbShares() + "");
if(publicCompany1.getQuotation()!=null){
		shareValueUpdatePu.setText(publicCompany1.getQuotation()
				.getClosingPrice() + "");}

		QuotedShareUpdatePu.setText(publicCompany1.getQuotedShares() + "");
		int noquoted = publicCompany1.getNbShares()
				- publicCompany1.getQuotedShares();
		noQuotedShareUpdatePr.setText(noquoted + "");
		if(publicCompany1.getQuotation()!=null){
		ShareHeighPriceUpdatePu.setText(publicCompany1.getQuotation()
				.getHighestPrice() + "");}
		if(publicCompany1.getQuotation()!=null){
		SharelowPriceUpdatePu.setText(publicCompany1.getQuotation()
				.getLowestPrice() + "");

		ClosinfPriceUpdatePu.setText(publicCompany1.getQuotation()
				.getClosingPrice() + "");
		Bond bnd=(Bond)publicCompany1.getQuotation();
		opningPriceUpdatePu.setText(publicCompany1.getQuotation().getOpningPrice() + "");
		bopning.setText(Float.toString(bnd.getOpningPrice()));
		bclosing.setText(Float.toString(bnd.getClosingPrice()));
		bhprice.setText(Float.toString(bnd.getHighestPrice()));
		blprice.setText(Float.toString(bnd.getLowestPrice()));
		bnvalue.setText(Float.toString(bnd.getNominalValue()));
		bevalue.setText(Float.toString(bnd.getEmissionValue()));
		brvalue.setText(Float.toString(bnd.getRedemptionValue()));
		bnrate.setText(Float.toString(bnd.getNominalRate()));
		int y=bnd.getDateIssue().getYear();
		int m=bnd.getDateIssue().getMonth();
		int d=bnd.getDateIssue().getDay();
		System.out.println(y);
		LocalDate date =LocalDate.of(y+1900,m+1,d);
		bodate.setValue(date);
		int y1=bnd.getClosingDate().getYear();
		int m1=bnd.getClosingDate().getMonth();
		int d1=bnd.getClosingDate().getDay();
		LocalDate date1 =LocalDate.of(y1+1900,m1+1, d1);
		bcdate.setValue(date1);
		
		
		}
		File file1=new File(publicCompany1.getLogo()); 
		try {
			;
			System.out.println("hello2");
			BufferedImage bufferedImage = ImageIO.read(file1);
			System.out.println("hello3");
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			detailPicturePublic.setImage(image);
			
		} catch (IOException ex) {
			System.out.println("image erreur");

		}

	}
	@FXML
	public void updateBank(ActionEvent event) {

		
		
		bank1.setName(Ok.getText());
		

		System.out.println("updaaaaaaaaaaaaate");
		
		

		

		bank1.setHeadOffice(headOfficeUpdateB.getText());

		bank1.setPhone(Integer.parseInt(PhoneNumberUpdateB.getText()));

		bank1.setSocialCapital(Float.parseFloat(SocialCapitalUpdateB.getText()));

		bank1.setNbShares(Integer.parseInt(NumberShareUpdateB.getText()));
		
		bank1.getQuotation().setClosingPrice(Float.parseFloat(shareValueUpdateB.getText()));

		bank1.setQuotedShares(Integer.parseInt(QuotedShareUpdateB.getText()));
		
		
		
		bank1.getQuotation().setHighestPrice(Float.parseFloat(ShareHeighPriceUpdateB.getText()));

		bank1.getQuotation().setLowestPrice(Float.parseFloat(SharelowPriceUpdateB.getText()));

		bank1.getQuotation().setClosingPrice(Float.parseFloat(ClosinfPriceUpdateB.getText()));

		bank1.getQuotation().setOpningPrice(Float.parseFloat(opningPriceUpdateB.getText()));
		remoteBank.update(bank1,(Share) bank1.getQuotation());
		 banklist = FXCollections
				.observableArrayList(remoteBank.findAll());
		this.remplirTabBank();
	}
	@FXML
	public void updatePrivateCompany(ActionEvent event) {

		
		
		privateCompany1.setName(CmpanyNameUpdatePr.getText());
		

		System.out.println("updaaaaaaaaaaaaate priv");
		
		

		

		privateCompany1.setHeadOffice(headOfficeUpdatePr.getText());

		privateCompany1.setPhone(Integer.parseInt(PhoneNumberUpdatePr.getText()));

		privateCompany1.setSocialCapital(Float.parseFloat(SocialCapitalUpdatePr.getText()));

		privateCompany1.setNbShares(Integer.parseInt(NumberShareUpdatePr.getText()));

		privateCompany1.getQuotation().setClosingPrice(Float.parseFloat(shareValueUpdatePr.getText()));

		 privateCompany1.setQuotedShares(Integer.parseInt(QuotedShareUpdatePr.getText()));
		
		

		privateCompany1.getQuotation().setHighestPrice(Float.parseFloat(ShareHeighPriceUpdatePr.getText()));

		privateCompany1.getQuotation().setLowestPrice(Float.parseFloat(SharelowPriceUpdatePr.getText()));

		privateCompany1.getQuotation().setClosingPrice(Float.parseFloat(ClosinfPriceUpdatePr.getText()));

		privateCompany1.getQuotation().setOpningPrice(Float.parseFloat(opningPriceUpdatePr.getText()));
		remotePrivate.update(privateCompany1,(Share) privateCompany1.getQuotation());
		privateList = FXCollections
				.observableArrayList(remotePrivate.findAllPrivate());
		this.remplirTabPrivate();
	}
	@FXML
	public void updatePublicCompany(ActionEvent event) {

		
		
		publicCompany1.setName(CmpanyNameUpdatePu.getText());
		

		System.out.println("updaaaaaaaaaaaaate public");
		
		

		

		publicCompany1.setHeadOffice(headOfficeUpdatePu.getText());

		publicCompany1.setPhone(Integer.parseInt(PhoneNumberUpdatePu.getText()));

		publicCompany1.setSocialCapital(Float.parseFloat(SocialCapitalUpdatePu.getText()));

		publicCompany1.setNbShares(Integer.parseInt(NumberShareUpdatePu.getText()));
		if(publicCompany1.getQuotation()!=null){
		publicCompany1.getQuotation().setClosingPrice(Float.parseFloat(shareValueUpdatePu.getText()));}

		publicCompany1.setQuotedShares(Integer.parseInt(QuotedShareUpdatePu.getText()));
		
		
		if(publicCompany1.getQuotation()!=null){
		publicCompany1.getQuotation().setHighestPrice(Float.parseFloat(ShareHeighPriceUpdatePu.getText()));

		publicCompany1.getQuotation().setLowestPrice(Float.parseFloat(SharelowPriceUpdatePu.getText()));

		publicCompany1.getQuotation().setClosingPrice(Float.parseFloat(ClosinfPriceUpdatePu.getText()));

		publicCompany1.getQuotation().setOpningPrice(Float.parseFloat(opningPriceUpdatePu.getText()));}
		remotePublic.updatePublic(publicCompany1,(Bond) publicCompany1.getQuotation());
		 publicList = FXCollections
				.observableArrayList(remotePublic.findAllPublic());
		this.remplirTabPublic();
	}
@SuppressWarnings("deprecation")
@FXML
	public void addUpdateBond(){
	
	
	if(publicCompany1.getQuotation()!=null){
		Bond b1=(Bond)publicCompany1.getQuotation();
		b1.setClosingPrice(Float.parseFloat(bclosing.getText()));
		b1.setOpningPrice(Float.parseFloat(bopning.getText()));
		b1.setEmissionValue(Float.parseFloat(bevalue.getText()));
		b1.setNominalValue(Float.parseFloat(bnvalue.getText()));
		b1.setNominalRate(Float.parseFloat(bnrate.getText()));
		b1.setHighestPrice(Float.parseFloat(bhprice.getText()));
		b1.setLowestPrice(Float.parseFloat(blprice.getText()));
		b1.setRedemptionValue(Float.parseFloat(brvalue.getText()));
		Integer year = bodate.getValue().getYear();
		Integer month = bodate.getValue().getMonthValue();
		Integer day = bodate.getValue().getDayOfMonth();
		java.sql.Date odate = new java.sql.Date(year - 1900, month - 1, day);
		b1.setDateIssue(odate);
		Integer year1 = bcdate.getValue().getYear();
		Integer month1 = bcdate.getValue().getMonthValue();
		Integer day1 = bcdate.getValue().getDayOfMonth();
		java.sql.Date cdate = new java.sql.Date(year1 - 1900, month1 - 1, day1);
		b1.setClosingDate(cdate);
		remotePublic.updatePublic(publicCompany1,b1);
	}
	else{
		Bond b1=new Bond();
		b1.setClosingPrice(Float.parseFloat(bclosing.getText()));
		b1.setOpningPrice(Float.parseFloat(bopning.getText()));
		b1.setEmissionValue(Float.parseFloat(bevalue.getText()));
		b1.setNominalValue(Float.parseFloat(bnvalue.getText()));
		b1.setNominalRate(Float.parseFloat(bnrate.getText()));
		b1.setHighestPrice(Float.parseFloat(bhprice.getText()));
		b1.setLowestPrice(Float.parseFloat(blprice.getText()));
		b1.setRedemptionValue(Float.parseFloat(brvalue.getText()));
		Integer year = bodate.getValue().getYear();
		Integer month = bodate.getValue().getMonthValue();
		Integer day = bodate.getValue().getDayOfMonth();
		java.sql.Date odate = new java.sql.Date(year - 1900, month - 1, day);
		b1.setDateIssue(odate);
		Integer year1 = bcdate.getValue().getYear();
		Integer month1 = bcdate.getValue().getMonthValue();
		Integer day1 = bcdate.getValue().getDayOfMonth();
		java.sql.Date cdate = new java.sql.Date(year1 - 1900, month1 - 1, day1);
		b1.setClosingDate(cdate);
		b1.setCompany(publicCompany1);
		remotePublic.addBond(b1);
		
	}
	
}

	@FXML
	private void Close() {
		ScreensFramework.s.hide();
	}

	
	public boolean isFloat(String chaine) {
		try {
			Float.parseFloat(chaine);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
}
