/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.utilits;

/**
 *
 * @author moetez
 */
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Moetez Hechmi Groun
 */
public class ControleSaisie {

    public ControleSaisie() {
    }

    public static boolean controleTextFieldVide(TextField textField, String msg, Label errorLabel) {
        String chaine = textField.getText().trim();
        if (chaine.length() == 0) {
            errorLabel.setText(msg);
            textField.clear();
            return true;
        }
        return false;
    }

   

    public static void effacerControleSaisie(Label textField) {
        textField.setText("");
    }

    public static boolean controleTextFieldNonNumerique(TextField textField, String msg, Label errorLabel) {
        if (!textField.getText().matches(".*[a-zA-Z].*")) {
            errorLabel.setText(msg);

            return true;
        }
        return false;
    }

    public static boolean controleTextFieldOnlyLetters(TextField textField, String msg, Label errorLabel) {
        String chaine = textField.getText();
        char[] tab = chaine.toCharArray();

        boolean valide = true;

        for (int i = 0; i < tab.length; i++) {
            if (Character.isDigit(tab[i]) || tab[i] == '.' || tab[i] == ',' || tab[i] == '-' || tab[i] == '_' || tab[i] == '@') {
                valide = false;
            }
        }

        if (!valide) {
            errorLabel.setText(msg);
            return true;
        }
        return false;
    }

    public static boolean controleTextFieldChiffres(TextField textField, String msg, Label errorLabel) {
        String chaine = textField.getText();
        char[] tab = chaine.toCharArray();

        boolean estUnNombre = true;
        for (int i = 0; i < tab.length; i++) {
            if (!Character.isDigit(tab[i])) {
                estUnNombre = false;
            }
        }
        if (!estUnNombre) {
            errorLabel.setText(msg);
            return true;
        }
        return false;
    }

    public static boolean controleCINLongueur(TextField textField, String msg, Label errorLabel) {

        if (textField.getText().length() != 8) {
            errorLabel.setText(msg);
            return true;
        } else if (textField.getText().equals("00000000")) {
            errorLabel.setText("CIN incorrecte                  ");
            return true;
        }
        return false;
    }

    public static boolean controleCPLongueur(TextField textField, String msg, Label errorLabel) {

        if (textField.getText().length() != 4) {
            errorLabel.setText(msg);
            return true;
        } else if (textField.getText().equals("0000")) {
            errorLabel.setText("Code postal incorrecte                 ");
            return true;
        }
        return false;
    }

    public static boolean controleNumTelLongueur(TextField textField, String msg, Label errorLabel) {
        if (textField.getText().length() != 8) {
            errorLabel.setText(msg);
            return true;
        } else if (textField.getText().substring(0, 1) != "31" && textField.getText().charAt(0) != '2' && textField.getText().charAt(0) != '5' && textField.getText().charAt(0) != '9' && textField.getText().charAt(0) != '7') {
            errorLabel.setText("N° Tel. incorrecte                 ");
            return true;
        }
        return false;
    }

    public static boolean controleMailFormat(TextField textField, String msg, Label errorLabel) {
        String chaine = textField.getText();
        if (chaine.length() != 0) {
            if (chaine.charAt(chaine.length() - 1) == '.') {
                errorLabel.setText(msg);
                return true;
            } else {

                int firstIndexA = chaine.indexOf("@");
                int lastIndexA = chaine.lastIndexOf("@");
                int lastIndexPt = chaine.lastIndexOf(".");
                if (firstIndexA < 3 || firstIndexA != lastIndexA || firstIndexA > lastIndexPt || lastIndexPt - firstIndexA < 4 || chaine.substring(lastIndexPt + 1, chaine.length() - 1).length() > 3 || chaine.substring(lastIndexPt + 1, chaine.length()).length() < 2) {
                    errorLabel.setText(msg);
                    return true;
                }
            }
        }
        return false;
    }

   
    

   

   

  

    
}  