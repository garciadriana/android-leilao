package br.com.adriana.garcia.leilao.delegate;

import br.com.adriana.garcia.leilao.model.ProductAndAllBids;

public interface ParticipantDelegate {

    void showProductList();

    void showBid(ProductAndAllBids product);

    void backToProductList();
}
