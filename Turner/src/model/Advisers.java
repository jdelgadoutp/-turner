/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AdviserJpaController;
import entity.Adviser;
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
public class Advisers {
    
    private AdviserJpaController adviserCtrl = new AdviserJpaController();
    private Adviser adviser = new Adviser();

    public String InsertAdviser(String id,String name) {

        try {
            adviser.setId(id);
            adviser.setName(name);
            adviserCtrl.create(adviser);
            System.out.println("Datos ingresados con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public Adviser ConsultaAdviser(String id) {

        Adviser adviser = new Adviser();
        EntityManager em = adviserCtrl.getEntityManager();
        try {
            Query query = em.createQuery("SELECT a FROM Adviser a WHERE a.id = :id");
            query.setParameter("id", id);
            adviser = (Adviser) query.getSingleResult();
            if (adviserCtrl.findAdviser(id) == null) {
                JOptionPane.showMessageDialog(null, "No exite asesor " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Prioridad encontrado ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return adviser;

    }

    public void LlenarAdviser(JTable table, String name) {

        DefaultTableModel model;
        String[] title = {"Id", "Name"};
        model = new DefaultTableModel(null, title);
        List<Adviser> data = BuscarDatos(name);
        String[] data_table = new String[2];
        for (Adviser ent : data) {
            data_table[0] = ent.getId() + "";
            data_table[1] = ent.getName();
            model.addRow(data_table);
        }
        table.setModel(model);
    }

    public String DeleteAdviser(String id) {
        try {
            adviserCtrl.destroy(id);
            JOptionPane.showMessageDialog(null, "Asesor eliminado " + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se  eliminado " + id);
            System.out.println(e);
        }
        return null;
    }
    
    public String UpdateAdviser(String id,String name){
        try {
            adviser.setId(id);
            adviser.setName(name);
            adviserCtrl.edit(adviser);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no actualizados");
            System.out.println(e);
        }
        return null;
    }
    
    private List<Adviser> BuscarDatos(String name) {
        EntityManager em = adviserCtrl.getEntityManager();
        Query query = em.createQuery("SELECT a FROM Adviser a WHERE a.name LIKE :name");
        query.setParameter("name", "%" + name + "%");
        List<Adviser> data = query.getResultList();
        return data;
    }

    
}
