package com.qa.cd.business;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

import com.qa.cd.util.JSONUtil;
import com.qa.cd.persistence.CD;

@Stateless
@Default
public class CDServiceDBImpl implements CDService {

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllCDs() {
        Query query = manager.createQuery("Select m FROM CD m");
        Collection<CD> cds = (Collection<CD>) query.getResultList();
        return util.getJSONForObject(cds);
    }

    @Override
    public String getCD(Long id) {
        if (id instanceof Long) {
            CD cdInDb = findCD(id);
            if (cdInDb != null) {
                return util.getJSONForObject(cdInDb);
            }
        } else {
            return "{\"message\": \"Not valid Input. Enter a number.\"}";
        }
        return "";
    }

    @Override
    public String createCD(String cd) {
        CD aCD = util.getObjectForJSON(cd, CD.class);
        manager.persist(aCD);
        return "{\"message\": \"cd probably added\"}";
    }

    @Override
    public String updateCD(Long id, String cd) {
        CD updatedCD = util.getObjectForJSON(cd, CD.class);
        CD cdInDb = findCD(id);
        if (cdInDb != null) {
            updatedCD.setId(id);
            manager.merge(updatedCD);
        }
        return "{\"message\": \"cd probably updated\"}";
    }

    @Override
    public String deleteCD(Long id) {
        CD cdInDb = findCD(id);
        if (cdInDb != null) {
            manager.remove(cdInDb);
        }
        return "{\"message\": \"cd probably deleted\"}";
    }

    public String deleteAllCDs() {
        Query query = manager.createQuery("DELETE FROM CD");
        query.executeUpdate();
        return "{\"message\": \"all cd probably deleted\"}";
    }

    private CD findCD(Long id) {
        return manager.find(CD.class, id);
    }

}
