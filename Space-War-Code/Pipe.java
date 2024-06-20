import greenfoot.*;
import java.util.Random;

public class Pipe extends Actor {
    private static int speed = 1;
    private boolean hasRemoved = false;
    private static final String[] IMAGES = {
        "Actor/asteroid.png", 
        "Actor/Ufo1.png", 
        "Actor/ufo2.png",
        "Actor/Virus.png",
        // Tambahkan path gambar lainnya jika ada
    };
    
    public Pipe() {
        setImage(getRandomImage());
        GreenfootImage image = getImage();
        image.scale(50, 50);
    }

    public void act() {
        setLocation(getX() - 1, getY()); // Selalu gerakkan Pipe ke kiri

        if (isAtEdge()) {
            removePipe();
        } else if (isTouching(Bullet.class)) {
            removePipeWithAnimation(); // Panggil metode baru untuk menghapus dengan animasi
            Score.add(1);
        }
    }

    private void removePipe() {
        if (!hasRemoved) {
            getWorld().removeObject(this);
            hasRemoved = true;
        }
    }

    private void removePipeWithAnimation() {
        if (!hasRemoved) {
            // Tambahkan animasi kematian
            Death deathAnimation = new Death();
            getWorld().addObject(deathAnimation, getX(), getY());

            // Hapus Pipe dari dunia
            getWorld().removeObject(this);

            // Set hasRemoved menjadi true agar tidak terjadi penghapusan ganda
            hasRemoved = true;
        }
    }

    private GreenfootImage getRandomImage() {
        Random rand = new Random();
        int index = rand.nextInt(IMAGES.length);
        return new GreenfootImage(IMAGES[index]);
    }
    
}
