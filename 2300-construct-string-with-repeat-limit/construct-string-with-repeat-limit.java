class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }

        PriorityQueue<FreqAndChar> pq = new PriorityQueue<>(
                (a, b) -> Character.compare(b.ch, a.ch));

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int count = charArray[i];
            if (count == 0)
                continue;

            FreqAndChar freqAndChar = new FreqAndChar(ch, count);
            pq.add(freqAndChar);
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() > 0) {
            FreqAndChar fchar = pq.poll();
            char ch = fchar.ch;
            int count = fchar.count;

            int used = Math.min(count, repeatLimit);
            for (int i = 0; i < used; i++) {
                ans.append(ch);
            }

            fchar.count -= used;
            if (fchar.count > 0 && pq.size() > 0) {
                FreqAndChar nextFchar = pq.poll();
                char nextBigger = nextFchar.ch;
                ans.append(nextBigger);
                nextFchar.count--;
                if (nextFchar.count > 0) {
                    pq.add(nextFchar);
                }
              pq.add(fchar);  
            }
            
        }
       return ans.toString();
    }

    class FreqAndChar {
        public char ch;
        public int count;

        public FreqAndChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}