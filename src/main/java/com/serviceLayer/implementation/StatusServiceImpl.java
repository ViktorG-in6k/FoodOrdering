package com.serviceLayer.implementation;

import com.dataLayer.DAO.StatusDAO;
import com.model.Entity.Status;
import com.serviceLayer.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusDAO statusDAO;

    @Override
    public Status getStatusById(int id){
        return statusDAO.getStatusById(id);
    }
}

