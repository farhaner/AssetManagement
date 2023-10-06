package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Asset;
import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.model.request.AssetRequest;
import com.finalproject.assetmanagement.model.response.AssetResponse;
import com.finalproject.assetmanagement.model.response.BranchResponse;
import com.finalproject.assetmanagement.repository.AssetRepository;
import com.finalproject.assetmanagement.service.AssetService;
import com.finalproject.assetmanagement.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImplementation implements AssetService {

    private final AssetRepository assetRepository;
    private final BranchService branchService;

    //CRUD tanpa relasi
    @Override
    public Asset create(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Asset getById(String id) {
        return assetRepository.findById(id).get();
    }

    @Override
    public List<Asset> getAll() {
        return assetRepository.findAll();
    }

    @Override
    public Asset update(Asset asset) {
        Asset currentAsset = getById(asset.getId());
        if (asset!= null){
            return assetRepository.save(asset);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        assetRepository.deleteById(id);
    }




//    private static ProductResponse toProductResponse(Store store, Product product, ProductPrice productPrice) {
//        return ProductResponse.builder()
//                .productId(product.getId())
//                .productName(product.getName())
//                .description(product.getDescription())
//                .price(productPrice.getPrice())
//                .stock(productPrice.getStock())
//                .store(StoreResponse.builder()
//                        .id(store.getId())
//                        .name(store.getName())
//                        .address(store.getAddress())
//                        .build())
//                .build();
//    }


    //CRUD dengan relasi

    @Transactional
    @Override
    public AssetResponse createNewAsset(AssetRequest request) {

            Branch branch = branchService.getBranchById(request.getBranchId());

            Asset asset = Asset.builder()
                    .assetCode(request.getAssetCode())
                    .name(request.getName())
                    .description(request.getDescription())
                    .build();
            assetRepository.saveAndFlush(asset);

//            return toProductResponse(store, product, productPrice);
        return  AssetResponse.builder()
                .id(asset.getId())
                .assetCode(asset.getAssetCode())
                .name(asset.getName())
                .description(asset.getDescription())
                .branch(BranchResponse.builder()
                        .id(branch.getId())
                        .branchName(branch.getBranchName())
                        .mobilePhone(branch.getMobilePhone())
                        .address(branch.getAddress())
                        .build())
                .build();
    }

    @Override
    public AssetResponse getAssetById(AssetRequest request) {
        return null;
    }

    @Override
    public AssetResponse getAllAsset(AssetRequest request) {
        return null;
    }

    @Override
    public AssetResponse updateAsset(AssetRequest request) {
        return null;
    }

    @Override
    public AssetResponse deleteAsset(AssetRequest request) {
        return null;
    }
}
