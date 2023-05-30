package enums;

public enum ActionType {

    MOVETOELEMENT,
    SCROLLTOELEMENT;

    public String getActionType() {

        switch(this) {
          
          case MOVETOELEMENT:
            return "moveToElement";
    
          case SCROLLTOELEMENT:
            return "scrollToElement";
          default:
            return null;
          }
       }
    
}
