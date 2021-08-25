package fr.greta60.planeteappgreta60.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Planete extends RealmObject {
    //créattion d'entité
    @PrimaryKey
    private int id;
    @Required
    private String nom;
//    @Required
    private int distance;
//    @Required
    private int idImage;

    //constructeur
    public Planete() {
        this.nom = nom;
        this.distance = distance;
        this.idImage = idImage;
    }

    public Planete(String nom, int distance, int idImage) {
        this.nom = nom;
        this.distance = distance;
        this.idImage = idImage;
    }

    //Getter et Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    //Méthode stringify
    @Override
    public String toString() {
        return getNom();
    }

    public long getId() {
        return id;
    }

    public void setId(int nextId) {
        this.id = id;
    }
}