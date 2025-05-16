package nl.han.asd.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.asd.entities.Aardbei;
import nl.han.asd.entities.Banaan;
import nl.han.asd.entities.VerrotteAardbei;
import nl.han.asd.entities.VerrotteBanaan;

import java.util.Random;

public class FruitSpawner extends EntitySpawner {
    private final double sceneWidth;
    private static final int spawnIntervalMs = 1000;
    private static final double fruitSnelheid = 2;
    private static final int kansBanaan = 4; // van 10
    private static final int kansVerrotFruit = 3; // van 10
    private static final double spawnY = 0;

    public FruitSpawner(double sceneWidth, double sceneHeight) {
        super(spawnIntervalMs);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        Coordinate2D location = randomLocation();
        double speed = 2;

        Random random = new Random();
        int chance = random.nextInt(10);

        if (chance < kansBanaan) {
            spawn(new Banaan(location, fruitSnelheid));
        } else {
            spawn(new Aardbei(location, fruitSnelheid));
        }

        if (random.nextInt(10) < kansVerrotFruit) {
            spawn(new VerrotteAardbei(randomLocation(), speed));
            spawn(new VerrotteBanaan(randomLocation(), speed));
        }
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, spawnY);
    }
}
