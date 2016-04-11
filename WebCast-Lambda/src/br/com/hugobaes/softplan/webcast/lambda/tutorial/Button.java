package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Button
{
    public static void main(String[] args)
    {
        JFrame janela = new JFrame("Lambda");
        JPanel panel = new JPanel();
        JButton button = new JButton("Teste");
//        String e = "E"
        
        button.addActionListener(e -> JOptionPane.showMessageDialog(janela, e.getClass()));
        
        button.addActionListener(e -> button.setForeground(Color.RED));
        
        panel.add(button);
        janela.add(panel);
        showOnScreen(janela);
    }
    
    static void java7()
    {
        JFrame janela = new JFrame("Lambda");
        JPanel panel = new JPanel();
        JButton button = new JButton("Teste");
        String e = "E";
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(janela, e.getClass());
            }
        });
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                button.setForeground(Color.RED);
            }
        });
        
        panel.add(button);
        janela.add(panel);
        showOnScreen(janela);
    }
    
    static void showOnScreen(JFrame janela)
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle screen2 = ge.getScreenDevices()[0].getDefaultConfiguration().getBounds();
        janela.setLocation(screen2.x, screen2.y + janela.getY());
        janela.setPreferredSize(new Dimension(200, 100));
        janela.pack();
        janela.setVisible(true);
    }
}
