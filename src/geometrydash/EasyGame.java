package geometrydash;

import geometrydash.objects.Player;
import geometrydash.objects.Spike;
import org.newdawn.slick.*;


public class EasyGame extends BasicGame {

    private Player player;
    private Image Background;
    private Image Floor;
    private Spike Spike;
   // private ArrayList <Wand> weande = new ArrayList<>();

    public EasyGame(String title) {
        super(title);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new EasyGame("EasyGame"));
            container.setDisplayMode(1920,1080,false);
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
        player = new Player( 400, 785,new Image("res/Player_Model.png"), container.getInput());
        Background = new Image("res/Background.png");
        Floor = new Image("res/Floor.png");
        Spike = new Spike(500,785,new Image("res/normal_spike.png"));
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        Background.draw();
        Floor.draw();
        player.draw(g);
        Spike.draw(g);


    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException{

    player.update(delta);

     //   for (Wand w : waende) {
      //      if (w.collide(Spike.getShape()) == 1) {
                // von oben
         //   }
       //     if (w.collide(geometrydash.objects.Spike.getShape()) == 2) {
                // von link kollision
         //   }
      //  }


    }




}
