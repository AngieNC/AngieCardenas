package com.example.AngieCardenas.web;

import java.util.List;

import org.springdoc.core.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AngieCardenas.domain.service.CalculatorService;
import com.example.AngieCardenas.persistence.DTO.OperationDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/calculadora")
public class CalculatorController {
    
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public List<OperationDTO> getAllOperations() {
        return calculatorService.getAllOperations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationDTO> getOperationById(@PathVariable Object id) {
        return calculatorService.getOperationById(id);
    }

    @PostMapping
    public ResponseEntity<OperationDTO> saveOperation(@RequestBody OperationDTO operationDTO) {
        return calculatorService.saveOperation(operationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        return calculatorService.deleteOperation(id);
    }

    @GetMapping("/{operationType}")
    public ResponseEntity<OperationDTO> saveAdd(@PathVariable double result){
        return calculatorService.saveAdd(result);
    }

    @GetMapping("/{operationType}")
    public ResponseEntity<OperationDTO> saveSubtract(@PathVariable double result){
        return calculatorService.saveSubtract(result);
    }
    
}
