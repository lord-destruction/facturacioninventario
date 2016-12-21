/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class control_articulos {
    
    
    Sentencias_sql sensql;
   
    public control_articulos() {
        
        sensql = new Sentencias_sql();
    }

    
    /**
     *
     * @param Date
     */
    
    public boolean ingresar_articulo(String id, String descripcion, int precioventa, int preciocosto, String stock,int cantidad, String tipoart, String codprov, String fechaingreso)
    {               
        
            String datos[] = {id,descripcion,Integer.toString(precioventa),Integer.toString(preciocosto),stock,Integer.toString(cantidad),tipoart,codprov,fechaingreso};           
            return sensql.insertar(datos, "insert into articulo(id_articulo, descripcion, precio_venta,precio_costo, stock, cantidad, cod_tipo_articulo, cod_proveedor, fecha_ingreso) values(?,?,?,?,?,?,?,?,?)");
                                  
        
    }
    
    public Object[][] consulta_articulos(){
        String[] columnas={"id_articulo","descripcion","precio_venta","precio_costo","stock","descripcion_articulo","Nombre_comercial","fecha_ingreso"};
        Object[][] datos = sensql.GetTabla(columnas, "articulo", "select id_articulo,descripcion,articulo.precio_venta,precio_costo,stock,descripcion_articulo,Nombre_comercial,fecha_ingreso from articulo,proveedor,tipo_articulo where id_tipoarticulo=cod_tipo_articulo and No_documento=cod_proveedor;");
        return datos;
    }
    
}