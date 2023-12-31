package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Asset;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.entity.Transaction;
import com.finalproject.assetmanagement.model.request.TransactionRequest;
import com.finalproject.assetmanagement.model.response.AssetResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;
import com.finalproject.assetmanagement.model.response.TransactionResponse;
import com.finalproject.assetmanagement.repository.AssetRepository;
import com.finalproject.assetmanagement.repository.EmployeeRepository;
import com.finalproject.assetmanagement.repository.TransactionRepository;
import com.finalproject.assetmanagement.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImplementation implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public TransactionResponse createNewTransaction(TransactionRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        Asset asset = assetRepository.findById(request.getAssetId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        long requestLoanAmount = request.getLoanAmount();
        if (requestLoanAmount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Current quantity must be greater than 0");
        }
        if (asset.getQuantity() < requestLoanAmount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough quantity of the asset available");
        }

        Transaction transaction = Transaction.builder()
                .inboundItem(request.getInboundItem())
                .outboundItem(request.getOutboundItem())
                .loanAmount(request.getLoanAmount())
                .build();

        transaction.setAssets(Collections.singletonList(asset));
        transaction.setEmployees(Collections.singletonList(employee));

        transactionRepository.save(transaction);

        return transactionResponse(transaction, employee, asset);
    }

    @Override
    public TransactionResponse getTransactionById(String id) {
        return null;
    }

    @Override
    public List<TransactionResponse> getAllTransaction() {
        return null;
    }

    @Override
    public TransactionResponse updateTransaction(TransactionRequest request) {
        return null;
    }

    @Override
    public void deleteTransactionById(String id) {

    }

    private static TransactionResponse transactionResponse(Transaction transaction, Employee employee, Asset asset) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .inboundItem(transaction.getInboundItem())
                .outboundItem(transaction.getOutboundItem())
                .loanAmount(transaction.getLoanAmount())
                .status("Waiting Approvement")
                .employees(EmployeeResponse.builder()
                        .username(employee.getUsername())
                        .build())
                .assets(AssetResponse.builder()
                        .name(asset.getName())
                        .build())
                .build();
    }
}
