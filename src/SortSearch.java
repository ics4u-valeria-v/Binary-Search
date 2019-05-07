import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

public class SortSearch {

	private JFrame frmSortSearch;
	private JTextField txtMin;
	private JTextField txtMax;
	private JButton btnSortMin;
	private JButton btnSortMax;
	private JButton btnSearch;
	//declare global variables
	ArrayList<Integer> rndNums = new ArrayList<Integer>();
	private JTextField textField;
	private JTextField txtTarget;
	private JLabel lblTarget;
	
	int genCount = 0;
	String displayS= "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortSearch window = new SortSearch();
					window.frmSortSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
 				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SortSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSortSearch = new JFrame();
		frmSortSearch.setTitle("Bubble Sort & Binary Search");
		frmSortSearch.setBounds(100, 100, 316, 297);
		frmSortSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSortSearch.getContentPane().setLayout(null);
		
		JButton btnGenerate = new JButton("Generate Random Number");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					//get min and max of the random numbers
					int min = Integer.parseInt(txtMin.getText());
					int max = Integer.parseInt(txtMax.getText());
					int items = Integer.parseInt(textField.getText());
					
					
					//clear the rndNums list
					rndNums.clear();
					
					//generate 250 random numbers and them to an array list
					
					for (int counter = 1; counter <= items; counter++)
					{
						double rndNum = (Math.random() * ((max - min) + 1)) + min;
						int rndInt = (int)rndNum;
						rndNums.add(rndInt);
					}
					
					//display the list in a text file
					File rndFile = new File("Files/random.txt");
					try (PrintWriter pw = new PrintWriter(rndFile))
					{
						pw.print(rndNums);
					}
					catch (Exception e3)
					{
						System.out.print("File not found");
					}
					
