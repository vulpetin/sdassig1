package gui;

import controller.DestinationController;
import controller.VacationController;
import model.Destination;
import model.Vacation;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainWindow {
    private JPanel panel1;
    private JTable table1;
    private JButton addDestinationButton;
    private JScrollPane scrollPane;
    private JButton addVacationButton;
    private JTabbedPane tabbedPane1;
    private JTable table2;
    private JButton deleteVacationButton;
    private JButton deleteDestinationButton;
    private JButton editVacationButton;

    public JPanel getPanel1() {
        return panel1;
    }
    public MainWindow(){}


    List<Destination> destinations;
    List<Vacation> vacations;



    public void refreshData(){
        DestinationController destinationController = new DestinationController();
        VacationController vacationController = new VacationController();
        destinations = destinationController.getAll();
        vacations = vacationController.getAll();
        if(table1!= null)
        table1.repaint();
        if(table2!=null)
        table2.repaint();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here


        refreshData();

        String[] destinationColumnNames = { "Id", "Name" };










        class DestinationTableModel extends AbstractTableModel{

            //private String[] columnNames;
            //private ArrayList<Destination> destinations;


            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }


            public Destination getRowData(int i){
                return destinations.get(i);
            }

            @Override
            public String getColumnName(int i){
                return destinationColumnNames[i];
            }

            @Override
            public int getRowCount() {
                return destinations.size();
            }

            @Override
            public int getColumnCount() {
                return destinationColumnNames.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(columnIndex == 0)
                    return destinations.get(rowIndex).getId();
                if (columnIndex > 0)
                    return destinations.get(rowIndex).getLocation();
                return null;
            }
        }


        String[] vacationColumnNames = {"Id", "Name", "Start", "End", "Availability", "Price", "Destination", "Details"};
        class VacationTableModel extends AbstractTableModel{

            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }

            @Override
            public String getColumnName(int i){
                return vacationColumnNames[i];
            }

            @Override
            public int getRowCount() {
                return vacations.size();
            }

            @Override
            public int getColumnCount() {
                return vacationColumnNames.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(columnIndex == 0)
                    return vacations.get(rowIndex).getId();
                if (columnIndex == 1)
                    return vacations.get(rowIndex).getName();
                if (columnIndex == 2)
                    return vacations.get(rowIndex).getPeriodStart().toString();
                if (columnIndex == 3)
                    return vacations.get(rowIndex).getPeriodEnd().toString();
                if (columnIndex == 4)
                    return vacations.get(rowIndex).getNrAvailable();
                if (columnIndex == 5)
                    return vacations.get(rowIndex).getPrice();
                if (columnIndex == 6)
                    return vacations.get(rowIndex).getDestination().getLocation();
                if (columnIndex == 7)
                    return vacations.get(rowIndex).getDetails();

                return null;
            }
        }



        table1 = new JTable(new DestinationTableModel());
        table1.setRowSelectionAllowed(true);
        ListSelectionModel selectionModel = table1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        });



        table2 = new JTable((new VacationTableModel()));
        table2.setRowSelectionAllowed(true);
        ListSelectionModel selectionModel2 = table2.getSelectionModel();
        selectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });



        addDestinationButton = new JButton();
        addDestinationButton.setEnabled(true);
        addDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateDestination createDestination = new CreateDestination();
                createDestination.pack();
                createDestination.setVisible(true);
                refreshData();
            }
        });

        addVacationButton = new JButton();
        addVacationButton.setEnabled(true);
        addVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table1.getSelectionModel().getLeadSelectionIndex();
                if(i>=0) {
                    String id = (String) table1.getValueAt(i, 0);
                    DestinationController destinationController1 = new DestinationController();
                    Destination destination = destinationController1.getById(id);
                    CreateVacation dialog = new CreateVacation(destination);
                    dialog.pack();
                    dialog.setVisible(true);


                }
                refreshData();
            }
        });

        deleteVacationButton = new JButton();
        deleteVacationButton.setEnabled(true);
        deleteVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table2.getSelectionModel().getLeadSelectionIndex();
                if(i>=0) {
                    String id = (String) table2.getValueAt(i, 0);
                    VacationController controller = new VacationController();
                    controller.deleteById(id);
                    //System.out.println(i+"  press " + id);

                }
                refreshData();
            }
        });

        deleteDestinationButton = new JButton();
        deleteDestinationButton.setEnabled(true);
        deleteDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table1.getSelectionModel().getLeadSelectionIndex();
                if(i>=0) {
                    String id = (String) table1.getValueAt(i, 0);
                    DestinationController destinationController = new DestinationController();
                    destinationController.deleteById(id);
                    //Destination destination = destinationController.getById(id);



                }
                refreshData();
            }
        });

        editVacationButton = new JButton();
        editVacationButton.setEnabled(true);
        editVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table2.getSelectionModel().getLeadSelectionIndex();
                if(i>=0) {
                    String id = (String) table2.getValueAt(i, 0);
                    VacationController controller = new VacationController();
                    Vacation vacation = controller.getById(id);
                    CreateVacation dialog = new CreateVacation(vacation);
                    dialog.pack();
                    dialog.setVisible(true);

                    //controller.editVacation(vacation);
                    //System.out.println(i+"  press " + id);

                }
                refreshData();
            }
        });

    }


}
