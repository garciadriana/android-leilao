package br.com.adriana.garcia.leilao.repository;

import android.arch.persistence.room.*;
import br.com.adriana.garcia.leilao.model.Product;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;

import java.util.List;

@Dao
public interface ProductRepository {
    @Insert
    void insert(Product lance);

    @Update
    void update(Product lance);

    @Delete
    void delete(Product lance);

    @Query("Select * from Product ")
    List<ProductAndAllBids> getProducts();

    @Query("Select * from Product where name NOT like '%Encerrado%' ")
    List<ProductAndAllBids> getProductsNotClose();
}
