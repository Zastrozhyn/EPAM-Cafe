package by.zastr.cafe.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class Message Manager.
 *
 * @author A.Zastrozhyn
 */
public class MessageManager {
	private static final String MESSAGE_PATH = "message";
    
    /** The Constant RUSSIAN_LOCALE. */
    public static final String RUSSIAN_LOCALE = "ru_RU";
    
    /** The Constant ENGLISH_LOCALE. */
    public static final String ENGLISH_LOCALE = "en_US";
    
    /** The Constant ENGLISH_LANGUAGE. */
    public static final String ENGLISH_LANGUAGE = "en";
    
    /** The Constant US. */
    public static final String US = "US";
    
    /** The Constant RUSSIAN_LANGUAGE. */
    public static final String RUSSIAN_LANGUAGE = "ru";
    
    /** The Constant RUSSIA. */
    public static final String RUSSIA = "RU";
    
    private final ResourceBundle resourceBundle;

    private MessageManager(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Gets message.
     *
     * @param key the key
     * @return the message
     */
    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }

    /**
     * Define locale message manager.
     *
     * @param locale the locale
     * @return the message manager
     */
    public static MessageManager defineLocale(String locale) {
        MessageManager messageManager = null;
        if (locale == null) {
            messageManager = new MessageManager(ResourceBundle.getBundle(MESSAGE_PATH, new Locale(RUSSIAN_LOCALE)));
        } else {
            switch (locale) {
            case ENGLISH_LOCALE:
                messageManager = new MessageManager(ResourceBundle.getBundle(MESSAGE_PATH,
                        new Locale(ENGLISH_LANGUAGE, US)));
                break;
            case RUSSIAN_LOCALE:
                messageManager = new MessageManager(ResourceBundle.getBundle(MESSAGE_PATH,
                        new Locale(RUSSIAN_LANGUAGE, RUSSIA)));
            }
        }
        return messageManager;
    }
}