/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Service;
import view.PrincipalView;
import view.ServiceView;

/**
 *
 * @author ANDRES
 */
public class PrincipalCtrl implements ActionListener {

    private PrincipalView principalView;

    public PrincipalCtrl(PrincipalView principalView) {
        this.principalView = principalView;
        this.principalView.btnServicio.addActionListener(this);
    }

    public void Iniciar() {
        this.principalView.setTitle("Administrador de gestión turnos");
        this.principalView.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == principalView.btnServicio) {
            Service newService = new Service();
            ServiceView newServiceV = new ServiceView();

            ServiceCtrl ctrlService = new ServiceCtrl(newService, newServiceV);

            ctrlService.Iniciar();
            newServiceV.setVisible(true);
        }

    }

}
