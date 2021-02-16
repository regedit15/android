package martin.cuantocuesta.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import martin.cuantocuesta.Adapters.CalculoAdapter;
import martin.cuantocuesta.Models.Calculo;
import martin.cuantocuesta.R;
import martin.cuantocuesta.Services.UtilServiceLocal;

public class CalculoFragment extends Fragment {


    private ListView recyclerView;
    private CalculoAdapter audioAdapter;
//    private RecyclerView.LayoutManager layoutManagerCalculos;
    private List<Calculo> calculos = UtilServiceLocal.getCalculos();

    public CalculoFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculo, container, false);


        recyclerView = view.findViewById(R.id.rvListadoCalculos);
        //        recyclerView.setHasFixedSize(true);
        //        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        layoutManagerCalculos = new LinearLayoutManager(getContext());
        //        recyclerView.setLayoutManager(layoutManagerCalculos);

        //        audioAdapter = new CalculoAdapter(calculos, R.layout.item_calculo);
        audioAdapter = new CalculoAdapter(getContext(), R.layout.item_calculo, calculos);


        recyclerView.setAdapter(audioAdapter);
        return view;
    }


    //----------- Option Menu (Tres puntitos)
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.action_bar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean resultado;

        switch (item.getItemId()) {
            case R.id.item_agregar:
                audioAdapter.agregarItem();
                resultado = true;
                break;
            case R.id.item_limpiar:
                audioAdapter.limpiar();
                resultado = true;
                break;
            default:
                resultado = super.onOptionsItemSelected(item);
                break;
        }
        return resultado;
    }
    //-------------------------------------------------


}
