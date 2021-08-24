package fr.greta60.planeteappgreta60;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import fr.greta60.planeteappgreta60.adapter.PlaneteAdapter;
import fr.greta60.planeteappgreta60.adapter.RecyclerPlaneteAdapter;
import fr.greta60.planeteappgreta60.model.Planete;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //créer PlaneteAdapter
        RecyclerPlaneteAdapter adapter= new RecyclerPlaneteAdapter(list);
        //associer adapter à Recycler View
        RecyclerView rv = findViewById(R.id.list);
        rv.setAdapter(adapter);
    }
}