package nl.han.asd.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.asd.GeorgesFruitJacht;
import nl.han.asd.entities.text.FruitCollectedText;
import nl.han.asd.entities.text.HealthText;

import java.util.List;
import java.util.Set;

public class SpeelbaarKarakter extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, KeyListener, Collided, Collider, Newtonian {

    private final GeorgesFruitJacht georgesFruitJacht;
    private final HealthText healthText;
    private final FruitCollectedText fruitCollectedText;
    private int health = 10;
    private int fruitCollected = 0;

    public SpeelbaarKarakter(final Coordinate2D location, final HealthText healthText, final FruitCollectedText fruitCollectedText, final GeorgesFruitJacht georgesFruitJacht) {
        super("sprites/george.png", location, new Size(40, 40), 1, 2);

        this.healthText = healthText;
        this.fruitCollectedText = fruitCollectedText;
        healthText.setText(health);
        fruitCollectedText.setText(fruitCollected);
        this.georgesFruitJacht = georgesFruitJacht;

    }


    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof Fruit fruit) {
                fruitCollected += fruit.getScoreValue();
                fruitCollectedText.setText(fruitCollected);
                health -= fruit.getHealthValue();
                healthText.setText(health);
                fruit.remove();
            }
        }

        if (health == 0) {
            this.georgesFruitJacht.setActiveScene(2);
        }
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {

        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setCurrentFrameIndex(0);
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT);
        }
    }
}
