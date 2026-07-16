package uhgukg.projectopp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Abstract Player class
abstract class Player {
    private String name;
    private int age;
    private String type;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public abstract String getStats();
}

// Batsman class
class Batsman extends Player {
    private int runs;
    private int matches;
    private float battingAverage;

    public void setBatsmanStats(int runs, int matches, float battingAverage) {
        this.runs = runs;
        this.matches = matches;
        this.battingAverage = battingAverage;
    }

    @Override
    public String getStats() {
        return String.format(
            "Player Type: Batsman\nName: %s\nAge: %d\nRuns: %d\nMatches: %d\nBatting Average: %.2f\n",
            getName(), getAge(), runs, matches, battingAverage);
    }
}

// Bowler class
class Bowler extends Player {
    private int runs;
    private int wickets;
    private int matches;
    private float battingAverage;
    private float economy;

    public void setBowlerStats(int wickets, int matches, float economy, int runs, float battingAverage) {
        this.wickets = wickets;
        this.matches = matches;
        this.economy = economy;
        this.runs = runs;
        this.battingAverage = battingAverage;
    }

    @Override
    public String getStats() {
        return String.format(
            "Player Type: Bowler\nName: %s\nAge: %d\nRuns: %d\nWickets: %d\nMatches: %d\nBatting Average: %.2f\nEconomy: %.2f\n",
            getName(), getAge(), runs, wickets, matches, battingAverage, economy);
    }
}

// Allrounder class
class Allrounder extends Player {
    private int runs;
    private int wickets;
    private int matches;
    private float battingAverage;
    private float economy;

    public void setAllrounderStats(int runs, int wickets, int matches, float battingAverage, float economy) {
        this.runs = runs;
        this.wickets = wickets;
        this.matches = matches;
        this.battingAverage = battingAverage;
        this.economy = economy;
    }

    @Override
    public String getStats() {
        return String.format(
            "Player Type: Allrounder\nName: %s\nAge: %d\nRuns: %d\nWickets: %d\nMatches: %d\nBatting Average: %.2f\nEconomy: %.2f\n",
            getName(), getAge(), runs, wickets, matches, battingAverage, economy);
    }
}

// Main GUI class
public class PROJECTOPP extends JFrame {
    private JComboBox<String> typeBox;
    private JTextField nameField, ageField, runsField, wicketsField, matchesField, avgField, ecoField;
    private JTextArea outputArea;
    private ArrayList<Player> players = new ArrayList<>();

    public PROJECTOPP() {
        setTitle("Cricket Player Stats Management System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Cricket Player Stats Management System");
        titleLabel.setBounds(120, 10, 350, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        // Player Type
        addLabel("Player Type:", 20, 60, 100, 25);
        typeBox = new JComboBox<>(new String[] { "Batsman", "Bowler", "Allrounder" });
        typeBox.setBounds(130, 60, 120, 25);
        add(typeBox);

        // Name
        addLabel("Name:", 20, 100, 100, 25);
        nameField = new JTextField();
        nameField.setBounds(130, 100, 150, 25);
        add(nameField);

        // Age
        addLabel("Age:", 20, 140, 100, 25);
        ageField = new JTextField();
        ageField.setBounds(130, 140, 50, 25);
        add(ageField);

        // Runs
        addLabel("Runs:", 20, 180, 100, 25);
        runsField = new JTextField();
        runsField.setBounds(130, 180, 80, 25);
        add(runsField);

        // Wickets
        addLabel("Wickets:", 20, 220, 100, 25);
        wicketsField = new JTextField();
        wicketsField.setBounds(130, 220, 80, 25);
        add(wicketsField);

        // Matches
        addLabel("Matches:", 20, 260, 100, 25);
        matchesField = new JTextField();
        matchesField.setBounds(130, 260, 80, 25);
        add(matchesField);

        // Batting Average
        addLabel("Batting Average:", 20, 300, 120, 25);
        avgField = new JTextField();
        avgField.setBounds(140, 300, 80, 25);
        add(avgField);

        // Economy Rate
        addLabel("Economy Rate:", 20, 340, 120, 25);
        ecoField = new JTextField();
        ecoField.setBounds(140, 340, 80, 25);
        add(ecoField);

        JButton addButton = new JButton("Add Player");
        addButton.setBounds(130, 390, 120, 30);
        add(addButton);

        JButton showButton = new JButton("Show All Players");
        showButton.setBounds(270, 390, 150, 30);
        add(showButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setBounds(20, 430, 540, 120);
        add(scroll);

        // Action Listeners
        addButton.addActionListener(e -> addPlayer());
        showButton.addActionListener(e -> showAllPlayers());

        // Optional: Enable/disable fields based on player type
        typeBox.addActionListener(e -> updateFields());

        updateFields(); // set initial state
    }

    private void addLabel(String text, int x, int y, int width, int height) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, width, height);
        add(lbl);
    }

    private void updateFields() {
        String type = (String) typeBox.getSelectedItem();

        // Enable/disable fields based on player type
        if ("Batsman".equals(type)) {
            runsField.setEnabled(true);
            wicketsField.setEnabled(false);
            matchesField.setEnabled(true);
            avgField.setEnabled(true);
            ecoField.setEnabled(false);
        } else if ("Bowler".equals(type)) {
            runsField.setEnabled(true); // now enabled to add runs & batting average
            wicketsField.setEnabled(true);
            matchesField.setEnabled(true);
            avgField.setEnabled(true);
            ecoField.setEnabled(true);
        } else { // Allrounder
            runsField.setEnabled(true);
            wicketsField.setEnabled(true);
            matchesField.setEnabled(true);
            avgField.setEnabled(true);
            ecoField.setEnabled(true);
        }
    }

    private void addPlayer() {
        try {
            String type = (String) typeBox.getSelectedItem();
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            int runs = runsField.getText().trim().isEmpty() ? 0 : Integer.parseInt(runsField.getText().trim());
            int wickets = wicketsField.getText().trim().isEmpty() ? 0 : Integer.parseInt(wicketsField.getText().trim());
            int matches = matchesField.getText().trim().isEmpty() ? 0 : Integer.parseInt(matchesField.getText().trim());
            float battingAvg = avgField.getText().trim().isEmpty() ? 0 : Float.parseFloat(avgField.getText().trim());
            float economy = ecoField.getText().trim().isEmpty() ? 0 : Float.parseFloat(ecoField.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the player's name.");
                return;
            }

            if ("Batsman".equals(type)) {
                Batsman b = new Batsman();
                b.setType(type);
                b.setName(name);
                b.setAge(age);
                b.setBatsmanStats(runs, matches, battingAvg);
                players.add(b);
            } else if ("Bowler".equals(type)) {
                Bowler b = new Bowler();
                b.setType(type);
                b.setName(name);
                b.setAge(age);
                b.setBowlerStats(wickets, matches, economy, runs, battingAvg);
                players.add(b);
            } else if ("Allrounder".equals(type)) {
                Allrounder a = new Allrounder();
                a.setType(type);
                a.setName(name);
                a.setAge(age);
                a.setAllrounderStats(runs, wickets, matches, battingAvg, economy);
                players.add(a);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a valid player type.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Player added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values in all required fields.");
        }
    }

    private void showAllPlayers() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p.getStats()).append("\n------------------\n");
        }
        outputArea.setText(sb.toString());
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        runsField.setText("");
        wicketsField.setText("");
        matchesField.setText("");
        avgField.setText("");
        ecoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PROJECTOPP app = new PROJECTOPP();
            app.setVisible(true);
        });
    }
}
