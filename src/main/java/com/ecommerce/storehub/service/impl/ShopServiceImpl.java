package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.dto.ShopDTO;
import com.ecommerce.storehub.entity.Shop;
import com.ecommerce.storehub.mapper.ShopMapper;
import com.ecommerce.storehub.repository.ShopRepository;
import com.ecommerce.storehub.repository.specification.ShopSpecification;
import com.ecommerce.storehub.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;
    private final ShopRepository shopRepository;
    @Override
    public ShopDTO createShop(ShopDTO shopDTO) {
        Shop shop = shopMapper.toEntity(shopDTO);
        Shop savedShop = shopRepository.save(shop);
        return shopMapper.toDto(savedShop);
    }

    @Override
    public ShopDTO updateShop(Long shopId, ShopDTO shopDTO) {
        return null;
    }

    @Override
    public void deleteShop(Long shopId) {
        return;
    }

    @Override
    public ShopDTO getShopDetails(String shopId) {
        Specification<Shop> spec = Specification.where(ShopSpecification.hasShopId(shopId))
                .and(ShopSpecification.isNotDeleted())
                .and(ShopSpecification.fetchProductCategories());

        Shop shop = shopRepository.findOne(spec).orElseThrow(() -> new RuntimeException("Shop not found"));
        return shopMapper.toDto(shop);
    }

    @Override
    public List<ShopDTO> getAllShops() {
        return null;
    }

    @Override
    public List<ShopDTO> getShopsByOwner(Long ownerId) {
        return null;
    }

    @Override
    public List<ShopDTO> getShopsByStatus(String status) {
        return null;
    }
}
