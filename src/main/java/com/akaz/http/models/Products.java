package com.akaz.http.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "products") //informa o nome da tabela a qual a classe esta se referindo, e caso seja o mesmo nome da classe,
// pode ser omitido a anotatio
public class Products implements Serializable {

    @Serial
    private static final long serialVersionUID = 4502546432388941133L;

    @Id //infoma a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //metodo para gerar um valor incremental a cada persistenci de dados
    private long id;

    @Column(name = "name", nullable = false, length = 100) //tem por objetivo infomar o nome da tabela para esse campo
    private String name;

    @Column(nullable = false, length = 100) //se o nomeda coluna for igual ao nome do compo, se coloca apensa @Column
    private String brand;

    @Column(nullable = false, length = 300)
    private String feature;

    @Column(nullable = false, length = 10)
    private double price;


    public Products(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {  //reescrita do metodo equals
        if (this == o) return true; //se o objeto comparador for identico ao objeto comparado,retorna true
        if (!(o instanceof Products products)) return false; //se o objeto comparado for uma instancia de Products for verdadeiro,
                                                             // retorna true, onde o valor invertido pelo sinal de exclamação
                                                             // realização do casting utilizando correspondecia de
                                                             // padroes (pattern matching)

        // se os valores a seguir forem identicos, significa que os objetos irão ser uma referencia identica, ou inves de
        // duas referencias distintas para uma mesma classe
        // para x.equals(y), onde x == "objeto comparador" e y == "Objeto comprado"
        return getId() == products.getId() && //true se x.id == y.id
                Double.compare(getPrice(), products.getPrice()) == 0 && // true se x.price == y.price
                Objects.equals(getName(), products.getName()) && // true se x.name == y.price
                Objects.equals(getBrand(), products.getBrand()) && // true se x.brand == y.brand
                Objects.equals(getFeature(), products.getFeature()); // true se x.feature == y.feature
    }

    // cria um hash code personalizado para a classe person com base nos campos declarados inicialmente
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBrand(), getFeature(), getPrice());
    }
}
