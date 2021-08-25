package fr.greta60.planeteappgreta60.adapter;

import android.graphics.Color;
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
    //pour stocker la position d'élément cliqué
    private int clickedPosition = RecyclerView.NO_POSITION;
    //écouteur pour crée le menu contextuel
    private View.OnCreateContextMenuListener menuListener;
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
    public void onBindViewHolder(@NonNull RecyclerPlaneteView holder,final int position) {
        Planete p = list.get(position);
        holder.setItem(p);
        /**
         * SAME CODE IN 1 LINE :
         * holder.setItem(list.get(position));
         * */
        //ajouter un écouteur d'évènement sur chaque élément de la liste
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedPosition(position);
            }
        });
        //holder.itemView.setOnClickListener((view)->setClickedPosition(position));//expression Lambda
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                setClickedPosition(position);
                return false;
            }
        });
        //verifie que element cliqué est celui afficher si c'est le cas backgd est gris autrement il n'y en a pas
        holder.itemView.setBackgroundColor(getClickedPosition() == position ? Color.LTGRAY : Color.TRANSPARENT);
        //ajoute un menu contextuel sur chaque element de la liste
        holder.itemView.setOnCreateContextMenuListener(menuListener);
    }

    /**
     * Methode qui indique le nbr d'element contenu dans la liste
     * Compte nbr element de la variable list*/
    @Override
    public int getItemCount() {
        return list.size(); // methode size donne le nbr d'element de la liste
    }

    public int getClickedPosition() {
        return clickedPosition;
    }

    public void setClickedPosition(int clickedPosition) {
        notifyItemChanged(this.clickedPosition);
        this.clickedPosition = clickedPosition;
        notifyItemChanged(clickedPosition);
    }

    public View.OnCreateContextMenuListener getMenuListener() {
        return menuListener;
    }

    public void setMenuListener(View.OnCreateContextMenuListener menuListener) {
        this.menuListener = menuListener;
    }

    public void addPlanete(Planete planete) {
        list.add(planete);
        //envoie de notification d'ajout de la position de l'élèment qui vient d'être ajouté
        notifyItemInserted(list.size()-1); //nbr d'element de liste - celui qui vient d'être ajouté (-1)
    }

    public void removePlanete(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged(); //liste qui contient les données -> notifie que cette liste a subi des modifications
    }
}
