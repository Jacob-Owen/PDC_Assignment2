/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author jcobm
 */
public class GameGUI extends JPanel implements ActionListener
{

    //private final Timer timer;
    private JFrame window;
    private JButton attack, magic, run, newGame, loadGame, yes, no;
    private JLabel playerName, playerHP, title;
    private JTextArea textArea;
    private JPanel titlePanel, savePanel, saveButtonPanel;
    private Font titleFont = new Font("Arial", Font.PLAIN, 36);
    private Font btnFont = new Font("Arial", Font.PLAIN, 24);
    private JOptionPane loadPopUp, newPopUp;
    public Player player;
    public Enemy enemy;

    public GameGUI()
    {
        initWindow();
        initButtons();
        window.setVisible(true);
    }

    public void initWindow()
    {
        window = new JFrame("Monster Slayer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
    }

    public void initButtons()
    {
        attack = new JButton("ATTACK");
        magic = new JButton("MAGIC");
        run = new JButton("RUN");
        newGame = new JButton("NEW GAME");
        loadGame = new JButton("LOAD GAME");
        yes = new JButton("YES");
        no = new JButton("NO");

        newGame.setBackground(Color.DARK_GRAY);
        newGame.setBorder(new LineBorder(Color.CYAN, 5));
        newGame.setFont(btnFont);
        newGame.setForeground(Color.WHITE);
        newGame.setBounds(150, 400, 200, 75);

        loadGame.setBackground(Color.DARK_GRAY);
        loadGame.setBorder(new LineBorder(Color.CYAN, 5));
        loadGame.setFont(btnFont);
        loadGame.setForeground(Color.WHITE);
        loadGame.setBounds(450, 400, 200, 75);
        attack.addActionListener(this);
        magic.addActionListener(this);
        run.addActionListener(this);
        newGame.addActionListener(this);
        loadGame.addActionListener(this);
        yes.addActionListener(this);
        no.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == attack)
        {

        }
        if (source == magic)
        {

        }
        if (source == run)
        {

        }
        if (source == newGame)
        {
            String name;
            boolean valid = false;
            do
            {
                name = JOptionPane.showInputDialog(window, "Please enter your hero's name", "");
                try
                {
                    if (name.isEmpty())
                    {
                        JOptionPane.showMessageDialog(window, "Please enter a name", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        valid = true;
                    }
                }
                catch (NullPointerException ex)
                {
                    valid = true;
                }

            }
            while (valid != true);
            if (name != null)
            {
                player = new Player(name);
                try
                {
                    this.battleStart();
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (source == loadGame)
        {
            String name;
            boolean valid = false;
            do
            {
                name = JOptionPane.showInputDialog(window, "Please enter your hero's name to Load", "");
                try
                {
                    if (name.isEmpty())
                    {
                        JOptionPane.showMessageDialog(window, "Please enter a name", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        valid = true;
                    }
                }

                catch (NullPointerException ex)
                {
                    valid = true;
                }
            }
            while (valid != true);
            if (name != null)
            {
                player = new Player("");
                try
                {
                    player.loadPlayer(name);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try
                {
                    this.battleStart();
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (source == yes)
        {

        }
        if (source == no)
        {

        }
    }

    public void titleScreen()
    {
        titlePanel = new JPanel();
        titlePanel.setBounds(150, 100, 500, 100);
        titlePanel.setBackground(Color.DARK_GRAY);

        title = new JLabel("MONSTER SLAYER");
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        
        titlePanel.setLayout(new GridBagLayout());

        titlePanel.add(title);

        window.add(titlePanel);
        window.add(newGame);
        window.add(loadGame);
    }

    public void battleScreen()
    {
        titlePanel.setVisible(false);
        newGame.setVisible(false);
        loadGame.setVisible(false);

        textArea = new JTextArea();
        textArea.setBounds(150, 100, 500, 250);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        PrintStream ps = new PrintStream(new TextOutputGUI(textArea));
        System.setOut(ps);

        attack.setBackground(Color.DARK_GRAY);
        attack.setBorder(new LineBorder(Color.CYAN, 5));
        attack.setFont(btnFont);
        attack.setForeground(Color.WHITE);
        attack.setBounds(50, 400, 200, 75);

        magic.setBackground(Color.DARK_GRAY);
        magic.setBorder(new LineBorder(Color.CYAN, 5));
        magic.setFont(btnFont);
        magic.setForeground(Color.WHITE);
        magic.setBounds(300, 400, 200, 75);

        run.setBackground(Color.DARK_GRAY);
        run.setBorder(new LineBorder(Color.CYAN, 5));
        run.setFont(btnFont);
        run.setForeground(Color.WHITE);
        run.setBounds(550, 400, 200, 75);

        window.add(attack);
        window.add(magic);
        window.add(run);

        window.add(textArea);
        window.repaint();
    }

    public void battleStart() throws InterruptedException
    {
        this.battleScreen();
        System.out.println("Hello!" + player.getName());
    }

    public static void main(String[] args) throws InterruptedException
    {
        //Game game = new Game();

        GameGUI gui = new GameGUI();

        gui.titleScreen();

        //Title screen
//        //Gives the option to play a new game or load a previous game
//        game.gameStart();
//
//        //Starts the first loop of the battle
//        do
//        {
//            //Creates a random new enemy to battle
//            game.generateEnemy();
//            game.run = false;
//
//            //Starts the battle loop
//            while (game.enemy.getHp() > 0 && game.player.getHp() > 0 && game.run == false)
//            {
//                game.battleStart();
//            }
//            //Checks to see if the enemy is defeted
//            if (game.enemy.getHp() <= 0)
//            {
//                game.battleEnd();
//            }
//        }
//        //Checks to see if the player still has HP or if Quit has been selected.
//        while (game.player.getHp() > 0 && game.quit == false);
//        game.gameEnd();
    }

}
