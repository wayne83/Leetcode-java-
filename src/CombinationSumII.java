import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		find(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	public void find(List<List<Integer>> list, List<Integer> cur,
			int[] candidates, int target, int start) {
		if (target > 0) {
			for (int i = start; i < candidates.length
					&& target >= candidates[i]; i++) {
				cur.add(candidates[i]);
				find(list, cur, candidates, target - candidates[i], i + 1);
				cur.remove(cur.size() - 1);
			}
		} else if (target == 0) {
			List<Integer> l = new ArrayList<Integer>(cur);
			list.add(l);
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < list.size() - 1; i++) {
				temp = list.get(i);
				if (temp.equals(l)) {
					list.remove(i);
				}
			}
		}
	}
}
