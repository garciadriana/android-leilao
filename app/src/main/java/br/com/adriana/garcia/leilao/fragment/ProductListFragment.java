package br.com.adriana.garcia.leilao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.activity.ParticipantActivity;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;
import br.com.adriana.garcia.leilao.repository.ProductRepository;
import br.com.adriana.garcia.leilao.resource.ProductListResource;

import java.util.List;

public class ProductListFragment extends Fragment {
    private ParticipantActivity context;
    private ProductListResource productListResource;
    private ProductRepository productRepository;
    private ListView productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        listProducts();
    }

    private void init(View view) {
        context = (ParticipantActivity) getActivity();
        productListResource = new ProductListResource(view);
        productRepository = new DatabaseFactory().getDatabase(context).getProductRepository();

    }

    private void listProducts() {
        final List<ProductAndAllBids> products = productRepository.getProductsNotClose();
        ArrayAdapter<ProductAndAllBids> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, products);
        productList = productListResource.getProductList();
        productList.setAdapter(adapter);
        productList.setOnItemClickListener(this::descricao);
    }

    private void descricao(AdapterView<?> adapterView, View view, int position, long id) {
        final ProductAndAllBids product = (ProductAndAllBids) productList.getItemAtPosition(position);

        context.showBid(product);
    }
}
