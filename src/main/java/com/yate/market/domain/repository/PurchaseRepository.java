package com.yate.market.domain.repository;

import com.yate.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientID);

    Purchase save(Purchase purchase);

}
