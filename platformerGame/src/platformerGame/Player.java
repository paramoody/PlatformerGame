package platformerGame;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x, y; // Player position
    private double xVelocity = 0; // Horizontal velocity for smoother movement
    private double yVelocity = 0; // Vertical velocity for smoother movement
    private final double gravity = 0.5; // Gravity affecting player
    private boolean isJumping = false; // Flag to track if the player is currently jumping

    private final int speed = 5; // Speed of player movement
    private final int jumpHeight = 15; // Height of the jump

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        xVelocity = -speed; // Update horizontal velocity for left movement
    }

    public void moveRight() {
        xVelocity = speed; // Update horizontal velocity for right movement
    }

    public void stopMoving() {
        xVelocity = 0; // Reset horizontal velocity to zero
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            yVelocity = -jumpHeight; // Set initial upward velocity for jumping
        }
    }

    public void update(double deltaTime) {
        x += xVelocity * deltaTime; // Move player horizontally based on velocity and elapsed time

        if (isJumping) {
            y += yVelocity * deltaTime; // Move player vertically while jumping based on velocity and elapsed time
            yVelocity += gravity * deltaTime; // Apply gravity to the vertical velocity

            if (y >= 500) { // Check if player has landed
                y = 500; // Ensure the player doesn't fall below the ground level
                isJumping = false; // Stop jumping
                yVelocity = 0; // Reset vertical velocity
            }
        } else if (y < 500) {
            yVelocity += gravity * deltaTime; // Apply gravity to the vertical velocity
            y += yVelocity * deltaTime; // Move player vertically while falling based on velocity and elapsed time

            if (y >= 500) { // Check if player has landed
                y = 500; // Ensure the player doesn't fall below the ground level
                yVelocity = 0; // Reset vertical velocity
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50); // Draw the player (white rectangle) at x, y
    }
}
