package com.portnov.env_sky.logic.db.model;

import java.util.UUID;

public class CustomerEntity {
    private int id;
    private String email;
    private String username;
    private UUID customerGuid;
    private int isTaxExempt;
    private int affiliateId;
    private int vendorId;
    private int hasShoppingCartItems;
    private int requireReLogin;
    private int failedLoginAttempts;
    private int active;
    private int deleted;
    private int isSystemAccount;
    private String createdOnUtc;
    private String lastActivityDateUtc;
    private int registeredInStoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getCustomerGuid() {
        return customerGuid;
    }

    public void setCustomerGuid(UUID customerGuid) {
        this.customerGuid = customerGuid;
    }

    public int getIsTaxExempt() {
        return isTaxExempt;
    }

    public void setIsTaxExempt(int isTaxExempt) {
        this.isTaxExempt = isTaxExempt;
    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getHasShoppingCartItems() {
        return hasShoppingCartItems;
    }

    public void setHasShoppingCartItems(int hasShoppingCartItems) {
        this.hasShoppingCartItems = hasShoppingCartItems;
    }

    public int getRequireReLogin() {
        return requireReLogin;
    }

    public void setRequireReLogin(int requireReLogin) {
        this.requireReLogin = requireReLogin;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getIsSystemAccount() {
        return isSystemAccount;
    }

    public void setIsSystemAccount(int isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }

    public String getCreatedOnUtc() {
        return createdOnUtc;
    }

    public void setCreatedOnUtc(String createdOnUtc) {
        this.createdOnUtc = createdOnUtc;
    }

    public String getLastActivityDateUtc() {
        return lastActivityDateUtc;
    }

    public void setLastActivityDateUtc(String lastActivityDateUtc) {
        this.lastActivityDateUtc = lastActivityDateUtc;
    }

    public int getRegisteredInStoreId() {
        return registeredInStoreId;
    }

    public void setRegisteredInStoreId(int registeredInStoreId) {
        this.registeredInStoreId = registeredInStoreId;
    }
}
