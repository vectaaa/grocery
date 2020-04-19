package com.example.groscerry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GroceryAdapter.OnCheckListener {

    private Button button;
    private CheckBox checkBox;
    RecyclerView recyclerView;
    ArrayList<ModelGrocery> groceriesList;
    ArrayList<ModelGrocery> cartList;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnList);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGroceryList();
            }
        });

        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://picsum.photos/id/1080/300/200", "Fruits"));
        slideModels.add(new SlideModel("https://picsum.photos/id/292/300/200","Veggiess"));
        slideModels.add(new SlideModel("https://picsum.photos/id/488/300/200", "Salads"));
        imageSlider.setImageList(slideModels, true);

        recyclerView = findViewById(R.id.rv);
        groceriesList = new ArrayList<>();
        cartList = new ArrayList<>();

        groceriesList.add(new ModelGrocery(R.drawable.carbage, "Nigerian Carbage", "2 Days", "Delivery Time", "#250",4, false));
        groceriesList.add(new ModelGrocery(R.drawable.apples, "Nigerian Apples", "2 Days", "Delivery Time", "#100", 3, false));
        groceriesList.add(new ModelGrocery(R.drawable.cornedbeef, "Corned Beef", "2 Days", "Delivery Time", "#150", 4,false));
        groceriesList.add(new ModelGrocery(R.drawable.sandine1, "Mega Sandine", "2 Days", "Delivery Time", "#80", 3,false));
        groceriesList.add(new ModelGrocery(R.drawable.sardine2, "Wave Sandine", "2 Days", "Delivery Time", "#70", 5, false));
        groceriesList.add(new ModelGrocery(R.drawable.tomato, "Diced Tomato", "2 Days", "Delivery Time", "#40", 3, false));
        groceriesList.add(new ModelGrocery(R.drawable.spagethi, "Spaghetti", "2 Days", "Delivery Time", "#250",4,false));
        groceriesList.add(new ModelGrocery(R.drawable.maggi, "Knorr Cubes", "2 Days", "Delivery Time", "#150", 4,false));
        groceriesList.add(new ModelGrocery(R.drawable.oil, "Kings Oil", "2 Days", "Delivery Time", "#350", 4,false));
        groceriesList.add(new ModelGrocery(R.drawable.oilbig, "Tama Oil", "2 Days", "Delivery Time", "#550", 4,false));
        groceriesList.add(new ModelGrocery(R.drawable.sweetcorn, "SweetCorn", "2 Days", "Delivery Time", "#220", 4,false));




        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);


        GroceryAdapter adapter = new GroceryAdapter(this, this,  groceriesList);
        recyclerView.setAdapter(adapter);

    }

    public void openGroceryList() {
        String cart = cartList.getClass().toString();
        Intent intent = new Intent(this, GroceryList.class);
        intent.putExtra("cart", cartList);
        startActivity(intent);
    }

    @Override
    public void onCheck(ModelGrocery grocery, boolean check) {
        if (check ) {
            cartList.add(grocery );
        } else {
            cartList.remove(grocery);
        }
    }
}
