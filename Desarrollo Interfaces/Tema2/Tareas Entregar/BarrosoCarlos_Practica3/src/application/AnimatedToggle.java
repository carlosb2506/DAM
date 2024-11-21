package application;

import javafx.animation.ScaleTransition;
import javafx.scene.control.CheckBox;
import javafx.util.Duration;

public class AnimatedToggle extends CheckBox {
	public AnimatedToggle() {
		super();
		this.selectedProperty().addListener((observable, oldValue, newValue) -> {
			animateToggle(newValue);
		});
	}

	private void animateToggle(boolean selected) {
		ScaleTransition st = new ScaleTransition(Duration.millis(200), this);
		st.setToX(selected ? 1.2 : 1.0);
		st.setToY(selected ? 1.2 : 1.0);
		st.play();
	}
}