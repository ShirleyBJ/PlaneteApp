package fr.greta60.planeteappgreta60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.greta60.planeteappgreta60.adapter.PlaneteAdapter;
import fr.greta60.planeteappgreta60.model.Planete;

public class MainActivity extends AppCompatActivity {

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

        //créer arrayAdapter
        /**
         * 1er arg: this qui correspond à notre activ
         * 2eme arg est notre layout
         * 3eme arg est l'id
         * 4eme arg : notre site
         * */
        //layout prédéfinis
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1,list);
        //layout personnalisée -> item1.xml
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item1, R.id.planete_nom,list);

        //créer PlaneteAdapter
        PlaneteAdapter adapter= new PlaneteAdapter(this,list);

        //associer adaptateur a listView
        ListView lv = findViewById(android.R.id.list);
        //on associe à la liste l'adaptateur
        lv.setAdapter(adapter);
    }
}
