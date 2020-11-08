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
        System.out.println("");
        System.out.println("Linksbündig:");
        System.out.println("");
        formatter.print(text,0);
        System.out.println("");
        System.out.println("Rechtsbündig:");
        System.out.println("");
        formatter.print(text,1);
        // ENTER 0 for left formatted, 1 for right formatted
    } 

    public TextFormatter(int maxLineLength) {
        lineLength = maxLineLength;
    }

    public String addSpaces(int maxSpaces){
      String spaces = "";
      for (int i = 0; i< maxSpaces; i++){
          spaces += " ";
      }
      return spaces;
    }
    public void print(String aText,int format) {
      final int LIMIT_BACK = 14;
        int lineLengthCounter = 0;
        while (true) {
            if (lineLengthCounter < aText.length()) {
                for (int lastSpaceChar = 0; lastSpaceChar < LIMIT_BACK; lastSpaceChar++) {
                    if ((lineLengthCounter == lineLength - lastSpaceChar) && (aText.charAt(lineLength - lastSpaceChar) == ' ')) {
                        if (aText.charAt(0) == ' ') {
                            System.out.println(addSpaces(lastSpaceChar*format)+ aText.substring(1, lineLengthCounter));
                        } else {
                            System.out.println(addSpaces(lastSpaceChar*format)+aText.substring(0, lineLengthCounter));
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
        System.out.println(addSpaces((lineLength-aText.length())*format)+aText.substring(1, aText.length()));
    }
    
}