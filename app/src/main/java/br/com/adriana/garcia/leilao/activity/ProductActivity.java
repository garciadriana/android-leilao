package br.com.adriana.garcia.leilao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.Product;
import br.com.adriana.garcia.leilao.repository.ProductRepository;
import br.com.adriana.garcia.leilao.resource.ProductResource;

public class ProductActivity extends AppCompatActivity {
    private ProductActivity context;
    private ProductResource productResource;
    private ProductRepository productRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        init();
        productResource.getSubmit().setOnClickListener(this::save);
    }

    private void init() {
        context = ProductActivity.this;
        productResource = new ProductResource(context);
        productRepository = new DatabaseFactory().getDatabase(context).getProductRepository();
    }

    private void save(View view) {
        final Product product = productResource.getProduct();
        productRepository.insert(product);
        onBackPressed();
    }

}
