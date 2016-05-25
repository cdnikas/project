/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer.apcs.project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author dimitriosnikas
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label label;
    private static int i;
    private static Timer t;
    private static int createInt(){
        if (i != 1){
            return --i;
        }
        if (i == 1){
            t.cancel();
        }
        return --i;
    }
    public void createTimerandCount(){
        t = new Timer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please set the time (in seconds): ");
        String seconds = scanner.nextLine();
        i = Integer.parseInt(seconds);
        System.out.println(seconds);
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                label.setText(createInt() + "");
            }
        }, 900, 900);
        if(t == null){
            t.cancel();
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createTimerandCount();
    }    
    
}
