package com.example.ejercicio4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class CuentaBancaria extends AppCompatEditText {
    public void iniciarFiltros() {
        InputFilter[] filtros = new InputFilter[1];
        filtros[0] = new InputFilter.LengthFilter(19);
        this.setFilters(filtros);
    }

    public void onDraw(Canvas canvas) {
        Paint pincel = new Paint();

        pincel.setColor(Color.BLACK);
        pincel.setStyle(Paint.Style.STROKE);
        super.onDraw(canvas);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), pincel);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d("TAG", "Tecla pulsada " + keyCode);
        Editable texto;
        //Solo añado la / si no se ha pulsado la tecla BORRAR
        if (keyCode != KeyEvent.KEYCODE_DEL) {

            if (this.length() == 4) {
                this.setText(this.getText() + "-");
                this.setSelection(this.length());
            } else if (this.length() == 9) {
                this.setText(this.getText() + "-");
                this.setSelection(this.length());
            } else if (this.length() == 14) {
                this.setText(this.getText() + "-");
                this.setSelection(this.length());
            }
        }
        return true;
    }

    public CuentaBancaria(@NonNull Context context) {
        super(context);
        iniciarFiltros();
    }

    public CuentaBancaria(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        iniciarFiltros();
    }

    public CuentaBancaria(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniciarFiltros();
    }
}
