package martin.cuantocuesta.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

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

public class CalculoAdapter extends BaseAdapter {

    private Context context;
    private List<Calculo> lista;
    private int layout;
    private int contador = 1;
    private ViewHolder viewHolder;

    //    public CalculoAdapter(List<Calculo> lista, int layout) {
    //        this.lista = lista;
    //        this.layout = layout;
    //    }
    public CalculoAdapter(Context context, int layout, List<Calculo> lista) {
        this.context = context;
        this.layout = layout;
        this.lista = lista;
    }

    // devuelve la cantidad de items que va a tener el adaptados
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Calculo getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    // position : posicion
    // convertView: es como si fuera un item en la lista de Views
    // parent: vendria a ser la lista entera, osea, un grupo de views
    //
    // En este metodo tenemos que tomar el view que llega por parametro, personalizarlo y devolverlo
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout, null);

            viewHolder = new ViewHolder();

            //            viewHolder.tituloFruta = convertView.findViewById(R.id.tituloFruta);
            //            viewHolder.descripcionFruta = convertView.findViewById(R.id.descripcionFruta);
            //            viewHolder.imagenFruta = convertView.findViewById(R.id.imagenFruta);

            viewHolder.btTipo = convertView.findViewById(R.id.btTipo);
            viewHolder.btTipoDescuento = convertView.findViewById(R.id.btTipoDescuento);
            viewHolder.tiCantidad = convertView.findViewById(R.id.tiCantidad);
            viewHolder.tilCantidad = convertView.findViewById(R.id.tilCantidad);
            viewHolder.tilPorcentaje = convertView.findViewById(R.id.tilPorcentaje);
            viewHolder.tiNombre = convertView.findViewById(R.id.tiNombre);
            viewHolder.tiPrecio = convertView.findViewById(R.id.tiPrecio);
            viewHolder.tiPorcentaje = convertView.findViewById(R.id.tiPorcentaje);
            viewHolder.tvPrecioPorUnidadTitulo = convertView.findViewById(R.id.tvPrecioPorUnidadTitulo);
            viewHolder.tvPrecioPorUnidadResultado = convertView.findViewById(R.id.tvPrecioPorUnidadResultado);
            viewHolder.tvPrecioPorProductoTitulo = convertView.findViewById(R.id.tvPrecioPorProductoTitulo);
            viewHolder.tvPrecioPorProductoResultado = convertView.findViewById(R.id.tvPrecioPorProductoResultado);
            viewHolder.tiMetro = convertView.findViewById(R.id.tiMetro);
            viewHolder.tilMetro = convertView.findViewById(R.id.tilMetro);
            viewHolder.cbDescuento = convertView.findViewById(R.id.cbDescuento);
            viewHolder.clDescuento = convertView.findViewById(R.id.clDescuento);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //        viewHolder.tituloFruta.setText(getItem(position).getNombre());
        //        viewHolder.descripcionFruta.setText(getItem(position).getDescripcion());
        //        viewHolder.imagenFruta.setImageResource(getItem(position).getImagen());

        viewHolder.tvPrecioPorUnidadResultado.setText("");
        viewHolder.tilMetro.setVisibility(View.GONE);
        viewHolder.clDescuento.setVisibility(View.GONE);
        viewHolder.tvPrecioPorProductoTitulo.setVisibility(View.GONE);
        viewHolder.tvPrecioPorProductoResultado.setVisibility(View.GONE);
        viewHolder.tilPorcentaje.setVisibility(View.GONE);
        viewHolder.tiPrecio.setFilters(UtilInputFilter.getInputFilterDosDecimales());
        viewHolder.tiPorcentaje.setFilters(UtilInputFilter.getInputFilterPorcentajeSinCero());


        viewHolder.btTipo.setOnClickListener(view -> {
            Dialog dialog;

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Tipo: ");

            String[] unidades = UtilServiceLocal.getTipos();

            AtomicInteger indexInidad = new AtomicInteger();

            builder.setSingleChoiceItems(unidades, Arrays.asList(unidades).indexOf(getItem(position).getUnidad()), (dialog1, index) -> {
                indexInidad.set(index);
            }).setPositiveButton("Aceptar", (dialog1, index) -> {
                viewHolder.btTipo.setText(unidades[indexInidad.get()]);
                getItem(position).setUnidad(unidades[indexInidad.get()]);


                String frase = "Precio por ";

                // Nota: no se por que aca no pudimos hacer que el tiCantidad.setInputType y el tiPrecio.setFilters fueran puestos en una variable y seteados despues del switch.
                // Ese InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL es como que cambia si lo guardo en una variable, no es lo mismo y hace que no admita decimales sino
                switch (getItem(position).getUnidad()) {
                    case UtilServiceLocal.TIPO_KILO:
                    case UtilServiceLocal.TIPO_GRAMOS:
                        frase += "kilo:";
                        viewHolder.tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                        viewHolder.tiPrecio.setFilters(new InputFilter[0]);
                        break;
                    case UtilServiceLocal.TIPO_UNIDAD:
                        frase += "unidad:";
                        viewHolder.tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                        viewHolder.tiPrecio.setFilters(new InputFilter[0]);
                        break;
                    case UtilServiceLocal.TIPO_LITRO:
                        frase += "litro:";
                        viewHolder.tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        viewHolder.tiCantidad.setFilters(UtilInputFilter.getInputFilterDosDecimales());
                        break;
                    case UtilServiceLocal.TIPO_PAPEL_HIGIENICO:
                        frase += "metro:";
                        viewHolder.tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
                        viewHolder.tiPrecio.setFilters(new InputFilter[0]);
                        break;
                }

                viewHolder.tvPrecioPorUnidadTitulo.setText(frase);
                suffixTextCantidad(getItem(position));
                viewHolder.tilMetro.setVisibility(getItem(position).getUnidad() == UtilServiceLocal.TIPO_PAPEL_HIGIENICO ? View.VISIBLE : View.GONE);
                calcularCampos(getItem(position));
            });

            dialog = builder.create();
            dialog.show();
        });


        AtomicInteger indexTipoDescuento = new AtomicInteger();

        viewHolder.btTipoDescuento.setOnClickListener(view -> {
            Dialog dialog;

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tipo de descuento: ");


            String[] tiposDescuentos = UtilServiceLocal.getDescuentosTraducidos(context);


            int posicionDefaultItem = UtilServiceLocal.descuentos.indexOf(getItem(position).getTipoDescuento());

            builder.setSingleChoiceItems(tiposDescuentos, posicionDefaultItem, (dialog1, index) -> {
                indexTipoDescuento.set(index);
            }).setPositiveButton("Aceptar", (dialog1, index) -> {

                viewHolder.ultimoDescuento = UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get());

                viewHolder.btTipoDescuento.setText(tiposDescuentos[indexTipoDescuento.get()]);
                getItem(position).setTipoDescuento(UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get()));


                viewHolder.tilPorcentaje.setVisibility(getItem(position).getTipoDescuento() == UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD ? View.VISIBLE : View.GONE);

                calcularCampos(getItem(position));
            });

            dialog = builder.create();
            dialog.show();
        });

        viewHolder.tiCantidad.addTextChangedListener(UtilService.getTextWatcher(text -> {
            getItem(position).setCantidad(UtilService.parseStringToDouble(text));
            calcularCampos(getItem(position));

            suffixTextCantidad(getItem(position));
        }));

        viewHolder.tiPrecio.addTextChangedListener(UtilService.getTextWatcher(text -> {
            getItem(position).setPrecio(UtilService.parseStringToDouble(text));
            calcularCampos(getItem(position));
        }));

        viewHolder.tiMetro.addTextChangedListener(UtilService.getTextWatcher(text -> {
            getItem(position).setMetro(UtilService.parseStringToInteger(text));
            calcularCampos(getItem(position));
        }));

        viewHolder.tiPorcentaje.addTextChangedListener(UtilService.getTextWatcher(text -> {
            getItem(position).setPorcentajeDescuentoCustom(UtilService.parseStringToInteger(text));
            calcularCampos(getItem(position));
        }));


        viewHolder.cbDescuento.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewHolder.clDescuento.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            viewHolder.tvPrecioPorProductoTitulo.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            viewHolder.tvPrecioPorProductoResultado.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            getItem(position).setTipoDescuento(isChecked ? viewHolder.ultimoDescuento : null);
            calcularCampos(getItem(position));
        });

        return convertView;
    }

    static class ViewHolder {
        private TextInputEditText tiCantidad;
        private TextInputEditText tiMetro;
        private TextInputLayout tilCantidad;
        private TextInputLayout tilMetro;
        private TextInputLayout tilPorcentaje;
        private TextInputEditText tiPrecio;
        private TextInputEditText tiPorcentaje;
        private TextInputEditText tiNombre;
        private Button btTipo;
        private Button btTipoDescuento;
        private TextView tvPrecioPorUnidadTitulo;
        private TextView tvPrecioPorUnidadResultado;
        private TextView tvPrecioPorProductoTitulo;
        private TextView tvPrecioPorProductoResultado;
        private CheckBox cbDescuento;
        private ConstraintLayout clDescuento;
        private String ultimoDescuento = UtilServiceLocal.DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD;
    }


    //    @Override
    //    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    //        context = parent.getContext();
    //
    //        ViewHolder viewHolder = new ViewHolder(view);
    //        // Eso es porque sino no refrezca bien el 1er item. Si yo escribo un nombre, una cantidad, etc.
    //        // Despues le doy a agregar a otro item y despues le doy limpiar tod0. Si me saca el segundo
    //        // item pero el primero queda igual que como estaba, porque lo recicla. COn esto si lo refrezca bien
    //        //                        viewHolder.setIsRecyclable(false);
    //        return viewHolder;
    //    }
    //
    //    @Override
    //    public void onBindViewHolder(ViewHolder holder, int position) {
    //        holder.bind(lista.get(position));
    //    }
    //
    //    @Override
    //    public int getItemCount() {
    //        return lista.size();
    //    }

    public void agregarItem() {
        //        lista.add(new Calculo("nombre" + contador));
        lista.add(new Calculo());
        //        notifyItemRangeInserted(lista.size() - 1, 1);
        notifyDataSetChanged();
    }

    public void limpiar() {
        int oldSize = lista.size();
        lista.clear();
        //        notifyItemRangeRemoved(0, oldSize);

        lista.add(new Calculo());
        int newSize = lista.size();
        notifyDataSetChanged();
        //        notifyItemRangeInserted(0, newSize);
    }

    //    public class ViewHolder extends RecyclerView.ViewHolder {
    //
    //        private TextInputEditText tiCantidad;
    //        private TextInputEditText tiMetro;
    //        private TextInputLayout tilCantidad;
    //        private TextInputLayout tilMetro;
    //        private TextInputLayout tilPorcentaje;
    //        private TextInputEditText tiPrecio;
    //        private TextInputEditText tiPorcentaje;
    //        private TextInputEditText tiNombre;
    //        private Button btTipo;
    //        private Button btTipoDescuento;
    //        private TextView tvPrecioPorUnidadTitulo;
    //        private TextView tvPrecioPorUnidadResultado;
    //        private TextView tvPrecioPorProductoTitulo;
    //        private TextView tvPrecioPorProductoResultado;
    //        private CheckBox cbDescuento;
    //        private ConstraintLayout clDescuento;
    //
    //        private String ultimoDescuento = UtilServiceLocal.DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD;
    //
    //        public ViewHolder(View itemView) {
    //            super(itemView);
    //            btTipo = itemView.findViewById(R.id.btTipo);
    //            btTipoDescuento = itemView.findViewById(R.id.btTipoDescuento);
    //            tiCantidad = itemView.findViewById(R.id.tiCantidad);
    //            tilCantidad = itemView.findViewById(R.id.tilCantidad);
    //            tilPorcentaje = itemView.findViewById(R.id.tilPorcentaje);
    //            tiNombre = itemView.findViewById(R.id.tiNombre);
    //            tiPrecio = itemView.findViewById(R.id.tiPrecio);
    //            tiPorcentaje = itemView.findViewById(R.id.tiPorcentaje);
    //            tvPrecioPorUnidadTitulo = itemView.findViewById(R.id.tvPrecioPorUnidadTitulo);
    //            tvPrecioPorUnidadResultado = itemView.findViewById(R.id.tvPrecioPorUnidadResultado);
    //            tvPrecioPorProductoTitulo = itemView.findViewById(R.id.tvPrecioPorProductoTitulo);
    //            tvPrecioPorProductoResultado = itemView.findViewById(R.id.tvPrecioPorProductoResultado);
    //            tiMetro = itemView.findViewById(R.id.tiMetro);
    //            tilMetro = itemView.findViewById(R.id.tilMetro);
    //            cbDescuento = itemView.findViewById(R.id.cbDescuento);
    //            clDescuento = itemView.findViewById(R.id.clDescuento);
    //
    //            tvPrecioPorUnidadResultado.setText("");
    //            tilMetro.setVisibility(View.GONE);
    //            clDescuento.setVisibility(View.GONE);
    //            tvPrecioPorProductoTitulo.setVisibility(View.GONE);
    //            tvPrecioPorProductoResultado.setVisibility(View.GONE);
    //            tilPorcentaje.setVisibility(View.GONE);
    //            tiPrecio.setFilters(UtilInputFilter.getInputFilterDosDecimales());
    //            tiPorcentaje.setFilters(UtilInputFilter.getInputFilterPorcentajeSinCero());
    //        }
    //
    //        public void bind(final Calculo calculo) {
    //
    //
    //            tiNombre.setText(calculo.getNombre());
    //            tiPrecio.setText(calculo.getPrecio() == null ? "" : calculo.getPrecio().toString());
    //            tiCantidad.setText(calculo.getCantidad() == null ? "" : calculo.getCantidad().toString());
    //            tiMetro.setText(calculo.getMetro() == null ? "" : calculo.getMetro().toString());
    //            btTipo.setText(calculo.getUnidad());
    //            cbDescuento.setChecked(false);
    //            btTipoDescuento.setText(UtilService.getStringResourceByName(context, calculo.getTipoDescuento()));
    //
    //
    //            btTipo.setOnClickListener(view -> {
    //                Dialog dialog;
    //
    //                AlertDialog.Builder builder = new AlertDialog.Builder(context);
    //                builder.setTitle("Tipo: ");
    //
    //                String[] unidades = UtilServiceLocal.getTipos();
    //
    //                AtomicInteger indexInidad = new AtomicInteger();
    //
    //                builder.setSingleChoiceItems(unidades, Arrays.asList(unidades).indexOf(calculo.getUnidad()), (dialog1, index) -> {
    //                    indexInidad.set(index);
    //                }).setPositiveButton("Aceptar", (dialog1, index) -> {
    //                    btTipo.setText(unidades[indexInidad.get()]);
    //                    calculo.setUnidad(unidades[indexInidad.get()]);
    //
    //
    //                    String frase = "Precio por ";
    //
    //                    // Nota: no se por que aca no pudimos hacer que el tiCantidad.setInputType y el tiPrecio.setFilters fueran puestos en una variable y seteados despues del switch.
    //                    // Ese InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL es como que cambia si lo guardo en una variable, no es lo mismo y hace que no admita decimales sino
    //                    switch (calculo.getUnidad()) {
    //                        case UtilServiceLocal.TIPO_KILO:
    //                        case UtilServiceLocal.TIPO_GRAMOS:
    //                            frase += "kilo:";
    //                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
    //                            tiPrecio.setFilters(new InputFilter[0]);
    //                            break;
    //                        case UtilServiceLocal.TIPO_UNIDAD:
    //                            frase += "unidad:";
    //                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
    //                            tiPrecio.setFilters(new InputFilter[0]);
    //                            break;
    //                        case UtilServiceLocal.TIPO_LITRO:
    //                            frase += "litro:";
    //                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    //                            tiCantidad.setFilters(UtilInputFilter.getInputFilterDosDecimales());
    //                            break;
    //                        case UtilServiceLocal.TIPO_PAPEL_HIGIENICO:
    //                            frase += "metro:";
    //                            tiCantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
    //                            tiPrecio.setFilters(new InputFilter[0]);
    //                            break;
    //                    }
    //
    //                    tvPrecioPorUnidadTitulo.setText(frase);
    //                    suffixTextCantidad(calculo);
    //                    tilMetro.setVisibility(calculo.getUnidad() == UtilServiceLocal.TIPO_PAPEL_HIGIENICO ? View.VISIBLE : View.GONE);
    //                    calcularCampos(calculo);
    //                });
    //
    //                dialog = builder.create();
    //                dialog.show();
    //            });
    //
    //
    //            AtomicInteger indexTipoDescuento = new AtomicInteger();
    //
    //            btTipoDescuento.setOnClickListener(view -> {
    //                Dialog dialog;
    //
    //                AlertDialog.Builder builder = new AlertDialog.Builder(context);
    //                builder.setTitle("Tipo de descuento: ");
    //
    //
    //                String[] tiposDescuentos = UtilServiceLocal.getDescuentosTraducidos(context);
    //
    //
    //                int posicionDefaultItem = UtilServiceLocal.descuentos.indexOf(calculo.getTipoDescuento());
    //
    //                builder.setSingleChoiceItems(tiposDescuentos, posicionDefaultItem, (dialog1, index) -> {
    //                    indexTipoDescuento.set(index);
    //                }).setPositiveButton("Aceptar", (dialog1, index) -> {
    //
    //                    ultimoDescuento = UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get());
    //
    //                    btTipoDescuento.setText(tiposDescuentos[indexTipoDescuento.get()]);
    //                    calculo.setTipoDescuento(UtilServiceLocal.getTipoDeDescuentoValor(indexTipoDescuento.get()));
    //
    //
    //                    tilPorcentaje.setVisibility(calculo.getTipoDescuento() == UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD ? View.VISIBLE : View.GONE);
    //
    //                    calcularCampos(calculo);
    //                });
    //
    //                dialog = builder.create();
    //                dialog.show();
    //            });
    //
    //            tiCantidad.addTextChangedListener(UtilService.getTextWatcher(text -> {
    //                calculo.setCantidad(UtilService.parseStringToDouble(text));
    //                calcularCampos(calculo);
    //
    //                suffixTextCantidad(calculo);
    //            }));
    //
    //            tiPrecio.addTextChangedListener(UtilService.getTextWatcher(text -> {
    //                calculo.setPrecio(UtilService.parseStringToDouble(text));
    //                calcularCampos(calculo);
    //            }));
    //
    //            tiMetro.addTextChangedListener(UtilService.getTextWatcher(text -> {
    //                calculo.setMetro(UtilService.parseStringToInteger(text));
    //                calcularCampos(calculo);
    //            }));
    //
    //            tiPorcentaje.addTextChangedListener(UtilService.getTextWatcher(text -> {
    //                calculo.setPorcentajeDescuentoCustom(UtilService.parseStringToInteger(text));
    //                calcularCampos(calculo);
    //            }));
    //
    //
    //            cbDescuento.setOnCheckedChangeListener((buttonView, isChecked) -> {
    //                clDescuento.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    //                tvPrecioPorProductoTitulo.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    //                tvPrecioPorProductoResultado.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    //                calculo.setTipoDescuento(isChecked ? ultimoDescuento : null);
    //                calcularCampos(calculo);
    //            });
    //        }


    private void calcularCampos(Calculo calculo) {
        viewHolder.tvPrecioPorUnidadResultado.setText(calculo.calcularPrecioPorUnidad());
        viewHolder.tvPrecioPorProductoResultado.setText(calculo.calcularPrecioPorProducto());
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

        viewHolder.tilCantidad.setSuffixText(suffixText);
    }

    //        public List<Calculo> getLista() {
    //            return lista;
    //        }
    //
    //        public void setLista(List<Calculo> lista2) {
    //            lista = lista2;
    //        }
    //}
}
