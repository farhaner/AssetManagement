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

    private String inboundItem;

    private String outboundItem;

    private Long loanAmount;

    private String employeeId;

    private String assetId;
}
