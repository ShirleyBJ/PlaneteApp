package fr.greta60.planeteappgreta60.model;

public class Planete {
    private String nom;
    private int distance;
    private int idImage;

    //constructeur
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
}