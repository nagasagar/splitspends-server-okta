package com.splitspends.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Expense {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String detail;
}