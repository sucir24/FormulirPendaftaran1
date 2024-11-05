package com.example.uts_suci_22081015;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextemail;
    private EditText editTextnomor;
    private RadioButton radioMale, radioFemale;
    private CheckBox checkBox;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        editTextName = findViewById(R.id.editTextName);
        editTextemail = findViewById(R.id.editTextemail);
        editTextnomor = findViewById(R.id.editTextnomor);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        checkBox = findViewById(R.id.checkBox1);
        checkBox = findViewById(R.id.checkBox2);
        checkBox = findViewById(R.id.checkBox3);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set listener untuk tombol submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        // Ambil data dari input pengguna
        String name = editTextName.getText().toString();
        String email = editTextemail.getText().toString();
        String nomor = editTextnomor.getText().toString();
        String gender = radioMale.isChecked() ? "Laki-laki" : "Perempuan";
        String hobi = checkBox.isChecked() ? "masak" : "olahraga" ;

        // Buat dialog untuk menampilkan informasi
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Informasi Pengguna");
        builder.setMessage("Nama: " + name +  "\nemail: " + email + "\nnomor: "+nomor + "\nJenis Kelamin: " + gender + "\nhobi: " + hobi);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Data Terkirim", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Menutup dialog
            }
        });

        // Tampilkan dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}