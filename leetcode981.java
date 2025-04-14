import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode981 {
    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */

    class TimeMap {
        Map<String, List<Data>> map;

        private class Data {
            int timestamp;
            String value;

            Data(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Data(timestamp, value));
        }

        public String get(String key, int timestamp) {
            String answer = "";
            if (map.containsKey(key)) {
                int start = 0;
                List<Data> list = map.get(key);
                int end = list.size() - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int time = list.get(mid).timestamp;
                    if (time > timestamp) {
                        end = mid - 1;
                    } else if (time < timestamp) {
                        answer = list.get(start).value;
                        start = mid + 1;
                    } else {
                        return list.get(mid).value;
                    }
                }
            }

            return answer;
        }
    }
}
