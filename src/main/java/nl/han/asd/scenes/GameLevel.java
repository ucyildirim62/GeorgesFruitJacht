package nl.han.asd.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.asd.GeorgesFruitJacht;
import nl.han.asd.entities.SpeelbaarKarakter;
import nl.han.asd.entities.text.FruitCollectedText;
import nl.han.asd.entities.text.HealthText;
import nl.han.asd.spawner.FruitSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private final GeorgesFruitJacht georgesFruitJacht;

    public GameLevel(GeorgesFruitJacht georgesFruitJacht) {
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(new Coordinate2D(0, 0));
        addEntity(healthText);

        var fruitCollectedText = new FruitCollectedText(new Coordinate2D(0, 30));
        addEntity(fruitCollectedText);

        addEntity(new SpeelbaarKarakter(new Coordinate2D(1, 800), healthText, fruitCollectedText, georgesFruitJacht));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new FruitSpawner(getWidth(), getHeight()));

    }


}
