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
public class CSAFrontend extends JFrame {         

	private JPanel frame;
	private JTextField Input_text;
	static int[] MEM=new int[4096];
	static int pc;
	static int[] gpr =new int[4];
	static int[] ixr =new int[4];
	static int mar;
	static int mbr;
	static int ir;
	static int memStart;
	private JTextField MAR_Value;                         //Declaring the value for MAR
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
					CSAFrontend frame = new CSAFrontend();
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
	public CSAFrontend() {
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
		
		JLabel MARLabel = new JLabel("MAR");                       //Creating MAR label and setting bounds
		MARLabel.setBounds(693, 38, 52, 26);
		frame.add(MARLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MBR");                  //Creating MBR label and setting bounds
		lblNewLabel_1.setBounds(693, 76, 45, 14);
		frame.add(lblNewLabel_1);
		
		
		Input_text = new JTextField();
		Input_text.setBounds(119, 431, 298, 26);
		frame.add(Input_text);
		Input_text.setColumns(10);
		
		JButton MAR_load = new JButton("LD");                     //Assigning the load operation on MAR field
		MAR_load.setBounds(732, 41, 92, 21);
		MAR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String st = Input_text.getText();
			MAR_Value.setText(st);
			mar=Integer.parseInt(st,2);                           //Converting string into integer using parse
			}
		});
		frame.add(MAR_load);
		
		JButton MBR_load = new JButton("LD");                    //Assigning the load operation on MBR field
		MBR_load.setBounds(732, 73, 92, 21);
		MBR_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1=Input_text.getText();
				MBR_Value.setText(st1);
				mbr=Integer.parseInt(st1,2);                     //Converting string into integer using parse
			}
		});
		frame.add(MBR_load);
		
		JButton btnNewButton = new JButton("LOAD");             //Creating the new Load button in simulator
		btnNewButton.setBounds(637, 362, 108, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mbr=MEM[Integer.parseInt(MAR_Value.getText(),2)];
			int mbl=16-Integer.toBinaryString(mbr).length();
			String mbx="";
			for(int i=0;i<mbl;i++)
			{
				mbx=mbx+"0";
			}
			mbx=mbx+Integer.toBinaryString(mbr);
			MBR_Value.setText(mbx);
			}
		});
		frame.add(btnNewButton);
		
		MAR_Value = new JTextField();                          //Assigning the MAR value to the text field and setting bounds
		MAR_Value.setBounds(517, 41, 166, 20);
		frame.add(MAR_Value);
		MAR_Value.setColumns(10);
		
		MBR_Value = new JTextField();                          //Assigning the MBR value to the text field and setting bounds
		MBR_Value.setBounds(517, 73, 166, 20);
		frame.add(MBR_Value);
		MBR_Value.setColumns(10);
		
		JButton PC_Load = new JButton("LD");
		PC_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st6 = Input_text.getText();
				PC_Value.setText(st6);
				pc=Integer.parseInt(st6,2);
			}
		});
		PC_Load.setBounds(732, 13, 92, 23);
		frame.add(PC_Load);
		
		JLabel lblNewLabel = new JLabel("PC");                //Creating the PC label and setting bounds
		lblNewLabel.setBounds(693, 15, 52, 18);
		frame.add(lblNewLabel);
		
		PC_Value = new JTextField();                          //Assigning the PC value to the text field and setting bounds
		PC_Value.setBounds(517, 10, 166, 20);
		frame.add(PC_Value);
		PC_Value.setColumns(10);
		
		IR_Value = new JTextField();                         //Assigning the IR value to the text field and setting bounds
		IR_Value.setBounds(517, 114, 166, 20);
		frame.add(IR_Value);
		IR_Value.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("IR");             //Creating the IR label and setting bounds
		lblNewLabel_2.setBounds(693, 117, 60, 14);
		frame.add(lblNewLabel_2);
		
		textField = new JTextField();         
		textField.setBounds(592, 156, 84, 20);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(637, 192, 38, 20);
		frame.add(textField_1);
		textField_1.setColumns(10);
		
		GPR0_Value = new JTextField();                     //Assigning the GPR0 value to the text field and setting bounds
		GPR0_Value.setBounds(82, 14, 254, 20);
		frame.add(GPR0_Value);
		GPR0_Value.setColumns(10);
		 
		GPR1_Value = new JTextField();                     //Assigning the GPR1 value to the text field and setting bounds
		GPR1_Value.setBounds(82, 55, 254, 20);
		frame.add(GPR1_Value);
		GPR1_Value.setColumns(10);
		
		GPR2_Value = new JTextField();                     //Assigning the GPR2 value to the text field and setting bounds
		GPR2_Value.setBounds(82, 95, 254, 20);
		frame.add(GPR2_Value);
		GPR2_Value.setColumns(10);
		
		GPR3_Value = new JTextField();                     //Assigning the GPR3 value to the text field and setting bounds
		GPR3_Value.setBounds(82, 137, 254, 20);
		frame.add(GPR3_Value);
		GPR3_Value.setColumns(10);
		
		IXR1_Value = new JTextField();                     //Assigning the IXR1 value to the text field and setting bounds
		IXR1_Value.setBounds(82, 174, 254, 20);
		frame.add(IXR1_Value);
		IXR1_Value.setColumns(10);
		
		IXR2_Value = new JTextField();                    //Assigning the IXR2 value to the text field and setting bounds
		IXR2_Value.setBounds(82, 217, 254, 20);
		frame.add(IXR2_Value);
		IXR2_Value.setColumns(10);
		
		IXR3_Value = new JTextField();                    //Assigning the IXR3 value to the text field and setting bounds
		IXR3_Value.setBounds(82, 258, 254, 20);
		frame.add(IXR3_Value);
		IXR3_Value.setColumns(10);
		
		JButton GPR0_Ld = new JButton("LD");
		GPR0_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st1 = Input_text.getText();
				GPR0_Value.setText(st1);
				gpr[0]=Integer.parseInt(st1,2);
			}
		});
		GPR0_Ld.setBounds(349, 13, 68, 23);
		frame.add(GPR0_Ld);
		
		JButton GPR1_Ld = new JButton("LD");                  //Assigning the load operation on GPR1 field
		GPR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st2 = Input_text.getText();
				GPR1_Value.setText(st2);
				gpr[1]=Integer.parseInt(st2,2);              //Converting string into integer using parse
			}
		});
		GPR1_Ld.setBounds(346, 54, 71, 23);
		frame.add(GPR1_Ld);
		
		JButton GPR2_Ld = new JButton("LD");                 //Assigning the load operation on GPR2 field
		GPR2_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st3 = Input_text.getText();
				GPR2_Value.setText(st3);
				gpr[2]=Integer.parseInt(st3,2);               //Converting string into integer using parse
			}
		});
		GPR2_Ld.setBounds(349, 94, 68, 23);
		frame.add(GPR2_Ld);
		
		JButton GPR3_Ld = new JButton("LD");                  //Assigning the load operation on GPR3 field
		GPR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				GPR3_Value.setText(st4);
				gpr[3]=Integer.parseInt(st4,2);                //Converting string into integer using parse
			}
		});
		GPR3_Ld.setBounds(349, 136, 68, 23);
		frame.add(GPR3_Ld);
		
		JButton IXR1_Ld = new JButton("LD");                  //Assigning the load operation on IXR1 field
		IXR1_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st4 = Input_text.getText();
				IXR1_Value.setText(st4);
				ixr[1]=Integer.parseInt(st4,2);               //Converting string into integer using parse
			}
		});
		IXR1_Ld.setBounds(349, 173, 68, 23);
		frame.add(IXR1_Ld);
		
		JButton IXR2_Load = new JButton("LD");               //Assigning the load operation on IXR2 field
		IXR2_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st5 = Input_text.getText();
				IXR2_Value.setText(st5);
				ixr[2]=Integer.parseInt(st5,2);              //Converting string into integer using parse
			}
		});
		IXR2_Load.setBounds(349, 216, 68, 23);
		frame.add(IXR2_Load);
		
		JButton IXR3_Ld = new JButton("LD");                //Assigning the load operation on IXR3 field
		IXR3_Ld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st7 = Input_text.getText();
				IXR3_Value.setText(st7);
				ixr[3]=Integer.parseInt(st7,2);             //Converting string into integer using parse
			}
		});
		IXR3_Ld.setBounds(349, 257, 68, 23);
		frame.add(IXR3_Ld);
		
		JLabel lblNewLabel_3 = new JLabel("GPR 0");              //Creating a GPR0 label and setting bounds
		lblNewLabel_3.setBounds(27, 15, 45, 14);
		frame.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GPR 1");              //Creating a GPR1 label and setting bounds
		lblNewLabel_4.setBounds(27, 58, 49, 14);
		frame.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GPR 2");              //Creating a GPR2 label and setting bounds
		lblNewLabel_5.setBounds(27, 98, 49, 14);
		frame.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("GPR 3");              //Creating a GPR3 label and setting bounds
		lblNewLabel_6.setBounds(27, 140, 49, 14);
		frame.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("IXR 1");              //Creating a IXR1 label and setting bounds
		lblNewLabel_7.setBounds(27, 177, 49, 14);
		frame.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("IXR 2");              //Creating a register IXR2 label and setting bounds
		lblNewLabel_8.setBounds(27, 220, 49, 14);
		frame.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("IXR 3");              //Creating a IXR3 label and setting bounds
		lblNewLabel_9.setBounds(27, 261, 49, 14);
		frame.add(lblNewLabel_9);
		
		JButton btnNewButton_9 = new JButton("Store");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mar=Integer.parseInt(MAR_Value.getText(),2);
				mbr=Integer.parseInt(MBR_Value.getText(),2);
				MEM[mar]=mbr;
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
				pc=3596;
				pc=Integer.parseInt(PC_Value.getText(),2);
				int pcl=16-Integer.toBinaryString(pc).length();
				String pcx="";
				for(int i=0;i<pcl;i++)
				{
					pcx=pcx+"0";
				}
				pcx=pcx+Integer.toBinaryString(pc);
				PC_Value.setText(pcx);
				GPR0_Value.setText("0000000000000000");                      //Initializing the default values to zero into all fields
				GPR1_Value.setText("0000000000000000");
				GPR2_Value.setText("0000000000000000");
				GPR3_Value.setText("0000000000000000");
				IXR1_Value.setText("0000000000000000");
				IXR2_Value.setText("0000000000000000");
				IXR3_Value.setText("0000000000000000");
				MAR_Value.setText("0000000000000000");
				MBR_Value.setText("0000000000000000");
				IR_Value.setText("0000000000000000");
				File f= new File("C:\\Users\\irfan\\Documents\\input.txt");              //Providing the location of the input file 
				try {
				Scanner s=new Scanner(f);
				while(s.hasNextLine())
				{
					String s1=s.nextLine();
					String[] sa=s1.split(" ");
					MEM[Integer.parseInt(sa[0],16)]=Integer.parseInt(sa[1],16);	
				}
				}
				catch(Exception ex)
				{
					System.out.println("Exception occured in input file"+ex);
				}
			}
		});
		btnNewButton_11.setBounds(757, 361, 56, 23);
		frame.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("SS");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pcl=16-Integer.toBinaryString(pc).length();
				String pcx="";
				for(int i=0;i<pcl;i++)
				{
					pcx=pcx+"0";
				}
				pcx=pcx+Integer.toBinaryString(pc);
				PC_Value.setText(pcx);
				MAR_Value.setText(pcx);
				mar=pc;
				mbr=MEM[mar];
				int mbl=16-Integer.toBinaryString(mbr).length();
				String mbrx="";
				for(int i=0;i<mbl;i++)
				{
					mbrx=mbrx+"0";
				}
				mbrx=mbrx+Integer.toBinaryString(mbr);
				MBR_Value.setText(mbrx);
				ir=mbr;
				IR_Value.setText(MBR_Value.getText());
				int ai=16-Integer.toBinaryString(mbr).length();
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
				int eadd=0;
				ixr[0]=0;
				switch(op)
				{
				case 0:
					System.out.println("Instructions are completed");
					break;
				case 1:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=MEM[(add+ixr[ix])];
					}
					gpr[r]=MEM[eadd];
					int mem16l=16-Integer.toBinaryString(gpr[r]).length();
					String mem16="";
					for(int i=0;i<mem16l;i++)
					{
						mem16=mem16+"0";
					}mem16=mem16+Integer.toBinaryString(gpr[r]);
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
				case 2:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=MEM[(add+ixr[ix])];
					}
					MEM[eadd]=gpr[r];
					break;
				case 3:
					if(ia==0)
					{
						eadd=(add+ixr[ix]);
					}	
					else if(ia==1)
					{
						eadd=MEM[(add+ixr[ix])];
					}
					gpr[r]=eadd;
					int mem163l=16-Integer.toBinaryString(gpr[r]).length();
					String mem163="";
					for(int i=0;i<mem163l;i++)
					{
						mem163=mem163+"0";
					}
					mem163=mem163+Integer.toBinaryString(gpr[r]);
					if(r==0)
					{
						GPR0_Value.setText(mem163);
					}
					else if(r==1)
					{
						GPR1_Value.setText(mem163);
					}
					else if(r==2)
					{
						GPR2_Value.setText(mem163);
					}
					else if(r==3)
					{
						GPR3_Value.setText(mem163);
					}
					break;
				case 41:
					if(ia==0)
					{
						eadd=(add);
					}	
					else if(ia==1)
					{
						eadd=MEM[add];
					}
					ixr[r]=MEM[eadd];
					int mem16xl=16-Integer.toBinaryString(ixr[r]).length();
					String mem16x="";
					for(int i=0;i<mem16xl;i++)
					{
						mem16x=mem16x+"0";
					}
					mem16x=mem16x+Integer.toBinaryString(ixr[r]);
					if(ix==1)
					{
						IXR1_Value.setText(mem16x);
					}
					else if(ix==2)
					{
						IXR2_Value.setText(mem16x);
					}
					else if(ix==3)
					{
						IXR3_Value.setText(mem16x);
					}
					break;
				case 42:
					if(ia==0)
					{
						eadd=(add);
					}	
					else if(ia==1)
					{
						eadd=MEM[add];
					}
					MEM[eadd]=ixr[ix];
					break;
				}
				pc++;
			} 
		});
		btnNewButton_12.setBounds(587, 399, 89, 23);
		frame.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Run");                          //Creating new Run button
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Run:
				while(memStart-pc!=0)
				{
					int pcl=16-Integer.toBinaryString(pc).length();           //Converting integer to 16 bit binary value
					String pcx="";
					for(int i=0;i<pcl;i++)
					{
						pcx=pcx+"0";
					}
					pcx=pcx+Integer.toBinaryString(pc);
					PC_Value.setText(pcx);
					MAR_Value.setText(pcx);
					mar=pc;
					mbr=MEM[mar];
					int mbl=16-Integer.toBinaryString(mbr).length();
					String mbrx="";
					for(int i=0;i<mbl;i++)
					{
						mbrx=mbrx+"0";
					}
					mbrx=mbrx+Integer.toBinaryString(mbr);
					MBR_Value.setText(mbrx);
					ir=mbr;
					IR_Value.setText(MBR_Value.getText());
					int ai=16-Integer.toBinaryString(mbr).length();
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
					int eadd=0;
					ixr[0]=0;
					switch(op)
					{
					case 0:
						System.out.println("Instructions are completed");
						break Run;
					case 1:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(add+ixr[ix])];
						}
						gpr[r]=MEM[eadd];
						int mem16l=16-Integer.toBinaryString(gpr[r]).length();
						String mem16="";
						for(int i=0;i<mem16l;i++)
						{
							mem16=mem16+"0";
						}mem16=mem16+Integer.toBinaryString(gpr[r]);
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
					case 2:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(add+ixr[ix])];
						}
						MEM[eadd]=gpr[r];
						break;
					case 3:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(add+ixr[ix])];
						}
						gpr[r]=eadd;
						int mem163l=16-Integer.toBinaryString(gpr[r]).length();
						String mem163="";
						for(int i=0;i<mem163l;i++)
						{
							mem163=mem163+"0";
						}
						mem163=mem163+Integer.toBinaryString(gpr[r]);
						if(r==0)
						{
							GPR0_Value.setText(mem163);
						}
						else if(r==1)
						{
							GPR1_Value.setText(mem163);
						}
						else if(r==2)
						{
							GPR2_Value.setText(mem163);
						}
						else if(r==3)
						{
							GPR3_Value.setText(mem163);
						}
						break;
					case 41:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(add+ixr[ix])];
						}
						ixr[r]=MEM[eadd];
						int mem16xl=16-Integer.toBinaryString(ixr[r]).length();
						String mem16x="";
						for(int i=0;i<mem16xl;i++)
						{
							mem16x=mem16x+"0";
						}
						mem16x=mem16x+Integer.toBinaryString(ixr[r]);
						if(ix==1)
						{
							IXR1_Value.setText(mem16x);
						}
						else if(ix==2)
						{
							IXR2_Value.setText(mem16x);
						}
						else if(ix==3)
						{
							IXR3_Value.setText(mem16x);
						}
						break;
					case 42:
						if(ia==0)
						{
							eadd=(add+ixr[ix]);
						}	
						else if(ia==1)
						{
							eadd=MEM[(add+ixr[ix])];
						}
						MEM[eadd]=ixr[ix];
						break;
					}
					pc++;
				}
			}
		});
		btnNewButton_13.setBounds(587, 433, 89, 23);
		frame.add(btnNewButton_13);
		
		JLabel Halt = new JLabel("Halt");                        //Creating a Halt label and setting bounds
		Halt.setBounds(693, 410, 60, 14);
		frame.add(Halt);
		
		JLabel lblNewLabel_11 = new JLabel("Run");               //Creating a Run label and setting bounds to it.
		lblNewLabel_11.setBounds(693, 437, 60, 14);
		frame.add(lblNewLabel_11);
		
		Halt_Value = new JTextField();                          //Creating a Halt field and setting bounds
		Halt_Value.setBounds(757, 407, 29, 20);
		frame.add(Halt_Value);                                  //loading the Halt value into the Halt text field
		Halt_Value.setColumns(10);
		
		Run_Value = new JTextField();                          //Creating a Run field and setting bounds    
		Run_Value.setBounds(757, 434, 29, 20);
		frame.add(Run_Value);                                  //loading the Run value into the Halt text field
		Run_Value.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("MFR");             //Creating a MFR label and setting bounds
		lblNewLabel_12.setBounds(693, 159, 80, 14);
		frame.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Privileged");     //Creating a Privileged label and setting bounds
		lblNewLabel_13.setBounds(693, 195, 80, 14);
		frame.add(lblNewLabel_13);
	}
}
