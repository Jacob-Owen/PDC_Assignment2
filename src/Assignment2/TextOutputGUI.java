/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author jcobm
 */
public class TextOutputGUI extends OutputStream
{
    
    private JTextArea text;
     
    public TextOutputGUI(JTextArea text) {
        this.text = text;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        text.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        text.setCaretPosition(text.getDocument().getLength());
    }
}
