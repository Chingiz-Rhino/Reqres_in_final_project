package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:registration.properties")
public interface RegistrationConfig extends Config{
    @Key("REG_EMAIL")
    String regEmail();

    @Key("REG_PASSWORD")
    String regPassword();

    @Key("REG_UNDEFINED_EMAIL")
    String regUndefinedEmail();

    @Key("REG_UNDEFINED_PASSWORD")
    String regUndefinedPassword();
}
