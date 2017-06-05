/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.iReport;

import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.util.Properties;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author VAAR
 */
public class IReport {
    
    public void iReport(){
        Connection connection = ConnectionFactory.getConnection();
        
        String src = Properties.getConfiguracaoValue(Properties.IREPORT);
        
        //String src = "src\\br\\com\\praticas\\iReport\\Relatorio.jasper";
        
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(src, null, connection);
        } catch (JRException ex) {
            Logger.getLogger(IReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperViewer jV = new JasperViewer(jp,false);
        
        jV.setVisible(true);
        
    }
    
}
