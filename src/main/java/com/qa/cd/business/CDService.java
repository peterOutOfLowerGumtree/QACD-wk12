package com.qa.cd.business;

public interface CDService {
    String getAllCDs();

    String getCD(Long id);

    String createCD(String cd);

    String updateCD(Long id, String cd);

    String deleteAllCDs();

    String deleteCD(Long id);

}
