
package co.unicauca.subscriber.processProducts.presentation;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mfcaicedo
 */
public class CellRenderer extends DefaultTableCellRenderer{
    /**
     * Constructor 
     */
    public String estado;
    public CellRenderer(String estado){
        this.estado = estado;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //reseteo el background  
        Color gray = new Color(200 , 200, 200);
        setBackground(gray);
        //COnstructor de la clase DefaultTableCellRenderer
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //Creamos un color para las filas.
        Color green = new Color(93, 204, 86);
        Color orange = new Color(230, 70, 23);
        if (table.getValueAt(row,column).equals("Optimo")) {
            setBackground(green);
        }else if(table.getValueAt(row,column).equals("Defectuoso")){
            setBackground(orange);
        }
        return this;
    }

}
