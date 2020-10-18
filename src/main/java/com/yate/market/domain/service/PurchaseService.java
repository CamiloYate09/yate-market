package com.yate.market.domain.service;

import com.yate.market.domain.Purchase;
import com.yate.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {


    @Autowired
    public PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    @Transactional
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
