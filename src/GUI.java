import net.sourceforge.tess4j.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class GUI extends JFrame {
	private JPanel contentPane;
	private JTextField sourcePathText;
	private JTextField resultPathText;
	private JButton loadButton;
	private JButton executeButton;
	private JLabel log;
	
	public File[] files;
	
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		log = new JLabel("");
		log.setBounds(10,80,150,25);
		contentPane.add(log);
		
		sourcePathText = new JTextField("C://Arquivos");
		sourcePathText.setColumns(10);
		sourcePathText.setBounds(10,10,250,25);
		contentPane.add(sourcePathText);
		
		loadButton = new JButton("Carregar");
		loadButton.setBounds(270,10,100,25);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(sourcePathText.getText());
				log.setText("Carregando...");
				files = FileLayer.pickFiles(sourcePathText.getText());
				log.setText("Carregado");
				}
					
		});
		contentPane.add(loadButton);
		
		resultPathText = new JTextField("C://Result");
		resultPathText.setColumns(10);
		resultPathText.setBounds(10,45,250,25);
		contentPane.add(resultPathText);
		
		executeButton = new JButton("Executar");
		executeButton.setBounds(270,45,100,25);
		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				log.setText("Convertendo...");
				Converter.convertAndDownload(resultPathText.getText(), files, "");
				log.setText("Pronto");
				
				}
					
		});
		contentPane.add(executeButton);
		
		//this.add(contentPane);
		this.setVisible(true);
	}
}
