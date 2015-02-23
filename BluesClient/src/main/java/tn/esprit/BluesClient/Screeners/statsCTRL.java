package tn.esprit.BluesClient.Screeners;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.esprit.Blues.Services.OperationServices;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Operation;
import tn.esprit.BluesClient.Main.ScreensFramework;

/**
 * In MVC architectural patterns, a controller operates in a central role with
 * different mechanics. The controller class is a plain class with some public
 * methods. controller activity is to prepare view data(fxml file )
 * */

public class statsCTRL implements Initializable, ControlledScreen {

	String Operation = "Blues/OperationServicesImpl!"
			+ OperationServices.class.getCanonicalName();
	OperationServices remoteo = (OperationServices) ServiceLocator
			.getInstance().getProxy(Operation);
	ScreensController myController;

	OperationServices remote;

	/**
	 * adding some instance variables that to give access to the table and the
	 * labels inside the view. The fields and some methods have a special @FXML
	 * annotation. This is necessary for the fxml file to have access to those
	 * variables. After we have everything set up in the fxml file, the
	 * application will automatically fill the variables when the fxml file is
	 * loaded
	 */

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
	TableView<Customer> tab0;
	@FXML
	TableView<Company> tab3;

	@FXML
	TableColumn<Operation, String> dateOp;
	@FXML
	TableColumn<Operation, Integer> numberofshare;
	@FXML
	TableColumn<Customer, String> fname;
	@FXML
	TableColumn<Customer, String> lname;
	@FXML
	TableColumn<Customer, String> benefit;
	@FXML
	LineChart<String, Number> lineChart_Id;

	@FXML
	TableColumn<Company, String> compName;
	@FXML
	TableColumn<Company, String> Nature;
	@FXML
	ImageView home;

	userCTRL c = new userCTRL();
	/** data1 as an observable list of customer. */
	ObservableList<Customer> data1 = FXCollections.observableArrayList(c.remote
			.findAll());

	/** data as an observable list of company. */
	ObservableList<Company> data = FXCollections.observableArrayList(remoteo
			.affiche1());

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		/**
		 * The PropertyValueFactory that we set on the table columns are used to
		 * determine which field inside the customer objects should be used for
		 * the particular column
		 */

		fname.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"firstName"));
		lname.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"lastName"));

		/**
		 * The PropertyValueFactory that we set on the table columns are used to
		 * determine which field inside the company objects should be used for
		 * the particular column
		 */

		compName.setCellValueFactory(new PropertyValueFactory<Company, String>(
				"name"));
		Nature.setCellValueFactory(new PropertyValueFactory<Company, String>(
				"nature"));

		/**
		 * extracting the value of benefit from the gain field in the portfolio,
		 * then we added to tab0
		 */
		benefit.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Customer, String> c) {
				return new SimpleStringProperty(Float.toString(c.getValue()
						.getPortfolio().getGain()));
			}
		});

		/**
		 * Add observable list data to the table tab3 and data1 to the table
		 * data1
		 */

		tab0.setItems(data1);
		tab3.setItems(data);

	}

	/** all zoom methods are available to create animation for icons */

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

	/**
	 * A Popup dialog is a special window-like container for a scene graph.when
	 * this method is invoked,it provides the statistics of the customer's
	 * benefit as a line graph
	 */
	public void showpopup() {
		Customer c = data1.get(tab0.getSelectionModel().getSelectedIndex());
		ObservableList<Operation> data = FXCollections
				.observableArrayList(remoteo.affiche(c.getId()));
		numberofshare
				.setCellValueFactory(new PropertyValueFactory<Operation, Integer>(
						"numberShares"));
		dateOp.setCellValueFactory(new Callback<CellDataFeatures<Operation, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Operation, String> c) {
				return new SimpleStringProperty(c.getValue().getDateOperation()
						.toString());
			}
		});
		tab1.setItems(data);

		/** Load the fxml file and set into the center of the main layout */

		FXMLLoader loader = new FXMLLoader(
				statsCTRL.class.getResource("../Screeners/Popup.fxml"));
		try {
			Pane page = (Pane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Details");
			dialogStage.initModality(Modality.WINDOW_MODAL);

			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			dialogStage.setHeight(550);
			dialogStage.showAndWait();
		} catch (IOException e) {
			/** Exception gets thrown if the fxml file could not be loaded */
			e.printStackTrace();
		}
	}

	/**
	 * A Popup dialog is a special window-like container for a scene graph.when
	 * this method is invoked,it provides the statistics of the company's yield
	 * as a barchart graph
	 */
	public void showpopup1() {
		FXMLLoader loader = new FXMLLoader(
				statsCTRL.class.getResource("../Screeners/PopUp1.fxml"));
		try {
			Pane page = (Pane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Details");
			dialogStage.initModality(Modality.WINDOW_MODAL);

			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			dialogStage.setHeight(550);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/** SetScreenParent method will allow the injection of the Parent ScreenPane */
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	/**
	 * this method updates the data when merging from one screen to the stat screen
	 */
	@FXML
	private void updatedata(){
		ObservableList<Customer> data1 = FXCollections.observableArrayList(c.remote
				.findAll());
		ObservableList<Company> data = FXCollections.observableArrayList(remoteo
				.affiche1());
		tab0.setItems(data1);
		tab3.setItems(data);
	}

	/**
	 * gotoscreen methods are available to navigate from screen to another one
	 * animated by mouse click event
	 */
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

	/* !!!!simulation!!.! */
	/*
	 * public List<Float> ss() { List<Float> bt= new ArrayList<>();
	 * 
	 * for(Operation o : this.getContext().affiche()){ System.out.println(o);
	 * System.out.println(o.getQuotation());
	 * System.out.println(o.getPortfolio());
	 * System.out.println(o.getPortfolio().getCustomer()); System.out.println(
	 * o.
	 * getQuotation().getPricehistories().get(o.getQuotation().getPricehistories
	 * ().size()-1).getPrice());
	 * System.out.println("gaint : "+(o.getNumberShares
	 * ()*o.getQuotation().getPricehistories
	 * ().get(o.getQuotation().getPricehistories
	 * ().size()-1).getPrice()-o.getPortfolio().getCapital()));
	 * 
	 * bt.add(o.getNumberShares()*o.getQuotation().getPricehistories().get(o.
	 * getQuotation
	 * ().getPricehistories().size()-1).getPrice()-o.getPortfolio().getCapital
	 * ()); System.out.println("ouiiiiiii"+bt); } return bt; }
	 */

}
