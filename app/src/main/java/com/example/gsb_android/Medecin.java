package com.example.gsb_android;

public class Medecin {
    private String mNom, mPrenom, mAdresse, mTel, mSpecialite;
    private int mId;

    public Medecin( String nom,String prenom,String adresse, String tel,String specialite) {
        mNom = nom;
        mPrenom = prenom;
        mAdresse = adresse;
        mTel = tel;
        mSpecialite = specialite;
    }
    public Medecin() {
    }


    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public String getmPrenom() {
        return mPrenom;
    }

    public void setmPrenom(String mPrenom) {
        this.mPrenom = mPrenom;
    }

    public void setmAdresse(String mAdresse) {
        this.mAdresse = mAdresse;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public void setmSpecialite(String mSpecialite) {
        this.mSpecialite = mSpecialite;
    }

    public String getmNom() {
        return mNom;
    }

    public String getmAdresse() {
        return mAdresse;
    }

    public String getmTel() {
        return mTel;
    }

    public String getmSpecialite() {
        return mSpecialite;
    }
}