package calculatorFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {
    @FXML
    private TextField display;

    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    private CalculadoraDAO dao;

    public CalculadoraController() {
        dao = new CalculadoraDAO();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        
        switch (value) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = value;
                num1 = Double.parseDouble(display.getText());
                display.clear();
                break;
            case "=":
                num2 = Double.parseDouble(display.getText());
                result = calculateResult();
                display.setText(String.valueOf(result));
                dao.saveOperation(num1 + " " + operator + " " + num2 + " = " + result);
                break;
            default:
                display.setText(display.getText() + value);
        }
    }

    private double calculateResult() {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }
}
