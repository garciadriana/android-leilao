package br.com.adriana.garcia.leilao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.delegate.ParticipantDelegate;
import br.com.adriana.garcia.leilao.fragment.BidFragment;
import br.com.adriana.garcia.leilao.fragment.ProductListFragment;
import br.com.adriana.garcia.leilao.model.ProductAndAllBids;
import br.com.adriana.garcia.leilao.model.User;


public class ParticipantActivity extends AppCompatActivity implements ParticipantDelegate {


    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        showProductList();
    }

    @Override
    public void showProductList() {
        user = (User) getIntent().getExtras().getSerializable("user");
        changeFragment(new ProductListFragment(), false);
    }

    @Override
    public void showBid(ProductAndAllBids product) {


        final Bundle arguments = new Bundle();
        arguments.putSerializable("product", product);
        arguments.putSerializable("user", user);

        final BidFragment fragment = new BidFragment();
        fragment.setArguments(arguments);
        changeFragment(fragment, true);
    }

    @Override
    public void backToProductList() {
        onBackPressed();
    }

    private void changeFragment(Fragment fragment, boolean stack) {
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.participant_frame, fragment);
        if (stack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }


}
