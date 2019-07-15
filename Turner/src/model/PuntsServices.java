/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.PuntoservicesJpaController;
import entity.Puntoservices;
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
public class PuntsServices {

    private PuntoservicesJpaController puntoservicesCtrl = new PuntoservicesJpaController();
    private Puntoservices puntoservices = new Puntoservices();
   
    public String InsertPuntoservices(String punto, String service, String servicename) {

        try {
            puntoservices.setPunto(punto);
            puntoservices.setService(service);
            puntoservices.setServicename(servicename);
            puntoservicesCtrl.create(puntoservices);
            System.out.println("Datos ingresados con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public void LlenarPuntoservices(JTable table, String service) {

        DefaultTableModel model;
        String[] title = {"Servicio", "Nombre servicio"};
        model = new DefaultTableModel(null, title);
        List<Puntoservices> data = BuscarDatos(service);
        String[] data_table = new String[2];
        for (Puntoservices ent : data) {
            data_table[0] = ent.getService() + "";
            data_table[1] = ent.getServicename();
            model.addRow(data_table);
        }
        table.setModel(model);
    }

    public String DeletePunto(int id) {
        try {
            puntoservicesCtrl.destroy(id);
            JOptionPane.showMessageDialog(null, "Servicio eliminado " + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se  eliminado " + id);
            System.out.println(e);
        }
        return null;
    }

    private List<Puntoservices> BuscarDatos(String punto) {
        EntityManager em = puntoservicesCtrl.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Puntoservices p WHERE p.punto = :punto");
        query.setParameter("punto", punto);
        List<Puntoservices> data = query.getResultList();
        return data;
    }

}
