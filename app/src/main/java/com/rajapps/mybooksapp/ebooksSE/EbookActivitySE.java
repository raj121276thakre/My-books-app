package com.rajapps.mybooksapp.ebooksSE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rajapps.mybooksapp.R;
import com.rajapps.mybooksapp.ebook.EbookActivity;
import com.rajapps.mybooksapp.ebook.EbookAdapter;
import com.rajapps.mybooksapp.ebook.EbookData;

import java.util.ArrayList;
import java.util.List;

public class EbookActivitySE extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_se);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SE Ebooks");

        ebookRecycler = findViewById(R.id.ebookRecyclerSE);

        reference = FirebaseDatabase.getInstance().getReference().child("SE_sem_1");


        getData();


    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()){
                    EbookData data = snapshot.getValue(EbookData.class);
                    list.add(data);
                }

                adapter = new EbookAdapter(EbookActivitySE.this, list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivitySE.this));

                ebookRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(EbookActivitySE.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}