package controller;

import model.bo.ProductType;
import service.ProductTypeService;
import view.TelaBusProductType;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBusProductType implements ActionListener {

    TelaBusProductType searchScreen;
    ProductTypeService service = new ProductTypeService();
    DefaultTableModel table;

    public ControllerBusProductType(TelaBusProductType searchScreen) {
        addListeners(searchScreen);
        this.table = (DefaultTableModel) this.searchScreen.getjTable1().getModel();
        fillData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchScreen.getjButtonCarregar()) {
            ControllerCadProductType.code =
                    (int) this.searchScreen.getjTable1().getValueAt(this.searchScreen.getjTable1().getSelectedRow(), 0);
            this.searchScreen.dispose();
        } else if (e.getSource() == this.searchScreen.getjButtonSair()) {
            this.searchScreen.dispose();
        }
    }

    public void addListeners(TelaBusProductType searchScreen) {
        this.searchScreen = searchScreen;
        searchScreen.getjButtonCarregar().addActionListener(this);
        searchScreen.getjButtonSair().addActionListener(this);
    }

    public void fillData() {
        for (ProductType model : this.service.buscar()) {
            this.table.addRow(new Object[]{
                    model.getId(),
                    model.getDescription(),
            });
        }
    }
}