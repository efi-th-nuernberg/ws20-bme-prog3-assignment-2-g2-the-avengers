import java.util.*;

class TextFormatter {

  int lineLength;
  
  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    System.out.println("");
        System.out.println("Linksbündig:");
        System.out.println("");
        formatter.formatLeft(text);
        System.out.println("");
        System.out.println("Rechtsbündig:");
        System.out.println("");
        formatter.formatRight(text);
    
    
  }

  public TextFormatter(int lineLength) {
    this.lineLength = lineLength;
  }


  public void formatLeft(String text) {

		String currentLine = "";
    List<String> words = tokenize(text);
    
    // print each line
		for(int i =0; i < words.size(); i++)
      {
		    if (currentLine.length() + words.get(i).length() < lineLength) 
        {
				currentLine += words.get(i) + " ";
        } 
        else {
        System.out.println(currentLine);
				currentLine = words.get(i) + " ";
        }
		}
    //print last line
    System.out.println(currentLine); 
	}


  public void formatRight(String text) {
		String currentLine = "";
    List<String> words = tokenize(text);
    
		for(int count =0; count < words.size(); count++)
      {
		    if (currentLine.length() + words.get(count).length() < 30) 
        {
			currentLine += words.get(count) + " ";
        } 
        else {
          addSpaces(currentLine);
        currentLine = words.get(count) + " ";
        }
		}
    addSpaces(currentLine); 
	}

  private List<String>  tokenize(String text){

  StringTokenizer toki = new StringTokenizer(text, " ");
  List<String> words = new ArrayList<String>();

		while (toki.hasMoreTokens()) {
      words.add(toki.nextToken());
    }


return words;
  }
  private void addSpaces(String line){
    int diff = lineLength - line.length();
    int counter = 0;
          while (counter != diff) 
          {
            line = " " + line;
            counter++;
          }
        System.out.println(line);	
  }
}
