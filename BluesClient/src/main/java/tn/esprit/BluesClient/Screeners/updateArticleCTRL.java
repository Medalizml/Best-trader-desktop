package tn.esprit.BluesClient.Screeners;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import tn.esprit.Blues.Services.ArticleServices;
import tn.esprit.Blues.entities.Article;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class updateArticleCTRL implements Initializable, ControlledScreen{
	
	
	String aSer = "Blues/ArticleServicesImpl!"
			+ ArticleServices.class.getCanonicalName();
	ArticleServices remote = (ArticleServices) ServiceLocator.getInstance()
			.getProxy(aSer);
	Article a=remote.findById(articleCTRL.i);
	@FXML
	TextField Dname;
	@FXML
	TextArea Dtopic;
	@FXML
	TextField Dimage;
	@FXML
	TextField Dauthor;
	@FXML
	CheckBox updateDate;
	@FXML
	DatePicker dateAr;
	
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Dname.setText(a.getName());
		Dtopic.setText(a.getTopic());
		Dauthor.setText(a.getAuthor());
	
		
		
		
	}
	
	
	@FXML private javafx.scene.control.Button closeButton;
	
	@SuppressWarnings("deprecation")
	public void doUpdateArticl(){
		
	
		
		a.setName(Dname.getText());
		a.setAuthor(Dauthor.getText());
		a.setTopic(Dtopic.getText());
		
		if(updateDate.isSelected())
		{
			Integer year =dateAr.getValue().getYear();
			Integer month =dateAr.getValue().getMonthValue();
			Integer day = dateAr.getValue().getDayOfMonth();
			java.sql.Date date = new java.sql.Date(year-1900, month-1, day);
			a.setDate(date);
		}
		
			
		remote.update(a);
		 Stage stage = (Stage) closeButton.getScene().getWindow();
		 stage.close();
		 
		 
	}

	FileChooser fileChooser;
	File file;

	public void openfile(ActionEvent event) {
		System.out.println("hello1");
		Node node = (Node) event.getSource();
		System.out.println(node.getScene().getWindow().toString());
		fileChooser=new FileChooser();

		file = fileChooser.showOpenDialog(node.getScene().getWindow());
		a.setPicture(file.getPath());
		
	}
	

}
