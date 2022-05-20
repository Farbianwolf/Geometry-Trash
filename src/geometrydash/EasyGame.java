package geometrydash;

import geometrydash.objects.Block;
import geometrydash.objects.Player;
import geometrydash.objects.Spike;
import org.newdawn.slick.*;
//import org.newdawn.slick.gui.AbstractComponent;
//import org.newdawn.slick.gui.ComponentListener;
//import org.newdawn.slick.gui.MouseOverArea;

import java.util.ArrayList;


public class EasyGame extends BasicGame {

    private Player player;
    private Image Background;
    private Image Floor;
    private Image gameover;
    private Image pllayer;
    private ArrayList<Spike> spikes = new ArrayList<>();
    private ArrayList<Block> blocks = new ArrayList<>();
    private boolean isDead = false;

    private Music music;
    private Sound explosion;
    // private ArrayList <Wand> weande = new ArrayList<>();

    // private ArrayList <Wand> weande = new ArrayList<>();

    public EasyGame(String title) {
        super(title);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new EasyGame("EasyGame"));
            container.setDisplayMode(1920, 1080, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new image rendering test
     */
    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Player(400, 785, new Image("res/Player_Model.png"), container.getInput());
        Background = new Image("res/Background.png");
        Floor = new Image("res/Floor.png");
        gameover = new Image("res/Game_Over_Screen.png");
        pllayer = new Image("res/Player_Model.png");
        //  spikes.add(new Spike(1000, 785, new Image("res/normal_spike.png"), container.getInput()));
        //    spikes.add(new Spike(2000, 785, new Image("res/normal_spike.png"), container.getInput()));
        //    spikes.add(new Spike(4000, 785, new Image("res/normal_spike.png"), container.getInput()));
        //    spikes.add(new Spike(6500, 785, new Image("res/normal_spike.png"), container.getInput()));
        //    spikes.add(new Spike(7800, 785, new Image("res/normal_spike.png"), container.getInput()));
        //     spikes.add(new Spike(9000, 785, new Image("res/normal_spike.png"), container.getInput()));
        // spikes.add(new Spike(12000, 785, new Image("res/normal_spike.png"), container.getInput()));
        blocks.add(new Block(20000, 785, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 674, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 563, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 452, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 341, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 230, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 119, new Image("res/normal_cube.png"), container.getInput()));
        blocks.add(new Block(20000, 8, new Image("res/normal_cube.png"), container.getInput()));


        explosion = new Sound("res/game over.wav");
        music = new Music("res/Backgroundsong.wav");
        music.play();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        Background.draw();
        Floor.draw();
        player.draw(g);


        for (Block block : blocks) {
            block.draw(g);
        }

        if (isDead) {
            gameover.draw(0, 0);
        }


        for (Spike spike : spikes) {
            spike.draw(g);
        }


    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

        player.update(delta);
        for (Spike spike : spikes) {
            spike.update(delta);


            if (player.collide(spike.getShape())) {
                explosion.play();
                music.loop();
                resetAll();
                break;
            }
        }
        player.update(delta);
        for (Block block : blocks) {
            block.update(delta);
            if (player.collide(block.getShape())) {
                isDead = true;

            if (player.collide(block.getShape())) {
                resetAll();
                music.stop();
            }
        }
    }

    //   for (Wand w : waende) {
    //      if (w.collide(Spike.getShape()) == 1) {
    // von oben
    //   }
    //     if (w.collide(geometrydash.objects.Spike.getShape()) == 2) {
    // von link kollision
    //   }
    //  }


    void resetAll() {
        for (Spike spike : spikes) {
            spike.resetSpike();
        }

        for (Block block : blocks) {
            block.resetBlock();
        }

    }
}

