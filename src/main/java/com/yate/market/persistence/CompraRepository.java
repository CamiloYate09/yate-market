package com.yate.market.persistence;

import com.yate.market.domain.Purchase;
import com.yate.market.domain.repository.PurchaseRepository;
import com.yate.market.persistence.crud.CompraCrudRepository;
import com.yate.market.persistence.entity.Compra;
import com.yate.market.persistence.mapper.PurchaseItemMapper;
import com.yate.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CompraRepository implements PurchaseRepository {
    /**
     * Inyectar
     *
     * @return
     */
    @Autowired
    private CompraCrudRepository compraCrudRepository;


    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientID) {
        return compraCrudRepository.findByIdCliente(clientID).map(compras ->
                purchaseMapper.toPurchases(compras));
    }

    /**
     * Guardado en Cascada
     * @param purchase
     * @return
     */
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getComprasProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
