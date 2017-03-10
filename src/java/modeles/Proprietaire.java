package modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import outils.Connexion;

public class Proprietaire {

    private int id_proprietaire;
    private String nom_proprietaire;
    private String prenom_proprietaire;
    private String login;
    private String pwd;

    public Proprietaire() {
    }
    
    // <editor-fold desc="Propriétés">
    public int getId_proprietaire() {
        return id_proprietaire;
    }
    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }
    public String getNom_proprietaire() {
        return nom_proprietaire;
    }
    public void setNom_proprietaire(String nom_proprietaire) {
        this.nom_proprietaire = nom_proprietaire;
    }
    public String getPrenom_proprietaire() {
        return prenom_proprietaire;
    }
    public void setPrenom_proprietaire(String prenom_proprietaire) {
        this.prenom_proprietaire = prenom_proprietaire;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return this.login;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getPwd() {
        return this.pwd;
    }
    // </editor-fold> 
    public boolean checkLogin(String login, String pwd){
        boolean find = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            Connexion cnx = new Connexion();
            connection = cnx.connecter();
            ps = connection.prepareStatement("select * from proprietaire where login = ? and pwd = ?");
            ps.setString(1, login);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_proprietaire = rs.getInt("id_proprietaire");
                nom_proprietaire = rs.getString("nom_proprietaire");
                prenom_proprietaire = rs.getString("prenom_proprietaire");
                this.login = rs.getString("login");
                this.pwd = rs.getString("pwd");
                find = true;
            }
            return find;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
