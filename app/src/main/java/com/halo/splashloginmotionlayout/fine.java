package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class fine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Offence- Talking On Mobile Phone","Section- 250 A MMVR/177 MVA","Fine- 200"),
                new MyListData("Offence- Without Valid MDL","Section- 3/181 MVA (Driver)","Fine- 500"),
                new MyListData("Offence- Allowed Unauthorized Persons to Drive","Section- 5/180 MVA (Owner)","Fine- 500"),
                new MyListData("Offence- Driver Failed or Refused to Produce MDL","Section- 130 (1) MVA/177 MVA\t","Fine- 200"),
                new MyListData("Offence- Parking-Footpath","Section- 15 (2) (2) RRR/177 MVA","Fine- 200"),
                new MyListData("Offence- Parking- on or Near Bend","Section- 15 (2) (1) RRR/177 MVA","Fine- 200"),
                new MyListData("Offence- Parking-on Bridge","Section- 15 (2) (1) RRR/177 MVA","Fine- 200"),
                new MyListData("Offence- Parking- on Road Crossing","Section- 15 (2) (1) RRR/177 MVA","Fine- 200"),
                new MyListData("Offence- Drunk and Drive (Non-Compoundable Offence)","Section- 185 MVA","Fine- 2000"),
                new MyListData("Offence- Triple Seat","Section- 128(1)/177 MVA","Fine- 200"),
                new MyListData("Offence- Talking On Mobile Phone","Section- 250 A MMVR/177 MVA","Fine- 200"),
                new MyListData("Offence- Talking On Mobile Phone","Section- 250 A MMVR/177 MVA","Fine- 200"),
                new MyListData("Offence- Talking On Mobile Phone","Section- 250 A MMVR/177 MVA","Fine- 200"),



        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}