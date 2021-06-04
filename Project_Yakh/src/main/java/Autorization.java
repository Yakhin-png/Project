import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Autorization extends JFrame {
	
	public JLabel tname;
	static public JTextField login;
	static public JPasswordField pass;
	public JButton enter;
	public JPanel panel;
	static int col;
	private Scanner sc;
	static String user;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Autorization();
	}

	public Autorization() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
		setBounds(locationX, locationY, hor/4, vert/2);
		setLayout(new BorderLayout());
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,1));
		panel.setVisible(true);
		
		Font mainfont = new Font("Century Gothic", Font.PLAIN, 32);
		Font secondfont = new Font("Century Gothic", Font.PLAIN, 24);
		
		tname = new JLabel("Авторизация");
		tname.setFont(mainfont);
		tname.setHorizontalAlignment(JLabel.CENTER);
		
		login = new JTextField("Логин");
		login.setHorizontalAlignment(JTextField.CENTER);
		login.setFont(secondfont);
		
		sc = new Scanner(new File("src/main/resource/pass.txt"));
		
		String hintlogin = "Логин";
		login.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (login.getText().equals(hintlogin)) {
	            	login.setText("");
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (login.getText().isEmpty()) {
	            	login.setText(hintlogin);
	            }
	        }
	    });
		
		String hintpass = "Пароль";
		pass = new JPasswordField(hintpass);
		pass.setHorizontalAlignment(JTextField.CENTER);
		pass.setFont(secondfont);
		pass.setEchoChar((char)0);
		
		pass.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (pass.getText().equals(hintpass)) {
	            	pass.setText("");
	            	pass.setEchoChar('•');
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (pass.getText().isEmpty()) {
	            	pass.setText(hintpass);
	            	pass.setEchoChar((char)0);
	            }
	        }
	    });
		
		enter = new JButton("Войти");
		enter.setFont(secondfont);
		enter.setBackground(new Color(173, 214, 254));
		panel.setBackground(new Color(230, 235, 235));
		login.setBackground(new Color(250, 250, 250));
		pass.setBackground(new Color(250, 250, 250));
			
		panel.add(tname);
		panel.add(login);
		panel.add(pass);
		panel.add(enter);

		ProgressBarRotating progressBarRotating=new ProgressBarRotating();
		enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) {  
				int count1 = 0;
				String password = new String(pass.getPassword());
				try {					
					File file = new File("src/main/resource/pass.txt"); //Добавление файла из которого считываются логины				
					FileReader fr = new FileReader(file); // создаем объект FileReader для объекта File					
					BufferedReader reader = new BufferedReader(fr); // создаем BufferedReader с существующего FileReader для построчного считывания				
					String line = reader.readLine(); // считаем сначала первую строку
					int id = 0;
					String l = "";
					for (int i = 0; i < 10; i++) {
						if (line.startsWith("L:")) {
							String[] logi = line.split(":");
							l = logi[1];
						} 				
						if (l.equalsIgnoreCase(login.getText())) { // Поиск введенного логина среди существующих
							id = i;
							break;
						}
						else {
							line = reader.readLine();
						}
					}
					reader.close();
							
					File file1 = new File("src/main/resource/pass.txt"); //Добавление файла из которого считываются пароли							
					FileReader fr1 = new FileReader(file1); // создаем объект FileReader для объекта File							
					BufferedReader reader1 = new BufferedReader(fr1); // создаем BufferedReader с существующего FileReader для построчного считывания							
					String line1 = reader1.readLine(); // считаем сначала первую строку

					String p = "";
					int svyaz = 0;
					for (int j = 0; j < 10; j++) {
						if (line1.startsWith("P:")) {
							String[] parol = line1.split(":");
							p = parol[1];
							svyaz = j;
						}
						if ((p.equalsIgnoreCase(password)) && (svyaz == (id + 1)) && (!login.getText().equals("Логин"))) {
							count1 = 1;
						} else {
							
							line1 = reader1.readLine(); // считываем остальные строки в цикле
						}
					} // Поиск введенного логина среди существующих

					if (count1 == 1) {
						dispose(); //закрывает окно
						user = login.getText();
						new Main();			
					} else {
						login.setBackground(Color.PINK);
							pass.setBackground(Color.PINK);
							pass.setText(hintpass);
							pass.setEchoChar((char)0);	
							if (!progressBarRotating.isAlive())
						    progressBarRotating.start();
							else {
								if (col > 5) {
									col = 0;
								}
							}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}  	                             
	}); 		
		setVisible(true);
		enter.transferFocus(); 
		enter.grabFocus();
	}
}

class ProgressBarRotating extends Thread {
	boolean showProgress = true;
	public void run() {
	Boolean isVisible = true;
		while (showProgress) {
			isVisible=!isVisible;
			if (Autorization.col <=5) { Autorization.col++;
				if(isVisible) {
					Autorization.login.setBackground(Color.PINK);
					Autorization.pass.setBackground(Color.PINK);
				}
				else
				{
					Autorization.login.setBackground(new Color(250, 250, 250));
					Autorization.pass.setBackground(new Color(250, 250, 250));
				}
			} else {
				Autorization.login.setBackground(new Color(250, 250, 250));
				Autorization.pass.setBackground(new Color(250, 250, 250));
			}
            try { Thread.sleep(70); }
            catch (Exception e) {};
		}
	}
		
}
	


