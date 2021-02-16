package martin.cuantocuesta.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import martin.cuantocuesta.Models.Calculo;
import martin.cuantocuesta.R;
import martin.cuantocuesta.Services.UtilServiceLocal;
import martin.library.inputsFilters.UtilInputFilter;
import martin.library.services.UtilService;

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

        ViewHolder viewHolder = new ViewHolder(view);
        // Eso es porque sino no refrezca bien el 1er item. Si yo escribo un nombre, una cantidad, etc.
        // Despues le doy a agregar a otro item y despues le doy limpiar tod0. Si me saca el segundo
        // item pero el primero queda igual que como estaba, porque lo recicla. COn esto si lo refrezca bien
        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void agregarItem() {
        lista.add(new Calculo());
        //        notifyDataSetChanged();
        notifyItemInserted(lista.size() - 1);
    }

    public void limpiar() {
        //        int size = lista.size();
        lista.clear();
        //        notifyItemRangeRemoved(0, size - 1);
        lista.add(new Calculo());
        //        notifyItemInserted(0);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextInputEditText tiCantidad;
        private TextInputEditText tiMetro;
        private TextInputLayout tilCantidad;
        private TextInputLayout tilMetro;
        private TextInputLayout tilPorcentaje;
        private TextInputEditText tiPrecio;
        private TextInputEditText tiNombre;
        private TextInputEditText tiPorcentaje;
        private Button btTipo;
        private Button btTipoDescuento;
        private TextView tvPrecioPorUnidadTitulo;
        private TextView tvPrecioPorUnidadResultado;
        private TextView tvPrecioPorProductoTitulo;
        private TextView tvPrecioPorProductoResultado;
        private CheckBox cbDescuento;
        private ConstraintLayout clDescuento;

        private String ultimoDescuento = UtilServiceLocal.DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD;

        public ViewHolder(View itemView) {
            super(itemView);
            btTipo = itemView.findViewById(R.id.btTipo);
            btTipoDescuento = itemView.findViewById(R.id.btTipoDescuento);
            tiCantidad = itemView.findViewById(R.id.tiCantidad);
            tilCantidad = itemView.findViewById(R.id.tilCantidad);
            tilPorcentaje = itemView.findViewById(R.id.tilPorcentaje);
            tiPrecio = itemView.findViewById(R.id.tiPrecio);
            tiNombre = itemView.findViewById(R.id.tiNombre);
            tiPorcentaje = itemView.findViewById(R.id.tiPorcentaje);
            tvPrecioPorUnidadTitulo = itemView.findViewById(R.id.tvPrecioPorUnidadTitulo);
            tvPrecioPorUnidadResultado = itemView.findViewById(R.id.tvPrecioPorUnidadResultado);
            tvPrecioPorProductoTitulo = itemView.findViewById(R.id.tvPrecioPorProductoTitulo);
            tvPrecioPorProductoResultado = itemView.findViewById(R.id.tvPrecioPorProductoResultado);
            tiMetro = itemView.findViewById(R.id.tiMetro);
            tilMetro = itemView.findViewById(R.id.tilMetro);
            cbDescuento = itemView.findViewById(R.id.cbDescuento);
            clDescuento = itemView.findViewById(R.id.clDescuento);

            tvPrecioPorUnidadResultado.setText("");
            tilMetro.setVisibility(View.GONE);
            clDescuento.setVisibility(View.GONE);
            tvPrecioPorProductoTitulo.setVisibility(View.GONE);
            tvPrecioPorProductoResultado.setVisibility(View.GONE);
            tilPorcentaje.setVisibility(View.GONE);
            tiPrecio.setFilters(UtilInputFilter.getInputFilterDosDecimales());
            tiPorcentaje.setFilters(UtilInputFilter.getInputFilterPorcentajeSinCero());
        }

        public void bind(final Calculo calculo) {

            tiNombre.setText(calculo.getNombre() == null ? "" : calculo.getNombre());
            tiPrecio.setText(calculo.getPrecio() == null ? "" : calculo.getNombre());
            tiCantidad.setText(calculo.getCantidad() == null ? "" : calculo.getNombre());
            tiMetro.setText(calculo.getMetro() == null ? "" : calculo.getNombre());

            tiNombre.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setNombre(text);
            }));

            btTipo.setOnClickListener(view -> {
                Dialog dialog;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Tipo: ");

                String[] unidades = UtilServiceLocal.getTipos();

                AtomicInteger indexInidad = new AtomicInteger();

                builder.setSingleChoiceItems(unidades, Arrays.asList(unidades).indexOf(calculo.getUnidad()), (dialog1, index) -> {
                    indexInidad.set(index);
                }).setPositiveButton("Aceptar", (dialog1, index) -> {
                    btTipo.setText(unidades[indexInidad.get()]);
                    calculo.setUnidad(unidades[indexInidad.get()]);


                    String frase = "Precio por ";

                    // Nota: no se por que aca no pudimos hacer que el tiCantidad.setInputType y el tiPrecio.setFilters fueran puestos en una variable y seteados despues del switch.
                    // Ese InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL es como que cambia si lo guardo en una variable, no es lo mismo y hace que no admita decimales sino
                    switch (calculo.getUnidad()) {
                        case UtilServiceLocal.TIPO_KILO:
                        case UtilServiceLocal.TIPO_GRAMOS:
                            frase += "kilo:";
                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                            tiPrecio.setFilters(new InputFilter[0]);
                            break;
                        case UtilServiceLocal.TIPO_UNIDAD:
                            frase += "unidad:";
                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                            tiPrecio.setFilters(new InputFilter[0]);
                            break;
                        case UtilServiceLocal.TIPO_LITRO:
                            frase += "litro:";
                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                            tiCantidad.setFilters(UtilInputFilter.getInputFilterDosDecimales());
                            break;
                        case UtilServiceLocal.TIPO_PAPEL_HIGIENICO:
                            frase += "metro:";
                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                            tiPrecio.setFilters(new InputFilter[0]);
                            break;
                    }

                    tvPrecioPorUnidadTitulo.setText(frase);
                    suffixTextCantidad(calculo);
                    tilMetro.setVisibility(calculo.getUnidad() == UtilServiceLocal.TIPO_PAPEL_HIGIENICO ? View.VISIBLE : View.GONE);
                    calcularCampos(calculo);
                });

                dialog = builder.create();
                dialog.show();
            });


            AtomicInteger indexTipoDescuento = new AtomicInteger();

            btTipoDescuento.setOnClickListener(view -> {
                Dialog dialog;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Tipo de descuento: ");


                String[] tiposDescuentos = UtilServiceLocal.getDescuentosTraducidos(context);


                int posicionDefaultItem = UtilServiceLocal.descuentos.indexOf(calculo.getTipoDescuento());

                builder.setSingleChoiceItems(tiposDescuentos, posicionDefaultItem, (dialog1, index) -> {
                    indexTipoDescuento.set(index);
                }).setPositiveButton("Aceptar", (dialog1, index) -> {

                    ultimoDescuento = UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get());

                    btTipoDescuento.setText(tiposDescuentos[indexTipoDescuento.get()]);
                    calculo.setTipoDescuento(UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get()));


                    tilPorcentaje.setVisibility(calculo.getTipoDescuento() == UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD ? View.VISIBLE : View.GONE);

                    calcularCampos(calculo);
                });

                dialog = builder.create();
                dialog.show();
            });

            tiCantidad.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setCantidad(UtilService.parseStringToDouble(text));
                calcularCampos(calculo);

                suffixTextCantidad(calculo);
            }));

            tiPrecio.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setPrecio(UtilService.parseStringToDouble(text));
                calcularCampos(calculo);
            }));

            tiMetro.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setMetro(UtilService.parseStringToInteger(text));
                calcularCampos(calculo);
            }));

            tiPorcentaje.addTextChangedListener(UtilService.getTextWatcher(text -> {
                calculo.setPorcentajeDescuentoCustom(UtilService.parseStringToInteger(text));
                calcularCampos(calculo);
            }));


            cbDescuento.setOnCheckedChangeListener((buttonView, isChecked) -> {
                clDescuento.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                tvPrecioPorProductoTitulo.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                tvPrecioPorProductoResultado.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                calculo.setTipoDescuento(isChecked ? ultimoDescuento : null);
                calcularCampos(calculo);
            });
        }


        private void calcularCampos(Calculo calculo) {
            tvPrecioPorUnidadResultado.setText(calculo.calcularPrecioPorUnidad());
            tvPrecioPorProductoResultado.setText(calculo.calcularPrecioPorProducto());
        }

        private void suffixTextCantidad(Calculo calculo) {
            String suffixText = "";
            switch (calculo.getUnidad()) {
                case UtilServiceLocal.TIPO_KILO:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "kilo";
                    } else {
                        suffixText = "kilos";
                    }
                    break;
                case UtilServiceLocal.TIPO_GRAMOS:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "gramo";
                    } else {
                        suffixText = "gramos";
                    }
                    break;
                case UtilServiceLocal.TIPO_UNIDAD:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "unidad";
                    } else {
                        suffixText = "unidades";
                    }
                    break;
                case UtilServiceLocal.TIPO_LITRO:
                    if (calculo.getCantidad() == 1) {
                        suffixText = "litro";
                    } else {
                        suffixText = "litros";
                    }
                    break;
                case UtilServiceLocal.TIPO_PAPEL_HIGIENICO:
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
