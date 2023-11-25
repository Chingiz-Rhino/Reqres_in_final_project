package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:auth.properties")
public interface AuthorizationConfig extends Config{
    @Key("AUTH_EMAIL")
    String authEmail();

    @Key("AUTH_PASSWORD")
    String authPassword();

    @Key("AUTH_UNDEFINED_EMAIL")
    String authUndefinedEmail();

    @Key("AUTH_UNDEFINED_PASSWORD")
    String authUndefinedPassword();
}
