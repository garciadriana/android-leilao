package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.model.Product;

public class ProductResource {
    private final TextView name;
    private final TextView description;
    private final Button submit;

    public ProductResource(Activity view) {
        name = view.findViewById(R.id.product_name);
        description = view.findViewById(R.id.product_description);
        submit = view.findViewById(R.id.product_submit);
    }

    public TextView getName() {
        return name;
    }

    public TextView getDescription() {
        return description;
    }

    public Button getSubmit() {
        return submit;
    }

    public Product getProduct(){
        final Product product = new Product();
        product.setName(name.getText().toString());
        product.setDescription(description.getText().toString());
        return product;
    }
}
