package com.example.sandwich_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int topping = 0;
    int sand = 0;       //샌드위치 가격
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        int viewId = v.getId();
        int sum = 0;

        //result
        TextView total = findViewById(R.id.total);

        switch(viewId){
            case R.id.ham:
                sand = 5000;
                break;
            case R.id.tuna:
                sand = 4000;
                break;
            case R.id.chicken:
                sand = 4500;
                break;
            case R.id.bacon:
                if(((CheckBox)v).isChecked())
                    topping += 1000;
                else
                    topping -= 1000;
                break;
            case R.id.cheese:
                if(((CheckBox)v).isChecked())
                    topping += 500;
                else
                    topping -= 500;
                break;
            case R.id.avocado:
                if(((CheckBox)v).isChecked())
                    topping += 1500;
                else
                    topping -= 1500;

                break;
        }

        sum = sand + topping;
        total.setText(Integer.toString(sum));
    }
    //옵션 메뉴 생성
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    //옵션 메뉴 항목 선태 이벤트 처리
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.apple:
                Toast.makeText(getApplicationContext(),"Apple", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grape:
                Toast.makeText(getApplicationContext(),"Grape",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(getApplicationContext(),"Banana",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}