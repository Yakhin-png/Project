
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class FibonacciCalc extends JFrame {
	static float high;
	static float low;
	static String result;
	public FibonacciCalc() {
        JFrame frame1 = new JFrame("Калькулятор Фибоначчи"); 
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
        JLabel empty1 = new JLabel("");
        JButton clear = new JButton("Очистить");
        
        JLabel highpricetext = new JLabel("<html><p style=\"margin-left: 3px;\">Наивысшая цена</p></html>");
        JTextField highpricefield = new JTextField("");
        JLabel lowpricetext = new JLabel("<html><p style=\"margin-left: 3px;\">Низшая цена</p></html>");
        JTextField lowpricefield = new JTextField("");
        JLabel empty2 = new JLabel("");
        JButton enter = new JButton("Расчитать");
        
        JLabel results = new JLabel("<html><p style=\"margin-left: 3px;\"> Результаты</p></html>");
        JLabel straight = new JLabel("Прямой");
        JLabel reverse = new JLabel("Обратный");
        
        JLabel level100 = new JLabel("<html><p style=\"margin-left: 3px;\"> 100,0% уровень</p></html>");
        JLabel level100str = new JLabel("");
        JLabel level100rev = new JLabel("");

        JLabel level61_8 = new JLabel("<html><p style=\"margin-left: 3px;\"> 61,8% уровень</p></html>");
        JLabel level61_8str = new JLabel("");
        JLabel level61_8rev = new JLabel("");
        
        JLabel level50 = new JLabel("<html><p style=\"margin-left: 3px;\"> 50,0% уровень</p></html>");
        JLabel level50str = new JLabel("");
        JLabel level50rev = new JLabel("");
        
        JLabel level38_2 = new JLabel("<html><p style=\"margin-left: 3px;\"> 32,8% уровень</p></html>");
        JLabel level38_2str = new JLabel("");
        JLabel level38_2rev = new JLabel("");
        
        JLabel level23_6 = new JLabel("<html><p style=\"margin-left: 3px;\"> 23,6% уровень</p></html>");
        JLabel level23_6str = new JLabel("");
        JLabel level23_6rev = new JLabel("");
        
        JLabel level0 = new JLabel("<html><p style=\"margin-left: 3px;\"> 0,0% уровень</p></html>");
        JLabel level0str = new JLabel("");
        JLabel level0rev = new JLabel("");
        
        frame1.add(back);frame1.add(clear);frame1.add(enter);
        frame1.add(highpricetext);frame1.add(highpricefield);frame1.add(empty1);
        frame1.add(lowpricetext);frame1.add(lowpricefield);frame1.add(empty2);
        frame1.add(results);frame1.add(straight);frame1.add(reverse);
        frame1.add(level100);frame1.add(level100str);frame1.add(level100rev);
        frame1.add(level61_8);frame1.add(level61_8str);frame1.add(level61_8rev);
        frame1.add(level50);frame1.add(level50str);frame1.add(level50rev);
        frame1.add(level38_2);frame1.add(level38_2str);frame1.add(level38_2rev);
        frame1.add(level23_6);frame1.add(level23_6str);frame1.add(level23_6rev);
        frame1.add(level0);frame1.add(level0str);frame1.add(level0rev);
        
        back.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new Main();
			} 	    	                             
		}); 
        
        clear.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				level100str.setText("");
				level100rev.setText("");
				level61_8str.setText("");
				level61_8rev.setText("");
				level50str.setText("");
				level50rev.setText("");
				level38_2str.setText("");
				level38_2rev.setText("");
				level23_6str.setText("");
				level23_6rev.setText("");
				level0str.setText("");
				level0rev.setText("");
				highpricefield.setText("");
				lowpricefield.setText("");
			} 	    	                             
		}); 
               
        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				high = Float.parseFloat(highpricefield.getText());
				low = Float.parseFloat(lowpricefield.getText());
				
				DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
				
				level100str.setText(String.valueOf( Math.ceil(((high-low)/100*100+low)*Math.pow(10, 4))/Math.pow(10, 4)) );
				level100rev.setText(String.valueOf( Math.ceil(low*Math.pow(10, 4))/Math.pow(10, 4)) );
				
				level61_8str.setText(SwitchStyle(high, low, 61.8));
				level61_8rev.setText(SwitchStyle(high, low, 38.2));
				
				level50str.setText(SwitchStyle(high, low, 50));
				level50rev.setText(SwitchStyle(high, low, 50));
				
				level38_2str.setText(SwitchStyle(high, low, 38.2));
				level38_2rev.setText(SwitchStyle(high, low, 61.8));
				
				level23_6str.setText(SwitchStyle(high, low, 23.6));
				level23_6rev.setText(SwitchStyle(high, low, 76.4));
				
				level0str.setText(String.valueOf( Math.ceil(((high-low)/100*0+low)*Math.pow(10, 4))/Math.pow(10, 4)) );
				level0rev.setText(String.valueOf( Math.ceil(((high-low)+low)*Math.pow(10, 4))/Math.pow(10, 4)) );
				
				
			} 	    	                             
		}); 

	}
	
	public static String SwitchStyle(float highnum, float lownum, double persent) {
		result = new String("");
		result = (String.valueOf( Math.ceil(((highnum-lownum)/100*persent+lownum)*Math.pow(10, 4))/Math.pow(10, 4)) );
		return result;
	}

}

