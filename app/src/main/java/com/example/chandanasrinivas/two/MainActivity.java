package com.example.chandanasrinivas.two;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomView mCV;
    Button btn;
    Button context;
    Button alertbtn,progressbtn,arrayad;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.btn);
        context = (Button) findViewById(R.id.context);
        alertbtn = (Button) findViewById(R.id.alert);
        progressbtn=(Button) findViewById(R.id.progress);
        arrayad=(Button) findViewById(R.id.arrayad);
        mCV= (CustomView) findViewById(R.id.cv);

        //CONTEXT MENU
        registerForContextMenu(context);

        //CUSTOM VIEW
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCV.swapColor();
            }
        });

        //ALERT DIALOG
        alertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
                ab.setMessage("Close ?").setCancelable(false)
                        .setPositiveButton("YES",new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface d,int which)
                            {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert=ab.create();
                alert.setTitle("ALERT");
                alert.show();

            }
        });

        //PROGRESS DIALOG
        progressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd=new ProgressDialog(MainActivity.this);
                pd.setTitle("DOWNLOAD");
                pd.setMessage("DOWNLOADING");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setProgress(0);
                pd.setMax(100);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress=0;
                        while(progress<=100)
                        {
                            try{
                                pd.setProgress(progress);
                                progress++;
                                Thread.sleep(200);
                            }catch(Exception e){}

                        }
                        pd.dismiss();
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"DOWNLOADING",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                t.start();
                pd.show();
            }
        });

        //ARRAY ADAPTER
        arrayad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,listAndArray.class);
                startActivity(i);
            }
        });


    }
    //CONTEXT MENU
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuinfo)
    {
        super.onCreateContextMenu(menu,v,menuinfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"ONE");
        menu.add(0,v.getId(),2,"TWO");
        menu.add(0,v.getId(),3,"THREE");
        menu.add(0,v.getId(),4,"FOUR");

    }

    public boolean onContextItemSelected(MenuItem item)
    {
        Toast.makeText(this,"Selected Item : "+item.getTitle(),Toast.LENGTH_SHORT).show();
        return true;
    }


    //OPTIONS MENU
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.my_menu,menu);
        return(super.onCreateOptionsMenu(menu));
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1 :
                Toast.makeText(this, "ITEM 1 SELECTED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2 :
                Toast.makeText(this, "ITEM 2 SELECTED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3 :
                Toast.makeText(this, "ITEM 3 SELECTED", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
