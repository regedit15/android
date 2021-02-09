package com.example.cuantocuesta.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cuantocuesta.Models.Calculo;
import com.example.cuantocuesta.R;
import com.example.cuantocuesta.Services.UtilService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class CalculoAdapter extends RecyclerView.Adapter<CalculoAdapter.ViewHolder> {

    private Context context;
    private List<Calculo> lista;
    private int layout;

    public CalculoAdapter(List<Calculo> lista, int layout) {
        this.lista = lista;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextInputEditText tiCantidad;
        public TextInputEditText tiMetro;
        public TextInputLayout tilCantidad;
        public TextInputLayout tilMetro;
        public TextInputEditText tiPrecio;
        public Button btTipo;
        public TextView tvResultado;
        public TextView tvResultadoValor;

        public ViewHolder(View itemView) {
            super(itemView);
            btTipo = itemView.findViewById(R.id.btTipo);
            tiCantidad = itemView.findViewById(R.id.tiCantidad);
            tilCantidad = itemView.findViewById(R.id.tilCantidad);
            tiPrecio = itemView.findViewById(R.id.tiPrecio);
            tvResultado = itemView.findViewById(R.id.tvResultado);
            tvResultadoValor = itemView.findViewById(R.id.tvResultadoValor);
            tiMetro = itemView.findViewById(R.id.tiMetro);
            tilMetro = itemView.findViewById(R.id.tilMetro);
            tvResultadoValor.setText("");
            tilMetro.setVisibility(View.GONE);
        }

        public void bind(final Calculo calculo) {
            btTipo.setOnClickListener(view -> {
                Dialog dialog;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Filtrar por Tags: ");

                String[] tipos = UtilService.getTipos();

                builder.setSingleChoiceItems(tipos, Arrays.asList(tipos).indexOf(calculo.getUnidad()), (dialog1, index) -> {
                    btTipo.setText(tipos[index]);
                    calculo.setUnidad(tipos[index]);


                    String frase = "Precio por ";

                    switch (calculo.getUnidad()) {
                        case UtilService.TIPO_KILO:
                        case UtilService.TIPO_GRAMOS:
                            frase += "kilo:";
                            break;
                        case UtilService.TIPO_UNIDAD:
                            frase += "unidad:";
                            break;
                        case UtilService.TIPO_LITRO:
                            frase += "litro:";
                            break;
                        case UtilService.TIPO_PAPEL_HIGIENICO:
                            frase += "metro:";
                            break;
                    }


                    tvResultado.setText(frase);
                    suffixTextCantidad(calculo);

                    if (calculo.getUnidad() == UtilService.TIPO_PAPEL_HIGIENICO) {
                        tilMetro.setVisibility(View.VISIBLE);
                    } else {
                        tilMetro.setVisibility(View.GONE);
                    }
                }).setPositiveButton("Aceptar", null);

                dialog = builder.create();
                dialog.show();
            });

            tiCantidad.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setCantidad(UtilService.parseStringToDouble(text));
                tvResultadoValor.setText(calculo.calcular());

                suffixTextCantidad(calculo);
            }));

            tiPrecio.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setPrecio(UtilService.parseStringToDouble(text));
                tvResultadoValor.setText(calculo.calcular());
            }));

            tiMetro.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setMetro(UtilService.parseStringToInteger(text));
                tvResultadoValor.setText(calculo.calcular());
            }));
        }


        public void suffixTextCantidad(Calculo calculo) {
            String suffixText = "";
            switch (calculo.getUnidad()) {
                case UtilService.TIPO_KILO:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "kilo";
                    } else {
                        suffixText = "kilos";
                    }
                    break;
                case UtilService.TIPO_GRAMOS:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "gramo";
                    } else {
                        suffixText = "gramos";
                    }
                    break;
                case UtilService.TIPO_UNIDAD:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "unidad";
                    } else {
                        suffixText = "unidades";
                    }
                    break;
                case UtilService.TIPO_LITRO:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "litro";
                    } else {
                        suffixText = "litros";
                    }
                    break;
                case UtilService.TIPO_PAPEL_HIGIENICO:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "rollo";
                    } else {
                        suffixText = "rollos";
                    }
                    break;
            }

            tilCantidad.setSuffixText(suffixText);
        }

        public List<Calculo> getLista() {
            return lista;
        }

        public void setLista(List<Calculo> lista2) {
            lista = lista2;
        }
    }
}
