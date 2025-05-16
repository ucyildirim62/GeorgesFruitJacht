package nl.han.asd.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class VerrotteBanaan extends Fruit{
    public VerrotteBanaan(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.YELLOWGREEN);
        setStrokeColor(Color.BLACK);
    }

    @Override
    public int getScoreValue() {
        return 0;
    }

    @Override
    public int getHealthValue() {
        return 1;
    }
}
