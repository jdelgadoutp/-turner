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

/**
 *
 * @author ANDRES
 */
public class ServiceTailM {

    private ServicetailmJpaController servicetailmCtrl = new ServicetailmJpaController();
    private Servicetailm servicetailm = new Servicetailm();

    public String InsertServiceTail(String service, int turn, String servicename, String userid, String username, Boolean priority, String priorityname) {

        try {
            servicetailm.setServicefk(service);
            servicetailm.setTurn(turn);
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

}
