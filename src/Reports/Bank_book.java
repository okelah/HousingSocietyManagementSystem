/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RtrSuahantNadkar
 */
public class Bank_book {
    public Bank_book() {
        try {
            Connection con = Others.Database.connect();
            String jasperFile = Bank_book.class.getResource("/Resource/Bank_book.jasper").toString().substring(6);
            JasperPrint jp = JasperFillManager.fillReport(jasperFile, null, con);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setVisible(true);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Bank_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main (String op[]) {
        new Bank_book();
    }
}
