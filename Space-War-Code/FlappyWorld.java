import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyWorld extends World {
    private GreenfootSound backgroundMusic;
    private int animationMilliseconds = 0;
     
    public FlappyWorld(){    
        super(600, 400, 1);
        addObject(new Player(-1.3), 100, 300);
        //addObject(new Pipe(), 800, 175);
        
        addObject(new Score(), 300, 100); 
    }
    
    public void started(){
        backgroundMusic = new GreenfootSound("Wandering.mp3");
        backgroundMusic.play();
    }   
    
    public void gameOver(){
        backgroundMusic.stop();
        addObject(new GameOver(), 300, 200);
        addFog();
    }
    
    private void addFog() {
        // Add fog with random positions above the screen
        for (int i = 0; i < 40; i++) {
            int seed = Greenfoot.getRandomNumber(800) + 1;
            if (seed % 2 == 0) {
                addObject(new Fog(seed, animationMilliseconds), getWidth() - 200, -500);
            } else {
                addObject(new Fog(seed, animationMilliseconds), 200, -500);
            }
        }
    }
    
    public void act() {
        animationMilliseconds++; // Increment animation milliseconds
    }
}
