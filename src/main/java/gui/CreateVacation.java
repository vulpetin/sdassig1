package gui;

import controller.VacationController;
import model.Destination;
import model.Vacation;

import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateVacation extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldDetails;
    private JTextField textFieldName;
    private JTextField textFieldStart;
    private JTextField textFieldEnd;
    private JTextField textFieldPrice;
    private JTextField textFieldAvailability;
    Destination destination;
    Vacation vacation;

    public CreateVacation(Destination destination) {
        this.destination = destination;
        commonconstructor();
    }

    private void commonconstructor(){
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    public CreateVacation(Vacation vacation){
        this.vacation = vacation;
        this.destination = vacation.getDestination();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textFieldDetails.setText(vacation.getDetails());
        textFieldName.setText(vacation.getName());
        textFieldStart.setText(dateFormat.format(vacation.getPeriodStart()));
        textFieldEnd.setText(dateFormat.format(vacation.getPeriodEnd()));
        textFieldPrice.setText(vacation.getPrice().toString());
        textFieldAvailability.setText(vacation.getNrAvailable().toString());

        commonconstructor();
    }


    private void onOK() {
        VacationController controller = new VacationController();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (this.vacation == null)
            {
            Vacation result = new Vacation(
                    textFieldName.getText(),
                    textFieldDetails.getText(),
                    Float.parseFloat(textFieldPrice.getText()),
                    Integer.parseInt(textFieldAvailability.getText()),
                    dateFormat.parse(textFieldStart.getText()),
                    dateFormat.parse(textFieldEnd.getText()),
                    destination
            );
                controller.addVacation(result);}
            else
            {
                Vacation result = new Vacation(
                        vacation.getId(),
                        textFieldName.getText(),
                        textFieldDetails.getText(),
                        Float.parseFloat(textFieldPrice.getText()),
                        Integer.parseInt(textFieldAvailability.getText()),
                        dateFormat.parse(textFieldStart.getText()),
                        dateFormat.parse(textFieldEnd.getText()),
                        destination
                );
                controller.editVacation(result);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
