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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    public JFrame window;
    public JButton attack, magic, run, newGame, loadGame, yes, no;
    public JLabel playerName, playerHP, playerMP, title;
    public JTextArea textArea;
    public JPanel titlePanel, savePanel, hpPanel, mpPanel, namePanel;
    public Font titleFont = new Font("Arial", Font.PLAIN, 36);
    public Font btnFont = new Font("Arial", Font.PLAIN, 24);
    public JOptionPane loadPopUp, newPopUp;
    public Player player;
    public Enemy enemy;
    public PlayerBattle pBattle;
    public EnemyBattle eBattle;

    public GameGUI()
    {
        initWindow();
        initButtons();
        window.setVisible(true);
        pBattle = new PlayerBattle();
        eBattle = new EnemyBattle();
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
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        //When Attack is pressed
        if (source == attack)
        {
            this.setButtonVisible(false);
            textArea.setText("");
            pBattle.playerAttack(this);            
            eBattle.enemyBattle(this);
            playerHP.setText("HP: "+player.getHp());
            this.setButtonVisible(true);
        }
        if (source == magic)
        { 
            this.setButtonVisible(false);
            textArea.setText("");
            pBattle.playerMagic(this);
            playerMP.setText("MP: "+player.getMp());
            eBattle.enemyBattle(this);
            playerHP.setText("HP: "+player.getHp());
            this.setButtonVisible(true);
        }
        if (source == run)
        {
            textArea.setText("");
            if(pBattle.playerRun() == true)
            {
                this.generateEnemy();
            }
            else
            {
                eBattle.enemyBattle(this);
            }
        }
        
        //When the New game button is pressed
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
        
        //When the Load game button is pressed
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

        textArea = new JTextArea(10, 10);
        textArea.setBounds(150, 100, 500, 250);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        
        //JScrollPane scrollText = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        PrintStream ps = new PrintStream(new TextOutputGUI(textArea));
        System.setOut(ps);

        namePanel = new JPanel();
        namePanel.setBounds(200, 10, 400, 50);
        namePanel.setBackground(Color.BLACK);
        namePanel.setLayout(new GridBagLayout());
        
        playerName = new JLabel(player.getName());
        playerName.setForeground(Color.ORANGE);
        playerName.setFont(btnFont);
        
        hpPanel = new JPanel();
        hpPanel.setBounds(30, 200, 100, 50);
        hpPanel.setBackground(Color.DARK_GRAY);
        
        playerHP = new JLabel("HP: "+player.getHp());
        playerHP.setForeground(Color.WHITE);
        playerHP.setFont(btnFont);
        
        mpPanel = new JPanel();
        mpPanel.setBounds(670, 200, 100, 50);
        mpPanel.setBackground(Color.DARK_GRAY);
        
        playerMP = new JLabel("MP: "+player.getMp());
        playerMP.setForeground(Color.WHITE);
        playerMP.setFont(btnFont);
        
        namePanel.add(playerName);
        hpPanel.add(playerHP);
        mpPanel.add(playerMP);
        
        window.add(attack);
        window.add(magic);
        window.add(run);
        window.add(namePanel);
        window.add(hpPanel);
        window.add(mpPanel);
        window.add(textArea);
        window.repaint();
    }

    public void battleStart() throws InterruptedException
    {
        this.battleScreen();
        this.generateEnemy();
        
    }
    
    public void setButtonVisible(boolean set)
    {
        attack.setVisible(set);
        magic.setVisible(set);
        run.setVisible(set);
    }
    
    public void generateEnemy() 
    {
        //Randomly gets a number to decide what enemy to use
        Random rand = new Random();
        int enemyChosen = rand.nextInt(4) + 1;

        //Creates a enemy depending on what number was chosen 
        switch (enemyChosen)
        {
            case 1:
            {
                this.enemy = new Orc();
                break;
            }
            case 2:
            {
                this.enemy = new Wizard();
                break;
            }
            case 3:
            {
                this.enemy = new Giant();
                break;
            }
            case 4:
            {
                this.enemy = new Elf();
                break;
            }

        }
        //Displays what enemy is chosen
        System.out.println("A " + this.enemy.getName() + " appears!!\n");
        System.out.println("What do you do?");
    }

    public static void main(String[] args) 
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
