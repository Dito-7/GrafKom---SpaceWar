import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor {
    public static int score;
    public static int highScore = 0;
    private GreenfootImage scoreImage;
    
    public Score() {
        score = 0;
        scoreImage = new GreenfootImage(400, 150);
        updateImage();
    }
    
    public void act() {
        updateImage();
    }
    
    public static void add(int num) {
        score += num;
        if (score > highScore) {
            highScore = score;
        }
    }
    
    private void updateImage() {
        scoreImage.clear();
        
        // Set larger font size
        scoreImage.setFont(new Font("Arial", true, false, 20));  // Font size set to 36
        
        scoreImage.setColor(Color.WHITE);
        
        String scoreText = "Score: " + score;
        String highScoreText = "High Score: " + highScore;
        
        scoreImage.drawString(scoreText, 10, 50);
        scoreImage.drawString(highScoreText, 10, 100);
        
        setImage(scoreImage);
    }
}
