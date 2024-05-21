import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor {
    public static int score;
    private GreenfootImage scoreImage;
    
    public Score() {
        score = 0;
        scoreImage = new GreenfootImage(200, 100);
        updateImage();
    }
    
    public void act() {
        updateImage();
    }
    
    public static void add(int num) {
        score += num;
    }
    
    private void updateImage() {
        scoreImage.clear();
        
        Font font = new Font("Arial", true, false, 24);
        scoreImage.setFont(font);
        scoreImage.setColor(Color.WHITE);
        
        String scoreText = "Score: " + score;
        scoreImage.drawString(scoreText, 10, 25);
        
        setImage(scoreImage);
    }
}
