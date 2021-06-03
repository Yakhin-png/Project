import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class PivotPointCalc extends JFrame {
	static float high;
	static float low;
	static float close;
	static float open;
	static float ppoint;
	public PivotPointCalc() {
        JFrame frame1 = new JFrame("Калькулятор Точек Разворота"); 
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
        JButton clear = new JButton("Очистить");
        JLabel empty1 = new JLabel("");
        JButton enter = new JButton("Расчитать");
        
        JLabel highpricetext = new JLabel("Максимальный показатель");
        JTextField highpricefield = new JTextField("");
        JLabel lowpricetext = new JLabel("Минимальный показатель");
        JTextField lowpricefield = new JTextField("");
        JLabel closepricetext = new JLabel("Цена закрытия");
        JTextField closepricefield = new JTextField("");
        JLabel openpricetext = new JLabel("Цена открытия");
        JTextField openpricefield = new JTextField("");
        
        JLabel results = new JLabel("Результаты");
        JLabel empty2 = new JLabel("");
        
        JLabel resist3text = new JLabel("Сопротивление 3");
        JLabel resist3 = new JLabel("");
        JLabel resist2text = new JLabel("Сопротивление 2");
        JLabel resist2 = new JLabel("");
        JLabel resist1text = new JLabel("Сопротивление 1");
        JLabel resist1 = new JLabel("");
        JLabel pivottext = new JLabel("Точки Пивот");
        JLabel pivot = new JLabel("");
        JLabel support1text = new JLabel("Поддержка 1");
        JLabel support1 = new JLabel("");
        JLabel support2text = new JLabel("Поддержка 2");
        JLabel support2 = new JLabel("");
        JLabel support3text = new JLabel("Поддержка 3");
        JLabel support3 = new JLabel("");

        frame1.add(back);frame1.add(empty1);
        frame1.add(clear);frame1.add(enter);
        frame1.add(highpricetext);frame1.add(highpricefield);
        frame1.add(lowpricetext);frame1.add(lowpricefield);
        frame1.add(closepricetext);frame1.add(closepricefield);
        
        frame1.add(results);frame1.add(empty2);
        frame1.add(resist3text);frame1.add(resist3);
        frame1.add(resist2text);frame1.add(resist2);
        frame1.add(resist1text);frame1.add(resist1);
        frame1.add(pivottext);frame1.add(pivot);
        frame1.add(support1text);frame1.add(support1);
        frame1.add(support2text);frame1.add(support2);
        frame1.add(support3text);frame1.add(support3);

        back.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				frame1.dispose();
				new Main();
			} 	    	                             
		}); 
        
        clear.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				highpricefield.setText("");
				lowpricefield.setText("");
				closepricefield.setText("");
				openpricefield.setText("");
				resist3.setText("");
				resist2.setText("");
				resist1.setText("");
				pivot.setText("");
				support1.setText("");
				support2.setText("");
				support3.setText("");
			} 	    	                             
		}); 
               
        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				high = Float.parseFloat(highpricefield.getText());
				low = Float.parseFloat(lowpricefield.getText());
				close = Float.parseFloat(closepricefield.getText());
				open = Float.parseFloat(closepricefield.getText());
				ppoint = (high+low+close)/3;
				
				resist1.setText(String.valueOf(ppoint*2-low));
				resist2.setText(String.valueOf(ppoint+high-low));
				resist3.setText(String.valueOf((ppoint-low)*2+high));
				pivot.setText(String.valueOf(ppoint));
				support1.setText(String.valueOf(ppoint*2-high));
				support2.setText(String.valueOf(ppoint-high+low));
				support3.setText(String.valueOf(low-(high-ppoint)*2));
				
				//DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
				
				//level100str.setText(String.valueOf( Math.ceil(((high-low)/100*100+low)*Math.pow(10, 4))/Math.pow(10, 4)) );
				//level100rev.setText(String.valueOf( Math.ceil(low*Math.pow(10, 4))/Math.pow(10, 4)) );

			} 	    	                             
		}); 

	}
	
	public static String SwitchStyle(float highnum, float lownum, double persent) {
		String result = new String("");
		result = (String.valueOf( Math.ceil(((high-low)/100*persent+low)*Math.pow(10, 4))/Math.pow(10, 4)) );
		return result;
	}

}
