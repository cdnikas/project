/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer.apcs.project;

/**
 *
 * @author dimitriosnikas
 */
import java.util.*;
public class Chronometer {
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
    public static void createTimerandCount(){
        t = new Timer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please set the time (in seconds): ");
        String seconds = scanner.nextLine();
        i = Integer.parseInt(seconds);
        System.out.println(seconds);
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(createInt());
            }
        }, 900, 900);
        if(t == null){
            t.cancel();
        }
    }   
    public static void main(String[]args) {
        createTimerandCount();
    }
}
