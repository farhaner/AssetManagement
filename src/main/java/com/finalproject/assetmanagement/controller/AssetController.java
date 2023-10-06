package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Asset;
import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.service.AssetService;
import com.finalproject.assetmanagement.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/asset")
public class AssetController {

    private final AssetService  assetService;

    //Tanpa Relasi

    @PostMapping
    public Asset createNewAsset(@RequestBody Asset asset){
        return assetService.create(asset);
    }

    @GetMapping(value = "/{id}")
    public Asset getAssetById(@PathVariable String id){
        return assetService.getById(id);
    }

    @GetMapping
    public List<Asset> getAllAsset(){
        return assetService.getAll();
    }

    @PutMapping
    public Asset updateAsset(@RequestBody Asset asset){
        return assetService.update(asset);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAsset(@PathVariable String id){
        assetService.deleteById(id);
    }


}
