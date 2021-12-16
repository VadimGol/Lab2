
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


	public class MainFrame extends JFrame{
	// ������� ���� ���������� � ���� ��������
	private static final int WIDTH = 400;
	private static final int HEIGHT = 320;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	private JTextField textFieldResult;
	// ������ �����-������ ��� ����������� ������������ ��������� � ������
	private ButtonGroup radioButtons = new ButtonGroup();
	// ��������� ��� ����������� �����-������
	private Box hboxFormulaType = Box.createHorizontalBox();
	// ������������� ��������� �������
	private int formula = 1;
		public Double sum=0.0;
		public Double result=0.0;
	public Double calculate1 (Double x,Double y, Double z)
	{
		return Math.pow(Math.cos(Math.exp(y))+Math.exp(Math.pow(y, 2))+Math.pow(1/x, 1/2), 1/4)/Math.pow(Math.cos(Math.pow(z, 3)*Math.acos(-1))+Math.log(Math.pow(1+z, 2)),Math.sin(y));
	}

	public Double calculate2 (Double x,Double y, Double z)
	{
		return ((1+Math.pow(x, z)+Math.log(Math.pow(y,2)))*(1-Math.sin(y*z)))/Math.pow(Math.pow(x,3), 1/2);
	}

	private void addRadioButton ( String buttonName, final int formula)
	{
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				MainFrame.this.formula = formula;	
			}
		});
		radioButtons.add(button);
		hboxFormulaType.add(button);}
		
	public MainFrame() {
		super("���������� �������");
		setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		// ������������ ���� ���������� �� ������
		setLocation((kit.getScreenSize().width - WIDTH)/2, 
		(kit.getScreenSize().height - HEIGHT)/2);
		
		
		JLabel labelForX = new JLabel("X:");
		textFieldX = new JTextField("0", 10);
		textFieldX.setMaximumSize(textFieldX.getPreferredSize());

		JLabel labelForY = new JLabel("Y:");
		textFieldY = new JTextField("0", 10);
		textFieldY.setMaximumSize(textFieldY.getPreferredSize());
		
		JLabel labelForZ = new JLabel("Z:");
		textFieldZ = new JTextField("0", 10);
		textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
		
		Box hboxVariables = Box.createHorizontalBox();
		hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		


		hboxVariables.add(labelForX);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldX);
		hboxVariables.add(Box.createHorizontalGlue());
		hboxVariables.add(Box.createHorizontalStrut(10));

		hboxVariables.add(labelForY);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldY);
		hboxVariables.add(Box.createHorizontalGlue());
		
		hboxVariables.add(labelForZ);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldZ);
		
		
		JLabel labelForResult = new JLabel("���������:");
		textFieldResult = new JTextField("0", 20);
		Box hboxResult = Box.createHorizontalBox();
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.add(labelForResult);
		hboxResult.add(Box.createHorizontalStrut(10));
		hboxResult.add(textFieldResult);
		hboxResult.add(Box.createHorizontalGlue());
		textFieldResult.setMaximumSize(textFieldX.getPreferredSize());
		hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
	
		hboxFormulaType.add(Box.createHorizontalGlue());
		addRadioButton("������� 1", 1);
		addRadioButton("������� 2", 2);
		radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
		hboxFormulaType.add(Box.createHorizontalGlue());
		hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

		
		JButton buttonCalc = new JButton("���������");
		buttonCalc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
		try {
		Double x = Double.parseDouble(textFieldX.getText());
		Double y = Double.parseDouble(textFieldY.getText());
		Double z = Double.parseDouble(textFieldZ.getText());
		if (formula==1)
			MainFrame.this.result = calculate1(x,y,z);		else
			MainFrame.this.result = calculate2(x,y,z);
		textFieldResult.setText(MainFrame.this.result.toString());
		} catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(MainFrame.this, "������ � ������� ������ ����� � ��������� ������", "��������� ������ �����", 
		JOptionPane.WARNING_MESSAGE);
		}
		}
		});
		
		JButton Mbutton = new JButton ("M+");
		Mbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				sum=sum+result;
				textFieldResult.setText(sum.toString());
			}
		});
		
		// ������� ������ ��������� �����
		JButton buttonReset = new JButton("�������� ����");
		// ���������� � ���������������� ���������� ������� �� ������
		buttonReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
		textFieldX.setText("0");
		textFieldY.setText("0");
		textFieldZ.setText("0");
		textFieldResult.setText("0");
		}
		});
		
		JButton MCbutton = new JButton("MC");
		// ���������� � ���������������� ���������� ������� �� ������
		MCbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
		sum=0.0;
		textFieldResult.setText("0");
		}
		});
		
		// ������� ������� � �������������� ��������
		Box hboxButtons = Box.createHorizontalBox();
		// �������� ����� C4-H1 � ����� �������
		hboxButtons.add(Box.createHorizontalGlue());
		// �������� ������ ����������� � ����������
		hboxButtons.add(buttonCalc);
		// �������� �������� � 30 �������� C4-H2 ����� ��������
		hboxButtons.add(Box.createHorizontalStrut(10));
		// �������� ������ ��������� ����� � ����������
		hboxButtons.add(buttonReset);
		// �������� ����� C4-H3 � ������ �������
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.add(Box.createVerticalGlue());
		hboxButtons.add(Mbutton);
		hboxButtons.add(Box.createHorizontalStrut(5));
		hboxButtons.add(MCbutton);
		hboxButtons.add(Box.createHorizontalGlue());
		// ������ ����� ��� ����������
		hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		
		// ������� ��������� �������� � ������������ ��������
		Box contentBox = Box.createVerticalBox();
		// �������� ��������� � �����������
		contentBox.add(hboxVariables);
		// �������� ��������� � ����������� ����������
		contentBox.add(hboxResult);
		// �������� ��������� � ��������
		contentBox.add(hboxFormulaType);
		contentBox.add(hboxButtons);
		getContentPane().add(contentBox, BorderLayout.CENTER);

	}
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}

