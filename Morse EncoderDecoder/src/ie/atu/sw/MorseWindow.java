package ie.atu.sw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;

public class MorseWindow {
	private Colour[] colours = Colour.values(); // This might come in handy
	private ThreadLocalRandom rand = ThreadLocalRandom.current(); // This will definitely come in handy
	private JFrame win; // The GUI Window
	private JTextArea txtOutput = new JTextArea(); // The text box to output the results to
	private JTextField txtFilePath; // The file name to process

	public MorseWindow() {
		/*
		 * Create a window for the application. Building a GUI is an example of
		 * "divide and conquer" in action. A GUI is really a tree. That is why we are
		 * able to create and configure GUIs in XML.
		 */
		win = new JFrame();
		win.setTitle("Data Structures & Algorithms 2023 - Morse Encoder/Decoder");
		win.setSize(650, 400);
		win.setResizable(false);
		win.setLayout(new FlowLayout());

		/*
		 * The top panel will contain the file chooser and encode / decode buttons
		 */
		var top = new JPanel(new FlowLayout(FlowLayout.LEADING));
		top.setBorder(new javax.swing.border.TitledBorder("Select File"));
		top.setPreferredSize(new Dimension(600, 80));

		txtFilePath = new JTextField(20);
		txtFilePath.setPreferredSize(new Dimension(100, 30));

		var chooser = new JButton("Browse...");
		chooser.addActionListener((e) -> {
			var fc = new JFileChooser(System.getProperty("user.dir"));
			var val = fc.showOpenDialog(win);
			if (val == JFileChooser.APPROVE_OPTION) {
				var file = fc.getSelectedFile().getAbsoluteFile();
				txtFilePath.setText(file.getAbsolutePath());
			}
		});

		// ENCODING BUTTON
		// Time complexity based on size of the file being encoded
		// Time complexity of this block of code with "Encode.encoding" is O(x^2)
		// x - number of characters in a file
		var btnEncodeFile = new JButton("Encode");
		btnEncodeFile.addActionListener(e -> {
			// Path
			// Call getText() to get the file name
			String path = txtFilePath.getText();
			replaceText("Encoding.....\n" + path + "\n\n");
			// Block of code being tested while executed
			try {
				// File and scanner
				File file = new File(path);
				Scanner scanner = new Scanner(file);
				// Scanning the file
				// Time complexity of while loop O(x)
				// x - number of characters
				while (scanner.hasNextLine()) {
					String input = scanner.nextLine();
					StringBuilder output = new StringBuilder();
					// Encoding the input
					output = Encode.Encoding(input);
					// Output GUI
					appendText("[DECODED]\n" + input + "\n");
					appendText("[ENCODED]\n" + output.toString() + "\n");
					// Output console
					System.out.println("[DECODED] \n" + input);
					System.out.println("[ENCODED] \n" + output.toString());
				}
				// Close the scanner
				scanner.close();
				// In case of error
				
			} catch (FileNotFoundException eeee) {
				// Console output
				System.out.println("An error occurred.");
				// Handle exception and errors
				eeee.printStackTrace();
				// GUI output
				appendText("File not found.\n");
			}
		});
		// DECODING BUTTON
		// Time complexity based on size of the file being encoded
		// Time complexity of this block of code with "Decode.decoding" is O(xy)
		// x - number of characters in a file
		// y - number of lines
		var btnDecodeFile = new JButton("Decode");
		btnDecodeFile.addActionListener(e -> {
			// Path
			// Call getText() to get the file name
			String path = txtFilePath.getText();
			replaceText("Decoding.....\n" + path + "\n\n");

			// Block of code being tested while executed
			try {
				// File and scanner
				File file = new File(path);
				Scanner scanner = new Scanner(file);

				// Scanning the file
				while (scanner.hasNextLine()) {
					String input = scanner.nextLine();
					StringBuilder output = new StringBuilder();
					// Decoding the input
					output = Decode.Decoding(input);
					// Output GUI
					appendText("[ENCODED]\n" + input + "\n");
					appendText("[DECODED]\n" + output.toString() + "\n");
					// Output console
					System.out.println("[ENCODED] " + input);
					System.out.println("[DECODED] " + output.toString());
				}
				// Close the scanner
				scanner.close();
				// In case of error
			} catch (FileNotFoundException eeee) {
				// Console output
				System.out.println("An error occurred.");
				// Handle exception and errors
				eeee.printStackTrace();
				// GUI output
				appendText("File not found.\n");
			}
		});

		// Add all the components to the panel and the panel to the window
		top.add(txtFilePath);
		top.add(chooser);
		top.add(btnEncodeFile);
		top.add(btnDecodeFile);
		win.getContentPane().add(top); // Add the panel to the window

		/*
		 * The middle panel contains the coloured square and the text area for
		 * displaying the outputted text.
		 */
		var middle = new JPanel(new FlowLayout(FlowLayout.LEADING));
		middle.setPreferredSize(new Dimension(600, 200));

		var dot = new JPanel();
		dot.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		dot.setBackground(getRandomColour());
		dot.setPreferredSize(new Dimension(140, 150));
		dot.addMouseListener(new MouseAdapter() {
			// Can't use a lambda against MouseAdapter because it is not a SAM
			public void mousePressed(MouseEvent e) {
				dot.setBackground(getRandomColour());
			}
		});

		// Add the text area
		txtOutput.setLineWrap(true);
		txtOutput.setWrapStyleWord(true);
		txtOutput.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

		var scroller = new JScrollPane(txtOutput);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setPreferredSize(new Dimension(450, 150));
		scroller.setMaximumSize(new Dimension(450, 150));

		// Add all the components to the panel and the panel to the window
		middle.add(dot);
		middle.add(scroller);
		win.getContentPane().add(middle);

		/*
		 * The bottom panel contains the clear and quit buttons.
		 */
		var bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottom.setPreferredSize(new java.awt.Dimension(500, 50));

		// Create and add Clear and Quit buttons
		var clear = new JButton("Clear");
		clear.addActionListener((e) -> txtOutput.setText(""));

		var quit = new JButton("Quit");
		quit.addActionListener((e) -> System.exit(0));

		// Add all the components to the panel and the panel to the window
		bottom.add(clear);
		bottom.add(quit);
		win.getContentPane().add(bottom);

		/*
		 * All done. Now show the configured Window.
		 */
		win.setVisible(true);
	}

	private Color getRandomColour() {
		Colour c = colours[rand.nextInt(0, colours.length)];
		return Color.decode(c.hex() + "");
	}

	protected void replaceText(String text) {
		txtOutput.setText(text);
	}

	protected void appendText(String text) {
		txtOutput.setText(txtOutput.getText() + " " + text);
	}
}