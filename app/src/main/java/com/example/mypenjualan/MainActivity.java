package com.example.mypenjualan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etHarga, etJumlah, etByr;
    Button btTotal, btHasil, btClear;
    TextView tvTot, tvKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNama = (EditText) findViewById(R.id.etNamaBarang);
        etHarga = (EditText) findViewById(R.id.etHargaBarang);
        etJumlah = (EditText) findViewById(R.id.etJumlahBarang);
        etByr = (EditText) findViewById(R.id.etBayar);
        btTotal = (Button) findViewById(R.id.btnTotal);
        btHasil = (Button) findViewById(R.id.btnHasil);
        btClear = (Button) findViewById(R.id.btnClear);
        tvTot = (TextView) findViewById(R.id.tvTotal);
        tvKembali = (TextView) findViewById(R.id.tvKembalian);

        btTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double jmlbarang, hrgbarang, total;
                jmlbarang = Double.valueOf(etJumlah.getText().toString().trim());
                hrgbarang = Double.valueOf(etHarga.getText().toString().trim());
                total = jmlbarang * hrgbarang;
                String total1 = String.valueOf(total);
                tvTot.setText(total1);
            }
        });

        btHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bayar, totharga, hasil;
                totharga = Double.valueOf(tvTot.getText().toString().trim());
                bayar = Double.valueOf(etByr.getText().toString().trim());
                hasil = bayar - totharga;
                String hasil1 = String.valueOf(hasil);
                tvKembali.setText(hasil1);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNama.setText("");
                etHarga.setText("");
                etJumlah.setText("");
                etByr.setText("");
                tvTot.setText("");
                tvKembali.setText("");
            }
        });
    }
}