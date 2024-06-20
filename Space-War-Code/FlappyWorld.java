import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyWorld extends World {
    private GreenfootSound backgroundMusic;
    private int animationMilliseconds = 0;
    private int speed = 60;
    private boolean firstBackgroundChanged = false;
    private boolean secondBackgroundChanged = false;
    
    public FlappyWorld() {    
        super(600, 400, 1);
        Greenfoot.setSpeed(speed);
        addObject(new Player(-1.3), 100, 300);
        addObject(new Score(), 300, 100);
          // Show level text for level 1
    }
    
    public void started() {
        backgroundMusic = new GreenfootSound("Wandering.mp3");
        backgroundMusic.playLoop(); 
        showLevelText("Level 1",200);
    }
    
    public void gameOver() {
        backgroundMusic.stop();
        addObject(new GameOver(), 300, 200);
        addFog();
    }
    
    private void addFog() {
        // Add fog with random positions above the screen
        for (int i = 0; i < 40; i++) {
            int seed = Greenfoot.getRandomNumber(800) + 1;
            int xPosition = (seed % 2 == 0) ? getWidth() - 200 : 200;
            addObject(new Fog(seed, animationMilliseconds), xPosition, -500);
        }
    }

  private void showLevelText(String text, int duration) {
        Label levelLabel = new Label(text, 40, duration); // 100 acts = approx 1.67 seconds at 60 fps
        addObject(levelLabel, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        animationMilliseconds++; // Increment animation milliseconds
        int speedIncreaseLevel1 = 63;
        int speedIncreaseLevel2 = 66;
        
        // Change background and increase speed based on score
        if (Score.score >= 10 && Score.score < 20 && !firstBackgroundChanged) {
            setBackground("background1.jpg");
            getBackground().scale(getWidth(), getHeight()); 
            Greenfoot.setSpeed(speedIncreaseLevel1);
            firstBackgroundChanged = true;
            showLevelText("Level 2",200);  // Show level text for level 2
        } 
        
        if (Score.score >= 20 && !secondBackgroundChanged) {
            setBackground("background3.jpg");
            getBackground().scale(getWidth(), getHeight()); 
            Greenfoot.setSpeed(speedIncreaseLevel2);
            secondBackgroundChanged = true;
            showLevelText("Level 3",200);  // Show level text for level 3
        }
    }
}
