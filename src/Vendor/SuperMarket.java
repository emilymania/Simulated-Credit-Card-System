package Vendor;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class SuperMarket extends JFrame {

	private JPanel contentPane;
	public HashMap<String, Double> prices = new HashMap<String, Double>();
	private JTextField total;
	private JTextField cC;
	public static String selected ;
	int amount;
	double done, all;
	private JTextField date;
	int[] purchases = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	double[] price = {5.0, 8.0, 16.0, 7.0, 8.0, 45.0, 15.0, 5.0, 4.0};
	String[] names = {"Bread", "Cheese", "Meats", "Fruits", "Vegetables", "Cake", "Cookies", "Juice", "Milk"};
	int chosen = 1;
	
	public SuperMarket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 896, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		
		
		prices.put("Bread", 5.00);
		prices.put("Cheese", 8.00);
		prices.put("Meats", 16.00);
		prices.put("Fruits", 7.00);
		prices.put("Vegetables", 8.00);
		prices.put("Cake", 45.00);
		prices.put("Cookies", 15.00);
		prices.put("Milk", 4.00);
		prices.put("Juice", 5.00);
		
		
		JButton btn1 = new JButton("Bread");
		JButton btn2 = new JButton("Cheese");
		JButton btn3 = new JButton("Meats");
		JButton btn4 = new JButton("Fruits");
		JButton btn5 = new JButton("Vegetables");
		JButton btn6 = new JButton("Cake");
		JButton btn7 = new JButton("Cookies");
		JButton btn8 = new JButton("Milk");
		JButton btn9 = new JButton("Juice");
		JTextArea quantity = new JTextArea();

		JLabel lblNewLabel = new JLabel("Duena's Grocery");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		lblNewLabel.setBounds(53, 11, 413, 36);
		contentPane.add(lblNewLabel);
		JLabel Msg = new JLabel("");
		Msg.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Msg.setForeground(Color.red);
		Msg.setBounds(580, 540, 90, 14);
		contentPane.add(Msg);
		
		JButton chooseAnotherStore = new JButton("Cancel / Choose another Vendor");
		chooseAnotherStore.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		chooseAnotherStore.setBounds(313, 533, 233, 36);
		chooseAnotherStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * returns to vendor options
				 */
				Vendors v = new Vendors();
				v.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(chooseAnotherStore);
		
		JLabel shoppingCart = new JLabel("Shopping Cart");
		shoppingCart.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		shoppingCart.setBounds(715, 92, 105, 24);
		contentPane.add(shoppingCart);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBounds(715, 127, 133, 300);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 58, 587, 405);
		panel.setLayout(new GridLayout(3,5));
	
		Image img1  = new ImageIcon(this.getClass().getResource("Images/Bread.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);;
		btn1.setIcon(new ImageIcon(img1));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn1.getText().toString();
				chosen = 1;
				Msg.setText("");
			}
		});
		panel.add(btn1);
		
		Image img2  = new ImageIcon(this.getClass().getResource("Images/Cheese.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);;
		btn2.setIcon(new ImageIcon(img2));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);

				selected = btn2.getText().toString();
				chosen = 2;
				Msg.setText("");
			}
		});
				
		JTextArea lbl1 = new JTextArea("Bread" + "\n" + prices.get("Bread"));
		lbl1.setEditable(false);
		lbl1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl1);
		panel.add(btn2);
		
		Image img3  = new ImageIcon(this.getClass().getResource("Images/Meats.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(img3));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn3.getText().toString();
				chosen =3;
				Msg.setText("");
			}
		});
		
		JTextArea lbl2 = new JTextArea("Cheese" + "\n" + prices.get("Cheese"));
		lbl2.setEditable(false);
		lbl2.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl2);
		panel.add(btn3);
		
		JTextArea lbl3 = new JTextArea("Meats" + "\n" + prices.get("Meats"));
		lbl3.setEditable(false);
		lbl3.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl3);
		
		Image img4  = new ImageIcon(this.getClass().getResource("Images/Fruits.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);;
		btn4.setIcon(new ImageIcon(img4));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn4.getText().toString();
				chosen = 4;
				Msg.setText("");
			}
		});
		panel.add(btn4);
		
		Image img5  = new ImageIcon(this.getClass().getResource("Images/Vegetables.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn5.setIcon(new ImageIcon(img5));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn5.getText().toString();
				chosen = 5;
				Msg.setText("");

			}
		});
		
		JTextArea lbl4 = new JTextArea("Fruits" + "\n" + prices.get("Fruits"));
		lbl4.setEditable(false);
		lbl4.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl4);
		panel.add(btn5);
		
		Image img6  = new ImageIcon(this.getClass().getResource("Images/Cake.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn6.setIcon(new ImageIcon(img6));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn6.getText().toString();
				chosen = 6;
				Msg.setText("");
			}
		});
		
		JTextArea lbl5 = new JTextArea("Vegetables" + "\n" + prices.get("Vegetables"));
		lbl5.setEditable(false);
		lbl5.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl5);
		panel.add(btn6);
		
		JTextArea lbl6 = new JTextArea("Cake" + "\n" + prices.get("Cake"));
		lbl6.setEditable(false);
		lbl6.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl6);
		
		Image img7  = new ImageIcon(this.getClass().getResource("Images/Cookies.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn7.setIcon(new ImageIcon(img7));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn7.getText().toString();
				chosen = 7;
				Msg.setText("");
			}
		});
		panel.add(btn7);
		
		Image img8  = new ImageIcon(this.getClass().getResource("Images/Juice.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn8.setIcon(new ImageIcon(img8));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn9.setBorder(null);
				
				selected = btn8.getText().toString();
				chosen = 8;
				Msg.setText("");
			}
		});
		
		JTextArea lbl7 = new JTextArea("Cookies" + "\n" + prices.get("Cookies"));
		lbl7.setEditable(false);
		lbl7.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl7);
		panel.add(btn8);
		
		Image img9  = new ImageIcon(this.getClass().getResource("Images/Milk.jpg")).getImage().getScaledInstance(
                210, 150, java.awt.Image.SCALE_SMOOTH);
		btn9.setIcon(new ImageIcon(img9));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
				
				quantity.setText("1");
				quantity.setEditable (true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				
				selected = btn9.getText().toString();
				chosen = 9;
				Msg.setText("");
			}
		});
		
		JTextArea lbl8 = new JTextArea("Juice" + "\n" + prices.get("Juice"));
		lbl8.setEditable(false);
		lbl8.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl8);
		panel.add(btn9);
		
		JTextArea lbl9 = new JTextArea("Milk" + "\n" + prices.get("Milk"));
		lbl9.setEditable(false);
		lbl9.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		panel.add(lbl9);
		
		contentPane.add(panel);
		
		
		
		JButton a2c = new JButton("Add to cart");
		a2c.setBounds(35, 495, 117, 36);
		a2c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Msg.setText("");
				if(selected == null) return;
				try{
					amount = Integer.parseInt(quantity.getText());
					done = prices.get((selected))*(amount);
				}catch (NumberFormatException ex) {
				    quantity.setText("1");
				}
				
				//textArea.append("\n" + amount + "X " + selected + " : " + prices.get(selected));

				all += done;
				checkout(chosen-1, amount);
				//total.setText(all+"");
				
				date.setEditable(true);
				cC.setEditable(true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				selected = null;
				
			}

			private void checkout(int selected, int amount) {
				// TODO Auto-generated method stub
				purchases[selected] += amount;
				double totalAmt = 0;
				textArea.setText("");
				for(int i = 0; i < purchases.length; i++) {
					if(purchases[i] > 0) {
						textArea.append("\n" + purchases[i] + "X " + names[i] + " : " + price[i]);
						totalAmt += purchases[i] * price[i];
					}
				}
				total.setText(totalAmt + "");
			}
			
		});
		contentPane.add(a2c);
		
		JLabel lblNewLabel_1 = new JLabel("Total :");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(715, 449, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(759, 443, 89, 30);
		contentPane.add(total);
		total.setColumns(10);
		
		quantity.setBounds(235, 501, 68, 28);
		quantity.setEditable(false);
		contentPane.add(quantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblQuantity.setBounds(169, 495, 56, 36);
		contentPane.add(lblQuantity);
		
		JButton remove = new JButton("Remove from cart");
		remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * check if item is in textArea, remove all of them?
				 * adjust total
				 */
				Msg.setText("");
				if(selected == null) return;
				try{
					amount = Integer.parseInt(quantity.getText());
					done = prices.get((selected))*(amount);
				}catch (NumberFormatException ex) {
				    quantity.setText("1");
				}
				
				//textArea.append("\n" + amount + "X " + selected + " : " + prices.get(selected));

				all += done;
				remove(chosen-1, amount);
				//total.setText(all+"");
				
				date.setEditable(true);
				cC.setEditable(true);
				
				btn1.setBorder(null);
				btn2.setBorder(null);
				btn3.setBorder(null);
				btn4.setBorder(null);
				btn5.setBorder(null);
				btn6.setBorder(null);
				btn7.setBorder(null);
				btn8.setBorder(null);
				btn9.setBorder(null);
				selected = null;
				
			}

			private void remove(int i, int amount) {
				// TODO Auto-generated method stub
				if(purchases[i] <= 0) return;
				int leftover = purchases[i] - amount;
				if(leftover <= 0) {
					purchases[i] = 0;
				}
				else {
					purchases[i] = leftover;
				}
				double totalAmt = 0;
				textArea.setText("");
				for(int i1 = 0; i1 < purchases.length; i1++) {
					if(purchases[i1] > 0) {
						textArea.append("\n" + purchases[i1] + "X " + names[i1] + " : " + price[i1]);
						totalAmt += purchases[i1] * price[i1];
					}
				}
				total.setText(totalAmt + "");
			}
			
		});
			
		
		remove.setBounds(313, 496, 157, 30);
		contentPane.add(remove);
		
		cC = new JTextField();
		cC.setEditable(false);
		cC.setBounds(759, 485, 86, 20);
		contentPane.add(cC);
		cC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Credit Card :");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(671, 488, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		date = new JTextField();
		date.setEditable(false);
		date.setBounds(759, 511, 86, 20);
		contentPane.add(date);
		date.setColumns(10);
		date.setText("2019-08-06");
		
		
		JLabel lblNewLabel_3 = new JLabel("Date : ");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(715, 517, 46, 14);
		contentPane.add(lblNewLabel_3);
		JButton checkout = new JButton("Checkout");
		checkout.setBounds(715, 533, 89, 23);
		checkout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			/*
			 * make sure it is a valid date and credit card
			 * add total to credit card
			 */
				Msg.setText("");
				if(textArea.getText().length() <= 3) return;
				if(validDate(date.getText())) {
					if(validCCNum(cC.getText())) {
						int ccnum = Integer.parseInt(cC.getText());
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection myConn = DriverManager.getConnection(
									"jdbc:mysql://149.4.211.180:3306/cali8332?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
						               "cali8332", "23058332");
							Statement myStmt = myConn.createStatement();
							String query = "SELECT * FROM cardholders where cardnumber = " + ccnum + ";";
							
						     ResultSet rs = myStmt.executeQuery(query);
						     rs.next();
						     double limit = Double.parseDouble(rs.getString("creditlimit"));
						     double due = Double.parseDouble(rs.getString("balance"));
						     if(due >= limit) {
						    	 //not enough credit to buy
						    	 System.out.println("Hit Credit Limit, card declined");
						    	 Msg.setText("Hit Credit Limit");
						     }
						     else {
						    	 String purchase = "insert into purchases (card_number, date, vendor, amount, description, vendor_id) ";
						    	 purchase += "values (" + ccnum + ", '" + date.getText() + "','Supermarket store', " + total.getText() + ", 'Groceries shop', 4);";
						    	 myStmt.execute(purchase);
						    	 //adding total
						    	 myStmt.executeUpdate("update cardholders set balance = balance + " + Double.parseDouble(total.getText()) +" where cardNumber =" + ccnum + ";");
						    	 System.out.println("Purchase Complete!");
						    	 for(int i = 0; i < purchases.length; i++) {
						    		 purchases[i] = 0;
						    	 }
						    	 selected = null;
									total.setText("");
									cC.setText("");
									textArea.setText("");
									Msg.setText("Purchase complete!");
						     }

						     myConn.close();
						     
					    } catch (Exception exc) {
					        System.err.println(exc.getMessage());
					        Msg.setText("Error!");
					    }
					}
					else {
						//invalid ccNum
						System.out.println("Invalid CCNum");
						Msg.setText("Invalid CCNum");
					}
				}
				else {
					//invalid date
					System.out.println("Invalid date");
					Msg.setText("Invalid Date");

				}
			}	
				
		});
		contentPane.add(checkout);
		
	
		
		
		}
	boolean validDate(String date) {
		Pattern datePattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
		boolean format = datePattern.matcher(date).matches();
		if(!format) return false;
		int year = Integer.parseInt(date.substring(0, 4));
		if(year < 1) return false;
		int month = Integer.parseInt(date.substring(5, 7));
		if(month < 1 || month > 12) return false;
		int day = Integer.parseInt(date.substring(9));
		if(day < 1 || day > 31) return false;
		return true;
	}
	
	boolean validCCNum(String input) {
		if(input.length() != 4) return false;
		try {
			int a = Integer.parseInt(input);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://149.4.211.180:3306/cali8332?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
		               "cali8332", "23058332");
			Statement myStmt = myConn.createStatement();
			String query = "SELECT * FROM cardholders where cardnumber = " + a + ";";
		     ResultSet rs = myStmt.executeQuery(query);
			if(!rs.next()) return false;
		}
		catch(Exception e) {
			System.out.println("Exception");
			return false;
		}
		return true;
	}
	
	public boolean isActivated(String f) {			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://149.4.211.180:3306/cali8332?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
		               "cali8332", "23058332");
			Statement myStmt = myConn.createStatement();
			
			
			ResultSet myRs = myStmt.executeQuery("select * from cardholders where cardnumber =" + f +";");
			
			
			myRs.next();
				if (myRs.getString("activated").equals("1")) {
					return true;
				}

	    } catch (Exception exc) {
	        System.err.println("Got an exception!");
	        System.err.println(exc.getMessage());
	    }

		return false;
}
	
}