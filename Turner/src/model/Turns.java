/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.TurnJpaController;
import entity.Turn;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.nio.file.Files.write;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class Turns {

    private TurnJpaController turnCtrl = new TurnJpaController();
    private Turn turn = new Turn();

    public String InsertTurn(String user, String username, String servicename, Boolean priority, String priorityname) {

        try {
            turn.setFact(Date.from(Instant.now()));
            turn.setUsers(user);
            turn.setUsername(username);
            turn.setServicename(servicename);
            
            if (!priorityname.equals("")){
                turn.setPriority(true);
            }else{
                turn.setPriority(false);
            }
            
            turn.setPriorityname(priorityname);
            turnCtrl.create(turn);
            CreateFile(user, username, servicename, turn.getPriority(), priorityname);
            JOptionPane.showMessageDialog(null, "Turno generado estar atento a su llamado ");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public void CreateFile(String user, String username, String servicename, Boolean priority, String priorityname) {
        File file = new File("ListaLLegada.txt");

        try {
            FileWriter cursor = new FileWriter(file,true);
            PrintWriter write = new PrintWriter(cursor);
            
            if (!file.exists()) {

                file.createNewFile();
                write.println(Date.from(Instant.now()) + ";" + user + ";" + username + ";" + servicename + ";" + priority + ";" + priorityname + ";");
                cursor.close();
                write.close();
            } else {
                write.println(Date.from(Instant.now()) + ";" + user + ";" + username + ";" + servicename + ";" + priority + ";" + priorityname + ";");
                cursor.close();
                write.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
