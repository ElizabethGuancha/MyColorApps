package com.example.colorsapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDos extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

   // pasos 1. obtener o instanciar los id's del xml del diseño activity_main.xml
    private SeekBar srbRed = null;
    private SeekBar srbGren = null;
    private SeekBar srbBlue = null;
    private SeekBar srbTransparent = null;
    private SeekBar srbSemiTransparent = null;
    private SeekBar srbOpaque = null;
    private SeekBar srbBlack = null;
    private SeekBar srbWhite = null;
    private SeekBar srbCyan = null;
    private SeekBar srbMagenta = null;
    private SeekBar srbYellow = null;
    private SeekBar srbAlpha = null;
    private View vieColors = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // paso 2. Obtener los id's del diseñor activity_main.xml

        srbRed = findViewById(R.id.sbrRed);
        srbGren = findViewById(R.id.sbrGreen);
        srbBlue = findViewById(R.id.sbrBlue);
        srbAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);

        // paso 3. cada vez que se mueva la barra de progreso va a guardar un valor entre 0 - 255
        // en el this se realiza una agregacion del Seekbar a la clase como importacion y se generan los metodos

        srbRed.setOnSeekBarChangeListener(this);
        srbGren.setOnSeekBarChangeListener(this);
        srbBlue.setOnSeekBarChangeListener(this);
        srbAlpha.setOnSeekBarChangeListener(this);

        // 4 paso: contextmenu on view component  cuando yo mantega sostenido se abra el menu contextual
        registerForContextMenu(vieColors);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.iteTransparent:
                Toast.makeText(this, "You've selected option 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteSemiTransparent:
                Toast.makeText(this, "You've selected option 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteOpaque:
                Toast.makeText(this, "You've selected option 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteBlack:
                Toast.makeText(this, "You've selected suboption 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteWhite:
                Toast.makeText(this, "You've selected suboption 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteCyan:
                Toast.makeText(this, "You've selected suboption 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteMagenta:
                Toast.makeText(this, "You've selected suboption 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteYellow:
                Toast.makeText(this, "You've selected suboption 3", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
