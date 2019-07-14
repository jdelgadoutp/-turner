/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ServicesJpaController;
import entity.Services;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES
 */
public class Service {

    private ServicesJpaController serviceCtrl = new ServicesJpaController();
    private Services service = new Services();

    public String InsertService(String id, String name) {

        try {
            service.setId(id);
            service.setName(name);
            serviceCtrl.create(service);
            System.out.println("Datos ingresados con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public Services ConsultaService(String id) {

        Services service = new Services();
        EntityManager em = serviceCtrl.getEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM Services s WHERE s.id = :id");
            query.setParameter("id", id);
            service = (Services) query.getSingleResult();
            if (serviceCtrl.findServices(id) == null) {
                JOptionPane.showMessageDialog(null, "No exite servicio " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Servicio encontrado ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return service;

    }

    public void LlenarServicio(JTable table, String name) {

        DefaultTableModel model;
        String[] title = {"Id", "Name"};
        model = new DefaultTableModel(null, title);
        List<Services> data = BuscarDatos(name);
        String[] data_table = new String[2];
        for (Services ent : data) {
            data_table[0] = ent.getId() + "";
            data_table[1] = ent.getName();
            model.addRow(data_table);
        }
        table.setModel(model);
    }

    public String DeleteService(String id) {
        try {
            serviceCtrl.destroy(id);
            JOptionPane.showMessageDialog(null, "Servicio eliminado " + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se  eliminado " + id);
            System.out.println(e);
        }
        return null;
    }

    public String UpdateService(String id, String name) {
        try {
            service.setId(id);
            service.setName(name);
            serviceCtrl.edit(service);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no actualizados");
            System.out.println(e);
        }
        return null;
    }

    private List<Services> BuscarDatos(String name) {
        EntityManager em = serviceCtrl.getEntityManager();
        Query query = em.createQuery("SELECT s FROM Services s WHERE s.name LIKE :name");
        query.setParameter("name", "%" + name + "%");
        List<Services> data = query.getResultList();
        return data;
    }

}
