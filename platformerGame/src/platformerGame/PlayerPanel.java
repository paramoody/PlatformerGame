package platformerGame;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {
    private Player player;

    public PlayerPanel(Player player) {
        this.player = player;
        setBackground(Color.BLACK);
    }

    public void updatePlayer(double deltaTime) {
        player.update(deltaTime);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}
