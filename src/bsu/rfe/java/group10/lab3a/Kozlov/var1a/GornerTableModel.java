package bsu.rfe.java.group10.lab3a.Kozlov.var1a;
import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }


    public int getRowCount() {
        return (int)(Math.ceil((to-from)/step))+1;
    }

    public Object getValueAt(int row, int col) {
        Double x = from + step*row;
        Double result = 0.0;
        int temp = 0;
        int i = 0;
        for (i = 0; i < coefficients.length; i++) {
            result = x*result+coefficients[i];
        }
        if (col==0)
            return x;
        else if (col==1)
            return result;
        else {
            double k = result;
            k = (int) k;
            k = Math.sqrt(k);
            int z = (int) k;
            if (k - z == 0) {
                return true;
            }
            return false;
        }

    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Целая часть является квадратом?";
        }
    }

    public Class<?> getColumnClass(int col) {
        if (col!=2)
            return Double.class;
        return Boolean.class;
    }
}




