import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Gui implements ActionListener {
	private JFrame frame;
	private JPanel panelCounter1;
	private JPanel panelCounter2;
	private JPanel panelCounter3;
	private JLabel labelQueue1, labelQueue2, labelQueue3, labelCustomerLeft;
	private JButton btnPay1, btnPay2, btnPay3, btnNext, btnDisplay;
	private int queue1 = 0, queue2 = 0, queue3 = 0;
	private int totalCustomer;
	private Queue qCounter1, qCounter2, qCounter3;
	private LinkedList<CustomerInformation> customerList;
	private Stack<CustomerInformation> completedStack;

	public Gui(LinkedList<CustomerInformation> customerList, Queue qCounter1, Queue qCounter2, Queue qCounter3,
			int totalCustomer, Stack<CustomerInformation> completedStack) {
		this.customerList = customerList;
		this.totalCustomer = totalCustomer;
		this.qCounter1 = qCounter1;
		this.qCounter2 = qCounter2;
		this.qCounter3 = qCounter3;
		this.completedStack = completedStack;

		// Panel Counter 1
		panelCounter1 = new JPanel();
		panelCounter1.setBounds(20, 60, 110, 50); // set the size and position
		panelCounter1.setBorder(new LineBorder(Color.BLACK)); // create border
		JLabel labelCounter1 = new JLabel("Counter 1"); // create label
		labelCounter1.setFont(new Font("Verdana", 1, 15)); // change font
		labelQueue1 = new JLabel("Queue: " + String.valueOf(queue1)); // create label for how many customer in counter
																		// queue left
		panelCounter1.add(labelCounter1);
		panelCounter1.add(labelQueue1);

		// Panel Counter 2
		panelCounter2 = new JPanel();
		panelCounter2.setBounds(150, 60, 110, 50); // size and position
		panelCounter2.setBorder(new LineBorder(Color.BLACK)); // create border
		JLabel labelCounter2 = new JLabel("Counter 2"); // create label
		labelCounter2.setFont(new Font("Verdana", 1, 15)); // change font
		labelQueue2 = new JLabel("Queue: " + String.valueOf(queue2)); // create label for how many customer in counter
																		// queue left
		panelCounter2.add(labelCounter2);
		panelCounter2.add(labelQueue2);

		// Panel Counter 3
		panelCounter3 = new JPanel();
		panelCounter3.setBounds(280, 60, 110, 50); // size and position
		panelCounter3.setBorder(new LineBorder(Color.BLACK)); // create border
		JLabel labelCounter3 = new JLabel("Counter 3"); // create label
		labelCounter3.setFont(new Font("Verdana", 1, 15)); // change font
		labelQueue3 = new JLabel("Queue: " + String.valueOf(queue3)); // create label for how many customer in counter
																		// queue left
		panelCounter3.add(labelCounter3);
		panelCounter3.add(labelQueue3);

		// Button pay counter 1
		btnPay1 = new JButton("PAY");
		btnPay1.setBounds(40, 25, 75, 30); // size and position

		// Button pay counter 1
		btnPay2 = new JButton("PAY");
		btnPay2.setBounds(170, 25, 75, 30); // size and position

		// Button pay counter 1
		btnPay3 = new JButton("PAY");
		btnPay3.setBounds(300, 25, 75, 30); // size and position

		// Button NEXT
		btnNext = new JButton("NEXT");
		btnNext.setBounds(170, 200, 75, 30); // size and position
		labelCustomerLeft = new JLabel("Customers Left: " + String.valueOf(totalCustomer)); // create label to show how
																							// many customers left to
																							// pay
		labelCustomerLeft.setBounds(150, 230, 200, 20); // size and position

		// Button to display completed customer
		btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBounds(162, 270, 90, 30); // size and position

		// Frame
		frame = new JFrame();
		frame.setTitle("GG Mart"); // Frame title
		frame.setLayout(null); // frame layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(430, 400); // size
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // spawn in the middle of screen
		frame.add(panelCounter1);
		frame.add(panelCounter2);
		frame.add(panelCounter3);
		frame.add(btnPay1);
		frame.add(btnPay2);
		frame.add(btnPay3);
		frame.add(btnNext);
		frame.add(labelCustomerLeft);
		frame.add(btnDisplay);

		// Action Listener
		btnPay1.addActionListener(this);
		btnPay2.addActionListener(this);
		btnPay3.addActionListener(this);
		btnNext.addActionListener(this);
		btnDisplay.addActionListener(this);
	}// close GUI

	public void actionPerformed(ActionEvent e) {// open actionPerformed
		Iterator<CustomerInformation> iterator = customerList.iterator();
		CustomerInformation cust;
		if (e.getSource() == btnNext) { // start btnNext

			// while the list is not empty, run this code until no more in the list
			while (iterator.hasNext()) {
				CustomerInformation customer = iterator.next();

				if (customer.getItemQuantity() <= 5) {// open if
					if (qCounter1.size() < 5) {// open if
						iterator.remove();
						qCounter1.enqueue(customer);
						customer.setCounterPaid(1);
						totalCustomer--;
						queue1++;
						labelQueue1.setText("Queue: " + String.valueOf(queue1));
					} // close if
					else if (qCounter2.size() < 5) {// open else if
						iterator.remove();
						qCounter2.enqueue(customer);
						customer.setCounterPaid(2);
						totalCustomer--;
						queue2++;
						labelQueue2.setText("Queue: " + String.valueOf(queue2));
					} // close else if
				} // close if
				else {// open else
					if (qCounter3.size() < 5) {// open if
						iterator.remove();
						qCounter3.enqueue(customer);
						customer.setCounterPaid(3);
						totalCustomer--;
						queue3++;
						labelQueue3.setText("Queue: " + String.valueOf(queue3));
					} // close if
					else {// open else
						JOptionPane.showMessageDialog(null, "All Counter are full!");
						break;
					} // close else
				} // close else
			}
			labelCustomerLeft.setText("Customers Left: " + String.valueOf(totalCustomer));
		} // close btnNext

		if (e.getSource() == btnPay1) {// open btnPay1
			if (!qCounter1.empty()) {// open if
				cust = (CustomerInformation) qCounter1.dequeue();
				JOptionPane.showMessageDialog(null, "Customer with ID " + cust.getCustId() + " has paid");
				queue1--;
				labelQueue1.setText("Queue: " + queue1);
				completedStack.push(cust);
			} // close if
		} // close btnPay1

		if (e.getSource() == btnPay2) {// open btnPay2
			if (!qCounter2.empty()) {// open if
				cust = (CustomerInformation) qCounter2.dequeue();
				JOptionPane.showMessageDialog(null, "Customer with ID " + cust.getCustId() + " has paid");
				queue2--;
				labelQueue2.setText("Queue: " + queue2);
				completedStack.push(cust);
			} // close if
		} // close btnPay2

		if (e.getSource() == btnPay3) {// open btnPay3
			if (!qCounter3.empty()) {// open if
				cust = (CustomerInformation) qCounter3.dequeue();
				JOptionPane.showMessageDialog(null, "Customer with ID " + cust.getCustId() + " has paid");
				queue3--;
				labelQueue3.setText("Queue: " + queue3);
				completedStack.push(cust);
			} // close if
		} // close btnPay3

		if (e.getSource() == btnDisplay) {// open btnDisplay
			while (!completedStack.isEmpty()) {// open while
				cust = (CustomerInformation) completedStack.pop();
				System.out.println(cust);
			} // close while
		} // close btnDisplay

	} // end actionPerformed

}// end class