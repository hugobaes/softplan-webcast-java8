package br.com.hugobaes.softplan.webcast.lambda.compare;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Button_Java_8
{
    public static void main(String... λ)
    {
        JFrame  frame  = new JFrame("Lambda - Java 8");
        JButton button = new JButton("Click Me");
        frame.add(button);
        
        
        button.addActionListener(e -> button.setBackground(Color.RED));

        
        button.addActionListener(
        	e -> JOptionPane.showMessageDialog(frame, e.getActionCommand())
        );
        
        
        showOnScreen(frame);
    }
    
    static void showOnScreen(JFrame janela)
    {
        janela.setPreferredSize(new Dimension(200, 100));
        janela.pack();
        janela.setVisible(true);
    }
}
