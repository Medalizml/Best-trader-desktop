package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import tn.esprit.Blues.Services.BankServices;
import tn.esprit.Blues.Services.BondServices;
import tn.esprit.Blues.Services.CompanyServices;
import tn.esprit.Blues.Services.CurrencybankServices;
import tn.esprit.Blues.Services.PaircurrencyServices;
import tn.esprit.Blues.Services.SharesServices;
import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Paircurrency;
import tn.esprit.Blues.entities.Share;
import tn.esprit.BluesClient.Main.ScreensFramework;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class profileCTRL implements Initializable, ControlledScreen {
	ScreensController myController;	
	String CompanySer="Blues/CompanyServicesImpl!"+ CompanyServices.class.getCanonicalName();
	String ShareSer="Blues/SharesServicesImpl!"+ SharesServices.class.getCanonicalName();
	String BondSer="Blues/BondServicesImpl!"+ BondServices.class.getCanonicalName();
	String CurrSer="Blues/PaircurrencyServicesImpl!"+ PaircurrencyServices.class.getCanonicalName();
	String BankSer="Blues/BankServicesImpl!"+ BankServices.class.getCanonicalName();
	String CurbSer="Blues/CurrencybankServicesImpl!"+CurrencybankServices.class.getCanonicalName();
	SharesServices remotesh=(SharesServices)ServiceLocator.getInstance().getProxy(ShareSer);
	BondServices remotebd=(BondServices)ServiceLocator.getInstance().getProxy(BondSer);
	BankServices remoteba=(BankServices)ServiceLocator.getInstance().getProxy(BankSer);
	PaircurrencyServices remotecurr=(PaircurrencyServices)ServiceLocator.getInstance().getProxy(CurrSer);
	CurrencybankServices remotecb=(CurrencybankServices)ServiceLocator.getInstance().getProxy(CurbSer);
	CompanyServices remotec=(CompanyServices)ServiceLocator.getInstance().getProxy(CompanySer);
	Sound s;
	@FXML
	ImageView home;
	@FXML
	TextField estShare;
	@FXML
	TextField estBond;
	@FXML
	TextField estCurr;
	@FXML
	ImageView user;
	@FXML
	ImageView logoS;
	@FXML
	ImageView logoB;
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
	ImageView up;
	@FXML
	ImageView down;
	@FXML
	ImageView up1;
	@FXML
	ImageView down1;
	@FXML
	ImageView up2;
	@FXML
	ImageView down2;
	@FXML
	TabPane tabp;
	@FXML
	Tab shares;
	@FXML
	TableView<Bond> bondstab;
	@FXML
	TableView<Bank> bankstab;
	@FXML
	TableView<Currencybank>curbtabB;
	@FXML
	TableView<Share> sharestab;
	@FXML
	TableView<Paircurrency> currtab;
	@FXML
	TableColumn<Share, String> companyNameS;
	@FXML
	TableColumn<Currencybank, String>currName;
	@FXML
	TableColumn<Currencybank, Float>buyingPrice;
	@FXML
	TableColumn<Currencybank, Float>sellingPrice;
	@FXML
	TableColumn<Bank, String>bankName;
	@FXML
	TableColumn<Bank, Integer>bankLogo;
	@FXML
	TableColumn<Share, String> companyLogoS;
	@FXML
	TableColumn<Share, Float> closingPriceS;
	@FXML
	TableColumn<Share, Float> estimationS;
	@FXML
	TableColumn<Bond, String> companyNameB;
	@FXML
	TableColumn<Bond, String> companyLogoB;
	@FXML
	TableColumn<Bond, Float> closingPriceB;
	@FXML
	TableColumn<Bond, Float> estimationB;
	@FXML
	TableColumn<Paircurrency, String> pairs;
	@FXML
	TableColumn<Paircurrency, Float> closingPriceP;
	@FXML
	TableColumn<Paircurrency, Float> estimationP;
	ObservableList<Share> data= FXCollections.observableArrayList(remotesh.findAll());
	ObservableList<Bond> bdata= FXCollections.observableArrayList(remotebd.findAll());
	ObservableList<Paircurrency> cdata= FXCollections.observableArrayList(remotecurr.findAll());
	ObservableList<Bank> badata= FXCollections.observableArrayList(remoteba.findAll());
	//ObservableList<Currencybank> cbdata= FXCollections.observableArrayList(remotecb.findAll());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		companyNameS.setCellValueFactory(new Callback<CellDataFeatures<Share, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Share, String> c) {
	            return new SimpleStringProperty(c.getValue().getCompany().getName());                
	        }
	}); 
		 companyLogoS.setCellValueFactory(new Callback<CellDataFeatures<Share, String>, ObservableValue<String>>() {
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<Share, String> c) {
		            return new SimpleStringProperty(Integer.toString(c.getValue().getCompany().getNbShares()));                
		        }
		}); 
		closingPriceS.setCellValueFactory(new PropertyValueFactory<Share,Float>("closingPrice"));
		estimationS.setCellValueFactory(new PropertyValueFactory<Share,Float>("estimation"));
		sharestab.setItems(data);
		
		companyNameB.setCellValueFactory(new Callback<CellDataFeatures<Bond, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Bond, String> c) {
	            return new SimpleStringProperty(c.getValue().getCompany().getName());                
	        }
	}); 
		 companyLogoB.setCellValueFactory(new Callback<CellDataFeatures<Bond, String>, ObservableValue<String>>() {
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<Bond, String> c) {
		            return new SimpleStringProperty(Integer.toString(c.getValue().getCompany().getNbShares()));                
		        }
		}); 
		closingPriceB.setCellValueFactory(new PropertyValueFactory<Bond,Float>("closingPrice"));
		estimationB.setCellValueFactory(new PropertyValueFactory<Bond,Float>("estimation"));
		bondstab.setItems(bdata);
		pairs.setCellValueFactory(new PropertyValueFactory<Paircurrency,String>("name"));
		closingPriceP.setCellValueFactory(new PropertyValueFactory<Paircurrency,Float>("closingPrice"));
		estimationP.setCellValueFactory(new PropertyValueFactory<Paircurrency,Float>("estimation"));
		currtab.setItems(cdata);
		bankName.setCellValueFactory(new PropertyValueFactory<Bank,String>("name"));
		bankLogo.setCellValueFactory(new PropertyValueFactory<Bank,Integer>("phone"));
		bankstab.setItems(badata);
	}

	@FXML
	public void zoomHome() {

		home.setScaleX(1.2);
		home.setScaleY(1.2);

	}
	@FXML
	public void zoomOutHome() {

		home.setScaleX(1.0);
		home.setScaleY(1.0);

	}
	@FXML
	public void zoomUser() {

		user.setScaleX(1.2);
		user.setScaleY(1.2);

	}
	@FXML
	public void zoomOutUser() {

		user.setScaleX(1.0);
		user.setScaleY(1.0);

	}
	@FXML
	public void zoomArticle() {

		article.setScaleX(1.2);
		article.setScaleY(1.2);

	}
	@FXML
	public void zoomOutArticle() {

		article.setScaleX(1.0);
		article.setScaleY(1.0);

	}
	@FXML
	public void zoomLogout() {

		logout.setScaleX(1.2);
		logout.setScaleY(1.2);

	}
	@FXML
	public void zoomOutLogout() {

		logout.setScaleX(1.0);
		logout.setScaleY(1.0);

	}
	@FXML
	public void zoomCompany() {

		company.setScaleX(1.2);
		company.setScaleY(1.2);

	}
	@FXML
	public void zoomOutCompany() {

		company.setScaleX(1.0);
		company.setScaleY(1.0);

	}
	@FXML
	public void zoomStats() {

		stats.setScaleX(1.2);
		stats.setScaleY(1.2);

	}
	@FXML
	public void zoomOutStats() {

		stats.setScaleX(1.0);
		stats.setScaleY(1.0);

	}
	@FXML
	public void zoomProfile() {

		profile.setScaleX(1.2);
		profile.setScaleY(1.2);

	}
	@FXML
	public void zoomOutProfile() {

		profile.setScaleX(1.0);
		profile.setScaleY(1.0);

	}
	@FXML
	public void zoomUp() {

		up.setScaleX(1.2);
		up.setScaleY(1.2);

	}
	@FXML
	public void zoomOutUp() {

		up.setScaleX(1.0);
		up.setScaleY(1.0);

	}
	@FXML
	public void zoomDown() {

		down.setScaleX(1.2);
		down.setScaleY(1.2);

	}
	@FXML
	public void zoomOutDown() {

		down.setScaleX(1.0);
		down.setScaleY(1.0);

	}
	@FXML
	public void zoomUp1() {

		up1.setScaleX(1.2);
		up1.setScaleY(1.2);

	}
	@FXML
	public void zoomOutUp1() {

		up1.setScaleX(1.0);
		up1.setScaleY(1.0);

	}
	@FXML
	public void zoomDown1() {

		down1.setScaleX(1.2);
		down1.setScaleY(1.2);

	}
	@FXML
	public void zoomOutDown1() {

		down1.setScaleX(1.0);
		down1.setScaleY(1.0);

	}
	@FXML
	public void zoomUp2() {

		up2.setScaleX(1.2);
		up2.setScaleY(1.2);

	}
	@FXML
	public void zoomOutUp2() {

		up2.setScaleX(1.0);
		up2.setScaleY(1.0);

	}
	@FXML
	public void zoomDown2() {

		down2.setScaleX(1.2);
		down2.setScaleY(1.2);

	}
	@FXML
	public void zoomOutDown2() {

		down2.setScaleX(1.0);
		down2.setScaleY(1.0);

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
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen5() {
		myController.setScreen(ScreensFramework.screen5ID);
		s.playSomeSound();
	}

	@FXML
	private void goToScreen6() {
		myController.setScreen(ScreensFramework.screen6ID);
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
	@FXML
	private void setEstimationb(){
		Share a=null;
		String s=estShare.getText();
		Float e;
		try{
			e=Float.valueOf(s);}
			catch(Exception ex){
				@SuppressWarnings("unused")
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Please Type a number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
				e=(float) 0;
			}
		 a =(Share)data.get(sharestab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotesh.setEstimation(a,-e);
		 data= FXCollections.observableArrayList(remotesh.findAll());
		 sharestab.setItems(data);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void setEstimationa(){
		Share a=null;
		String s=estShare.getText();
		Float e;
		try{
			e=Float.valueOf(s);}
			catch(Exception ex){
				@SuppressWarnings("unused")
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Please Type a number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
				e=(float) 0;
			}
		 a =(Share)data.get(sharestab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotesh.setEstimation(a,e);
		 data= FXCollections.observableArrayList(remotesh.findAll());
		 sharestab.setItems(data);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void bsetEstimationb(){
		Bond a=null;
		String s=estBond.getText();
		Float e;
		try{
			e=Float.valueOf(s);}
			catch(Exception ex){
				@SuppressWarnings("unused")
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Please Type a number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
				e=(float) 0;
			}
		 a =(Bond)bdata.get(bondstab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotebd.setEstimation(a,-e);
		 bdata= FXCollections.observableArrayList(remotebd.findAll());
		 bondstab.setItems(bdata);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void bsetEstimationa(){
		Bond a=null;
		String s=estBond.getText();
		Float e;
		try{
			e=Float.valueOf(s);}
			catch(Exception ex){
				@SuppressWarnings("unused")
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Please Type a number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
				e=(float) 0;
			}
		 a =(Bond)bdata.get(bondstab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotebd.setEstimation(a,e);
		 bdata= FXCollections.observableArrayList(remotebd.findAll());
		 bondstab.setItems(bdata);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void csetEstimationa(){
		Paircurrency a=null;
		String s=estCurr.getText();
		Float e;
		try{
			e=Float.valueOf(s);}
			catch(Exception ex){
				@SuppressWarnings("unused")
				JOptionPane jp = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Please Type a number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
				e=(float) 0;
			}
		 a =(Paircurrency)cdata.get(currtab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotecurr.setEstimation(a,e);
		 cdata= FXCollections.observableArrayList(remotecurr.findAll());
		 currtab.setItems(cdata);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void csetEstimationb(){
		Paircurrency a=null;
		String s=estCurr.getText();
		Float e;
		try{
		e=Float.valueOf(s);}
		catch(Exception ex){
			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Please Type a number ", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(ex);
			e=(float) 0;
		}
		 a =(Paircurrency)cdata.get(currtab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 remotecurr.setEstimation(a,-e);
		 cdata= FXCollections.observableArrayList(remotecurr.findAll());
		 currtab.setItems(cdata);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	@FXML
	private void remplirTab(){
		Bank a=null;
		a =(Bank)badata.get(bankstab.getSelectionModel().getSelectedIndex());
		ObservableList<Currencybank> cbdata= FXCollections.observableArrayList(remotecb.findByid(a.getId()));
		currName.setCellValueFactory(new Callback<CellDataFeatures<Currencybank, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Currencybank, String> c) {
	            return new SimpleStringProperty(c.getValue().getCurrency().getName());                
	        }
	}); 
		sellingPrice.setCellValueFactory(new PropertyValueFactory<Currencybank,Float>("buyPrice"));
		buyingPrice.setCellValueFactory(new PropertyValueFactory<Currencybank,Float>("sellPrice"));
		curbtabB.setItems(cbdata);
	}
	@FXML
	private void setimS(){
		Share a=null;
		 a =(Share)data.get(sharestab.getSelectionModel().getSelectedIndex());
		  Image image = new Image(getClass().getResourceAsStream(a.getCompany().getLogo()));
		  logoS.setImage(image);
	}
	@FXML
	private void setimB(){
		Bond a=null;
		 a =(Bond)bdata.get(bondstab.getSelectionModel().getSelectedIndex());
		  Image image = new Image(getClass().getResourceAsStream(a.getCompany().getLogo()));
		  logoB.setImage(image);
	}
}
