/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class Productos {
    private Long InventoryItemId;
    private int OrganizationId;
    private double Amount;
    private int Quantity;

    public Productos() {
    }

    public Productos(Long InventoryItemId, int OrganizationId, double Amount, int Quantity) {
        this.InventoryItemId = InventoryItemId;
        this.OrganizationId = OrganizationId;
        this.Amount = Amount;
        this.Quantity = Quantity;
    }

    public Long getInventoryItemId() {
        return InventoryItemId;
    }

    public void setInventoryItemId(Long InventoryItemId) {
        this.InventoryItemId = InventoryItemId;
    }

    public int getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(int OrganizationId) {
        this.OrganizationId = OrganizationId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