					//enable bubble sort buttons	
					btnSortMax.setEnabled(true);
					btnSortMin.setEnabled(true);
					
				}
				catch (Exception e2)
				{
					//if the user entered something different than an integer, display a warning message
					JOptionPane.showMessageDialog(null,"Warning: Enter an integer","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
				}
				
				
				//open random file
				try {
					Desktop.getDesktop().open(new java.io.File("Files/random.txt"));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnGenerate.setBackground(new Color(255, 215, 0));
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerate.setForeground(new Color(255, 255, 255));
		btnGenerate.setBounds(51, 80, 197, 23);
		frmSortSearch.getContentPane().add(btnGenerate);
		
	    btnSortMin = new JButton("Bubble Sort (min-max)");
		btnSortMin.setEnabled(false);
		btnSortMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//local variables
				int count ;
				
				//loop through the list as many times as many items are in the list
				for (int counter = 1; counter <= rndNums.size(); counter++)
				{
					//check each item in the list, starting from the first one
					for ( count = 0; count < rndNums.size()-1; count +=1)
					{
						//get the number at the counter
						int firstNum = rndNums.get(count);
						//get the next item
						int secondNum = rndNums.get(count +1);
						//compare if the first one is greater
							if (firstNum > secondNum)
							{
								//if so switch their places
								rndNums.add(count+1, firstNum);
								rndNums.add(count, secondNum);
								//remove the old ones
								rndNums.remove(count+2);
								rndNums.remove(count+2);

							}
						}
					}
				//enable search button
				btnSearch.setEnabled(true);
				
				//display the list in a text file
				File rndFile = new File("Files/BubleSort2.txt");
				try (PrintWriter pw = new PrintWriter(rndFile))
				{
					pw.print(rndNums);
				}
				catch (Exception e3)
				{
					System.out.print("File not found");
				}
				
				//open bubble sort file
				try {
					Desktop.getDesktop().open(new java.io.File("Files/BubleSort2.txt"));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		btnSortMin.setForeground(Color.WHITE);
		btnSortMin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSortMin.setBackground(new Color(70, 130, 180));
		btnSortMin.setBounds(51, 114, 197, 23);
		frmSortSearch.getContentPane().add(btnSortMin);
		
		btnSortMax = new JButton("Bubble Sort (max-min)");
		btnSortMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//local variables
				int count ;
				
				//loop through the list as many times as many items are in the list
				for (int counter = 1; counter <= rndNums.size(); counter++)
				{
					//check each item in the list, starting from the first one
					for ( count = 0; count < rndNums.size()-1; count +=1)
					{
						//get the number at the counter
						int firstNum = rndNums.get(count);
						//get the next item
						int secondNum = rndNums.get(count +1);
						//compare if the first one is greater
							if (firstNum < secondNum)
							{
								//if so switch their places
								rndNums.add(count+1, firstNum);
								rndNums.add(count, secondNum);
								//remove the old ones
								rndNums.remove(count+2);
								rndNums.remove(count+2);

							}
						}
					}
				
				//display the list in a text file
				File rndFile = new File("Files/BubbleSort.txt");
				try (PrintWriter pw = new PrintWriter(rndFile))
				{
					pw.print(rndNums);
				}
				catch (Exception e3)
				{
					System.out.print("File not found");
				}
				
				//open bubble sort file
				try {
					Desktop.getDesktop().open(new java.io.File("Files/BubbleSort.txt"));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSortMax.setEnabled(false);
		btnSortMax.setForeground(Color.WHITE);
		btnSortMax.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSortMax.setBackground(new Color(210, 105, 30));
		btnSortMax.setBounds(51, 148, 197, 23);
		frmSortSearch.getContentPane().add(btnSortMax);
		
	    btnSearch = new JButton("Binary Search");
	    btnSearch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	
				try
				{
		    		//declare local variables
		    		int target = Integer.parseInt(txtTarget.getText());
		    		int min = 0;
		    		int max = rndNums.size() - 1;
		    		boolean targetBool = false;
		    		genCount = 0;
		    		
		    		//check if the target is in the list
		    		for (int counter = 0; counter < rndNums.size(); counter ++)
		    		{
		    			if (rndNums.get(counter) == target)
		    			{
		    				targetBool = true;
		    			}
		    			else
		    			{
		    				if (targetBool == true)
		    				{
		    					targetBool = true;
		    				}
		    				else
		    				{
		    					targetBool = false;
		    				}
		    			}
		    		}

		    		//if the target is in the list then call binary search method
		    		if (targetBool == true)
		    		{
		    			BinarySearch (min, max, target);
		    		}
		    		else if (targetBool == false)
		    		{
		    			//if the user entered something different than an integer, display a warning message
						JOptionPane.showMessageDialog(null,"Warning: Enter an integer that is in the list","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
		    		}
					
				}
				catch (Exception e2)
				{
					//if the user entered something different than an integer, display a warning message
					JOptionPane.showMessageDialog(null,"Warning: Enter an integer","Random Generator Warning",JOptionPane.WARNING_MESSAGE);
				}
	    	}
	    });
	    
		btnSearch.setEnabled(false);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBackground(new Color(60, 179, 113));
		btnSearch.setBounds(51, 220, 197, 23);
		frmSortSearch.getContentPane().add(btnSearch);
		
		txtMin = new JTextField();
		txtMin.setBounds(10, 36, 69, 20);
		frmSortSearch.getContentPane().add(txtMin);
		txtMin.setColumns(10);
		
		txtMax = new JTextField();
		txtMax.setColumns(10);
		txtMax.setBounds(117, 36, 69, 20);
		frmSortSearch.getContentPane().add(txtMax);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMin.setBounds(28, 19, 32, 14);
		frmSortSearch.getContentPane().add(lblMin);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMax.setBounds(135, 19, 38, 14);
		frmSortSearch.getContentPane().add(lblMax);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(221, 36, 69, 20);
		frmSortSearch.getContentPane().add(textField);
		
		JLabel lblOfItems = new JLabel("# of items");
		lblOfItems.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOfItems.setBounds(216, 19, 87, 14);
		frmSortSearch.getContentPane().add(lblOfItems);
		
		txtTarget = new JTextField();
		txtTarget.setColumns(10);
		txtTarget.setBounds(117, 193, 69, 20);
		frmSortSearch.getContentPane().add(txtTarget);
		
		lblTarget = new JLabel("  Target");
		lblTarget.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTarget.setBounds(117, 172, 69, 23);
		frmSortSearch.getContentPane().add(lblTarget);
	}
	
    //Binary Search Function
    public void BinarySearch(int min, int max, int target)
    {
    	System.out.print(genCount);
    	//find the middle
    	int mid = (min+max)/2;
    	int position = 0;
    	boolean right = false;
    	//check if the item at the middle is the same as the target
    	if (rndNums.get(mid) == target)
    	{
    		position = mid;
    		displayS += "Position " + position;
    		if (right == true)
    		{
    			displayS += "   Target is in the right side of the list and greater than the target";
    		}
    		else
    		{
    			displayS += "        Target is in the left side of the list and less than the target";
    		}
    		
        	//display the list in a text file
    		File rndFile = new File("Files/BinarySearch.txt");
    		try (PrintWriter pw = new PrintWriter(rndFile))
    		{
    			pw.print(displayS);
    		}
    		catch (Exception e3)
    		{
    			System.out.print("File not found");
    		}
    		
    		//open bubble sort file
    		try {
    			Desktop.getDesktop().open(new java.io.File("Files/BinarySearch.txt"));
    		}
    		catch (Exception e1)
    		{
    			e1.printStackTrace();
    		}
    	}
    	//check if the number is greater than the target, then analyze the left side of the list
    	else if (rndNums.get(mid)>target){
    		
    		max = mid -1;
    		BinarySearch (min, max, target);
    		if (genCount == 0)
    		{
    			System.out.print("Here l");
    			right = false;
    		}
    		
    	}
    	//check if the number is less than the target, then analyze the right side of the list
    	else if (rndNums.get(mid)<target){
    		
    		min = mid+1;
    		BinarySearch (min, max, target);
    		if (genCount == 0)
    		{
    			System.out.print("Here r");
    			right = true;
    		}
    		
    	}
    	
    }
}
