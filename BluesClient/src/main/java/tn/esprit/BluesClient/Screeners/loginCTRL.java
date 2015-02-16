package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import tn.esprit.BluesClient.Main.ScreensFramework;

public class loginCTRL implements Initializable, ControlledScreen {
	ScreensController myController;
	@FXML
	ImageView login;
	@FXML
	ImageView quit;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private void goToScreen1() {
		myController.setScreen(ScreensFramework.screen1ID);
	}

	@FXML
	private void Close() {
		ScreensFramework.s.hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
