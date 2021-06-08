import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class PipsPointsCalc extends JFrame {
	static float high;
	static float low;
	static float price;

	

	public PipsPointsCalc() {
        JFrame frame1 = new JFrame("Калькулятор Пипов"); 
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
        frame1.setResizable(true);
        frame1.setBounds(locationX, locationY, hor/3, vert/2+20);
        frame1.setVisible(true); 
        
        GridLayout content = new GridLayout(0, 2, 0, 0);
        frame1.setLayout(content);
        
        JButton back = new JButton("Назад");
        JLabel empty1 = new JLabel("");
        JButton clear = new JButton("Очистить");  
        JButton enter = new JButton("Расчитать");
        
        JLabel Currentpricetext = new JLabel("Текущая цена валютной пары");
        JTextField Currentpricefield = new JTextField("");
        JLabel Tradevolumetext = new JLabel("Объем сделки");
        JTextField Tradevolumefield = new JTextField("");

        JLabel results = new JLabel("<html>Валюта депозита равна первому члену валютной пары</html>");
        JLabel empty2 = new JLabel("");
        
        JLabel currency1 = new JLabel("Цена пипа");
        JLabel currency1pips = new JLabel("");
        
        frame1.add(back);frame1.add(empty1);
        frame1.add(clear);frame1.add(enter);     
        frame1.add(Currentpricetext);frame1.add(Currentpricefield);
        frame1.add(Tradevolumetext);frame1.add(Tradevolumefield);
        frame1.add(results);frame1.add(empty2);   
        frame1.add(currency1);frame1.add(currency1pips);
        
        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				price = PipsFormule(Float.parseFloat(Currentpricefield.getText()), Float.parseFloat(Tradevolumefield.getText()));
				currency1pips.setText(String.valueOf(price));
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
				Currentpricefield.setText("");
				Tradevolumefield.setText("");
				currency1pips.setText("");
			} 	    	                             
		}); 

	}
	
	public Float PipsFormule(float Current, float Trade) {
		Float result = 0.0F;
		result = 0.0001F/Current*Trade;
		return result;
	}

}



