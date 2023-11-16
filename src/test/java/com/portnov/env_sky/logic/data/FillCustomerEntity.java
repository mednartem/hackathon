package com.portnov.env_sky.logic.data;

import com.portnov.env_sky.logic.db.model.CustomerEntity;

public class FillCustomerEntity {

    public CustomerEntity fillRequiredFields() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(RandomData.generateUniqEmail());
        customerEntity.setUsername(RandomData.generateFirstName());
        customerEntity.setCustomerGuid(RandomData.generateUUID());
        customerEntity.setIsTaxExempt(0);
        customerEntity.setAffiliateId(0);
        customerEntity.setVendorId(0);
        customerEntity.setHasShoppingCartItems(0);
        customerEntity.setRequireReLogin(0);
        customerEntity.setFailedLoginAttempts(0);
        customerEntity.setActive(1);
        customerEntity.setDeleted(0);
        customerEntity.setIsSystemAccount(0);
        customerEntity.setCreatedOnUtc(Time.getDateNow());
        customerEntity.setLastActivityDateUtc(Time.getDateNow());
        customerEntity.setRegisteredInStoreId(1);

        return customerEntity;
    }
}
