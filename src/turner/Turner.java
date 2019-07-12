/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turner;

import controller.PrincipalCtrl;
import controller.ServiceCtrl;
import java.awt.event.ActionEvent;
import model.Principal;
import model.Service;
import view.PrincipalView;
import view.ServiceView;

/**
 *
 * @author ANDRES
 */
public class Turner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PrincipalView newInicio = new PrincipalView();
        PrincipalCtrl newCtrl = new PrincipalCtrl(newInicio);
        
        newCtrl.Iniciar();
        newInicio.setVisible(true);
    }

}
