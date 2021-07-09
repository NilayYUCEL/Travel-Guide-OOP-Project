import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Main {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static Management m;

	static String city_Name = "";
	static boolean test = false;
	static int buttonfor = -1;
	static int control = 0;
	static String type = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		m = new Management();
		startPage();

	}

	// this function is used for display start page of the program.
	// program redirect user to sign up or log in page by pressing related buttons
	public static void startPage() {
		frame.setBounds(20, 20, 1100, 700);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		panel.setBounds(0, 0, 1100, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel resim = new JLabel();
		Image img = new ImageIcon(Main.class.getResource("/start.png")).getImage();
		resim.setIcon(new ImageIcon(img));
		resim.setBounds(-50, 0, 1200, 700);

		JButton button1 = new JButton("LOGIN");
		button1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.LIGHT_GRAY);
		button1.setBounds(450, 350, 200, 75);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				login();

			}
		}

		);

		JButton button2 = new JButton("SIGN UP");
		button2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.LIGHT_GRAY);
		button2.setBounds(450, 450, 200, 75);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				signUp();

			}
		}

		);

		panel.add(button1);
		panel.add(button2);
		panel.add(resim);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// this function is used for log in operation of the system.
	// Log in operation is run with two inputs. If user enter right inputs to text
	// boxes, function sent user to home page.
	public static void login() {
		JLabel label1 = new JLabel();
		label1.setText("E-mail Address:");
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label1.setBounds(250, 320, 350, 20);

		JTextField mail = new JTextField();
		mail.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		mail.setBackground(Color.WHITE);
		mail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mail.setBounds(440, 322, 350, 20);

		JLabel label2 = new JLabel();
		label2.setText("          Password:");
		label2.setForeground(Color.black);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label2.setBounds(250, 355, 350, 20);

		final JPasswordField password = new JPasswordField();
		password.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setBounds(440, 357, 350, 20);
		password.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String e_mail = mail.getText();
					@SuppressWarnings("deprecation")
					String passw = password.getText();
					if (!m.logIn(String.valueOf(e_mail), String.valueOf(passw))) {
						JOptionPane.showMessageDialog(null, "INVALID INPUT! TRY AGAIN!", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Logged in successfully!", "INFORMATION",
								JOptionPane.INFORMATION_MESSAGE);
						panel.removeAll();
						panel.repaint();
						homePage();

					}
				}

			}
		});

		JButton button = new JButton("LOGIN");
		button.setFont(new Font("Times New Roman", Font.BOLD, 24));
		button.setBackground(Color.BLACK);
		button.setOpaque(false);
		button.setForeground(Color.black);
		button.setBorderPainted(false);
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				button.setOpaque(false);
				button.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				button.setOpaque(true);
				button.setBackground(Color.DARK_GRAY);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		button.setBounds(475, 400, 150, 50);

		JLabel resim = new JLabel();
		Image img = new ImageIcon(Main.class.getResource("/login.png")).getImage();
		resim.setIcon(new ImageIcon(img));
		resim.setBounds(-50, 0, 1200, 700);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String e_mail = mail.getText();
				@SuppressWarnings("deprecation")
				String passw = password.getText();
				if (!m.logIn(String.valueOf(e_mail), String.valueOf(passw))) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT! TRY AGAIN!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Logged in successfully!", "INFORMATION",
							JOptionPane.INFORMATION_MESSAGE);
					panel.removeAll();
					panel.repaint();
					homePage();

				}
			}
		});
		panel.add(label1);
		panel.add(mail);
		panel.add(label2);
		panel.add(password);
		panel.add(button);
		panel.add(resim);

	}

	// this function is used for sign up operation of the system.
	// with using necessary information of user, register operation is done. Some
	// warnings are showed when user inputs are wrong.
	// If all inputs are right and register operation is done, program return to
	// start page for user to log in.
	public static void signUp() {
		JLabel resim = new JLabel();
		Image img1 = new ImageIcon(Main.class.getResource("/signup.png")).getImage();
		resim.setIcon(new ImageIcon(img1));
		resim.setBounds(-50, 0, 1200, 700);
		int h = 30;

		JLabel name_label = new JLabel("Name: ");
		name_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		name_label.setForeground(Color.black);
		name_label.setBounds(10, 5, 200, h);
		JTextField name_text = new JTextField();
		name_text.addMouseListener(new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		name_text.setBackground(Color.white);
		name_text.setBounds(130, 5, 200, h);
		name_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		name_text.setOpaque(false);
		panel.add(name_label);
		panel.add(name_text);

		JLabel surname_label = new JLabel("Surname: ");
		surname_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		surname_label.setForeground(Color.black);
		surname_label.setBounds(10, 40, 200, h);
		JTextField surname_text = new JTextField();
		surname_text.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		surname_text.setBackground(Color.white);
		surname_text.setBounds(130, 40, 200, h);
		surname_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		surname_text.setOpaque(false);
		panel.add(surname_label);
		panel.add(surname_text);

		JLabel mail_label = new JLabel("Mail: ");
		mail_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		mail_label.setForeground(Color.black);
		mail_label.setBounds(10, 75, 200, h);
		JTextField mail_text = new JTextField();
		mail_text.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		mail_text.setBackground(Color.white);
		mail_text.setBounds(130, 75, 200, h);
		mail_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mail_text.setOpaque(false);
		panel.add(mail_label);
		panel.add(mail_text);

		JLabel password_label = new JLabel("Password: ");
		password_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		password_label.setForeground(Color.black);
		password_label.setBounds(10, 110, 200, h);
		panel.add(password_label);
		final JPasswordField pfPassword = new JPasswordField(20);
		pfPassword.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		pfPassword.setBounds(130, 110, 200, h);
		pfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		pfPassword.setOpaque(false);
		password_label.setLabelFor(pfPassword);
		panel.add(pfPassword);

		JLabel phone_label = new JLabel("Phone: ");
		phone_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		phone_label.setForeground(Color.black);
		phone_label.setBounds(10, 145, 200, h);

		JTextField phone_text1 = new JTextField(2);
		phone_text1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		phone_text1.setBackground(Color.white);
		phone_text1.setBounds(130, 145, 30, h);
		phone_text1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		phone_text1.setOpaque(false);
		JTextField phone_text2 = new JTextField(3);
		phone_text2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		phone_text2.setBackground(Color.white);
		phone_text2.setBounds(162, 145, 50, h);
		phone_text2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		phone_text2.setOpaque(false);
		JTextField phone_text3 = new JTextField(7);
		phone_text3.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		phone_text3.setBackground(Color.white);
		phone_text3.setBounds(214, 145, 70, h);
		phone_text3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		phone_text3.setOpaque(false);
		panel.add(phone_label);
		panel.add(phone_text1);
		panel.add(phone_text2);
		panel.add(phone_text3);

		JLabel address_label = new JLabel("City: ");
		address_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		address_label.setForeground(Color.black);
		address_label.setBounds(10, 180, 200, h);
		panel.add(address_label);
		JTextField city_text = new JTextField();
		city_text.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		city_text.setBackground(Color.white);
		city_text.setBounds(130, 180, 200, h);
		city_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		city_text.setOpaque(false);
		panel.add(city_text);

		address_label = new JLabel("Town: ");
		address_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		address_label.setForeground(Color.black);
		address_label.setBounds(10, 215, 200, h);
		panel.add(address_label);
		JTextField town_text = new JTextField();
		town_text.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		town_text.setBackground(Color.white);
		town_text.setBounds(130, 215, 200, h);
		town_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		town_text.setOpaque(false);
		panel.add(town_text);

		address_label = new JLabel("Address: ");
		address_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		address_label.setForeground(Color.black);
		address_label.setBounds(10, 250, 200, h);
		panel.add(address_label);
		JTextField address_text = new JTextField();
		address_text.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		address_text.setBackground(Color.white);
		address_text.setBounds(130, 250, 200, h);
		address_text.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		address_text.setOpaque(false);
		panel.add(address_text);

		JLabel interest_label = new JLabel("Interests: ");
		interest_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		interest_label.setForeground(Color.black);
		interest_label.setBounds(10, 285, 200, h);
		panel.add(interest_label);

		JTextField interest_text0 = new JTextField();
		interest_text0.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		interest_text0.setBackground(Color.white);
		interest_text0.setBounds(130, 285, 75, h);
		interest_text0.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		interest_text0.setOpaque(false);
		panel.add(interest_text0);
		JTextField interest_text1 = new JTextField();
		interest_text1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		interest_text1.setBackground(Color.white);
		interest_text1.setBounds(210, 285, 75, h);
		interest_text1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		interest_text1.setOpaque(false);
		panel.add(interest_text1);
		JTextField interest_text2 = new JTextField();
		interest_text2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		interest_text2.setBackground(Color.white);
		interest_text2.setBounds(290, 285, 75, h);
		interest_text2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		interest_text2.setOpaque(false);
		panel.add(interest_text2);
		JTextField interest_text3 = new JTextField();
		interest_text3.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		interest_text3.setBackground(Color.white);
		interest_text3.setBounds(370, 285, 75, h);
		interest_text3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		interest_text3.setOpaque(false);
		panel.add(interest_text3);
		JTextField interest_text4 = new JTextField();
		interest_text4.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		interest_text4.setBackground(Color.white);
		interest_text4.setBounds(450, 285, 75, h);
		interest_text4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		interest_text4.setOpaque(false);
		panel.add(interest_text4);

		JButton buttonOK = new JButton("SIGN UP");
		buttonOK.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonOK.setBackground(Color.BLACK);
		buttonOK.setOpaque(false);
		buttonOK.setForeground(Color.BLACK);
		buttonOK.setBorderPainted(false);
		buttonOK.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				buttonOK.setOpaque(false);
				buttonOK.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				buttonOK.setOpaque(true);
				buttonOK.setBackground(Color.pink);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		buttonOK.setBounds(425, 350, 250, 60);
		panel.add(buttonOK);

		buttonOK.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (!name_text.getText().equals("") && !surname_text.getText().equals("")
						&& !mail_text.getText().equals("") && !pfPassword.getText().equals("")
						&& !phone_text1.getText().equals("") && !phone_text2.getText().equals("")
						&& !phone_text3.getText().equals("") && !city_text.getText().equals("")
						&& !town_text.getText().equals("") && !address_text.getText().equals("")
						&& !interest_text0.getText().equals("") && !interest_text1.getText().equals("")
						&& !interest_text2.getText().equals("") && !interest_text3.getText().equals("")
						&& !interest_text4.getText().equals("")) {

					String name = name_text.getText();
					String surname = surname_text.getText();
					String mail = mail_text.getText();
					String password = pfPassword.getText();
					String phone = phone_text1.getText() + "-" + phone_text2.getText() + "-" + phone_text3.getText();
					String address = city_text.getText() + "," + town_text.getText() + "," + address_text.getText();
					String interest = interest_text0.getText() + "," + interest_text1.getText() + ","
							+ interest_text2.getText() + "," + interest_text3.getText() + ","
							+ interest_text4.getText();

					try {
						if (!m.signUp(name, surname, mail, password, phone, address, interest)) {
							JOptionPane.showMessageDialog(null, "This email address is taken already!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "You saved successfully! \nPlease log in!",
									"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
							panel.removeAll();
							panel.repaint();
							startPage();
						}
					} catch (IOException e) {
						System.out.println("catch!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL INFORMATION!", "WARNING",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		}

		);
		panel.add(resim);
	}

	// this function is used for display home page of the program.
	// this page of the program is the main page for accessing to all features of
	// application.
	// there is an 'all cities' button to display all cities in the program.
	// a search box has been implemented to display cities when its name is entered
	// to text box.
	// a profile button added to home page for users to see and change their profile
	// information.
	// there are three buttons to display popular cities in the program. when this
	// button is clicked, program will display the city's page.
	public static void homePage() {
		JLabel resim = new JLabel();
		Image img1 = new ImageIcon(Main.class.getResource("/homepage.png")).getImage();
		resim.setIcon(new ImageIcon(img1));
		resim.setBounds(-50, 0, 1200, 700);

		// PROFILE
		JButton buttonOK = new JButton("PROFILE");
		JLabel u_label = new JLabel();
		Image img2 = new ImageIcon(Main.class.getResource("/u.png")).getImage();
		u_label.setIcon(new ImageIcon(img2));
		u_label.setForeground(Color.black);
		u_label.setBounds(916, 12, 200, 20);
		panel.add(u_label);
		buttonOK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		// buttonOK.setBackground(Color.WHITE);
		buttonOK.setOpaque(false);
		buttonOK.setForeground(Color.black);
		buttonOK.setBounds(940, 10, 150, 24);
		panel.add(buttonOK);
		buttonOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				profile();
			}
		}

		);

		// SEARCH BUTTON
		JLabel search_label = new JLabel();
		Image img3 = new ImageIcon(Main.class.getResource("/s.png")).getImage();
		search_label.setIcon(new ImageIcon(img3));
		search_label.setForeground(Color.black);
		search_label.setBounds(15, 10, 200, 20);
		panel.add(search_label);
		JTextField search_text = new JTextField();
		search_text.setBackground(Color.WHITE);
		search_text.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		search_text.setBounds(45, 10, 150, 24);
		panel.add(search_text);

		search_text.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					test = false;
					city_Name = search_text.getText();
					for (int i = 0; i < Management.cities.size(); i++) {
						if (city_Name.equalsIgnoreCase(Management.cities.get(i).getCity_name())) {
							test = true;
						}
					}
					if (test) {
						panel.removeAll();
						panel.repaint();
						displayCity();
					} else
						JOptionPane.showMessageDialog(null, "No Result!", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// POPULAR CITIES
		JButton topCity1 = new JButton();
		img2 = new ImageIcon(Main.class.getResource("/istanbul.png")).getImage();
		topCity1.setIcon(new ImageIcon(img2));
		topCity1.setBounds(220, 420, 180, 75);
		panel.add(topCity1);
		JLabel c1 = new JLabel("ÝSTANBUL");
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setForeground(Color.black);
		c1.setBounds(265, 500, 100, 20);
		panel.add(c1);
		topCity1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				city_Name = "Ýstanbul";
				panel.removeAll();
				panel.repaint();
				displayCity();
			}
		}

		);
		JButton topCity2 = new JButton();
		img2 = new ImageIcon(Main.class.getResource("/ankara.png")).getImage();
		topCity2.setIcon(new ImageIcon(img2));
		topCity2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		topCity2.setBackground(Color.WHITE);
		topCity2.setForeground(Color.black);
		topCity2.setBounds(460, 420, 180, 75);
		panel.add(topCity2);
		JLabel c2 = new JLabel("ANKARA");
		c2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c2.setForeground(Color.black);
		c2.setBounds(500, 500, 100, 20);
		panel.add(c2);
		topCity2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				city_Name = "Ankara";
				panel.removeAll();
				panel.repaint();
				displayCity();
			}
		}

		);
		JButton topCity3 = new JButton();
		img2 = new ImageIcon(Main.class.getResource("/izmir.png")).getImage();
		topCity3.setIcon(new ImageIcon(img2));
		topCity3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		topCity3.setBackground(Color.WHITE);
		topCity3.setForeground(Color.black);
		topCity3.setBounds(700, 420, 180, 75);
		panel.add(topCity3);
		JLabel c3 = new JLabel("ÝZMÝR");
		c3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c3.setForeground(Color.black);
		c3.setBounds(760, 500, 100, 20);
		panel.add(c3);
		topCity3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				city_Name = "Ýzmir";
				panel.removeAll();
				panel.repaint();
				displayCity();
			}
		}

		);

		// DISPLAY ALL CITIES
		JButton all_cities = new JButton("ALL CITIES");
		all_cities.setFont(new Font("Times New Roman", Font.BOLD, 20));
		all_cities.setOpaque(false);
		all_cities.setForeground(Color.black);
		all_cities.setBounds(890, 640, 200, 24);
		panel.add(all_cities);
		all_cities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				allCities();
			}
		}

		);

		panel.add(resim);

	}

	// this function is used for display profile page of the program.
	// users' general information are displayed in this page of the program.
	// there is a settings button to allow users for changing their information.
	public static void profile() {
		Person logged = null;
		for (Person person : Management.users) {
			if (person.getClass().getSimpleName().equalsIgnoreCase("admin")) {
				if (m.logged[2].equalsIgnoreCase(((Admin) person).getMail())) {
					logged = person;
				}
			} else if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
				if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
					logged = person;
				}
			}
		}

		if (logged.getClass().getSimpleName().equalsIgnoreCase("User")) {
			JLabel name_label = new JLabel("Name: ");
			name_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			name_label.setBounds(10, 30, 200, 30);
			name_label.setForeground(Color.BLACK);
			panel.add(name_label);
			JLabel name_text = new JLabel(((User) logged).getName());
			name_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			name_text.setBounds(100, 30, 200, 30);
			name_text.setForeground(Color.BLACK);
			panel.add(name_text);

			JLabel surname_label = new JLabel("Surname: ");
			surname_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			surname_label.setBounds(10, 65, 200, 30);
			surname_label.setForeground(Color.BLACK);
			panel.add(surname_label);
			JLabel surname_text = new JLabel(((User) logged).getSurname());
			surname_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			surname_text.setBounds(100, 65, 200, 30);
			surname_text.setForeground(Color.BLACK);
			panel.add(surname_text);

			JLabel mail_label = new JLabel("Mail: ");
			mail_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			mail_label.setBounds(10, 100, 200, 30);
			mail_label.setForeground(Color.BLACK);
			panel.add(mail_label);
			JLabel mail_text = new JLabel(((User) logged).getMail());
			mail_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			mail_text.setBounds(100, 100, 200, 30);
			mail_text.setForeground(Color.BLACK);
			panel.add(mail_text);

			JLabel phone_label = new JLabel("Phone: ");
			phone_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			phone_label.setBounds(10, 135, 200, 30);
			phone_label.setForeground(Color.BLACK);
			panel.add(phone_label);
			JLabel phone_text = new JLabel(((User) logged).getPhone().toString());
			phone_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			phone_text.setBounds(100, 135, 200, 30);
			phone_text.setForeground(Color.BLACK);
			panel.add(phone_text);

			JLabel address_label = new JLabel("Address: ");
			address_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			address_label.setBounds(10, 170, 200, 30);
			address_label.setForeground(Color.BLACK);
			panel.add(address_label);
			String address = ((User) logged).getAddress().getAddress() + " " + ((User) logged).getAddress().getTown()
					+ "/" + ((User) logged).getAddress().getCity();
			JLabel address_text = new JLabel(address);
			address_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			address_text.setBounds(100, 170, 500, 30);
			address_text.setForeground(Color.BLACK);
			panel.add(address_text);

			JLabel interest_label = new JLabel("Interests:");
			interest_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			interest_label.setBounds(10, 205, 200, 30);
			interest_label.setForeground(Color.BLACK);
			panel.add(interest_label);
			String interests = "";
			for (String intr : ((User) logged).getInterest()) {
				interests += " " + intr;
			}
			JLabel interest_text = new JLabel(interests);
			interest_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			interest_text.setBounds(100, 205, 200, 30);
			interest_text.setForeground(Color.BLACK);
			panel.add(interest_text);

			JLabel fav_place_label = new JLabel("Fav Places: ");
			fav_place_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			fav_place_label.setBounds(10, 240, 200, 30);
			fav_place_label.setForeground(Color.BLACK);
			panel.add(fav_place_label);
			String fav_place = "";
			for (Place place : ((User) logged).getFav_place()) {
				fav_place += " " + place.getName();
			}
			JLabel fav_place_text = new JLabel(fav_place);
			fav_place_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			fav_place_text.setBounds(102, 240, 850, 30);
			fav_place_text.setForeground(Color.BLACK);
			panel.add(fav_place_text);

			JLabel setting_text = new JLabel("SETTINGS");
			setting_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			setting_text.setBounds(500, 330, 100, 30);
			setting_text.setForeground(Color.BLACK);
			panel.add(setting_text);
			JComboBox<String> settings = new JComboBox<String>();
			settings.setFont(new Font("Times New Roman", Font.BOLD, 20));
			settings.setBounds(475, 370, 150, 30);
			settings.addItem("Name");
			settings.addItem("Surname");
			settings.addItem("Mail");
			settings.addItem("Password");
			settings.addItem("Phone");
			settings.addItem("Address");
			panel.add(settings);
			settings.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (settings.getSelectedItem().equals("Name")) {
						String name = JOptionPane.showInputDialog("Please enter your new name: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), name);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Surname")) {
						String surname = JOptionPane.showInputDialog("Please enter your new surname: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), surname);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Mail")) {
						String mail = JOptionPane.showInputDialog("Please enter your new mail: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), mail);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Password")) {
						String password = JOptionPane.showInputDialog("Please enter your new password: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), password);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Phone")) {
						String phone1 = JOptionPane.showInputDialog("Please enter your new country code: ");
						String phone2 = JOptionPane.showInputDialog("Please enter your new phone code: ");
						String phone3 = JOptionPane.showInputDialog("Please enter your new number: ");
						String phone = phone1 + "-" + phone2 + "-" + phone3;
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), phone);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Address")) {
						String city = JOptionPane.showInputDialog("Please enter your new city: ");
						String town = JOptionPane.showInputDialog("Please enter your new town: ");
						String address = JOptionPane.showInputDialog("Please enter your new address: ");
						String last = address + "," + town + "," + city;
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")) {
								if (m.logged[2].equalsIgnoreCase(((User) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), last);
									} catch (IOException e) {
									}
								}
							}
						}
					}

				}

			});

		}

		if (logged.getClass().getSimpleName().equalsIgnoreCase("Admin")) {
			JLabel name_label = new JLabel("Name: ");
			name_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			name_label.setBounds(10, 30, 200, 30);
			name_label.setForeground(Color.BLACK);
			panel.add(name_label);
			JLabel name_text = new JLabel(((Admin) logged).getName());
			name_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			name_text.setBounds(100, 30, 200, 30);
			name_text.setForeground(Color.BLACK);
			panel.add(name_text);

			JLabel surname_label = new JLabel("Surname: ");
			surname_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			surname_label.setBounds(10, 65, 200, 30);
			surname_label.setForeground(Color.BLACK);
			panel.add(surname_label);
			JLabel surname_text = new JLabel(((Admin) logged).getSurname());
			surname_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			surname_text.setBounds(100, 65, 200, 30);
			surname_text.setForeground(Color.BLACK);
			panel.add(surname_text);

			JLabel mail_label = new JLabel("Mail: ");
			mail_label.setFont(new Font("Times New Roman", Font.BOLD, 20));
			mail_label.setBounds(10, 100, 200, 30);
			mail_label.setForeground(Color.BLACK);
			panel.add(mail_label);
			JLabel mail_text = new JLabel(((Admin) logged).getMail());
			mail_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			mail_text.setBounds(100, 100, 200, 30);
			mail_label.setForeground(Color.BLACK);
			panel.add(mail_text);

			JLabel setting_text = new JLabel("SETTINGS");
			setting_text.setFont(new Font("Times New Roman", Font.BOLD, 20));
			setting_text.setBounds(500, 330, 100, 30);
			setting_text.setForeground(Color.BLACK);
			panel.add(setting_text);
			JComboBox<String> settings = new JComboBox<String>();
			settings.setFont(new Font("Times New Roman", Font.BOLD, 20));
			settings.setBounds(475, 370, 150, 30);
			settings.addItem("Name");
			settings.addItem("Surname");
			settings.addItem("Mail");
			settings.addItem("Password");
			panel.add(settings);
			settings.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (settings.getSelectedItem().equals("Name")) {
						String name = JOptionPane.showInputDialog("Please enter your new name: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("admin")) {
								if (m.logged[2].equalsIgnoreCase(((Admin) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), name);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Surname")) {
						String surname = JOptionPane.showInputDialog("Please enter your new surname: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("admin")) {
								if (m.logged[2].equalsIgnoreCase(((Admin) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), surname);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Mail")) {
						String mail = JOptionPane.showInputDialog("Please enter your new mail: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("admin")) {
								if (m.logged[2].equalsIgnoreCase(((Admin) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), mail);
									} catch (IOException e) {
									}
								}
							}
						}
					} else if (settings.getSelectedItem().equals("Password")) {
						String password = JOptionPane.showInputDialog("Please enter your new password: ");
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("admin")) {
								if (m.logged[2].equalsIgnoreCase(((Admin) person).getMail())) {
									try {
										m.setBool(true, (String) settings.getSelectedItem(), password);
									} catch (IOException e) {
									}
								}
							}
						}
					}

				}

			});

		}

		JLabel resim = new JLabel();
		Image background = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(background));
		resim.setBounds(-50, 0, 1200, 700);

		JButton back = new JButton();
		back.setBackground(Color.BLACK);
		Image img = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBounds(2, 640, 27, 27);
		back.setOpaque(false);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				homePage();
			}
		});
		panel.add(resim);
	}

	// this function is used for display city page of the program.
	// cities' general information are displayed in this page of the program.
	// a show all places button added to this page for users to see all places in
	// the city that they are looking at.
	// there is a combo box for filter feature of the places. when user choose one
	// of the facilities, if this facility exists in the place, it will be shown.
	// there are three buttons to display different kinds of places in the program.
	// when this button is clicked, program will display related places.
	public static void displayCity() {

		JTextPane cityName = new JTextPane();
		cityName.setText(city_Name.toUpperCase());
		cityName.setEditable(false);
		cityName.setOpaque(false);
		cityName.setForeground(Color.BLACK);
		cityName.setFont(new Font("Times New Roman", Font.BOLD, 50));
		cityName.setBounds(300, 40, 500, 100);
		StyledDocument style = cityName.getStyledDocument();
		SimpleAttributeSet align = new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
		style.setParagraphAttributes(0, style.getLength(), align, false);

		String information_city = "";
		for (int i = 0; i < Management.cities.size(); i++) {
			if (Management.cities.get(i).getCity_name().equalsIgnoreCase(city_Name)) {
				information_city = Management.cities.get(i).getInformation();
			}
		}

		JTextPane information = new JTextPane();
		information.setText(information_city);
		information.setForeground(Color.BLACK);
		information.setOpaque(false);
		information.setFont(new Font("Times New Roman", Font.BOLD, 20));
		information.setBounds(350, 130, 400, 275);
		style = information.getStyledDocument();
		align = new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
		style.setParagraphAttributes(0, style.getLength(), align, false);

		JButton accommodation = new JButton("Accommodation");
		Image img1 = new ImageIcon(Main.class.getResource("/accommodation.png")).getImage();
		accommodation.setIcon(new ImageIcon(img1));
		accommodation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		accommodation.setBackground(Color.WHITE);
		accommodation.setForeground(Color.BLACK);
		accommodation.setBounds(210, 440, 160, 70);
		JLabel c1 = new JLabel("Accommodation");
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setForeground(Color.black);
		c1.setBounds(225, 512, 150, 20);
		panel.add(c1);

		accommodation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.sortbyPrice(city_Name, "Accommodation");
				type="Accommodation";
				panel.removeAll();
				panel.repaint();
				displayType(type);
			}
		});

		JButton FoodAndDrink = new JButton("FoodAndDrink");
		Image img2 = new ImageIcon(Main.class.getResource("/foodanddrink.png")).getImage();
		FoodAndDrink.setIcon(new ImageIcon(img2));
		FoodAndDrink.setFont(new Font("Times New Roman", Font.BOLD, 20));
		FoodAndDrink.setBackground(Color.WHITE);
		FoodAndDrink.setForeground(Color.BLACK);
		FoodAndDrink.setBounds(470, 440, 160, 70);
		JLabel c2 = new JLabel("Food And Drink");
		c2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c2.setForeground(Color.black);
		c2.setBounds(485, 512, 150, 20);
		panel.add(c2);

		FoodAndDrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.sortbyPrice(city_Name, "FoodAndDrink");
				type="foodanddrink";
				panel.removeAll();
				panel.repaint();
				displayType(type);
			}
		});

		JButton TravelToVisit = new JButton("TravelToVisit");
		Image img3 = new ImageIcon(Main.class.getResource("/traveltovisit.png")).getImage();
		TravelToVisit.setIcon(new ImageIcon(img3));
		TravelToVisit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TravelToVisit.setBackground(Color.WHITE);
		TravelToVisit.setForeground(Color.BLACK);
		TravelToVisit.setBounds(730, 440, 160, 70);
		JLabel c3 = new JLabel("TravelToVisit");
		c3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c3.setForeground(Color.black);
		c3.setBounds(760, 512, 150, 20);
		panel.add(c3);

		TravelToVisit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.sortbyPrice(city_Name, "TravelToVisit");
				type="traveltovisit";
				panel.removeAll();
				panel.repaint();
				displayType(type);
			}
		});

		JButton all_places = new JButton("Show All Places");
		all_places.setFont(new Font("Times New Roman", Font.BOLD, 17));
		all_places.setBackground(Color.WHITE);
		all_places.setForeground(Color.BLACK);
		all_places.setBounds(2, 4, 200, 25);

		all_places.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.allPlaces(city_Name);
				panel.removeAll();
				panel.repaint();
				displayAllPlacesorFilters();
			}
		});

		JButton back = new JButton();
		Image imgback = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(imgback));
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBackground(Color.BLACK);
		back.setOpaque(false);
		back.setBounds(2, 640, 27, 27);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				if (control == 3)
					allCities();
				else
					homePage();
			}
		});

		JComboBox<String> facilities = new JComboBox<String>();
		facilities.setFont(new Font("Times New Roman", Font.BOLD, 18));
		facilities.setBackground(Color.WHITE);
		facilities.setForeground(Color.BLACK);
		facilities.setBounds(940, 4, 150, 25);
		facilities.addItem("Age Limit");
		facilities.addItem("Wi-Fi");
		facilities.addItem("Parking Place");
		facilities.addItem("Smoking");
		facilities.addItem("Pet Allowed");

		facilities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.searchFacilities(String.valueOf(city_Name), String.valueOf(facilities.getSelectedItem()));
				panel.removeAll();
				panel.repaint();
				displayAllPlacesorFilters();
			}
		});

		JLabel resim = new JLabel();
		Image img = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(img));
		resim.setBounds(-50, 0, 1200, 700);

		panel.add(cityName);
		panel.add(information);
		panel.add(accommodation);
		panel.add(FoodAndDrink);
		panel.add(TravelToVisit);
		panel.add(all_places);
		panel.add(facilities);
		panel.add(back);
		panel.add(resim);

	}

	// this function within the displayCity function works with the allPlaces button
	// and facilities selection.
	public static void displayAllPlacesorFilters() {
		JLabel cityName = new JLabel(city_Name.toUpperCase());
		cityName.setFont(new Font("Times New Roman", Font.BOLD, 40));
		cityName.setBounds(40, 2, 250, 50);
		panel.add(cityName);
		int y = 40;

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					panel.removeAll();
					panel.repaint();
					control = 2;
					displayPlaces(((JButton) e.getSource()).getText());
				}
			}
		};

		JButton[] buttons = new JButton[Management.search.size()];

		for (int i = 0; i < Management.search.size(); i++) {
			buttonfor = 0;
			y += 40;

			buttons[buttonfor] = new JButton(String.valueOf(Management.search.get(i).getName()));
			buttons[buttonfor].setFont(new Font("Times New Roman", Font.BOLD, 18));
			buttons[buttonfor].setForeground(Color.BLACK);
			buttons[buttonfor].setOpaque(false);
			buttons[buttonfor].setBounds(40, y, 250, 30);

			buttons[buttonfor].addActionListener(listener);

			JLabel address = new JLabel();
			address.setText(Management.search.get(i).getAddress().toString() + " "
					+ Management.search.get(i).getPhone().toString());
			address.setFont(new Font("Times New Roman", Font.BOLD, 20));
			address.setBounds(310, y, 550, 30);
			panel.add(address);
			panel.add(buttons[buttonfor]);
		}

		JButton back = new JButton();
		back.setBackground(Color.BLACK);
		Image img = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBounds(2, 640, 27, 27);
		back.setOpaque(false);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				displayCity();
			}
		});

		JLabel resim = new JLabel();
		Image background = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(background));
		resim.setBounds(-50, 0, 1200, 700);
		panel.add(resim);

	}

	// it contains the names of all cities.
	// if you click it, it opens the information of that city.
	public static void allCities() {
		JLabel resim = new JLabel();
		Image background = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(background));
		resim.setBounds(-50, 0, 1200, 700);
		int x = 20;
		int y = 50;
		int counter = 2;

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					panel.removeAll();
					panel.repaint();
					city_Name = ((JButton) e.getSource()).getText();
					control = 3;
					displayCity();
				}
			}
		};
		JButton[] buttons = new JButton[Management.cities.size()];

		for (int i = 0; i < Management.cities.size(); i++) {
			buttonfor = 0;
			if (counter == 17) {
				counter = 0;
				x += 205;
				y = 50;
			}

			buttons[buttonfor] = new JButton(String.valueOf(Management.cities.get(i).getCity_name()));
			buttons[buttonfor].setFont(new Font("Times New Roman", Font.BOLD, 20));
			buttons[buttonfor].setForeground(Color.BLACK);
			buttons[buttonfor].setBackground(Color.BLACK);
			buttons[buttonfor].setOpaque(false);
			buttons[buttonfor].setBounds(x, y, 200, 25);

			buttons[buttonfor].addActionListener(listener);

			panel.add(buttons[buttonfor]);
			counter++;

			y += 30;
		}

		JButton back = new JButton();
		back.setBackground(Color.BLACK);
		Image img = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBounds(2, 640, 27, 27);
		back.setOpaque(false);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				homePage();
			}
		});

		panel.add(resim);
	}

	// this function on the city page lists places by type
	// there is also an add place button for administrators.
	public static void displayType(String type) {
		JLabel cityName = new JLabel();
		cityName.setText(city_Name.toUpperCase());
		cityName.setFont(new Font("Times New Roman", Font.BOLD, 40));
		cityName.setBounds(40, 2, 250, 50);
		panel.add(cityName);
		int y = 40;

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					panel.removeAll();
					panel.repaint();
					control = 1;
					displayPlaces(((JButton) e.getSource()).getText());
				}
			}
		};

		JButton[] buttons = new JButton[Management.places_q.size()];

		while (!Management.places_q.isEmpty()) {
			buttonfor = 0;
			y += 40;
			buttons[buttonfor] = new JButton(String.valueOf(Management.places_q.peek().getName()));
			buttons[buttonfor].setFont(new Font("Times New Roman", Font.BOLD, 18));
			buttons[buttonfor].setForeground(Color.BLACK);
			buttons[buttonfor].setOpaque(false);
			buttons[buttonfor].setBounds(40, y, 250, 30);

			buttons[buttonfor].addActionListener(listener);

			JLabel address = new JLabel();
			address.setText(Management.places_q.peek().getAddress().toString() + " "
					+ Management.places_q.peek().getPhone().toString());
			address.setFont(new Font("Times New Roman", Font.BOLD, 20));
			address.setBounds(310, y, 550, 30);
			panel.add(address);

			Management.temp.add(Management.places_q.remove());
			panel.add(buttons[buttonfor]);

		}

		while (!Management.temp.isEmpty()) {
			Management.places_q.add(Management.temp.remove());
		}

		JButton back = new JButton();
		back.setBackground(Color.BLACK);
		Image img = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBounds(2, 640, 27, 27);
		back.setOpaque(false);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				displayCity();
			}
		});

		if (m.logged[0].equalsIgnoreCase("admin")) {
			JButton addPlace = new JButton("ADD PLACE");
			addPlace.setBackground(Color.BLACK);
			addPlace.setForeground(Color.WHITE);
			addPlace.setFont(new Font("Times New Roman", Font.BOLD, 16));
			addPlace.setBounds(920, 640, 150, 27);
			panel.add(addPlace);

			addPlace.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (type.equalsIgnoreCase("traveltovisit")) {
						String name = JOptionPane.showInputDialog("Please enter place's name: ");
						String addr1 = JOptionPane.showInputDialog("Please enter place's address: ");
						String addr2 = JOptionPane.showInputDialog("Please enter place's town: ");
						String addr3 = JOptionPane.showInputDialog("Please enter place's city: ");
						String addr = addr1 + "," + addr2 + "," + addr3;
						String pho1 = JOptionPane.showInputDialog("Please enter place's country code: ");
						String pho2 = JOptionPane.showInputDialog("Please enter place's phone code: ");
						String pho3 = JOptionPane.showInputDialog("Please enter place's phone number: ");
						String pho = pho1 + "-" + pho2 + "-" + pho3;
						String season = JOptionPane.showInputDialog("Which season is convenient for this place: ");
						String information = JOptionPane.showInputDialog("Please enter information about the place: ");
						String price = JOptionPane.showInputDialog("Please enter an integer price for the place: ");
						String distance_to_center = JOptionPane
								.showInputDialog("Please enter distance of the place to center: ");
						String facilities1 = JOptionPane.showInputDialog("Is there age limit in the place? (yes/no): ");
						String facilities2 = JOptionPane.showInputDialog("Free wi-fi available? (yes/no): ");
						String facilities3 = JOptionPane.showInputDialog("Is there any parking place? (yes/no): ");
						String facilities4 = JOptionPane.showInputDialog("Smoking? (yes/no): ");
						String facilities5 = JOptionPane.showInputDialog("Are pets allowed? (yes/no): ");
						String facilities = facilities1 + "," + facilities2 + "," + facilities3 + "," + facilities4
								+ "," + facilities5;
						String rate = JOptionPane.showInputDialog("Please enter your rate to this place: ");
						try {
							m.addPlaces(name, type, addr, pho, season, information, Integer.valueOf(price),Integer.valueOf(distance_to_center) , facilities, Integer.valueOf(rate), "", 0);
							JOptionPane.showMessageDialog(null,
									"The place added successfully! for display this place restart the app.",
									"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException | IOException e) {
						}
					} else if (type.equalsIgnoreCase("foodanddrink")) {
						String name = JOptionPane.showInputDialog("Please enter place's name: ");
						String addr1 = JOptionPane.showInputDialog("Please enter place's address: ");
						String addr2 = JOptionPane.showInputDialog("Please enter place's town: ");
						String addr3 = JOptionPane.showInputDialog("Please enter place's city: ");
						String addr = addr1 + "," + addr2 + "," + addr3;
						String pho1 = JOptionPane.showInputDialog("Please enter place's country code: ");
						String pho2 = JOptionPane.showInputDialog("Please enter place's phone code: ");
						String pho3 = JOptionPane.showInputDialog("Please enter place's phone number: ");
						String pho = pho1 + "-" + pho2 + "-" + pho3;
						String price = JOptionPane
								.showInputDialog("Please enter a price for the place(cheap/medium/expensive): ");
						String facilities1 = JOptionPane.showInputDialog("Is there age limit in the place? (yes/no): ");
						String facilities2 = JOptionPane.showInputDialog("Free wi-fi available? (yes/no): ");
						String facilities3 = JOptionPane.showInputDialog("Is there any parking place? (yes/no): ");
						String facilities4 = JOptionPane.showInputDialog("Smoking? (yes/no): ");
						String facilities5 = JOptionPane.showInputDialog("Are pets allowed? (yes/no): ");
						String facilities = facilities1 + "," + facilities2 + "," + facilities3 + "," + facilities4
								+ "," + facilities5;
						String rate = JOptionPane.showInputDialog("Please enter your rate to this place: ");
						try {
							m.addPlaces(name, type, addr, pho, "", "", 0,0 , facilities, Integer.valueOf(rate), price, 0);

							JOptionPane.showMessageDialog(null,
									"The place added successfully! for display this place restart the app.",
									"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException | IOException e) {
						}
					} else {
						String name = JOptionPane.showInputDialog("Please enter place's name: ");
						String addr1 = JOptionPane.showInputDialog("Please enter place's address: ");
						String addr2 = JOptionPane.showInputDialog("Please enter place's town: ");
						String addr3 = JOptionPane.showInputDialog("Please enter place's city: ");
						String addr = addr1 + "," + addr2 + "," + addr3;
						String pho1 = JOptionPane.showInputDialog("Please enter place's country code: ");
						String pho2 = JOptionPane.showInputDialog("Please enter place's phone code: ");
						String pho3 = JOptionPane.showInputDialog("Please enter place's phone number: ");
						String pho = pho1 + "-" + pho2 + "-" + pho3;
						String price = JOptionPane
								.showInputDialog("Please enter a price for the place(cheap/medium/expensive): ");
						String rate = JOptionPane.showInputDialog("Please enter place's star: ");
						try {
		
							m.addPlaces(name, type, addr, pho, "", "", 0,0 , "", Integer.valueOf(rate), price, Integer.valueOf(rate));
							JOptionPane.showMessageDialog(null,
									"The place added successfully! for display this place restart the app.",
									"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException | IOException e) {
						}
					}
				}
			});
		}

		JLabel resim = new JLabel();
		Image background = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(background));
		resim.setBounds(-50, 0, 1200, 700);
		panel.add(resim);

	}

	// this page displays information about the place.
	// there are also comments and add comment button.
	// there is also a favorite add button.
	public static void displayPlaces(String place_name) {
		City c = null;
		JLabel placeName = new JLabel();
		placeName.setText(place_name.toUpperCase());
		placeName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		placeName.setBounds(50, 2, 500, 50);
		panel.add(placeName);
		String general_information = "";
		String information_place = "";
		String comment_text = "";
		boolean[] facilityAr = null;

		for (int i = 0; i < Management.cities.size(); i++) {
			if (Management.cities.get(i).getCity_name().equalsIgnoreCase(city_Name)) {
				c = Management.cities.get(i);
			}
		}

		for (Place place : c.getPlaces()) {
			if (place.getName().equals(place_name)) {
				if (place.getType().equalsIgnoreCase("traveltovisit")) {
					type = "traveltovisit";
					facilityAr = ((TravelToVisit) place).getFacilities();
					String facilities = "";
					facilities += "Age Limit - " + facilityAr[0] + "\nWi-Fi - " + facilityAr[1] + "\nParking Place - "
							+ facilityAr[2] + "\nSmoking - " + facilityAr[3] + "\nPet Allowed - " + facilityAr[4];
					general_information = ((TravelToVisit) place).getInformation();
					information_place = "Address: " + place.getAddress().toString() + "\nPhone: "
							+ place.getPhone().toString() + "\nPrice: " + ((TravelToVisit) place).getPrice()
							+ "\nDistance to Center: " + ((TravelToVisit) place).getDistance_to_center()
							+ "\nFacilities: " + facilities + "\nRates: " + ((TravelToVisit) place).getRates();
					for (String[] comment : ((TravelToVisit) place).getComments()) {
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")
									&& ((User) person).getUser_id() == Integer.valueOf(comment[0])) {
								comment_text += ((User) person).getName().toUpperCase() + ": " + comment[1] + "\n";
							}
						}
					}
					JLabel labelcomments = new JLabel();
					labelcomments.setText("COMMENTS");
					labelcomments.setFont(new Font("Times New Roman", Font.BOLD, 18));
					labelcomments.setBounds(850, 68, 200, 20);
					panel.add(labelcomments);

					JTextPane comments = new JTextPane();
					comments.setText(comment_text);
					comments.setEditable(false);
					comments.setOpaque(false);
					comments.setFont(new Font("Times New Roman", Font.BOLD, 12));
					comments.setBounds(850, 85, 150, 500);
					StyledDocument style = comments.getStyledDocument();
					SimpleAttributeSet align = new SimpleAttributeSet();
					StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
					style.setParagraphAttributes(0, style.getLength(), align, false);
					panel.add(comments);

					JTextPane info = new JTextPane();
					info.setText(general_information);
					info.setEditable(false);
					info.setOpaque(false);
					info.setFont(new Font("Times New Roman", Font.BOLD, 16));
					info.setBounds(50, 75, 500, 160);
					style = info.getStyledDocument();
					align = new SimpleAttributeSet();
					StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
					style.setParagraphAttributes(0, style.getLength(), align, false);
					panel.add(info);

					if (m.logged[0].equalsIgnoreCase("user")) {
						JButton add_comment = new JButton("ADD COMMENT");
						add_comment.setBackground(Color.BLACK);
						add_comment.setFont(new Font("Times New Roman", Font.BOLD, 16));
						add_comment.setBounds(850, 600, 200, 50);
						add_comment.setOpaque(false);
						panel.add(add_comment);

						add_comment.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								String comment = JOptionPane.showInputDialog("Please enter your comment: ");
								try {
									m.addComment(place_name, comment);
									for (Person person : Management.users) {
										if (person.getClass().getSimpleName().equalsIgnoreCase("user")
												&& ((User) person).getUser_id() == Integer.valueOf(m.logged[1])
												&& !comment.equals("")) {
											comments.setText(comments.getText() + ((User) person).getName() + ": "
													+ comment + "\n");

										}
									}
								} catch (IOException e) {
									panel.add(comments);
								}

							}
						});
					}
				}

				else if (place.getType().equalsIgnoreCase("foodanddrink")) {
					type = "foodanddrink";
					facilityAr = ((FoodAndDrink) place).getFacilities();
					String facilities = "";
					facilities += "Age Limit - " + facilityAr[0] + "\nWi-Fi - " + facilityAr[1] + "\nParking Place - "
							+ facilityAr[2] + "\nSmoking - " + facilityAr[3] + "\nPet Allowed - " + facilityAr[4];
					information_place = "Address: " + place.getAddress().toString() + "\nPhone: "
							+ place.getPhone().toString() + "\nPrice Range: " + ((FoodAndDrink) place).getPrice_range()
							+ "\nFacilities: " + facilities + "\nRates: " + ((FoodAndDrink) place).getRates();
					for (String[] comment : ((FoodAndDrink) place).getComments()) {
						for (Person person : Management.users) {
							if (person.getClass().getSimpleName().equalsIgnoreCase("user")
									&& ((User) person).getUser_id() == Integer.valueOf(comment[0])) {
								comment_text += ((User) person).getName().toUpperCase() + ": " + comment[1] + "\n";
							}
						}
					}
					JLabel labelcomments = new JLabel();
					labelcomments.setText("COMMENTS");
					labelcomments.setFont(new Font("Times New Roman", Font.BOLD, 18));
					labelcomments.setBounds(850, 68, 200, 20);
					panel.add(labelcomments);

					JTextPane comments = new JTextPane();
					comments.setText(comment_text);
					comments.setEditable(false);
					comments.setOpaque(false);
					comments.setFont(new Font("Times New Roman", Font.BOLD, 12));
					comments.setBounds(850, 85, 150, 500);
					StyledDocument style = comments.getStyledDocument();
					SimpleAttributeSet align = new SimpleAttributeSet();
					StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
					style.setParagraphAttributes(0, style.getLength(), align, false);
					panel.add(comments);

					if (m.logged[0].equalsIgnoreCase("user")) {
						JButton add_comment = new JButton("ADD COMMENT");
						add_comment.setBackground(Color.BLACK);
						add_comment.setFont(new Font("Times New Roman", Font.BOLD, 16));
						add_comment.setBounds(850, 600, 200, 50);
						add_comment.setOpaque(false);
						panel.add(add_comment);

						add_comment.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								String comment = JOptionPane.showInputDialog("Please enter your comment: ");
								try {
									m.addComment(place_name, comment);
									for (Person person : Management.users) {
										if (person.getClass().getSimpleName().equalsIgnoreCase("user")
												&& ((User) person).getUser_id() == Integer.valueOf(m.logged[1])
												&& !comment.equals("")) {
											comments.setText(comments.getText()
													+ ((User) person).getName().toUpperCase() + ": " + comment + "\n");
										}
									}
								} catch (IOException e) {

									panel.add(comments);
								}

							}
						});
					}
				} else {
					type = "accommodation";
					information_place = "Address: " + place.getAddress().toString() + "\nPhone: "
							+ place.getPhone().toString() + "\nPrice Range: " + ((Accommodation) place).getPrice_range()
							+ "\nStar: " + ((Accommodation) place).getStar();

				}
			}
		}

		JLabel labelinfo = new JLabel();
		labelinfo.setText("INFORMATION:");
		labelinfo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		if (!type.equals("traveltovisit")) {

			labelinfo.setBounds(50, 75, 150, 18);
		} else
			labelinfo.setBounds(50, 300, 150, 18);

		panel.add(labelinfo);

		JTextPane information = new JTextPane();
		information.setText(information_place);
		information.setEditable(false);
		information.setOpaque(false);
		information.setFont(new Font("Times New Roman", Font.BOLD, 14));
		if (!type.equals("traveltovisit")) {

			information.setBounds(120, 75, 500, 160);
		} else
			information.setBounds(100, 300, 500, 160);

		StyledDocument style = information.getStyledDocument();
		SimpleAttributeSet align = new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
		style.setParagraphAttributes(0, style.getLength(), align, false);
		panel.add(information);

		JButton fav_place = new JButton();
		fav_place.setBackground(Color.BLACK);
		Image img = new ImageIcon(Main.class.getResource("/fav.png")).getImage();
		fav_place.setIcon(new ImageIcon(img));
		fav_place.setBounds(1000, 8, 25, 25);
		fav_place.setOpaque(false);
		panel.add(fav_place);

		fav_place.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					m.favPlace(true, place_name);
					JOptionPane.showMessageDialog(null, "This place added to your favourite places", "INFORMATION",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
				}
			}
		});

		JButton back = new JButton();
		back.setBackground(Color.BLACK);
		img = new ImageIcon(Main.class.getResource("/b.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setBounds(2, 640, 27, 27);
		back.setOpaque(false);
		panel.add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				if (control == 1)
					displayType(type);
				else if (control == 2)
					displayAllPlacesorFilters();
			}
		});

		JLabel resim = new JLabel();
		Image background = new ImageIcon(Main.class.getResource("/back0.png")).getImage();
		resim.setIcon(new ImageIcon(background));
		resim.setBounds(-50, 0, 1200, 700);
		panel.add(resim);
	}

}
