package com.example.AngieCardenas.persistence.DTO;

import java.security.Timestamp;

public class OperationDTO {
    
    private Long id;
    private String operationType;
    private int operand1;
    private int operand2;
    private double result;
    private Timestamp timestamp;

    public OperationDTO() {
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

    @Override
    public String toString() {
        return "OperationDTO [id=" + id + 
                "\n operationType=" + operationType + 
                "\n operand1=" + operand1 + 
                "\n operand2=" + operand2 + 
                "\n result=" + result + 
                "\n timestamp=" + timestamp + "]";
    }

    public double addOperation(int one, int two){

        operand1 = one;
        operand2 = two;

        double add = operand1 + operand2;
        result = add;
        return  result;
         
    }  

    public double subtractOperation (int one, int two){
        operand1 = one;
        operand2 = two;

        double subtract = operand1 - operand2;
        result = subtract;
        return  subtract;
    }
    
    public double splitOperation(int one, int two){
        operand1 = one;
        operand2 = two;

        double split = operand1/operand2;
        result = split;
        return  split;
    }

    public double multiplyOperation(int one, int two){
            
        double multiply = operand1 * operand2;
        result = multiply;
        return  result;
    }
}
