package com.ecommerce.dao.definition;

import com.ecommerce.entity.Supplier;

import java.util.List;

public interface SupplierDao {

    public boolean addSupplier(Supplier supplier);
    public boolean deleteSupplier(Supplier supplier);
    public boolean updateSupplier(Supplier supplier);

    public List<Supplier> listSuppliers();
    public Supplier getSupplier(int supplierId);

}
