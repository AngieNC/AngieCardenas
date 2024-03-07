package com.example.AngieCardenas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.AngieCardenas.domain.repository.OperationRepository;
import com.example.AngieCardenas.exceptions.CalculatorIdException;
import com.example.AngieCardenas.exceptions.CalculatorStringException;
import com.example.AngieCardenas.persistence.DTO.OperationDTO;
import com.example.AngieCardenas.persistence.entity.Operation;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    
    private final OperationRepository operationRepository;

    
    @Autowired
    public CalculatorServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<OperationDTO> getAllOperations() {
        List<Operation> operations = operationRepository.findAll();
        return operations.stream().map(Operation::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<OperationDTO> getOperationById(Object id) {
        
        try{
            Long calculatorId = Long.parseLong((String) id);
            Optional<Operation> optionalOperation = operationRepository.findById(calculatorId);
            return optionalOperation.map(Operation -> ResponseEntity.ok(Operation.toDTO()))
                    .orElseThrow(() -> new CalculatorIdException("Ese endpoint no está en la base de datos"));
        } catch (Exception e) {
            throw new CalculatorStringException("Tipo de dato inválido");
        }
    }

    @Override
    public ResponseEntity<OperationDTO> saveOperation(OperationDTO operationDTO) {
        Operation operation = Operation.fromDTO(operationDTO);
        operation = operationRepository.save(operation);
        return ResponseEntity.ok(operation.toDTO());
    }

    @Override
    public ResponseEntity<Void> deleteOperation(Long id) {
        if(operationRepository.existsById(id)){
            operationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<OperationDTO> updateOperation(Object id, OperationDTO operationDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOperation'");
    }

    @Override
    public ResponseEntity<OperationDTO> operationsTest(Object id, int operand1, int operand2, String operationType, OperationDTO operationDTO) {
        
        

        if (operationType == "add"){
            Long calculatorId = Long.parseLong((String) id);
            Optional<Operation> optionalOperation = operationRepository.findById(calculatorId);

            OperationDTO operation = new OperationDTO();
            Operation operation2 = Operation.fromDTO(operationDTO);
            operation2 = operationRepository.save(operation2);
            double resultado = operation.addOperation(operand1, operand2);
            
            return ResponseEntity.ok(operation);
        }
        return null;
        
        
        
    }

    @Override
    public ResponseEntity<OperationDTO> saveAdd(double result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAdd'");
    }

    @Override
    public ResponseEntity<OperationDTO> saveSubtract(double result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveSubtract'");
    }

    @Override
    public ResponseEntity<OperationDTO> saveSplit(double result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveSplit'");
    }

    @Override
    public ResponseEntity<OperationDTO> saveMultiply(double result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveMultiply'");
    }

    // @Override
    // public ResponseEntity<OperationDTO> updateOperation(Object id, OperationDTO operationDTO) {

    //     try {
    //         Long calculatorId2 = Long.parseLong((String) id);
    //         Optional<OperationDTO> operation = operationRepository.findById(calculatorId2);
    //         operation.ifPresent(x -> {
    //             x.setOperand1(operationDTO.getOperand1());
    //             x.setOperand2(operationDTO.getOperand2());
    //             x.setOperationType(operationDTO.getOperationType());
    //             x.setResult(operationDTO.getResult());
    //             x.setTimestamp(operationDTO.getTimestamp());
    //         });
    //         return operationRepository.save(operation.get());
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
        

    // }
    
}
