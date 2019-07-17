/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.TailattentionmJpaController;
import entity.Tailattentionm;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES
 */
public class TailattenTionM {
    
    private TailattentionmJpaController tailattentionmCtrl = new TailattentionmJpaController();
    private Tailattentionm tailattentionm = new Tailattentionm();

    public String InsertTailAttention(String service,int turn,String servicename, String userid, String username, String priorityname,String punt,String advinser,String advinsername) {

        try {
            tailattentionm.setServicefk(service);
            tailattentionm.setTurn(turn);
            tailattentionm.setServicename(servicename);
            tailattentionm.setFact(Date.from(Instant.now()));
            tailattentionm.setUserid(userid);
            tailattentionm.setUsername(username);

            if (!priorityname.equals("")) {
                tailattentionm.setPriority(true);
            } else {
                tailattentionm.setPriority(false);
            }

            tailattentionm.setPriorityname(priorityname);
            tailattentionm.setPunt(punt);
            tailattentionm.setAdvinser(advinser);
            tailattentionm.setAdvisername(advinsername);
            tailattentionmCtrl.create(tailattentionm);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    
    public void LlenarAttention(JTable table, String name) {

        DefaultTableModel model;
        String[] title = {"Turno", "Servicio", "Nombre Servicio", "Fecha/Hora", "Usuario", "Nombre Usuario", "Prioridad", "Nombre prioridad", "Punto antencion", "Asesor", "Nombre Asesor"};
        model = new DefaultTableModel(null, title);
        List<Tailattentionm> data = BuscarDatos(name);
        String[] data_table = new String[11];
        for (Tailattentionm ent : data) {
            data_table[0] = ent.getTurn() + "";
            data_table[1] = ent.getServicefk();
            data_table[2] = ent.getServicename();
            data_table[3] = ent.getFact() + "";
            data_table[4] = ent.getUserid();
            data_table[5] = ent.getUsername();
            data_table[6] = ent.getPriority() + "";
            data_table[7] = ent.getPriorityname();
            data_table[8] = ent.getPunt();
            data_table[9] = ent.getAdvinser();
            data_table[10] = ent.getAdvisername();

            model.addRow(data_table);
        }
        table.setModel(model);
    }

    private List<Tailattentionm> BuscarDatos(String name) {
        EntityManager em = tailattentionmCtrl.getEntityManager();
        Query query = em.createQuery("SELECT t FROM Tailattentionm t WHERE t.servicefk LIKE :servicefk");
        query.setParameter("servicefk", "%" + name + "%");
        List<Tailattentionm> data = query.getResultList();
        System.out.println(tailattentionm.getServicename());
        return data;
    }
    
}
