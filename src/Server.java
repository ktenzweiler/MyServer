import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Server extends JFrame {

	private JPanel contentPane;
	private static ServerSocket serverSocket;
	private static BufferedReader bufferedReader;
	private static Socket socket;
	private static InputStreamReader inputStreamReader;
	private static String message = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			while(true) {
			serverSocket = new ServerSocket(5000);
			System.out.println("Server running at port 5000" );
			socket = serverSocket.accept();
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);
			message = bufferedReader.readLine();
			System.out.println(message);
			inputStreamReader.close();
			bufferedReader.close();
			serverSocket.close();
			socket.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SERVER");
		lblNewLabel.setBounds(120, 85, 61, 16);
		contentPane.add(lblNewLabel);
	}
}
