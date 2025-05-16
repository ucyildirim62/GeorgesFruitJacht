package nl.han.asd;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.asd.scenes.GameLevel;
import nl.han.asd.scenes.GameOverScene;
import nl.han.asd.scenes.TitleScene;

/**
 * Hello world!
 *
 */
public class GeorgesFruitJacht extends YaegerGame
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("George's fruit jacht");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOverScene(this));
    }
}
