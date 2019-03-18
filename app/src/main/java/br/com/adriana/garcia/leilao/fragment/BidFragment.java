package br.com.adriana.garcia.leilao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.activity.ParticipantActivity;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.Bid;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;
import br.com.adriana.garcia.leilao.model.User;
import br.com.adriana.garcia.leilao.repository.BidRepository;
import br.com.adriana.garcia.leilao.resource.BidResource;

public class BidFragment extends Fragment {
    private ParticipantActivity context;
    private BidResource bidResource;
    private BidRepository bidRepository;
    private ProductAndAllBids product;
    private User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bid, container, false);
        init(view);
        doBid();
        return view;
    }

    private void doBid() {
        bidResource.getSubmit().setOnClickListener(this::saveBid);
    }

    private void saveBid(View view) {
        final Bid bid = new Bid();

        final String priceString = bidResource.getPrice().getText().toString();
        final double priceDouble = Double.parseDouble(priceString);
        bid.setValue(priceDouble);
        bid.setProductId(product.getProduct().getId());
        bid.setUserId(user.getId());

        bidRepository.insert(bid);
        context.backToProductList();
    }


    private void init(View view) {
        context = (ParticipantActivity) getActivity();
        bidResource = new BidResource(view);
        bidRepository = new DatabaseFactory().getDatabase(context).getBidRepository();
        product = (ProductAndAllBids) getArguments().getSerializable("product");
        user = (User) getArguments().getSerializable("user");
    }
}
