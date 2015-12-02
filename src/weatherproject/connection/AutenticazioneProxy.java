/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherproject.connection;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author Paolo
 */
public class AutenticazioneProxy {
    private String username;
    private String password;

    AutenticazioneProxy() {
    }

    public String getNome() {
        return username;
    }

    public void setNome(String nome) {
        this.username = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AutenticazioneProxy(final String username, final String password) {
        this.username = username;
        this.password = password;
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "192.168.0.1");
        System.setProperty("http.proxyPort", "8080");
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username,password.toCharArray());
            }
        });
    }
    private static class ProxyAuthenticator extends Authenticator {

        public ProxyAuthenticator(String userName, String password) 
        {
        this.userName = userName;
        this.password = password;
        }



        private String userName, password;

        protected PasswordAuthentication getPasswordAuthentication() 
        {
            return new PasswordAuthentication(userName, password.toCharArray());
        }
    }
}
