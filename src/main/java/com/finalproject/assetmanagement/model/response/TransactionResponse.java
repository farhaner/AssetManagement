package com.finalproject.assetmanagement.model.response;

import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionResponse {
    private String id;

    private LocalDateTime inboundItem;

    private LocalDateTime outboundItem;
    private Long quantity;

    private EmployeeResponse employees;
    private AssetResponse assets;
}
