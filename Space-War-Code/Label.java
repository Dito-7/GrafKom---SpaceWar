import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private int duration; // Duration in acts (frames)
    private int actCounter = 0; // Counter to keep track of the number of acts

    public Label(String text, int fontSize, int duration) {
        this.duration = duration;
        GreenfootImage img = new GreenfootImage(text.length() * fontSize, fontSize);
        img.setColor(new Color(0, 0, 0, 0)); // Transparent background
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(img.getFont().deriveFont((float) fontSize));
        img.drawString(text, 0, fontSize - img.getFont().getSize() / 4);
        setImage(img);
    }

    public void act() {
        actCounter++;
        if (actCounter >= duration) {
            getWorld().removeObject(this);
        }
    }
}
