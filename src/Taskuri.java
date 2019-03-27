import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Taskuri {

    private static List<MonitoredData> monitoredDataList;

    public Taskuri() throws IOException {
        task0();
    }

    public List<MonitoredData> read() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("Activities.txt"));
        return stream.map(s -> {
            String[] strings = s.split("		");
            MonitoredData m = new MonitoredData(strings[0], strings[1], strings[2]);
            return m;
        }).collect(Collectors.toList());
    }

    public void task0() throws IOException {
        monitoredDataList = read();
        //monitoredDataList.forEach(System.out::println);
    }


    public long task1() {

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        return monitoredDataList.stream().map(mp -> {
            String dataOra = formatter2.format(mp.getStart_time());
            String[] dataTimp = dataOra.split(" ");
            String data = new String(dataTimp[0]);
            return data;
        }).distinct().count();
    }


    public Map<String, Integer> task2() {

        Map<String, Long> stringLongMap = monitoredDataList.stream().map(mp -> mp.getActivity_label())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return stringLongMap.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> Integer.parseInt(String.valueOf(e.getValue()))));
    }


    public Map<Integer, Map<String, Integer>> task3() {

        Map<Integer, Map<String, Long>> stringLongMap = monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getDay,
                Collectors.groupingBy(MonitoredData::getActivity_label, Collectors.counting())));

        Map<Integer, Map<String, Integer>> stringIntegerMap = stringLongMap.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue().entrySet().stream().collect(Collectors.toMap(m -> m.getKey(), m -> Integer.parseInt(String.valueOf(m.getValue()))))
        ));
        return stringIntegerMap;
    }

    public Map<String, Long> task4() {

        return monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getActivity_label, Collectors.summingLong(MonitoredData::getTime)))
                .entrySet().stream().filter(s -> s.getValue() >= 36000).collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
    }

    public String toTime(long x) {

        if (x < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }
        long zile = TimeUnit.SECONDS.toDays(x);
        x -= TimeUnit.DAYS.toSeconds(zile);
        long ore = TimeUnit.SECONDS.toHours(x);
        x -= TimeUnit.HOURS.toSeconds(ore);
        long minute = TimeUnit.SECONDS.toMinutes(x);
        x -= TimeUnit.MINUTES.toSeconds(minute);
        long secunde = TimeUnit.SECONDS.toSeconds(x);

        StringBuilder sb = new StringBuilder(64);
        if (zile != 0) {
            sb.append(zile);
            if (zile != 1)
                sb.append(" Zile  ");
            else
                sb.append(" Zi   ");
        }
        if (ore >= 10) {
            sb.append(ore);
        } else {
            sb.append("0");
            sb.append(ore);
        }
        sb.append(":");
        if (minute >= 10) {
            sb.append(minute);
        } else {
            sb.append("0");
            sb.append(minute);
        }
        sb.append(":");
        if (secunde >= 10) {
            sb.append(secunde);
        } else {
            sb.append("0");
            sb.append(secunde);
        }
        /*
        sb.append(zile);
        if (zile != 1)
            sb.append(" Zile  ");
        else
            sb.append(" Zi   ");
        sb.append(ore);
        sb.append(":");
        sb.append(minute);
        sb.append(":");
        sb.append(secunde);*/
        return (sb.toString());
    }


    public List<String> task5() {

        Map<String, Long> stringLongMap = monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getActivity_label, Collectors.counting()));
        Map<String, Long> stringLongMapfilter = monitoredDataList.stream().filter(s -> s.getTime() < 300).collect(Collectors.groupingBy(MonitoredData::getActivity_label, Collectors.counting()));

        List<String> list = new ArrayList<>();
        monitoredDataList.stream().forEach(s -> {
            if (stringLongMapfilter.containsKey(s.getActivity_label())) {
                if ((stringLongMapfilter.get(s.getActivity_label()) / stringLongMap.get(s.getActivity_label())) >= 0.9)
                    list.add(s.getActivity_label());
            }
        });
        List<String> listFinal = list.stream().distinct().collect(Collectors.toList());
        return listFinal;
    }

    public List<Long> task6() {

        return monitoredDataList.stream().map(MonitoredData::getTime).collect(Collectors.toList());
    }

    public Map<String, Long> task7() {

        return monitoredDataList.stream().collect(Collectors.groupingBy(MonitoredData::getActivity_label, Collectors.summingLong(MonitoredData::getTime)))
                .entrySet().stream().collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
    }

}
