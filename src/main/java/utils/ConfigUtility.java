package utils;

public class ConfigUtility {
    public static final String IOS_PLATFORM = "iOS";
    public static final String ANDROID_PLATFORM = "Android";

    private static final class Holder {
        public static final ConfigUtility INSTANCE = new ConfigUtility();
    }

    public static ConfigUtility getInstance() {
        return Holder.INSTANCE;
    }


    public boolean isIOSPlatform() {
        return true;
    }
}
