package fr.greta60.planeteappgreta60.adapter;

import android.media.metrics.PlaybackErrorEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.greta60.planeteappgreta60.R;
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

    /**
     * Méthode qui contient la vue
     * Ne peut pas retourner  null sinon ne compile pas le code
     * */
    @NonNull
    @Override
    public RecyclerPlaneteView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // objet qui permet d'expanser (transformer) une ressource(xml,png) en objet java
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        //création d'objet de type View (arg 1 : fichier XML, arg 2: parent( recyclerView))
        View view = li.inflate(R.layout.recycler_item, parent, false);
        return new RecyclerPlaneteView(view); //appel du constructeur de la classe pour creer objet de type RecyclerPlaneteView
    }

    //méthode qui ajoute les données -> associe vue et données
    @Override
    public void onBindViewHolder(@NonNull RecyclerPlaneteView holder, int position) {
        Planete p = list.get(position);
        holder.setItem(p);
        //same code in 1 line
        holder.setItem(list.get(position));
    }

    /**
     * Methode qui indique le nbr d'element contenu dans la liste
     * Compte nbr element de la variable list*/
    @Override
    public int getItemCount() {
        return list.size(); // methode size donne le nbr d'element de la liste
    }
}
