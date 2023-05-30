package enums;

public enum BrowserType {

    CHROME,
    FIREFOX,
    EDGE;

    public String getBrowserValue() {

        switch(this) {
          case CHROME:
            return "chrome";
    
          case FIREFOX:
            return "firefox";
    
          case EDGE:
            return "edge";
          default:
            return null;
          }
       }
    
}
