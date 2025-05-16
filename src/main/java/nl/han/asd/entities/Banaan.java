package nl.han.asd.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Banaan extends Fruit{

    public Banaan(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.YELLOW);
        setStrokeColor(Color.BLUE);
    }

    @Override
    public int getScoreValue() {
        return 5;
    }

    @Override
    public int getHealthValue() {
        return 0;
    }
}
