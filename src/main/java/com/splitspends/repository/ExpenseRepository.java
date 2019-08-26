package com.splitspends.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.splitspends.model.Expense;

@RepositoryRestResource
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}