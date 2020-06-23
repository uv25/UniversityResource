package com.uatech.MyUnix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DownloadList extends AppCompatActivity {
    ArrayList<File> pdfList;
    ArrayList<String> pdfNames;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_list);

        listView = (ListView) findViewById(R.id.list_view);

        pdfList = new ArrayList<>();
        pdfNames = new ArrayList<>();
        getFileNames();
        display();
    }

    void getFileNames()
    {
        File storage = new File(Environment.getExternalStorageDirectory().getPath() + "/MyUniversity");
        for (File f: storage.listFiles())
        {
            if (f.isFile() && f.getName().endsWith(".pdf"))
            {
                pdfList.add(f);
                pdfNames.add(f.getName());

            }
        }
    }

    void display()
    {
        Log.d("pdf names", pdfList.get(0).getName());
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, pdfNames);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri pdfUri = Uri.fromFile(pdfList.get(position));

                Intent intent = new Intent(DownloadList.this, PDFViewerActivity.class);
                intent.putExtra("pdfFile", pdfUri);
                startActivity(intent);
            }
        });
    }
}

