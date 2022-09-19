import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
public class frontend extends JFrame {

	private JPanel frame;
	private JTextField Input_text;
	static short[] MEM=new short[4096];
	static short pc;
	static short[] gpr =new short[4];
	static short[] ixr =new short[4];
	static short mar;
	static short mbr;
	static short ir;
	static short memStart;
	private JTextField MAR_Value;
	private JTextField MBR_Value;
	private JTextField PC_Value;
	private JTextField IR_Value;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField GPR0_Value; 
	private JTextField GPR1_Value;
	private JTextField GPR2_Value;
	private JTextField GPR3_Value;
	private JTextField IXR1_Value;
	private JTextField IXR2_Value;
	private JTextField IXR3_Value;
	private JTextField Halt_Value;
	private JTextField Run_Value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontend frame = new frontend();
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
	public frontend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 525);
		frame = new JPanel();
		frame.setAutoscrolls(true);
		frame.setPreferredSize(new Dimension(100, 100));
		frame.setSize(new Dimension(500, 100));
		frame.setSize(1000, 1000);
		frame.setBorder(new EmptyBorder(10, 5, 5, 5));

		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel MARLabel = new JLabel("MAR");
		MARLabel.setBounds(693, 38, 52, 26);
		frame.add(MARLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MBR");
		lblNewLabel_1.setBounds(693, 76, 45, 14);
		frame.add(lblNewLabel_1);
		
		
		Input_text = new JTextField();
		Input_text.setBounds(119, 431, 298, 26);
		frame.add(Input_text);
		Input_text.setColumns(10);
		
		JButton MAR_load = new JButton("LD");
		MAR_load.setBounds(732, 41, 92, 21);
		MAR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String st = Input_text.getText();
			MAR_Value.setText(st);
			}
		});
		frame.add(MAR_load);
		
		JButton MBR_load = new JButton("LD");
		MBR_load.setBounds(732, 73, 92, 21);
		MBR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1=Input_text.getText();
				MBR_Value.setText(st1);
			}
		});
		frame.add(MBR_load);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(637, 362, 108, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MBR_Value.setText(Integer.toHexString(MEM[Short.parseShort(MAR_Value.getText(),16)]));
			}
		});
		frame.add(btnNewButton);
		
		MAR_Value = new JTextField();
		MAR_Value.setBounds(587, 41, 96, 20);
		frame.add(MAR_Value);
		MAR_Value.setColumns(10);
		
		MBR_Value = new JTextField();
		MBR_Value.setBounds(587, 73, 96, 20);
		frame.add(MBR_Value);
		MBR_Value.setColumns(10);
		
		JButton PC_Load = new JButton("LD");
		PC_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st6 = Input_text.getText();
				PC_Value.setText(st6);
				pc=Short.parseShort(st6,16);
			}
		});
		PC_Load.setBounds(732, 13, 92, 23);
		frame.add(PC_Load);
		
		JLabel lblNewLabel = new JLabel("PC");
		lblNewLabel.setBounds(693, 15, 52, 18);
		frame.add(lblNewLabel);
		
		PC_Value = new JTextField();
		PC_Value.setBounds(587, 10, 96, 20);
		frame.add(PC_Value);
		PC_Value.setColumns(10);
		
		IR_Value = new JTextField();
		IR_Value.setBounds(587, 114, 96, 20);
		frame.add(IR_Value);
		IR_Value.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("IR");
		lblNewLabel_2.setBounds(693, 117, 60, 14);
		frame.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(587, 156, 57, 20);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(587, 192, 38, 20);
		frame.add(textField_1);
		textField_1.setColumns(10);
		
		GPR0_Value = new JTextField();
		GPR0_Value.setBounds(82, 14, 254, 20);
		frame.add(GPR0_Value);
		GPR0_Value.setColumns(10);
		
		GPR1_Value = new JTextField();
		GPR1_Value.setBounds(82, 55, 254, 20);
		frame.add(GPR1_Value);
		GPR1_Value.setColumns(10);
		
		GPR2_Value = new JTextField();
		GPR2_Value.setBounds(82, 95, 254, 20);
		frame.add(GPR2_Value);
		GPR2_Value.setColumns(10);
		
		GPR3_Value = new JTextField();
		GPR3_Value.setBounds(82, 137, 254, 20);
		frame.add(GPR3_Value);
		GPR3_Value.setColumns(10);
		
		IXR1_Value = new JTextField();
		IXR1_Value.setBounds(82, 174, 254, 20);
		frame.add(IXR1_Value);
		IXR1_Value.setColumns(10);
		
		IXR2_Value = new JTextField();
		IXR2_Value.setBounds(82, 217, 254, 20);
		frame.add(IXR2_Value);
		IXR2_Value.setColumns(10);
		
		IXR3_Value = new JTextField();
		IXR3_Value.setBounds(82, 258, 254, 20);
		frame.add(IXR3_Value);
		IXR3_Value.setColumns(10);
		
		JButton GPR0_Ld = new JButton("LD");
		GPR0_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1 = Input_text.getText();
				GPR0_Value.setText(st1);
				gpr[0]=Short.parseShort(st1,16);
			}
		});
		GPR0_Ld.setBounds(349, 13, 68, 23);
		frame.add(GPR0_Ld);
		
		JButton GPR1_Ld = new JButton("LD");
		GPR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st2 = Input_text.getText();
				GPR1_Value.setText(st2);
				gpr[1]=Short.parseShort(st2,16);
			}
		});
		GPR1_Ld.setBounds(346, 54, 71, 23);
		frame.add(GPR1_Ld);
		
		JButton GPR2_Ld = new JButton("LD");
		GPR2_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st3 = Input_text.getText();
				GPR2_Value.setText(st3);
				gpr[2]=Short.parseShort(st3,16);
			}
		});
		GPR2_Ld.setBounds(349, 94, 68, 23);
		frame.add(GPR2_Ld);
		
		JButton GPR3_Ld = new JButton("LD");
		GPR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				GPR3_Value.setText(st4);
				gpr[3]=Short.parseShort(st4,16);
			}
		});
		GPR3_Ld.setBounds(349, 136, 68, 23);
		frame.add(GPR3_Ld);
		
		JButton IXR1_Ld = new JButton("LD");
		IXR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				IXR1_Value.setText(st4);
				ixr[1]=Short.parseShort(st4,16);
			}
		});
		IXR1_Ld.setBounds(349, 173, 68, 23);
		frame.add(IXR1_Ld);
		
		JButton IXR2_Load = new JButton("LD");
		IXR2_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st5 = Input_text.getText();
				IXR2_Value.setText(st5);
				ixr[2]=Short.parseShort(st5,16);
			}
		});
		IXR2_Load.setBounds(349, 216, 68, 23);
		frame.add(IXR2_Load);
		
		JButton IXR3_Ld = new JButton("LD");
		IXR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st7 = Input_text.getText();
				IXR3_Value.setText(st7);
				ixr[3]=Short.parseShort(st7,16);
			}
		});
		IXR3_Ld.setBounds(349, 257, 68, 23);
		frame.add(IXR3_Ld);
		
		JLabel lblNewLabel_3 = new JLabel("GPR 0");
		lblNewLabel_3.setBounds(27, 15, 45, 14);
		frame.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GPR 1");
		lblNewLabel_4.setBounds(27, 58, 49, 14);
		frame.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GPR 2");
		lblNewLabel_5.setBounds(27, 98, 49, 14);
		frame.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("GPR 3");
		lblNewLabel_6.setBounds(27, 140, 49, 14);
		frame.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("IXR 1");
		lblNewLabel_7.setBounds(27, 177, 49, 14);
		frame.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IXR 2");
		lblNewLabel_8.setBounds(27, 220, 49, 14);
		frame.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("IXR 3");
		lblNewLabel_9.setBounds(27, 261, 49, 14);
		frame.add(lblNewLabel_9);
		
		JButton btnNewButton_9 = new JButton("Store");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_9.setBounds(483, 361, 67, 23);
		frame.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("St+");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_10.setBounds(560, 361, 67, 23);
		frame.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Init");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc=Short.parseShort(PC_Value.getText(),16);
				File f= new File("C:\\Users\\irfan\\Documents\\input.txt");
				File f1= new File("C:\\Users\\irfan\\Documents\\Instructions.txt");
				try {
				Scanner s=new Scanner(f);
				while(s.hasNextLine())
				{
					String s1=s.nextLine();
					String[] sa=s1.split(" ");
					MEM[Short.parseShort(sa[0],16)]=Short.parseShort(sa[1],16);	
				}
				}
				catch(Exception ex)
				{
					System.out.println("Exception occured in input file"+ex);
				}
				
				try {
				Scanner sc=new Scanner(f1);
				memStart=pc;
					while(sc.hasNextLine())
					{
						String s1=sc.nextLine();
						MEM[memStart++]=Short.parseShort(s1,16);	
					}
					}
					catch(Exception ex)
					{
						System.out.println("Exception occured in Instructions file"+ex);
					}
			}
		});
		btnNewButton_11.setBounds(757, 361, 56, 23);
		frame.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("SS");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAR_Value.setText(PC_Value.getText());
				mar=pc;
				mbr=MEM[mar];
				MBR_Value.setText(Integer.toHexString(mbr));
				ir=mbr;
				IR_Value.setText(MBR_Value.getText());
				int ai=16-Integer.toBinaryString(mbr).length();
				System.out.println("len of ai "+ai);
				String ir16="";
				for(int i=0;i<ai;i++)
				{
					ir16=ir16+"0";
				}
				ir16=ir16+Integer.toBinaryString(mbr);
				short op=Short.parseShort(ir16.substring(0,6),2);
				short r=Short.parseShort(ir16.substring(6,8),2);
				short ix=Short.parseShort(ir16.substring(8,10),2);
				short ia=Short.parseShort(ir16.substring(10,11),2);
				short add=Short.parseShort(ir16.substring(11),2);
				short eadd=0;
				ixr[0]=0;
				switch(op)
				{
				case 1:
					if(ia==0)
					{
						eadd=(short)(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=MEM[(short)(add+ixr[ix])];
					}
					gpr[r]=MEM[eadd];
					String mem16=Integer.toHexString(gpr[r]);
					if(r==0)
					{
						GPR0_Value.setText(mem16);
					}
					else if(r==1)
					{
						GPR1_Value.setText(mem16);
					}
					else if(r==2)
					{
						GPR2_Value.setText(mem16);
					}
					else if(r==3)
					{
						GPR3_Value.setText(mem16);
					}
					break;
				}
				pc++;
			}
		});
		btnNewButton_12.setBounds(587, 399, 89, 23);
		frame.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Run");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(memStart-pc!=0)
				{

					MAR_Value.setText(PC_Value.getText());
					mar=pc;
					mbr=MEM[mar];
					MBR_Value.setText(Integer.toBinaryString(mbr));
					ir=mbr;
					IR_Value.setText(MBR_Value.getText());
					int ai=16-IR_Value.getText().length();
					String ir16="";
					for(int i=0;i<ai;i++)
					{
						ir16=ir16+"0";
					}
					ir16=ir16+IR_Value.getText();
					short op=Short.parseShort(ir16.substring(0,6),2);
					short r=Short.parseShort(ir16.substring(6,8),2);
					short ix=Short.parseShort(ir16.substring(8,10),2);
					short ia=Short.parseShort(ir16.substring(10,11),2);
					short add=Short.parseShort(ir16.substring(11),2);
					short eadd=0;
					ixr[0]=0;
					switch(op)
					{
					case 1:
						if(ia==0)
						{
							eadd=(short)(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(short)(add+ixr[ix])];
						}
						gpr[r]=MEM[eadd];
						int lg=16-Integer.toBinaryString(gpr[r]).length();
						String mem16="";
						for(int i=0;i<lg;i++)
						{
							mem16=mem16+"0";
						}
						mem16=mem16+Integer.toBinaryString(gpr[r]);
						if(r==0)
						{
							GPR0_Value.setText(mem16);
						}
						else if(r==1)
						{
							GPR1_Value.setText(mem16);
						}
						else if(r==2)
						{
							GPR2_Value.setText(mem16);
						}
						else if(r==3)
						{
							GPR3_Value.setText(mem16);
						}
						break;
					}
					pc++;
				
				}
			}
		});
		btnNewButton_13.setBounds(587, 433, 89, 23);
		frame.add(btnNewButton_13);
		
		JLabel Halt = new JLabel("Halt");
		Halt.setBounds(693, 410, 60, 14);
		frame.add(Halt);
		
		JLabel lblNewLabel_11 = new JLabel("Run");
		lblNewLabel_11.setBounds(693, 437, 60, 14);
		frame.add(lblNewLabel_11);
		
		Halt_Value = new JTextField();
		Halt_Value.setBounds(757, 407, 29, 20);
		frame.add(Halt_Value);
		Halt_Value.setColumns(10);
		
		Run_Value = new JTextField();
		Run_Value.setBounds(757, 434, 29, 20);
		frame.add(Run_Value);
		Run_Value.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("MFR");
		lblNewLabel_12.setBounds(693, 159, 80, 14);
		frame.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Privileged");
		lblNewLabel_13.setBounds(693, 195, 80, 14);
		frame.add(lblNewLabel_13);
	}
}
