package com.ecommerce.storehub.service;

import com.ecommerce.storehub.dto.ShopDTO;

import java.util.List;

public interface ShopService {
    ShopDTO createShop(ShopDTO shopDTO);
    ShopDTO updateShop(Long shopId, ShopDTO shopDTO);
    void deleteShop(Long shopId);
    ShopDTO getShopDetails(String shopId);

    List<ShopDTO> getAllShops();
    List<ShopDTO> getShopsByOwner(Long ownerId);
    List<ShopDTO> getShopsByStatus(String status);
}

