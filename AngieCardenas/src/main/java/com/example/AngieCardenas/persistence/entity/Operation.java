package com.example.AngieCardenas.persistence.entity;

import java.security.Timestamp;

import com.example.AngieCardenas.persistence.DTO.OperationDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operationType;
    private int operand1;
    private int operand2;
    private double result;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    public Operation() {
    }

    public Operation(Long id, String operationType, int operand1, int operand2, double result, Timestamp timestamp) {
        this.id = id;
        this.operationType = operationType;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public OperationDTO toDTO(){
        
        OperationDTO dto = new OperationDTO();
        dto.setId(this.id);
        dto.setOperand1(this.operand1);
        dto.setOperand2(this.operand2);
        dto.setOperationType(this.operationType);
        dto.setResult(this.result);
        dto.setTimestamp(this.timestamp);
        return dto;
    }
    
    public static Operation fromDTO(OperationDTO dto2){
        
        Operation operation = new Operation();
        operation.setId(dto2.getId());
        operation.setOperand1(dto2.getOperand1());
        operation.setOperand2(dto2.getOperand2());
        operation.setOperationType(dto2.getOperationType());
        operation.setResult(dto2.getResult());
        operation.setTimestamp(dto2.getTimestamp());
        return operation;
    }
    
}
