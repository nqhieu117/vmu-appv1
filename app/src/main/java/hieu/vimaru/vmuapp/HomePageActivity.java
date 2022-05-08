package hieu.vimaru.vmuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    ImageView dangXuat;
    ImageView tinTuc;
    ImageView bangDiem;
    ImageView traCuuHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        dangXuat = (ImageView) findViewById(R.id.imageViewdangxuat);
        tinTuc = (ImageView) findViewById(R.id.btnTinTuc);
        bangDiem = (ImageView) findViewById(R.id.btnBangDiem);
        traCuuHoaDon = (ImageView) findViewById(R.id.btnTraCuuHoaDon);

        dangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tinTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://sdh.vimaru.edu.vn/tin-tuc"));
                startActivity(intent);
            }
        });

        bangDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, BangDiemActivity.class);
                startActivity(intent);
            }
        });

        traCuuHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.meinvoice.vn/tra-cuu/"));
                startActivity(intent);
            }
        });




    }
}