package com.example.projeto_pdm_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SlideHolder extends RecyclerView.ViewHolder{

    public TextView titulo;

    public ImageView imagem;

    public SlideHolder(@NonNull View itemView) {
        super(itemView);

        titulo = itemView.findViewById(R.id.textView6);
        imagem = itemView.findViewById(R.id.imageView6);

    }
}
