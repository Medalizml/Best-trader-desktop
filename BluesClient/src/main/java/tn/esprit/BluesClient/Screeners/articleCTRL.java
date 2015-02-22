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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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

import tn.esprit.Blues.Services.ArticleServices;
import tn.esprit.Blues.entities.Article;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class articleCTRL implements Initializable, ControlledScreen {
	ScreensController myController;

	/**
	 * this static integer will take the value of an article id to delete or
	 * update it later
	 */
	static Integer i;

	// ................Declaration the ServiceLocator..................///
	String aSer = "Blues/ArticleServicesImpl!"
			+ ArticleServices.class.getCanonicalName();
	ArticleServices remote = (ArticleServices) ServiceLocator.getInstance()
			.getProxy(aSer);

	// declaration of the JAVAFX component imageView//
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
	TextField name;
	@FXML
	TextField author;
	@FXML
	TextField pic;
	@FXML
	TextArea topic;
	@FXML
	DatePicker dateAr;
	@FXML
	ImageView home;
	@FXML
	Tab detail;
	@FXML
	Label Aname;
	@FXML
	TextArea Atopic;
	@FXML
	ImageView Aimage;
	@FXML
	Label Adate;

	@FXML
	Label Aauthor;
	@FXML
	Button updateButton;
	@FXML
	Button deleteButton;

	// declaration of the javaFX components Tableview and culumns//
	@FXML
	private TableView<Article> Table;
	@FXML
	private TableColumn<Article, Integer> idTab;
	@FXML
	private TableColumn<Article, String> nameTab;
	@FXML
	private TableColumn<Article, String> dateTab;

	// Instance of the sound class with witch we obtain our sound click music//
	Sound s = new Sound();

	// ..........initializing the values of the JAVAFX component
	// ObservalList.........//

	ObservableList<Article> l = FXCollections.observableArrayList(remote
			.findAll());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		remplirTab();

	}

	/**
	 * remplirTab() fill the table with data provided from the Observablelist we
	 * set the value of each columns : here we have id, name and the date of the
	 * article
	 */

	void remplirTab() {

		idTab.setCellValueFactory(new PropertyValueFactory<Article, Integer>(
				"id"));
		nameTab.setCellValueFactory(new PropertyValueFactory<Article, String>(
				"name"));
		dateTab.setCellValueFactory(new Callback<CellDataFeatures<Article, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					CellDataFeatures<Article, String> c) {
				return new SimpleStringProperty(c.getValue().getDate()
						.toString());
			}
		});

		Table.setItems(l);
		l.removeAll(remote.findAll());

	}

	// ..................Animations'functions............//
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

	// .............................Windows mapping functions.................//
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		s.playSomeSound();
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
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

	// ...........Instansiation of an article that we will add later........//
	Article a = new Article();

	/**
	 * when we click on the add button a test is launched : if there is empty
	 * fields an error window will appear else we recuperate the fields' text
	 * and the datepicker's then add the article in the database through the
	 * remote service. Finally we refresh the Observablelist of the articles to
	 * add this new article on the table.
	 */
	@SuppressWarnings("deprecation")
	public void doAddArticle() {

		if (name.getText().isEmpty() || author.getText().isEmpty()
				|| topic.getText().isEmpty()) {
			@SuppressWarnings("unused")
			JOptionPane jp = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Champ Vide ", "ERROR",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			a.setName(name.getText());
			a.setAuthor(author.getText());
			a.setTopic(topic.getText());
			Integer year = dateAr.getValue().getYear();
			Integer month = dateAr.getValue().getMonthValue();
			Integer day = dateAr.getValue().getDayOfMonth();
			java.sql.Date date = new java.sql.Date(year - 1900, month - 1, day);
			a.setDate(date);
			// System.out.println(a.getDate().toString());
			remote.add(a);
			l = FXCollections.observableArrayList(remote.findAll());
			Table.setItems(l);
			name.clear();
			author.clear();
			topic.clear();

		}
	}

	/**
	 * when we click on an article from the table this function get his index
	 * and get his id from the observable list, then we recuperate the article
	 * from the database through the remote service "findById" and the field's
	 * will be filled by its informations
	 */

	public void AfficheDetails() {
		Article a = new Article();
		Article b = new Article();
		updateButton.setDisable(false);
		deleteButton.setDisable(false);

		a = l.get(Table.getSelectionModel().getSelectedIndex());
		b = remote.findById(a.getId());
		Aname.setText(b.getName());
		Adate.setText(b.getDate().toString());
		Atopic.setText(b.getTopic());
		Aauthor.setText(b.getAuthor());

		i = b.getId();
		File file1 = new File(b.getPicture());
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file1);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			Aimage.setOpacity(1);
			Aimage.setImage(image);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		l = FXCollections.observableArrayList(remote.findAll());
		Table.setItems(l);
	}

	/**
	 * this function display a filechhoser window to choose a picture for an
	 * article after choosing a picture we get his path to assign it to an
	 * article that we will add later
	 */
	FileChooser fileChooser;
	File file;

	public void openfile(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser = new FileChooser();

		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		a.setPicture(file.getPath());

	}
	/**
	 * when we click on the delete button we recuperate the article's id and delete it through the remote service "remove"
	 * and finally we refesh the articles' list to remove the deleted article from the tableView
	 */

	public void doDeleteArticle() {

		if(JOptionPane.showConfirmDialog(new JFrame(),"Do you want to delete this user ?", "Title",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
		Article a = remote.findById(i);
		remote.remove(a);
		l = FXCollections.observableArrayList(remote.findAll());
		Table.setItems(l); }

	}

	/**
	 * when we click on the update button this function displays a popup in
	 * which we will find textfields to update an article
	 */

	public void popupUpdate() {
		FXMLLoader loader = new FXMLLoader(
				statsCTRL.class.getResource("../Screeners/updateArticle.fxml"));
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

}
