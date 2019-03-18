package br.com.adriana.garcia.leilao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.Product;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;
import br.com.adriana.garcia.leilao.repository.ProductRepository;
import br.com.adriana.garcia.leilao.resource.LeiloeiroProductListResource;
import br.com.adriana.garcia.leilao.resource.ProductResource;

import java.util.List;


public class LeilaoActivity extends AppCompatActivity  {

    private LeilaoActivity context;
    private LeiloeiroProductListResource productResource;
    private ProductRepository productRepository;
    private ListView productList;
    private List<ProductAndAllBids> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leilao);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this::newProduct);

    }

    private void editProduct(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(context, EditProductActivity.class);
        intent.putExtra("product", products.get(position));
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        listProducts();
        productList.setOnItemClickListener(this::editProduct);
    }

    private void init() {
        context = LeilaoActivity.this;
        productResource = new LeiloeiroProductListResource(context);
        productRepository = new DatabaseFactory().getDatabase(context).getProductRepository();
    }

    private void newProduct(View view) {
        Intent intent = new Intent(context, ProductActivity.class);
        startActivity(intent);
    }

    private void listProducts() {
         products = productRepository.getProducts();
        ArrayAdapter<ProductAndAllBids> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, products);
        productList = productResource.getProductList();
        productList.setAdapter(adapter);
    }

}
