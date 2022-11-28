package com.ecommerce.controller;


import com.ecommerce.dao.definition.SupplierDao;
import com.ecommerce.dto.SupplierDto;
import com.ecommerce.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierDao supplierDao;

    @GetMapping("/supplier")
    public String supplier(Model m){

        m.addAttribute("supplierDto", new SupplierDto());
        return "/admin/supplier";
    }


    @PostMapping("views/supplier")
    public String createSupplier(Model model,
                                 @ModelAttribute("supplierDto")SupplierDto supplierDto)
                                    throws IOException {

        Supplier supplier = new Supplier();

        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setSupplierAddress(supplierDto.getSupplierAddress());

        supplierDao.addSupplier(supplier);

        model.addAttribute("supplier",supplier);

        return "redirect:/showSupplier";
    }

    @GetMapping("/showSupplier")
    public String getSupplier(Model model){

        List<Supplier> suppliers= supplierDao.listSuppliers();
        model.addAttribute("suppliers",suppliers);
        return "admin/showSupplier";
    }

    @RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
    public String updateSupplier(Model model, @RequestParam("supplierId") int supplierId,
                                 @ModelAttribute("supplierDto")SupplierDto supplierDto){

        Supplier supplier= supplierDao.getSupplier(supplierId);
        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setSupplierAddress(supplierDto.getSupplierAddress());
        supplierDao.updateSupplier(supplier);
        return "redirect:/admin/showSupplier";
    }

    @RequestMapping(value = "/editSupplier/{supplierId}")
    public String editSupplier(Model model,
                               @PathVariable("supplierId") int supplierId){
        Supplier supplier=supplierDao.getSupplier(supplierId);
        model.addAttribute("supplier", supplier);
        return "admin/updateSupplier";
    }

    @RequestMapping(value = "/deleteSupplier/{supplierId}")
    public String deleteSupplier(Model m,
                                 @PathVariable("supplierId")int supplierId){

        Supplier supplier=supplierDao.getSupplier(supplierId);
        supplierDao.deleteSupplier(supplier);

        return "redirect:/admin/showSupplier";
    }
}
