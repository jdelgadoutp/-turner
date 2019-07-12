/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.TableModel;
import model.Service;
import view.PrincipalView;
import view.ServiceView;

/**
 *
 * @author ANDRES
 */
public class ServiceCtrl implements ActionListener {

    private Service service;
    private ServiceView serviceView;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Turner");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Service guardarServicio(Service newService) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        newService = em.merge(newService);

        em.getTransaction().commit();
        em.close();
        return newService;
    }

    public List<Service> listarService() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT u FROM Services u");
        List<Service> resp = (List<Service>) query.getResultList();

        em.close();
        return resp;
    }

    public ServiceCtrl(Service service, ServiceView serviceView) {
        this.service = service;
        this.serviceView = serviceView;
        this.serviceView.btnGuardar.addActionListener(this);
    }

    public void Iniciar() {
        this.serviceView.setTitle("Lista de servicios");
        this.serviceView.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == serviceView.btnGuardar) {
            service.setName(serviceView.txTServicioName.getText());
            guardarServicio(this.service);
            System.err.println(listarService());
        }
    }
}
