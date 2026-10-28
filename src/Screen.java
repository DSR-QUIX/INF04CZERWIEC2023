import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Screen extends JFrame{

    private JTextField adressDetails;
    private JTextField postalCode;
    private JTextField city;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton[] buttons;
    private JButton submit;
    private JLabel price;
    private HashMap<String, Values> priceList;
    private JLabel imageLabel;
    private ImageIcon image;
    private JPanel imageAndPricePanel;
    private GridBagConstraints gridBagLayout;
    private JButton buttonPrice;
    record Values(String FirstValue, String SecondValue) {};

    public Screen(){


        priceList = new HashMap<String, Values>();
        priceList.put("src/drawable/pocztowka.png", new Values("Cena: 1zł" , "Pocztówka"));
        priceList.put("src/drawable/list.png", new Values("Cena: 1,5zł" , "List"));
        priceList.put("src/drawable/paczka.png", new Values("Cena: 10zł" , "Paczka"));

        JFrame frame = new JFrame("Nadaj Przesyłkę, 00000000000");
        JPanel center = new JPanel(new GridBagLayout());
        JPanel leftGroup = new JPanel(new GridBagLayout());
        gridBagLayout = new GridBagConstraints();
        JPanel dialogWindow = new JPanel(new GridLayout(3, 1 , 0 , 5));
        JPanel adressDetailsPanel = new JPanel(new GridLayout(6,1, 0,5));
        imageAndPricePanel = new JPanel(new GridBagLayout());

        radioButton1 = new JRadioButton("Pocztówka");
        radioButton2 = new JRadioButton("List");
        radioButton3 = new JRadioButton("Paczka");

        buttons = new JRadioButton[] {radioButton1, radioButton2, radioButton3};

        JLabel adressDetetailsLabel = new JLabel("Ulica z numerem");
        adressDetails = new JTextField(25);

        JLabel postalCodeLabel = new JLabel("Kod pocztowy");
        postalCode = new JTextField(25);

        JLabel cityLabel = new JLabel("Miasto");
        city = new JTextField(25);

        buttonPrice = new JButton("Sprawdź cenę");

        image = new ImageIcon("src/drawable/pocztowka.png");
        imageLabel = new JLabel(image);


        price = new JLabel("Cena: ");

        submit = new JButton("Zatwierdź");

        Border blackLine = BorderFactory.createLineBorder(Color.black, 1, true);

        CompoundBorder titledBorderLeft = BorderFactory.createCompoundBorder
                (BorderFactory.createTitledBorder(blackLine, "Rodzaj przesyłki", TitledBorder.LEFT, TitledBorder.CENTER),
                        BorderFactory.createEmptyBorder(5,0, 5, 120)
                );

        CompoundBorder titledBorderRight = BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(blackLine, "Dane adresowe", TitledBorder.LEFT, TitledBorder.CENTER),
                BorderFactory.createEmptyBorder(10, 10, 25, 30)
        );

        dialogWindow.setBorder(titledBorderLeft);
        adressDetailsPanel.setBorder(titledBorderRight);



        radioButton1.setSelected(true);


        ButtonGroup group = new ButtonGroup();


        for (JRadioButton button : buttons){
            group.add(button);
            dialogWindow.add(button);
        }


        price.setFont(new Font("", Font.BOLD, 18));

        adressDetailsPanel.add(adressDetetailsLabel);
        adressDetailsPanel.add(adressDetails);
        adressDetailsPanel.add(postalCodeLabel);
        adressDetailsPanel.add(postalCode);
        adressDetailsPanel.add(cityLabel);
        adressDetailsPanel.add(city);

        gridBagLayout.fill = GridBagConstraints.NONE;
        gridBagLayout.insets = new Insets(0,0,0,9);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        gridBagLayout.weightx = 0.0;
        gridBagLayout.anchor = GridBagConstraints.WEST;
        imageAndPricePanel.add(imageLabel, gridBagLayout);

        gridBagLayout.gridx = 1;
        gridBagLayout.gridy = 0;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.anchor = GridBagConstraints.NORTHWEST;
        imageAndPricePanel.add(price, gridBagLayout);


        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.insets = new Insets(0, 0,10,20);


        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.weighty = 0.0;
        leftGroup.add(dialogWindow, gridBagLayout);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 1;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.weighty = 0.0;
        leftGroup.add(buttonPrice, gridBagLayout);

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 2;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.weighty = 0.0;
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.WEST;
        leftGroup.add(imageAndPricePanel, gridBagLayout);


        //Grid Center
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.anchor = GridBagConstraints.NORTH;

        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 0;
        gridBagLayout.weightx = 2.0;
        gridBagLayout.weighty = 1.0;
        center.add(leftGroup, gridBagLayout);

        gridBagLayout.gridx = 1;
        gridBagLayout.gridy = 0;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.weighty = 1.0;
        center.add(adressDetailsPanel, gridBagLayout);


        gridBagLayout.gridx = 0;
        gridBagLayout.gridy = 1;
        gridBagLayout.weightx = 1.0;
        gridBagLayout.weighty = 0.0;
        gridBagLayout.gridwidth = 2;
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;
        center.add(submit, gridBagLayout);

        center.setBorder(new EmptyBorder(20, 40, 0, 20));


        frame.add(center);


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public ArrayList<String> getTextFromPolls(){
        ArrayList<String> getTextList = new ArrayList<String>();
        getTextList.add(adressDetails.getText());
        getTextList.add(postalCode.getText());
        getTextList.add(city.getText());

        return getTextList;
    }

    public HashMap<String, Values> getPriceHashMap(){
        return priceList;
    }

    public JButton getCheckPrice(){
        return buttonPrice;
    }

    public JRadioButton[] getRadioButtons(){
        return buttons;
    }
    public JButton getSubmit(){
        return submit;
    }

    public void setImageAndPricePanel(String newImageLabel,String newPriceLabel){


        ImageIcon image = new ImageIcon(newImageLabel);
        JLabel newPrice = new JLabel(newPriceLabel);


        imageLabel.setIcon(image);
        price.setText(newPriceLabel);

        imageAndPricePanel.revalidate();
        imageAndPricePanel.repaint();
    }
}
