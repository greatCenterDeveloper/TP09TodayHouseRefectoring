package com.swj.tp09todayhouserefectoring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.swj.tp09todayhouserefectoring.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SearchView searchView;
    ArrayList<Item> itemArrayList = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        itemArrayList.add(new Item(R.drawable.room01, "복잡하고 어두웠던 공간을 깔끔하게", "디자인홈즈"));
        itemArrayList.add(new Item(R.drawable.room02, "큰 창문으로 개방감을 준 화이트 인테리어", "LX지인 HS디자인"));
        itemArrayList.add(new Item(R.drawable.room03, "복층 침대로 내부 여유 공간을 크게", "예스디자인"));
        itemArrayList.add(new Item(R.drawable.room04, "공부하기 좋은 화이트 인테리어", "대해건축디자인"));
        itemArrayList.add(new Item(R.drawable.room05, "화이트/블루를 섞은 고품격 인테리어", "디자인홈즈"));
        itemArrayList.add(new Item(R.drawable.room06, "고품격 벙커형 인테리어", "LX지인 HS디자인"));
        itemArrayList.add(new Item(R.drawable.room07, "한옥 느낌 물씬나는 그리운 옛맛", "예스디자인"));
        itemArrayList.add(new Item(R.drawable.room08, "유럽에 온 것처럼! 유럽식 호텔형 인테리어", "대해건축디자인"));

        binding.tvTotal.setText("" + itemArrayList.size());
        adapter = new MyAdapter(this, itemArrayList);
        binding.recyclerview.setAdapter(adapter);
        
        binding.btnSort.setOnClickListener(view -> Toast.makeText(this, "정렬", Toast.LENGTH_SHORT).show());
        binding.btnJugeoType.setOnClickListener(view -> Toast.makeText(this, "주거형태", Toast.LENGTH_SHORT).show());
        binding.btnPyeong.setOnClickListener(view -> Toast.makeText(this, "평수", Toast.LENGTH_SHORT).show());
        binding.btnArea.setOnClickListener(view -> Toast.makeText(this, "지역", Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("오늘의집 통합검색");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                searchView.setQuery("", false);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_jjim)
            Toast.makeText(this, "찜", Toast.LENGTH_SHORT).show();
        else if(item.getItemId() == R.id.menu_shopping_basket)
            Toast.makeText(this, "장바구니", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}