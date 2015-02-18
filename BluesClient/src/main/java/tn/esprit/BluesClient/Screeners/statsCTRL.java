package tn.esprit.BluesClient.Screeners;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.Blues.Services.OperationServicesInterface;
import tn.esprit.Blues.entities.Operation;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class statsCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	

	OperationServicesInterface remote;

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
	TableView<Operation> tab1;
	
	
	@FXML
	TableColumn<Operation, Float> dateOp;
	@FXML
	TableColumn<Operation, Integer> numberofshare;
	
	ObservableList<Operation> data = FXCollections.observableArrayList(this.getContext().afficherOperation());
	
	public OperationServicesInterface getContext() {
		try {
			Context context = new InitialContext();
			remote = (OperationServicesInterface) context
					.lookup("Blues/CustomerServicesImpl!"
							+ OperationServicesInterface.class.getCanonicalName());
			return remote;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return remote;
		}

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		dateOp.setCellValueFactory(new
	 PropertyValueFactory<Operation,Float>("sharePrice"));
		numberofshare.setCellValueFactory(new
		 PropertyValueFactory<Operation,Integer>("numberShares"));
		// value.setCellValueFactory(new
		// PropertyValueFactory<Customer,Float>("value"));
		tab1.setItems(data);

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
	public void showpopup()
	{
		FXMLLoader loader = new FXMLLoader(statsCTRL.class.getResource("../Screeners/Popup.fxml"));
		try{  
		Pane page = (Pane) loader.load();
		    Stage dialogStage = new Stage();
		    dialogStage.setTitle("d�tails");
		    dialogStage.initModality(Modality.WINDOW_MODAL);
		    
		    Scene scene = new Scene(page);
		    dialogStage.setScene(scene);
		  
		    
	        dialogStage.setHeight(550);
		    dialogStage.showAndWait();}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		    
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
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
	}

	@FXML
	private void goToScreen6() {
		myController.setScreen(ScreensFramework.screen6ID);
	}

	@FXML
	private void goToScreen7() {
		myController.setScreen(ScreensFramework.screen7ID);
	}

}
	
	
	

	


