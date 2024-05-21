import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor {
    private final double FLAP = 1.0;
    private boolean oldSpace = false;
    private double yVel = 0;
    private double y = 300;
    private boolean oldTouchingPipe = false;
    private static boolean dead;
    private int timer = 100;
    private Bullet bullet;
    
    public Player(double yVel) {
        GreenfootImage image = getImage();
        image.scale(150, 100);
        dead = false;
        this.yVel = yVel;
    }
    
    public Player() {
        this(0);
    }
    
    public void act() {
        handleMovement();
        
        if (spacePressed()) {
            getWorld().addObject(new Bullet(), getX(), getY());
        }
        
        timer--;
        if (timer <= 0) {
            getWorld().addObject(new Pipe(), getRandomNumber(500, 900), getRandomNumber(-100, 600));
            timer = 100;
        }

        checkCollisions();
        
        if (dead) {
            FlappyWorld myWorld = (FlappyWorld) getWorld();
            myWorld.gameOver();
            getWorld().removeObject(this);
        }
    }

    private void handleMovement() {
        if (Greenfoot.isKeyDown("Down")) {
            y += 1;
            setLocation(getX(), y);
        }
        if (Greenfoot.isKeyDown("Up")) {
            y += -1;
            setLocation(getX(), y);
        }
        if (Greenfoot.isKeyDown("Right")) {
            setLocation(getX() + 1, y);
        }
        if (Greenfoot.isKeyDown("Left")) {
            setLocation(getX() - 1, y);
        }
    }

    private void checkCollisions() {
        if (isAtEdge()) {
            dead = true;
        }

        for (Pipe pipe : getWorld().getObjects(Pipe.class)) {
            if (Math.abs(pipe.getX() - getX()) < 40 && Math.abs(pipe.getY() - getY()) < 40) {
                dead = true;
            }
        }
    }
    
    public boolean spacePressed() {
        boolean pressed = false;
        if (Greenfoot.isKeyDown("space")) {
            if (!oldSpace) {
                pressed = true;
            }
            oldSpace = true;
        } else {
            oldSpace = false;
        }
        return pressed;
    }
    
    public int getRandomNumber(int start, int end) {
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
    
    public static boolean isAlive() {
        return !dead;
    }
    
    public void setLocation(double x, double y) {
        super.setLocation((int) x, (int) y);
    }
}
