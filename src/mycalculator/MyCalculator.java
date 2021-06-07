/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author krikor astour
 */
public class MyCalculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, divButton, multiButton;
    JButton clrButton, eqlButton, delButton, decButton;
    JPanel panel;
    Font myFont = new Font ("ink Free", Font.BOLD ,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    MyCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        divButton = new JButton("/");
        multiButton = new JButton("*");
        subButton = new JButton("-");
        decButton = new JButton(".");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        eqlButton = new JButton("=");
        
        
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = clrButton;
        functionButtons[5] = delButton;
        functionButtons[6] = eqlButton;
        functionButtons[7] = decButton;
        
        for(int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
      //panel.setBackground(Color.GRAY);
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i])
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
        
        if(e.getSource() == decButton)
            textfield.setText(textfield.getText().concat("."));
        
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        
        if(e.getSource() == eqlButton){
            num2 = Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textfield.setText("");
        }
        
        if(e.getSource() == delButton){
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length() - 1; i++){
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }
    }
    
}
