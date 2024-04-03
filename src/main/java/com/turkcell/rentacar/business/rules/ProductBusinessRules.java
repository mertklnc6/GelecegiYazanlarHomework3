package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.BrandMessages;
import com.turkcell.rentacar.business.messages.ProductMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.ProductRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private ProductRepository productRepository;
    public void isProductExistById(int id){
        if (this.productRepository.findById(id).isEmpty()){
            throw new BusinessException(ProductMessages.PRODUCT_NOT_EXIST);
        }
    }
    public void productNameCanNotBeDuplicated(String productName){
        Optional<Product> product = productRepository.findByNameIgnoreCase(productName);
        if(product.isPresent()){
            throw new BusinessException(ProductMessages.PODUCT_ALREADY_EXIST);
        }
    }

    public void checkProductQuantityLimit(int requestProductQuantity,int productId){
        Product product = this.productRepository.findById(productId).orElse(null);

        if (product.getQuantity() < requestProductQuantity){
            throw new BusinessException("There is not " + requestProductQuantity + " product in stock");
        }
    }
    public int calculateTotalPriceofProductRequest(int requestProductQuantity,int productId){
        Product product = this.productRepository.findById(productId).orElse(null);

        return (int) (product.getPrice() * requestProductQuantity);
    }

    public void reduceQuantityofProductsinStore(List<RentalProduct> products){
        for (RentalProduct product:products){
            Product product1 = this.productRepository.findById(product.getId()).orElse(null);
            product1.setQuantity(product1.getQuantity() - product.getProduct().getQuantity());
        }
    }
}
