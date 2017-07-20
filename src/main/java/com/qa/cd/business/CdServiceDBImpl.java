package com.qa.cd.business;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

import com.qa.cd.util.JSONUtil;
import com.qa.cd.persistence.Cd;

@Stateless
@Default
public class CdServiceDBImpl implements CdService {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllCds() {
        Query query = manager.createQuery("Select m FROM Cd m");
        Collection<Cd> cds = (Collection<Cd>) query.getResultList();
        return util.getJSONForObject(cds);
    }

    @Override
    public String createCd(String cd) {
        Cd aCd = util.getObjectForJSON(cd, Cd.class);
        manager.persist(aCd);
        return "{\"message\": \"cd successfully added\"}";
    }

    @Override
    public String updateCd(Long id, String cd) {
        Cd updatedCd = util.getObjectForJSON(cd, Cd.class);
        Cd cdInDb = findCd(id);
        if (cdInDb != null) {
            cdInDb = updatedCd;
            manager.merge(cdInDb);
        }
        return "{\"message\": \"cd successfully updated\"}";
    }

    @Override
    public String deleteCd(Long id) {
        Cd cdInDb = findCd(id);
        if (cdInDb != null) {
            manager.remove(cdInDb);
        }
        return "{\"message\": \"cd successfully deleted\"}";
    }

    private Cd findCd(Long id) {
        return manager.find(Cd.class, id);
    }

}
