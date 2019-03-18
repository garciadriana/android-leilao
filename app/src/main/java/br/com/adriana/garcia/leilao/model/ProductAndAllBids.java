package br.com.adriana.garcia.leilao.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.io.Serializable;
import java.util.List;

public class ProductAndAllBids implements Serializable {
    @Embedded
    private Product product;
    @Relation(parentColumn = "id", entityColumn = "productId", entity = Bid.class)
    private List<Bid> bids;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return product.getName() + "-" + bids.size();
    }
}
