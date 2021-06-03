import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MarginCalc extends JFrame {
	
	static float marginvalue;

	public MarginCalc() {
		
        JFrame frame1 = new JFrame("Калькулятор Маржи"); 
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
        frame1.setResizable(true);
        frame1.setBounds(locationX, locationY, hor/3, vert/2+20);
        frame1.setVisible(true); 
        
        GridLayout content = new GridLayout(0, 3, 0, 0);
        frame1.setLayout(content);
        
        JButton back = new JButton("Назад");
        JButton clear = new JButton("Очистить");  
        JButton enter = new JButton("Расчитать");
        
        JLabel costpricetext = new JLabel("Себестоимость");
        JLabel sellingpricetext = new JLabel("Цена продажи");
        JLabel margintext = new JLabel("Маржа");

        JTextField costprice = new JTextField("");
        JTextField sellingprice = new JTextField("");
        JLabel margin = new JLabel("");      
        
        JLabel empty1 = new JLabel("");
        JLabel empty2 = new JLabel("");
        JLabel empty3 = new JLabel("");
        JLabel empty4 = new JLabel("");
        JLabel empty5 = new JLabel("");
        JLabel empty6 = new JLabel("");
        JLabel empty7 = new JLabel("");
        JLabel empty8 = new JLabel("");
        JLabel empty9 = new JLabel("");

        frame1.add(back);frame1.add(clear);frame1.add(enter);
        frame1.add(empty1);frame1.add(empty2);frame1.add(empty3);
        frame1.add(empty4);frame1.add(empty5);frame1.add(empty6);
        frame1.add(empty7);frame1.add(empty8);frame1.add(empty9);
        frame1.add(costpricetext);frame1.add(sellingpricetext);frame1.add(margintext);
        frame1.add(costprice);frame1.add(sellingprice);frame1.add(margin);
        
        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				marginvalue = (Float.parseFloat(sellingprice.getText())-Float.parseFloat(costprice.getText()))/
					Float.parseFloat(sellingprice.getText())*100;
				margin.setText(String.valueOf(marginvalue));
			}                 
		}); 
              
        back.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new Main();
			} 	    	                             
		}); 
        
        clear.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				costprice.setText("");
				sellingprice.setText("");
				margin.setText("");
			} 	    	                             
		}); 

	}
}


