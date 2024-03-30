package com.akaz.http.services;

import com.akaz.http.excepition.ResourceNotFoundException;
import com.akaz.http.models.Products;
import com.akaz.http.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // indica que a classe é um objeto gerenciavel pelo spring boot
public class ProductsServices {

    private Logger logger =  Logger.getLogger(ProductsServices.class.getName()); // retorna uma mensagem personalizada atraves do terminal

    @Autowired
    private ProductsRepository repository; //ao extender a classe JPA, repository pode acessar diversos metodos que antes deveriam ser feitos a mão

    public Products findProductById(Long id){

        logger.info("Buca de produtos por ID - ok");

//        Products products = new Products();
//        products.setId(counter.incrementAndGet());
//        products.setName("Empire");
//        products.setBrand("Hinode");
//        products.setFeature("Woody");
//        products.setPrice(149.99);

        return repository.findById(id) //caso o valor seja nulo, isso iria gerar uma excessão
                .orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados dados para esse id"));//esse metodo chama uma excessão quando isso ocorre, e tambem pode ser passado a
                               // excessão perosnalizada
    }

    public List<Products> findAllProducts(){

        logger.info("Retornando todos os dados - ok");

        return repository.findAll();
    }


    public Products createProduct(Products products){

        logger.info("Criando produto - ok");

        return repository.save(products);
    }

    public Products updateProduct(Products products){

        logger.info("Atualizando produto - ok");

        Products entity = repository.findById(products.getId()).orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados dados para esse id"));

        entity.setName(products.getName());
        entity.setBrand(products.getBrand());
        entity.setFeature(products.getFeature());
        entity.setPrice(products.getPrice());

        return repository.save(products);
    }

    public void deleteProduct(Long id){

        logger.info("Excluindo Produto");

        Products entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados dados para esse id"));

        repository.delete(entity);

    }


}
