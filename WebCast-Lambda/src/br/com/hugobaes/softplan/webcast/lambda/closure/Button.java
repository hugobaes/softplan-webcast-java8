package br.com.hugobaes.softplan.webcast.lambda.closure;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Button
{
    public static void main(String[] args)
    {
        JFrame janela = new JFrame("Lambda");
        
        JPanel panel = new JPanel();
        janela.add(panel);
        
        JButton button = new JButton("Teste");
        panel.add(button);

        //String e = "E"
        
        button.addActionListener(e -> JOptionPane.showMessageDialog(janela, e.getClass()));
        
        button.addActionListener(e -> button.setForeground(Color.RED));
        
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
        janela.setPreferredSize(new Dimension(200, 100));
        janela.pack();
        janela.setVisible(true);
    }
}
