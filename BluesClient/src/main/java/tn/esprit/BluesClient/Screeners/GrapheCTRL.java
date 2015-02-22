package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
/**
 * this controller manages the linechart graph of customer's benefits.
 * 
 * */
public class GrapheCTRL implements Initializable{
	@FXML
	LineChart<String, Float> graphe;
	@FXML
	CategoryAxis x;
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/**add starting data*/
		
		XYChart.Series<String,Float> series = new XYChart.Series<String,Float>();		
		series.setName("Benfits as function of time");
	
		series.getData().add(new XYChart.Data<String, Float>("January",(float) this.Rnd(22.3, 55.5)));

		series.getData().add(new XYChart.Data<String, Float>("February",(float) this.Rnd(10.3, 69.5) ));

		series.getData().add(new XYChart.Data<String,Float>("Mars", (float) this.Rnd(9.3, 89.5)));

		series.getData().add(new XYChart.Data<String, Float>("April",(float) this.Rnd(9.6, 80)));

		series.getData().add(new XYChart.Data<String, Float>("Mai", (float) this.Rnd(80, 200)));
		series.getData().add(new XYChart.Data<String, Float>("June", (float) this.Rnd(80, 120)));
		series.getData().add(new XYChart.Data<String, Float>("July", (float) this.Rnd(-20, 600)));
		series.getData().add(new XYChart.Data<String, Float>("August", (float) this.Rnd(80, 200)));
		series.getData().add(new XYChart.Data<String, Float>("September", (float) this.Rnd(80, 140)));
		series.getData().add(new XYChart.Data<String, Float>("October", (float) this.Rnd(-80, 940)));
		series.getData().add(new XYChart.Data<String, Float>("November", (float) this.Rnd(80, 265)));
		series.getData().add(new XYChart.Data<String, Float>("December", (float) this.Rnd(80, 987)));
		
		
		graphe.getData().add(series);
		
	
		
	}
	public double Rnd(double low, double high)
	{
	     return  (double) (low + (high - low) * Math.random() + 0.5);
	}

}
