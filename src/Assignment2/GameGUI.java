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
import java.awt.GridLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author jcobm
 */
public class GameGUI extends JPanel
{
    //private final Timer timer;
    private JFrame window;
    private final JButton attack, magic, run, newGame, loadGame, yes, no;
    private JLabel text, title;
    private JPanel textPanel;
    private JPanel titlePanel, titleButtonPanel, gamePanel, gameButtonPanel, savePanel, saveButtonPanel;
    private Font titleFont = new Font("Arial", Font.PLAIN, 36);
    
    
    public GameGUI()
    {
        window = new JFrame("Monster Slayer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.getContentPane().setBackground(Color.BLUE);
        window.setLayout(null);
        
        titlePanel = new JPanel();
        titlePanel.setBounds(150, 100, 500, 100);
        titlePanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("MONSTER SLAYER");
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        
        
        
        attack = new JButton("ATTACK");
        magic = new JButton("MAGIC");
        run = new JButton("RUN");
        newGame = new JButton("NEW GAME");
        loadGame = new JButton("LOAD GAME");
        yes = new JButton("YES");
        no = new JButton("NO");
        
        
        titleButtonPanel = new JPanel();
        titleButtonPanel.setBounds(150, 450, 500, 75);
        titleButtonPanel.setLayout(new GridLayout(1, 2));
        
        attack.setBounds(50, 200, 100, 50);
        magic.setBounds(200, 200, 100, 50);
        run.setBounds(350, 200, 100, 50);
        
        newGame.setBackground(Color.BLACK);
        newGame.setFont(titleFont);
        loadGame.setSize(100, 100);
        
        yes.setBounds(150, 370, 100, 50);
        no.setBounds(300, 370, 100, 50);
        
        //.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        
        titleButtonPanel.add(newGame);
        titleButtonPanel.add(loadGame);
        titlePanel.add(title);
        //loadGame.setBounds(300, 100, 100, 150);
        window.add(titlePanel);
        window.add(titleButtonPanel);
        window.setVisible(true);
        
    }
    
    
    public static void main(String[] args) throws InterruptedException
    {
        //Game game = new Game();
        
        GameGUI gui = new GameGUI();
        //Title screen
//        System.out.println("===============");
//        System.out.println("Monster Slayer!");
//        System.out.println("===============");
//        Thread.sleep(1000);
//        System.out.println("Your adventure begins");
//
//        for (int i = 0; i < 5; i++)
//        {
//            System.out.print(".");
//            Thread.sleep(500);
//        }
//
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
