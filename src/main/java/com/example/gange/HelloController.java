package com.example.gange;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.Objects;


public class HelloController {
    int factor1, factor2, antallSvar, antallRette, antallFeil;
    double rettProsent, feilProsent;
    String[] riktigsvar = {"Bra!", "Konge!", "Super!", "Mad skills eller flaks?", "Heftig shiiiit!"};
    String[] galtsvar = {"Woops, stemmer ikke!", "Hvorfor loker du?", "Skjerpings!", "Nah, prøv igjen!", "Nope, rusten eller?"};


    @FXML
    private Label lblAntallRett;
    @FXML
    private Label lblAntallFeil;
    @FXML
    private Label lblRettProsent;
    @FXML
    private Label lblFeilProsent;
    @FXML
    private Label lblOppgave;
    @FXML
    private Label lblResultat;
    @FXML
    private TextField txtSvar;
    @FXML
    public void onEnter(ActionEvent actionEvent) {
        svar(actionEvent);
    }

    @FXML
    void nullstill(ActionEvent event) {
        lblAntallRett.setText("");
        lblAntallFeil.setText("");
        lblRettProsent.setText("");
        lblFeilProsent.setText("");
        lblOppgave.setText("");
        lblResultat.setText("");
        txtSvar.setText("");
        antallSvar = 0;
        antallRette = 0;
        antallFeil = 0;
        rettProsent = 0;
        feilProsent = 0;

    }
    @FXML
    void nyOppgave(ActionEvent event) {
        factor1 = (int) (Math.random() *11);
        factor2 = (int) (Math.random() *11);
        lblOppgave.setText("Hva blir "+factor1+" x "+factor2+"?");
    }
    @FXML
    void svar(ActionEvent event) {
        int svar;
        try {
            svar = Integer.parseInt(txtSvar.getText());
            antallSvar ++;
            int tilfeldigSvarTall = (int)(Math.random()*6);
            txtSvar.setText("");
            int riktigSvar = factor1 * factor2;
            if (svar == riktigSvar) {
                lblResultat.setText(riktigsvar[tilfeldigSvarTall]);
                antallRette ++;
                lblAntallRett.setText(String.valueOf(antallRette));
                rettProsent = (antallRette * 100) / (double)antallSvar;
                lblRettProsent.setText(String.format("%.2f", rettProsent)+" %");
                feilProsent = (antallFeil * 100) / (double)antallSvar;
                lblFeilProsent.setText(String.format("%.2f", feilProsent)+" %");
                nyOppgave(event);
            }
            else {
                lblResultat.setText(galtsvar[tilfeldigSvarTall]);
                antallFeil ++;
                lblAntallFeil.setText(String.valueOf(antallFeil));
                feilProsent = (antallFeil * 100) / (double)antallSvar;
                lblFeilProsent.setText(String.format("%.2f", feilProsent)+" %");
                rettProsent = (antallRette * 100) / (double)antallSvar;
                lblRettProsent.setText(String.format("%.2f", rettProsent)+" %");
            }
        }
        catch (Exception e) {
            lblResultat.setText("Du skal kun skrive inn heltall som svar");
        }
    }
}