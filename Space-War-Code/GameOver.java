import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    public GameOver() {
        GreenfootImage image = getImage();
        image.scale(600, 400); // Menyesuaikan ukuran gambar menjadi setengah dari ukuran aslinya
        setImage(image);// Menetapkan gambar yang telah diubah ukurannya
        
        GreenfootSound game = new GreenfootSound("gameover.mp3");
        game.setVolume(100); // Mengatur volume suara menjadi 50% dari volume aslinya
        game.play();
    }
}
