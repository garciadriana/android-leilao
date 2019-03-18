package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.model.Product;

public class EditProductResource {
    private final TextView name;
    private final TextView description;
    private final TextView winner;
    private final TextView price;
    private final Button submit;

    public EditProductResource(Activity view) {
        name = view.findViewById(R.id.edit_product_name);
        description = view.findViewById(R.id.edit_product_description);
        winner = view.findViewById(R.id.edit_winner);
        price = view.findViewById(R.id.edit_price);
        submit = view.findViewById(R.id.edit_product_submit);
    }

    public TextView getPrice() {
        return price;
    }

    public TextView getWinner() {
        return winner;
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

    public Product getProduct() {
        final Product product = new Product();
        product.setName(name.getText().toString());
        product.setDescription(description.getText().toString());
        return product;
    }
}
