package platformerGame;
public static void main(String[] args) {
    //SwingUtilities.invokeLater(() -> 
	
        JFrame frame = new JFrame("Platformer Game"); // Create a JFrame
        PlatformerGame game = new PlatformerGame(); // Create an instance of your game panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(game); // Set the game panel as the content pane
        frame.pack(); // Pack components in the frame
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true); // Show the frame
    }
}
