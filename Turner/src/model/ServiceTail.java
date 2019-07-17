/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ServicetailJpaController;
import entity.Servicetail;
import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ANDRES
 */
public class ServiceTail {

    private ServicetailJpaController servicetailCtrl = new ServicetailJpaController();
    private Servicetail servicetail = new Servicetail();

    public Servicetail ConsultaServicetail(String service) {

        Servicetail servicetail = new Servicetail();
        EntityManager em = servicetailCtrl.getEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM Servicetail s WHERE s.service = :service");
            query.setParameter("service", service);
            servicetail = (Servicetail) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return servicetail;

    }
}
