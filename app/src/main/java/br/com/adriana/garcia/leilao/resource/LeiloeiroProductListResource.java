package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import br.com.adriana.garcia.leilao.R;

public class LeiloeiroProductListResource {
    private final ListView productList;

    public LeiloeiroProductListResource(Activity view) {
        productList = view.findViewById(R.id.product_list_list);
    }

    public ListView getProductList() {
        return productList;
    }
}
