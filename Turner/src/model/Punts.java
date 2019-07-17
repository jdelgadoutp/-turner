/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.PuntoJpaController;
import entity.Punto;
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
public class Punts {

    private PuntoJpaController puntoCtrl = new PuntoJpaController();
    private Punto punto = new Punto();

    public String InsertPunto(String id, String adviser,Boolean  activo, String advisername) {

        try {
            punto.setId(id);
            punto.setAdviser(adviser);
            punto.setActivo(activo);
            punto.setAdvisername(advisername);
            puntoCtrl.create(punto);
            System.out.println("Datos ingresados con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
    
     public Punto ConsultaPunto(String id) {

        Punto punto = new Punto();
        EntityManager em = puntoCtrl.getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Punto p WHERE p.id = :id");
            query.setParameter("id", id);
            punto = (Punto) query.getSingleResult();
            if (puntoCtrl.findPunto(id) == null) {
                //JOptionPane.showMessageDialog(null, "No exite puesto de atención " + id);
            } else {
                //JOptionPane.showMessageDialog(null, "Punto encontrado ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return punto;

    }

     public void LlenarPunto(JTable table, String adviser) {

        DefaultTableModel model;
        String[] title = {"Id", "Asesor","Activo","Nombre asesor"};
        model = new DefaultTableModel(null, title);
        List<Punto> data = BuscarDatos(adviser);
        String[] data_table = new String[4];
        for (Punto ent : data) {
            data_table[0] = ent.getId() + "";
            data_table[1] = ent.getAdviser();
            data_table[2] = ent.getActivo() + "";
            data_table[3] = ent.getAdvisername();
            model.addRow(data_table);
        }
        table.setModel(model);
    }

    public String DeletePunto(String id) {
        try {
            puntoCtrl.destroy(id);
            JOptionPane.showMessageDialog(null, "Servicio eliminado " + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se  eliminado " + id);
            System.out.println(e);
        }
        return null;
    }

    public String UpdatePunto(String id, String adviser, boolean activo, String advisername) {
        try {
            punto.setId(id);
            punto.setAdviser(adviser);
            punto.setActivo(activo);
            punto.setAdvisername(advisername);
            puntoCtrl.edit(punto);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no actualizados");
            System.out.println(e);
        }
        return null;
    }

    private List<Punto> BuscarDatos(String adviser) {
        EntityManager em = puntoCtrl.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Punto p WHERE p.adviser LIKE :adviser");
        query.setParameter("adviser", "%" + adviser + "%");
        List<Punto> data = query.getResultList();
        return data;
    }
}
