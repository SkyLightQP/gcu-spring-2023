public class Homework_3_2 {
    public static void main(String[] args) {
        double[][] picture = {
            {1.2, 1.3, 4.5, 6.2, 2.7},
            {1.7, 3.3, 4.4, 10.5, 17.0},
            {1.1, 4.5, 2.1, 25.3, 9.2},
            {1.0, 9.5, 8.3, 2.9, 2.1}
        };

        System.out.println("Original picture:");
        for (double[] row : picture) {
            for (double i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("Picture with threshold:");
        double[][] result = findFigure(picture, 1.4);
        for (double[] row : result) {
            for (double i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static double[][] findFigure(double[][] picture, double threshold) {
        double sum = 0.0;
        for (double[] row : picture) {
            for (double i : row) {
                sum += i;
            }
        }
        double avg = sum / (picture.length * picture[0].length);

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] < avg * threshold) picture[i][j] = 0.0;
                else picture[i][j] = 1.0;
            }
        }

        return picture;
    }
}
