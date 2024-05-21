import greenfoot.*;

public class Pipe extends Actor {
    private boolean hasRemoved = false;

    public Pipe() {
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
}