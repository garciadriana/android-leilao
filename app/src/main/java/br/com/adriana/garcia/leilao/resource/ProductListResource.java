package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import br.com.adriana.garcia.leilao.R;

public class ProductListResource {
    private final ListView productList;

    public ProductListResource(View view) {
        productList = view.findViewById(R.id.product_list_list);
    }

    public ListView getProductList() {
        return productList;
    }
}
