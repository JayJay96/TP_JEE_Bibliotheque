/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.*;

/**
 *
 * @author Epulapp
 */
public class Connexion {

    public Connection connecter() throws Exception {
        Context initCtx, envCtx;
        DataSource ds;
        Connection connection;
        try {
            initCtx = new InitialContext();
            envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/OeuvresJDBC");
            connection = (Connection) ds.getConnection();
            return (connection);
        } catch (Exception e) {
            throw e;
        }
    }
}
