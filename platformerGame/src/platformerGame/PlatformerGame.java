package platformerGame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PlatformerGame extends JFrame {
    private PlayerPanel playerPanel;
    private Player player;

    public PlatformerGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Platformer Game");
        setSize(800, 600);
        setResizable(false);

        player = new Player(50, 500);
        playerPanel = new PlayerPanel(player);
        add(playerPanel);

        addKeyListener(new KeyAdapter());

        setLocationRelativeTo(null);
        setVisible(true);

        GameThread gameThread = new GameThread(playerPanel);
        gameThread.start();
    }

    private class KeyAdapter implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT) {
                player.moveLeft();
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                player.moveRight();
            } else if (keyCode == KeyEvent.VK_SPACE) {
                player.jump();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
                player.stopMoving();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Unused method
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PlatformerGame();
        });
    }
}
