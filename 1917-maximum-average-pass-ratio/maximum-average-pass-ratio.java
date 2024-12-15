class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b[0], a[0]);
        });

        for (int[] currentClass : classes) {
            int passes = currentClass[0];
            int total = currentClass[1];
            double gain = gainByAddingOneStudent(passes, total);
            pq.add(new double[] {
                    gain,
                    passes,
                    total
            });
        }

        while (extraStudents-- > 0) {
            double[] currentClass = pq.poll();
            double currentGain = currentClass[0];
            int passes = (int) currentClass[1];
            int totalStudents = (int) currentClass[2];

            int newPasses = passes + 1;
            int newTotalStudents = totalStudents + 1;

            double newExpectedGainByAddingOne = gainByAddingOneStudent(newPasses, newTotalStudents);

            pq.add(
                    new double[] {
                            newExpectedGainByAddingOne,
                            newPasses,
                            newTotalStudents
                    });
        }

        double totalPassRation = 0;

        while (pq.size() > 0) {
            double[] currentClass = pq.poll();

            double passStudents = currentClass[1];
            double totalStudents = currentClass[2];

            totalPassRation += passStudents / totalStudents;
        }

        return totalPassRation / classes.length;

    }

    private double gainByAddingOneStudent(int pass, int total) {
        return ((double) (pass + 1) / (total + 1) -
                (double) (pass)/ total);
    }
}