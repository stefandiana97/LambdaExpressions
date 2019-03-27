import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame = new JFrame("Tema5");

    private JPanel panel = new JPanel();
    private JPanel task1 = new JPanel();
    private JPanel task2 = new JPanel();
    private JPanel task3 = new JPanel();
    private JPanel task4 = new JPanel();
    private JPanel task5 = new JPanel();
    private JPanel task0 = new JPanel();
    private JPanel task6 = new JPanel();
    private JPanel task7 = new JPanel();

    private JTextArea task5L = new JTextArea("Filter the activities that have 90% of the monitoring samples with duration\n" +
            "less than 5 minutes, collect the results in a List<String> containing only the\n" +
            "distinct activity names and write the result in a text file.\n");
    private JTextArea task4L = new JTextArea("Determine a data structure of the form Map<String, DateTime> that maps\n" +
            "for each activity the total duration computed over the monitoring period. Filter the\n" +
            "activities with total duration larger than 10 hours. Write the result in a text file.");
    private JTextArea task3L = new JTextArea("Generates a data structure of type Map<Integer, Map<String, Integer>> that\n" +
            "contains the activity count for each day of the log (task number 2 applied for each\n" +
            "day of the log)and writes the result in a text file.\n");
    private JTextArea task2L = new JTextArea("Determine a map of type <String, Integer> that maps to each distinct action type\n" +
            "the number of occurrences in the log. Write the resulting map into a text file.");
    private JTextArea task1L = new JTextArea("Count the distinct days that appear in the monitoring data.");
    private JTextArea task0L = new JTextArea("Define a class MonitoredData with 3 fields: start time, end time and activity as\n" +
            "string. Read the data from the file Activity.txt using streams and create a list of\n" +
            "objects of type MonitoredData.");
    private JTextArea task6L = new JTextArea("For each line from the file map for the activity label the duration recorded on that line\n" +
            "(end_time-start_time)\n");
    private JTextArea task7L = new JTextArea("For each activity compute the entire duration over the monitoring period ");

    private JButton task1B = new JButton("Task1");
    private JButton task2B = new JButton("Task2");
    private JButton task3B = new JButton("Task3");
    private JButton task4B = new JButton("Task4");
    private JButton task5B = new JButton("Task5");
    private JButton task0B = new JButton("Task0");
    private JButton task6B = new JButton("Task6");
    private JButton task7B = new JButton("Task7");

    public GUI() {
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        //panel.setLayout(new BorderLayout());

        task0L.setPreferredSize(new Dimension(500, 50));
        task0L.setEditable(false);
        task0.add(task0L);
        task0.add(task0B);
        panel.add(task0);

        task1L.setPreferredSize(new Dimension(500, 50));
        task1L.setEditable(false);
        task1.add(task1L);
        task1.add(task1B);
        panel.add(task1);

        task2L.setPreferredSize(new Dimension(500, 50));
        task2L.setEditable(false);
        task2.add(task2L);
        task2.add(task2B);
        panel.add(task2);

        task3L.setPreferredSize(new Dimension(500, 50));
        task3L.setEditable(false);
        task3.add(task3L);
        task3.add(task3B);
        panel.add(task3);

        task4L.setPreferredSize(new Dimension(500, 50));
        task4L.setEditable(false);
        task4.add(task4L);
        task4.add(task4B);
        panel.add(task4);

        task5L.setPreferredSize(new Dimension(500, 50));
        task5L.setEditable(false);
        task5.add(task5L);
        task5.add(task5B);
        panel.add(task5);

        task6L.setPreferredSize(new Dimension(500, 50));
        task6L.setEditable(false);
        task6.add(task6L);
        task6.add(task6B);
        panel.add(task6);

        task7L.setPreferredSize(new Dimension(500, 50));
        task7L.setEditable(false);
        task7.add(task7L);
        task7.add(task7B);
        panel.add(task7);

        frame.add(panel);
        frame.revalidate();;
        frame.repaint();
    }

    public void task0(ActionListener a) {
        task0B.addActionListener(a);
    }

    public void task1(ActionListener a) {
        task1B.addActionListener(a);
    }


    public void task2(ActionListener a) {
        task2B.addActionListener(a);
    }

    public void task3(ActionListener a) {
        task3B.addActionListener(a);
    }

    public void task4(ActionListener a) {
        task4B.addActionListener(a);
    }

    public void task5(ActionListener a) {
        task5B.addActionListener(a);
    }

    public void task6(ActionListener a) {
        task6B.addActionListener(a);
    }

    public void task7(ActionListener a) {
        task7B.addActionListener(a);
    }

}

