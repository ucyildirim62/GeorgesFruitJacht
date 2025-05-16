package nl.han.asd.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class Aardbei extends Fruit{

    public Aardbei(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.RED);
        setStrokeColor(Color.BLUE);
    }

    @Override
    public int getScoreValue() {
        return 10;
    }

    @Override
    public int getHealthValue() {
        return 0;
    }
}
