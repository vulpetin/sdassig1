import gui.MainWindow;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class Main {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    private static void runGUI(){
        JFrame frame = new JFrame("Travel Agency");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  JLabel label = new JLabel("Hello World");
        MainWindow mainWindow = new MainWindow();
        frame.getContentPane().add(mainWindow.getPanel1());

        //Display the window.
        frame.pack();

        frame.setVisible(true);
        mainWindow.getPanel1().setVisible(true);
    }

    public static void main(String[] args) {
//        User user = new User("2", "asdss", "ghj","poiuuyddddddt");
//        UserController userController = new UserController();
//        //userController.addUser(user);
//       // DateFormat dateFormat = new DateFormat();
//
//        //DateFormat.getDateInstance().parse("13-03-2022")
//        VacationRepository vacationRepository = new VacationRepository();
//        DestinationRepository destinationRepository = new DestinationRepository();
//
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//        Calendar cal = Calendar.getInstance();
//
//        Destination destination = new Destination("1", "Cluj");
//        try {
//            Date startDate = dateFormat.parse("10/03/2022");
//            Date endDate = dateFormat.parse("16/03/2022");
//
//            Vacation vacation = new Vacation(
//                    "1",
//                    "Cluj Vacation",
//                    "A vacation in Cluj",
//                    150F,
//                    20,
//                    startDate,
//                    endDate,
//                    destination
//
//            );
//
//            destinationRepository.addDestination(destination);
//            vacationRepository.addVacation(vacation);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        User user2 = userController.getByUsername("poiuuyddddddt");
//        System.out.println(user2.toString());


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });

    }
}
