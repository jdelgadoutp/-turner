/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ServicetailmJpaController;
import entity.Servicetailm;
import java.time.Instant;
import java.util.Date;
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
public class ServiceTailM {

    private ServicetailmJpaController servicetailmCtrl = new ServicetailmJpaController();
    private Servicetailm servicetailm = new Servicetailm();

    public String InsertServiceTail(String service, String servicename, String userid, String username, Boolean priority, String priorityname) {

        try {
            servicetailm.setServicefk(service);
            servicetailm.setServicename(servicename);
            servicetailm.setFact(Date.from(Instant.now()));
            servicetailm.setUserid(userid);
            servicetailm.setUsername(username);

            if (!priorityname.equals("")) {
                servicetailm.setPriority(true);
            } else {
                servicetailm.setPriority(false);
            }

            servicetailm.setPriorityname(priorityname);
            servicetailmCtrl.create(servicetailm);
            System.out.println("turno en cola de servicio");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public Servicetailm Atender(String punt) {

        Servicetailm servicetailm = new Servicetailm();
        PuntsServices puntsservice = new PuntsServices();
        String mysql = "SELECT s FROM Servicetailm s where (" + puntsservice.QueryService(punt) + ") order by s.priority,s.turn";
        System.out.println(mysql);
        EntityManager em = servicetailmCtrl.getEntityManager();
        try {
            Query query = em.createQuery(mysql);
            servicetailm = (Servicetailm) query.getResultList().get(0);
        } catch (Exception e) {
            System.out.println(e);

        }
        return servicetailm;

    }

    public int LiberarTurno(int turn) {

        int result = 0;
        EntityManager em = servicetailmCtrl.getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete FROM Servicetailm s WHERE s.turn = :turn");
            query.setParameter("turn", turn).executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public void LlenarTailm(JTable table, String name) {

        DefaultTableModel model;
        String[] title = {"Turno", "Servicio", "Nombre Servicio", "Fecha/Hora", "Usuario", "Nombre Usuario", "Prioridad", "Nombre prioridad"};
        model = new DefaultTableModel(null, title);
        List<Servicetailm> data = BuscarDatos(name);
        String[] data_table = new String[8];
        for (Servicetailm ent : data) {
            data_table[0] = ent.getTurn() + "";
            data_table[1] = ent.getServicefk();
            data_table[2] = ent.getServicename();
            data_table[3] = ent.getFact() + "";
            data_table[4] = ent.getUserid();
            data_table[5] = ent.getUsername();
            data_table[6] = ent.getPriority() + "";
            data_table[7] = ent.getPriorityname();

            model.addRow(data_table);
        }
        table.setModel(model);
    }

    private List<Servicetailm> BuscarDatos(String name) {
        EntityManager em = servicetailmCtrl.getEntityManager();
        Query query = em.createQuery("SELECT s FROM Servicetailm s WHERE s.servicefk LIKE :servicefk");
        query.setParameter("servicefk", "%" + name + "%");
        List<Servicetailm> data = query.getResultList();
        System.out.println(servicetailm.getServicename());
        return data;
    }

}
