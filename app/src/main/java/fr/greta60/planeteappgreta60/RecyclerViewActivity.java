package fr.greta60.planeteappgreta60;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.greta60.planeteappgreta60.adapter.PlaneteAdapter;
import fr.greta60.planeteappgreta60.adapter.RecyclerPlaneteAdapter;
import fr.greta60.planeteappgreta60.model.Planete;

public class RecyclerViewActivity extends AppCompatActivity {
    public static final String TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Resources resources = getResources();
        String[] nomsTab = resources.getStringArray(R.array.noms); //type et nom du tab dans arrays.xml
        int[] distancesTab = resources.getIntArray(R.array.distances); //type et nom du tab dans arrays.xml

        //créer un tableau des ressources images
        int[] idImages = new int[]{
                R.drawable.mercury,
                R.drawable.venus,
                R.drawable.earth,
                R.drawable.mars,
                R.drawable.jupiter,
                R.drawable.saturn,
                R.drawable.uranus,
                R.drawable.neptune,
                R.drawable.pluto
        };
        //créer la liste des planètes
        ArrayList<Planete> list = new ArrayList<>(); //créer une liste vide qui contient objet type planete
        //avec boucle for, on ajoute les elements dans cette liste ->exécution du code 9 fois car 9 planete
        for (int i = 0; i < nomsTab.length ; i++){
            Planete p = new Planete(nomsTab[i], distancesTab[i], idImages[i]);
            list.add(p);
        }

        RecyclerPlaneteAdapter adapter =
                new RecyclerPlaneteAdapter(list);
        //associer adaptateur à ListView
        RecyclerView rv = (RecyclerView)findViewById(R.id.list);
        //Disposition des elements ...
        //créer gestionnaire de layout
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //... basé sur grille
//        GridLayoutManager llm = new GridLayoutManager(this,2);
        rv.setLayoutManager(llm);//gestionnaire de mise en forme
        rv.setHasFixedSize(true);
        //séparateur
        DividerItemDecoration did = new DividerItemDecoration(rv.getContext(), llm.getOrientation());
        rv.addItemDecoration(did);
        adapter.setMenuListener(this);
        rv.setAdapter(adapter);
    }

   //affichage du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * création du menu
     * @param menu
     * @return true
     * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); //retourne id de l'item sélectionné
        switch (itemId) {
            case R.id.menu_creer:
                //afficher le formulaire de création de planete
                Log.d(TAG, "dans menu_creer");
                Toast.makeText(this,"dans menu_creer",Toast.LENGTH_LONG).show();
                //créer un Intent explicite

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // recupere id de l'item qui vient d'être activé
        switch (itemId){
            case R.id.menu_modifier:
                //afficher le formulaire de modification de planete
                Log.d(TAG, "dans menu_modifier");
                Toast.makeText(this,"dans menu_modifier",Toast.LENGTH_LONG).show();
                return false;
            case R.id.menu_supprimer:
                //demander la confirmation avant de supprimer
                Log.d(TAG, "dans menu_supprimer");
                Toast.makeText(this,"dans menu_supprimer",Toast.LENGTH_LONG).show();
                return false;
            default:
                return super.onContextItemSelected(item);
        }
    }
}