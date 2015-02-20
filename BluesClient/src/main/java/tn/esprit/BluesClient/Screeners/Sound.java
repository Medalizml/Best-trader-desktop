package tn.esprit.BluesClient.Screeners;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
	
	private void playMedia(Media m){
	    if (m != null){
	        MediaPlayer mp = new MediaPlayer(m);
	        mp.play();
	    }
	}

	public void playSomeSound(){
	    try{
	    	final File file = new File("src/main/java/tn/esprit/BluesClient/Screeners/Windows Navigation Start.wav");  
	    	final Media media = new Media(file.toURI().toString());
	        playMedia(media);
	    }catch(Exception ex){
	        System.out.println(ex);
	    }

	}

}
