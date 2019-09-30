package com.example.colorsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

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

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.menu1, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
            switch(item.getItemId()){
                case R.id.iteTransparent:
                    return true;
                case R.id.iteSemiTransparent :
                    return true;
                case R.id.iteOpaque :
                    return true;
                case R.id.iteBlack :
                    return true;
                case R.id.iteWhite :
                    return true;
                case R.id.iteCyan :
                    return true;
                case R.id.iteMagenta :
                    return true;
                case R.id.iteYellow :
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode = null;

        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int r = srbRed.getProgress();
        int g = srbGren.getProgress();
        int b = srbBlue.getProgress();
        int t = srbTransparent.getProgress();
        int a = srbAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu1,menu);
        menu.setHeaderTitle("::: Select a color :::");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.iteTransparent:
                Toast.makeText(this, " Has chosen Trasparent", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteSemiTransparent :
                Toast.makeText(this, "Has chosen SemiTransparent", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteOpaque :
                Toast.makeText(this, "Has chosen Opaque", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteBlack :
                Toast.makeText(this, "Has chosen Black", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteWhite :
                Toast.makeText(this, "Has chosen White", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteCyan :
                Toast.makeText(this, "Has chosen Cyan", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteMagenta :
                Toast.makeText(this, "Has chosen Magenta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iteYellow :
                Toast.makeText(this, "You've selected green color", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

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

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
