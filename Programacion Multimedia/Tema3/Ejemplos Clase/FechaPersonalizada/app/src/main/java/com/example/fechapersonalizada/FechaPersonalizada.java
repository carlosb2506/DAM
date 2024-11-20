package com.example.fechapersonalizada;

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

public class FechaPersonalizada extends AppCompatEditText
{
    // Vamos a añadir un filtro que solo permita escribir 10 caracteres
    // en el campo
    public void iniciarFiltros()
    {

        InputFilter[] filtros = new InputFilter[1];

        filtros[0] = new InputFilter.LengthFilter(10);
        // Hemos creado un array porque es el parametro de entrada del metodo setFilters
        this.setFilters(filtros);
    }

    //Vamos a pintar el componente: queremos que sea cuadrado con borde negro
    public void onDraw(Canvas canvas){
        Paint pincel = new Paint();

        pincel.setColor(Color.BLACK);
        pincel.setStyle(Paint.Style.STROKE);
        super.onDraw(canvas);
        canvas.drawRect(0,0, this.getWidth(), this.getHeight(), pincel);
    }

    // Este método se llama cada vez que se pulsa una tecla en el teclado
    public boolean onKeyUp(int keyCode, KeyEvent event){
        Log.d("TAG", "Tecla pulsada " + keyCode );
        Editable texto;
        //Solo añado la / si no se ha pulsado la tecla BORRAR
        if (keyCode != KeyEvent.KEYCODE_DEL)
        {

            if (this.length() == 2){
                this.setText(this.getText() + "/");
                this.setSelection(this.length());
            } else if (this.length() == 5) {
                this.setText(this.getText() + "/");
                this.setSelection(this.length());
            }
        }

        else {
            if (this.length() == 2){
                texto = this.getText();
                //Solo me quedo con lo que hay escrito en la posicion 1
                texto.delete(1,texto.length());
                this.setText(texto);
                this.setSelection(this.length());
            }else if (this.length() == 5){
                texto = this.getText();
                //Solo me quedo con lo que hay escrito en la posicion 1
                texto.delete(4,texto.length());
                this.setSelection(this.length());
            }
        }

        return true;
    }

    public FechaPersonalizada(@NonNull Context context) {
        super(context);
        iniciarFiltros();
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        iniciarFiltros();
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniciarFiltros();
    }
}
