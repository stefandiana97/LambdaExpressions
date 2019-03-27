import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

public class ActionL {

    private GUI gui;
    private Taskuri task;

    public ActionL() {
        gui = new GUI();
        gui.task0(new Task0());
        gui.task1(new Task1());
        gui.task2(new Task2());
        gui.task3(new Task3());
        gui.task4(new Task4());
        gui.task5(new Task5());

        gui.task6(new Task6());
        gui.task7(new Task7());
        try {
            task = new Taskuri();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Task0 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                task.task0();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            long number = task.task1();
            System.out.println("Count the distinct days that appear in the monitoring data:");
            System.out.println(number + "\n");
        }
    }

    class Task2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Map<String, Integer> stringIntegerMap2 = task.task2();
                String text2 = new String("Determine a map of type <String, Integer> that maps to each distinct action type\n" +
                        "the number of occurrences in the log:\n\n");
                Files.write(Paths.get("Task2.txt"), text2.getBytes());
                Files.write(Paths.get("Task2.txt"), () -> stringIntegerMap2.entrySet().stream()
                        .<CharSequence>map(s -> s.getKey() + "  " + s.getValue()).iterator(), StandardOpenOption.APPEND);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Map<Integer, Map<String, Integer>> stringIntegerMap3 = task.task3();
                String text3 = new String("Generates a data structure of type Map<Integer, Map<String, Integer>> that\n" +
                        "contains the activity count for each day of the log (task number 2 applied for each\n" +
                        "day of the log): \n\n");
                Files.write(Paths.get("Task3.txt"), text3.getBytes());
                Files.write(Paths.get("Task3.txt"), () -> stringIntegerMap3.entrySet().stream()
                        .<CharSequence>map(s -> s.getKey() + " =  " + s.getValue()).iterator(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Map<String, Long> stringMap4 = task.task4();
                String text4 = new String("Determine a data structure of the form Map that maps\n" +
                        "for each activity the total duration computed over the monitoring period. Filter the\n" +
                        "activities with total duration larger than 10 hours: \n\n");
                Files.write(Paths.get("Task4.txt"), text4.getBytes());
                Files.write(Paths.get("Task4.txt"), () -> stringMap4.entrySet().stream()
                        .<CharSequence>map(s -> s.getKey() + " =  " + task.toTime(s.getValue())).iterator(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<String> string5 = task.task5();
                String text5 = new String("Filter the activities that have 90% of the monitoring samples with duration\n" +
                        "less than 5 minutes, collect the results in a List<String> containing only the\n" +
                        "distinct activity names: \n\n");
                Files.write(Paths.get("Task5.txt"), text5.getBytes());
                Files.write(Paths.get("Task5.txt"), () -> string5.stream()
                        .<CharSequence>map(s -> s).iterator(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Long> stringMap6 = task.task6();
                String text6 = new String("For each line from the file map for the activity label the duration recorded on that line\n" +
                        "(end_time-start_time)\n\n");
                Files.write(Paths.get("Task6.txt"), text6.getBytes());
                Files.write(Paths.get("Task6.txt"), () -> stringMap6.stream()
                        .<CharSequence>map(s -> task.toTime(s)).iterator(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    class Task7 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Map<String, Long> stringMap7 = task.task7();
                String text7 = new String("For each activity compute the entire duration over the monitoring period.\n\n ");
                Files.write(Paths.get("Task7.txt"), text7.getBytes());
                Files.write(Paths.get("Task7.txt"), () -> stringMap7.entrySet().stream()
                        .<CharSequence>map(s -> s.getKey() + " =  " + task.toTime(s.getValue())).iterator(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
