package com.finalproject.assetmanagement.model.request;

import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmployeeRequest {

    private String username;

    private String password;

    private String email;

    private String mobilePhone;

    private String assetId;

    private String branchId;
}
