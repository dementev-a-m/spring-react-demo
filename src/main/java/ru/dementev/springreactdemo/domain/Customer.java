package ru.dementev.springreactdemo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Map;


@Data
@Table(name = "customer")
public class Customer {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Map<String,Object> data;
    @CreatedDate
    private Timestamp createdTime;
}
