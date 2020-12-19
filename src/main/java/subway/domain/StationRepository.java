package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findStationByName(String comparedName) {
        for (Station station : stations()) {
            if (station.isSameName(comparedName)) {
                return station;
            }
        }
        return null;
    }

    public static String makeString() {
        StringBuilder st = new StringBuilder();
        for (Station station : stations()) {
            st.append(station.getName());
        }
        return st.toString();
    }
}
