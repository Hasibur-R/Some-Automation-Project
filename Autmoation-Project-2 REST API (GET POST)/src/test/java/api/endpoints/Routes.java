package api.endpoints;

import config.EnvironmentConfig;

public class Routes {
    public static String base_url = EnvironmentConfig.getUrl("url");

    //post module
    public static String postsUrl = base_url + "/posts"; //post
    public static String rud_postsUrl = base_url + "/posts/{Id}"; //read, updated and delete

    //users module
    public static String usersUrl = base_url + "/users";
    public static String rud_usersUrl = base_url + "/users/{Id}";
}
