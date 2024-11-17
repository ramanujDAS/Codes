class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 0) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int count = entry.getValue();
            while (count-- > 0)
                sb.append(entry.getKey());
        }

        return sb.toString();

    }

    class CharFreq {
        char letter;
        int freq;

        public CharFreq(char letter, int freq) {
            this.letter = letter;
            this.freq = freq;
        }
    }
}