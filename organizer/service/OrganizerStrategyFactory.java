package organizer.service;

import organizer.core.OrganizerMode;

public class OrganizerStrategyFactory {
  public static OrganizerStrategy getStrategy(OrganizerMode mode) {
    
    return switch(mode){
      case EXTENSION->new ExtensionOrganizer();
      case SIZE -> new SizeOrganizer();
    };

  }
}
