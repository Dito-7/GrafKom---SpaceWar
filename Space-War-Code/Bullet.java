import greenfoot.*;

public class Bullet extends Actor {
    private static boolean hit;
    private Pipe hitpipe = null;
    private GreenfootSound bulletSound; // Deklarasi variabel untuk suara bullet

    public Bullet() {
        GreenfootImage image = getImage();
        image.scale(70, 30);
        hit = false;
        
        // Inisialisasi suara bullet
        GreenfootSound bulletSound = new GreenfootSound("blaster.mp3");
        bulletSound.setVolume(20); // Mengatur volume suara menjadi 50% dari volume aslinya
        bulletSound.play(); // Ganti "bullet_sound.wav" dengan nama file suara Anda
    }
    
    public void act() {
        setLocation(getX() + 1, getY());

        // Cek jika bullet menyentuh tepi layar atau pipe
        if (isAtEdge() || hitpipe != null || isTouching(Pipe.class)) {
            // Membuat instance dari kelas Death dan menempatkannya di lokasi tabrakan
            Death deathAnimation = new Death();
            getWorld().addObject(deathAnimation, getX(), getY());
            getWorld().removeObject(this);
        }
    }

    // Metode untuk menetapkan pipe yang disentuh bullet
    public void setHitPipe(Pipe pipe) {
        hitpipe = pipe;
    }
}
