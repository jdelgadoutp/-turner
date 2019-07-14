/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turner;

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
        // TODO code application logic here
        PrincipalView principal = new PrincipalView();
                
        principal.setTitle("Turner");
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    
}
