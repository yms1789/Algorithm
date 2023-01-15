import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int currTest = Integer.parseInt(br.readLine());
			String[] numArr = br.readLine().split(" ");
			Arrays.sort(numArr);
			Map<String, Integer> map = new HashMap<String, Integer>();

			for (int j = 0; j < numArr.length; j++) {
				if (!map.containsKey(numArr[j])) {
					map.put(numArr[j], 0);
				} else {
					int curCount = map.get(numArr[j]);
					map.replace(numArr[j], curCount + 1);
				}
			}
			List<Integer> valueList = new ArrayList<>(map.values());
			valueList.sort(Integer::compareTo);
			Set<String> keys = map.entrySet().stream()
					.filter(ele -> Objects.equals(ele.getValue(), valueList.get(valueList.size() - 1)))
					.map(Map.Entry::getKey).collect(Collectors.toSet());
			System.out.println("#" + currTest + " " + Collections.max(keys));

		}

	}
}