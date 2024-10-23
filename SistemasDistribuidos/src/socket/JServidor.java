package socket;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JServidor extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField porta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JServidor frame = new JServidor();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JServidor() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 218);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 248, 255));
        panel.setBounds(38, 7, 282, 166);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Servidor");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        lblNewLabel.setBounds(24, 15, 234, 30);
        lblNewLabel.setBackground(new Color(220, 220, 220));
        panel.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("ENTRAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnNewButton.setBounds(73, 118, 136, 30);
        panel.add(btnNewButton);
        
        JLabel lblTextoModificado = new JLabel("PORTA");
        lblTextoModificado.setHorizontalAlignment(SwingConstants.LEFT);
        lblTextoModificado.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTextoModificado.setBackground(new Color(0, 51, 51));
        lblTextoModificado.setBounds(24, 48, 217, 30);
        panel.add(lblTextoModificado);
        
        porta = new JTextField();
        porta.setFont(new Font("Poppins", Font.PLAIN, 12));
        porta.setBackground(new Color(220, 220, 220));
        porta.setColumns(10);
        porta.setBounds(24, 73, 234, 30);
        panel.add(porta);
    }
}
