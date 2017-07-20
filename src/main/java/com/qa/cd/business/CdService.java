package com.qa.cd.business;

public interface CdService {
    String getAllCds();

    String getCd(Long id);

    String createCd(String cd);

    String updateCd(Long id, String cd);

    String deleteAllCds();

    String deleteCd(Long id);
    
}
