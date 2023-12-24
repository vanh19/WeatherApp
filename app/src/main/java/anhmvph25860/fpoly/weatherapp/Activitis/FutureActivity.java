package anhmvph25860.fpoly.weatherapp.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

import anhmvph25860.fpoly.weatherapp.Adapters.FutureAdapter;
import anhmvph25860.fpoly.weatherapp.Domains.FutureDomains;
import anhmvph25860.fpoly.weatherapp.R;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTommorow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> startActivity(new Intent(FutureActivity.this, MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<FutureDomains> items = new ArrayList<>();

        items.add(new FutureDomains("Sat", "storm", "Storm", 25, 10));
        items.add(new FutureDomains("Sun", "cloudy", "Cloudy", 24, 16));
        items.add(new FutureDomains("Mon", "windy", "Windy", 29, 15));
        items.add(new FutureDomains("Tue", "cloudy_sunny", "Cloudy Sunny", 22, 13));
        items.add(new FutureDomains("Wen", "sunny", "Sunny", 28, 11));
        items.add(new FutureDomains("Thu", "rainy", "Rainy", 23, 12));


        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTommorow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}