package ad.sogeti.filmlandservice.utils;

public class FilmLandConstants {

    public static final String FILMLAND_TITLE = "Filmland service REST API";
    public static final String FILMLAND_VERSION = "0.0.1-SNAPSHOT";

    public static final String DELETE_SUBSCRIBED_CATEGORY = "delete from Available_Categories where email = :email AND name = :name";
    public static final String FIND_SUBSCRIBED_CATEGORY = "Select sc from Subscribed_Categories sc where sc.email = :email AND sc.name = :name";

    public static final String EMAIL = "email";
    public static final String NAME = "name";

    public static final String CUSTOMER_BASE_URL = "filmland/api/v1/customer";

    public static final String SUBSCRIPTION_BASE_URL = "filmland/api/v1/subscription";
    public static final String SUBSCRIBE_ENDPOINT = "/subscribe";
    public static final String SHARE_SUBSCRIBE_ENDPOINT = "/shareSubscription";

    public static final String USER_BASE_URL = "filmland/api/v1/user";
    public static final String LOGIN_ENDPOINT = "/login";
    public static final String ADD_ENDPOINT = "/add";
}
