package com.qa.cd.business;

public interface CdService {
    String getAllCds();

    String createCd(String cd);

    String updateCd(Long id, String cd);

    String deleteCd(Long id);
    
}
