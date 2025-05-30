package nl.han.asd.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.asd.GeorgesFruitJacht;
import nl.han.asd.entities.buttons.StartButton;

public class TitleScene extends StaticScene {

    private final GeorgesFruitJacht georgesFruitJacht;

    public TitleScene(GeorgesFruitJacht georgesFruitJacht) {
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var gameText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "George's fruit jacht");
        gameText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameText.setFill(Color.LIGHTBLUE);
        gameText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameText);

        var playGameText = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), georgesFruitJacht);
        playGameText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(playGameText);
    }
}
