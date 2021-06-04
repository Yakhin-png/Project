
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {

	public Main() {
        JFrame frame1 = new JFrame("Торговый калькулятор"); 
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
        frame1.setResizable(true);													//изменить
        frame1.setBounds(locationX, locationY, hor/3, vert/2+20);
        frame1.setVisible(true); 
        
        GridLayout content = new GridLayout(0, 1, 0, 0);
        frame1.setLayout(content);
        
        JLabel selecttype = new JLabel("Пользователь: " + Autorization.user + ", выберите калькулятор");
        selecttype.setHorizontalAlignment(JLabel.CENTER);
        JButton type1 = new JButton("Калькулятор Фибоначчи");
        JButton type2 = new JButton("Калькулятор точек разворота");
        JButton type3 = new JButton("Калькулятор пипов");
        JButton type4 = new JButton("Калькулятор доходности");
        JButton type5 = new JButton("Калькулятор маржи");
        JButton type6 = new JButton("Калькулятор кэрри-трейд");
        
        type1.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new FibonacciCalc();
			} 	    	                             
		}); 
        
        type2.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new PivotPointCalc();
			} 	    	                             
		});   
        
        type3.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new PipsPointsCalc();
			} 	    	                             
		});
        
        type4.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new IncomeCalc();
			} 	    	                             
		});
        
        type5.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new MarginCalc();
			} 	    	                             
		});
        
        type6.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new CarryTradeCalc();
			} 	    	                             
		});
            
        frame1.add(selecttype);
        frame1.add(type1);
        frame1.add(type2);
        frame1.add(type3);
        frame1.add(type4);
        frame1.add(type5);
        frame1.add(type6);
        
    } 
}



