package nl.han.asd.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public abstract class Fruit extends DynamicCircleEntity implements Collided, Collider, SceneBorderCrossingWatcher {
    public Fruit(Coordinate2D initialLocation, double speed) {
        super(initialLocation);

        setRadius(8);
        setMotion(speed, Direction.DOWN);
        setOpacity(0.5);
        setStrokeWidth(0.2);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var shouldPop = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof SpeelbaarKarakter) {
                shouldPop = true;
                break;
            }
        }
        if (shouldPop) {


            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.BOTTOM)) {
            remove();
        }
    }

    public abstract int getScoreValue();

    public abstract int getHealthValue();

}
