class Solution {
	private int[] answer;
	private int count = 0;
	private int currentNum = 1;
	private int currentIndex = 0;

	public int[] solution(int n) {
		int size = n * (n + 1) / 2;
		answer = new int[size];

		mod1(n, 0);

		return answer;
	}

	private void mod1(int n, int depth) {
		for (int i = 0; i < n - count; i++) {
			currentIndex += depth;
			answer[currentIndex] = currentNum;
			currentNum++;
			depth++;
		}
		count++;
		if (count >= n) return;
		mod2(n, depth - 1);
	}

	private void mod2(int n, int depth) {
		for (int i = 0; i < n - count; i++) {
			currentIndex += 1;
			answer[currentIndex] = currentNum;
			currentNum++;
		}
		count++;
		if (count >= n) return;
		mod3(n, depth);
	}

	private void mod3(int n, int depth) {
		for (int i = 0; i < n - count; i++) {
			currentIndex -= (depth + 1);
			answer[currentIndex] = currentNum;
			currentNum++;
			depth--;
		}
		count++;
		if (count >= n) return;
		mod1(n, depth + 1);
	}
}
