package tn.esprit.BluesClient.Screeners;


import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.Blues.Services.ArticleServices;
import tn.esprit.Blues.entities.Article;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class articleCTRL implements Initializable, ControlledScreen {
	ScreensController myController;

	ArticleServices remote;
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
	    private TableView<Article> Table;
	 @FXML
	    private TableColumn<Article, Integer> idTab;
	    @FXML
	    private TableColumn<Article, String> nameTab;
	    @FXML
	    private TableColumn<Article, Date> dateTab;

		public ArticleServices getContext() {
			try {
				Context context = new InitialContext();
				remote = (ArticleServices) context
						.lookup("Blues/ArticleServicesImpl!"
								+ ArticleServices.class.getCanonicalName());
				return remote;
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return remote;
			}

		}
		
		
		ObservableList<Article> l= FXCollections.observableArrayList(this.getContext().findAll());
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		idTab.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id"));
		 nameTab.setCellValueFactory(new PropertyValueFactory<Article,String>("name"));
	        
	    Table.setItems(l);  
		

	        
	        

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
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
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

	public void doAddArticle() {
		Article a = new Article();
		a.setName(name.getText());
		a.setPicture(pic.getText());
		a.setAuthor(author.getText());
		a.setTopic(topic.getText());
		
		
		
		this.getContext().add(a);
	}
}
