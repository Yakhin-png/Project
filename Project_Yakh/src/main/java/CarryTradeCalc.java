import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CarryTradeCalc extends JFrame {
	
	static float profit;
	static int years;
	static float days;

	public CarryTradeCalc() {
        JFrame frame1 = new JFrame("Калькулятор Кэрри-Трейд"); 
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
        
        JLabel credittext = new JLabel("Оценка кредита, %");
        JTextField credit = new JTextField("");
        JLabel loantext = new JLabel("Оценка заема, %");
        JTextField loan = new JTextField("");
        JLabel tradetext = new JLabel("Размер сделки");
        JTextField trade = new JTextField("");
        JLabel holdtext = new JLabel("Удерж. дней");
        JTextField hold = new JTextField("");
        JLabel earnedtext = new JLabel("Заработанные проценты");
        JLabel earned = new JLabel("");
        
        frame1.add(back);frame1.add(empty1);
        frame1.add(clear);frame1.add(enter);
        frame1.add(credittext);frame1.add(credit);
        frame1.add(loantext);frame1.add(loan);
        frame1.add(tradetext);frame1.add(trade);
        frame1.add(holdtext);frame1.add(hold);
        frame1.add(earnedtext);frame1.add(earned);

        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				profit=Float.parseFloat(trade.getText());
				years = Integer.parseInt(hold.getText())/365;
				days = Float.parseFloat(hold.getText())%365;
				if (years>0)
				for (int i=0; i<years; i++) {
					profit = profit + profit/100*(Float.parseFloat(credit.getText())-Float.parseFloat(loan.getText()));
				}
				profit = profit + profit/100*(Float.parseFloat(credit.getText())-Float.parseFloat(loan.getText()))/365*days;
				earned.setText(String.valueOf(profit-Float.parseFloat(trade.getText())));
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
				credit.setText("");
				loan.setText("");
				trade.setText("");
				hold.setText("");
				earned.setText("");
			} 	    	                             
		}); 

	}
}


