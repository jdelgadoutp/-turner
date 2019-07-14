/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.PriorityJpaController;
import entity.Priority;
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
public class Prioritys {
    
    private PriorityJpaController priorityCtrl = new PriorityJpaController();
    private Priority priority = new Priority();

    public String InsertPriority(String id,String name) {

        try {
            priority.setId(id);
            priority.setName(name);
            priorityCtrl.create(priority);
            System.out.println("Datos ingresados con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public Priority ConsultaPriority(String id) {

        Priority priority = new Priority();
        EntityManager em = priorityCtrl.getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Priority p WHERE p.id = :id");
            query.setParameter("id", id);
            priority = (Priority) query.getSingleResult();
            if (priorityCtrl.findPriority(id) == null) {
                JOptionPane.showMessageDialog(null, "No exite prioridad " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Prioridad encontrado ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return priority;

    }

    public void LlenarPriority(JTable table, String name) {

        DefaultTableModel model;
        String[] title = {"Id", "Name"};
        model = new DefaultTableModel(null, title);
        List<Priority> data = BuscarDatos(name);
        String[] data_table = new String[2];
        for (Priority ent : data) {
            data_table[0] = ent.getId() + "";
            data_table[1] = ent.getName();
            model.addRow(data_table);
        }
        table.setModel(model);
    }

    public String DeletePriority(String id) {
        try {
            priorityCtrl.destroy(id);
            JOptionPane.showMessageDialog(null, "Prioridad eliminada " + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se  eliminado " + id);
            System.out.println(e);
        }
        return null;
    }
    
    public String UpdatePriority(String id,String name){
        try {
            priority.setId(id);
            priority.setName(name);
            priorityCtrl.edit(priority);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no actualizados");
            System.out.println(e);
        }
        return null;
    }
    
    private List<Priority> BuscarDatos(String name) {
        EntityManager em = priorityCtrl.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Priority p WHERE p.name LIKE :name");
        query.setParameter("name", "%" + name + "%");
        List<Priority> data = query.getResultList();
        return data;
    }

    
}
