package fr.greta60.planeteappgreta60.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.greta60.planeteappgreta60.model.Planete;
import fr.greta60.planeteappgreta60.view.RecyclerPlaneteView;

/**
 *  classe de type RecyclerView.adapter<RecyclerViewPlaneteView>
 *  class Adapter = abstract classe -> méthode abstraite doivent être implémenter
* */
public class RecyclerPlaneteAdapter extends RecyclerView.Adapter<RecyclerPlaneteView> {
    //variable pour stocker la liste des planetes
    private List<Planete> list;
    //constructeur pour initialiser la liste des planetes => list
    public RecyclerPlaneteAdapter(@NonNull List<Planete> planetes){
        super();
        list = planetes;
    }

    @NonNull
    @Override
    public RecyclerPlaneteView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPlaneteView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
