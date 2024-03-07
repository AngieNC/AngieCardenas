package com.example.AngieCardenas.domain.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.AngieCardenas.persistence.DTO.OperationDTO;

public interface CalculatorService {

    List<OperationDTO> getAllOperations();
    ResponseEntity<OperationDTO> getOperationById(Object id);
    ResponseEntity<OperationDTO> saveOperation(OperationDTO operationDTO);
    ResponseEntity<Void> deleteOperation(Long id);
    ResponseEntity<OperationDTO> updateOperation(Object id, OperationDTO operationDTO);
    ResponseEntity<OperationDTO> operationsTest(Object id, int operand1, int operand2, String operationType, OperationDTO operationDTO);
    ResponseEntity<OperationDTO> saveAdd(double result);
    ResponseEntity<OperationDTO> saveSubtract(double result);
    ResponseEntity<OperationDTO> saveSplit(double result);
    ResponseEntity<OperationDTO> saveMultiply(double result);
}
