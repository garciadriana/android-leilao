package br.com.adriana.garcia.leilao.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import br.com.adriana.garcia.leilao.model.Bid;

@Dao
public interface BidRepository {

    @Insert
    void insert(Bid bid);
}
