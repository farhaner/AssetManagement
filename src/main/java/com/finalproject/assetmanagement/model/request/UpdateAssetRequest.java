package com.finalproject.assetmanagement.model.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdateAssetRequest {
    private String id;

    private String assetCode;

    private String name;

    private Long quantity;

    private String description;
}
