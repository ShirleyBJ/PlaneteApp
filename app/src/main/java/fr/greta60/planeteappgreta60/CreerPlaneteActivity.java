package fr.greta60.planeteappgreta60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreerPlaneteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_planete);
        //récupérer le bouton
        final View button = findViewById(R.id.planete_create_submit_btn);
        //ajouter un écouteur d'évenèment sur ce bouton
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //récupérer l'editText nom
                final EditText etNom = (EditText)findViewById(R.id.planete_name);
                //récupérer l'editText distance
                final EditText etDistance = (EditText)findViewById(R.id.planete_distance);
                String nomPlanete = etNom.getText().toString();
                String tempDistance = etDistance.getText().toString(); // var temporaire pour trasnfirmer le string en entier
                int distancePlanete = tempDistance.isEmpty() ? // vérifie si le champ est vide, on donne valeur 0
                        0 :
                        Integer.parseInt(etDistance.getText().toString());
                //validation des données
                boolean error = false;
                nomPlanete = nomPlanete.trim();// normalise les données (suppr. espaces av. et ap.)
                if(nomPlanete.isEmpty()){ //vérifie de champs vide, si oui-> change backgd et fontColor pour signalement
                    etNom.setBackgroundColor(Color.RED);
                    etNom.setTextColor(Color.WHITE);
                    error = true;
                }
                //validation à faire en utilisant RegEXP
                if(distancePlanete < 0){ //vérifie si distance inférieur à 0 , erreur-> return, pas d'envoie de données vers recyclerActivity
                    etDistance.setBackgroundColor(Color.RED);
                    etDistance.setTextColor(Color.WHITE);
                    error = true;
                }
                if(error) return;
                //récupérer l'objet Intent pour envoyer la réponse
                Intent intent = getIntent(); //récupere objet intent envoyer par RecyclerView
                intent.putExtra("nomPlanete", nomPlanete); // ajout des données avec putExtra
                intent.putExtra("distancePlanete", distancePlanete);
                //envoyer la réponse vers MainActivity
                setResult(RESULT_OK, intent); //envoie resultat
                finish(); //clos l'activity
            }
        });
    }
}