package nl.han.asd.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FruitCollectedText extends TextEntity {

    public FruitCollectedText(Coordinate2D initialPosition) {
        super(initialPosition);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.PINK);
    }

    public void setText(final int fruitCollected) {
        setText("Fruit collected: " + fruitCollected);
    }
}
