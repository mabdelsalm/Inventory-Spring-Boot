package com.inventory.sprintbootrestapi.model;
import javax.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemNo;

    @Column(name="name")
    private String  name;

    @Column(name="amount")
    private long  amount;

    @Column(name="inventoryCode")
    private String  inventoryCode;

    public Item(){

    }
    public Item(String name, long amount, String inventoryCode) {
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }

    public long getItemNo(){
        return itemNo;
    }
    public void setItemNo(long itemNo){
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }
    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }








}
