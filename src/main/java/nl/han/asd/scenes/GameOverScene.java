package nl.han.asd.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.asd.GeorgesFruitJacht;
import nl.han.asd.entities.buttons.QuitButton;
import nl.han.asd.entities.buttons.StartButton;

public class GameOverScene extends StaticScene {

    private final GeorgesFruitJacht georgesFruitJacht;
    public GameOverScene(GeorgesFruitJacht georgesFruitJacht) {
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Game Over");
        gameOverText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameOverText.setFill(Color.DEEPPINK);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var playGamButton = new StartButton(new Coordinate2D((getWidth() / 2) - 20, getHeight() / 2), georgesFruitJacht);
        playGamButton.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(playGamButton);

        var exitGameButton = new QuitButton(new Coordinate2D((getWidth() / 2) + 20, getHeight() / 2), georgesFruitJacht);
        exitGameButton.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(exitGameButton);
    }
}
