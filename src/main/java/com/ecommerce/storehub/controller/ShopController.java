package com.ecommerce.storehub.controller;

import com.ecommerce.storehub.dto.ShopDTO;
import com.ecommerce.storehub.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    public ShopDTO createShop(@RequestBody ShopDTO shopDTO) {
        return shopService.createShop(shopDTO);
    }

    @GetMapping("/{id}")
    public ShopDTO getShopDetails(@PathVariable String id) {
        return shopService.getShopDetails(id);
    }

    @GetMapping
    public List<ShopDTO> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/owner/{ownerId}")
    public List<ShopDTO> getShopsByOwner(@PathVariable Long ownerId) {
        return shopService.getShopsByOwner(ownerId);
    }

    @PutMapping("/{id}")
    public ShopDTO updateShop(@PathVariable Long id, @RequestBody ShopDTO shopDTO) {
        return shopService.updateShop(id, shopDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }
}
