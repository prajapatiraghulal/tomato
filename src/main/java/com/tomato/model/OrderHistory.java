package com.tomato.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document
public class OrderHistory {
    @Id
    private String userId;
    private List<String> orderIdList;
}
