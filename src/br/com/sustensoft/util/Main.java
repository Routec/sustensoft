package br.com.sustensoft.util;



import com.alee.laf.WebLookAndFeel;
import br.com.sustensoft.visao.LoginTela;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String args[]) {

        ///*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //WebLookAndFeel.install();

                LoginTela login = new LoginTela();
                login.setVisible(true);


            }
        });
         //*/
        
        //LoginTela login = new LoginTela();
        //login.setVisible(true);
        
    }

}
