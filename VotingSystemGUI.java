
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VotingSystemGUI extends JFrame implements ActionListener {
    private Map<String, String[]> statePartiesMap;
    private JComboBox<String> stateComboBox;
    private JList<String> partiesList;
    private JButton confirmButton;

    public VotingSystemGUI() {
        statePartiesMap = new HashMap<>();
statePartiesMap.put("Andhra Pradesh", new String[]{"BJP", "TDP", "YSRCP"});
statePartiesMap.put("Arunachal Pradesh", new String[]{"BJP", "INC", "NPP"});
statePartiesMap.put("Assam", new String[]{"BJP", "AGP", "INC"});
statePartiesMap.put("Bihar", new String[]{"BJP", "JD(U)", "RJD"});
statePartiesMap.put("Chhattisgarh", new String[]{"BJP", "INC"});
statePartiesMap.put("Goa", new String[]{"BJP", "INC"});
statePartiesMap.put("Gujarat", new String[]{"BJP", "INC"});
statePartiesMap.put("Haryana", new String[]{"BJP", "INC"});
statePartiesMap.put("Himachal Pradesh", new String[]{"BJP", "INC"});
statePartiesMap.put("Jharkhand", new String[]{"BJP", "JMM", "INC"});
statePartiesMap.put("Karnataka", new String[]{"BJP", "INC", "JD(S)"});
statePartiesMap.put("Kerala", new String[]{"CPI(M)", "INC"});
statePartiesMap.put("Madhya Pradesh", new String[]{"BJP", "INC"});
statePartiesMap.put("Maharashtra", new String[]{"BJP", "SS", "NCP"});
statePartiesMap.put("Manipur", new String[]{"BJP", "INC"});
statePartiesMap.put("Meghalaya", new String[]{"NPP", "BJP", "INC"});
statePartiesMap.put("Mizoram", new String[]{"MNF", "ZPM"});
statePartiesMap.put("Nagaland", new String[]{"NDPP", "BJP"});
statePartiesMap.put("Odisha", new String[]{"BJD", "BJP", "INC"});
statePartiesMap.put("Punjab", new String[]{"AAP", "BJP", "INC"});
statePartiesMap.put("Rajasthan", new String[]{"BJP", "INC"});
statePartiesMap.put("Sikkim", new String[]{"SKM", "BJP"});
statePartiesMap.put("Tamil Nadu", new String[]{"DMK", "AIADMK", "BJP"});
statePartiesMap.put("Telangana", new String[]{"TRS", "BJP"});
statePartiesMap.put("Tripura", new String[]{"BJP", "INC"});
statePartiesMap.put("Uttar Pradesh", new String[]{"BJP", "SP", "BSP"});
statePartiesMap.put("Uttarakhand", new String[]{"BJP", "INC"});
statePartiesMap.put("West Bengal", new String[]{"AITC","BJP"});
        
        stateComboBox = new JComboBox<>(statePartiesMap.keySet().toArray(new String[0]));
        stateComboBox.setBounds(100, 50, 150, 30);
        stateComboBox.addActionListener(e -> updatePartiesList());

        partiesList = new JList<>();
        partiesList.setBounds(100, 100, 150, 100);
        JScrollPane scrollPane = new JScrollPane(partiesList);
        scrollPane.setBounds(100, 100, 150, 100);

        confirmButton = new JButton("Confirm Vote");
        confirmButton.setBounds(100, 220, 150, 30);
        confirmButton.addActionListener(this);

        add(stateComboBox);
        add(scrollPane);
        add(confirmButton);

        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VotingSystemGUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String selectedState = stateComboBox.getSelectedItem().toString();
            String[] parties = partiesList.getSelectedValuesList().toArray(new String[0]);

            // In a real system, you would store the vote and handle confirmation appropriately
            System.out.println("Vote confirmed for " + String.join(", ", parties) + " in " + selectedState);
        }
    }

    private void updatePartiesList() {
        String selectedState = stateComboBox.getSelectedItem().toString();
        String[] parties = statePartiesMap.get(selectedState);
        partiesList.setListData(parties);

        // Color coding based on the selected state
        switch (selectedState) {
            case "Andhra Pradesh":
              getContentPane().setBackground(Color.GREEN); // YSRCP
              break;
         
             
            case "Bihar":
              getContentPane().setBackground(Color.GREEN); // JD(U)
              break;
            case "Chhattisgarh":
              getContentPane().setBackground(Color.BLUE); // INC
              break;
           
           
            case "Jharkhand":
              getContentPane().setBackground(Color.GRAY); // BJP
              break;
            
            case "Kerala":
              getContentPane().setBackground(Color.RED); // CPI(M)
              break;
            
            
            case "Meghalaya":
              getContentPane().setBackground(Color.ORANGE); // NPP
              break;
            case "Mizoram":
              getContentPane().setBackground(Color.BLUE); // MNF
              break;
            case "Nagaland":
              getContentPane().setBackground(Color.WHITE); // NDPP
              break;
            case "Odisha":
              getContentPane().setBackground(Color.GREEN); // BJD
              break;
            
            case "Sikkim":
              getContentPane().setBackground(Color.WHITE); // SKM
              break;
            case "Tamil Nadu":
              getContentPane().setBackground(Color.BLACK); // DMK
              break;
            case "Telangana":
              getContentPane().setBackground(Color.PINK); // BRS
              break;
          
            
            case "West Bengal":
              getContentPane().setBackground(Color.GREEN); // AITC
              break;
            default:
              getContentPane().setBackground(Color.ORANGE);
              break;
          }
        }
    }

