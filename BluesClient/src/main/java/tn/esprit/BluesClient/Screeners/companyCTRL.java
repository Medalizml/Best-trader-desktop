package tn.esprit.BluesClient.Screeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import tn.esprit.BluesClient.Main.ScreensFramework;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
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
	Button openButtonPublic;
	@FXML
	Button openButtonPrivate;
	@FXML
	Button openButtonBank;
	@FXML
	ImageView logoPrivate;
	@FXML
	ImageView logoBank;
	@FXML
	ImageView logoPublic;
	@FXML
	Pane CompanyPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
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
	public void loadPrivateCompany() {

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
	private void Close() {
		ScreensFramework.s.hide();
	}

}
