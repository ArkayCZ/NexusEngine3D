package game;

import engine.NexusGame;
import engine.graphics.*;
import engine.graphics.shaders.BasicShader;
import engine.graphics.shaders.Shader;
import engine.input.Input;
import engine.math.Vector2;
import engine.math.Vector3;
import engine.utils.ContentLoader;

/**
 * Created by vesel on 02.11.2015.
 */
public class WolfensteinClone extends NexusGame {

    private Level mLevel;
    public static Material sSpriteSheet;

    public WolfensteinClone() {
        super("Wolfenstein3D");
        setWindowSize(600, 600);
        start();
    }

    @Override
    public void init() {
        getGameWindow().initProjection(70f, 0.1f, 1000f);

        sSpriteSheet = new Material(ContentLoader.loadTexture("res/textures/spritesheet.png"), new Vector3(1));

        LevelLoader loader = new LevelLoader();
        loader.setBitmap(ContentLoader.loadBitmap("res/level/level1.png"));

        mLevel = loader.createLevel();
    }

    @Override
    public void update(Input inputStatus) {
        mLevel.update(inputStatus);

        if(inputStatus.isKeyDown(Input.KEY_ESC)) {
            stop();
        }

        inputStatus.update();
    }

    @Override
    public void render() {
        RenderingEngine engine = new RenderingEngine();

        mLevel.render(engine);

        engine.flush();
    }



    @Override
    public void secondlyUpdate() {

    }
}

//TODO: Create a level loader
