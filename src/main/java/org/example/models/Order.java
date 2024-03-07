package org.example.models;

import org.example.models.Food;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int accountId;
    List<Food> foodList = new ArrayList<Food>();

    public Order(int accountId, List<Food> foodList) {
        this.accountId = accountId;
        this.foodList = foodList;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    }
