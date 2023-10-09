package com.finalproject.assetmanagement.model.request;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionRequest {
    private String id;

    private LocalDateTime inboundItem;

    private LocalDateTime outboundItem;
    private Long currentQuantity;
    private String employeeId;

    private String assetId;
}
