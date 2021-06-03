import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IncomeCalc extends JFrame {
	
	static int refillfrequency;
	static int ratefrequency;
	static int periodtype;
	static float price;

	public IncomeCalc() {
        JFrame frame1 = new JFrame("����������� ����������"); 
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
        
        refillfrequency=1;
        ratefrequency=1;
        periodtype=1;
        
        JButton back = new JButton("�����");
        JLabel empty1 = new JLabel("");
        JButton clear = new JButton("��������");  
        JButton enter = new JButton("���������");
        
        JLabel startup = new JLabel("��������� �������");
        JTextField startupfield = new JTextField("");
        JButton rate = new JButton("������ ���������� � �����");
        JTextField ratefield = new JTextField("");
        JLabel refill = new JLabel("����������� ���������� �����");
        JTextField refillfield = new JTextField("");
        JLabel period = new JLabel("���-�� �������");
        JTextField periodfield = new JTextField("");
        
        JLabel currency1 = new JLabel("���������");
        JLabel currency1label = new JLabel("");
        
        frame1.add(back);frame1.add(empty1);
        frame1.add(clear);frame1.add(enter);     
        frame1.add(startup);frame1.add(startupfield);
        frame1.add(rate);frame1.add(ratefield);
        frame1.add(refill);frame1.add(refillfield);   
        frame1.add(period);frame1.add(periodfield); 
        frame1.add(currency1);frame1.add(currency1label);
        
        enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				if (ratefrequency==0) {
					price=Float.parseFloat(startupfield.getText());
					for (int i=0; i<Integer.parseInt(periodfield.getText()); i++) {
						price=price+price/100*Float.parseFloat(ratefield.getText());
						if (refillfrequency==0) {
							price=price+Float.parseFloat(refillfield.getText());
						} else {
							price=price+Float.parseFloat(refillfield.getText())*12;
						}
					}
				} else { 
					byte months=1;
					price=Float.parseFloat(startupfield.getText());
					for (int i=0; i<Integer.parseInt(periodfield.getText()); i++) {		
						price=price+price/100*Float.parseFloat(ratefield.getText());
						if (refillfrequency==0 && months==12) {
							price=price+Float.parseFloat(refillfield.getText());
						} else {
							price=price+Float.parseFloat(refillfield.getText());
						}
						months++;
						if (months==13) months=1;
						
					}
				}
				currency1label.setText(String.valueOf(price));
			} 	    	                             
		}); 
        
        rate.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) { 
				if (rate.getText().equals("������ ���������� � �����")) {
					rate.setText("������ ���������� � ���");
					refill.setText("��������� ���������� �����");
					period.setText("���-�� ���");
					ratefrequency=0;
					refillfrequency=0;
					periodtype=0;
				} else {
					rate.setText("������ ���������� � �����");
					refill.setText("����������� ���������� �����");
					period.setText("���-�� �������");
					ratefrequency=1;
					refillfrequency=1;
					periodtype=1;
				}
				
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
				startupfield.setText("");
				refillfield.setText("");
				ratefield.setText("");
				periodfield.setText("");
				currency1label.setText("");
			} 	    	                             
		}); 

	}
}



