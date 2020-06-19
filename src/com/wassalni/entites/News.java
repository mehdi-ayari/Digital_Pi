/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

public class News {

  int id_news;
  String titre;
  String desc;
  String image;
  

  public News(){}
  
    public News(String titre, String desc, String image) {
       // this.id_news = id_news;
        this.titre = titre;
        this.desc = desc;
     
        this.image = image;
    }

    public News(int id_news, String titre, String desc, String image) {
        this.id_news = id_news;
        this.titre = titre;
        this.desc = desc;
        this.image = image;
    }
    

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
    @Override
    public String toString() {
        return "News{" + "id_news=" + id_news + ", titre=" + titre + ", desc=" + desc + ", image=" + image + '}';
    }
  
}

  