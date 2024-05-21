import greenfoot.*;

public class Death extends Actor {
    private int animationFrame = 1;

    public Death() {
        GreenfootSound deathSound = new GreenfootSound("DeathExplosion/AlienMetal/gun.mp3");
        deathSound.setVolume(50); // Mengatur volume suara menjadi 50% dari volume aslinya
        deathSound.play();
    }

    public void act() {
        if (animationFrame <= 12) {
            setImage("DeathExplosion/AlienMetal/" + String.format("%02d", animationFrame) + ".png");
            getImage().scale(64, 64);
            animationFrame++;
        } else {
            getWorld().removeObject(this);
        }
    }
}
