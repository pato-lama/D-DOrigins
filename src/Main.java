import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.awt.event.ActionEvent;


public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("This Is Your Life Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGenerateOrigins = new JButton("Generate Origins");
		btnGenerateOrigins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateChar();
				
			}

			private void generateChar() {
				File newChar = new File("origin.txt");
				try (Writer writer = new BufferedWriter(new FileWriter(newChar))){
					String clas = getClas(); //cannot write Class so wrote Clas instead
					String race = getRace();
					String alignment = getAlignment();
					String parents = getParents(race);
					String birthplace = getBirthplace();
					writer.write(clas + race + alignment + parents + birthplace);
					System.out.println(clas + race + alignment + parents + birthplace);
				}
				catch (IOException e) {
					
				}
			}
			
			private String getBirthplace() {
				Random rand = new Random();
				int seed = rand.nextInt(100) + 1;
				StringBuilder sb = new StringBuilder();
				sb.append("Birthplace: ");
				if(isBetween(seed, 1, 50)) {
					sb.append("Home\r\n");
				}
				else if(isBetween(seed, 51, 55)) {
					sb.append("Home of a family friend\r\n");
				}
				else if(isBetween(seed, 56, 63)) {
					sb.append("Home of a healer or midwife\r\n");
				}
				else if(isBetween(seed, 64, 65)) {
					sb.append("Carriage, cart, or wagon\r\n");
				}
				else if(isBetween(seed, 66, 68)) {
					sb.append("Barn, shed, or other outbuilding\r\n");
				}
				else if(isBetween(seed, 69, 70)) {
					sb.append("Cave\r\n");
				}
				else if(isBetween(seed, 71, 72)) {
					sb.append("Field\r\n");
				}
				else if(isBetween(seed, 73, 74)) {
					sb.append("Forest\r\n");
				}
				else if(isBetween(seed, 75, 77)) {
					sb.append("Temple\r\n");
				}
				else if(isBetween(seed, 78, 78)) {
					sb.append("Battlefield\r\n");
				}
				else if(isBetween(seed, 79, 80)) {
					sb.append("Alley or street\r\n");
				}
				else if(isBetween(seed, 81, 82)) {
					sb.append("Brothel, tavern, or inn\r\n");
				}
				else if(isBetween(seed, 83, 84)) {
					sb.append("Castle, keep, tower, or palace\r\n");
				}
				else if(isBetween(seed, 85, 85)) {
					sb.append("Sewer or rubbish heap\r\n");
				}
				else if(isBetween(seed, 86, 88)) {
					sb.append("Among people of a different race\r\n");
				}
				else if(isBetween(seed, 89, 91)) {
					sb.append("On board a boat or a ship\r\n");
				}
				else if(isBetween(seed, 92, 93)) {
					sb.append("In a prison or in the headquarters of a secret organization\r\n");
				}
				else if(isBetween(seed, 94, 95)) {
					sb.append("In a sage's laboratory\r\n");
				}
				else if(isBetween(seed, 96, 96)) {
					sb.append("In the Feywild\r\n");
				}
				else if(isBetween(seed, 97, 97)) {
					sb.append("In the Shadowfell\r\n");
				}
				else if(isBetween(seed, 98, 98)) {
					sb.append("On the Astral Plane or Ethereal Plane\r\n");
				}
				else if(isBetween(seed, 99, 99)) {
					sb.append("On an Inner Plane of your choice\r\n");
				}
				else {
					sb.append("On an Outer Plane of your choice. A strange event coincided with your birth.\r\n");
				}
				
				return sb.toString();
			}
			private String getParents(String race) {
				Random rand = new Random();
				int seed = rand.nextInt(100) + 1;
				StringBuilder sb = new StringBuilder();
				if(isBetween(seed, 1, 95)) {
					sb.append("You know who your parents are or were.\r\n");
				} else {
					sb.append("You do not know who your parents were.\r\n");
				}
				if (race.equals("Half-elf\r\n")) {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(8) + 1;
					if (isBetween(newSeed, 1, 5)) {
						sb.append("One parent was an elf and the other was a human.\r\n");
					} 
					else if(newSeed == 6) {
						sb.append("One parent was an elf and the other was a half-elf.\r\n");
					}
					else if(newSeed == 7) {
						sb.append("One parent was a human and the other was a half-elf.\r\n");
					} 
					else {
						sb.append("Both parents were half-elves.\r\n");
					}
				}
				else if (race.equals("Half-orc\r\n")) {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(8) + 1;
					if (isBetween(newSeed, 1, 3)) {
						sb.append("One parent was an orc and the other was a human.\r\n");
					} 
					else if(isBetween(newSeed, 4, 5)) {
						sb.append("One parent was an orc and the other was a half-orc.\r\n");
					}
					else if(isBetween(newSeed, 6, 7)) {
						sb.append("One parent was a human and the other was a half-orc.\r\n");
					} 
					else {
						sb.append("Both parents were half-orcs.\r\n");
					}
				}
				else if (race.equals("Tiefling\r\n")) {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(8) + 1;
					if (isBetween(newSeed, 1, 4)) {
						sb.append("Both parents were humans, their infernal heritage dormant until you came along.\r\n");
					} 
					else if(isBetween(newSeed, 5, 6)) {
						sb.append("One parent was a tiefling and the other was a human.\r\n");
					}
					else if(isBetween(newSeed, 7, 7)) {
						sb.append("One parent was a tiefling and the other was a devil.\r\n");
					} 
					else {
						sb.append("One parent was a human and the other was a devil.\r\n");
					}
				}
				return sb.toString();
			}
			
			private String getAlignment() {
				Random rand = new Random();
				int seed = rand.nextInt(16) + 3;
				String result = "";
				if(seed == 3) {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(2) + 1;
					if (newSeed == 1) {
						result = "Chaotic evil\r\n";
					} else {
						result = "Chaotic neutral\r\n";
					}
				}
				else if(isBetween(seed, 4, 5)) {
					result = "Lawful evil\r\n";
				}
				else if(isBetween(seed, 6, 8)) {
					result = "Neutral evil\r\n";
				}
				else if(isBetween(seed, 9, 12)) {
					result = "Neutral\r\n";
				}
				else if(isBetween(seed, 13, 15)) {
					result = "Neutral good\r\n";
				}
				else if(isBetween(seed, 16, 17)) {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(2) + 1;
					if (newSeed == 1) {
						result = "Lawful good\r\n";
					} else {
						result = "Lawful neutral\r\n";
					}
				}
				else {
					Random newRand = new Random();
					int newSeed = newRand.nextInt(2) + 1;
					if (newSeed == 1) {
						result = "Chaotic good\r\n";
					} else {
						result = "Chaotic neutral\r\n";
					}
				}
				return result;
			}
			private String getRace() {
				Random rand = new Random();
				int seed = rand.nextInt(100) + 1;
				String result = "";
				if (isBetween(seed, 1, 40)) {
					result = "Human\r\n";
				}
				else if(isBetween(seed, 41, 50)) {
					result = "Dwarf\r\n";
				}
				else if(isBetween(seed, 51, 60)) {
					result = "Elf\r\n";
				}
				else if(isBetween(seed, 61, 70)) {
					result = "Halfling\r\n";
				}
				else if(isBetween(seed, 71, 75)) {
					result = "Dragonborn\r\n";
				}
				else if(isBetween(seed, 76, 80)) {
					result = "Gnome\r\n";
				}
				else if(isBetween(seed, 81, 85)) {
					result = "Half-elf\r\n";
				}
				else if(isBetween(seed, 86, 90)) {
					result = "Half-orc\r\n";
				}
				else if(isBetween(seed, 91, 95)) {
					result = "Tiefling\r\n";
				}
				else {
					result = "DM's choice (or your choice).\r\n";
				}
				return result;
			}
			private String getClas() {		//returns a random class
				Random rand = new Random();
				String result = "";
				int seed = rand.nextInt(100) + 1;
				switch(seed) {
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: {
					result = "Barbarian\r\n";
					break;
				}
				case 8: case 9: case 10: case 11: case 12: case 13:case 14: {
					result = "Bard\r\n";
					break;
				}
				case 15: case 16: case 17: case 18: case 19: case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29: {
					result = "Cleric\r\n";
					break;
				}
				case 30: case 31: case 32: case 33: case 34: case 35:case 36: {
					result = "Druid\r\n";
					break;
				}
				case 37: case 38:case 39:case 40:case 41:case 42:case 43:case 44:case 45:case 46:case 47:case 48:case 49:case 50:case 51:case 52: {
					result = "Fighter\r\n";
					break;
				}
				case 53:case 54:case 55:case 56:case 57:case 58: {
					result = "Monk\r\n";
					break;
				}
				case 59:case 60:case 61:case 62:case 63:case 64: {
					result = "Paladin\r\n";
					break;
				}
				case 65: case 66: case 67: case 68: case 69:case 70: {
					result = "Ranger\r\n";
					break;
				}
				case 71:case 72:case 73:case 74:case 75:case 76:case 77:case 78:case 79:case 80:case 81:case 82:case 83:case 84: {
					result = "Rogue\r\n";
					break;
				}
				case 85:case 86:case 87:case 88:case 89: {
					result = "Sorcerer\r\n";
					break;
				}
				case 90:case 91:case 92:case 93:case 94: {
					result = "Warlock\r\n";
					break;
				}
				case 95: case 96:case 97:case 98:case 99:case 100: {
					result = "Wizard\r\n";
					break;
				}
				default: {
					result = "Pick a class!";
				}
				}
				return result;
			}
			
			private boolean isBetween(int x, int lower, int upper) {
				  return lower <= x && x <= upper;
				}

		});
		btnGenerateOrigins.setBounds(335, 256, 148, 23);
		contentPane.add(btnGenerateOrigins);
	}
}
