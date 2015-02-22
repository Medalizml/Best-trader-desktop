package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.Blues.Services.SharesServices;
import tn.esprit.Blues.entities.Share;
import tn.esprit.BluesClient.Main.ScreensFramework;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class profileCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	SharesServices remote;
	@FXML
	TextField estShare;
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
	TableView<Share> sharestab;
	@FXML
	TableColumn<Share, Float> companyNameS;
	@FXML
	TableColumn<Share, Integer> companyLogoS;
	@FXML
	TableColumn<Share, Float> closingPriceS;
	@FXML
	TableColumn<Share, Float> estimationS;
	ObservableList<Share> data= FXCollections.observableArrayList(this.getContext().findAll());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		companyNameS.setCellValueFactory(new PropertyValueFactory<Share, Float>("opningPrice"));
		 companyLogoS.setCellValueFactory(new PropertyValueFactory<Share,Integer>("id"));
		closingPriceS.setCellValueFactory(new PropertyValueFactory<Share,Float>("closingPrice"));
		estimationS.setCellValueFactory(new PropertyValueFactory<Share,Float>("estimation"));
		sharestab.setItems(data);
		try{
			System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaa"+this.getContext().Sharestab());
		}
		catch(Exception ex){
			System.out.println("ICIIIIIIIIIIIIIIIIIIII "+ex);
		}
	}

	@FXML
	ImageView home;
	public SharesServices getContext() {
		try {
			Context context = new InitialContext();
			System.out.println("Blues/SharesServicesImpl!"
							+ SharesServices.class.getCanonicalName());
			remote = (SharesServices) context
					.lookup("Blues/SharesServicesImpl!"+ SharesServices.class.getCanonicalName());
			return remote;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur share serveces");
			return null;
		}

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
	}

	@FXML
	private void goToScreen3() {
		myController.setScreen(ScreensFramework.screen3ID);
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
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
	private void Close() {
		ScreensFramework.s.hide();
	}
	@FXML
	private void setEstimationb(){
		Share a=null;
		String s=estShare.getText();
		Float e;
		e=Float.valueOf(s);
		 a =data.get(sharestab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 this.getContext().setEstimation(a,-e);
		 data= FXCollections.observableArrayList(this.getContext().findAll());
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
		e=Float.valueOf(s);
		 a =data.get(sharestab.getSelectionModel().getSelectedIndex());
		 System.out.println(a.getId());
		 try{
		 this.getContext().setEstimation(a,e);
		data= FXCollections.observableArrayList(this.getContext().findAll());
		sharestab.setItems(data);
		 }
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
