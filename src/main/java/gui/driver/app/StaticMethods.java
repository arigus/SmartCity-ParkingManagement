package gui.driver.app;

import java.util.ArrayList;

import data.members.StickersColor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

public class StaticMethods {

	public static String getStickerClolorFromEnum(final StickersColor ¢) {
		switch (¢) {
		case BLUE:
			return "Blue";
		case BORDEAUX:
			return "Bordeaux";
		case GREEN:
			return "Green";
		case RED:
			return "Red";
		case WHITE:
			return "White";
		case YELLOW:
			return "Yellow";
		default:
			return "";
		}
	}

	// onEntry checks if you just entered the window or you clicked on the mute
	// button
	public static void dealWithMute(final MediaPlayer p, final ArrayList<Button> muteButtonsAL) {
		for (final Button currButton : muteButtonsAL)
			currButton.setGraphic(new ImageView(new Image(
					StaticMethods.class.getResourceAsStream(!p.isMute() ? "mute_button.png" : "unmute_button.png"))));
		p.setMute(!p.isMute());
	}

	public static Button cloneButton(final Button firstButton) {
		final Button $ = new Button();
		$.setText(firstButton.getText());
		// System.out.println("firstButton.getOnAction(): " +
		// firstButton.getOnAction());
		// System.out.println(firstButton.getStyleClass().toString());
		$.getStyleClass().addAll(firstButton.getStyleClass());
		$.setOnAction(λ -> StaticMethods.dealWithMute(AbstractWindow.mediaPlayer, AbstractWindow.muteButtonsAL));
		return $;
	}

}
