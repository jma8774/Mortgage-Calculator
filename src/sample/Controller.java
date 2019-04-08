package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Controller {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField purchasePriceText;
    @FXML
    private TextField downPaymentText;
    @FXML
    private TextField interestRateText;
    @FXML
    private TextField titleLabel;
    @FXML
    private TextField purchasePriceLabel;
    @FXML
    private TextField downPaymentLabel;
    @FXML
    private TextField interestRateLabel;
    @FXML
    private TextField yearLabel;
    @FXML
    private TextField monthLabel;
    @FXML
    private Slider slider;
    @FXML
    private Slider slider2;
    @FXML
    private TextField displayLabel1;
    @FXML
    private TextField displayLabel2;
    @FXML
    private TextField displayLabel3;
    @FXML
    private TextField displayLabel4;
    @FXML
    private TextField displayLabel5;
    @FXML
    private TextField displayLabel6;
    @FXML
    private TextField displayAnswer1;
    @FXML
    private TextField displayAnswer2;
    @FXML
    private TextField displayAnswer3;
    @FXML
    private TextField displayAnswer4;
    @FXML
    private TextField displayAnswer5;
    @FXML
    private TextField displayAnswer6;

    private int purchasePrice;
    private int downPayment;
    private double interestRate;
    private double interestRateMonth;
    private int loanAmount;
    private int year;
    private int month;

    private ArrayList<TextField> displayLabels;
    private ArrayList<TextField> displayAnswers;

    @FXML
    public void initialize() {
        displayLabels = new ArrayList<TextField>();
        displayLabels.add(displayLabel1);
        displayLabels.add(displayLabel2);
        displayLabels.add(displayLabel3);
        displayLabels.add(displayLabel4);
        displayLabels.add(displayLabel5);
        displayLabels.add(displayLabel6);

        displayAnswers = new ArrayList<TextField>();
        displayAnswers.add(displayAnswer1);
        displayAnswers.add(displayAnswer2);
        displayAnswers.add(displayAnswer3);
        displayAnswers.add(displayAnswer4);
        displayAnswers.add(displayAnswer5);
        displayAnswers.add(displayAnswer6);


        year = (int) slider.getValue();
        yearLabel.setText("Select year: " + year);
        month = (year * 12) + (int) slider2.getValue();
        monthLabel.setText("Select month: " + (int) slider2.getValue());
        displayLabel4.setText("Monthly payment in " + year + " years " + (int) (slider2.getValue()) + " months: ");

        changeDisplayAnswers();
    }

    public void changeDisplayAnswers(){
        loanAmount = purchasePrice - downPayment;
        displayAnswer1.setText(Integer.toString(loanAmount));
        displayAnswer2.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),10*12)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, 10*12)))));
        displayAnswer5.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),20*12)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, 20*12)))));
        displayAnswer3.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),30*12)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, 30*12)))));
        displayAnswer6.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),40*12)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, 40*12)))));
        displayAnswer4.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),month)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, month)))));
    }

    @FXML
    public void onKeyTypePP(){
        try {
            purchasePrice = Integer.parseInt(purchasePriceText.getText());
            changeDisplayAnswers();
        } catch (Exception NumberFormatException) {
            System.out.println("NumberFormatException: User entered a letter");
            for(TextField t: displayAnswers)
                t.setText("");
        }
    }

    @FXML
    public void onKeyTypeDP(){
        try {
            downPayment = Integer.parseInt(downPaymentText.getText());
            changeDisplayAnswers();
        } catch (Exception NumberFormatException) {
            System.out.println("NumberFormatException: User entered a letter");
            for(TextField t: displayAnswers)
                t.setText("");
        }
    }

    @FXML
    public void onKeyTypeIR(){
        try {
            interestRate = Double.parseDouble(interestRateText.getText());
            interestRateMonth = interestRate / 12;
            changeDisplayAnswers();
        } catch (Exception NumberFormatException) {
            System.out.println("NumberFormatException: User entered a letter");
            for(TextField t: displayAnswers)
                t.setText("");
        }
    }

    @FXML
    public void onSliderDrag() {
        year = (int) slider.getValue();
        yearLabel.setText("Select year: " + year);
        month = (year * 12) + (int) slider2.getValue();
        monthLabel.setText("Select month: " + (int) slider2.getValue());
        displayLabel4.setText("Monthly payment in " + year + " years " + (int) (slider2.getValue()) + " months: ");
        displayAnswer4.setText(Double.toString(loanAmount / ((Math.pow((1+interestRateMonth),month)-1) / (interestRateMonth*Math.pow(1+interestRateMonth, month)))));
    }

    @FXML
    public void deselect(){
        titleLabel.deselect();
        purchasePriceLabel.deselect();
        downPaymentLabel.deselect();
        interestRateLabel.deselect();
        yearLabel.deselect();
        for(TextField t:displayLabels)
            t.deselect();
        for(TextField t:displayAnswers)
            t.deselect();

    }
}
