package tn.esprit.BluesClient.Screeners;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
/**
 * this controller manages the barchart graph of company's yield.
 * 
 * */
public class Graphe1CTRL implements Initializable{
@FXML
BarChart< String, Float> graphe1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/**add starting data*/
		
		XYChart.Series<String,Float> series = new XYChart.Series<String,Float>();		
		series.setName("company 's yield as a of function time");
	
		
		series.getData().add(new XYChart.Data<String, Float>("January",(float) this.Rnd(10.3, 55.5)));

		series.getData().add(new XYChart.Data<String, Float>("February",(float) this.Rnd(100.3, 69.5) ));

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
		
		
		graphe1.getData().add(series);
		
	}
	public double Rnd(double low, double high)
	{
	     return  (double) (low + (high - low) * Math.random() + 0.5);
	}
}
