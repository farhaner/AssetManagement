package com.finalproject.assetmanagement.model.request;

import com.finalproject.assetmanagement.entity.Branch;
import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AssetRequest {

    private String assetCode;

    private String name;

    private String description;

    private String branchId;

}
