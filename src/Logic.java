import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    private Screen view;

    public Logic(Screen view){
        this.view = view;

        Collisions();
        Checked();
    }

    private void Collisions(){
        view.getCheckPrice().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                HashMap<String, Screen.Values> hashMap = view.getPriceHashMap();
                JRadioButton[] radioButtons = view.getRadioButtons();


                String selectedRadioButton = null;

                for (int i = 0; i < radioButtons.length; i++){
                    if (radioButtons[i].isSelected()){
                        selectedRadioButton = radioButtons[i].getText();
                        break;
                    }

                }

                for (Map.Entry<String, Screen.Values> entry : hashMap.entrySet()){

                    if (entry.getValue().SecondValue().equals(selectedRadioButton)){
                        String imageLabel = entry.getKey();
                        String priceLabel = entry.getValue().FirstValue();

                        view.setImageAndPricePanel(imageLabel, priceLabel);
                    }


                }

            }
        });
    }
    private void Checked(){
        view.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> list = view.getTextFromPolls();

                if (list.get(1).length() == 5 && list.get(1).matches("[0-9]+")){
                    System.out.println("Dane przesyłki zostały wprowadzone");
                }
                else {
                    System.out.println("Nieprawidłowa liczba cyfr w kodzie pocztowym");
                }
            }
        });
    }
}
