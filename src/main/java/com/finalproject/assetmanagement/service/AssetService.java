package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Asset;
import com.finalproject.assetmanagement.model.request.AssetRequest;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.AssetResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;

import java.util.List;

public interface AssetService {
    Asset create(Asset asset);
    Asset getById(String id);
    List<Asset> getAll();
    Asset update(Asset asset);
    void deleteById(String id);

    AssetResponse createNewAsset(AssetRequest request);
    AssetResponse getAssetById(AssetRequest request);
    AssetResponse getAllAsset(AssetRequest request);
    AssetResponse updateAsset(AssetRequest request);
    AssetResponse deleteAsset(AssetRequest request);


}
