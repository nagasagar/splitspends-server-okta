package com.splitspends.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splitspends.model.Expense;
import com.splitspends.repository.ExpenseRepository;

@RestController
public class ExpenseController {
    private ExpenseRepository repository;

    public ExpenseController(ExpenseRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/expenses")
    public Collection<Expense> getExpenses() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
    
    @GetMapping("/hello")
    public String sayHello(Principal principal) {
        return "Hello, " + principal.getName();
    }

}
