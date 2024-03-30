package com.akaz.http.repository;

import com.akaz.http.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//utilizada como uma classe para persistir dados
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> { //<Objeto, e tipo do id>
                                            // recupera o Objeto Products, e tambem o type do campo marcado com o @Id,
                                            // nesse caso, Long(não pode ser um tipo primitivo)

    //ProductsRepository será reponsavel por acessar e manipular dados de Products
}
