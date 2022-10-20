package com.example.navigationcomponentobjeto.Fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationcomponentobjeto.Persona;
import com.example.navigationcomponentobjeto.R;

public class FinalFragment extends Fragment {

    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        TextView text1 = view.findViewById(R.id.tvNombre);
        TextView text2 = view.findViewById(R.id.tvApellidos);
        TextView text3 = view.findViewById(R.id.tvTelefono);
        Button boton =view.findViewById(R.id.botonFinal);

        //Obtenemos los argumentos si no son nulos.
        if (getArguments()!= null){
            //Los obtenemos vía Bundle.
            Persona registro = getArguments().getParcelable("persona");

            text1.setText("El nombre es: "+ registro.getNombre());
            text2.setText("Los apellidos son: "+ registro.getApellidos());
            text3.setText("El teléfono es: "+ registro.getTelefono());
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_finalFragment_to_inicioFragment);
            }
        });
    }
}