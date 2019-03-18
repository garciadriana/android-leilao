package br.com.adriana.garcia.leilao.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import br.com.adriana.garcia.leilao.model.Bid;
import br.com.adriana.garcia.leilao.model.Product;
import br.com.adriana.garcia.leilao.model.User;
import br.com.adriana.garcia.leilao.repository.BidRepository;
import br.com.adriana.garcia.leilao.repository.ProductRepository;
import br.com.adriana.garcia.leilao.repository.UserRepository;


@Database(entities = {Bid.class, User.class, Product.class}, version = 7)
public abstract class DatabaseConfig extends RoomDatabase {

    public abstract BidRepository getBidRepository();

    public abstract UserRepository getUserRepository();

    public abstract ProductRepository getProductRepository();
}
