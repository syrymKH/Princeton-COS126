import java.awt.Color;

public class ImageClassifier {

    // Creates a feature vector (1D array) from the given picture.
    public static double[] extractFeatures(Picture picture) {

        int height = picture.height();
        int width = picture.width();

        double[] vector = new double[height * width];

        int index = 0;
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {

                Color currentColor = picture.get(i, j);
                int getRed = currentColor.getRed();
                vector[index] = getRed;
                index++;
            }
        }
        return vector;
    }

    // See below.
    public static void main(String[] args) {

        // Picture image = new Picture(args[0]);
        // image.show();

        // Picture image = new Picture(args[0]);
        // StdOut.println(extractFeatures(image));

        // Training //
        In digitsTraining = new In(args[0]);

        int m = digitsTraining.readInt();
        int height = digitsTraining.readInt();
        int width = digitsTraining.readInt();
        // StdOut.println(m);
        // StdOut.println(height);
        // StdOut.println(width);
        MultiPerceptron classifier = new MultiPerceptron(m, height * width);

        while (!digitsTraining.isEmpty()) {
            String fileName = digitsTraining.readString();
            int label = digitsTraining.readInt();
            // StdOut.println(fileName);
            // StdOut.println(label);
            Picture imageTraining = new Picture(fileName);
            // imageTraining.show();
            classifier.trainMulti(extractFeatures(imageTraining), label);

        }
        // Testing //
        In digitsTesting = new In(args[1]);

        m = digitsTesting.readInt();
        height = digitsTesting.readInt();
        width = digitsTesting.readInt();
        // StdOut.println(m);
        // StdOut.println(height);
        // StdOut.println(width);

        int error = 0;
        int total = 0;
        while (!digitsTesting.isEmpty()) {
            String fileName = digitsTesting.readString();
            int label = digitsTesting.readInt();
            // StdOut.println(fileName);
            // StdOut.println(label);
            Picture imageTesting = new Picture(fileName);
            // imageTesting.show();
            int predict = classifier.predictMulti(extractFeatures(imageTesting));
            if (predict != label) {
                StdOut.println(fileName);
                error++;
            }
            total++;
        }
        double errorRate = (double) error / total;
        StdOut.println("Error rate = " + errorRate);
    }
}
