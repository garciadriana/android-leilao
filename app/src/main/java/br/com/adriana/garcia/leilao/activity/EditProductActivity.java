package br.com.adriana.garcia.leilao.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.Bid;
import br.com.adriana.garcia.leilao.model.Product;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;
import br.com.adriana.garcia.leilao.model.User;
import br.com.adriana.garcia.leilao.repository.ProductRepository;
import br.com.adriana.garcia.leilao.repository.UserRepository;
import br.com.adriana.garcia.leilao.resource.EditProductResource;

import java.util.Optional;

public class EditProductActivity extends AppCompatActivity {

    private EditProductActivity context;
    private EditProductResource productResource;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private ProductAndAllBids productAndAllBids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        init();
        productResource.getSubmit().setOnClickListener(this::save);
    }

    @SuppressLint("NewApi")
    private void init() {
        context = EditProductActivity.this;
        userRepository = new DatabaseFactory().getDatabase(context).getUserRepository();
        productRepository = new DatabaseFactory().getDatabase(context).getProductRepository();
        productAndAllBids = (ProductAndAllBids) getIntent().getExtras().getSerializable("product");
        productResource = new EditProductResource(context);
        productResource.getName().setText(productAndAllBids.getProduct().getName());
        productResource.getDescription().setText(productAndAllBids.getProduct().getDescription());
        final Optional<Bid> max = productAndAllBids.getBids().stream().max((a, b) -> (int) (a.getValue() - b.getValue()));
        productResource.getPrice().setText("R$"+max.get().getValue());
        productResource.getWinner().setText(max.map(bid -> {
            final User byId = userRepository.findById(bid.getUserId());
            return byId.getEmail();
        }).get());
    }

    private void save(View view) {
        final Product product = productAndAllBids.getProduct();
        product.setName(product.getName() + "Encerrado");
        productRepository.update(product);
        onBackPressed();
    }

}
