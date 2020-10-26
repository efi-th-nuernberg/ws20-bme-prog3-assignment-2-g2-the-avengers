class TextFormatter {

    int lineLength;

    private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
        "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
        "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
        "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
        "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
        "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est. " +
        "Lorem ipsum dolor sit amet.";

    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter(40);
        formatter.print(text);
    } //Konstruktor

    public TextFormatter(int maxLineLength) {
        lineLength = maxLineLength;
    }

    public void print(String aText) {

      static int LIMIT_BACK = 7;
      
        int lineLengthCounter = 0;
        while (true) {
            if (lineLengthCounter < aText.length()) {
                for (int lastSpaceChar = 0; lastSpaceChar < LIMIT_BACK; lastSpaceChar++) {
                    if ((lineLengthCounter == lineLength - lastSpaceChar) && (aText.charAt(lineLength - lastSpaceChar) == ' ')) {
                        if (aText.charAt(0) == ' ') {
                            System.out.println(aText.substring(1, lineLengthCounter));
                        } else {
                            System.out.println(aText.substring(0, lineLengthCounter));
                        }
                        aText = aText.substring(lineLengthCounter, aText.length());
                        lineLengthCounter = 0;
                    }
                }
                lineLengthCounter++;
            } else {
                break;
            }
        }
        System.out.println(aText.substring(1, aText.length()));
    }
}