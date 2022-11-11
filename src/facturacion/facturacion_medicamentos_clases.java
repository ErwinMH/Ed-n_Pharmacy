/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import conexion.MyConnection;
import static facturacion.frm_facturacion_medicamentos.txt_apellidosclientemedic;
import static facturacion.frm_facturacion_medicamentos.txt_cantidadmedic;
import static facturacion.frm_facturacion_medicamentos.txt_fechafacturamedic;
import static facturacion.frm_facturacion_medicamentos.txt_idclientemedic;
import static facturacion.frm_facturacion_medicamentos.txt_montototalfacturamedic;
import static facturacion.frm_facturacion_medicamentos.txt_nofacturamedic;
import static facturacion.frm_facturacion_medicamentos.txt_nombreclientemedic;
import static facturacion.frm_facturacion_medicamentos.txt_nombreempleadomedic;
import static facturacion.frm_facturacion_medicamentos.txt_preciomedic;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin Martinez
 */
public class facturacion_medicamentos_clases {
    
     public static void suma (){ //realiza la suma para el total
        int a=0;
       int  b=0;

        for (int i=0; i<frm_facturacion_medicamentos.tbl_factura_medicamentos.getRowCount(); i++){
            a= Integer.parseInt(frm_facturacion_medicamentos.tbl_factura_medicamentos.getValueAt(i,2).toString());
            
          b+=a;
        }
        
   frm_facturacion_medicamentos.txt_montototalfacturamedic.setText(""+  b);
    }
        

         public static void monto(){ //realiza el monto.
   
        int mon,prec,canti;
   prec=Integer.parseInt(txt_preciomedic.getText());
      canti=Integer.parseInt(txt_cantidadmedic.getText());
   mon=prec*canti;
  frm_facturacion_medicamentos.txt_montomedic.setText(String.valueOf(mon));
   
}
    public static void guardar (){ //guarda datos en la tabla factura.
      String detall = txt_nofacturamedic.getText();
      String nomEm= txt_nombreempleadomedic.getText(); 
      String codclie= txt_idclientemedic.getText();
      String nomclie= txt_nombreclientemedic.getText();
      String apel= txt_apellidosclientemedic.getText();
      String total= txt_montototalfacturamedic.getText();
      String fecha= txt_fechafacturamedic.getText();
      
 
        //Declaración de consulta
        PreparedStatement ps;
        
        //Creación de sentencia SQL para insertar los datos en la base de datos
        String query = "INSERT INTO `factura_medicamento`(`no_detallefactura`,`nom_emp`,`ID_cliente`,`nom_cliente`,`apellidos_cliente`,`monto_total`,`fecha_venta`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
       ps.setString(1, detall);
       ps.setString(2, nomEm);
       ps.setString(3, codclie);
       ps.setString(4, nomclie);
       ps.setString(5, apel);
       ps.setString(6, total);
       ps.setString(7, fecha);
 
         //Condicional IF que confirma la inserción de los datos
         if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Factura guardada");
                
            }
            
//        
        //Mensaje de error 
        } catch (SQLException ex) {
            Logger.getLogger(formularios_de_control_y_acceso.frm_control_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }

         
         
    }    
    
}
