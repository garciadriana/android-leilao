package br.com.adriana.garcia.leilao.resource;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.adriana.garcia.leilao.R;

public class BidResource {
    private final TextView title;
    private final TextView price;
    private final Button submit;

    public BidResource(View view) {
        title = view.findViewById(R.id.bid_title);
        price = view.findViewById(R.id.bid_price);
        submit = view.findViewById(R.id.bid_submit);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getPrice() {
        return price;
    }

    public Button getSubmit() {
        return submit;
    }
}
