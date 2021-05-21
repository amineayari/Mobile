/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author khalil
 */

public class serie {
 int id;
 String title,episode,saison,date,nomrealisateur,categorie,image,video;

 
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
    
    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNomrealisateur() {
        return nomrealisateur;
    }

    public void setNomrealisateur(String nomrealisateur) {
        this.nomrealisateur = nomrealisateur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


    public serie() {
    }
    
    
    public serie(String title,String saison,String episode,String date,String nomrealisateur,String categorie,String image,String video){
     
     
     this.title=title;
     this.saison=saison;
     this.episode=episode;
     this.date=date;
     this.nomrealisateur=nomrealisateur;
     this.categorie=categorie;
     this.image=image;
     this.video=video;
    }
     
    
    public serie(int id,String title,String saison,String episode,String date,String nomrealisateur,String categorie,String image,String video){
     
     this.id=id;
     this.title=title;
     this.saison=saison;
     this.episode=episode;
     this.date=date;
     this.nomrealisateur=nomrealisateur;
     this.categorie=categorie;
     this.image=image;
     this.video=video;
    }
    
   
    
}
